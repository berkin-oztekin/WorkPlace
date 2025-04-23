public class PassByValue {

    static int x  = 5;

    static void Arttır(int x){
        System.out.println(++x );
    }

    public static void main(String [] args){

        Arttır(x);
        System.out.println(x);
    }
}
