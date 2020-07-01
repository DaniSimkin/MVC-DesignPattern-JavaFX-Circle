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

public class CircleController1 extends GridPane implements EventHandler<ActionEvent> {
	private CircleModel1 model;
	private TextField jtfRadius = new TextField();
	private ComboBox<Boolean> jcboFilled = new ComboBox<>(FXCollections.observableArrayList(false, true));
	private ColorPicker colorPicker = new ColorPicker(Color.BLACK);

	/** Creates new form CircleController */
	public CircleController1() {
		setPadding(new Insets(20));
		this.setHgap(10);
		this.setVgap(10);
		this.setAlignment(Pos.CENTER_LEFT);
		add(new Label("Radius"), 0, 0);
		add(new Label("Filled"), 0, 1);
		add(new Label("Color"), 0, 2);
		add(jtfRadius, 1, 0);
		add(jcboFilled, 1, 1);
		jcboFilled.setValue(false);
		add(colorPicker, 1, 2);
		jcboFilled.setPrefWidth(100);
		jtfRadius.setPrefWidth(100);
		colorPicker.setPrefWidth(100);
		// Register listeners
		jtfRadius.setOnAction(this);
		jcboFilled.setOnAction(this);
		colorPicker.setOnAction(this);
	}

	public void handle(ActionEvent e) {
		if (model == null)
			return; // No model associated yet. Do nothing
		if (e.getSource() == jtfRadius)
			model.setRadius(new Double(jtfRadius.getText()).doubleValue());
		else if (e.getSource() == jcboFilled)
			model.setFilled(jcboFilled.getValue());
		else if (e.getSource() == colorPicker)
			model.setColor(colorPicker.getValue());
	}

	public void setModel(CircleModel1 newModel) {
		model = newModel;
	}

	public CircleModel1 getModel() {
		return model;
	}
}
