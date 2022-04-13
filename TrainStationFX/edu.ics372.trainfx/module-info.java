module edu.ics372.trainstationfx {
	requires javafx.controls;
	requires javafx.base;
	requires java.desktop;
	requires transitive javafx.graphics;

	exports edu.ics372.trainfx.display to javafx.graphics;
	exports edu.ics372.trainfx.start to javafx.graphics;
}
