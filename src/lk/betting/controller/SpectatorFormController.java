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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import lk.betting.dto.SpectatorDTO;
import java.util.regex.Pattern;
import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import lk.betting.bo.BOFactory;
import lk.betting.bo.custom.SpectatorBO;
import lk.betting.db.DBConnection;
import lk.betting.commonmethods.CommonMethods;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 * FXML Controller class
 *
 * @author Your Name <Ishan Randika>
 */
public class SpectatorFormController extends CommonMethods implements Initializable {

    @FXML
    private Pane titleBar;
    @FXML
    private JFXButton btnClose;
    @FXML
    private JFXButton btnMin;
    @FXML
    private JFXTextField txtSpectatorID;
    @FXML
    private JFXTextField txtSpectatorname;
    @FXML
    private JFXTextField txtSpectatorAddress;
    @FXML
    private JFXTextField txtSpectatorMobile;
    @FXML
    private JFXButton btnRegister;
    @FXML
    private ImageView logo;
    @FXML
    private Pane pane01;
    @FXML
    private ImageView image;
    @FXML
    private Pane bottom;
    @FXML
    private JFXButton btnlogout;
    @FXML
    private AnchorPane anchor;
    @FXML
    private JFXButton btnBack;
    @FXML
    private JFXButton btnTickets;
    @FXML
    private JFXButton btnRegisteredSpectators;
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

        Image image = new Image("/lk/betting/image/LoginPage.jpg");
        this.image.setImage(image);
        Image logo = new Image("/lk/betting/image/logo.png");
        this.logo.setImage(logo);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                txtSpectatorID.requestFocus();
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
    private void spectatorID(ActionEvent event) {
        if (Pattern.compile("^[S]{1}[0-9]{1,}$").matcher(txtSpectatorID.getText()).matches()) {
            txtSpectatorname.requestFocus();
        } else {
            txtSpectatorID.requestFocus();
            Alert a = new Alert(Alert.AlertType.ERROR, "Input SpectatorID format is Invalid", ButtonType.OK);
            a.show();
        }

    }

    @FXML
    private void Spectatorname(ActionEvent event) {
        txtSpectatorAddress.requestFocus();
    }

    @FXML
    private void spectatorAddress(ActionEvent event) {
        txtSpectatorMobile.requestFocus();
    }

    @FXML
    private void spectatorMobile(ActionEvent event) {
        if (Pattern.compile("^[+]{1}(94)[-]{1}[0-9]{9}$").matcher(txtSpectatorMobile.getText()).matches()) {
            btnRegister.fire();
        } else {
            txtSpectatorMobile.requestFocus();
            Alert a = new Alert(Alert.AlertType.ERROR, "Input Mobile Number format is Invalid", ButtonType.OK);
            a.show();
        }

    }
    static SpectatorBO bo = (SpectatorBO) BOFactory.getInstace().getBO(BOFactory.BOTypes.SPECTATOR);

    public static boolean registerSpectator(SpectatorDTO ju) throws SQLException, ClassNotFoundException, Exception {
        return bo.registerSpectator(ju);

    }

    @FXML
    private void register(ActionEvent event) throws ClassNotFoundException, SQLException, JRException {

        try {
            String spectatorID = txtSpectatorID.getText();
            String spectatorName = txtSpectatorname.getText();
            String spectatorAddress = txtSpectatorAddress.getText();
            String spectatorMobile = txtSpectatorMobile.getText();

            SpectatorDTO spectator = new SpectatorDTO();
            spectator.setSpectatorID(spectatorID);
            spectator.setSpectatorName(spectatorName);
            spectator.setSpectatorAddress(spectatorAddress);
            spectator.setSpectatorMobile(spectatorMobile);

            boolean addCom = SpectatorFormController.registerSpectator(spectator);

            if (addCom) {
                Alert a = new Alert(Alert.AlertType.INFORMATION, "Done", ButtonType.OK);
                a.show();

            } else {
                Alert a = new Alert(Alert.AlertType.ERROR, "Please Enter Details Correctly", ButtonType.OK);
                a.show();
            }

        } catch (NumberFormatException e) {
            Alert a = new Alert(Alert.AlertType.ERROR, "Please Enter Details Correctly", ButtonType.OK);
            a.show();

        } catch (Exception ex) {
            Alert a = new Alert(Alert.AlertType.ERROR, "Please Enter Details Correctly", ButtonType.OK);
            a.show();
        }

        InputStream is = this.getClass().getResourceAsStream("/lk/betting/reports/Spectators.jasper");
        Connection connection = DBConnection.getInstance().getConnection();
        HashMap map = new HashMap();
        map.put("sid", txtSpectatorID.getText());
        JasperPrint print = JasperFillManager.fillReport(is, map, connection);
        JasperViewer.viewReport(print, false);

        clearAll();

        txtSpectatorID.requestFocus();
    }

    @FXML
    private void logo(MouseEvent event) throws IOException {
        Stage stage = (Stage) this.anchor.getScene().getWindow();
        Parent rt = FXMLLoader.load(getClass().getResource("/lk/betting/view/HomeForm.fxml"));
        Scene scen = new Scene(rt);
        stage.setScene(scen);
    }

    @FXML
    private void back(ActionEvent event) throws IOException {
        Stage stage = (Stage) this.anchor.getScene().getWindow();
        Parent rt = FXMLLoader.load(getClass().getResource("/lk/betting/view/HomeForm.fxml"));
        Scene scen = new Scene(rt);
        stage.setScene(scen);
    }

    public void clearAll() {
        txtSpectatorID.setText("");
        txtSpectatorAddress.setText("");
        txtSpectatorMobile.setText("");
        txtSpectatorname.setText("");

    }

    @FXML
    private void tickets(ActionEvent event) throws IOException {
        Stage stage = (Stage) this.anchor.getScene().getWindow();
        Parent rt = FXMLLoader.load(getClass().getResource("/lk/betting/view/TicketsForm.fxml"));
        Scene scen = new Scene(rt);
        stage.setScene(scen);
    }

    @FXML
    private void registeredSpectators(ActionEvent event) throws ClassNotFoundException, JRException, SQLException {
        InputStream is = this.getClass().getResourceAsStream("/lk/betting/reports/RegisteredSpectators.jasper");
        Connection connection = DBConnection.getInstance().getConnection();
        JasperPrint print = JasperFillManager.fillReport(is, null, connection);
        JasperViewer.viewReport(print, false);
    }
}
