/**
 * Simple DB Load Data
 * Uses Typica Library to load sample data into Domain
 * Used in tutorial on SimpleDB and Yahoo Data Source
 * Based on Amazon sample data set.
 * Note: I removed "hard cases" that include ' and * in data.
 */

/**
 * @author Carmen Delessio
 * carmendelessio AT gmail DOT com
 * 
 * 03/01/2009 Creation
 * 
 */
import java.util.ArrayList;
import java.util.List;
import com.xerox.amazonws.sdb.*;

public class SimpleDBLoadData {

	public static void main(String[] args) {
		SimpleDB exampleDB = new SimpleDB("KEY","SECRET");
		Item exampleItem;
		List<ItemAttribute> attributes;
		Domain exampleDomain;
		try {
			exampleDomain=exampleDB.getDomain("example");
			
			exampleItem = exampleDomain.getItem("0385333498");
			attributes = new ArrayList<ItemAttribute>();
			attributes.add(new ItemAttribute("Title", "The Sirens of Titan", true));
			attributes.add(new ItemAttribute("Author", "Kurt Vonnegut", true));
			attributes.add(new ItemAttribute("Year", "1959", true));
			attributes.add(new ItemAttribute("Pages", "00336", true));
			exampleItem.putAttributes(attributes);

			attributes.add(new ItemAttribute("Keyword", "Book", false));
			attributes.add(new ItemAttribute("Keyword", "Paperback", false));
			attributes.add(new ItemAttribute("Rating", "5 stars", false));
			attributes.add(new ItemAttribute("Rating", "Excellent", false));
			exampleItem.putAttributes(attributes);
			
			exampleItem = exampleDomain.getItem("0802131786");
			attributes = new ArrayList<ItemAttribute>();
			attributes.add(new ItemAttribute("Title", "Tropic of Cancer", true));
			attributes.add(new ItemAttribute("Author", "Henry Miller", true));
			attributes.add(new ItemAttribute("Year", "1934", true));
			attributes.add(new ItemAttribute("Pages", "00318", true));
			attributes.add(new ItemAttribute("Keyword", "Book", false));
			exampleItem.putAttributes(attributes);

			exampleItem = exampleDomain.getItem("1579124585");
			attributes = new ArrayList<ItemAttribute>();
			attributes.add(new ItemAttribute("Title", "The Right Stuff", true));
			attributes.add(new ItemAttribute("Author", "Tom Wolfe", true));
			attributes.add(new ItemAttribute("Year", "1979", true));
			attributes.add(new ItemAttribute("Pages", "00304", true));
			attributes.add(new ItemAttribute("Keyword", "Book", false));
			attributes.add(new ItemAttribute("Keyword", "Hardcover", false));
			attributes.add(new ItemAttribute("Keyword", "American", false));
			attributes.add(new ItemAttribute("Rating", "4 stars", false));
			attributes.add(new ItemAttribute("Rating", "Excellent", false));
			exampleItem.putAttributes(attributes);


			exampleItem = exampleDomain.getItem("B000T9886K");
			attributes = new ArrayList<ItemAttribute>();
			attributes.add(new ItemAttribute("Title", "In Between", true));
			attributes.add(new ItemAttribute("Author", "Paul Van Dyk", true));
			attributes.add(new ItemAttribute("Year", "2007", true));
			attributes.add(new ItemAttribute("Keyword", "CD", false));
			attributes.add(new ItemAttribute("Keyword", "Trance", false));
			attributes.add(new ItemAttribute("Rating", "4 stars", false));
			exampleItem.putAttributes(attributes);

			exampleItem = exampleDomain.getItem("B00005JPLW");
			attributes = new ArrayList<ItemAttribute>();
			attributes.add(new ItemAttribute("Title", "300", true));
			attributes.add(new ItemAttribute("Author", "Zack Snyder", true));
			attributes.add(new ItemAttribute("Year", "2007", true));
			attributes.add(new ItemAttribute("Keyword", "DVD", false));
			attributes.add(new ItemAttribute("Keyword", "Action", false));
			attributes.add(new ItemAttribute("Keyword", "Frank Miller", false));
			attributes.add(new ItemAttribute("Rating", "3 stars", false));
			attributes.add(new ItemAttribute("Rating", "Not bad", false));
			exampleItem.putAttributes(attributes);

			exampleItem = exampleDomain.getItem("B000SF3NGK");
			attributes = new ArrayList<ItemAttribute>();
			attributes.add(new ItemAttribute("Title", "Heaven's Gonna Burn Your Eyes", true));
			attributes.add(new ItemAttribute("Author", "Thievery Corporation", true));
			exampleItem.putAttributes(attributes);
	
		} catch (SDBException ex) {
			System.err.println("message : "+ex.getMessage());
			System.err.println("requestID : "+ex.getRequestId());
		}
	}
}
