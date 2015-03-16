package main.java.com.jca.creditcardmanager;

public class Bank {

	private String name;
	private String creditCardMask;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCreditCardMask() {
		return creditCardMask;
	}
	public void setCreditCardMask(String creditCardMask) {
		this.creditCardMask = creditCardMask;
	}
	public Bank(String name, String creditCardMask) {
		super();
		this.name = name;
		this.creditCardMask = creditCardMask;
	}
}
