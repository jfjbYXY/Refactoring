package demo1.after;

import java.util.Enumeration;
import java.util.Vector;

/**
 * 实体类-顾客
 * 
 * @author yxy
 *
 */
public class Customer {
	private String _name;
	private Vector _rentals = new Vector();

	public Customer(String name) {
		_name = name;
	}

	public String get_name() {
		return _name;
	}

	public void addRental(Rental rental) {
		_rentals.addElement(rental);
	}

	public String statement() {
		/****/
		double totalAmount = 0;
		/****/
		int frequntRenterPoints = 0;
		Enumeration rentals = _rentals.elements();
		String result = "Rental Record for " + get_name() + "\n";
		while (rentals.hasMoreElements()) {
			double thisAmount = 0;// 本片费用
			Rental each = (Rental) rentals.nextElement();

			thisAmount = amountFor(each);

			// add frequent renter points
			frequntRenterPoints++;
			// add bonus for a two day new release rental
			if ((each.get_movie().get_priceCode() == Movie.NEW_RELEASE) && each.get_daysRented() > 1)
				frequntRenterPoints++;

			// show figures for this rental
			result += "\t" + each.get_movie().get_title() + "\t" + String.valueOf(thisAmount) + "\n";
			totalAmount += thisAmount;
		}

		// add footer lines
		result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequntRenterPoints) + " frequent renter Points";
		return result;
	}

	/**
	 * 1.使用shift+alt+M提取方法；改变返回变量为方法内的局部变量<br>
	 * 2.改参数名aRental\result，便于理解
	 * 
	 * @param aRental
	 * @return
	 */
	private double amountFor(Rental aRental) {
		int result = 0;
		// determine amounts for each line
		switch (aRental.get_movie().get_priceCode()) {
		case Movie.REGULAR:
			result += 2;
			if (aRental.get_daysRented() > 2)
				result += (aRental.get_daysRented() - 2) * 1.5;
			break;
		case Movie.NEW_RELEASE:
			result += aRental.get_daysRented() * 3;
			break;
		case Movie.CHILDRENS:
			result += 1.5;
			if (aRental.get_daysRented() > 3)
				result += (aRental.get_daysRented() - 3) * 1.5;
			break;
		}
		return result;
	}
}
