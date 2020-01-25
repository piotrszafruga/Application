package pl.coderslab.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.model.Priority;
import pl.coderslab.repository.PriorityRepository;
import pl.coderslab.repository.StatusRepository;

@Controller
public class PriorityController {

    @Autowired
    private PriorityRepository priorityRepository;



    @GetMapping("/priority")
    public String showUsers(Model model) {
        model.addAttribute("priorities", priorityRepository.findAll());
        return "priority/index";
    }

    @GetMapping("/priority/add")
    public String prepareAddUser(Model model) {
        model.addAttribute("priority", new Priority());
        return "priority/add";
    }

    @PostMapping("priority/add")
    public String addUser(@ModelAttribute Priority priority, BindingResult bindingResult) {
        priorityRepository.save(priority);
        return "redirect:/priority";
    }
}
