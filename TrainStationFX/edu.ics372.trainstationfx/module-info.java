module edu.ics372.trainstationfx {
	requires javafx.controls;
	requires javafx.base;
	requires java.desktop;

	exports edu.ics372.trainstationfx.display to javafx.graphics;
	exports edu.ics372.trainstationfx.start to javafx.graphics;
}
