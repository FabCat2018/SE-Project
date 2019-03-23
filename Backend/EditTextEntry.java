import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class EditTextEntry {
    static String reviewBody;

    public static String display (String title, String message, Review review) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);

        Label previousLabel = new Label("Current Review Body");
        Label newLabel = new Label(message);
        TextArea oldBody = new TextArea(review.getBody());
        oldBody.setEditable(false);
        TextArea newBody = new TextArea();
        newBody.setPromptText("Enter body here");

        Button finishButton = new Button("Finish");
        finishButton.setOnAction(e -> {
            if (!(newBody.getText() == null) && !newBody.getText().equals(""))
                reviewBody = newBody.getText();
            window.close();
        });

        VBox layout = new VBox(20);
        layout.getChildren().addAll(previousLabel, oldBody, newLabel, newBody, finishButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

        return reviewBody;
    }
}