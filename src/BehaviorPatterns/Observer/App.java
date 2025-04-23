package BehaviorPatterns.Observer;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;

abstract class Observable {

    private List<Observer> observerList;

    public Observable() {
        observerList = new ArrayList<>();
    }

    public void ekle(Observer observer){
        observerList.add(observer);
    }

    public void cikar(Observer observer){
        observerList.remove(observer);
    }

    public void haberVer(){
        for (Observer observer : observerList) {
            observer.update(this);
        }
    }
}

class Termometre extends Observable {

    private BigDecimal anlikSicaklik;
    private BigDecimal minSicaklik;
    private BigDecimal maxSicaklik;

    public Termometre(BigDecimal minSicaklik, BigDecimal maxSicaklik) {
        this.minSicaklik = minSicaklik;
        this.maxSicaklik = maxSicaklik;
        this.anlikSicaklik = BigDecimal.valueOf(24);
    }

    public BigDecimal getAnlikSicaklik() {
        return anlikSicaklik;
    }

    public void setAnlikSicaklik(BigDecimal anlikSicaklik) {
        this.anlikSicaklik = anlikSicaklik;

        System.out.println(anlikSicaklik);

        sicakligiKontrolEt();
    }

    private void sicakligiKontrolEt() {

        boolean isCokSicak = anlikSicaklik.compareTo(maxSicaklik) >= 0;
        boolean isCokSoguk = anlikSicaklik.compareTo(minSicaklik) <= 0;

        if (isCokSicak || isCokSoguk){
            haberVer();
        }
    }
}

interface Observer {

    void update(Observable observable);
}

class Ebeveyn implements Observer {

    private String adi;

    public Ebeveyn(String adi) {
        this.adi = adi;
    }

    @Override
    public void update(Observable observable) {

        Termometre termometre = (Termometre) observable;

        System.out.println(adi + " dedi ki: ooo sicaklık " + termometre.getAnlikSicaklik()+
                " derece olmuş!");
    }
}

public class App {

    public static void main(String[] args) {
        BigDecimal minSicaklik = BigDecimal.valueOf(23);
        BigDecimal maxSicaklik = BigDecimal.valueOf(28);

        Termometre termometre = new Termometre(minSicaklik, maxSicaklik);

        Ebeveyn anne = new Ebeveyn("Anne");
        Ebeveyn baba = new Ebeveyn("Baba");


        termometre.ekle(anne);
        termometre.ekle(baba);

        for (int i = termometre.getAnlikSicaklik().intValue(); i <= 30; i++){
            termometre.setAnlikSicaklik(BigDecimal.valueOf(i));
        }

        for (int i = termometre.getAnlikSicaklik().intValue(); i >= 22; i--){
            termometre.setAnlikSicaklik(BigDecimal.valueOf(i));
        }
    }
}