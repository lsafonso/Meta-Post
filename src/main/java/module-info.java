module facebook.metapost {
    requires javafx.controls;
    requires javafx.fxml;


    opens facebook.metapost to javafx.fxml;
    exports facebook.metapost;
}