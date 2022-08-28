import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import server.MainController;
 
public class App extends Application {
 
    public static void main(String[] args) {
        // 실행~~
        launch(args);
    }
     
    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("server/main.fxml"));
        Parent root = loader.load();

        stage.setResizable(false);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(new Scene(root));

        MainController mainController = loader.getController();
        mainController.setPrimaryStage(stage);
        stage.show();
       
    }
     
 
}