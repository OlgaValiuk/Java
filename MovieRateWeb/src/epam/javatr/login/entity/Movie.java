package epam.javatr.login.entity;

import java.util.ArrayList;

public class Movie extends Entity{
	
	private int movieID;
	private String movieName;
	private String movieDesc;
	private int movieYear;
	private double movieRate;
	private ArrayList<Recall> movieRecalls;
	
	public Movie(int movieID, String movieName, String movieDesc, int movieYear, double movieRate) {
		super();
		this.movieID = movieID;
		this.movieName = movieName;
		this.movieDesc = movieDesc;
		this.movieYear = movieYear;
		this.movieRate = movieRate;
	}
	
	public Movie(int movieID, String movieName, String movieDesc, int movieYear, double movieRate,ArrayList<Recall> movieRecalls ) {
		super();
		this.movieID = movieID;
		this.movieName = movieName;
		this.movieDesc = movieDesc;
		this.movieYear = movieYear;
		this.movieRate = movieRate;
		this.movieRecalls=movieRecalls;
	}
	
	public int getMovieID() {
		return movieID;
	}
	public String getMovieName() {
		return movieName;
	}
	public String getMovieDesc() {
		return movieDesc;
	}
	public int getMovieYear() {
		return movieYear;
	}
	public double getMovieRate() {
		return movieRate;
	}
	public ArrayList<Recall> getMovieRecalls(){
		return movieRecalls;
	}
	@Override
	public String toString() {
		return "Movie [movieID=" + movieID + ", movieName=" + movieName + ", movieDesc=" + movieDesc + ", movieYear="
				+ movieYear + ", movieRate=" + movieRate + "]";
	}
}
