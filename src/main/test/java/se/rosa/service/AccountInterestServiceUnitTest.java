package se.rosa.service;

import org.junit.Assert;
import org.junit.Test;
import se.rosa.dao.AccountDao;
import se.rosa.dao.AccountDaoImpl;
import se.rosa.domain.Account;

import static org.junit.Assert.assertEquals;

/**
 * Created by Robert on 2019-05-30.
 */
public class AccountInterestServiceUnitTest {

	@Test
	public void calculateInterest() {
		AccountDao dao = new AccountDaoImpl();
		AccountInterestService service = new AccountInterestServiceImpl(dao);
		dao.create(Account.builder().withId(1L).withBalance(1000d).build());
		assertEquals(Double.valueOf(1040.4d), service.calculateInterest(1L,2,1.02));
	}
}
