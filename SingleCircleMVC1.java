
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class SingleCircleMVC1 extends Application {

	private CircleModel1 model = new CircleModel1();

	/** Shows the controller window */
	public void showController() {
		Stage stageController = new Stage();
		CircleController1 controller = new CircleController1();
		controller.setModel(model);
		Scene scene = new Scene(controller, 250, 150);

		stageController.setTitle("Controller"); // Set the stage title
		stageController.setScene(scene); // Place the scene in the stage
		stageController.setAlwaysOnTop(true);
		stageController.setOnCloseRequest(e -> e.consume());
		stageController.setResizable(false);
		stageController.setX(200);
		stageController.setY(200);
		stageController.show(); // Display the stage
	}

	/** Shows the view window */
	public void showView() {
		Stage stageView = new Stage();
		CircleView1 view = new CircleView1();
		view.setModel(model);

		Scene scene = new Scene(view, 500, 200);

		stageView.setTitle("View"); // Set the stage title
		stageView.setScene(scene); // Place the scene in the stage
		stageView.setAlwaysOnTop(true);
		stageView.setOnCloseRequest(e -> e.consume());
		stageView.setX(300);
		stageView.setY(300);
		stageView.show(); // Display the stage
	}

	public static void main(String[] args) {
		launch(args);
	}

	
	/** Shows the initial window */
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Button jbtController = new Button("Show Controller");
		Button jbtView = new Button("     Show View     ");
		HBox hbox = new HBox(20, jbtController, jbtView);
		hbox.setAlignment(Pos.CENTER);
		hbox.setPadding(new Insets(20));
		jbtController.setOnAction(e -> showController());
		jbtView.setOnAction(e -> showView());

		Scene scene = new Scene(hbox, 400, 70);
		primaryStage.setOnCloseRequest(e -> Platform.exit());
		primaryStage.setTitle("SingleCircleMvc1"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.setAlwaysOnTop(true);
		primaryStage.setResizable(false);
		primaryStage.setX(0);
		primaryStage.setY(0);
		primaryStage.show(); // Display the stage

	}
}
