package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.coderslab.model.Project;

import java.awt.print.Book;
import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    @Query(value = "SELECT * FROM projects WHERE created IS NOT NULL ORDER BY created DESC LIMIT 5", nativeQuery = true)
    List<Project> getFiveProjectsByCreatedDesc();

//    @Query(value = "select b from books b where b.category_id = :category order by b.title limit 1", nativeQuery = true)
//    Book getFirstBookFromCategorySortedByTitle(@Param("category") Category category);

    List<Project> findTwoByOrderByCreatedDesc();

    List<Project> findAll();

    Project findFirstById(Long id);
    Project findFirstByName(String name);

}
