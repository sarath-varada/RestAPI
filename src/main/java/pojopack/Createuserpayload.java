package pojopack;

public class Createuserpayload {
	
	
	public String AdminuserCreationpayload(String emailAddress, String CompanyName) {
		
		
		return "[\r\n"
				+ "  {\r\n"
				+ "    \"AccountType\": 3,\r\n"
				+ "    \"Name\": \""+CompanyName+"\",\r\n"
				+ "    \"Address1\": \"Enterprise, Inc. 022515-s1\",\r\n"
				+ "    \"State\": \"CA\",\r\n"
				+ "    \"City\": \"Cupertino\",\r\n"
				+ "    \"ZipCode\": \"95014\",\r\n"
				+ "    \"Owner\": {\r\n"
				+ "      \"EmailAddress\": \""+emailAddress+"\",\r\n"
				+ "      \"FirstName\": \"Firstname\",\r\n"
				+ "      \"LastName\": \"Lastname\",\r\n"
				+ "      \"Password\": \"t3stP@ss\",\r\n"
				+ "      \"StorageRegion\": 0,\r\n"
				+ "      \"AccountType\": 3\r\n"
				+ "    },\r\n"
				+ "    \"Phone1\": \"650-111-1111\",\r\n"
				+ "    \"ExternalBillingId\": \"610918\",\r\n"
				+ "    \"BillingModelType\": 0,\r\n"
				+ "    \"Seats\": 99999,\r\n"
				+ "    \"Storage\": 50\r\n"
				+ "  }\r\n"
				+ "]";
		
	}

}
