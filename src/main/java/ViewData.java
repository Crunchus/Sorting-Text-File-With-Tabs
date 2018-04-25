//View

import java.util.ArrayList;

public class ViewData {

    public void displayInput(ArrayList<String> input){
        for(String inLines : input){
            System.out.println(inLines);
        }
    }

    public void displayOutput(ArrayList<String> output){
        for(String outLines : output){
            System.out.println(outLines);
        }
    }

}
