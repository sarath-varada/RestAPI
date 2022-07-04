package pojopack;

public class Pojopayload {
	
	private String Name;
	private String Type;
	
	public String getName() {
		return Name;
	}
	public void setName(String Name) {
		this.Name = Name;
	}
	public String getType() {
		return Type;
	}
	public void setType(String Type) {
		this.Type = Type;
	}
	
	
	public static String realpayload() {
		
		return "[\r\n"
				+ "  {\r\n"
				+ "    \"Name\": \"testAPI\",\r\n"
				+ "    \"Type\": \"8\"\r\n"
				+ "  }\r\n"
				+ "]";
	}
	

}
