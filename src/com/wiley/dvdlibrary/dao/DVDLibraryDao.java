package com.wiley.dvdlibrary.dao;

import java.util.List;

import com.wiley.dvdlibrary.dto.DVD;
import com.wiley.dvdlibrary.exception.DVDLibraryDaoException;

public interface DVDLibraryDao {
	List<DVD> getAllDVDs() throws DVDLibraryDaoException;
	DVD getDVD(String dvdId) throws DVDLibraryDaoException;
	DVD addDVD(String title, DVD dvd) throws DVDLibraryDaoException;
	DVD removeDVD(String title) throws DVDLibraryDaoException;
	DVD editDVD(String title, DVD dvd) throws DVDLibraryDaoException;
}
