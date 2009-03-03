
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

  <jsp:directive.page import="com.xerox.amazonws.sdb.*"/>
  <jsp:directive.page import="java.util.List"/>
  <jsp:directive.page import="java.util.ArrayList"/>
 
 <%
		SimpleDB exampleDB = new SimpleDB("KEY","SECRET");
		Domain exampleDomain;
		List<Item> items;
		QueryResult result = null;
		StringBuffer title = new StringBuffer("");
		StringBuffer author= new StringBuffer("");
		StringBuffer year= new StringBuffer("");
		StringBuffer pages= new StringBuffer("");
		StringBuffer keyword= new StringBuffer("");
		StringBuffer rating= new StringBuffer("");
		String itemIdentifier= null;

		List<String> attributesToGet = new ArrayList<String>();
		
		try {
			exampleDomain=exampleDB.getDomain("example");
			result = exampleDomain.listItems();
			items = result.getItemList();
			
			
			for (Item exampleItem : items) {
				itemIdentifier =exampleItem.getIdentifier();

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
				String display = itemIdentifier+"|"+title.toString() +"|"+ author.toString() +"|" + year.toString()+"|" + pages.toString()+"|"+keyword.toString()+"|" + rating.toString();
				%>
				
				<%=display %>
				
                <%			
			} // for each item
		} catch (SDBException ex) {
			System.err.println("message : "+ex.getMessage());
			System.err.println("requestID : "+ex.getRequestId());
		}
	
 %>