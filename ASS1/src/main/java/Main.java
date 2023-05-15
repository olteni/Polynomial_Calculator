import Controller.Controller;
import View.View;

public class Main {

    public static void main(String[] args) {
        View view = new View();
        Controller controller = new Controller(view);
        view.addController(controller);
    }
}