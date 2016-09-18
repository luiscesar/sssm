package sssm.market;

import java.util.HashMap;

import sssm.market.stock.CommonStock;
import sssm.market.stock.PreferredStock;
import sssm.market.stock.Stock;

public class SuperSimpleStockMarketServiceFactory {

	public SuperSimpleStockMarketServiceFactory() {
		
	}

	public SuperSimpleStockMarket getInstance() {
		SuperSimpleStockMarket market = new SuperSimpleStockMarket();
		loadStocks(market); 
		return market;
	}

	private void loadStocks(SuperSimpleStockMarket market) {
		market.allStocks = new HashMap<String, Stock>();
		CommonStock tea, pop, ale, joe = null;
		PreferredStock gin = null;
		
		tea = new CommonStock();
		tea.setSymbol("TEA");
		tea.setLastDividend(new Double(0));
		tea.setParValue(new Double(100));
		market.allStocks.put(tea.getSymbol(), tea);
		
		pop = new CommonStock();
		pop.setSymbol("POP");
		pop.setLastDividend(new Double(8));
		pop.setParValue(new Double(100));
		market.allStocks.put(pop.getSymbol(), pop);
		
		ale = new CommonStock();
		ale.setSymbol("ALE");
		ale.setLastDividend(new Double(23));
		ale.setParValue(new Double(60));
		market.allStocks.put(ale.getSymbol(), ale);
		
		gin = new PreferredStock();
		gin.setSymbol("GIN");
		gin.setLastDividend(new Double(8));
		gin.setFixedDividend(new Double(2));
		gin.setParValue(new Double(100));
		market.allStocks.put(gin.getSymbol(), gin);
		
		joe = new CommonStock();
		joe.setSymbol("JOE");
		joe.setLastDividend(new Double(13));
		joe.setParValue(new Double(250));
		market.allStocks.put(joe.getSymbol(), joe);
	}

}
