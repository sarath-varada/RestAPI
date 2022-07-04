package pojopack;

public class Payloadimplementation {
	
	public static Pojopayload payloadfunction(String Name, String Type) {
		
		Pojopayload p=new Pojopayload();
		p.setName(Name);
		p.setType(Type);
		return p;
	}

}
