package se.rosa.dao;

import se.rosa.domain.Account;

import java.util.List;

public interface AccountDao {

	void create(Account account);

	Account get(Long id);

	void update(Account account);

	void remove(Long id);

	Account searchAccountByName(String name);
}
