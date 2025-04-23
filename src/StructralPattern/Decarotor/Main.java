package StructralPattern.Decarotor;

import java.util.ArrayList;
import java.util.List;

interface ICar {
    double calculatePrice();
    List<Package> getComponents();
}

class BasicCar implements ICar {

    private String brand;
    protected double price;

    public BasicCar(String brand, double price) {
        this.brand = brand;
        this.price = price;
    }

    @Override
    public double calculatePrice() {
        return price;
    }

    @Override
    public List<Package> getComponents() {
        return new ArrayList<Package>();
    }

}

abstract class Package implements ICar {
    private String name;
    protected ICar car;
    protected double price;

    private List<Package> componentList = new ArrayList<>();

    public Package(String name, ICar car, double price) {
        this.name = name;
        this.car = car;
        this.price = price;
        componentList.add(this);
    }

    @Override
    public double calculatePrice() {
        return car.calculatePrice() + price;
    }

    @Override
    public List<Package> getComponents() {
        List<Package> currentComponentList = car.getComponents();
        currentComponentList.add(this);
        return currentComponentList;
    }

    @Override
    public String toString() {
        return name;
    }

    //Getter&Setter Methods;
}

class Sunroof extends Package {
    public Sunroof(ICar car, double price) {
        super("Sunroof", car, price);
    }

}

class RainSensor extends Package {
    public RainSensor(ICar car, double price) {
        super("Yağmur Sensörü",car, price);
    }

}

class CruiseControl extends Package {
    public CruiseControl(ICar car, double price) {
        super("Hız Sabitleyici", car, price);
    }
}

class TripComputer extends Package {

    public TripComputer(ICar car, double price) {
        super("Yol Bilgisayarı", car, price);
    }
}

class CarProvider {

    private ICar car;
    private String brand;

    public void createBMW(boolean hasSunroof, boolean hasRainSensor, boolean hasCruiseControl, boolean hasTripComputer) {
        brand = "BMW";
        car = new BasicCar(brand, 685000.0);
        addExtras(hasSunroof, hasRainSensor, hasCruiseControl, hasTripComputer);
        showCarInfo(brand);
    }

    public void createAudi(boolean hasSunroof, boolean hasRainSensor, boolean hasCruiseControl, boolean hasTripComputer) {
        brand = "Audi";
        car = new BasicCar(brand, 720000.0);
        addExtras(hasSunroof, hasRainSensor, hasCruiseControl, hasTripComputer);
        showCarInfo(brand);
    }

    public void createMercedes(boolean hasSunroof, boolean hasRainSensor, boolean hasCruiseControl, boolean hasTripComputer) {
        brand = "Mercedes";
        car = new BasicCar(brand, 700000.0);
        addExtras(hasSunroof, hasRainSensor, hasCruiseControl, hasTripComputer);
        showCarInfo(brand);
    }

    private void addExtras(boolean hasSunroof, boolean hasRainSensor, boolean hasCruiseControl, boolean hasTripComputer) {
        if (hasSunroof) {
            car = new Sunroof(car, 12000.0);
        }
        if (hasRainSensor) {
            car = new RainSensor(car, 8000.0);
        }
        if (hasCruiseControl) {
            car = new CruiseControl(car, 18000.0);
        }
        if (hasTripComputer) {
            car = new TripComputer(car, 16000.0);
        }
    }

    public void showCarInfo(String brand) {
        System.out.println("Marka : "+brand);
        System.out.println("Bulunan Özellikler;");
        for(Package component : car.getComponents()){
            System.out.println("  -"+component);
        }
        System.out.println("Fiyat : " + car.calculatePrice());
    }
}

public class Main {
    public static void main(String[] args) {

        CarProvider carProvider = new CarProvider();

        carProvider.createBMW(true, false, true, true);
        System.out.println("--");
        carProvider.createAudi(false, false, false, false);
        System.out.println("--");
        carProvider.createMercedes(true, true, true, true);

    }
}