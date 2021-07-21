package arsss_01.test.kcell.entities;
import arsss_01.test.kcell.dto.TaskStatus;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class ReminderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String note;
    private LocalDate date;
    @Enumerated(EnumType.STRING)
    private TaskStatus status;
}
