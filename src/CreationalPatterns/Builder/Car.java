package CreationalPatterns.Builder;

class Car {
    int seats;
    boolean engine;
    boolean computer;
    boolean gps;

    public int getSeats() {
        return seats;
    }
    public boolean isEngine() {
        return engine;
    }
    public boolean isComputer() {
        return computer;
    }
    public boolean isGps() {
        return gps;
    }
}


class Manuel{
    int seats;
    boolean engine;
    boolean computer;
    boolean gps;

    public int getSeats() {
        return seats;
    }
    public boolean isEngine() {
        return engine;
    }
    public boolean isComputer() {
        return computer;
    }
    public boolean isGps() {
        return gps;
    }
}

interface Builder{
    public void reset();
    public void  setSeats(int number);
    public void setEngine(Boolean engine);
    public void setTripComputer(Boolean computer);
    public void setGPS(Boolean gps);
}

class CarBuilder implements Builder{
    private Car car ;

    public CarBuilder() {
            this.reset();
    }
    public void setCar(Car car) {
        this.car = car;
    }

    public void reset() {
        this.car = new Car();
    }

    @Override
    public void setSeats(int number) {
        car.seats = number;
    }
    @Override
    public void setEngine(Boolean engine) {
        car.engine = engine ;
    }
    @Override
    public void setTripComputer(Boolean computer) {
        car.computer = computer;
    }
    @Override
    public void setGPS(Boolean gps) {
        car.gps = gps;
    }


    public Car getProduct(){
        Car product = this.car;
        this.reset();
        return product ;
    }
}

class CarManualBuilder implements Builder{
    private Manuel manuel ;

    public CarManualBuilder() {
        this.reset();
    }

    @Override
    public void reset() {
        this.manuel = new Manuel();
    }
    @Override
    public void setSeats(int number) {
        manuel.seats = number ;
    }
    @Override
    public void setEngine(Boolean engine) {
        manuel.engine = engine ;
    }
    @Override
    public void setTripComputer(Boolean computer) {
        manuel.computer = computer;
    }

    @Override
    public void setGPS(Boolean gps) {
        manuel.gps = gps;
    }

    public Manuel getProduct(){
        Manuel product = this.manuel;
        this.reset();
        return product ;
    }

}

class Director{

    public void constructSportsCar(Builder builder){
        builder.reset();
        builder.setSeats(2);
        builder.setTripComputer(true);
        builder.setGPS(true);
        builder.setEngine(true);
    }

    public void constructSuvCar(Builder builder){
        builder.reset();
        builder.setEngine(true);
        builder.setSeats(4);
        builder.setTripComputer(true);
        builder.setGPS(true);
    }
}

class Application{
    public static void main(String [] args){
        Director director = new Director();
        CarBuilder builder = new CarBuilder();

        director.constructSportsCar(builder);
        Car car = builder.getProduct();

        System.out.println("Car seats: " + car.getSeats());
        System.out.println("Car has engine: " + car.isEngine());
        System.out.println("Car has computer: " + car.isComputer());
        System.out.println("Car has GPS: " + car.isGps());

        CarManualBuilder builder2 = new CarManualBuilder();
        director.constructSuvCar(builder2);
        Manuel manual = builder2.getProduct();
        System.out.println("****************************");
        System.out.println("ManualCar seats: " + manual.getSeats());
        System.out.println("ManualCar has engine: " + manual.isEngine());
        System.out.println("ManualCar has computer: " + manual.isComputer());
        System.out.println("ManualCar has GPS: " + manual.isGps());

    }
}