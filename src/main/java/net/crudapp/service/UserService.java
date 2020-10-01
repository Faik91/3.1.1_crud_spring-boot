package net.crudapp.service;


import net.crudapp.model.Role;
import net.crudapp.model.User;
import net.crudapp.repository.RoleRepository;
import net.crudapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService {

    private final UserRepository userRepository;


    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }

    @Transactional
    public List<User> allUsers() {
        return this.userRepository.findAll();
    }

    @Transactional
    public void saveUser(User user) {
        this.userRepository.save(user);
    }

    @Transactional
    public void deleteUser(long id) {
       this.userRepository.deleteById(id);
    }

    @Transactional
    public User getUserById(long id) {
        return this.userRepository.getOne(id);
    }

}
