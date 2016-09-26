package demo1.after.strategy;

import demo1.pre.Movie;

public class NewReleasePrice extends Price {

	@Override
	public int getPriceCode() {
		// TODO Auto-generated method stub
		return Movie.NEW_RELEASE;
	}

	@Override
	public double getCharge(int daysRented) {
		return daysRented * 3;
	}

	public int getFrequentRenterPoints(int daysRented) {
		return (daysRented > 1) ? 2 : 1;
	}
}
