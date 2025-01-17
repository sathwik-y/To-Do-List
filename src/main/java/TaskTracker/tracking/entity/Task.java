package TaskTracker.tracking.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    @Id
    @SequenceGenerator(
        name="task_seq",
        sequenceName = "task_seq",
        allocationSize = 1
        
    )
    @GeneratedValue(
        generator = "task_seq",
        strategy = GenerationType.SEQUENCE
    )
    @Column(name="Number")
    private Long taskId;
    @Column(name="Name" , nullable = false)
    private String taskName;
    @Column(name="Due Date")
    private LocalDate dueDate;
    @Column(name="Status" ,nullable = false)
    private String status;

}
