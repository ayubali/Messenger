/**
 *  @author Md. Ayub Ali Sarker, email:ayub.ali.sarker@gmail.com
 *  File Name: CommentService.java
 *  Date Created: 4:11:11 pm,2015
 */
package com.ayubsarker.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.ayubsarker.messenger.database.DatabaseClass;
import com.ayubsarker.messenger.model.Comment;
import com.ayubsarker.messenger.model.ErrorMessage;
import com.ayubsarker.messenger.model.Message;

public class CommentService {

	private Map<Long, Message> messages = DatabaseClass.getMessages();

	public List<Comment> getAllComments(long messageId) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return new ArrayList<Comment>(comments.values());
	}

	public Comment getComment(long messageId, long commentId) {
		/*
		 * WebApllicationException example ErrorMessage errorMessage = new
		 * ErrorMessage("Not Found", 404, "http://wwww.google.com"); Response
		 * response =
		 * Response.status(Status.NOT_FOUND).entity(errorMessage).build();
		 * Message message = messages.get(messageId);
		 * 
		 * if (message == null) { throw new WebApplicationException(response); }
		 * Map<Long, Comment> comments = message.getComments(); Comment comment
		 * = comments.get(commentId); if (comment == null) { throw new
		 * WebApplicationException(response); } return comment;
		 */
		Message message = messages.get(messageId);
		Map<Long, Comment> comments = message.getComments();
		Comment comment = comments.get(commentId);
		return comment;
	}

	public Comment addComment(long messageId, Comment comment) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		comment.setId(comments.size() + 1);
		comments.put(comment.getId(), comment);
		return comment;
	}

	public Comment updateComment(long messageId, Comment comment) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		if (comment.getId() <= 0) {
			return null;
		}

		comments.put(comment.getId(), comment);
		return comment;
	}

	public Comment removeComment(long messageId, long commentId) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return comments.remove(commentId);
	}

}
