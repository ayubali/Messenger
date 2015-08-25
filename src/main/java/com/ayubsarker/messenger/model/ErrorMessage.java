/**
 *  @author Md. Ayub Ali Sarker, email:ayub.ali.sarker@gmail.com
 *  File Name: ErrorMessage.java
 *  Date Created: 11:23:50 am,2015
 */
package com.ayubsarker.messenger.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessage {

	private String errorMessage;
	private int errorCode;
	private String documnetation;

	public ErrorMessage() {

	}

	/**
	 * @param errorMessage
	 * @param errorCode
	 * @param documnetation
	 */
	public ErrorMessage(String errorMessage, int errorCode, String documnetation) {
		super();
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
		this.documnetation = documnetation;
	}

	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return this.errorMessage;
	}

	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	/**
	 * @return the errorCode
	 */
	public int getErrorCode() {
		return this.errorCode;
	}

	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @return the documnetation
	 */
	public String getDocumnetation() {
		return this.documnetation;
	}

	/**
	 * @param documnetation the documnetation to set
	 */
	public void setDocumnetation(String documnetation) {
		this.documnetation = documnetation;
	}
	
	

}
