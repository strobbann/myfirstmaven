package se.rosa.dao;

import se.rosa.domain.Account;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
		return searchGetAccount(account -> name.equalsIgnoreCase(account.getName()));
	}

	@Override
	public List<Account> searchAccountsOverBalance(Double balance) {
		return searchGetList(account -> account.getBalance() >= balance);
	}

	public List<Account> searchGetList(Predicate<Account> predicate) {
		return accounts.values().stream()
				.filter(predicate)
				.collect(Collectors.toList());
	}

	public Account searchGetAccount(Predicate<Account> predicate) {
		return accounts.values().stream()
				.filter(predicate)
				.findAny()
				.map(account -> account)
				.orElseThrow(() -> new IllegalArgumentException("Cannot find the desired account"));
	}

}
