package user.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import user.model.User;

import java.util.List;

@Path("/users")
public class UserController {

    @GET
    public List<User> index(){

    }

    @POST
    public User insert(){

    }






}
