package com.david.spring.hibernate.exception;

/**
 * @描述：
 * @className:BookShopException.java
 * @作者： David
 * @日期 2019-02-22 21:47:01
 */
public class BookShopException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6491484001541576087L;

	public BookShopException() {
		super();
		
	}

	public BookShopException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public BookShopException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public BookShopException(String message) {
		super(message);
		
	}

	public BookShopException(Throwable cause) {
		super(cause);
		
	}

}
