package se.rosa.service;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import se.rosa.dao.AccountDao;
import se.rosa.dao.AccountDaoImpl;
import se.rosa.domain.Account;


import static org.junit.Assert.*;


public class AccountServiceUnitTest {

	private static AccountService accountService;
	private static AccountDao accountDao;
	private Long id = 0L;

	@BeforeClass
	public static void beforeClass() {
		accountDao = new AccountDaoImpl();
		accountService = AccountServiceImpl.getInstance(accountDao);
	}

	@Before
	public void before() {
		id++;
	}

	@Test
	public void getBalance() {
		accountDao.create(Account.builder().withId(id).withBalance(200D).withName("JUNIT").build());
		AccountService service = AccountServiceImpl.getInstance(accountDao);
		assertEquals(Double.valueOf(200D), service.getBalance(id));

	}

	@Test
	public void withdraw() {
		accountDao.create(Account.builder().withId(id).withBalance(200D).withName("JUNIT").build());
		accountService.withdraw(id, 200D);
		assertEquals(Double.valueOf(0D), accountService.getBalance(id));
	}

	@Test
	public void deposit() {
		accountDao.create(Account.builder().withId(id).withBalance(200.33333D).withName("JUNIT").build());
		accountService.deposit(id, 200);
		assertEquals(Double.valueOf(400.33333D), accountService.getBalance(id));
	}
}