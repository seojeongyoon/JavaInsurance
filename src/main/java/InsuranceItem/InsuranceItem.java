package InsuranceItem;

import Contract.Contract;

public class InsuranceItem {
	
	private Contract contract;
	private InsuranceRate insuranceRate;
	
	public void instantiation() {// associate하는 다른 클래스 객체 만들기
		
		this.contract = new Contract();
		this.contract.instantiation();
		this.insuranceRate = new InsuranceRate();
		
	}

	public void associate() {
		this.contract.associate();
		this.insuranceRate.associate();

	}

}
