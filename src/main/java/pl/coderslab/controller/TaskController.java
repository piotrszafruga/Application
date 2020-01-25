package pl.coderslab.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.*;
import pl.coderslab.repository.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private StatusRepository statusRepository;
    @Autowired
    private PriorityRepository priorityRepository;



    @ModelAttribute("projects")
    public List<Project> getAllProjects() { return projectRepository.findAll(); }
    @ModelAttribute("statuses")
    public List<Status> getAllActiveStatuses() { return statusRepository.findAllByActive(true); }
    @ModelAttribute("priorities")
    public List<Priority> getAllActivePriorities() { return priorityRepository.findAllByActive(true); }



    @GetMapping("/task/add/{projectId}")
    public String prepareAddTask(Model model, @PathVariable long projectId) {
        model.addAttribute("task", new Task());
        model.addAttribute("project", projectRepository.findFirstById(projectId));
        return "task/add";
    }

    @PostMapping("/task/add/{projectId}")
    public String addTask(Model model, @ModelAttribute Task task, BindingResult bindingResult1, @PathVariable long projectId) {

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        task.setCreated(date);

        Project project = projectRepository.findFirstById(projectId);
        task.setProject(project);
        taskRepository.save(task);

        model.addAttribute("projectId", projectId);
        model.addAttribute("tasks", project.getTasks());
        return "project/tasks";
    }


    @GetMapping("/task/details/{id}")
    public String showTaskDetails(Model model, @PathVariable long id) {
        model.addAttribute("task", taskRepository.findFirstById(id));
        return "/task/details";
    }

    @GetMapping("/task/edit/{projectId}/{taskId}")
    public String prepareEditTask(Model model, @PathVariable long projectId, @PathVariable long taskId) {
        Task task = taskRepository.findFirstById(taskId);
        model.addAttribute("task", task);
        model.addAttribute("topic", task.getTopic());
        return "task/edit";
    }

    @PostMapping("/task/edit/{projectId}/{taskId}")
    public String editTask(Model model, @ModelAttribute Task task, BindingResult bindingResult,
                           @PathVariable long projectId, @PathVariable long taskId) {

        Project project = projectRepository.findFirstById(projectId);
        task.setId(taskId);
        task.setProject(project);
        taskRepository.save(task);

        project = projectRepository.findFirstById(projectId);
        model.addAttribute("projectId", projectId);
        model.addAttribute("tasks", project.getTasks());
        return "project/tasks";
    }

    @GetMapping("/task/delete/{projectId}/{taskId}")
    public String deleteTask(Model model, @PathVariable long projectId, @PathVariable long taskId) {
        taskRepository.delete(taskRepository.findFirstById(taskId));

        Project project = projectRepository.findFirstById(projectId);
        model.addAttribute("projectId", projectId);
        model.addAttribute("tasks", project.getTasks());
//        return "redirect:/project";
        return "project/tasks";
    }
}
