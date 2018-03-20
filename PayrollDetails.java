public class PayrollDetails {

	private String accountNumber;
	private String sortCode;

	PayrollDetails(String accountNumber, String sortCode)
	{
		this.accountNumber = accountNumber;
		this.sortCode = sortCode;
	}

	public String getAccountNumber() {
		return this.accountNumber;
	}

	/**
	 * 
	 * @param accountNumber
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getSortCode() {
		return this.sortCode;
	}

	/**
	 * 
	 * @param sortCode
	 */
	public void setSortCode(String sortCode) {
		this.sortCode = sortCode;
	}

}