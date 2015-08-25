/**
 *  @author Md. Ayub Ali Sarker, email:ayub.ali.sarker@gmail.com
 *  File Name: MessageFilterBean.java
 *  Date Created: 1:14:52 pm,2015
 */
package com.ayubsarker.messenger.resources.beans;

import javax.ws.rs.QueryParam;

public class MessageFilterBean {
	private @QueryParam("year") int year;
	private @QueryParam("start") int start;
	private @QueryParam("size") int size;

	/**
	 * @return the year
	 */
	public int getYear() {
		return this.year;
	}

	/**
	 * @param year
	 *            the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * @return the start
	 */
	public int getStart() {
		return this.start;
	}

	/**
	 * @param start
	 *            the start to set
	 */
	public void setStart(int start) {
		this.start = start;
	}

	/**
	 * @return the size
	 */
	public int getSize() {
		return this.size;
	}

	/**
	 * @param size
	 *            the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}

}
