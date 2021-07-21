package arsss_01.test.kcell.repos;

import arsss_01.test.kcell.entities.ReminderEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface ReminderRero extends CrudRepository <ReminderEntity, Long> {
    List<ReminderEntity> findByDate(LocalDate date);

}
