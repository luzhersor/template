package user.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import user.model.User;
import user.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class UserService {

    @Inject
    UserRepository userRepo;

    public List<User> listAllUsers(){
        return userRepo.listAll();
    }

    public Optional<User> findUserById(Long id){
        return userRepo.findByIdOptional(id);
    }

    @Transactional
    public User createUser(User user){
        userRepo.persist(user);
        return user;
    }

    @Transactional
    public boolean deleteUser(Long id){
        return userRepo.deleteById(id);
    }

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
