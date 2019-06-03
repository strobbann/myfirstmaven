package se.rosa.domain;

public class Account {

	private Long id;
	private Double balance;

	private Account(Long id, Double balance) {
		this.id = id;
		this.balance = balance;
	}

	public Long getId() {
		return id;
	}

	public Double getBalance() {
		return balance;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		private Long id;
		private Double balance;

		public Builder withId(Long id) {
			this.id = id;
			return this;
		}

		public Builder withBalance(Double balance) {
			this.balance = balance;
			return this;
		}

		public Account build() {
			return new Account(id, balance);
		}
	}

}
