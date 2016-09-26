package demo1.pre;

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

			// determine amounts for each line
			switch (each.get_movie().get_priceCode()) {
			case Movie.REGULAR:
				thisAmount += 2;
				if (each.get_daysRented() > 2)
					thisAmount += (each.get_daysRented() - 2) * 1.5;
				break;
			case Movie.NEW_RELEASE:
				thisAmount += each.get_daysRented() * 3;
				break;
			case Movie.CHILDRENS:
				thisAmount += 1.5;
				if (each.get_daysRented() > 3)
					thisAmount += (each.get_daysRented() - 3) * 1.5;
				break;
			}

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
}
