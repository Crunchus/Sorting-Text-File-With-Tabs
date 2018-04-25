public class Main {

    public static void main(String[] args) {

        ViewData viewer = new ViewData();
        InputOutput data = new InputOutput();
        DataController controller = new DataController(viewer, data);

        controller.sortData();
        controller.updateView();
    }
}