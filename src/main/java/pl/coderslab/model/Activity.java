package pl.coderslab.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "activities")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Date happened;

    private String userName;

    private String projectName;

    private long projectId;

    private String taskName;

    private String action;




    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getHappened() {
        return happened;
    }

    public void setHappened(Date happened) {
        this.happened = happened;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getAction() { return action; }

    public void setAction(String type) { this.action = type; }
}
