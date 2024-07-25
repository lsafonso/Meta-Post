module facebook.metapost {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;


    opens facebook.metapost to javafx.fxml;
    exports facebook.metapost;
}