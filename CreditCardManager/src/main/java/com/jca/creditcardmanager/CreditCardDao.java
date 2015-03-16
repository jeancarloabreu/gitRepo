package main.java.com.jca.creditcardmanager;

import java.text.ParseException;
import java.util.List;

public interface CreditCardDao {

	public List<CreditCard> getAllCreditCards() throws ParseException;

}
