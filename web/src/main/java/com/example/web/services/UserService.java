package  com.example.web.services;

import java.util.List;
import java.util.Optional;

import com.example.web.domains.User;
import com.example.web.repositories.UserRepository;

import jakarta.transaction.Transactional;

// @Service
@Transactional
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

  public Optional<User> findOne(String id){
    return userRepository.findById(id);
  }
}
