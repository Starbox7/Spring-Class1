package  com.example.web.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.web.domains.User;
import com.example.web.repositories.UserRepository;

@Service
public class UserService {
  private final UserRepository userRepository;

  public UserService(UserRepository userRepository){
    this.userRepository = userRepository;
  }

  public String join(User user) {
    validateDuplicateUser(user);
    userRepository.add(user);
    return user.getId();
  }

  private void validateDuplicateUser(User user) {
    userRepository.findById(user.getId()).ifPresent(existingUser -> {
      throw new IllegalStateException("Duplicate User");
    });
  }

  public List<User> findUsers() {
    return userRepository.findAll();
  }
}
