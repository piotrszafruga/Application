package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.model.Activity;
import pl.coderslab.model.Container;
import pl.coderslab.model.Project;
import pl.coderslab.model.User;
import pl.coderslab.repository.ActivityRepository;
import pl.coderslab.repository.ProjectRepository;
import pl.coderslab.repository.UserRepository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ActivityRepository activityRepository;



    @ModelAttribute("users")
    public List<User> getAllUsers() { return userRepository.findAll(); }



    @GetMapping("/project")
    public String showProjects(Model model) {
        model.addAttribute("projects", projectRepository.findAll());
        return "project/index";
    }

    @GetMapping("/project/add")
    public String prepareAddProject(Model model) {
        model.addAttribute("project", new Project());
        return "project/add";
    }

    @PostMapping("project/add")
    public String addProject(@ModelAttribute Project project, BindingResult bindingResult) {

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        project.setCreated(date);
        project.setIdFromName();
        projectRepository.save(project);

        Activity activity = new Activity();
        activity.setHappened(date);
        activity.setProjectName(project.getName());
        activity.setAction("Create project");
        Project createdProject = projectRepository.findFirstByName(project.getName());
        activity.setProjectId(createdProject.getId());
        activityRepository.save(activity);

        return "redirect:/project";
    }



    @GetMapping("/project/tasks/{id}")
    public String showProjectTasks(Model model, @PathVariable long id) {
        model.addAttribute("projectId", id);
        model.addAttribute("tasks", projectRepository.findFirstById(id).getTasks());
        return "project/tasks";
    }

    @GetMapping("/project/details/{id}")
    public String showProjectDetails(Model model, @PathVariable long id) {
        model.addAttribute("project", projectRepository.findFirstById(id));
        return "project/details";
    }

    @GetMapping("/project/edit/{id}")
    public String prepareEditProject(Model model, @PathVariable long id) {
        model.addAttribute("project", projectRepository.findById(id).get());
        return "project/edit";
    }

    @PostMapping("project/edit/{id}")
    public String editProject(@ModelAttribute Project project, @PathVariable long id, BindingResult bindingResult) {
        project.setIdFromName();
        projectRepository.save(project);
        return "redirect:/project";
    }



}
