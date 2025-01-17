package TaskTracker.tracking.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import TaskTracker.tracking.entity.Task;
import TaskTracker.tracking.service.TaskService;

@RestController
// @RequestMapping("/mytask")
public class WelcomeController {
    @GetMapping("")
    public String greet(){
        return "Welcome to your Task Tracker Application";
    }
    @Autowired
    private TaskService tasks;
    @PostMapping("/add")
    public Task addTask(@Validated @RequestBody Task task) {
        System.out.println("Adding");
        return tasks.saveTask(task);
    }
    @GetMapping("/tasks")
    public List<Task> getAllTask() {
        return tasks.fetchTasks();
    }
    @GetMapping("/task/{id}")
    public Optional<Task> geTask(@PathVariable("id") Long taskId) {
        return tasks.fetchTaskById(taskId);
    }

    @GetMapping("task/status/{status}")
    public List<Task> getTaskByStatus(String status ) {
        return tasks.fetchTaskByStatus(status);
    }

    @PutMapping("/update/{id}")
    public Task updateTask(@PathVariable("id") Long taskId ,@RequestBody Task task){
        return tasks.updateTask(taskId,task);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTaskById(@PathVariable("id") Long taskId){
        return tasks.deleteTaskById(taskId);
    }
}
