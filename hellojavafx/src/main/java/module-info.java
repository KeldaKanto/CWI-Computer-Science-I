module com.github.keldakanto {
    requires transitive javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;

    opens com.github.keldakanto to javafx.fxml;
    exports com.github.keldakanto;
}
