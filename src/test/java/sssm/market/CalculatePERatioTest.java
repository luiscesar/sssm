package sssm.market;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import sssm.market.price.Price;
import sssm.market.stock.CommonStock;
import sssm.market.stock.PreferredStock;
import sssm.market.stock.Stock;
import sssm.market.stock.StockException;

public class CalculatePERatioTest {

	@Test
	public void testCase1() {
		SuperSimpleStockMarketServiceFactory factory = null;
		MarketService marketService = null;
		
		Price price = null;
		Stock stock = null;
		Double peRatio = null;
		Double expected = null;
		
		try {			
			factory = new SuperSimpleStockMarketServiceFactory();
			marketService = factory.getInstance();

			price = new Price(new Double(1));
			// TEA
			stock = marketService.getStock("TEA");
			try {
				peRatio = marketService.calculatePERatio("TEA", price);
				fail("MarketException expected");
			} catch (MarketException me) {
				assertTrue("Message exptected: Dividend is 0", me.getMessage().equals("Dividend is 0"));
			}			
			// POP
			stock = marketService.getStock("POP");
			expected = price.getAmount() / stock.getDividend();
			peRatio = marketService.calculatePERatio("POP", price);
			assertTrue("Stock " + stock.getSymbol() + ": peRatio = " + peRatio.doubleValue() + ", expected = " + 
					expected.doubleValue(), 
					peRatio.doubleValue() == expected.doubleValue());
			// ALE
			stock = marketService.getStock("ALE");
			expected = price.getAmount() / stock.getDividend();
			peRatio = marketService.calculatePERatio("ALE", price);
			assertTrue("Stock " + stock.getSymbol() + ": peRatio = " + peRatio.doubleValue() + ", expected = " + 
					expected.doubleValue(), 
					peRatio.doubleValue() == expected.doubleValue());
			// GIN	
			stock = marketService.getStock("GIN");
			expected = price.getAmount() / stock.getDividend();
			peRatio = marketService.calculatePERatio("GIN", price);
			peRatio = stock.getPERatio(price);
			assertTrue("Stock " + stock.getSymbol() + ": peRatio = " + peRatio.doubleValue() + ", expected = " + 
					expected.doubleValue(), 
					peRatio.doubleValue() == expected.doubleValue());
			// JOE	
			stock = marketService.getStock("JOE");
			expected = price.getAmount() / stock.getDividend();
			peRatio = marketService.calculatePERatio("JOE", price);
			peRatio = stock.getPERatio(price);
			assertTrue("Stock " + stock.getSymbol() + ": peRatio = " + peRatio.doubleValue() + ", expected = " + 
					expected.doubleValue(), 
					peRatio.doubleValue() == expected.doubleValue());
		} catch (RuntimeException rue) {
			fail(rue.getMessage());
		} catch (StockException se) {
			fail(se.getMessage());
		} catch (MarketException me) {
			fail(me.getMessage());
		}
	}

	@Test
	public void testCase2() {
		SuperSimpleStockMarketServiceFactory factory = null;
		MarketService marketService = null;
		
		Price price = null;
		Stock stock = null;
		Double peRatio = null;
		Double expected = null;
		
		try {			
			factory = new SuperSimpleStockMarketServiceFactory();
			marketService = factory.getInstance();

			price = new Price(new Double(10));
			// TEA
			stock = marketService.getStock("TEA");
			try {
				peRatio = marketService.calculatePERatio("TEA", price);
				fail("MarketException expected");
			} catch (MarketException me) {
				assertTrue("Message exptected: Dividend is 0", me.getMessage().equals("Dividend is 0"));
			}
			// POP
			stock = marketService.getStock("POP");
			expected = price.getAmount() / stock.getDividend();
			peRatio = marketService.calculatePERatio("POP", price);
			assertTrue("Stock " + stock.getSymbol() + ": peRatio = " + peRatio.doubleValue() + ", expected = " + 
					expected.doubleValue(), 
					peRatio.doubleValue() == expected.doubleValue());
			// ALE
			stock = marketService.getStock("ALE");
			expected = price.getAmount() / stock.getDividend();
			peRatio = marketService.calculatePERatio("ALE", price);
			assertTrue("Stock " + stock.getSymbol() + ": peRatio = " + peRatio.doubleValue() + ", expected = " + 
					expected.doubleValue(), 
					peRatio.doubleValue() == expected.doubleValue());
			// GIN	
			stock = marketService.getStock("GIN");
			expected = price.getAmount() / stock.getDividend();
			peRatio = marketService.calculatePERatio("GIN", price);
			assertTrue("Stock " + stock.getSymbol() + ": peRatio = " + peRatio.doubleValue() + ", expected = " + 
					expected.doubleValue(), 
					peRatio.doubleValue() == expected.doubleValue());
			// JOE	
			stock = marketService.getStock("JOE");
			expected = price.getAmount() / stock.getDividend();
			peRatio = marketService.calculatePERatio("JOE", price);
			assertTrue("Stock " + stock.getSymbol() + ": peRatio = " + peRatio.doubleValue() + ", expected = " + 
					expected.doubleValue(), 
					peRatio.doubleValue() == expected.doubleValue());
		} catch (RuntimeException rue) {
			fail(rue.getMessage());
		} catch (StockException se) {
			fail(se.getMessage());
		} catch (MarketException me) {
			fail(me.getMessage());
		}
	}
		
}
