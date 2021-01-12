package levunguyen.demo_spring_boot.service;

import levunguyen.demo_spring_boot.model.User;
import levunguyen.demo_spring_boot.repository.UserRepository;

public interface UserService {
    void save(User user);
    User findById(int id);
}
