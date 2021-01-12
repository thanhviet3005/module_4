package levunguyen.demo_spring_boot.service;

import levunguyen.demo_spring_boot.model.User;
import levunguyen.demo_spring_boot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(User user) {
        this.userRepository.save(user);
    }

    @Override
    public User findById(int id) {
        User user = this.userRepository.findById(id).orElse(null);
        return user;
    }
}
