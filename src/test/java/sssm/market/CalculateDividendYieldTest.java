package sssm.market;

import static org.junit.Assert.*;

import org.junit.Test;

import sssm.market.price.Price;
import sssm.market.stock.Stock;
import sssm.market.stock.StockException;

public class CalculateDividendYieldTest {

	@Test
	public void testCase1() {			
		SuperSimpleStockMarketServiceFactory factory = null;
		MarketService marketService = null;
		Price price = null;
		Stock stock = null;
		Double dividend = null;
		Double expected = null;
		
		try {			
			factory = new SuperSimpleStockMarketServiceFactory();
			marketService = factory.getInstance();
			
			price = new Price(new Double(1));
			
			// TEA
			stock = marketService.getStock("TEA");
			expected = stock.getDividend() / price.getAmount();
			dividend = marketService.calculateDividendYield("TEA", price);
			assertTrue("Stock " + stock.getSymbol() + ": dividend = " + dividend.doubleValue() + ", expected = " + 
					expected.doubleValue(), 
					dividend.doubleValue() == expected.doubleValue());
			// POP
			stock = marketService.getStock("POP");
			expected = stock.getDividend() / price.getAmount();
			dividend = marketService.calculateDividendYield("POP", price);
			assertTrue("Stock " + stock.getSymbol() + ": dividend = " + dividend.doubleValue() + ", expected = " + 
					expected.doubleValue(), 
					dividend.doubleValue() == expected.doubleValue());
			// ALE
			stock = marketService.getStock("ALE");
			expected = stock.getDividend() / price.getAmount();
			dividend = marketService.calculateDividendYield("ALE", price);
			assertTrue("Stock " + stock.getSymbol() + ": dividend = " + dividend.doubleValue() + ", expected = " + 
					expected.doubleValue(), 
					dividend.doubleValue() == expected.doubleValue());
			// GIN	
			stock = marketService.getStock("GIN");
			expected = stock.getDividend() / price.getAmount();
			dividend = marketService.calculateDividendYield("GIN", price);
			assertTrue("Stock " + stock.getSymbol() + ": dividend = " + dividend.doubleValue() + ", expected = " + 
					expected.doubleValue(), 
					dividend.doubleValue() == expected.doubleValue());
			// JOE	
			stock = marketService.getStock("JOE");
			expected = stock.getDividend() / price.getAmount();
			dividend = marketService.calculateDividendYield("JOE", price);
			assertTrue("Stock " + stock.getSymbol() + ": dividend = " + dividend.doubleValue() + ", expected = " + 
					expected.doubleValue(), 
					dividend.doubleValue() == expected.doubleValue());

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
		Double dividend = null;
		Double expected = null;
		
		try {			
			factory = new SuperSimpleStockMarketServiceFactory();
			marketService = factory.getInstance();

			price = new Price(new Double(10));
			
			// TEA
			stock = marketService.getStock("TEA");
			expected = stock.getDividend() / price.getAmount();
			dividend = marketService.calculateDividendYield("TEA", price);
			assertTrue("Stock " + stock.getSymbol() + ": dividend = " + dividend.doubleValue() + ", expected = " + 
					expected.doubleValue(), 
					dividend.doubleValue() == expected.doubleValue());
			// POP
			stock = marketService.getStock("POP");
			expected = stock.getDividend() / price.getAmount();
			dividend = marketService.calculateDividendYield("POP", price);
			assertTrue("Stock " + stock.getSymbol() + ": dividend = " + dividend.doubleValue() + ", expected = " + 
					expected.doubleValue(), 
					dividend.doubleValue() == expected.doubleValue());
			// ALE
			stock = marketService.getStock("ALE");
			expected = stock.getDividend() / price.getAmount();
			dividend = marketService.calculateDividendYield("ALE", price);
			assertTrue("Stock " + stock.getSymbol() + ": dividend = " + dividend.doubleValue() + ", expected = " + 
					expected.doubleValue(), 
					dividend.doubleValue() == expected.doubleValue());
			// GIN	
			stock = marketService.getStock("GIN");
			expected = stock.getDividend() / price.getAmount();
			dividend = marketService.calculateDividendYield("GIN", price);
			assertTrue("Stock " + stock.getSymbol() + ": dividend = " + dividend.doubleValue() + ", expected = " + 
					expected.doubleValue(), 
					dividend.doubleValue() == expected.doubleValue());
			// JOE	
			stock = marketService.getStock("JOE");
			expected = stock.getDividend() / price.getAmount();
			dividend = marketService.calculateDividendYield("JOE", price);
			assertTrue("Stock " + stock.getSymbol() + ": dividend = " + dividend.doubleValue() + ", expected = " + 
					expected.doubleValue(), 
					dividend.doubleValue() == expected.doubleValue());

		} catch (RuntimeException rue) {
			fail(rue.getMessage());
		} catch (StockException se) {
			fail(se.getMessage());
		} catch (MarketException me) {
			fail(me.getMessage());
		}
	}
	
}
