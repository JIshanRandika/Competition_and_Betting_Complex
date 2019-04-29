/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.betting.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.animation.Animation;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
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
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.betting.db.DBConnection;
import lk.betting.commonmethods.CommonMethods;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class WonReportsController extends CommonMethods implements Initializable {

    @FXML
    private Pane titleBar;
    @FXML
    private JFXButton btnClose;
    @FXML
    private JFXButton btnMin;
    @FXML
    private ImageView logo;
    @FXML
    private ImageView image;
    @FXML
    private Pane bottom;
    @FXML
    private Label ishan;
    @FXML
    private JFXButton btnBack;
    @FXML
    private JFXButton btnlogout;
    @FXML
    private Pane pane01;
    @FXML
    private JFXTextField txtCompetitionID;
    @FXML
    private AnchorPane anchor;
    @FXML
    private JFXButton btnRs100;
    @FXML
    private JFXButton btnRs500;
    @FXML
    private JFXButton btnRs2000;
    @FXML
    private JFXButton btnWonPlayers;

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

        Image image = new Image("/lk/betting/image/LoginPage.jpg");
        this.image.setImage(image);
        Image logo = new Image("/lk/betting/image/logo.png");
        this.logo.setImage(logo);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                txtCompetitionID.requestFocus();
            }
        });
    }

    @FXML
    private void min(ActionEvent event) {
        Stage stage = (Stage) btnMin.getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    private void logo(MouseEvent event) throws IOException {
        Stage stage = (Stage) this.anchor.getScene().getWindow();
        Parent rt = FXMLLoader.load(getClass().getResource("/lk/betting/view/HomeForm.fxml"));
        Scene scen = new Scene(rt);
        stage.setScene(scen);
    }

    @FXML
    private void dragged(MouseEvent event) {
    }

    @FXML
    private void back(ActionEvent event) throws IOException {
        Stage stage = (Stage) this.anchor.getScene().getWindow();
        Parent rt = FXMLLoader.load(getClass().getResource("/lk/betting/view/OrganizingForm.fxml"));
        Scene scen = new Scene(rt);
        stage.setScene(scen);
    }

    @FXML
    private void competitonID(ActionEvent event) {
        if (Pattern.compile("^[C]{1}[0-9]{1,}$").matcher(txtCompetitionID.getText()).matches()) {
            btnRs100.requestFocus();
        } else {
            txtCompetitionID.requestFocus();
            Alert a = new Alert(Alert.AlertType.ERROR, "Input CompetitionID format is Invalid", ButtonType.OK);
            a.show();
        }
    }

    @FXML
    private void rs100(ActionEvent event) throws JRException, ClassNotFoundException, SQLException {
        SequentialTransition fly = makeBtnFly(btnRs100);
        fly.play();
        fly.setOnFinished(event1 -> {
            try {
                InputStream is = this.getClass().getResourceAsStream("/lk/betting/reports/Rs100WonBetters.jasper");
                Connection connection = DBConnection.getInstance().getConnection();
                HashMap map = new HashMap();
                map.put("cid", txtCompetitionID.getText());
                JasperPrint print = JasperFillManager.fillReport(is, map, connection);
                JasperViewer.viewReport(print, false);
            } catch (ClassNotFoundException ex) {
                Alert a = new Alert(Alert.AlertType.ERROR, "Please Enter Details Correctly", ButtonType.OK);
                a.show();
            } catch (SQLException ex) {
                Alert a = new Alert(Alert.AlertType.ERROR, "Please Enter Details Correctly", ButtonType.OK);
                a.show();
            } catch (JRException ex) {
                Alert a = new Alert(Alert.AlertType.ERROR, "Please Enter Details Correctly", ButtonType.OK);
                a.show();
            }
        });
    }

    @FXML
    private void rs500(ActionEvent event) throws ClassNotFoundException, JRException, SQLException {
        SequentialTransition fly = makeBtnFly(btnRs500);
        fly.play();
        fly.setOnFinished(event1 -> {
            try {
                InputStream is = this.getClass().getResourceAsStream("/lk/betting/reports/Rs500WonBetters.jasper");
                Connection connection = DBConnection.getInstance().getConnection();
                HashMap map = new HashMap();
                map.put("cid", txtCompetitionID.getText());
                JasperPrint print = JasperFillManager.fillReport(is, map, connection);
                JasperViewer.viewReport(print, false);
            } catch (ClassNotFoundException ex) {
                Alert a = new Alert(Alert.AlertType.ERROR, "Please Enter Details Correctly", ButtonType.OK);
                a.show();
            } catch (SQLException ex) {
                Alert a = new Alert(Alert.AlertType.ERROR, "Please Enter Details Correctly", ButtonType.OK);
                a.show();
            } catch (JRException ex) {
                Alert a = new Alert(Alert.AlertType.ERROR, "Please Enter Details Correctly", ButtonType.OK);
                a.show();
            }
        });
    }

    @FXML
    private void rs2000(ActionEvent event) throws ClassNotFoundException, JRException, SQLException {
        SequentialTransition fly = makeBtnFly(btnRs2000);
        fly.play();
        fly.setOnFinished(event1 -> {
            try {
                InputStream is = this.getClass().getResourceAsStream("/lk/betting/reports/Rs2000WonBetters.jasper");
                Connection connection = DBConnection.getInstance().getConnection();
                HashMap map = new HashMap();
                map.put("cid", txtCompetitionID.getText());
                JasperPrint print = JasperFillManager.fillReport(is, map, connection);
                JasperViewer.viewReport(print, false);
            } catch (ClassNotFoundException ex) {
                Alert a = new Alert(Alert.AlertType.ERROR, "Please Enter Details Correctly", ButtonType.OK);
                a.show();
            } catch (SQLException ex) {
                Alert a = new Alert(Alert.AlertType.ERROR, "Please Enter Details Correctly", ButtonType.OK);
                a.show();
            } catch (JRException ex) {
                Alert a = new Alert(Alert.AlertType.ERROR, "Please Enter Details Correctly", ButtonType.OK);
                a.show();
            }
        });
    }

    @FXML
    private void wonPlayers(ActionEvent event) throws ClassNotFoundException, JRException, SQLException {
        SequentialTransition fly = makeBtnFly(btnWonPlayers);
        fly.play();
        fly.setOnFinished(event1 -> {
            try {
                InputStream is = this.getClass().getResourceAsStream("/lk/betting/reports/WonPlayers.jasper");
                Connection connection = DBConnection.getInstance().getConnection();
                HashMap map = new HashMap();
                map.put("cid", txtCompetitionID.getText());
                JasperPrint print = JasperFillManager.fillReport(is, map, connection);
                JasperViewer.viewReport(print, false);
            } catch (ClassNotFoundException ex) {
                Alert a = new Alert(Alert.AlertType.ERROR, "Please Enter Details Correctly", ButtonType.OK);
                a.show();
            } catch (SQLException ex) {
                Alert a = new Alert(Alert.AlertType.ERROR, "Please Enter Details Correctly", ButtonType.OK);
                a.show();
            } catch (JRException ex) {
                Alert a = new Alert(Alert.AlertType.ERROR, "Please Enter Details Correctly", ButtonType.OK);
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
