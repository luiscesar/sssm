package sssm.market;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import sssm.market.price.Price;
import sssm.market.trade.Trade;
import sssm.market.trade.TradeType;

public class CalculateGBCEIndexTest {

	@Test
	public void testCase1() {
		// Init context
		MarketService marketService = null;
		SuperSimpleStockMarketServiceFactory marketFactory = null;
		List<Trade> trades = null;
		Double index = 0.0;
		Double expected = null;
		try {
			marketFactory = new SuperSimpleStockMarketServiceFactory();
			marketService = marketFactory.getInstance();
			trades = getTradesTestCase1();
			for (Trade trade: trades) {
				marketService.recordTrade(trade);
			}
			expected = 1.0;
			index = marketService.calculateGBCEIndex();
			assertTrue("index = " + index + ", expected = " + expected, index.doubleValue() == expected.doubleValue());
		} catch (RuntimeException rue) {
			fail(rue.getMessage());
		} catch (MarketException me) {
			fail(me.getMessage());
		}
	}

	@Test
	public void testCase2() {
		// Init context
		MarketService marketService = null;
		SuperSimpleStockMarketServiceFactory marketFactory = null;
		List<Trade> trades = null;
		Double index = 0.0;
		Double expected = null;
		try {
			marketFactory = new SuperSimpleStockMarketServiceFactory();
			marketService = marketFactory.getInstance();
			trades = getTradesTestCase2();
			for (Trade trade: trades) {
				marketService.recordTrade(trade);
			}
			expected = 2.0;
			index = marketService.calculateGBCEIndex();
			assertTrue("index = " + index + ", expected = " + expected, index.doubleValue() == expected.doubleValue());
		} catch (RuntimeException rue) {
			fail(rue.getMessage());
		} catch (MarketException me) {
			fail(me.getMessage());
		}
	}

	private List<Trade> getTradesTestCase1() {
		List<Trade> trades = new ArrayList<Trade>();
		Trade trade1, trade2, trade3, trade4, trade5 = null;
		String stockSymbol = null;
		
		stockSymbol = "TEA";
		trade1 = new Trade();
		trade1.setStockSymbol(stockSymbol);
		trade1.setId(new Long(1));
		trade1.setStockSymbol(stockSymbol);
		trade1.setPrice(new Price(1.0));
		trade1.setQuantityOfShares(new Long(10));
		trade1.setTimestamp(new Timestamp(System.currentTimeMillis()));
		trade1.setType(TradeType.BUY);

		stockSymbol = "POP";
		trade2 = new Trade();
		trade2.setStockSymbol(stockSymbol);
		trade2.setId(new Long(1));
		trade2.setStockSymbol(stockSymbol);
		trade2.setPrice(new Price(1.0));
		trade2.setQuantityOfShares(new Long(10));
		trade2.setTimestamp(new Timestamp(System.currentTimeMillis()));
		trade2.setType(TradeType.BUY);

		stockSymbol = "ALE";
		trade3 = new Trade();
		trade3.setId(new Long(2));
		trade3.setStockSymbol(stockSymbol);
		trade3.setPrice(new Price(1.0));
		trade3.setQuantityOfShares(new Long(10));
		trade3.setTimestamp(new Timestamp(System.currentTimeMillis()));
		trade3.setType(TradeType.SELL);

		stockSymbol = "GIN";
		trade4 = new Trade();
		trade4.setId(new Long(3));
		trade4.setStockSymbol(stockSymbol);
		trade4.setPrice(new Price(1.0));
		trade4.setQuantityOfShares(new Long(10));
		trade4.setTimestamp(new Timestamp(System.currentTimeMillis()));
		trade4.setType(TradeType.BUY);

		stockSymbol = "JOE";
		trade5 = new Trade();
		trade5.setStockSymbol(stockSymbol);
		trade5.setId(new Long(1));
		trade5.setStockSymbol(stockSymbol);
		trade5.setPrice(new Price(1.0));
		trade5.setQuantityOfShares(new Long(10));
		trade5.setTimestamp(new Timestamp(System.currentTimeMillis()));
		trade5.setType(TradeType.BUY);

		trades.add(trade1);
		trades.add(trade2);
		trades.add(trade3);
		trades.add(trade4);
		trades.add(trade5);

		return trades;
	}

	private List<Trade> getTradesTestCase2() {
		List<Trade> trades = new ArrayList<Trade>();
		Trade trade1, trade2, trade3, trade4, trade5 = null;
		Trade trade11, trade21, trade31, trade41, trade51 = null;
		Trade trade12, trade22, trade32, trade42, trade52 = null;
		
		String stockSymbol = null;
		
		stockSymbol = "TEA";
		trade1 = new Trade();
		trade1.setStockSymbol(stockSymbol);
		trade1.setId(new Long(1));
		trade1.setStockSymbol(stockSymbol);
		trade1.setPrice(new Price(1.0));
		trade1.setQuantityOfShares(new Long(10));
		trade1.setTimestamp(new Timestamp(System.currentTimeMillis()));
		trade1.setType(TradeType.BUY);

		trade11 = new Trade();
		trade11.setStockSymbol(stockSymbol);
		trade11.setId(new Long(1));
		trade11.setStockSymbol(stockSymbol);
		trade11.setPrice(new Price(1.0));
		trade11.setQuantityOfShares(new Long(10));
		trade11.setTimestamp(new Timestamp(System.currentTimeMillis()));
		trade11.setType(TradeType.BUY);

		trade12 = new Trade();
		trade12.setStockSymbol(stockSymbol);
		trade12.setId(new Long(1));
		trade12.setStockSymbol(stockSymbol);
		trade12.setPrice(new Price(2.0));
		trade12.setQuantityOfShares(new Long(10));
		trade12.setTimestamp(new Timestamp(System.currentTimeMillis()));
		trade12.setType(TradeType.SELL);

		stockSymbol = "POP";
		trade2 = new Trade();
		trade2.setStockSymbol(stockSymbol);
		trade2.setId(new Long(1));
		trade2.setStockSymbol(stockSymbol);
		trade2.setPrice(new Price(1.0));
		trade2.setQuantityOfShares(new Long(10));
		trade2.setTimestamp(new Timestamp(System.currentTimeMillis()));
		trade2.setType(TradeType.BUY);

		trade21 = new Trade();
		trade21.setStockSymbol(stockSymbol);
		trade21.setId(new Long(1));
		trade21.setStockSymbol(stockSymbol);
		trade21.setPrice(new Price(1.0));
		trade21.setQuantityOfShares(new Long(10));
		trade21.setTimestamp(new Timestamp(System.currentTimeMillis()));
		trade21.setType(TradeType.SELL);

		trade22 = new Trade();
		trade22.setStockSymbol(stockSymbol);
		trade22.setId(new Long(1));
		trade22.setStockSymbol(stockSymbol);
		trade22.setPrice(new Price(2.0));
		trade22.setQuantityOfShares(new Long(10));
		trade22.setTimestamp(new Timestamp(System.currentTimeMillis()));
		trade22.setType(TradeType.BUY);

		stockSymbol = "ALE";
		trade3 = new Trade();
		trade3.setId(new Long(2));
		trade3.setStockSymbol(stockSymbol);
		trade3.setPrice(new Price(1.0));
		trade3.setQuantityOfShares(new Long(10));
		trade3.setTimestamp(new Timestamp(System.currentTimeMillis()));
		trade3.setType(TradeType.SELL);

		trade31 = new Trade();
		trade31.setId(new Long(2));
		trade31.setStockSymbol(stockSymbol);
		trade31.setPrice(new Price(1.0));
		trade31.setQuantityOfShares(new Long(10));
		trade31.setTimestamp(new Timestamp(System.currentTimeMillis()));
		trade31.setType(TradeType.SELL);

		trade32 = new Trade();
		trade32.setId(new Long(2));
		trade32.setStockSymbol(stockSymbol);
		trade32.setPrice(new Price(2.0));
		trade32.setQuantityOfShares(new Long(10));
		trade32.setTimestamp(new Timestamp(System.currentTimeMillis()));
		trade32.setType(TradeType.SELL);

		stockSymbol = "GIN";
		trade4 = new Trade();
		trade4.setId(new Long(3));
		trade4.setStockSymbol(stockSymbol);
		trade4.setPrice(new Price(1.0));
		trade4.setQuantityOfShares(new Long(10));
		trade4.setTimestamp(new Timestamp(System.currentTimeMillis()));
		trade4.setType(TradeType.SELL);

		trade41 = new Trade();
		trade41.setId(new Long(3));
		trade41.setStockSymbol(stockSymbol);
		trade41.setPrice(new Price(1.0));
		trade41.setQuantityOfShares(new Long(10));
		trade41.setTimestamp(new Timestamp(System.currentTimeMillis()));
		trade41.setType(TradeType.BUY);

		trade42 = new Trade();
		trade42.setId(new Long(3));
		trade42.setStockSymbol(stockSymbol);
		trade42.setPrice(new Price(2.0));
		trade42.setQuantityOfShares(new Long(10));
		trade42.setTimestamp(new Timestamp(System.currentTimeMillis()));
		trade42.setType(TradeType.BUY);

		stockSymbol = "JOE";
		trade5 = new Trade();
		trade5.setStockSymbol(stockSymbol);
		trade5.setId(new Long(1));
		trade5.setStockSymbol(stockSymbol);
		trade5.setPrice(new Price(1.0));
		trade5.setQuantityOfShares(new Long(10));
		trade5.setTimestamp(new Timestamp(System.currentTimeMillis()));
		trade5.setType(TradeType.BUY);

		trade51 = new Trade();
		trade51.setStockSymbol(stockSymbol);
		trade51.setId(new Long(1));
		trade51.setStockSymbol(stockSymbol);
		trade51.setPrice(new Price(1.0));
		trade51.setQuantityOfShares(new Long(10));
		trade51.setTimestamp(new Timestamp(System.currentTimeMillis()));
		trade51.setType(TradeType.SELL);

		trade52 = new Trade();
		trade52.setStockSymbol(stockSymbol);
		trade52.setId(new Long(1));
		trade52.setStockSymbol(stockSymbol);
		trade52.setPrice(new Price(2.0));
		trade52.setQuantityOfShares(new Long(10));
		trade52.setTimestamp(new Timestamp(System.currentTimeMillis()));
		trade52.setType(TradeType.BUY);

		trades.add(trade1);trades.add(trade2);trades.add(trade3);trades.add(trade4);trades.add(trade5);
		trades.add(trade11);trades.add(trade21);trades.add(trade31);trades.add(trade41);trades.add(trade51);
		trades.add(trade12);trades.add(trade22);trades.add(trade32);trades.add(trade42);trades.add(trade52);
		
		return trades;
	}

}
