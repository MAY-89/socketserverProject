package server;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import server.network.ServerSocketService;

public class MainController implements Initializable{

    private Stage stage;
    private boolean isServerOpen;

    @FXML private Button serverOpenBtn, userBtn, closeBtn;
    @FXML private Pane parent;
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
        close();
    }

    private void close() {
        closeBtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                Platform.exit();
                stage.close();
            }
        });
    }

    private void userCollector() {
        userBtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                Stage newStage = new Stage(StageStyle.UNDECORATED);
                FXMLLoader loader;

                try {
                    loader = new FXMLLoader(getClass().getResource("user.fxml"));                
                    newStage.setScene(loader.load());
                    newStage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
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
