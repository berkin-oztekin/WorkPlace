package StructralPattern.Composite;
import java.util.ArrayList;

class PrimElem2 extends DrawingElement{
    private String name ;

    public PrimElem2(String name) {
        this.name = name;
    }

    public void Display(int ident) {
        for(int i = 0 ; i <= ident ; i++){
            System.out.print("-");
            System.out.println(" " + name);
        }
    }


    public String getName() {
        return name;
    }

}
class PrimitiveElement extends DrawingElement {
    private String name ;

    public PrimitiveElement(String name) {
        this.name = name;
    }

    public void Display(int ident) {
        for(int i = 0 ; i <= ident ; i++){
            System.out.print("-");
            System.out.println(" " + name);
        }
    }

    public String getName() {
        return name;
    }
}
abstract class DrawingElement {
    public void Add(DrawingElement d){
        throw new UnsupportedOperationException();
    }
    public void Display(int ident){
        throw new UnsupportedOperationException();
    }
    public String getName(){
        throw new UnsupportedOperationException();
    }
    public void Remove(DrawingElement d){
        throw new UnsupportedOperationException();
    }
    public int getChild (int i){
        throw new UnsupportedOperationException();
    }

}

class CompositeElement extends DrawingElement{
    private String name ;
    PrimElem2 primElem2;

    private ArrayList<DrawingElement> elements = new ArrayList<DrawingElement>();



    public CompositeElement(String name) {
        this.name = name;

    }

    public void Add(DrawingElement d) {
        if(d == primElem2)
            System.out.println("We cant this primitive element");
        else
            elements.add(d);
    }

    public void Remove(DrawingElement d) {
        for(int i = 0 ; i <elements.size() ; i++) {
            if(elements.get(i).getName().equals(d.getName())){
                elements.remove(i);
                return ;
            }
        }
    }

    public void Display(int indent) {
        for(int i = 1 ; i < elements.size() ; i++ ){
            System.out.print("-");
            System.out.println("+" + getChild(i));
        }
        for(int i = 0 ; i < elements.size() ; i++){
            elements.get(i).Display(indent+2);
        }
    }

    public String getName() {
        return name;
    }
    public int getChild(int i ){
        return i ;
    }
}
public class Client {
    public static void main(String [] args){
        CompositeElement root = new CompositeElement("Picture");
        root.Add(new PrimitiveElement("Red Line"));
        root.Add(new PrimitiveElement("Blue Circle"));
        root.Add(new PrimitiveElement("Green Box"));


        CompositeElement comp = new CompositeElement("Two Circles");
        comp.Add(new PrimitiveElement("Blue Circle"));
        comp.Add(new PrimitiveElement("Red Circle"));
        root.Add(comp);



       /* PrimElem2 pe2 = new PrimElem2("BrownLine");
        pe2.Add(new PrimitiveElement("DASDAF"));  // Safety

        */
        root.Remove(new PrimitiveElement("Two Circles"));
       root.Display(1);
    }

}
