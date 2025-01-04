module br.ifsp.edu.br {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens br.ifsp.edu.br to javafx.fxml;
    exports br.ifsp.edu.br;
}
