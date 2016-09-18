package sssm.market.stock;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import sssm.market.price.Price;
import sssm.market.trade.Trade;

abstract public class Stock {
	
	static final long PRICE_TIME_LIMIT_MINUTES = 15;
				
	private String symbol;
	private Double lastDividend;
	private Double parValue;
	protected StockType type;
	
	private List<Trade> recordedTrades;
	private Price price;

	public Stock() {
		recordedTrades = new ArrayList<Trade>();
		price = new Price(0.0);
	}

	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public StockType getType() {
		return type;
	}
	public void setType(StockType type) {
		this.type = type;
	}
	
	public Double getLastDividend() {
		return lastDividend;
	}
	public void setLastDividend(Double lastDividend) {
		this.lastDividend = lastDividend;
	}
	public Double getParValue() {
		return parValue;
	}
	public void setParValue(Double parValue) {
		this.parValue = parValue;
	}
		
	public Price getPrice() {
		return price;
	}

	abstract public Double getDividend() throws StockException;

	public Double getDividendYield(Price price) throws StockException {
		Double result = null;
		
		if (price != null) {
			if (price.getAmount() != 0) {
				result = this.getDividend() / price.getAmount();
			} else {
				throw new StockException("Price amount is 0");
			}
		} else {
			throw new StockException("Price is NULL");
		}
		
		return result;
	}

	public Double getPERatio(Price price) throws StockException {
		Double result = null;
		
		if (price != null) {
			Double dividend = this.getDividend();
			if (dividend != 0) {
				result = price.getAmount() / dividend;
			} else {
				throw new StockException("Dividend is 0");
			}
		} else {
			throw new StockException("Price is NULL");
		}
		
		return result;
	} 

	synchronized public void recordTrade(Trade trade) throws StockException {
		if (trade != null) {
			this.recordedTrades.add(trade);
			this.price = trade.getPrice();
		} else {
			throw new StockException("Trade is NULL");
		}
	}
	
	public List<Trade> getTrades() throws StockException {
		return this.recordedTrades;
	}
	
	synchronized public Double getVolumeWeightedStockPrice() throws StockException {
		Double result = new Double(0);

		Timestamp now = new Timestamp(System.currentTimeMillis());
		Long accumulatedQuantities = new Long(0);
		
		for (Trade currentTrade: this.recordedTrades) {
			if (isWithinPriceTimeLimit(now, currentTrade.getTimestamp())) {
				result += currentTrade.getQuantityOfShares() * currentTrade.getPrice().getAmount();
				accumulatedQuantities += currentTrade.getQuantityOfShares();
			}
		}

		if (accumulatedQuantities != 0) {
			result = result / accumulatedQuantities;
		} 
		return result;
	}
	
	private boolean isWithinPriceTimeLimit(Timestamp present, Timestamp past) {
		boolean result = false;
		long timeDiff = 0;
		if (present.getTime() >= past.getTime()) {
			timeDiff = (present.getTime() - past.getTime());
			// 1 minute = 60 * 1000 milliseconds
			result = (timeDiff <= PRICE_TIME_LIMIT_MINUTES*60000) ? true : false;			
		}
		return result;
	}
	
} // class Stock
