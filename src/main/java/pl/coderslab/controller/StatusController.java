package pl.coderslab.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.model.Status;
import pl.coderslab.model.User;
import pl.coderslab.repository.StatusRepository;

@Controller
public class StatusController {

    @Autowired
    private StatusRepository statusRepository;



    @GetMapping("/status")
    public String showUsers(Model model) {
        model.addAttribute("statuses", statusRepository.findAll());
        return "status/index";
    }

    @GetMapping("/status/add")
    public String prepareAddUser(Model model) {
        model.addAttribute("status", new Status());
        return "status/add";
    }

    @PostMapping("status/add")
    public String addUser(@ModelAttribute Status status, BindingResult bindingResult) {
        statusRepository.save(status);
        return "redirect:/status";
    }
}
