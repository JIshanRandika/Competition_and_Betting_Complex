/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.betting.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import static lk.betting.controller.UsersFormController.bo;
import lk.betting.db.DBConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.xml.transform.Source;
import lk.betting.bo.BOFactory;
import lk.betting.bo.custom.LoginBO;
import lk.betting.dto.LoginDTO;
import lk.betting.entity.Login;

/**
 * FXML Controller class
 *
 * @author Your Name <Ishan Randika>
 */
public class LoginFormController implements Initializable {

    @FXML
    private Pane titleBar;
    @FXML
    private JFXButton btnClose;
    @FXML
    private JFXButton btnMin;
    @FXML
    private Pane logpane;
    @FXML
    private ImageView image;
    @FXML
    private JFXTextField textEmail;
    @FXML
    private JFXPasswordField textPassword;
    @FXML
    private JFXButton btnLogin;
    @FXML
    private AnchorPane anchor;
    @FXML
    private ImageView logo;
    @FXML
    private StackPane stackpane;
    @FXML
    private Label ishan;
    @FXML
    private Circle circle1;
    @FXML
    private Circle circle2;
    @FXML
    private Circle circle3;
    @FXML
    private Circle circle4;
    @FXML
    private Circle circle5;
    @FXML
    private Label forgotPassword;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(10));
        transition.setToX(700);
//        transition.setToY(500);
        transition.setAutoReverse(true);
        transition.setCycleCount(Animation.INDEFINITE);
        transition.setNode(ishan);
        transition.play();
        
        TranslateTransition cir1 = new TranslateTransition();
        cir1.setDuration(Duration.seconds(3));
        cir1.setToX(100);
//        transition.setToY(500);
        cir1.setAutoReverse(true);
        cir1.setCycleCount(Animation.INDEFINITE);
        cir1.setNode(circle1);
        cir1.play();
        
        TranslateTransition cir2 = new TranslateTransition();
        cir2.setDuration(Duration.seconds(3));
        cir2.setToX(200);
//        transition.setToY(500);
        cir2.setAutoReverse(true);
        cir2.setCycleCount(Animation.INDEFINITE);
        cir2.setNode(circle2);
        cir2.play();

        TranslateTransition cir3 = new TranslateTransition();
        cir3.setDuration(Duration.seconds(3));
        cir3.setToX(300);
//        transition.setToY(500);
        cir3.setAutoReverse(true);
        cir3.setCycleCount(Animation.INDEFINITE);
        cir3.setNode(circle3);
        cir3.play();
        
        TranslateTransition cir4 = new TranslateTransition();
        cir4.setDuration(Duration.seconds(3));
        cir4.setToX(400);
//        transition.setToY(500);
        cir4.setAutoReverse(true);
        cir4.setCycleCount(Animation.INDEFINITE);
        cir4.setNode(circle4);
        cir4.play();
        
        TranslateTransition cir5 = new TranslateTransition();
        cir5.setDuration(Duration.seconds(3));
        cir5.setToX(500);
//        transition.setToY(500);
        cir5.setAutoReverse(true);
        cir5.setCycleCount(Animation.INDEFINITE);
        cir5.setNode(circle5);
        cir5.play();
        Image image = new Image("/lk/betting/image/LoginPage.jpg");
        this.image.setImage(image);
        Image logo = new Image("/lk/betting/image/logo.png");
        this.logo.setImage(logo);
//        btnClose.setGraphic(new ImageView());
//        this.btnClose.setGraphic(image);
        

  Platform.runLater(new Runnable() {
        @Override
        public void run() {
              textEmail.requestFocus();
        }
    });
        
        // TODO
    }

    @FXML
    private void close(ActionEvent event) {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();

    }

    @FXML
    private void min(ActionEvent event) {
        Stage stage = (Stage) btnMin.getScene().getWindow();
        stage.setIconified(true);
    }
    double x, y;

    @FXML
    private void dragged(MouseEvent event) {
        Stage stage = (Stage) titleBar.getScene().getWindow();
        stage.setX(x = event.getScreenX());
        stage.setY(y = event.getScreenY());

    }
    Stage dialogStage = new Stage();
    Scene scene;

    
    
    static LoginBO bo = (LoginBO) BOFactory.getInstace().getBO(BOFactory.BOTypes.LOGIN);

    
    
     public static boolean login(LoginDTO login) throws SQLException, ClassNotFoundException, Exception {
        return bo.login(login);
    }
    @FXML
    private void loginAction(ActionEvent event) throws ClassNotFoundException, Exception {
        String email = textEmail.getText();
        String password = textPassword.getText();
        
        LoginDTO login=new LoginDTO();
        login.setPassword(password);
        login.setU_Email(email);
        
        boolean log = LoginFormController.login(login);

        if (!log) {
                infoBox("Please enter correct Email and Password", null, "Failed");
            } else {
                infoBox("Login Successfull", null, "Success");
                Node node = (Node) event.getSource();
                dialogStage = (Stage) node.getScene().getWindow();
                dialogStage.close();
                scene = new Scene(FXMLLoader.load(getClass().getResource("/lk/betting/view/HomeForm.fxml")));
                dialogStage.setScene(scene);
                dialogStage.show();
            }

//        try {
//            Connection connection = DBConnection.getInstance().getConnection();
//            String sql = "SELECT * FROM users WHERE U_Email = ? and password =MD5(?)";
//            PreparedStatement pstm = connection.prepareStatement(sql);
//            pstm.setString(1, email);
//            pstm.setString(2, password);
//            ResultSet rst = pstm.executeQuery();
//            if (!rst.next()) {
//                infoBox("Please enter correct Email and Password", null, "Failed");
//            } else {
//                infoBox("Login Successfull", null, "Success");
//                Node node = (Node) event.getSource();
//                dialogStage = (Stage) node.getScene().getWindow();
//                dialogStage.close();
//                scene = new Scene(FXMLLoader.load(getClass().getResource("/lk/betting/view/HomeForm.fxml")));
//                dialogStage.setScene(scene);
//                dialogStage.show();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }

    public static void infoBox(String infoMessage, String headerText, String title) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText(infoMessage);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.showAndWait();
    }

    @FXML
    private void email(ActionEvent event) {
          if (Pattern.compile("[a-z0-9.]{1,}[@]{1}[a-z]{1,}[.]{1}(com)$").matcher(textEmail.getText()).matches() ) {
            textPassword.requestFocus();
        } else {
            textEmail.requestFocus();
            Alert a = new Alert(Alert.AlertType.ERROR, "Input Email Address format is Invalid", ButtonType.OK);
            a.show();
        }
//        textPassword.requestFocus();
    }

    @FXML
    private void password(ActionEvent event) {
        btnLogin.fire();
    }

    @FXML
    private void frogotPassword(MouseEvent event) {
//        Text title = new Text("Help With Forgotten Credentials");
//        title.setFont(Font.font("arial", FontWeight.SEMI_BOLD, FontPosture.REGULAR, 13));
//        String content = "It looks like you forgot your username or password,\nif so then no need to "+
//                "worry. Simply please get in \ntouch with or knock on my office door and ill be \nhappy to help.\n\n"+
//                "Thanks\nNajm, Your Manager";
//        JFXDialogLayout dialogContent = new JFXDialogLayout();
//        dialogContent.setHeading(title);
//        dialogContent.setPrefWidth(280);
//        dialogContent.setBody(new Text(content));
//
//        JFXButton close = new JFXButton("Close");
//        close.setButtonType(JFXButton.ButtonType.RAISED);
//        close.setStyle("-fx-background-color: #FF9A00; -fx-text-fill: white");
//        dialogContent.setActions(close);
//        JFXDialog dialog = new JFXDialog(stackpane, dialogContent, JFXDialog.DialogTransition.TOP);
//        dialog.setOverlayClose(false);
//        close.setOnAction(event -> {
//            dialog.close();
//        });
//        dialog.show();
//
//        dialog.setOnDialogOpened(event -> mainloginpane.setEffect(new GaussianBlur(5d)));
//        dialog.setOnDialogClosed(event -> mainloginpane.setEffect(new GaussianBlur(0d)));
showDialog();
    }
public void showDialog(){
        Text title = new Text("Help With Forgotten Credentials");
        title.setFont(Font.font("arial", FontWeight.SEMI_BOLD, FontPosture.REGULAR, 13));
        String content = "It looks like you forgot your email or password,\nif so then no need to "+
                "worry. Simply please get in \ntouch with or knock on my office door and ill be \nhappy to help.\n\n"+
                "Thanks\nJ. Ishan Randika, Your Manager";
        JFXDialogLayout dialogContent = new JFXDialogLayout();
        dialogContent.setHeading(title);
        dialogContent.setPrefWidth(280);
        dialogContent.setBody(new Text(content));

        JFXButton close = new JFXButton("Close");
        close.setButtonType(JFXButton.ButtonType.RAISED);
        close.setStyle("-fx-background-color: #FF9A00; -fx-text-fill: white");
        dialogContent.setActions(close);
        JFXDialog dialog = new JFXDialog(stackpane, dialogContent, JFXDialog.DialogTransition.TOP);
        dialog.setOverlayClose(false);
        close.setOnAction(event -> {
            dialog.close();
        });
        dialog.show();

        dialog.setOnDialogOpened(event -> anchor.setEffect(new GaussianBlur(5d)));
        dialog.setOnDialogClosed(event -> anchor.setEffect(new GaussianBlur(0d)));
    }

}
