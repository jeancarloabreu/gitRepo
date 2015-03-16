package test.java.com.jca.creditcardmanager;

import static org.junit.Assert.*;

import java.util.List;

import main.java.com.jca.creditcardmanager.CreditCard;
import main.java.com.jca.creditcardmanager.CreditCardManager;

import org.junit.Before;
import org.junit.Test;

public class CreditCardManagerTest {

	CreditCardManager ccm ;
	List<CreditCard> creditCards;

	@Before
	public void setUp() throws Exception {
		ccm = new CreditCardManager();
		creditCards = ccm.getCreditCardsExpDateDesc();
	}

	@Test
	public void whenGetCreditCardsExpDateDescValueIs3() {
		assertEquals(3,creditCards.size());
	}
	
	@Test
	public void whenGetCreditCardsExpDateDescNoCardIsNull() {
		for(CreditCard cc : creditCards){
			assertNotEquals(null,cc.getExpireDate());
			assertNotEquals(null,cc.getBankName());
			assertNotEquals(null,cc.getNumber());
			assertNotEquals(null,cc.getNumberMasked());
		}
	}


	public void testGetCreditCardsExpDateDescInOrder() {
		CreditCard cc1 = creditCards.get(0);
		for(CreditCard cc2 : creditCards){
			assertFalse(cc1.getExpireDate().after(cc2.getExpireDate()));
			cc1 = cc2;
		}
		
	}

}
