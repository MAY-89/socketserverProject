package server;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import server.network.ServerSocketService;

public class MainController implements Initializable{

    private Stage stage;
    private boolean isServerOpen;

    @FXML private Button serverOpenBtn, userBtn;
    Stage privateStage;

    public void setPrimaryStage(Stage stage){
       this.stage = stage;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /*
         * Server Open
         * Socket Server Open
         */
        serviceOpenNow();
        userCollector();
    }

    private void userCollector() {
        userBtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                // TODO Auto-generated method stub
                
            }
            

        });
    }

    private void serviceOpenNow() {
        serverOpenBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                System.out.println("ServerOpen");
                if(isServerOpen == false){
                    new ServerSocketService();
                }
            }
        });

    }
    
}
