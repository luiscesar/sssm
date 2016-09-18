package sssm.market.price;

public class Price {

	static private String defaultCurrency = "GBP";
	
	private Double amount;
	private String currency;
	
	public Price() {
		this.amount = new Double(0.0);
		this.currency = defaultCurrency;
	}
	
	public Price(Double amount) {
		this.amount = amount;
		this.currency = defaultCurrency;
	}

	public Price(Double amount, String currency) {
		this.amount = amount;
		this.currency = currency;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
}
