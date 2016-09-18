package sssm.market;

import static org.junit.Assert.fail;
import static org.junit.Assert.assertTrue;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import sssm.market.price.Price;
import sssm.market.trade.Trade;
import sssm.market.trade.TradeType;

public class CalculateVolumeWeightedStockPriceTest {

	@Test
	public void testCase1() {
		// Init context
		MarketService marketService = null;
		SuperSimpleStockMarketServiceFactory marketFactory = null;
		List<Trade> trades = null;
		String stockSymbol = null;
		Double volumeWeightedStockPrice = 0.0;
		Double expected = null;
		
		try {
			marketFactory = new SuperSimpleStockMarketServiceFactory();
			marketService = marketFactory.getInstance();
			trades = getTradesTestCase1();
			stockSymbol = "TEA";
			for (Trade trade: trades) {
				marketService.recordTrade(trade);
			}
			expected = 1.0;
			volumeWeightedStockPrice = marketService.calculateVolumeWeightedStockPrice(stockSymbol);
			assertTrue(stockSymbol + ": volumeWeightedPrice = " + volumeWeightedStockPrice.doubleValue() + 
					", expected = " + expected, volumeWeightedStockPrice.doubleValue() == expected.doubleValue());
		} catch (RuntimeException rue) {
			fail(rue.getMessage());
		} catch (MarketException me) {
			fail(me.getMessage());
		}
	}


	private List<Trade> getTradesTestCase1() {
		List<Trade> trades = new ArrayList<Trade>();
		String stockSymbol = "TEA";
		Trade trade1, trade2, trade3 = null;
		trade1 = new Trade();
		trade1.setId(new Long(1));
		trade1.setStockSymbol(stockSymbol);
		trade1.setPrice(new Price(1.0));
		trade1.setQuantityOfShares(new Long(10));
		Timestamp t1 = new Timestamp(System.currentTimeMillis());
		trade1.setTimestamp(t1);
		trade1.setType(TradeType.BUY);

		trade2 = new Trade();
		trade2.setId(new Long(2));
		trade2.setStockSymbol(stockSymbol);
		trade2.setPrice(new Price(1.0));
		trade2.setQuantityOfShares(new Long(10));
		Timestamp t2 = new Timestamp(System.currentTimeMillis());
		trade2.setTimestamp(t2);
		trade2.setType(TradeType.SELL);

		trade3 = new Trade();
		trade3.setId(new Long(3));
		trade3.setStockSymbol(stockSymbol);
		trade3.setPrice(new Price(1.0));
		trade3.setQuantityOfShares(new Long(10));
		Timestamp t3 = new Timestamp(System.currentTimeMillis());
		trade3.setTimestamp(t3);
		trade3.setType(TradeType.BUY);

		trades.add(trade1);
		trades.add(trade2);
		trades.add(trade3);
		
		return trades;
	}

	@Test
	public void testCase2() {
		// Init context
		MarketService marketService = null;
		SuperSimpleStockMarketServiceFactory marketFactory = null;
		List<Trade> trades = null;
		String stockSymbol = null;
		Double volumeWeightedStockPrice = 0.0;
		Double expected = null;
		
		try {
			marketFactory = new SuperSimpleStockMarketServiceFactory();
			marketService = marketFactory.getInstance();
			trades = getTradesTestCase2();
			stockSymbol = "TEA";
			for (Trade trade: trades) {
				marketService.recordTrade(trade);
			}
			expected = (double) 2/3;
			volumeWeightedStockPrice = marketService.calculateVolumeWeightedStockPrice(stockSymbol);
			assertTrue(stockSymbol + ": volumeWeightedPrice = " + volumeWeightedStockPrice.doubleValue() + 
					", expected = " + expected, volumeWeightedStockPrice.doubleValue() == expected.doubleValue());
		} catch (RuntimeException rue) {
			fail(rue.getMessage());
		} catch (MarketException me) {
			fail(me.getMessage());
		}
	}

	private List<Trade> getTradesTestCase2() {
		List<Trade> trades = new ArrayList<Trade>();
		Trade trade1, trade2, trade3 = null;
		String stockSymbol = "TEA";

		trade1 = new Trade();
		trade1.setId(new Long(1));
		trade1.setStockSymbol(stockSymbol);
		trade1.setPrice(new Price(1.0));
		trade1.setQuantityOfShares(new Long(10));
		Timestamp t1 = new Timestamp(System.currentTimeMillis());
		trade1.setTimestamp(t1);
		trade1.setType(TradeType.BUY);

		trade2 = new Trade();
		trade2.setId(new Long(2));
		trade2.setStockSymbol(stockSymbol);
		trade2.setPrice(new Price((0.5)));
		trade2.setQuantityOfShares(new Long(20));
		Timestamp t2 = new Timestamp(System.currentTimeMillis());
		trade2.setTimestamp(t2);
		trade2.setType(TradeType.SELL);

		trade3 = new Trade();
		trade3.setId(new Long(3));
		trade3.setStockSymbol(stockSymbol);
		trade3.setPrice(new Price(1.0));
		trade3.setQuantityOfShares(new Long(10));
		Timestamp t3 = new Timestamp(System.currentTimeMillis() - 16*60000);
		trade3.setTimestamp(t3);
		trade3.setType(TradeType.BUY);

		trades.add(trade1);
		trades.add(trade2);
		trades.add(trade3);
		
		return trades;
	}

}
