/**
 *  @author Md. Ayub Ali Sarker, email:ayub.ali.sarker@gmail.com
 *  File Name: DataNotFoundExceptionMapper.java
 *  Date Created: 11:27:44 am,2015
 */
package com.ayubsarker.messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.ayubsarker.messenger.model.ErrorMessage;

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

	@Override
	public Response toResponse(DataNotFoundException ex) {
		ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), 404, "http://wwww.google.com");

		return Response.status(Status.NOT_FOUND).entity(errorMessage).build();
	}
}
