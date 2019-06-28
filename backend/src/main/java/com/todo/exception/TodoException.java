package com.todo.exception;

public class TodoException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The error message. */
	private String errorMessage;

	/** The error code. */
	private Integer errorCode;

	/**
	 * Instantiates a new GA exception.
	 *
	 * @param errorCode    the error code
	 * @param errorMessage the error message
	 */
	public TodoException(ErrorCodes errorCode, String errorMessage) {
		this.errorCode = errorCode.getErrorCode();
		this.errorMessage = errorMessage;
	}

	/**
	 * Instantiates a new GA exception.
	 *
	 * @param errorCode the error code
	 */
	public TodoException(ErrorCodes errorCode) {
		this.errorCode = errorCode.getErrorCode();
		this.errorMessage = errorCode.getDescription();

	}

	/**
	 * Instantiates a new GA exception.
	 *
	 * @param cause the cause
	 */
	public TodoException(Throwable cause) {
		super(cause);
	}

	/**
	 * Gets the error message.
	 *
	 * @return the error message
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * Sets the error message.
	 *
	 * @param errorMessage the new error message
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	/**
	 * Gets the error code.
	 *
	 * @return the error code
	 */
	public Integer getErrorCode() {
		return errorCode;
	}

	/**
	 * Sets the error code.
	 *
	 * @param errorCode the new error code
	 */
	
	/**
	 * Instantiates a new GA exception.
	 */
	public TodoException() {
	}

}
