package user.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import user.model.User;

@ApplicationScoped
public class UserRepository implements PanacheRepository<User> {
}
