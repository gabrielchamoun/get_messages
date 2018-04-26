import java.beans.EventHandler;

import javafx.application.Application;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GetMessages extends Application {

    private Grab grab;
    private String filename = "messages.txt";
    private TextField inputField;
    private TextField outputField;

    public void start (Stage stage) {
        grab = new Grab(filename);
        Pane root = new VBox();
        
        //Branch 1: Total words
        TextField b1 = new TextField(filename + ": There are " + grab.getTotal() + " words");
        b1.setEditable(false);

        //Branch 2: Most common
        TextField b2 = new TextField("The word " + grab.getCommon());
        b2.setEditable(false);
        
        //Branch 3: Entered Word
        HBox b3 = new HBox();
        inputField = new TextField("Enter a word");
        outputField = new TextField();
        outputField.setEditable(false);
        //Action Event for when user presses enter
        inputField.setOnAction(e -> {
            outputField.setText(inputField.getText() + ": " + grab.getWordCount(inputField.getText().toLowerCase()) + " times");
        });
        b3.getChildren().addAll(inputField,outputField);

        root.getChildren().addAll(b1,b2,b3);
        stage.setTitle("Get Messages");
        stage.setScene(new Scene(root, 300, 150));
        stage.show();
    }

    public static void main(String[] args) {launch(args);}
}