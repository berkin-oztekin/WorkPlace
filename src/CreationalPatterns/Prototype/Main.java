package CreationalPatterns.Prototype;

class Soldier implements Cloneable {

    private int health;
    private int speed;
    private int maxLifeTime;
    private int agility;
    private int power;
    private int rank;

    private String weapon;

    private boolean isAvailableForWar;

    public Soldier(int health, int speed, int maxLifeTime, int agility, int power, int rank, String weapon, boolean isAvailableForWar) {
        this.health = health;
        this.speed = speed;
        this.maxLifeTime = maxLifeTime;
        this.agility = agility;
        this.power = power;
        this.rank = rank;
        this.weapon = weapon;
        this.isAvailableForWar = isAvailableForWar;
    }

    public void showSoldierInfo(){
        System.out.println("Sağlık : "+health);
        System.out.println("Hız : "+speed);
        System.out.println("Yaşam Süresi : "+maxLifeTime);
        System.out.println("Çeviklik : "+agility);
        System.out.println("Güç : "+power);
        System.out.println("Rütbe : "+rank);
        System.out.println("Silah : "+weapon);
        if(isAvailableForWar){
            System.out.println("Savaşmaya hazır!");
        }
        else{
            System.out.println("Bu asker savaşamaz!");
        }
    }


    @Override
    public Soldier clone() {

        Soldier soldier = null;

        try {
            soldier = (Soldier) super.clone();
        }
        catch (CloneNotSupportedException e) {
            System.out.println("Asker kopyalama sırasında bir hata yaşandı!");
            e.printStackTrace();
        }

        return soldier;

    }

    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public int getMaxLifeTime() {
        return maxLifeTime;
    }
    public void setMaxLifeTime(int maxLifeTime) {
        this.maxLifeTime = maxLifeTime;
    }
    public int getAgility() {
        return agility;
    }
    public void setAgility(int agility) {
        this.agility = agility;
    }
    public int getPower() {
        return power;
    }
    public void setPower(int power) {
        this.power = power;
    }
    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
    public String getWeapon() {
        return weapon;
    }
    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }
    public boolean isAvailableForWar() {
        return isAvailableForWar;
    }

    public void setAvailableForWar(boolean availableForWar) {
        isAvailableForWar = availableForWar;
    }
/*
    Getter/Setter Metotlar;
    .
    ..
    ...
     */

}
public class Main {
    public static void main(String[] args){

        Soldier availableSoldier = new Soldier(100,45,20,50,60,5,"Kılıç",true);

        Soldier notAvailableSoldier = availableSoldier.clone();
        notAvailableSoldier.setAvailableForWar(false);

        availableSoldier.showSoldierInfo();
        System.out.println("--");
        notAvailableSoldier.showSoldierInfo();
    }
}

