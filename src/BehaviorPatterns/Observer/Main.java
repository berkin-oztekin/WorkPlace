package BehaviorPatterns.Observer;

import java.util.ArrayList;

class EventManager{
    ArrayList<EventListeners> listeners ;

    public EventManager() {
        listeners = new ArrayList<>();
    }

    public void subscribe(EventListeners listener){
        listeners.add(listener);
    }

    public void unsubscribe(EventListeners listener){
        listeners.remove(listener);
    }

    public void notify1(){
        for(EventListeners listener : listeners)
            listener.update(this);
    }

}

class Editor extends  EventManager{
    boolean openCLose ;

    public Editor() {
        this.openCLose = false;
    }

    void openFile(){
        openCLose = true;
        controlFile();
    }
    void closeFile(){
        System.out.println("File closed");
        openCLose = false ;
    }

    void controlFile(){
        if (openCLose == true)
            notify1();
    }
}


interface EventListeners{

    void update(EventManager manager);
}

class EmailAlertsListener implements  EventListeners{

    private String name ;

    public EmailAlertsListener(String name) {
        this.name = name;
    }

    @Override
    public void update(EventManager manager) {
        Editor manager1 = (Editor) manager;
        System.out.println(manager1 + "file already open please close it While program running");
    }
}
class LoggingAlertsListener implements  EventListeners{

    private String name ;

    public LoggingAlertsListener(String name) {
        this.name = name;
    }

    @Override
    public void update(EventManager manager) {
        Editor manager1 = (Editor) manager;
        System.out.println(manager1 + "file already open please close it While program running");
    }
}

public class Main {
    public static void main(String  [] args){
        Editor editor = new Editor();
        LoggingAlertsListener loggingAlertsListener = new LoggingAlertsListener("Google Logger");
        editor.subscribe(loggingAlertsListener);
        editor.openFile();



    }
}
