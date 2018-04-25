//Controller

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class DataController {

    private ViewData dataViewer;
    private InputOutput inOut;

    public DataController(ViewData dataViewer, InputOutput inOut) {
        this.dataViewer = dataViewer;
        this.inOut = inOut;
    }

    public void sortData(){
        inOut.setInput();
        Sorting sorting = new Sorting(inOut.getInput());
        sorting.bubbleSort();
        ArrayList<String> sortedData = sorting.getToBeSorted();
        Path outputPath = Paths.get("", "output.txt");
        try {
            Files.write(outputPath, sortedData, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateView(){
        inOut.setInput();
        System.out.println("\nInput data");
        dataViewer.displayInput(inOut.getInput());
        inOut.setOutput();
        System.out.println("\nOutput data");
        dataViewer.displayOutput(inOut.getOutput());
    }

}
