package TaskTracker.tracking.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import TaskTracker.tracking.entity.Task;
import java.util.List;


@Repository
public interface TaskRepo extends JpaRepository<Task,Long>{
    
    public List<Task> findByStatus(String status);
}
