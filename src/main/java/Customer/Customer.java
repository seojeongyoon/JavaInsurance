package Customer;

import InsuranceItem.InsuranceItem;

public class Customer {

	private InsuranceItem insuranceItem;
	
	public Customer() {
	}
	
	public void associate(InsuranceItem insuranceItem) {
		this.insuranceItem = insuranceItem;
	}

}
