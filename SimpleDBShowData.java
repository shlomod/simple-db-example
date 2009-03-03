/**
 * Simple DB Show Data
 * Uses Typica Library to show sample data 
 * Used in tutorial on SimpleDB and Yahoo Data Source
 * Based on Amazon sample data set.
 * 
 * handle absence of an attribute and multiple attributes with same name,
 * but this is done in a very simple way.  
 * 
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
public class SimpleDBShowData {

	public static void main(String[] args) {
		SimpleDB exampleDB = new SimpleDB("KEY","SECRET");
		Domain exampleDomain;
		//Item exampleItem;
		List<Item> items;
//		List<ItemAttribute> attributes;
		QueryResult result = null;
		StringBuffer title = new StringBuffer("");
		StringBuffer author= new StringBuffer("");
		StringBuffer year= new StringBuffer("");
		StringBuffer pages= new StringBuffer("");
		StringBuffer keyword= new StringBuffer("");
		StringBuffer rating= new StringBuffer("");
		
		//ItemAttribute currentAttribute;
		
		List<String> attributesToGet = new ArrayList<String>();
		
		try {
			exampleDomain=exampleDB.getDomain("example");
			result = exampleDomain.listItems();
			items = result.getItemList();
			
			
			for (Item exampleItem : items) {
				System.out.print(exampleItem.getIdentifier()+"|" );

				 title = new StringBuffer("");
				 author= new StringBuffer("");
				 year= new StringBuffer("");
				 pages= new StringBuffer("");
				 keyword= new StringBuffer("");
				 rating= new StringBuffer("");
				
				
				List<ItemAttribute> attrs = exampleItem.getAttributes(attributesToGet);
				for (ItemAttribute currentAttribute : attrs) {

					
					
					if (currentAttribute.getName().equals("Title")){
						title.append( currentAttribute.getValue()+" ");
					}else
					if (currentAttribute.getName().equals("Author")){
						author.append( currentAttribute.getValue()+" ");
					}else
					if (currentAttribute.getName().equals("Year")){
						year.append( currentAttribute.getValue()+" ");
					}else
					if (currentAttribute.getName().equals("Keyword")){
						keyword.append( currentAttribute.getValue()+" ");
					}else
					if (currentAttribute.getName().equals("Rating")){
						rating.append( currentAttribute.getValue()+" ");
					}else
					if (currentAttribute.getName().equals("Pages")){
						pages.append( currentAttribute.getValue()+" ");
					}
				}	// for each attribute
				System.out.println(title.toString() +"|"+ author.toString() +"|" + year.toString()+"|" + pages.toString()+"|"+keyword.toString()+"|" + rating.toString());
			} // for each item

			System.out.println();
			
		} catch (SDBException ex) {
			System.err.println("message : "+ex.getMessage());
			System.err.println("requestID : "+ex.getRequestId());
		}
	}

}
