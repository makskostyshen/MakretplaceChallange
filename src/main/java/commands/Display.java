package commands;

import java.util.Collection;

public class Display {

    public void display(Collection collection){
        for(Object object: collection){
            System.out.println(object);
        }
        System.out.println();
    }


    public void display(String line){
        System.out.println(line);
        System.out.println();
    }
}
