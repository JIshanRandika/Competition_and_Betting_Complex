/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.betting.controller;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.betting.commonmethods.CommonMethods;

/**
 * FXML Controller class
 *
 * @author Your Name <Ishan Randika>
 */
public class HomeFormController extends CommonMethods implements Initializable {

    @FXML
    private JFXButton btnusers;
    @FXML
    private AnchorPane homepane;
    @FXML
    private JFXButton btnRegister;
    @FXML
    private JFXButton btnSpectator;
    @FXML
    private Pane titleBar;
    @FXML
    private JFXButton btnClose;
    @FXML
    private JFXButton btnMin;
    @FXML
    private ImageView image;
    @FXML
    private JFXButton btnOrganizing;
    @FXML
    private ImageView logo;
    @FXML
    private JFXButton btnlogout;
    @FXML
    private JFXButton btnTickets;
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
    private Label ishan;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        moveWindow(titleBar);

        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(20));
        transition.setToX(700);
        transition.setAutoReverse(true);
        transition.setCycleCount(Animation.INDEFINITE);
        transition.setNode(ishan);
        transition.play();

        TranslateTransition cir1 = new TranslateTransition();
        cir1.setDuration(Duration.seconds(3));
        cir1.setToX(100);
        cir1.setAutoReverse(true);
        cir1.setCycleCount(Animation.INDEFINITE);
        cir1.setNode(circle1);
        cir1.play();

        TranslateTransition cir2 = new TranslateTransition();
        cir2.setDuration(Duration.seconds(3));
        cir2.setToX(200);
        cir2.setAutoReverse(true);
        cir2.setCycleCount(Animation.INDEFINITE);
        cir2.setNode(circle2);
        cir2.play();

        TranslateTransition cir3 = new TranslateTransition();
        cir3.setDuration(Duration.seconds(3));
        cir3.setToX(300);
        cir3.setAutoReverse(true);
        cir3.setCycleCount(Animation.INDEFINITE);
        cir3.setNode(circle3);
        cir3.play();

        TranslateTransition cir4 = new TranslateTransition();
        cir4.setDuration(Duration.seconds(3));
        cir4.setToX(400);
        cir4.setAutoReverse(true);
        cir4.setCycleCount(Animation.INDEFINITE);
        cir4.setNode(circle4);
        cir4.play();

        TranslateTransition cir5 = new TranslateTransition();
        cir5.setDuration(Duration.seconds(3));
        cir5.setToX(500);
        cir5.setAutoReverse(true);
        cir5.setCycleCount(Animation.INDEFINITE);
        cir5.setNode(circle5);
        cir5.play();
        Image image = new Image("/lk/betting/image/LoginPage.jpg");
        this.image.setImage(image);
        Image logo = new Image("/lk/betting/image/logo.png");
        this.logo.setImage(logo);
    }

    @FXML
    private void users(ActionEvent event) throws IOException {
        SequentialTransition fly = makeBtnFly(btnusers);
        fly.play();
        fly.setOnFinished(event1 -> {
            try {
                Stage stage = (Stage) this.homepane.getScene().getWindow();
                Parent rt = FXMLLoader.load(getClass().getResource("/lk/betting/view/UsersForm.fxml"));
                Scene scen = new Scene(rt);
                stage.setScene(scen);
            } catch (IOException ex) {
                Alert a = new Alert(Alert.AlertType.ERROR, "Error :" + ex.getMessage(), ButtonType.OK);
                a.show();
            }
        });
    }

    @FXML
    private void register(ActionEvent event) throws IOException {
        SequentialTransition fly = makeBtnFly(btnRegister);
        fly.play();
        fly.setOnFinished(event1 -> {
            try {
                Stage stage = (Stage) this.homepane.getScene().getWindow();
                Parent rt = FXMLLoader.load(getClass().getResource("/lk/betting/view/RegisterForm.fxml"));
                Scene scen = new Scene(rt);
                stage.setScene(scen);
            } catch (IOException ex) {
                Alert a = new Alert(Alert.AlertType.ERROR, "Error :" + ex.getMessage(), ButtonType.OK);
                a.show();
            }
        });
    }

    @FXML
    private void spectator(ActionEvent event) throws IOException {
        SequentialTransition fly = makeBtnFly(btnSpectator);
        fly.play();
        fly.setOnFinished(event1 -> {
            try {
                Stage stage = (Stage) this.homepane.getScene().getWindow();
                Parent rt = FXMLLoader.load(getClass().getResource("/lk/betting/view/SpectatorForm.fxml"));
                Scene scen = new Scene(rt);
                stage.setScene(scen);
            } catch (IOException ex) {
                Alert a = new Alert(Alert.AlertType.ERROR, "Error :" + ex.getMessage(), ButtonType.OK);
                a.show();
            }
        });
    }

    @FXML
    private void min(ActionEvent event) {
        Stage stage = (Stage) btnMin.getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    private void dragged(MouseEvent event) {
    }

    @FXML
    private void organizing(ActionEvent event) throws IOException {
        SequentialTransition fly = makeBtnFly(btnOrganizing);
        fly.play();
        fly.setOnFinished(event1 -> {
            try {
                Stage stage = (Stage) this.homepane.getScene().getWindow();
                Parent rt = FXMLLoader.load(getClass().getResource("/lk/betting/view/OrganizingForm.fxml"));
                Scene scen = new Scene(rt);
                stage.setScene(scen);
            } catch (IOException ex) {
                Alert a = new Alert(Alert.AlertType.ERROR, "Error :" + ex.getMessage(), ButtonType.OK);
                a.show();
            }
        });
    }

    @FXML
    private void tickets(ActionEvent event) throws IOException {
        SequentialTransition fly = makeBtnFly(btnTickets);
        fly.play();
        fly.setOnFinished(event1 -> {
            try {
                Stage stage = (Stage) this.homepane.getScene().getWindow();
                Parent rt = FXMLLoader.load(getClass().getResource("/lk/betting/view/TicketsForm.fxml"));
                Scene scen = new Scene(rt);
                stage.setScene(scen);
            } catch (IOException ex) {
                Alert a = new Alert(Alert.AlertType.ERROR, "Error :" + ex.getMessage(), ButtonType.OK);
                a.show();
            }
        });
    }

    public SequentialTransition makeBtnFly(JFXButton btn) {
        TranslateTransition t1 = new TranslateTransition(Duration.millis(200), btn);
        t1.setToY(-17d);
        PauseTransition p1 = new PauseTransition(Duration.millis(30));
        TranslateTransition t2 = new TranslateTransition(Duration.millis(200), btn);
        t2.setToY(0d);

        SequentialTransition transition = new SequentialTransition(btn, t1, p1, t2);
        return transition;
    }
}
