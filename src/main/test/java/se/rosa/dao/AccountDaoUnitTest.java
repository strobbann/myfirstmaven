package se.rosa.dao;

import org.junit.Test;
import se.rosa.domain.Account;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class AccountDaoUnitTest {

	@Test
	public void create() {
		AccountDao accountDao = new AccountDaoImpl();
		Account account = Account.builder().withId(1L).withBalance(200D).build();
		accountDao.create(account);
		assertEquals(account, accountDao.get(1L));
	}

	@Test
	public void remove() {
		AccountDao accountDao = new AccountDaoImpl();
		Account account = Account.builder().withId(1L).withBalance(200d).build();
		accountDao.create(account);
		assertEquals(account, accountDao.get(1L));
		accountDao.remove(1L);
		assertNotEquals(account, accountDao.get(1L));
	}

}
