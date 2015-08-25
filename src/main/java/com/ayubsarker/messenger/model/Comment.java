/**
 *  @author Md. Ayub Ali Sarker, email:ayub.ali.sarker@gmail.com
 *  File Name: Comment.java
 *  Date Created: 4:04:12 pm,2015
 */
package com.ayubsarker.messenger.model;

import java.util.Date;

public class Comment {

	private long id;
	private String message;
	private Date created;
	private String author;

	/**
	 * 
	 */
	public Comment() {
	}

	/**
	 * @param id
	 * @param message
	 * @param created
	 * @param author
	 */
	public Comment(long id, String message, Date created, String author) {
		super();
		this.id = id;
		this.message = message;
		this.created = new Date();
		this.author = author;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return this.id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return this.message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the created
	 */
	public Date getCreated() {
		return this.created;
	}

	/**
	 * @param created
	 *            the created to set
	 */
	public void setCreated(Date created) {
		this.created = created;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return this.author;
	}

	/**
	 * @param author
	 *            the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

}
