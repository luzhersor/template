package user.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import user.model.User;
import user.repository.UserRepository;

import java.util.List;
import java.util.Optional;

/**
 * Servicio para la gestion de usuarios.
 */
@ApplicationScoped
public class UserService {

    @Inject
    UserRepository userRepo;

    /**
     * Enlista todos los usuarios.
     *
     * @return Lista de usuarios.
     */
    public List<User> listAllUsers(){
        return userRepo.listAll();
    }

    /**
     * Encuentra un usuario por su ID.
     *
     * @param id ID del usuario.
     * @return Usuario encontrado, si existe.
     */
    public Optional<User> findUserById(Long id){
        return userRepo.findByIdOptional(id);
    }

    /**
     * Crea un nuevo usuario.
     *
     * @param user Usuario a crear.
     * @return Usuario creado.
     */
    @Transactional
    public User createUser(User user){
        userRepo.persist(user);
        return user;
    }

    /**
     *Elimina un usuario por su ID.
     * @param id ID del usuario a eliminar.
     * @return true si se eliminó, false si no se encontró.
     */
    @Transactional
    public boolean deleteUser(Long id){
        return userRepo.deleteById(id);
    }


    /**
     * Actualiza un usuario existente.
     * @param id ID del usuario a actualizar.
     * @param user Datos del usuario actualizados.
     * @return Usuario actualizado, o null si no se encontró.
     */
    @Transactional
    public User updateUser(Long id, User user){
        Optional<User> userOptional = userRepo.findByIdOptional(id);
        //if (userOptional != null)
        if (userOptional.isPresent()) {
            User existingUser =  userOptional.get();
            existingUser.setNombre(user.getNombre());
            existingUser.setEmail(user.getEmail());
            existingUser.setPassword(user.getPassword());
            return existingUser;

        } else {
            return null;
        }
    }



}
