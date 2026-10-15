module org.openjfx.javfx_archetype_fxml {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;

    opens org.openjfx.javfx_archetype_fxml to javafx.fxml;
    exports org.openjfx.javfx_archetype_fxml;
}
