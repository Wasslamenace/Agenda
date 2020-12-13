package agenda;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;


public class FixedTerminationEvent extends RepetitiveEvent {

    
    
    
    private LocalDate terminationInclusive;
    private long nombreOccurrences = 0;
    
    public FixedTerminationEvent(String title, LocalDateTime start, Duration duration, ChronoUnit frequence, LocalDate terminationInclusive) {
         super(title, start, duration, frequence);
        this.terminationInclusive = terminationInclusive;

    }

  
        public FixedTerminationEvent(String title, LocalDateTime start, Duration duration, ChronoUnit frequency, long numberOfOccurrences) {
        super(title, start, duration, frequency);
        this.nombreOccurrences = numberOfOccurrences;
    }

  
    public LocalDate getTerminationDate() {
        LocalDate fin;
        fin = this.getleDebut().plus(nombreOccurrences-1, this.getFrequence()).toLocalDate();
        return fin;
    }

    public long getNombreOccurrences() {
        LocalDate fin, debut;
        fin = this.terminationInclusive;
        debut = this.getleDebut().toLocalDate();
        

        while(fin.isAfter(debut)){
            this.nombreOccurrences += 1;
            fin = fin.minus(1, this.getFrequence());
        }
        return this.nombreOccurrences;
    }
        
}
