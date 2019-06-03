package se.rosa.dao;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import se.rosa.domain.Account;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

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

	@Override
	public Account searchAccountByName(String name) {
		return accounts.values().stream()
				.filter(account ->  account.getName().equalsIgnoreCase(name))
				.findAny()
				.map(account -> account)
				.orElseThrow(IllegalArgumentException::new);
	}
}
