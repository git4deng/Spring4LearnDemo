package com.david.spring.transaction.xml.exception;

/**
 * @������
 * 
 * @className:UserAccountException.java @���ߣ� David
 * @���� 2019-02-22 21:48:26
 */
public class UserAccountException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1496702271103132633L;

	public UserAccountException() {

	}

	public UserAccountException(String message) {
		super(message);

	}

	public UserAccountException(Throwable cause) {
		super(cause);

	}

	public UserAccountException(String message, Throwable cause) {
		super(message, cause);

	}

	public UserAccountException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
