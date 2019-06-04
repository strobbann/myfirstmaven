package se.rosa.dao;

import se.rosa.domain.Account;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AccountDaoImpl implements AccountDao {

	private Map<Long, Account> accounts;

	public AccountDaoImpl() {
		this.accounts = new HashMap<>();
	}

	@Override
	public void create(Account account) {
		accountChecker(account, a -> {
			accounts.put(a.getId(),a);
			return a;
		});
	}

	@Override
	public Account get(Long id) {
		return Optional.of(accounts.get(id))
				.map(account -> account)
				.orElseThrow(()-> new IllegalArgumentException("Cannot find account with this id"));
	}

	@Override
	public void update(Account account) {
		Objects.requireNonNull(account,"Account to update cannot be null");
		if (accounts.containsKey(account.getId())) {
			accounts.put(account.getId(), account);
		}
	}

	@Override
	public void remove(Long id) {
		Objects.requireNonNull(id,"Id to remove cannot be null");
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


	public void accountChecker(Account account,Function<Account, Account> function) {
		Optional<Account> accountOptional = Optional.of(account);
		accountOptional.map(function).orElseThrow(() -> new IllegalArgumentException("Account does not exist"));
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
