package agenda;

import java.util.*;
import java.time.*;
import java.time.temporal.ChronoUnit;


public class RepetitiveEvent extends Event {

    
    private final ChronoUnit frequence;
    private ArrayList<LocalDate> lesjoursExceptionnels = new ArrayList<>();

    public RepetitiveEvent(String title, LocalDateTime start, Duration duration, ChronoUnit frequence) {
        super(title, start, duration);
        this.frequence = frequence;
    }

   
    public void addException(LocalDate date) {
        this.lesjoursExceptionnels.add(date);
    }

    
    public ChronoUnit getFrequence() {
        return this.frequence;
    }

    @Override
    public boolean isInDay(LocalDate aDay) {
        LocalDate dateTest;
        dateTest = this.getleDebut().toLocalDate();

        
        while (aDay.isAfter(dateTest) || aDay.equals(dateTest)) {
            if (aDay.isEqual(dateTest)) {
                this.isInDay = true;
            }
            dateTest = dateTest.plus(1, frequence);
        }
        
        
        this.lesjoursExceptionnels.forEach((j) -> {
            if (aDay.isEqual(j)) {
                this.isInDay = false;
            }
        });
        return this.isInDay;
    }
}
