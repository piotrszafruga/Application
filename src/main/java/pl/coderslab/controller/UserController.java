package pl.coderslab.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.model.Project;
import pl.coderslab.model.User;
import pl.coderslab.repository.UserRepository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;



    @GetMapping("/user")
    public String showUsers(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "user/index";
    }

    @GetMapping("/user/add")
    public String prepareAddUser(Model model) {
        model.addAttribute("user", new User());
        return "user/add";
    }

    @PostMapping("user/add")
    public String addUser(@ModelAttribute User user, BindingResult bindingResult) {
        userRepository.save(user);
        return "redirect:/user";
    }

}
