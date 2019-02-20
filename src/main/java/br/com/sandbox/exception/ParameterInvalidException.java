package br.com.sandbox.exception;

public class ParameterInvalidException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ParameterInvalidException(String msg) {
		super(msg);
	}

}
