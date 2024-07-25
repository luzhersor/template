package user.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import user.model.User;

/**
 * Repositorio de la entidad Usuario que extiende de PanacheRepository
 */
@ApplicationScoped
public class UserRepository implements PanacheRepository<User> {
}
