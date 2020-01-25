package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.model.Activity;
import pl.coderslab.model.Priority;
import pl.coderslab.model.Project;

import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {

    @Query(value = "SELECT * FROM activities WHERE happened IS NOT NULL ORDER BY happened DESC LIMIT 25", nativeQuery = true)
    List<Activity> getActivitiesByCreatedDesc();

    List<Activity> findTwentyFiveByOrderByHappenedDesc();
    List<Activity> findTwoByOrderByHappenedDesc();

    List<Activity> findAll();



}
