package ecommerce.v2.services;

import ecommerce.v2.models.entities.User;

import java.util.List;

public interface UserService {
    public abstract User create(User user);
    public abstract List<User> findAll();
    public abstract User findOneById(String id);
}
