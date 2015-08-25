/**
 *  @author Md. Ayub Ali Sarker, email:ayub.ali.sarker@gmail.com
 *  File Name: InjectDemoResource.java
 *  Date Created: 12:37:39 pm,2015
 */
package com.ayubsarker.messenger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;


@Path("/injectdemo")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
public class InjectDemoResource {

	@GET
	@Path("annotations")
	// injectdemo/annotations;param=value
	public String getParamsUsingAnnotation(@MatrixParam("param") String matrixParam,
			@HeaderParam("authenSessionID") String sessionId, @CookieParam("name") String cookieValue) {
		return "matrix param: " + matrixParam + " authenSessionID: " + sessionId + " Cookie param: " + cookieValue;
	}

	@GET
	@Path("context")
	public String getParamUsingContext(@Context UriInfo uriInfo, @Context HttpHeaders httpHeaders) {
		String path = uriInfo.getAbsolutePath().toString();
		String cookies = httpHeaders.getCookies().toString();
		return "PATH: " + path + " Cookie: " + cookies;
	}

}
