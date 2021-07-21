package arsss_01.test.kcell.services;

import arsss_01.test.kcell.dto.ReminderDto;
import arsss_01.test.kcell.dto.TaskStatus;
import arsss_01.test.kcell.entities.ReminderEntity;
import arsss_01.test.kcell.repos.ReminderRero;
import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.OptionalDataException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReminderService {

    private final ModelMapper modelMapper;
    private final ReminderRero reminderRero;
    private final Logger log = Logger.getLogger(ReminderService.class);

    public ReminderService(ReminderRero reminderRero, ModelMapper modelMapper) {
        this.reminderRero = reminderRero;
        this.modelMapper = modelMapper;
    }

    public void addReminder(ReminderDto reminderDto) {
        try {
            reminderDto.setStatus(TaskStatus.ACTIVE);
            reminderRero.save(modelMapper.map(reminderDto, ReminderEntity.class));
        } catch (RuntimeException ex) {
            log.error("An error has occurred!");
        }
    }


    public void updateReminder(ReminderDto reminderDto) {
        Long id = reminderDto.getId();

        try {
            reminderRero.save(modelMapper.map(reminderDto, ReminderEntity.class));
        }catch (RuntimeException ex){
            log.error("Nothing found!");
            throw new RuntimeException(ex);
        }
    }

    public List<ReminderDto> getRemindersAll() {
        try {
            List<ReminderDto> reminderDtos = new ArrayList<>();
            reminderRero.findAll().forEach(reminderEntity -> {
                reminderDtos.add(modelMapper.map(reminderEntity, ReminderDto.class));
            });
            return reminderDtos;
        } catch (RuntimeException ex) {
            log.error("Nothing matched your request!");
            throw new RuntimeException(ex);
        }
    }

    public ReminderDto getReminderById(Long id) {
        try {
            Optional<ReminderEntity> reminderEntity = reminderRero.findById(id);
            return modelMapper.map(reminderEntity.get(), ReminderDto.class);
        } catch (RuntimeException ex) {
            log.error("Nothing matched your request!");
            throw new RuntimeException(ex);
        }
    }

    public void deleteReminderById(Long id) {
        try {
            reminderRero.deleteById(id);
        } catch (RuntimeException ex) {
            log.error("An error has occurred!");
        }
    }

    public List<ReminderDto> getRemindersByDate(String date) {

        LocalDate localDate = LocalDate.parse(date);

        List<ReminderDto> reminderDtos = new ArrayList<>();
        List<ReminderEntity> reminderEntities = reminderRero.findByDate(localDate);

        try {
            reminderEntities.forEach(reminderEntity1 -> {
                reminderDtos.add(modelMapper.map(reminderEntity1, ReminderDto.class));
            });

            return reminderDtos;
        } catch (RuntimeException ex){
            log.error("Nothing matched your request!");
            throw new RuntimeException(ex);
        }
    }

}
