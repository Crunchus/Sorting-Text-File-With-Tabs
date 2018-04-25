import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.*;

public class Sorting {

    private ArrayList<String> toBeSorted;

    public Sorting(ArrayList<String> unsorted){
        this.toBeSorted = unsorted;
    }

    public ArrayList<String> getToBeSorted() {
        return toBeSorted;
    }

    public void bubbleSort(){
       int counter = (toBeSorted.size() - 1);
       while(counter > 0){
           int index = 0;
           while(index < counter){
               String line1 = toBeSorted.get(index);
               String line2 = toBeSorted.get(index+1);
               int comparison = compareTwoLines(line1, line2);
               if(comparison > 0){
                   toBeSorted.set(index, line2);
                   toBeSorted.set((index + 1), line1);
               }
               index++;
           }
           counter--;
       }
    }

    public int compareTwoLines(String s1, String s2){
        int result = 0;
        String[] s1Split = s1.split("\t");
        String[] s2Split = s2.split("\t");
        int shorterStringLength = 0;
        int shorterStringIndex = -1;
        if(s1Split.length > s2Split.length){
            shorterStringLength = s2Split.length;
            shorterStringIndex = 2;
        } else if(s1Split.length < s2Split.length){
            shorterStringLength = s1Split.length;
            shorterStringIndex = 1;
        } else if(s1Split.length == s2Split.length){
            shorterStringLength = s1Split.length;
            shorterStringIndex = 0;
        }
        int comp = 0;
        for(int counter = 0; counter < shorterStringLength; counter++){
            if(isNumeric(s1Split[counter]) && isNumeric(s2Split[counter])){
                Double s11 = Double.valueOf(s1Split[counter]);
                Double s22 = Double.valueOf(s2Split[counter]);
                comp = s11.compareTo(s22);
            } else if(isNumeric(s1Split[counter]) && !isNumeric(s2Split[counter])){
                comp = -1;
            } else if(!isNumeric(s1Split[counter]) && isNumeric(s2Split[counter])){
                comp = 1;
            } else if(!isNumeric(s1Split[counter]) && !isNumeric(s2Split[counter])){
                comp = s1Split[counter].compareToIgnoreCase(s2Split[counter]);
            }
            if(comp != 0){
                result = comp;
                break;
            }
            if(counter == (shorterStringLength - 1) && shorterStringIndex == 0){
                result = 0;
            } else if(counter == (shorterStringLength - 1) && shorterStringIndex == 1){
                result = -1;
            } else if(counter == (shorterStringLength - 1) && shorterStringIndex == 2){
                result = 1;
            }
        }
        return result;
    }

    public boolean isNumeric(String str)
    {
        NumberFormat formatter = NumberFormat.getInstance();
        ParsePosition pos = new ParsePosition(0);
        formatter.parse(str, pos);
        return str.length() == pos.getIndex();
    }
}
