package Contract;

import Accident.Accident;

public class Contract {
	
	private Accident accident;

	public void instantiation() {
		this.accident = new Accident();
	}

	public void associate() {
		this.accident.associate();
	}

}
