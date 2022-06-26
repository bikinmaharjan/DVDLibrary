package com.wiley.dvdlibrary.ui;

import java.util.Date;
import java.util.List;

import com.wiley.dvdlibrary.dto.DVD;

public class DVDLibraryView {
	private UserIO io;
	
	public DVDLibraryView(UserIO io) {
		this.io = io;
	}
	
	public int printMenuAndGetSelection() {
		io.print("Main Menu");
		io.print("1. List all the DVD");
		io.print("2. Add DVD to the Collection");
		io.print("3. Display the info for a particular DVD (Search by Title)");
		io.print("4. Edit a DVD from the Collection");
		io.print("5. Remove a DVD from the Collection");
		io.print("6. Exit");
		
		return io.readInt("Please select from the above choices." , 1 ,6);

	}
	public void displayDisplayAllBanner() {
		io.print("==== Display All DVD ====");
	}
	public void displayDVDList(List<DVD> dvdList) {
		for(DVD dvd : dvdList) {
			String DVDinfo = String.format("#%s", 
					dvd.getTitle()
					);
			io.print(DVDinfo);
		}
		io.readString("Please hit enter to continue. ");
	}
	public void displayCreateDVDBanner() {
		io.print("==== Add DVD to Collection ====");
	}
	public DVD createNewDVD() {
		String title = io.readString("Please enter title");
		String releaseDate = io.readString("Please enter release date");
		String rating = io.readString("Please enter MPAA rating");
		String directorName = io.readString("Please enter Director's name");
		String studio= io.readString("Please enter Studio name");
		String userRating = io.readString("Please enter your note");
		DVD currentDVD = new DVD(title,releaseDate,rating,directorName,studio,userRating);
		return currentDVD;
	}
	public void displayCreateSuccessBanner() {
		io.readString("DVD added to the Collection. Please hit enter to continue.");
	}
	public void displayRemoveDVDBanner() {
		io.print("==== Remove DVD from Collection ====");
	}
	public void displayRemoveresult(DVD dvd) {
		if(dvd != null) {
			io.print("DVD successfully removed from collection");
		}else {
			io.print("No such DVD in the collection");
		}
		io.readString("<< Please hit enter to continue. >>");
	}
	public void displayEditDVDBanner() {
		io.print("==== Edit DVD from Collection ====");
	}
	public DVD editDVD(String title) {
		String releaseDate = io.readString("Please enter release date");
		String rating = io.readString("Please enter MPAA rating");
		String directorName = io.readString("Please enter Director's name");
		String studio= io.readString("Please enter Studio name");
		String userRating = io.readString("Please enter your note");
		DVD currentDVD = new DVD(title,releaseDate,rating,directorName,studio,userRating);
		return currentDVD;
	}
	public void displayEditresult(DVD dvd) {
		if(dvd != null) {
			io.print("DVD successfully edited from collection");
		}else {
			io.print("No such DVD in the collection");
		}
		io.readString("<< Please hit enter to continue. >>");
	}
	public void displayEditSuccessBanner() {
		io.readString("DVD edited. Please hit enter to continue.");
	}
	public String getDVDTitleChoice() {
		return io.readString("PLease enter the title of the DVD. ");
	}
	public void displayDisplayDVDBanner() {
		io.print("==== Display info of DVD by Title ====");
	}
	public void displayDVD(DVD dvd) {
		if (dvd != null) {
			io.print("----------------------------");
			io.print("Title: " + dvd.getTitle());
			io.print("Released on: " + dvd.getReleaseDate());
			io.print("Directed by: " + dvd.getDirectorName());
			io.print("Studio: " + dvd.getStudio());
			io.print("----------------------------");
			io.print("Rating:" + dvd.getRating());
			io.print("User review: " + dvd.getUserRating());
			io.print("----------------------------");
		}
		else {
			io.print("No DVD with that tile in the collection");
		}
	}
	public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }
    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }
	
}
