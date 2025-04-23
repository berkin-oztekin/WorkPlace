package StructralPattern.Bridge;


class RemoteControl{
    protected  Device device;

    public RemoteControl(Device device) {
        this.device = device;
    }

    void  togglePower() {
    if (device.isEnabled())
        device.disable();
    else{
        System.out.println("Device already enabled..");
        device.enable();
    }
}

    int  volumeUp(){
        return  device.getVolume() + 10;
    }


}

class AdvancedRemoteControl extends RemoteControl{

    public AdvancedRemoteControl(Device device) {
        super(device);
    }

    void advancedOperation(){
        System.out.println("Advanced remote controller operation...");
    }
}


interface Device {
    boolean isEnabled();
    void enable();
    void disable();
    int getVolume();
}

class Tv implements Device{
    public boolean isEnabled() {
        return  true  ;
    }
    public void enable() {
        System.out.println("TV enabled");
    }
    public void disable() {
        System.out.println("TV disabled");
    }
    public int getVolume() {
        return 0;
    }

}
class Radio implements   Device{

    public boolean isEnabled() {
        return true;
    }
    public void enable() {
        System.out.println("Radio enabled");
    }
    public void disable() {
        System.out.println("Radio disabled");
    }
    public int getVolume() {
        return  0 ;
    }
}

public class Main {
    public static void main(String[] args){
        Device device1 = new Tv();
        Device device2 = new Radio();
        RemoteControl remoteControl = new RemoteControl(device1);
        AdvancedRemoteControl advancedRemoteControl = new AdvancedRemoteControl(device2);

        remoteControl.togglePower();
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*");
        advancedRemoteControl.togglePower();
        advancedRemoteControl.advancedOperation();
    }
}
