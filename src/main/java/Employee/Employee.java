package Employee;

import Customer.Customer;
import InsuranceItem.InsuranceItem;
import Login.Login;

public class Employee {
	
	private Customer customer;
	private InsuranceItem insuranceItem;
	
	public Employee() {
		
	}
	
	public void associate(Customer customer, Login login, InsuranceItem insuranceItem) {
		this.customer = customer;
		this.insuranceItem = insuranceItem; 
	}

}
