package ManagedBeans;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.script.SimpleScriptContext;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

@ManagedBean(name = "StockBean") 
@SessionScoped
public class StockBean {
	String url = "https://www.boursorama.com/cours/1rPBNP/";
	String stockPrice="";
	public StockBean() {
		// TODO Auto-generated constructor stub
	}
	public void initStock(){
		try {
			Stock stock = YahooFinance.get("BNP.PA");
			stockPrice=""+stock.getCurrency();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int i;
	public void test() throws FileNotFoundException, ScriptException{
		StringWriter writer = new StringWriter(); //ouput will be stored here
		ScriptEngineManager manager = new ScriptEngineManager();
	    ScriptContext context = new SimpleScriptContext();

	    context.setWriter(writer); //configures output redirection
	    ScriptEngine engine = manager.getEngineByName("python");
	    engine.eval(new FileReader("C:/Users/Nihel/DataMiningRL.ipynb"), context);
	   if( writer.toString().isEmpty())
	   {
		   i=0;
	   }else
		   i = writer.toString().length();
	}
	public String getStockPrice() {
		return stockPrice;
	}
	public void setStockPrice(String stockPrice) {
		this.stockPrice = stockPrice;
	}
}
