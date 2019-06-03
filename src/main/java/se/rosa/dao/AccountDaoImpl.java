package se.rosa.dao;

import se.rosa.domain.Account;

import java.util.HashMap;
import java.util.Map;

public class AccountDaoImpl implements AccountDao {

	private Map<Long, Account> accounts = new HashMap<>();

	@Override
	public void create(Account account) {
		accounts.put(account.getId(), account);
	}

	@Override
	public Account get(Long id) {
		return accounts.get(id);
	}

	@Override
	public void update(Account account) {
		if (accounts.containsKey(account.getId())) {
			accounts.replace(account.getId(), account);
		}
	}

	@Override
	public void remove(Long id) {
		if(accounts.containsKey(id)) {
			accounts.remove(id);
		}
	}
}
