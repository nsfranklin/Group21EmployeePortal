public class PayrollDetails {

	Employee employee;
	private int accountNumber;
	private int sortCode;

	public int getAccountNumber() {
		return this.accountNumber;
	}

	/**
	 * 
	 * @param accountNumber
	 */
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getSortCode() {
		return this.sortCode;
	}

	/**
	 * 
	 * @param sortCode
	 */
	public void setSortCode(int sortCode) {
		this.sortCode = sortCode;
	}

}