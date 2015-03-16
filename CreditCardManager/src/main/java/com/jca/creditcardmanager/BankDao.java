package main.java.com.jca.creditcardmanager;

import java.util.List;

public interface BankDao {
	
	public List<Bank> getAllBanks();
	public Bank getBank(String bankName);

}
