package com.spring.hospital.service;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import com.spring.hospital.model.User;


@Path("/userService")
@Produces("application/xml, application/json")
@Consumes("application/xml, application/json")
public interface UserService {
	
	@GET
	@Path("/getUser")
	public List<User> getUser();
	
	@GET
	@Path("/getUser/{id}")
	public User getUserById(@PathParam(value="id")Integer id);
	
	@GET
	@Path("/authorizedUser/{id}")
	public boolean checkIfAutorized(@PathParam(value="id")Integer id);
	
	@POST
	@Path("/addUser")
	public Response addUser();
	
	@PUT
	@Path("/editUser/{id}")
	public Response editUser(User usr);
	
	@DELETE
	@Path("/deleteUser/{id}")
	public Response deleteUSer();

}
