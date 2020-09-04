package pl.honestit.demo.utils;

import java.net.*;
import java.net.http.*;

public class QuoteGenerator{
	
	public static String getQuote(){
		//https://theysaidso.com/quote-of-the-day/
		try{
		HttpClient client = HttpClient.newHttpClient();
		HttpResponse response = client.send(HttpRequest.newBuilder()
											.uri(URI.create("https://theysaidso.com/quote-of-the-day/"))
											.GET()
											.build(),
											HttpResponse.BodyHandlers.ofString());
		String content = (String) response.body();	
		int indexOfTitle = content.indexOf("title=\"Inspiring Quote of the day\"");
		content = content.substring(indexOfTitle);
		int indexOfLead=content.indexOf("<p class=\"lead\">");
		content=content.substring(indexOfLead);
		int indexOfSpan = content.indexOf("<span itemprop=\"text\">");
		int indexOfSpanClosed = content.indexOf("</span>", indexOfSpan);
		int spanLength = "<span itemprop=\"text\">".length();
		String quote = content.substring(indexOfSpan+spanLength,indexOfSpanClosed);
		
		return quote;
		}catch(Exception e){
			return "No quote!";
		}
	}
	
	public static String getAuthor(){
		
		//https://theysaidso.com/quote-of-the-day/
		try{
		HttpClient client = HttpClient.newHttpClient();
		HttpResponse response = client.send(HttpRequest.newBuilder()
											.uri(URI.create("https://theysaidso.com/quote-of-the-day/"))
											.GET()
											.build(),
											HttpResponse.BodyHandlers.ofString());
		String content = (String) response.body();	
		int indexOfTitle = content.indexOf("title=\"Inspiring Quote of the day\"");
		content = content.substring(indexOfTitle);
		int indexOfLead=content.indexOf("<p class=\"lead\">");
		content=content.substring(indexOfLead);
		int indexOfSpan = content.indexOf("<span itemprop=\"name\">");
		int indexOfSpanClosed = content.indexOf("</span>", indexOfSpan);
		int spanLength = "<span itemprop=\"name\">".length();
		String author = content.substring(indexOfSpan+spanLength,indexOfSpanClosed);
		
		return author;
		}catch(Exception e){
			return "No Author!";
		}
		
	}
}