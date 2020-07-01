import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class CircleController3 extends GridPane implements CircleEvents, EventHandler<ActionEvent> {
	private CircleModel3 model;
	private TextField jtfRadius = new TextField();
	private ComboBox<Boolean> jcboFilled = new ComboBox<>(FXCollections.observableArrayList(false, true));
	private ComboBox<Boolean> jcboCalculateArea = new ComboBox<>(FXCollections.observableArrayList(false, true));
	private ColorPicker colorPicker = new ColorPicker(Color.BLACK);

	private final String inputError = "Must be > 0.0";

	/** Creates new form CircleController */
	public CircleController3() {
		setPadding(new Insets(20));
		this.setHgap(10);
		this.setVgap(10);
		this.setAlignment(Pos.CENTER_LEFT);
		add(new Label(eventType.RADIUS.toString()), 0, 0);
		add(new Label(eventType.FILLED.toString()), 0, 1);
		add(new Label(eventType.AREA.toString()), 0, 2);
		add(new Label(eventType.COLOR.toString()), 0, 3);
		add(jtfRadius, 1, 0);
		add(jcboFilled, 1, 1);
		jcboFilled.setValue(false);
		add(jcboCalculateArea, 1, 2);
		jcboCalculateArea.setValue(false);
		add(colorPicker, 1, 3);
		jtfRadius.setPrefWidth(100);
		jcboFilled.setPrefWidth(100);
		jcboCalculateArea.setPrefWidth(100);
		colorPicker.setPrefWidth(100);
		// Register listeners
		jtfRadius.setOnAction(this);
		jcboFilled.setOnAction(this);
		jcboCalculateArea.setOnAction(this);
		colorPicker.setOnAction(this);
	}

	public void handle(ActionEvent e) {
		if (model == null)
			return; // No model associated yet. Do nothing
		if (e.getSource() == jtfRadius) {
			double radius = new Double(jtfRadius.getText()).doubleValue();
			if (radius <= 0)
				jtfRadius.setText(inputError);
			else
				model.setRadius(radius);
		} else if (e.getSource() == jcboFilled)
			model.setFilled(jcboFilled.getValue());
		else if (e.getSource() == jcboCalculateArea)
			model.setCalculateArea(jcboCalculateArea.getValue());
		else if (e.getSource() == colorPicker)
			model.setColor(colorPicker.getValue());

	}

	public void setModel(CircleModel3 newModel) {
		model = newModel;
	}

	public CircleModel3 getModel() {
		return model;
	}
}
