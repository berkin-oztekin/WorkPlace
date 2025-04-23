package Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.sql.DriverManager.println;
class Person{
    String name ;
    int id ;
    String place ;

    public Person(int id , String name, String place) {
        this.name = name;
        this.id = id;
        this.place = place;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
public class Main {

    public static void main(String [] args){

        Person person = new Person(13 ,"Mehmet" , "Komutan" );
/*
        Personel personel1 = new Personel("Batu" ,2);
        Personel personel2 = new Personel("Barış" ,3);
        Personel personel3 = new Personel("Keiran" ,4);
        Personel personel4 = new Personel("Messi" ,5);

    ArrayList<Personel> personel = new ArrayList<>();
    personel.add(personel1);
    personel.add(personel2);
    personel.add(personel3);
    personel.add(personel4);


      List<String> List = personel.stream()
              .map(Personel::getName)
              .filter(ad->ad.startsWith("B"))
              .limit(5)
              .collect(Collectors.toList());

        System.out.println(List);



        List<String> europeanCountries = Arrays.asList("Almanya", "Avusturya", "Belçika", "Bulgaristan");
        List<String> africanCountries = Arrays.asList("Ethiopia", "Tanzania", "Kenya", "Sudan");
        List<String> asianCountries = Arrays.asList("Japonya", "Çin", "Hindistan", "Kore");

        List<List<String>> allCountries = new ArrayList<>();
        allCountries.add(europeanCountries);
        allCountries.add(africanCountries);
        allCountries.add(asianCountries);

        System.out.println(allCountries);

        List<String> allCountriesAsFlat = allCountries.stream().flatMap(country -> country.stream()).collect(Collectors.toList());

        System.out.println(allCountriesAsFlat);


 */


        List<List<Person>> personList = Arrays.asList(
                Arrays.asList(
                        new Person(1, "Metin", "Aln"),
                        new Person(2, "Kağan", "Aln"),
                        new Person(3, "Yusuf", "Aln"),
                        new Person(4, "Dilek", "Aln")
                ),
                Arrays.asList(
                        new Person(5, "Ahmet", "Davut"),
                        new Person(6, "Rıza", "Özkök"),
                        new Person(7, "Ali", "Can"),
                        new Person(8, "Ayşe", "Nur")
                ),
                Arrays.asList(
                        new Person(9, "Enver", "Akça"),
                        new Person(10, "Kağan", "Korkmaz"),
                        new Person(11, "Yusuf", "Sönmez"),
                        new Person(12, "Yılmaz", "Aln")
                )
        );

/*
        List<Integer> allIds = personList.stream()
                .flatMap(persons -> persons.stream())
                .map(person -> person.getId())
                .collect(Collectors.toList());

        System.out.println(allIds);

 */

    }
/*
    public static void isPerson(  persons){
        if(persons instanceof   Person)
            System.out.println("Person class mensubu");
        else
            System.out.println("Person class mensubu değil");
    }

 */
}
