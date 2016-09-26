package demo1.pre;

import static org.junit.Assert.*;

public class Test {

	@org.junit.Test
	public void test() {
		Customer customer = new Customer("yxy");
		Movie movie1 = new Movie("东京沉没", Movie.NEW_RELEASE);
		Movie movie2 = new Movie("米老鼠和唐老鸭", Movie.CHILDRENS);
		Movie movie3 = new Movie("葫芦娃", Movie.CHILDRENS);
		Movie movie4 = new Movie("建国大业", Movie.REGULAR);
		Rental rental1 = new Rental(movie1, 3);
		Rental rental2 = new Rental(movie2, 5);
		Rental rental3 = new Rental(movie3, 7);
		Rental rental4 = new Rental(movie4, 2);
		customer.addRental(rental1);
		customer.addRental(rental2);
		customer.addRental(rental3);
		customer.addRental(rental4);
		System.out.println(customer.statement());
	}

}
