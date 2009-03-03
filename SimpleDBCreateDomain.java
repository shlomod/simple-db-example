/**
 * Simple DB Create Domain
 * Uses Typica Library to create Domain named example
 * Used in tutorial on SimpleDB and Yahoo Data Source
 */

/**
 * @author Carmen Delessio
 * carmendelessio AT gmail DOT com
 * 
 * 03/01/2009 Creation
 * 
 */

import com.xerox.amazonws.sdb.*;

public class SimpleDBCreateDomain {

	public static void main(String[] args) {
		SimpleDB exampleDB = new SimpleDB("KEY","SECRET");
		try {
			exampleDB.createDomain("example");
		} catch (SDBException ex) {
			System.err.println("message : "+ex.getMessage());
			System.err.println("requestID : "+ex.getRequestId());
		}

	}

}
