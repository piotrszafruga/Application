package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    Task findFirstById(Long id);
}
