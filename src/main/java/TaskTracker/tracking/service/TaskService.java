package TaskTracker.tracking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import TaskTracker.tracking.entity.Task;
import TaskTracker.tracking.repo.TaskRepo;

@Service
public class TaskService {
    
    @Autowired
    private TaskRepo taskRepo;

    public Task saveTask(Task task) {
        return taskRepo.save(task);
    }

    public Optional<Task> fetchTaskById(Long taskId) {
        return taskRepo.findById(taskId);
    }
    
    public List<Task> fetchTaskByStatus(String status){
        return taskRepo.findByStatus(status);
    }

    public List<Task> fetchTasks() {
        return taskRepo.findAll();
    }

    public Task updateTask(Long id, Task task) {
        Task taskupdated = taskRepo.findById(id).get();
        taskupdated.setDueDate(task.getDueDate());
        taskupdated.setStatus(task.getStatus());
        taskupdated.setTaskName(task.getTaskName());
        return taskRepo.save(taskupdated);
    }

    public String deleteTaskById(Long taskId) {
           taskRepo.deleteById(taskId);
           return "Deleted Succesffuly";
    }
}
