package sssm.stock;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import sssm.market.price.Price;
import sssm.market.stock.CommonStock;
import sssm.market.stock.PreferredStock;
import sssm.market.stock.Stock;
import sssm.market.stock.StockException;

public class GetPERatioTest {

	@Test
	public void testCase1() {
		List<Stock> stockList = getStockList();
		
		Price price = null;
		Stock stock = null;
		Double peRatio = null;
		Double expected = null;
		double value = 0;
		
		try {			
			price = new Price(new Double(1));
			// TEA
			stock = stockList.get(0);
			try {
				peRatio = stock.getPERatio(price);
				fail("StockException expected");
			} catch (StockException se) {
				assertTrue("Message exptected: Dividend is 0", se.getMessage().equals("Dividend is 0"));
			}
			
			// POP
			stock = stockList.get(1);
			value = price.getAmount().doubleValue() / stock.getDividend().doubleValue();
			expected = new Double(value);
			peRatio = stock.getPERatio(price);
			assertTrue("Stock " + stock.getSymbol() + ": peRatio = " + peRatio.doubleValue() + ", expected = " + 
					expected.doubleValue(), 
					peRatio.doubleValue() == expected.doubleValue());
			// ALE
			stock = stockList.get(2);
			value = price.getAmount().doubleValue() / stock.getDividend().doubleValue();
			expected = new Double(value);
			peRatio = stock.getPERatio(price);
			assertTrue("Stock " + stock.getSymbol() + ": peRatio = " + peRatio.doubleValue() + ", expected = " + 
					expected.doubleValue(), 
					peRatio.doubleValue() == expected.doubleValue());
			// GIN	
			stock = stockList.get(3);
			value = price.getAmount().doubleValue() / stock.getDividend().doubleValue();
			expected = new Double(value);
			peRatio = stock.getPERatio(price);
			assertTrue("Stock " + stock.getSymbol() + ": peRatio = " + peRatio.doubleValue() + ", expected = " + 
					expected.doubleValue(), 
					peRatio.doubleValue() == expected.doubleValue());
			// JOE	
			stock = stockList.get(4);
			value = price.getAmount().doubleValue() / stock.getDividend().doubleValue();
			expected = new Double(value);
			peRatio = stock.getPERatio(price);
			assertTrue("Stock " + stock.getSymbol() + ": peRatio = " + peRatio.doubleValue() + ", expected = " + 
					expected.doubleValue(), 
					peRatio.doubleValue() == expected.doubleValue());
		} catch (RuntimeException rue) {
			fail(rue.getMessage());
		} catch (StockException se) {
			fail(se.getMessage());
		}
	}

	@Test
	public void testCase2() {
		List<Stock> stockList = getStockList();
		
		Price price = null;
		Stock stock = null;
		Double peRatio = null;
		Double expected = null;
		double value = 0;
		
		try {			
			price = new Price(new Double(10));
			// TEA
			stock = stockList.get(0);
			try {
				peRatio = stock.getPERatio(price);
				fail("StockException expected");
			} catch (StockException se) {
				assertTrue("Message exptected: Dividend is 0", se.getMessage().equals("Dividend is 0"));
			}
			// POP
			stock = stockList.get(1);
			value = price.getAmount().doubleValue() / stock.getDividend().doubleValue();
			expected = new Double(value);
			peRatio = stock.getPERatio(price);
			assertTrue("Stock " + stock.getSymbol() + ": peRatio = " + peRatio.doubleValue() + ", expected = " + 
					expected.doubleValue(), 
					peRatio.doubleValue() == expected.doubleValue());
			// ALE
			stock = stockList.get(2);
			value = price.getAmount().doubleValue() / stock.getDividend().doubleValue();
			expected = new Double(value);
			peRatio = stock.getPERatio(price);
			assertTrue("Stock " + stock.getSymbol() + ": peRatio = " + peRatio.doubleValue() + ", expected = " + 
					expected.doubleValue(), 
					peRatio.doubleValue() == expected.doubleValue());
			// GIN	
			stock = stockList.get(3);
			value = price.getAmount().doubleValue() / stock.getDividend().doubleValue();
			expected = new Double(value);
			peRatio = stock.getPERatio(price);
			assertTrue("Stock " + stock.getSymbol() + ": peRatio = " + peRatio.doubleValue() + ", expected = " + 
					expected.doubleValue(), 
					peRatio.doubleValue() == expected.doubleValue());
			// JOE	
			stock = stockList.get(4);
			value = price.getAmount().doubleValue() / stock.getDividend().doubleValue();
			expected = new Double(value);
			peRatio = stock.getPERatio(price);
			assertTrue("Stock " + stock.getSymbol() + ": peRatio = " + peRatio.doubleValue() + ", expected = " + 
					expected.doubleValue(), 
					peRatio.doubleValue() == expected.doubleValue());
		} catch (RuntimeException rue) {
			fail(rue.getMessage());
		} catch (StockException se) {
			fail(se.getMessage());
		}
	}
		
	private List<Stock> getStockList() {
		List<Stock> stockList = new ArrayList<Stock>();
		CommonStock tea, pop, ale, joe = null;
		PreferredStock gin = null;
		
		tea = new CommonStock();
		tea.setSymbol("TEA");
		tea.setLastDividend(new Double(0));
		tea.setParValue(new Double(100));
		stockList.add(tea);
		
		pop = new CommonStock();
		pop.setSymbol("POP");
		pop.setLastDividend(new Double(8));
		pop.setParValue(new Double(100));
		stockList.add(pop);
		
		ale = new CommonStock();
		ale.setSymbol("ALE");
		ale.setLastDividend(new Double(23));
		ale.setParValue(new Double(60));
		stockList.add(ale);
		
		gin = new PreferredStock();
		gin.setSymbol("GIN");
		gin.setLastDividend(new Double(8));
		gin.setFixedDividend(new Double(2));
		gin.setParValue(new Double(100));
		stockList.add(gin);
		
		joe = new CommonStock();
		joe.setSymbol("JOE");
		joe.setLastDividend(new Double(13));
		joe.setParValue(new Double(250));
		stockList.add(joe);
		
		return stockList;
	}

}
