package test.java.com.jca.creditcardmanager;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import junit.framework.Assert;
import main.java.com.jca.creditcardmanager.Bank;
import main.java.com.jca.creditcardmanager.CreditCard;

import org.junit.Before;
import org.junit.Test;

public class CreditCardTest {

	Bank bank;
	CreditCard cc1;
	CreditCard cc2;
	DateFormat df = new SimpleDateFormat("MMM-YYYY");

	@Before
	public void setUp() throws Exception {
		bank = new Bank("name1", "##xx-xxxx-xxxx-####");
		cc1 = new CreditCard(bank, "1234-5678-9012-1234", df.parse("Jan-2016"));
		cc2 = new CreditCard(bank, "0011-2233-4455-6677", df.parse("Jan-2017"));
	}

	@Test
	public void testCreditCard() throws ParseException {
		/*CreditCard cc = new CreditCard(bank, "1111-5678-9012-1234", df.parse("Jan-2016"));
		assertEquals(cc.getBankName(), "name1");
		assertEquals(cc.getNumber(), "1111-5678-9012-1234");*/
	}

	@Test
	public void testGetNumberMasked1() {
		assertEquals("12xx-xxxx-xxxx-1234",cc1.getNumberMasked());
	}

	@Test
	public void testGetNumberMasked2() {
		assertEquals("00xx-xxxx-xxxx-6677",cc2.getNumberMasked());
	}

	@Test
	public void testToString() {
		assertEquals(cc1.toString(),"CreditCard [bankName=name1, number=12xx-xxxx-xxxx-1234]");
	}

}
