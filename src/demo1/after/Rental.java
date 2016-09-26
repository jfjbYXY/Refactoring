package demo1.after;

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

	/**
	 * 1.使用shift+alt+M提取方法；改变返回变量为方法内的局部变量<br>
	 * 2.改参数名aRental\result，便于理解<br>
	 * 3.此方法应该放属于Rental类
	 * 
	 * @param aRental
	 * @return
	 */
	double getCharge() {
		double result = 0;
		// determine amounts for each line
		switch (get_movie().get_priceCode()) {
		case Movie.REGULAR:
			result += 2;
			if (get_daysRented() > 2)
				result += (get_daysRented() - 2) * 1.5;
			break;
		case Movie.NEW_RELEASE:
			result += get_daysRented() * 3;
			break;
		case Movie.CHILDRENS:
			result += 1.5;
			if (get_daysRented() > 3)
				result += (get_daysRented() - 3) * 1.5;
			break;
		}
		return result;
	}
}
