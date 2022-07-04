package utilities;

public enum API_Enum {
	
	
	CreateSyncpointAPI("xml/1.1/syncpoint/syncpoints.svc/"),
	CreateUserAPI("xml/1.1/auth/companies_public.svc/");
	
	private String resource;

	API_Enum(String resource) {
		
		this.resource=resource;
	}
	
	public String getresoruce() {
		
		return resource;
		
	}
	
	

}
