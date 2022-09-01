package server.user;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import database.UserDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import server.vo.user.UserVo;

public class UserController implements Initializable {

    public ObservableList<UserVo> users = FXCollections.observableArrayList();
    public UserDao dao = new UserDao();
    @FXML private ListView<?> listView;
    @FXML private Pane parent;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        userListVeiwOpen();
    }

    private void userListVeiwOpen() {
        List<UserVo> result = dao.selectUsers();
        users.addAll(result);
        listView = new ListView<>(users);
    }
}
