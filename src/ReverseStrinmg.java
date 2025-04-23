public class ReverseStrinmg {
    public static void main(String [] args){
        String name = "Berkin ";
        for(int i = name.length() - 1  ; i >= 0   ; i--){
            System.out.print(name.charAt(i));
        }

        StringBuilder stringBuilder = new StringBuilder(name);
        System.out.println(stringBuilder.reverse());

    }
}