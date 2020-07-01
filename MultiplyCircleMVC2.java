
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MultiplyCircleMVC2 extends Application {

	private ObservableList<CircleController2> circleControllerList = FXCollections.observableArrayList();
	private ObservableList<CircleView2> circleViewList = FXCollections.observableArrayList();
	private ObservableList<CircleModel2> circleModelList = FXCollections.observableArrayList();
	private int circleCounter = 0;
	private CircleModel2 model;

	/** Shows the controller window */
	public void showController() {
		CircleController2 controller = new CircleController2();
		model = new CircleModel2(circleCounter);
		controller.setModel(model);
		circleModelList.add(model);
		circleControllerList.add(controller);

		Stage stageController = new Stage();
		Scene scene = new Scene(controller, 330, 180);

		stageController.setTitle("Controller number " + (circleCounter + 1)); // Set the stage title
		stageController.setScene(scene); // Place the scene in the stage
		stageController.setAlwaysOnTop(true);
		stageController.setOnCloseRequest(e -> e.consume());
		stageController.setResizable(false);
		stageController.setX(100 + circleCounter * 15);
		stageController.setY(100 + circleCounter * 15);
		stageController.show(); // Display the stage
	}

	/** Shows the view window */
	public void showView() {
		CircleView2 view = new CircleView2(circleCounter);
		circleViewList.add(view);
		view.setModel(model);

		Stage stageView = new Stage();
		Scene scene = new Scene(view, 500, 200);

		stageView.setTitle("View number " + (circleCounter + 1)); // Set the stage title
		stageView.setScene(scene); // Place the scene in the stage
		stageView.setAlwaysOnTop(true);
		stageView.setOnCloseRequest(e -> e.consume());
		stageView.setX(200 + circleCounter * 15);
		stageView.setY(200 + circleCounter * 15);
		stageView.show(); // Display the stage
	}

	public static void main(String[] args) {
		launch(args);
	}

	/** Shows the initial window */
	@Override
	public void start(Stage primaryStage) throws Exception {

		Button jbtControllerView = new Button("Show Controller and View");

		StackPane hbox = new StackPane(jbtControllerView);

		jbtControllerView.setOnAction(e -> {
			showController();
			showView();
			circleCounter++;
		});

		Scene scene = new Scene(hbox, 300, 70);
		primaryStage.setOnCloseRequest(e -> Platform.exit());
		primaryStage.setTitle("MultiplyCircleMVC2"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.setAlwaysOnTop(true);
		primaryStage.setResizable(false);
		primaryStage.setX(0);
		primaryStage.setY(0);
		primaryStage.show(); // Display the stage

	}
}
