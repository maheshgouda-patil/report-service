package com.solution.util;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

import org.springframework.web.client.RestTemplate;



public class CurrencyConversionUtil {

	final static String currencyExchangeURL = "https://api.exchangeratesapi.io/latest?symbols=USD,GBP,JPY";
	public static Map<String, Object> currencyMap = new HashMap<String, Object>();
	public static void convertCurrency() {
		
		 	RestTemplate restTemplate = new RestTemplate();
	        String result = restTemplate.getForObject(currencyExchangeURL, String.class);
	        JSONObject jsonObj = new JSONObject(result.toString());
	        JSONObject curr = (JSONObject) jsonObj.get("rates");
	       
	        currencyMap.put("JPY", curr.get("JPY"));
	        currencyMap.put("USD", curr.get("USD"));
	        currencyMap.put("GBP", curr.get("GBP"));
	        
	        //System.out.println(currencyMap);
	}
	
	/*
	 * public static void main(String[] args) {
	 * 
	 * CurrencyConversionUtil obj = new CurrencyConversionUtil();
	 * obj.convertCurrency();
	 * 
	 * 
	 * 
	 * 
	 * 
	 * }
	 */

 
}
