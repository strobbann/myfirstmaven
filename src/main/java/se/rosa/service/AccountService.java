package se.rosa.service;

public interface AccountService {

	Double getBalance(Long id);

	void withdraw(Long id, Double toWithdraw);

	void deposit(Long id, Integer amount);
}
