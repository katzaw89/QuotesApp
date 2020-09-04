package pl.honestit.demo;
import pl.honestit.demo.utils.QuoteGenerator;
import pl.honestit.demo.utils.QuoteTranslator;


public class QuotesApp{


private static String frameBorder = "*";

	public static void main (String[] args){
	
		System.out.print("\n\n~~~~Zapraszamy do udziału!~~~~\n\n");
		
		String quote = QuoteGenerator.getQuote();
		String author = QuoteGenerator.getAuthor();
		String translateQuote = QuoteTranslator.translate(quote);
		
		System.out.println("Cytat na dzisiaj:");
		
		int frameLength = quote.length()+6;
		printFrameBorder(frameLength);
		printFrameEmptyLine(frameLength);	
		printFrameQuoteLine(quote);
		printFrameAuthorLine(author,frameLength);
		printFrameEmptyLine(frameLength);
		printFrameBorder(frameLength);
		
		System.out.println();
		
		System.out.println("Po polsku:");

		frameLength = translateQuote.length()+6;
		printFrameBorder(frameLength);
		printFrameEmptyLine(frameLength);
		printFrameQuoteLine(translateQuote);
		printFrameAuthorLine(author,frameLength);

		printFrameEmptyLine(frameLength);
		printFrameBorder(frameLength);
		
	}
	
	public static void printFrameAuthorLine (String author, int length){
		System.out.print(frameBorder+"  ");
		int linePadding = length- (2*3)-4 - author.length();
		for(int i = 0; i<linePadding; i++){
		System.out.print(" ");
		}
		System.out.print("--- "+ author);
		System.out.print("  "+frameBorder);
		System.out.println();
	}
	
	public static void printFrameQuoteLine (String quote){
	System.out.println(frameBorder+"  "+quote+ "  "+frameBorder);
	
	}
	
	public static void printFrameBorder (int length){
	for (int i=0; i<length; i++)
		{
			System.out.print(frameBorder);
		}
		System.out.println();
	}
	
	public static void printFrameEmptyLine (int length){
		for (int i=0; i<length; i++)
		{
			if (i==0 || i==length-1){
				System.out.print("*");
		}else {System.out.print(" ");}
		}
		System.out.println();
		}
	
	
	
}