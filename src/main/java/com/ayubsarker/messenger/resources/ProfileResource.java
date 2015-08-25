/**
 *  @author Md. Ayub Ali Sarker, email:ayub.ali.sarker@gmail.com
 *  File Name: ProfileResource.java
 *  Date Created: 11:24:43 am,2015
 */
package com.ayubsarker.messenger.resources;

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
import javax.ws.rs.core.MediaType;

import com.ayubsarker.messenger.model.Profile;
import com.ayubsarker.messenger.service.ProfileService;

@Path("/profiles")
@Singleton
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProfileResource {

	private ProfileService profileService = null;

	public ProfileResource() {
		profileService = new ProfileService();
	}

	@GET
	// /profiles
	public List<Profile> getProfiles() {
		return profileService.getAllProfiles();
	}

	@POST
	// /profiles
	public Profile addProfile(Profile profile) {
		return profileService.addProfile(profile);
	}

	@GET
	@Path("/{profileName}")
	// /profiles/ayub.ali
	public Profile getProfile(@PathParam("profileName") String profileName) {
		return profileService.getProfile(profileName);

	}

	@PUT
	@Path("/{profileName}")
	// /profiles/ayub.ali
	public Profile updateProfile(@PathParam("profileName") String profileName, Profile profile) {
		profile.setProfileName(profileName);
		return profileService.updateProfile(profile);
	}

	@DELETE
	@Path("/{profileName}")
	// /profiles/ayub.ali
	public Profile deleteProfile(@PathParam("profileName") String profileName) {
		return profileService.removeProfile(profileName);

	}

}
