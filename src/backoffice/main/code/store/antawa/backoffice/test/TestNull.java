package store.antawa.backoffice.test;


public class TestNull {

	private  String restCode;
	
	private static CustomProfile getCustomer() {
		return new CustomProfile();
	}
	
	public static void main(String[] args) {
		CustomProfile cust = getCustomer();
		
		if("O".equals(cust.getCallType())){
			System.out.println(0);
		}

	}

	public String getRestCode() {
		return restCode;
	}

	public void setRestCode(String restCode) {
		this.restCode = restCode;
	}

}
