package main.java.com.jca.creditcardmanager;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

public class BankDaoImpl implements BankDao {

	List<Bank> banks;
	
	public BankDaoImpl() {
		banks = new ArrayList<Bank>();
	}

	@Override
	public List<Bank> getAllBanks() {
		Properties prop = new Properties();
		InputStream input = null;
	 
		try {
	 
			input = new FileInputStream("resources/banks.properties");
			
			prop.load(input);
			
			Enumeration en = prop.keys();
			while(en.hasMoreElements()){
				String bankName = (String)en.nextElement();
				Bank bank = new Bank(bankName, prop.getProperty(bankName));
				banks.add(bank);
			}
	 
		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
	 
		}
		return null;
	}

	@Override
	public Bank getBank(String bankName) {
		for(Bank bank: banks){
			if(bank.getName().equals(bankName)){
				return bank;
			}
		}
		return null;
	}

}
