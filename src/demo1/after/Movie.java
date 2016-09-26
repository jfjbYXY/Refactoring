package demo1.after;

import demo1.after.strategy.ChildrenspPrice;
import demo1.after.strategy.NewReleasePrice;
import demo1.after.strategy.Price;
import demo1.after.strategy.RegularPrice;

/**
 * 实体类-影片
 * 
 * @author yxy
 *
 */
public class Movie {
	public static final int CHILDRENS = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;

	private String _title;
	private int _priceCode;
	/** 使用策略模式-用来代替原来的变量_priceCode **/
	private Price _price;

	public Movie(String title, int priceCode) {
		super();
		_title = title;
		// _priceCode = priceCode;
		set_priceCode(priceCode);
	}

	public String get_title() {
		return _title;
	}

	public int get_priceCode() {
		// return _priceCode;
		return _price.getPriceCode();
	}

	public void set_priceCode(int priceCode) {
		// _priceCode = priceCode;
		switch (priceCode) {
		case REGULAR:
			_price = new RegularPrice();
			break;
		case CHILDRENS:
			_price = new ChildrenspPrice();
			break;
		case NEW_RELEASE:
			_price = new NewReleasePrice();
			break;
		default:
			throw new IllegalArgumentException("Incorrect Price Code");
		}
	}

	/**
	 * @param daysRented
	 *            租賃天數
	 * @return 由租赁时间计算本片的租赁费用
	 */
	double getCharge(int daysRented) {
		// double result = 0;
		// // determine amounts for each line
		// switch (get_priceCode()) {
		// case Movie.REGULAR:
		// result += 2;
		// if (daysRented > 2)
		// result += (daysRented - 2) * 1.5;
		// break;
		// case Movie.NEW_RELEASE:
		// result += daysRented * 3;
		// break;
		// case Movie.CHILDRENS:
		// result += 1.5;
		// if (daysRented > 3)
		// result += (daysRented - 3) * 1.5;
		// break;
		// }
		// return result;
		// 使用策略模式后替换掉了以上代码
		return _price.getCharge(daysRented);
	}

	/**
	 * @param daysRented
	 *            租赁天数
	 * @return 本片租賃獲得的積分
	 */
	int getFrequentRenterPoints(int daysRented) {
		if ((get_priceCode() == Movie.NEW_RELEASE) && daysRented > 1)
			return 2;
		else
			return 1;
	}
}
