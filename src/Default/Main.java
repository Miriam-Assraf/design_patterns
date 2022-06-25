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
		Model model= new Model(); 
		model.createPort("Tel-Aviv Port", "Israel");
		//MainView MainView = new MainView(model.getPortByName("Tel-Aviv Port"), stage);
		//Controller controller = new Controller(model.getPortByName("Tel-Aviv Port"), MainView);
	}
}
