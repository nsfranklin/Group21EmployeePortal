public class PayrollDetails {

	private int accountNumber;
	private int sortCode;

	PayrollDetails(int accountNumber, int sortCode)
	{
		this.accountNumber = accountNumber;
		this.sortCode = sortCode;
	}

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