package arsss_01.test.kcell.dto;
import lombok.Data;
import java.time.LocalDate;

@Data
public class ReminderDto {
    private Long id;
    private String name;
    private String note;
    private LocalDate date;
    private TaskStatus status;
}
