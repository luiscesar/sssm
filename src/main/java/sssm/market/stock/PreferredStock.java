package sssm.market.stock;

public class PreferredStock extends Stock {
	
	private Double fixedDividend;
	
	public PreferredStock() {
		super();
		this.type = StockType.PREFERRED;
	}

	public Double getFixedDividend() {
		return fixedDividend;
	}

	public void setFixedDividend(Double fixedDividend) {
		this.fixedDividend = fixedDividend;
	}

	public Double getDividend() throws StockException {
		Double dividend = null;
		
		try {
			dividend = (this.fixedDividend / 100) * this.getParValue();
		} catch (RuntimeException rue) {
			throw new StockException(rue.getMessage());
		}
		return dividend;
	}
	
}
