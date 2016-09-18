package sssm.market;


import java.util.Map;

import sssm.market.price.Price;
import sssm.market.stock.Stock;
import sssm.market.stock.StockException;
import sssm.market.trade.Trade;

public class SuperSimpleStockMarket implements MarketService {

	protected Map<String, Stock> allStocks = null;
	
	public SuperSimpleStockMarket() {
	}

	
	public Double calculateGBCEIndex() throws MarketException {
		Double result = null;
		
		try {
			result = 1.0;
			for (Stock stock: allStocks.values()) {
				result *= stock.getPrice().getAmount();
			}
			double p = (double) 1/allStocks.size();
			result = Math.pow(result, p); 
		} catch (RuntimeException rue) {
			throw new MarketException(rue.getMessage());
		} 
		
		return result;
	}

	public Double calculateDividendYield(String stockSymbol, Price price) 
			throws MarketException {
		Double result = new Double(0);
		
		try {
			result = this.allStocks.get(stockSymbol).getDividendYield(price);
		} catch (RuntimeException rue) {
			throw new MarketException(rue.getMessage());
		} catch (StockException se) {
			throw new MarketException(se.getMessage());
		}
		
		return result;
	}

	public Double calculatePERatio(String stockSymbol, Price price) 
			throws MarketException {
		Double result = new Double(0);
		
		try {
			result = this.allStocks.get(stockSymbol).getPERatio(price);
		} catch (RuntimeException rue) {
			throw new MarketException(rue.getMessage());
		} catch (StockException se) {
			throw new MarketException(se.getMessage());
		}
		
		return result;
	}

	public void recordTrade(Trade trade) throws MarketException {
		String stockSymbol = null;
		try {
			stockSymbol = trade.getStockSymbol();
			this.allStocks.get(stockSymbol).recordTrade(trade);
		} catch (RuntimeException rue) {
			throw new MarketException(rue.getMessage());
		} catch (StockException se) {
			throw new MarketException(se.getMessage());
		}
	}

	public Double calculateVolumeWeightedStockPrice(String stockSymbol) throws MarketException {
		Double result = new Double(0);
		
		try {
			result = this.allStocks.get(stockSymbol).getVolumeWeightedStockPrice();
		} catch (RuntimeException rue) {
			throw new MarketException(rue.getMessage());
		} catch (StockException se) {
			throw new MarketException(se.getMessage());
		}
		
		return result;
	}

	public Stock getStock(String stockSymbol) throws MarketException {
		Stock stock = null;
		try {
			stock = this.allStocks.get(stockSymbol);
		} catch (RuntimeException rue) {
			throw new MarketException(rue.getMessage());
		}
		return stock;
	} 
}
