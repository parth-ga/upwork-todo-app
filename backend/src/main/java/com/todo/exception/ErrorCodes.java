package com.todo.exception;

public enum ErrorCodes {

	POLICY_VIOLATION(466, "Logical policy violation."),

	NAME_EMPTY(466, "Todo Name is mandatory."),

	DESC_EMPTY(466, "Description is mndatory."),

	LIST_EMPTY(466, "List must contain one value."),

	TRANSACTION_OK(0, "Transaction successful.");

	int errorCode;
	String description;

	/**
	 * Instantiates a new error codes.
	 * 
	 * @param errorCode   the error code
	 * @param description the description
	 */
	private ErrorCodes(int errorCode, String description) {
		this.errorCode = errorCode;
		this.description = description;
	}

	/**
	 * Gets the error code.
	 * 
	 * @return the error code
	 */
	public int getErrorCode() {
		return errorCode;
	}

	/**
	 * Sets the error code.
	 * 
	 * @param errorCode the new error code
	 */
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * Gets the description.
	 * 
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 * 
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}
