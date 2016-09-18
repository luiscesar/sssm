package sssm.market.stock;

public class CommonStock extends Stock {

	public CommonStock() {
		super();
		this.type = StockType.COMMON;
	}

	public Double getDividend() throws StockException {
		Double dividend = null;
		try {
			dividend = this.getLastDividend();
		} catch (RuntimeException rue) {
			throw new StockException(rue.getMessage());
		}
		return dividend;
	}
	
}
