/**
 *  @author Md. Ayub Ali Sarker, email:ayub.ali.sarker@gmail.com
 *  File Name: MesssageResourceBeanParam.java
 *  Date Created: 1:18:41 pm,2015
 */
package com.ayubsarker.messenger.resources;

import java.util.List;

import javax.inject.Singleton;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.ayubsarker.messenger.model.Message;
import com.ayubsarker.messenger.resources.beans.MessageFilterBean;
import com.ayubsarker.messenger.service.MessageService;

@Path("/messagesbybeanparam")
@Singleton
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MesssageResourceBeanParam {

	MessageService messageService = null;

	public MesssageResourceBeanParam() {
		messageService = new MessageService();
	}

	@GET
	// /messages?start=1&size=1 or /messages?year=2015 or
		public List<Message> getMessages(@BeanParam MessageFilterBean filterBean) {
		if (filterBean.getYear() > 0) {
			return messageService.getAllMessagesForYear(filterBean.getYear());
		} else if (filterBean.getStart() > 0 && filterBean.getSize() > 0) {
			return messageService.getAllMessagePaginated(filterBean.getStart(), filterBean.getSize());
		}
		return messageService.getAllMessages();
	}

}
