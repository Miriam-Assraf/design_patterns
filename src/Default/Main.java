package Default;
import Model.Model;
import View.MainView;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Model model= new Model("Tel-aviv", "Israel"); //Create a new seaport
		model.addShipToPort();
		MainView MainView = new MainView(model, stage);
		Controller controller = new Controller(model,MainView);
	}
}
