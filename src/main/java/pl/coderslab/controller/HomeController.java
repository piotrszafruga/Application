package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.model.Activity;
import pl.coderslab.model.Project;
import pl.coderslab.repository.ActivityRepository;
import pl.coderslab.repository.ProjectRepository;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ActivityRepository activityRepository;


    @GetMapping("/")
    public String index(Model model) {

//        model.addAttribute("latestProjects", projectRepository.findFirstFiveByOrderByCreatedDesc());
        List<Activity> activities = activityRepository.getActivitiesByCreatedDesc();

        model.addAttribute("latestProjects", projectRepository.getFiveProjectsByCreatedDesc());
        model.addAttribute("latestActivities", activities);


        return "index";
    }
}
