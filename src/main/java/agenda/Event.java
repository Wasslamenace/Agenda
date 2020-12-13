package agenda;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;


public class Event {

    private String leTitre;
    private LocalDateTime leDebut;
    private Duration laDuree;
    private ArrayList<LocalDateTime> lesjoursEvent = new ArrayList<>();
    protected boolean isInDay = false;
    private LocalDateTime laFin;


    
    public Event(String titre, LocalDateTime debut, Duration duree) {
        this.leTitre = titre;
        this.leDebut = debut;
        this.laDuree = duree;
    }

   
    public boolean isInDay(LocalDate aDay) {
        
       
        int jourDebut = this.leDebut.getDayOfMonth();
        int jourFin = this.getEnd().getDayOfMonth();
        int difference = jourFin - jourDebut;
        
       
        this.lesjoursEvent.add(this.leDebut);
        
        
        for (int i = 1; i <= difference; i++) {
            this.lesjoursEvent.add(this.leDebut.plus(i, ChronoUnit.DAYS));
            System.out.println(this.lesjoursEvent);
        }
        
        
        this.lesjoursEvent.forEach(event -> {
            if (event.toLocalDate().equals(aDay)) {
                this.isInDay = true;
            }
        });
        return this.isInDay;
        
    }
   
   
    public String getleTitre() {
        return leTitre;
    }

   
    public LocalDateTime getleDebut() {
        return leDebut;
    }

    
    public LocalDateTime getEnd(){
        this.laFin = this.leDebut.plus(this.laDuree.toMinutes(), ChronoUnit.MINUTES);
        return this.laFin;
    }
   
    public Duration getDuration() {
        return laDuree;
    }
    
    @Override
    public String toString(){
        return this.leTitre;
    }

   
    
}
