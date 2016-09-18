package sssm.market;

import sssm.market.price.Price;
import sssm.market.stock.Stock;
import sssm.market.trade.Trade;

public interface MarketService {

	public Double calculateDividendYield(String stockSymbol, Price price) 
		throws MarketException;

	public Double calculatePERatio(String stockSymbol, Price price)
		throws MarketException;
	
	public void recordTrade(Trade trade) 
		throws MarketException;
	
	public Double calculateVolumeWeightedStockPrice(String stockSymbol)
		throws MarketException;
	
	public Double calculateGBCEIndex() throws MarketException;
	
	public Stock getStock(String stockSymbol) throws MarketException;
	
}
