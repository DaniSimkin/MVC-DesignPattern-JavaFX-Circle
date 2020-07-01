
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class CircleView1 extends StackPane {
	private CircleModel1 model;
	private Circle c = new Circle();

	/** Set a model */
	public void setModel(CircleModel1 newModel) {
		model = newModel;
		// Register the view as listener for the model
		model.addListener(e -> paint());

		paint();
		getChildren().add(c);
	}

	public CircleModel1 getModel() {
		return model;
	}

	/** Update circle properties */
	public void paint() {
		c.setRadius(model.getRadius());
		c.setStroke(model.getColor());
		if (model.isFilled())
			c.setFill(model.getColor());
		else
			c.setFill(Color.TRANSPARENT);
	}

}