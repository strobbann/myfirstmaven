package se.rosa.service;

import se.rosa.dao.AccountDao;
import se.rosa.domain.Account;

import java.util.Objects;
import java.util.Optional;

public class AccountServiceImpl implements AccountService {

	private AccountDao accountDao;

	private static AccountServiceImpl accountService;

	private AccountServiceImpl(AccountDao accountDao) {
		this.accountDao = Objects.requireNonNull(accountDao, "accountDao cannot be null");
	}

	public static synchronized AccountServiceImpl getInstance(AccountDao accountDao) {
		if(accountService == null) {
			return accountService = new AccountServiceImpl(accountDao);
		} else {
			return accountService;
		}

	}

	@Override
	public Double getBalance(Long id) {
		Account account = accountDao.get(id);
		if (account != null) {
			return account.getBalance();
		}
		return -1D;
	}

	@Override
	public void withdraw(Long id, Double toWithdraw) {
		Account account = accountDao.get(id);
		if (isBalanceValid(account, toWithdraw)) {
			Double balance = account.getBalance();
			balance -= toWithdraw;
			accountDao.update(Account.builder().withId(account.getId()).withBalance(balance).build());
		} else {
			throw new IllegalArgumentException("You cannot withdraw over you're balance");
		}


	}

	public boolean isBalanceValid(Account account, Double toWithdraw) {
		return toWithdraw >= account.getBalance();
	}
}
