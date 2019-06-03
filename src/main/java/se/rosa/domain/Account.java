package se.rosa.domain;

public class Account {

	private Long id;
	private Double balance;
	private String name;

	private Account(Long id, Double balance, String name) {
		this.id = id;
		this.balance = balance;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public Double getBalance() {
		return balance;
	}

	public String getName() {
		return name;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		private Long id;
		private Double balance;
		private String name;

		public Builder withId(Long id) {
			this.id = id;
			return this;
		}

		public Builder withBalance(Double balance) {
			this.balance = balance;
			return this;
		}

		public Builder withName(String name) {
			this.name = name;
			return this;
		}

		public Account build() {
			return new Account(id, balance, name);
		}
	}

}
