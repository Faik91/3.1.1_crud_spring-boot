package net.crudapp.service;


import net.crudapp.model.Role;
import net.crudapp.model.User;
import net.crudapp.repository.RoleRepository;
import net.crudapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public User getUserByName(String username) {
        return userRepository.getUserByName(username);
    }

    public List<User> allUsers() {
        return this.userRepository.findAll();
    }

    public void saveUser(User user) {
        Set<Role> roleSet = new HashSet<>();
        roleSet.add( roleRepository.getOne(1L));
        user.setRoles(roleSet);
        this.userRepository.save(user);
    }

    public void deleteUser(long id) {
       this.userRepository.deleteById(id);
    }

    public User getUserById(long id) {
        return this.userRepository.getOne(id);
    }

}