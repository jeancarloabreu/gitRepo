package main.java.com.jca.creditcardmanager;

import java.text.ParseException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CreditCardManager {

	private static List<CreditCard> creditCardList;

	public final static Comparator<CreditCard> CreditCardExpDateDescComparator = new Comparator<CreditCard>() {

		@Override
		public int compare(CreditCard o1, CreditCard o2) {
			return o1.getExpireDate().compareTo(o2.getExpireDate());
		}
		
	};

	
	public static void main(String[] args) throws ParseException {
		CreditCardManager ccm = new CreditCardManager();
		ccm.getCreditCardsExpDateDesc();
	}
	
	public List<CreditCard> getCreditCardsExpDateDesc() throws ParseException {
		//Get the Credit Card
		creditCardList = new CreditCardDaoImpl().getAllCreditCards();
		
		//Sort the Credit Card list descending by Expire Date
		Collections.sort(creditCardList,CreditCardExpDateDescComparator);
		
		//Show the results
		for(CreditCard cc: creditCardList){
			System.out.println(cc.toString());

		}
		return creditCardList;
	}

}