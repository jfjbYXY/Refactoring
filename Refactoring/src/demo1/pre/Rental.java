package demo1.pre;

/**
 * 实体类-租赁
 * 
 * @author yxy
 *
 */
public class Rental {
	private Movie _movie;
	private int _daysRented;

	public Rental(Movie movie, int daysRented) {
		super();
		_movie = movie;
		_daysRented = daysRented;
	}

	public Movie get_movie() {
		return _movie;
	}

	public int get_daysRented() {
		return _daysRented;
	}

}
