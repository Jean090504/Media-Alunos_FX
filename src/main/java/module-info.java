module sp.jandira.media_final {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.desktop;

    // "Abra" o seu pacote real para o JavaFX FXML
    opens br.senai.sp.jandira.media_final to javafx.fxml;

    // "Exporte" o seu pacote real
    exports br.senai.sp.jandira.media_final;
}