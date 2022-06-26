package com.wiley.dvdlibrary;

import com.wiley.dvdlibrary.controller.DVDLibraryController;
import com.wiley.dvdlibrary.dao.DVDLibraryDao;
import com.wiley.dvdlibrary.dao.DVDLibraryDaoImpl;
import com.wiley.dvdlibrary.ui.DVDLibraryView;
import com.wiley.dvdlibrary.ui.UserIO;
import com.wiley.dvdlibrary.ui.UserIOImpl;

public class App {

	public static void main(String[] args) {
		UserIO io = new UserIOImpl();
		DVDLibraryView myView = new DVDLibraryView(io);
		DVDLibraryDao dao = new DVDLibraryDaoImpl();
		DVDLibraryController controller = new DVDLibraryController(myView, dao);
		controller.run();

	}

}
