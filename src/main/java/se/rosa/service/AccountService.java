package se.rosa.service;

public interface AccountService {

	Double getBalance(Long id);

	void withdraw(Long id, Double toWithdraw);
}
