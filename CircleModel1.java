
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;

public class CircleModel1 {

	/** Property radius. */
	private SimpleDoubleProperty radius = new SimpleDoubleProperty(20);

	/** Property filled. */
	private SimpleBooleanProperty filled = new SimpleBooleanProperty();

	/** Property color. */
	private SimpleObjectProperty<Color> color = new SimpleObjectProperty<>(Color.BLACK);

	/** Utility field used by event firing mechanism. */
	private ObservableList<EventHandler<MyActionEvent>> list = FXCollections.observableArrayList();

	public double getRadius() {
		return radius.get();
	}

	public void setRadius(double radius) {
		this.radius.set(radius);
		// Notify the listener for the change on radius
		processEvent(new MyActionEvent(this, "radius"));
	}

	public boolean isFilled() {
		return filled.get();
	}

	public void setFilled(boolean filled) {
		this.filled.set(filled);
		// Notify the listener for the change on filled
		processEvent(new MyActionEvent(this, "filled"));
	}

	public Color getColor() {
		return color.get();
	}

	public void setColor(Color color) {
		this.color.set(color);
		// Notify the listener for the change on color
		processEvent(new MyActionEvent(this, "color"));
	}

	/** Register an action event listener */
	public synchronized void addListener(EventHandler<MyActionEvent> l) {
		if (!list.contains(l))
			list.add(l);
	}

	/** Remove an action event listener */
	public synchronized void removeListener(EventHandler<MyActionEvent> l) {
		list.remove(l);
	}

	/** Fire Event */
	private synchronized void processEvent(MyActionEvent e) {
		System.out.println("size of actionListenerList is: " + list.size());
		for (int i = 0; i < list.size(); i++) {
			list.get(i).handle(e);
			System.out.println("event is: " + e.getMsg());
		}
	}
}