package daxfinancemanager;

public class Main {

	public static void main(String[] args) {
		run();
	}
	
	private static void run() {
		DatabaseManager databaseManager = new DatabaseManager();
		DAXFinanceDownloader daxFinanceDownloader = new DAXFinanceDownloader("https://query1.finance.yahoo.com/v7/finance/download/%5EGDAXI?period1=1661776171&period2=1693312171&interval=1d&events=history&includeAdjustedClose=true");
		DAXFinanceParser daxFinanceParser = new DAXFinanceParser();
		while(daxFinanceDownloader.getDaxFinanceData() != null) {
			daxFinanceParser.parse(daxFinanceDownloader.getDaxFinanceData());
			databaseManager.insert(daxFinanceParser.getDate(), daxFinanceParser.getOpen(), daxFinanceParser.getHigh(), daxFinanceParser.getLow(), daxFinanceParser.getClose(), daxFinanceParser.getAdjClose(), daxFinanceParser.getVolume());
			daxFinanceDownloader.readLine();
		}
	}
}
