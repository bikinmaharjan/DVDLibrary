package com.wiley.dvdlibrary.dto;

import java.util.Date;

public class DVD {
	private String title;
	private String releaseDate;
	private String rating;
	private String directorName;
	private String studio;
	private String userRating;

	public DVD() {
		
	}

	public DVD(String title, String releaseDate, String rating,
			String directorName, String studio, String userRating) {
		super();
		this.title = title;
		this.releaseDate = releaseDate;
		this.rating = rating;
		this.directorName = directorName;
		this.studio = studio;
		this.userRating = userRating;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getDirectorName() {
		return directorName;
	}

	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}

	public String getStudio() {
		return studio;
	}

	public void setStudio(String studio) {
		this.studio = studio;
	}

	public String getUserRating() {
		return userRating;
	}

	public void setUserRating(String userRating) {
		this.userRating = userRating;
	}

	@Override
	public String toString() {
		return "DVD [title=" + title + ", releaseDate=" + releaseDate
				+ ", rating=" + rating + ", directorName=" + directorName
				+ ", Studio=" + studio + ", userRating=" + userRating + "]";
	}
	

	
}
