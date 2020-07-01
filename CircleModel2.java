
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;

public class CircleModel2 implements CircleEvents {

	private int circleCounter;

	/** Property radius. */
	private SimpleDoubleProperty radius = new SimpleDoubleProperty(20);

	/** Property filled. */
	private SimpleBooleanProperty filled = new SimpleBooleanProperty();

	/** Property filled. */
	private SimpleBooleanProperty calculateArea = new SimpleBooleanProperty();

	/** Property color. */
	private SimpleObjectProperty<Color> color = new SimpleObjectProperty<>(Color.BLACK);

	private ObservableMap<eventType, ObservableList<EventHandler<MyActionEvent>>> circleHashMap = FXCollections
			.observableHashMap();

	/** Constructor */
	public CircleModel2(int circleCounter) {
		this.circleCounter = circleCounter;
		for (eventType et : eventType.values())
			circleHashMap.put(et, FXCollections.observableArrayList());
	}

	public double getRadius() {
		return radius.get();
	}

	public void setRadius(double radius) {
		this.radius.set(radius);
		// Notify the listener for the change on radius
		processEvent(eventType.RADIUS, new MyActionEvent(this, eventType.RADIUS.toString()));
	}

	public boolean isFilled() {
		return filled.get();
	}

	public void setFilled(boolean filled) {
		this.filled.set(filled);
		// Notify the listener for the change on filled
		processEvent(eventType.FILLED, new MyActionEvent(this, eventType.FILLED.toString()));
	}

	public boolean calculateArea() {
		return calculateArea.get();
	}

	public void setCalculateArea(boolean calculateArea) {
		this.calculateArea.set(calculateArea);
		processEvent(eventType.AREA, new MyActionEvent(this, eventType.AREA.toString()));
	}

	public Color getColor() {
		return color.get();
	}

	public void setColor(Color color) {
		this.color.set(color);
		// Notify the listener for the change on color
		processEvent(eventType.COLOR, new MyActionEvent(this, eventType.COLOR.toString()));
	}

	/** Register an action event listener */
	public synchronized void addListener(EventHandler<MyActionEvent> l, eventType et) {
		ObservableList<EventHandler<MyActionEvent>> list = circleHashMap.get(et);
		if (!list.contains(l))
			list.add(l);
	}

	/** Remove an action event listener */
	public synchronized void removeListener(EventHandler<?> l, eventType et) {
		circleHashMap.get(et).remove(l);
	}

	/** Fire Event */
	private synchronized void processEvent(eventType et, MyActionEvent e) {
		ObservableList<EventHandler<MyActionEvent>> list = circleHashMap.get(et);
		System.out.println("model number: " + (circleCounter + 1) + " actionCommand: " + e.getMsg() + " array size is: "
				+ list.size());
		for (int i = 0; i < list.size(); i++)
			list.get(i).handle(e);
	}
}