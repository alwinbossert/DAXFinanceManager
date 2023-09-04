package daxfinancemanager;

import java.math.BigDecimal;
import java.sql.Date;


public class DAXFinanceParser {
	DAXFinanceDownloader daxFinanceDownloader = new DAXFinanceDownloader("https://query1.finance.yahoo.com/v7/finance/download/%5EGDAXI?period1=1661776171&period2=1693312171&interval=1d&events=history&includeAdjustedClose=true");

	private Date date;
	private BigDecimal open;
	private BigDecimal high;
	private BigDecimal low;
	private BigDecimal close;
	private BigDecimal adjClose;
	private BigDecimal volume;

	public Date getDate() {
		return date;
	}

	public BigDecimal getOpen() {
		return open;
	}

	public BigDecimal getHigh() {
		return high;
	}

	public BigDecimal getLow() {
		return low;
	}

	public BigDecimal getClose() {
		return close;
	}

	public BigDecimal getAdjClose() {
		return adjClose;
	}

	public BigDecimal getVolume() {
		return volume;
	}

	public DAXFinanceParser() {
	}
	
	public void parse(String financeData) {
		String[] splitData = financeData.split(",");
		date = Date.valueOf(splitData[0]);
		open = new BigDecimal(splitData[1]);
		high = new BigDecimal(splitData[2]);
		low = new BigDecimal(splitData[3]);
		close = new BigDecimal(splitData[4]);
		adjClose = new BigDecimal(splitData[5]);
		volume = new BigDecimal(splitData[6]);
	}
}
