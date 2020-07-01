
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class CircleView3 extends StackPane implements CircleEvents {

	private int circleCounter;
	private CircleModel3 model;
	private Circle c = new Circle();
	private Text txt = new Text();
	// Initial event type to show
	private String eventTitle = "DEFAULT";

	/** Constructor */
	public CircleView3(int circleCounter) {
		this.circleCounter = circleCounter;
		setPadding(new Insets(15));
		HBox box = new HBox(txt);
		this.getChildren().addAll(box, c);
	}

	/** Set a model */
	public void setModel(CircleModel3 newModel) {
		model = newModel;
		// Add all different listeners
		for (eventType ev : eventType.values())
			model.addListener(e -> {
				eventTitle = ev.toString();
				paint();
			}, ev);
		paint();
	}

	public CircleModel3 getModel() {
		return model;
	}

	/** Update circle properties */
	public void paint() {
		double radius = model.getRadius();
		String s1 = "Event Type: " + eventTitle;
		String s2 = "Circle number " + (circleCounter + 1);
		String s3 = "Circle raduis " + radius;
		String s4 = "";

		if (model.calculateArea()) {
			double circleArea = radius * radius * Math.PI;
			s4 = "Circle Area " + circleArea;
		}
		txt.setText(s1 + "\n" + s2 + "\n" + s3 + "\n" + s4);
		c.setRadius(radius);
		c.setStroke(model.getColor());
		if (model.isFilled())
			c.setFill(model.getColor());
		else
			c.setFill(Color.TRANSPARENT);
	}

}