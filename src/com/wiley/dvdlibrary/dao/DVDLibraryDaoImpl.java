package com.wiley.dvdlibrary.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.wiley.dvdlibrary.dto.DVD;
import com.wiley.dvdlibrary.exception.DVDLibraryDaoException;

public class DVDLibraryDaoImpl implements DVDLibraryDao {
	private Map<String, DVD> dvds = new HashMap<>();
	public static final String DVD_COLLECTION = "dvdcollection.txt";
	public static final String DELIMITER = "::";
	

	@Override
	public DVD addDVD(String title, DVD dvd) throws DVDLibraryDaoException {
		loadCollection();
		DVD newDVD = dvds.put(title, dvd);
		writeDVD();
		return newDVD;
	}

	@Override
	public List<DVD> getAllDVDs() throws DVDLibraryDaoException {
		loadCollection();
		return new ArrayList(dvds.values());
	}

	@Override
	public DVD getDVD(String title) throws DVDLibraryDaoException {
		loadCollection();
		return dvds.get(title);
	}

	@Override
	public DVD removeDVD(String title) throws DVDLibraryDaoException {
		loadCollection();
		DVD removedDVD = dvds.remove(title);
		writeDVD();
		return removedDVD;
	}
	
	@Override
	public DVD editDVD(String title, DVD dvd) throws DVDLibraryDaoException {
		loadCollection();
		DVD editedDVD = dvds.put(title, dvd);
		writeDVD();
		return editedDVD;
	}
	
	private void loadCollection() throws DVDLibraryDaoException {
		Scanner scanner;
		
		try {
			scanner = new Scanner(
	                new BufferedReader(
	                        new FileReader(DVD_COLLECTION)));
		} catch (FileNotFoundException e) {
			throw new DVDLibraryDaoException("Could not load collection into memory", e);
		}
		String currentLine;
		DVD currentDVD;
		
		while(scanner.hasNextLine()) {
			currentLine = scanner.nextLine();
			currentDVD = unmarshallDVD(currentLine);
			dvds.put(currentDVD.getTitle(), currentDVD);
		}
		scanner.close();
	}

	private DVD unmarshallDVD(String currentLine) {
		String[] sp = currentLine.split(DELIMITER);
		DVD dvdFromFile = new DVD(sp[0], sp[1], sp[2], sp[3], sp[4], sp[5]);
		return dvdFromFile;
	}
	
	private String marshallDVD(DVD d) {
		String dvdAsText = d.getTitle() + DELIMITER + d.getReleaseDate() + DELIMITER +
				d.getRating() + DELIMITER + d.getDirectorName() + DELIMITER + d.getStudio() +
				DELIMITER + d.getUserRating();
		return dvdAsText;	
	}
	
	private void writeDVD() throws DVDLibraryDaoException{
		PrintWriter out;
		
		try { 
			out = new PrintWriter(new FileWriter(DVD_COLLECTION));
		} catch (IOException e) {
	        throw new DVDLibraryDaoException(
	                "Could not save dvd collection.", e);
	    }
		
		String dvdAsText;
		List<DVD> dvdList = this.getAllDVDs();
		for (DVD currentDvd: dvdList) {
			dvdAsText = marshallDVD(currentDvd);
			out.println(dvdAsText);
			out.flush();
		}
		out.close();
	}

}
