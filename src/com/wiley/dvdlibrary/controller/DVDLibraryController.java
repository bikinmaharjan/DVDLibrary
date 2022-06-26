package com.wiley.dvdlibrary.controller;

import java.util.List;

import com.wiley.dvdlibrary.dao.DVDLibraryDao;
import com.wiley.dvdlibrary.dto.DVD;
import com.wiley.dvdlibrary.exception.DVDLibraryDaoException;
import com.wiley.dvdlibrary.ui.DVDLibraryView;
import com.wiley.dvdlibrary.ui.UserIO;
import com.wiley.dvdlibrary.ui.UserIOImpl;

public class DVDLibraryController {
	private UserIO io = new UserIOImpl();

	private DVDLibraryView view;
	private DVDLibraryDao dao;

	public DVDLibraryController(DVDLibraryView view, DVDLibraryDao dao) {
		this.view = view;
		this.dao = dao;
	}

	public void run() {
		boolean keepGoing = true;
		int menuSelection = 0;
		try {
			while (keepGoing) {

				menuSelection = getMenuSelection();

				switch (menuSelection) {
				case 1:
					listDVDs();
					break;
				case 2:
					createDVD();
					break;
				case 3:
					viewDVD();
					break;
				case 4:
					editDVD();
					break;
				case 5:
					removeDVD();
					break;
				case 6:
					keepGoing = false;
					break;
				default:
					unknownCommand();
				}
			}
			exitMessage();
		} catch (Exception e) {
			view.displayErrorMessage(e.getMessage());
		}
	}

	private void editDVD() throws DVDLibraryDaoException {
		view.displayEditDVDBanner();
		String title = view.getDVDTitleChoice();
		DVD d = dao.getDVD(title);
		if (d != null) {
			DVD dvd = view.editDVD(title);
			dao.editDVD(title, dvd);
			view.displayEditresult(dvd);
		} else {
			System.out.println("No such DVD in the collection!!!");
			System.out.println("____________________________________");
		}

	}

	private int getMenuSelection() {
		return view.printMenuAndGetSelection();
	}

	private void createDVD() throws DVDLibraryDaoException {
		view.displayCreateDVDBanner();
		DVD dvd = view.createNewDVD();
		dao.addDVD(dvd.getTitle(), dvd);
		view.displayCreateSuccessBanner();
	}

	private void listDVDs() throws DVDLibraryDaoException {
		view.displayDisplayAllBanner();
		List<DVD> dvdList = dao.getAllDVDs();
		view.displayDVDList(dvdList);
	}

	private void viewDVD() throws DVDLibraryDaoException {
		view.displayDisplayDVDBanner();
		String title = view.getDVDTitleChoice();
		DVD dvd = dao.getDVD(title);
		view.displayDVD(dvd);
	}

	private void removeDVD() throws DVDLibraryDaoException {
		view.displayRemoveDVDBanner();
		String title = view.getDVDTitleChoice();
		DVD removedDVD = dao.removeDVD(title);
		view.displayRemoveresult(removedDVD);
	}

	private void unknownCommand() {
		view.displayUnknownCommandBanner();
	}

	private void exitMessage() {
		view.displayExitBanner();
	}

}
