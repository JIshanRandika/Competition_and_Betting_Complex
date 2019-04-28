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
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Your Name <Ishan Randika>
 */
public class OrganizingFormController implements Initializable {

    @FXML
    private Pane titleBar;
    @FXML
    private JFXButton btnClose;
    @FXML
    private JFXButton btnMin;
    @FXML
    private ImageView image;
    @FXML
    private ImageView logo;
    @FXML
    private JFXButton btnCreateCompetition;
    @FXML
    private JFXButton btnJudgers;
    @FXML
    private JFXButton btnPlayers;
    @FXML
    private JFXButton btnBetters;
    @FXML
    private AnchorPane organizePane;
    @FXML
    private JFXButton btnWinners;
    @FXML
    private JFXButton btnlogout;
    @FXML
    private JFXButton btnBack;
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
    @FXML
    private JFXButton btnWonReports;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(20));
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

    @FXML
    private void createCompetition(ActionEvent event) throws IOException {
        SequentialTransition fly = makeBtnFly(btnCreateCompetition);
        fly.play();
        fly.setOnFinished(event1 -> {
            try {
                Stage stage = (Stage) this.organizePane.getScene().getWindow();
                Parent rt = FXMLLoader.load(getClass().getResource("/lk/betting/view/CreateCompetitionForm.fxml"));
                Scene scen = new Scene(rt);
                stage.setScene(scen);
            } catch (IOException ex) {
                Logger.getLogger(OrganizingFormController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    @FXML
    private void judgers(ActionEvent event) throws IOException {
        SequentialTransition fly = makeBtnFly(btnJudgers);
        fly.play();
        fly.setOnFinished(event1 -> {
            try {
                Stage stage = (Stage) this.organizePane.getScene().getWindow();
                Parent rt = FXMLLoader.load(getClass().getResource("/lk/betting/view/JudgersLevals.fxml"));
                Scene scen = new Scene(rt);
                stage.setScene(scen);
            } catch (IOException ex) {
                Logger.getLogger(OrganizingFormController.class.getName()).log(Level.SEVERE, null, ex);
            }
                });
    }

    @FXML
    private void players(ActionEvent event) throws IOException {
        SequentialTransition fly = makeBtnFly(btnPlayers);
        fly.play();
        fly.setOnFinished(event1 -> {
            try {
                Stage stage = (Stage) this.organizePane.getScene().getWindow();
                Parent rt = FXMLLoader.load(getClass().getResource("/lk/betting/view/PlayersLevals.fxml"));
                Scene scen = new Scene(rt);
                stage.setScene(scen);
            } catch (IOException ex) {
                Logger.getLogger(OrganizingFormController.class.getName()).log(Level.SEVERE, null, ex);
            }
                });
    }

    @FXML
    private void betters(ActionEvent event) throws IOException {
         SequentialTransition fly = makeBtnFly(btnBetters);
        fly.play();
        fly.setOnFinished(event1 -> {
             try {
                 Stage stage = (Stage) this.organizePane.getScene().getWindow();
                 Parent rt = FXMLLoader.load(getClass().getResource("/lk/betting/view/BettersLevals.fxml"));
                 Scene scen = new Scene(rt);
                 stage.setScene(scen);
             } catch (IOException ex) {
                 Logger.getLogger(OrganizingFormController.class.getName()).log(Level.SEVERE, null, ex);
             }
                });
    }

    @FXML
    private void winners(ActionEvent event) throws IOException {
          SequentialTransition fly = makeBtnFly(btnWinners);
        fly.play();
        fly.setOnFinished(event1 -> {
              try {
                  Stage stage = (Stage) this.organizePane.getScene().getWindow();
                  Parent rt = FXMLLoader.load(getClass().getResource("/lk/betting/view/WinnersForm.fxml"));
                  Scene scen = new Scene(rt);
                  stage.setScene(scen);
              } catch (IOException ex) {
                  Logger.getLogger(OrganizingFormController.class.getName()).log(Level.SEVERE, null, ex);
              }
                 });
    }

    @FXML
    private void logo(MouseEvent event) throws IOException {
        Stage stage = (Stage) this.organizePane.getScene().getWindow();
        Parent rt = FXMLLoader.load(getClass().getResource("/lk/betting/view/HomeForm.fxml"));
        Scene scen = new Scene(rt);
        stage.setScene(scen);
    }

    @FXML
    private void logout(ActionEvent event) throws IOException {
        Stage stage = (Stage) this.organizePane.getScene().getWindow();
        Parent rt = FXMLLoader.load(getClass().getResource("/lk/betting/view/LoginForm.fxml"));
        Scene scen = new Scene(rt);
        stage.setScene(scen);
    }

    @FXML
    private void back(ActionEvent event) throws IOException {
        Stage stage = (Stage) this.organizePane.getScene().getWindow();
        Parent rt = FXMLLoader.load(getClass().getResource("/lk/betting/view/HomeForm.fxml"));
        Scene scen = new Scene(rt);
        stage.setScene(scen);
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

    @FXML
    private void wonReports(ActionEvent event) throws IOException {
          SequentialTransition fly = makeBtnFly(btnWonReports);
        fly.play();
        fly.setOnFinished(event1 -> {
              try {
                  Stage stage = (Stage) this.organizePane.getScene().getWindow();
                  Parent rt = FXMLLoader.load(getClass().getResource("/lk/betting/view/WonReports.fxml"));
                  Scene scen = new Scene(rt);
                  stage.setScene(scen);
              } catch (IOException ex) {
                  Logger.getLogger(OrganizingFormController.class.getName()).log(Level.SEVERE, null, ex);
              }
         });
    }
}
