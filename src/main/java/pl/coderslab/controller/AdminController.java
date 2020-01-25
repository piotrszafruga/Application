package pl.coderslab.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.model.User;
import pl.coderslab.repository.PriorityRepository;
import pl.coderslab.repository.ProjectRepository;
import pl.coderslab.repository.StatusRepository;
import pl.coderslab.repository.UserRepository;

@Controller
public class AdminController {

//    @Autowired
//    private ProjectRepository projectRepository;
//    @Autowired
//    private UserRepository userRepository;
//    @Autowired
//    private StatusRepository statusRepository;
//    @Autowired
//    private PriorityRepository priorityRepository;


    @GetMapping("/admin")
    public String index(Model model) {

//        model.addAttribute("projects", projectRepository.findAll());
//        model.addAttribute("users", userRepository.findAll());
//        model.addAttribute("statuses", statusRepository.findAll());
//        model.addAttribute("priorities", priorityRepository.findAll());

        return "admin/index";
    }

}
