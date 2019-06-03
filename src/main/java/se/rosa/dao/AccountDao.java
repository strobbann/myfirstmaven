package se.rosa.dao;

import se.rosa.domain.Account;

public interface AccountDao {

	void create(Account account);

	Account get(Long id);

	void update(Account account);

	void remove(Long id);
}
