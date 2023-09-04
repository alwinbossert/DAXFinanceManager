package daxfinancemanager;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class DAXFinanceDownloader {
    private String daxFinanceData;
    private BufferedReader reader;

    public String getDaxFinanceData() {
        return daxFinanceData;
    }

    public DAXFinanceDownloader(String url) {
        try{
            BufferedInputStream in = new BufferedInputStream(new URL(url).openStream());
            reader = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
            // Skip the header
            reader.readLine();
            daxFinanceData = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readLine() {
        try {
        	daxFinanceData = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            daxFinanceData = null;
        }
    }
}
