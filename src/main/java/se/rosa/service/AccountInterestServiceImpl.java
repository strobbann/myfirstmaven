package se.rosa.service;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import se.rosa.dao.AccountDao;
import se.rosa.domain.Account;

import java.util.Objects;
import java.util.Optional;

public class AccountInterestServiceImpl implements AccountInterestService {

	private AccountDao accountDao;

	public AccountInterestServiceImpl(AccountDao accountDao) {
		this.accountDao = Objects.requireNonNull(accountDao, "accountDao cannot be null");
	}

	@Override
	public Double calculateInterest(Long id, int year, final double interest) {
		Optional<Account> accountOptional = Optional.of(accountDao.get(id));
		if(accountOptional.isPresent()) {
			return calculatedInterestValue(accountOptional.get().getBalance(), year,interest);
		}
		return 0.0D;
	}

	public double calculatedInterestValue(double amount, int year, double interest) {
		return amount * Math.pow(interest, year);
	}
}
