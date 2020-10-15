import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        //Variables
        VBox main_root=new VBox();

        Label l_grad=new Label("Grad Celsius");
        Label l_fahr=new Label("Grad Fahrenheit");
        TextArea txta_grad=new TextArea();
        TextArea txta_fahr=new TextArea();
        Button b_convToFahr=new Button("Convert C -> F");
        Button b_convToGrad=new Button("Convert F -> C");

        //EventHandler
        EventHandler handle_convToFahr=new EventHandler() {
            @Override
            public void handle(Event event) {

            }
        };

        EventHandler<MouseEvent> handle_convToGrad=new EventHandler() {
            @Override
            public void handle(Event event) {
                try {
                    double fa = Double.parseDouble(txta_fahr.getText());
                    double cel=(fa-32)/1.8;
                    txta_grad.setText("" + cel);
                }catch (Exception ignored){

                }
            }
        };

        //Styling
        txta_fahr.setMaxHeight(20);
        txta_grad.setMaxHeight(20);

        //Adding EventHandlers
        b_convToGrad.setOnMouseClicked(handle_convToGrad);

        //Adding to root
        main_root.getChildren().addAll(l_grad, txta_grad, l_fahr, txta_fahr, b_convToFahr, b_convToGrad);


        //Stage config
        System.out.println("test");
        Scene scene_root=new Scene(main_root);
        stage.setScene(scene_root);
        stage.setTitle("Moin");
        stage.show();
    }
}