package arsss_01.test.kcell.controllers;

import arsss_01.test.kcell.dto.ReminderDto;
import arsss_01.test.kcell.services.ReminderService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/note")
public class ReminderController {

    private final ReminderService reminderService;

    public ReminderController(ReminderService reminderService) {
        this.reminderService = reminderService;
    }

    @PostMapping("/add")
    public void addReminder(@RequestBody ReminderDto reminderDto) {
        reminderService.addReminder(reminderDto);
    }

    @PutMapping("/update")
    public void updateReminder(@RequestBody ReminderDto reminderDto) {
        reminderService.updateReminder(reminderDto);
    }

    @GetMapping
    public List<ReminderDto> getReminderAll() {
        return reminderService.getRemindersAll();
    }

    @GetMapping("/date/{date}")
    public List<ReminderDto> getReminderByDate(@PathVariable String date) {
        return reminderService.getRemindersByDate(date);
    }

    @GetMapping("/id/{id}")
    public ReminderDto getReminderById(@PathVariable Long id) {
        return reminderService.getReminderById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteReminderById(@PathVariable Long id) {
        reminderService.deleteReminderById(id);
    }


}
