package user.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import user.model.User;
import user.service.UserService;

import java.util.List;

/**
 * Recurso REST para la gestion de usuarios.
 */
@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserController {

    @Inject
    UserService userServ;

    /**
     * Obtiene todos los usuarios.
     * @return Lista de usuarios.
     */
    @GET
    public List<User> getAllUsers() {
        return userServ.listAllUsers();
    }

    /**
     * Obtiene un usuario por su ID.
     *
     * @param id ID del usuario.
     * @return Respuesta con el usuario encontrado o estado 404 si no se encuentra.
     */
    @GET
    @Path("/{id}")
    public Response getUserById(@PathParam("id") Long id) {
        return userServ.findUserById(id)
                .map(user -> Response.ok(user).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    /**
     * Crea un nuevo usuario.
     *
     * @param user Usuario a crear.
     * @return Respuesta con el usuario creado.
     */
    @POST
    public Response createUser(User user) {
        User createdUser = userServ.createUser(user);
        return Response.status(Response.Status.CREATED).entity(createdUser).build();
    }

    /**
     * @param id ID del usuario.
     * @return Respuesta con estado 204 si se eliminó o estado 404 si no se encuentra.
     */
    @DELETE
    @Path("/{id}")
    public Response deleteUser(@PathParam("id") Long id) {
        boolean deleted = userServ.deleteUser(id);
        if (deleted) {
            return Response.noContent().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    /**
     * @param id ID del usuario.
     * @param user Datos del usuario actualizados.
     * @return Respuesta con el usuario actualizado o estado 404 si no se encuentra.
     */
    @PUT
    @Path("/{id}")
    public Response updateUser(@PathParam("id") Long id, User user){
        User updatedUser = userServ.updateUser(id, user);

        if(updatedUser != null){
            return Response.ok(updatedUser).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }




}
