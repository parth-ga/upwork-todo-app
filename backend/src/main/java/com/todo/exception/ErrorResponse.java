package com.todo.exception;

public class ErrorResponse {

	/** The code. */
	private int code;

	/** The message. */
	private String message;

	/**
	 * Instantiates a new error responce.
	 */
	public ErrorResponse() {
	}

	/**
	 * Instantiates a new error responce.
	 *
	 * @param message the message
	 */
	public ErrorResponse(String message) {
		this.message = message;
	}

	/**
	 * Instantiates a new error responce.
	 *
	 * @param code    the code
	 * @param message the message
	 */
	public ErrorResponse(int code, String message) {
		this.message = message;
		this.code = code;
	}

	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * Sets the code.
	 *
	 * @param code the new code
	 */
	public void setCode(int code) {
		this.code = code;
	}

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Sets the message.
	 *
	 * @param message the new message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}
