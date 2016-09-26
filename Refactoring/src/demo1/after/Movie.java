package demo1.after;

/**
 * 实体类-影片
 * @author yxy
 *
 */
public class Movie {
	public static final int CHILDRENS = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;

	private String _title;
	private int _priceCode;

	public Movie(String title, int priceCode) {
		super();
		_title = title;
		_priceCode = priceCode;
	}

	public String get_title() {
		return _title;
	}

	public int get_priceCode() {
		return _priceCode;
	}

	public void set_priceCode(int priceCode) {
		_priceCode = priceCode;
	}

}
