package net.crudapp.controller;

import net.crudapp.model.Role;
import net.crudapp.model.User;
import net.crudapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String allUsers(Model model){
        List<User> usersList = this.userService.allUsers();
        model.addAttribute("usersList", usersList);
        return "user-list";
    }

    @GetMapping("/user-create")
    public String createUserForm(User user, Model model){
        List<Role> roles = this.userService.allRoles();
        model.addAttribute("roles", roles);
        return "user-create";
    }

    @PostMapping("/user-create")
    public String createUser(User user){
        this.userService.saveUser(user);
        return "redirect:/admin/users";
    }

    @GetMapping("/user-delete/{id}")
    public String deleteUser(@PathVariable("id") long id ){
        this.userService.deleteUser(id);
        return "redirect:/admin/users";
    }

    @GetMapping("/user-update/{id}")
    public String updatePage(@PathVariable("id") long id, Model model){
        User user = this.userService.getUserById(id);
        List<Role> roles = this.userService.allRoles();
        model.addAttribute("roles", roles);
        model.addAttribute("user", user);
        return "user-update";
    }

    @PostMapping("/user-update")
    public String userUpdate(User user){
        this.userService.saveUser(user);
        return "redirect:/admin/users";
    }

    @GetMapping("/userData/{id}")
    public String userData(@PathVariable("id") long id, Model model){
        User user = this.userService.getUserById(id);
        model.addAttribute("user", user);
        return "userData";
    }
}
