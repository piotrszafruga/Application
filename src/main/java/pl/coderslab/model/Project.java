package pl.coderslab.model;


import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.text.Normalizer;
import java.util.*;

@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Date created;

    @NotNull
    @Size(min = 5, max = 45)
    private String name;

    @Size(max = 445)
    private String description;

    private String webpage;
    private String idFromName;
    private boolean active;

    @ManyToMany //(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private Set<User> users = new HashSet<>();

    @OneToMany(mappedBy = "project")
    private List<Task> tasks = new ArrayList<>();



    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWebpage() {
        return webpage;
    }

    public void setWebpage(String webpage) {
        this.webpage = webpage;
    }

    public String getIdFromName() { return idFromName; }

    public void setIdFromName() {
        System.out.println("");
        System.out.println(this.getName());
        String name = StringUtils.stripAccents(this.getName());
        System.out.println(name);
        this.idFromName = name.replaceAll("\\s+", "_");

//        Normalizer.normalize(this.getName(), Normalizer.Form.NFD)
//                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "");

//        String text = this.getName()
//                .replaceAll("[^a-zA-Z0-9_]", "")
//                .replaceAll("\\s+","_");
//        this.idFromName = text;
    }


    public Set<User> getUsers() { return users; }

    public void setUsers(Set<User> users) { this.users = users; }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<Task> getTasks() { return tasks; }

    public void setTasks(List<Task> tasks) { this.tasks = tasks; }


}
