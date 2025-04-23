package StructralPattern.Adapter;

interface NaSocket {
    int NaSocket();
}

class EurSocket {

    public int EuSocketVoltage(){
        System.out.println("Eu sockets voltages are 220 votls");
        return 220 ;
    }
}

class NaToEuro extends EurSocket implements NaSocket{

    @Override
    public int NaSocket() {
        int voltage  = EuSocketVoltage();
        return voltage ;
    }
}

class VCR2 {
    public void powerUp(int voltage){
        System.out.println("Powerd Up");
    }
}

public class ClassAdapter {
    public static void main(String [] args ) {

        NaSocket naSocket = new NaToEuro();
        EurSocket eurSocket = new EurSocket();


        int voltage = naSocket.NaSocket();
        VCR2 vcr = new VCR2();
        vcr.powerUp(voltage);

    }
}