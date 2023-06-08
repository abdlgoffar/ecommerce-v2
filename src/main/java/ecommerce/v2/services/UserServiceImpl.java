package ecommerce.v2.services;

import ecommerce.v2.configurations.components.IDGenerator;
import ecommerce.v2.models.entities.User;
import ecommerce.v2.models.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;
    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    private IDGenerator idGenerator;
    @Autowired
    public void setIdGenerator(IDGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

    @Override
    public User create(User user) {
        user.setId(this.idGenerator.generate());
        User save = this.userRepository.save(user);
        return save;
    }

    @Override
    public List<User> findAll() {
        List<User> all = this.userRepository.findAll();
        return all;
    }

    @Override
    public User findOneById(String id) {
        Optional<User> byId = this.userRepository.findById(id);
        if (byId.isPresent()) {
            User user = byId.get();
            return user;
        } else {
            return null;
        }
    }
}
