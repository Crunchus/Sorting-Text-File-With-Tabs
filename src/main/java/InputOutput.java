//Model

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class InputOutput {

    private ArrayList<String> input;
    private ArrayList<String> output;

    public void setInput(){
        Path inputPath = Paths.get("", "input.txt");
        try {
            this.input = new ArrayList<String>(Files.readAllLines(inputPath, StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setOutput() {
        Path outputPath = Paths.get("", "output.txt");
        try {
            this.output = new ArrayList<String>(Files.readAllLines(outputPath, StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getInput() {
        return input;
    }

    public ArrayList<String> getOutput() {
        return output;
    }
}
