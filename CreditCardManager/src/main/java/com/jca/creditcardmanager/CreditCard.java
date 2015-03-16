package main.java.com.jca.creditcardmanager;

import java.util.Date;

public class CreditCard implements Comparable<CreditCard> {
	
	Bank bank;
	String number;
	Date expireDate;
	
	public CreditCard(Bank bank, String number, Date expireDate){
		this.number = number;
		this.bank = bank;
		this.expireDate = expireDate;
	}
	
	public Bank getBankName() {
		return bank;
	}
	public void setBankName(Bank bank) {
		this.bank = bank;
	}
	
	public String getNumber() {
		return number;
	}

	public String getNumberMasked() {
		return maskNumber(number,bank.getCreditCardMask());
	}

	public void setNumber(String number) {
		this.number = number;
	}
	public Date getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	@Override
	public int compareTo(CreditCard o) {
		// TODO Auto-generated method stub
		return this.expireDate.compareTo(o.getExpireDate());
	}

	   /**
	   * @param number The number in plain format
	   * @param mask The  mask pattern. 
	   *    Use # to include the digit from the position. 
	   *    Use x to mask the digit at that position.
	   *    Any other char will be inserted.
	   *	
	   *	Taken from: http://www.javacodex.com/Strings/Mask-Account-Number
	   *
	   * @return The masked card number
	   */
	   public static String maskNumber(String number, String mask) {
	 
	      int index = 0;
	      StringBuilder masked = new StringBuilder();
	      for (int i = 0; i < mask.length(); i++) {
	         char c = mask.charAt(i);
	         if (c == '#') {
	            masked.append(number.charAt(index));
	            index++;
	         } else if (c == 'x') {
	        	 index++;
	        	 masked.append(c);
	         } else {
	        	 index++;
	        	 masked.append(c);
	         }
	      }
	      return masked.toString();
	   }

	
	@Override
	public String toString() {
		return "CreditCard [bankName=" + bank.getName() + ", number=" + getNumberMasked() + "]";
	}
	
	

}
