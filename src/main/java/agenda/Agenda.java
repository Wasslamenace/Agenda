package agenda;

import agenda.Event;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;


public class Agenda {
   
    private ArrayList<Event> lesEvenements = new ArrayList<>();
    private ArrayList<Event> lesEvenementsPourUnJour = new ArrayList<>();
    private ArrayList<Event> lesEvenementsParTitre = new ArrayList<>();
    private boolean estlibre = false;
    
    
    public void addEvent(Event e) {
        this.lesEvenements.add(e);
    }

    public List<Event> eventsInDay(LocalDate day) {
        this.lesEvenements.forEach((e) -> {
            if (e.isInDay(day)) {
                this.lesEvenementsPourUnJour.add(e);
            }
        });
        return this.lesEvenementsPourUnJour;
    }
    
   
    public List<Event> findByTitle(String title) {
        this.lesEvenements.forEach((e) -> {
            if (e.getleTitre().equals(title)) {
                this.lesEvenementsParTitre.add(e);
            }
        });
        return this.lesEvenementsParTitre;
    }
    
   
    public boolean isFreeFor(Event e) {
        LocalDate jourEvenement;
        jourEvenement = e.getleDebut().toLocalDate();
        LocalDateTime debut = e.getleDebut();
        LocalDateTime fin = e.getEnd();
        
        
        this.eventsInDay(jourEvenement).forEach((evenement) -> {
            if (debut.isAfter(evenement.getEnd()) || fin.isBefore(evenement.getleDebut())) {
                this.estlibre = true;            
            }
        });
        return this.estlibre;
    }
}
