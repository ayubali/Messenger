/**
 *  @author Md. Ayub Ali Sarker, email:ayub.ali.sarker@gmail.com
 *  File Name: Message.java
 *  Date Created: 5:02:54 pm,2015
 */
package com.ayubsarker.messenger.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Message {

	private long id;
	private String message;
	private Date created;
	private String author;
	private Map<Long, Comment> comments = new HashMap<>();
	private List<Link> links = new ArrayList<>();

	public Message() {
	}

	/*
	 * @param id
	 * 
	 * @param message
	 * 
	 * @param created
	 * 
	 * @param author
	 */
	public Message(long id, String message, String author) {
		super();
		this.id = id;
		this.message = message;
		this.author = author;
		this.created = new Date();
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

	/**
	 * @return the comments
	 */
	@XmlTransient
	// this marker makes message list without comments list when return message
	public Map<Long, Comment> getComments() {
		return this.comments;
	}

	/**
	 * @param comments
	 *            the comments to set
	 */
	public void setComments(Map<Long, Comment> comments) {
		this.comments = comments;
	}

	/**
	 * @return the links
	 */
	public List<Link> getLinks() {
		return this.links;
	}

	/**
	 * @param links
	 *            the links to set
	 */
	public void setLinks(List<Link> links) {
		this.links = links;
	}

	public void addLinks(String url, String rel) {
		Link link = new Link();
		link.setLink(url);
		link.setRel(rel);
		links.add(link);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Message [id=" + this.id + ", message=" + this.message + ", created=" + this.created + ", author=" + this.author
				+ "]";
	}

}
