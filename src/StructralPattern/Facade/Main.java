package StructralPattern.Facade;

import java.lang.reflect.Member;
import java.util.ArrayList;

class LibraryMember{
    private int id;
    private String name;
    private double debt;
    private ArrayList<Book> books = new ArrayList<>();

    public LibraryMember(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void rentBook(Book book){
        books.add(book);
    }
    public void returnBook(Book book){
        books.remove(book);
    }

    public ArrayList<Book> getBooks() {
        return books;
    }
}

class Book{
    private String name;
    private boolean hasTimeOut;
    private int scheduledHoldingDay;
    private int actualHoldingDay;

    public static double defaultRentingPrice = 0.35;

    public Book(String name, int scheduledHoldingDay, int actualHoldingDay) {
        this.name = name;
        this.scheduledHoldingDay = scheduledHoldingDay;
        this.actualHoldingDay = actualHoldingDay;
    }

    public boolean hasTimeOut() {
        if(scheduledHoldingDay-actualHoldingDay<0){
            return true;
        }
        else {
            return false;
        }
    }

    public int getScheduledHoldingDay() {
        return scheduledHoldingDay;
    }

    public int getActualHoldingDay() {
        return actualHoldingDay;
    }

    public String getName() {
        return name;
    }
}
class BookDebt{

    private LibraryMember member;
    private static double penaltyRate = 0.65;

    public BookDebt(LibraryMember member) {
        this.member = member;
    }
    public double calculateDebt(){

        double debt = 0;

        for(Book book : member.getBooks()){
            if(book.hasTimeOut()){
                debt+= ((book.getActualHoldingDay()*Book.defaultRentingPrice))+((book.getActualHoldingDay()-book.getScheduledHoldingDay())*penaltyRate);
            }
            else{
                debt+=(book.getActualHoldingDay()*Book.defaultRentingPrice);
            }
        }

        return debt;
    }
}

class MembershipDebt{
    //Fields

    public double calculateDebt(){
        //A Complex Algorithm
        return 36.68;
    }
}

class CafeteriaDebt{
    //Fields

    public double calculateDebt(){ //4 Parameter Method
        //A Complex Algorithm
        return 60.0;
    }

}

class ParkDebt{
    //Fields

    public double calculateDebt(){
        //A Complex Algorithm
        return 40.0;
    }
}

class DeptCalculator{ //Facade Class
    private LibraryMember member;
    private BookDebt bookDebt;
    private MembershipDebt membershipDebt;
    private CafeteriaDebt cafeteriaDebt;
    private ParkDebt parkDebt;

    public DeptCalculator(LibraryMember member){
        member = member;
        bookDebt = new BookDebt(member);
        membershipDebt = new MembershipDebt();
        cafeteriaDebt = new CafeteriaDebt();
        parkDebt = new ParkDebt();
    }

    public double calculateTotalDept(){
        double totalDebt = 0;

        totalDebt+=bookDebt.calculateDebt()+membershipDebt.calculateDebt()+
                cafeteriaDebt.calculateDebt()+ parkDebt.calculateDebt();

        return totalDebt;
    }

}

public class Main {

    public static void setMemberBooks(LibraryMember member){
        member.rentBook(new Book("Kuzuların Sessizliği",5,8));
        member.rentBook(new Book("Cinnet",10,10));
        member.rentBook(new Book("Psikiyatrist",14,11));
        member.rentBook(new Book("Cerrah",8,7));
    }

    public static void main(String[] args){ //Client, İstemci

        LibraryMember member = new LibraryMember(1,"Üye245");
        setMemberBooks(member);

        System.out.println("Toplam borç : "+new DeptCalculator(member).calculateTotalDept()); //Facade Object
    }
}