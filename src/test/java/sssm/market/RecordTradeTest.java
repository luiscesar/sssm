package sssm.market;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import sssm.market.price.Price;
import sssm.market.stock.Stock;
import sssm.market.stock.StockException;
import sssm.market.trade.Trade;
import sssm.market.trade.TradeType;

public class RecordTradeTest {

	@Test
	public void testCase1() {
		// Init context
		MarketService marketService = null;
		SuperSimpleStockMarketServiceFactory marketFactory = null;
		List<Trade> trades = null;
		
		try {
			marketFactory = new SuperSimpleStockMarketServiceFactory();
			marketService = marketFactory.getInstance();
			trades = getTradesTestCase1();
			for (Trade trade: trades) {
				marketService.recordTrade(trade);
			}
			assertTrue("Trades no recorded properly", postconditionTestCase1(trades, marketService));
		} catch (RuntimeException rue) {
			fail(rue.getMessage());
		} catch (MarketException me) {
			fail(me.getMessage());
		} catch (StockException se) {
			fail(se.getMessage());
		}
	}

	private boolean postconditionTestCase1(List<Trade> trades, MarketService marketService) throws MarketException, StockException {
		boolean result = false;
		List<Trade> recordedTrades = null;
		try {
			recordedTrades = getRecordedTradesTestCase1(marketService);
			if (recordedTrades.size() == trades.size()) {
				boolean found = true;
				Iterator<Trade> it = trades.iterator();
				while (it.hasNext() && found) {
					Trade trade = it.next();
					found = false;
					for (Trade recordedTrade: recordedTrades) {
						if (recordedTrade.equals(trade)) {
							found = true;
							break;
						}
					}
				}
				result = (found) ? true : false;
			}			
		} catch (StockException e) {
		} catch (RuntimeException rue) {}
		
		return result;
	}

	private List<Trade> getRecordedTradesTestCase1(MarketService marketService) throws MarketException, StockException {
		List<Trade> recordedTrades = new ArrayList<Trade>();
		Stock stock = null;
		for (String stockSymbol: getStockSymbolListTestCase1()) {
			stock = marketService.getStock(stockSymbol);
			for (Trade trade: stock.getTrades()) {
				recordedTrades.add(trade);
			}
		}
		return recordedTrades;
	}

	private List<String> getStockSymbolListTestCase1() {
		List<String> stockSymbolListTestCase1 = new ArrayList<String>();
		stockSymbolListTestCase1.add("TEA");
		stockSymbolListTestCase1.add("ALE");
		stockSymbolListTestCase1.add("GIN");
		return stockSymbolListTestCase1;
	}
	
	private List<Trade> getTradesTestCase1() {
		List<Trade> trades = new ArrayList<Trade>();
		Trade trade1, trade2, trade3 = null;
		trade1 = new Trade();
		trade1.setId(new Long(1));
		trade1.setStockSymbol("TEA");
		trade1.setPrice(new Price(1.0));
		trade1.setQuantityOfShares(new Long(10));
		trade1.setTimestamp(new Timestamp(System.currentTimeMillis()));
		trade1.setType(TradeType.BUY);

		trade2 = new Trade();
		trade2.setId(new Long(2));
		trade2.setStockSymbol("ALE");
		trade2.setPrice(new Price(1.0));
		trade2.setQuantityOfShares(new Long(10));
		trade2.setTimestamp(new Timestamp(System.currentTimeMillis()));
		trade2.setType(TradeType.SELL);

		trade3 = new Trade();
		trade3.setId(new Long(3));
		trade3.setStockSymbol("GIN");
		trade3.setPrice(new Price(2.0));
		trade3.setQuantityOfShares(new Long(10));
		trade3.setTimestamp(new Timestamp(System.currentTimeMillis()));
		trade3.setType(TradeType.BUY);

		trades.add(trade1);
		trades.add(trade2);
		trades.add(trade3);
		
		return trades;
	}
	
}
