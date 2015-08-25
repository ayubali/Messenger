/**
 *  @author Md. Ayub Ali Sarker, email:ayub.ali.sarker@gmail.com
 *  File Name: MessageResource.java
 *  Date Created: 4:43:44 pm,2015
 */
package com.ayubsarker.messenger.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.ayubsarker.messenger.model.Message;
import com.ayubsarker.messenger.service.MessageService;

@Path("/messages")
@Singleton
public class MessageResource {

	MessageService messageService = null;

	public MessageResource() {
		messageService = new MessageService();
	}

	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
	// messages?start=1&size=1 or /messages?year=2015
	public List<Message> getMessages(@QueryParam("year") int year, @QueryParam("start") int start, @QueryParam("size") int size) {
		if (year > 0) {
			return messageService.getAllMessagesForYear(year);
		} else if (start > 0 && size > 0) {
			return messageService.getAllMessagePaginated(start, size);
		}
		return messageService.getAllMessages();
	}

	@GET
	@Path("/{messageId}")
	// messages/1
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessage(@PathParam("messageId") long id, @Context UriInfo uriInfo) {
		Message message = messageService.getMessage(id);
		message.addLinks(getUriforSalf(uriInfo), "self");
		message.addLinks(getUriforProfile(uriInfo, message), "profile");
		message.addLinks(getUriforComments(uriInfo, message), "comments");
		return message;
	}

	/**
	 * @author Ayub
	 *
	 * @param uriInfo
	 * @param message
	 * @return
	 */
	private String getUriforComments(UriInfo uriInfo, Message message) {
		String uri = uriInfo.getBaseUriBuilder() // http://localhost:8080/messenger/webapi/
				.path(MessageResource.class) //
				.path(MessageResource.class, "getCommonResource") // build uri
																	// from
																	// method of
																	// the class
																	// ex
																	// /{messageId}/comments
				.path(CommentResource.class).resolveTemplate("messageId", message.getId()).build().toString(); // replace
																												// message
																												// id
																												// with
																												// actual
																												// message
																												// id
		return uri;
	}

	/**
	 * @author Ayub
	 *
	 * @param uriInfo
	 * @return
	 */
	private String getUriforProfile(UriInfo uriInfo, Message message) {
		String uri = uriInfo.getBaseUriBuilder() // http://localhost:8080/messenger/webapi/
				.path(ProfileResource.class) // /profiles
				.path(message.getAuthor()).build().toString();
		return uri;
	}

	/**
	 * @author Ayub
	 *
	 * @param uriInfo
	 * @return
	 */
	private String getUriforSalf(UriInfo uriInfo) {
		String uri = uriInfo.getBaseUriBuilder() // http://localhost:8080/messenger/webapi/
				.path(MessageResource.class) // /messages
				.build().toString();
		return uri;
	}

	// @POST
	// // /messages
	// @Produces(MediaType.APPLICATION_JSON)
	// @Consumes(MediaType.APPLICATION_JSON)
	// public Message addMessage(Message message) {
	// return messageService.addMessage(message);
	//
	// }

	// @POST
	// // /messages
	// @Produces(MediaType.APPLICATION_JSON)
	// @Consumes(MediaType.APPLICATION_JSON)
	// public Response addMessage(Message message) throws URISyntaxException {
	// Message newMessage = messageService.addMessage(message);
	// //Response response =
	// Response.status(Status.CREATED).entity(newMessage).build();
	// Response response = Response.created(new
	// URI("/messagener/webapi/messages/"+
	// newMessage.getId())).entity(newMessage).build();
	// return response;
	//
	// }

	@POST
	// /messages
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addMessage(Message message, @Context UriInfo uriInfo) throws URISyntaxException {
		Message newMessage = messageService.addMessage(message);
		String newID = String.valueOf(newMessage.getId());
		URI uri = uriInfo.getAbsolutePathBuilder().path(newID).build();
		Response response = Response.created(uri).entity(newMessage).build();
		return response;

	}

	@PUT
	@Path("/{messageId}")
	// messages/1
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Message updateMessage(@PathParam("messageId") long id, Message message) {
		System.out.println("id: " + id);
		message.setId(id);
		return messageService.updateMessage(message);
	}

	@DELETE
	@Path("/{messageId}")
	// messages/1
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteMessage(@PathParam("messageId") long id) {
		messageService.removeMessage(id);
	}

	@Path("/{messageId}/comments")
	// /messages/1/comments
	public CommentResource getCommonResource() {
		return new CommentResource();
	}

}
