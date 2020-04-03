package transaction;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Transactions")
public class Transaction {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer transactionId;
	
	@Column(name="AccountNumber")
	private Integer accountNumber;
	
	@Column(name="Description")
	private String description;
	  
	@Column(name="Amount")
	private Float amount;
	  
	@Column(name="State")
	private String state;
	  
	@Column(name="Date")
	private String date;
	  
	@Column(name="TransactionType")
	private String transactionType;
	
	@Column(name="Category")
	private int category;
	
	@Column(name="ReadStatus")
	private boolean readStatus;

	public Transaction() {
		
	}

	/**
	 * @return the transactionId
	 */
	public Integer getTransactionId() {
		return transactionId;
	}

	/**
	 * @return the accountNumber
	 */
	public Integer getAccountNumber() {
		return accountNumber;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return the amount
	 */
	public Float getAmount() {
		return amount;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @return the transactionType
	 */
	public String getTransactionType() {
		return transactionType;
	}
	
	/**
	 * @return the category
	 */
	public int getCategory() {
		return category;
	}
	
	/**
	 * @return the redStatus
	 */
	public boolean getReadStatus() {
		return readStatus;
	}

	/**
	 * @param transactionId the transactionId to set
	 */
	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}

	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Float amount) {
		this.amount = amount;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @param transactionType the transactionType to set
	 */
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(int category) {
		this.category = category;
	}


	/**
	 * @param readStatus the redStatus to set
	 */
	public void setReadStatus(boolean readStatus) {
		this.readStatus = readStatus;
	}
<<<<<<< HEAD:CommerceServer/src/main/java/com/group2/sql/Transaction.java
=======
	  
>>>>>>> 83171c1af070557c5cbc4dfc953eea542fed2938:CommerceServer/src/main/java/transaction/Transaction.java

}
