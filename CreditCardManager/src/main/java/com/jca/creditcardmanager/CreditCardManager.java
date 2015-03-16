package main.java.com.jca.creditcardmanager;

import java.text.ParseException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import main.java.com.jca.creditcardmanager.util.Utils;

public class CreditCardManager {

	private static List<CreditCard> creditCardList;
	public static final String CSV_FILE_PATH = "resources/mid-test.csv";

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
		creditCardList = Utils.readCCsFromFile(CSV_FILE_PATH);
		
		//Sort the Credit Card list descending by Expire Date
		Collections.sort(creditCardList,CreditCardExpDateDescComparator);
		
		//Show the results
		for(CreditCard cc: creditCardList){
			System.out.println(cc.toString());

		}
		return creditCardList;
	}

}