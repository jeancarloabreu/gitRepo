package main.java.com.jca.creditcardmanager;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class CreditCardDaoImpl implements CreditCardDao {

	public static final String CSV_FILE_PATH = "resources/mid-test.csv";

	List<CreditCard> creditCards;
	
	public CreditCardDaoImpl() {
		creditCards = new ArrayList<CreditCard>();
	}	

	@Override
	public List<CreditCard> getAllCreditCards() throws ParseException {
			List<CreditCard> creditCards = new ArrayList<CreditCard>();
			BufferedReader br = null;
			String line = "";
			String cvsSplitBy = ",";
			
			BankDao bankDao = new BankDaoImpl();
			
			bankDao.getAllBanks();
			
			try {
				 
				br = new BufferedReader(new FileReader(CSV_FILE_PATH));
				while ((line = br.readLine()) != null) {
		 
				        // use comma as separator
					String[] lineTokens = line.split(cvsSplitBy);
					
					DateFormat sdf = new SimpleDateFormat("MMM-yyyy");
					
					CreditCard cc = new CreditCard(bankDao.getBank(lineTokens[0]), lineTokens[1], sdf.parse(lineTokens[2]));
					creditCards.add(cc);
		 
				}
		 
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (br != null) {
					try {
						br.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		 
			return creditCards;
		}


}
