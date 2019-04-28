/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.betting.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.collections.ObservableList;
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
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.betting.bo.BOFactory;
import lk.betting.bo.custom.WinnersBO;
import lk.betting.db.DBConnection;
import lk.betting.dto.WinnersDTO;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 * FXML Controller class
 *
 * @author Your Name <Ishan Randika>
 */
public class WinnersFormController implements Initializable {

    @FXML
    private Pane titleBar;
    @FXML
    private JFXButton btnMin;
    @FXML
    private JFXButton btnClose;
    @FXML
    private JFXTextField txtLeval_01_PlNIC;
    @FXML
    private JFXTextField txtLeval_02_PlNIC;
    @FXML
    private JFXTextField txtLeval_03_PlNIC;
    @FXML
    private JFXButton btnSave;
    @FXML
    private JFXComboBox<String> cobCompetitionID;
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
    private JFXButton btnCheckWinners;
    @FXML
    private JFXButton btnBack;
    @FXML
    private Label ishan;

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

        Image image = new Image("/lk/betting/image/LoginPage.jpg");
        this.image.setImage(image);
        Image logo = new Image("/lk/betting/image/logo.png");
        this.logo.setImage(logo);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                cobCompetitionID.requestFocus();
            }
        });

        try {
            fillcombo();
            // TODO
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WinnersFormController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(WinnersFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static WinnersBO bo = (WinnersBO) BOFactory.getInstace().getBO(BOFactory.BOTypes.WINNERS);

    public static ObservableList<String> fillcomboBox() throws ClassNotFoundException, SQLException, Exception {
        return bo.fillcomboBox();
    }

    public static boolean saveWinners(WinnersDTO win) throws SQLException, ClassNotFoundException, Exception {
        return bo.saveWinners(win);
    }

    private void fillcombo() throws SQLException, ClassNotFoundException, Exception {
        cobCompetitionID.setItems(fillcomboBox());

    }
    
    public static ResultSet getleval02Pnic(String nic, String comID) throws SQLException, ClassNotFoundException, Exception {
        return bo.getleval01Pnic(nic, comID);
    }

    public static ResultSet getleval01Pnic(String nic, String comID) throws SQLException, ClassNotFoundException, Exception {
        return bo.getleval02Pnic(nic, comID);
    }

    public static ResultSet getleval03Pnic(String nic, String comID) throws SQLException, ClassNotFoundException, Exception {
        return bo.getleval03Pnic(nic, comID);
    }

    @FXML
    private void min(ActionEvent event) {
        Stage stage = (Stage) btnMin.getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    private void close(ActionEvent event) {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }

    double x, y;

    @FXML
    private void dragged(MouseEvent event) {
        Stage stage = (Stage) titleBar.getScene().getWindow();
        stage.setX(x = event.getScreenX());
        stage.setY(y = event.getScreenY());
    }

    @FXML
    private void leval_01_PlNIC(ActionEvent event) throws SQLException, Exception {
        if (Pattern.compile("^[0-9]{9}[V]{1}$").matcher(txtLeval_01_PlNIC.getText()).matches() || Pattern.compile("^[0-9]{11}$").matcher(txtLeval_01_PlNIC.getText()).matches()) {
//            txtLeval_02_PlNIC.requestFocus();
            ResultSet resultSet = WinnersFormController.getleval01Pnic(txtLeval_01_PlNIC.getText(), cobCompetitionID.getSelectionModel().getSelectedItem());
            boolean empty = true;
            while (resultSet.next()) {
                empty = false;
            }

            if (empty) {
                Alert a = new Alert(Alert.AlertType.WARNING, "This Player will not partisipate to leval 01 in this competition", ButtonType.OK);
                a.show();
                txtLeval_01_PlNIC.requestFocus();
                System.out.println("empty");
            } else {
                txtLeval_02_PlNIC.requestFocus();
                System.out.println("Okay");
            }

        } else {
            txtLeval_01_PlNIC.requestFocus();
            Alert a = new Alert(Alert.AlertType.ERROR, "Input Leval-01-Player's NIC format is Invalid", ButtonType.OK);
            a.show();
        }
    }

    @FXML
    private void leval_02_PlNIC(ActionEvent event) throws SQLException, Exception {
        if (Pattern.compile("^[0-9]{9}[V]{1}$").matcher(txtLeval_02_PlNIC.getText()).matches() || Pattern.compile("^[0-9]{11}$").matcher(txtLeval_02_PlNIC.getText()).matches()) {
//            txtLeval_03_PlNIC.requestFocus();

            ResultSet resultSet = WinnersFormController.getleval02Pnic(txtLeval_02_PlNIC.getText(), cobCompetitionID.getSelectionModel().getSelectedItem());
            boolean empty = true;
            while (resultSet.next()) {
                empty = false;
            }

            if (empty) {
                Alert a = new Alert(Alert.AlertType.WARNING, "This Player will not partisipate to leval 01 in this competition", ButtonType.OK);
                a.show();
                txtLeval_02_PlNIC.requestFocus();
                System.out.println("empty");
            } else {
                txtLeval_03_PlNIC.requestFocus();
                System.out.println("Okay");
            }

        } else {
            txtLeval_02_PlNIC.requestFocus();
            Alert a = new Alert(Alert.AlertType.ERROR, "Input Leval-02-Player's NIC format is Invalid", ButtonType.OK);
            a.show();
        }
    }

    @FXML
    private void leval_03_PlNIC(ActionEvent event) throws SQLException, Exception {
        if (Pattern.compile("^[0-9]{9}[V]{1}$").matcher(txtLeval_03_PlNIC.getText()).matches() || Pattern.compile("^[0-9]{11}$").matcher(txtLeval_03_PlNIC.getText()).matches()) {
//            btnSave.fire();
            ResultSet resultSet = WinnersFormController.getleval01Pnic(txtLeval_03_PlNIC.getText(), cobCompetitionID.getSelectionModel().getSelectedItem());
            boolean empty = true;
            while (resultSet.next()) {
                empty = false;
            }

            if (empty) {
                Alert a = new Alert(Alert.AlertType.WARNING, "This Player will not partisipate to leval 01 in this competition", ButtonType.OK);
                a.show();
                txtLeval_03_PlNIC.requestFocus();
                System.out.println("empty");
            } else {
                 btnSave.fire();
                System.out.println("Okay");
            }

            
            
            
        } else {
            txtLeval_03_PlNIC.requestFocus();
            Alert a = new Alert(Alert.AlertType.ERROR, "Input Leval-03-Player's NIC format is Invalid", ButtonType.OK);
            a.show();
        }
    }

    @FXML
    private void save(ActionEvent event) {
        try {
            String competition_ID = cobCompetitionID.getSelectionModel().getSelectedItem();
            String le01_P_NIC = txtLeval_01_PlNIC.getText();
            String le02_P_NIC = txtLeval_02_PlNIC.getText();
            String le03_P_NIC = txtLeval_03_PlNIC.getText();

            WinnersDTO win = new WinnersDTO();
            win.setCompetition_ID(competition_ID);
            win.setLe01_P_NIC(le01_P_NIC);
            win.setLe02_P_NIC(le02_P_NIC);
            win.setLe03_P_NIC(le03_P_NIC);

            boolean addCom = WinnersFormController.saveWinners(win);

            if (addCom) {
                Alert a = new Alert(Alert.AlertType.INFORMATION, "Done", ButtonType.OK);
                a.show();

            } else {
                Alert a = new Alert(Alert.AlertType.ERROR, "Error", ButtonType.OK);
                a.show();
            }

        } catch (NumberFormatException e) {
            Alert a = new Alert(Alert.AlertType.ERROR, "You Cannot Input :" + e.getMessage(), ButtonType.OK);
            a.show();

        } catch (Exception ex) {
            Alert a = new Alert(Alert.AlertType.ERROR, "You Cannot Input :" + ex.getMessage(), ButtonType.OK);
            a.show();
            Logger.getLogger(WinnersFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
        clearAll();

        cobCompetitionID.requestFocus();
    }

    @FXML
    private void addCompetitionID(KeyEvent event) {
        if (event.getCode() == KeyCode.DOWN || event.getCode() == KeyCode.UP) {
            System.out.println("");
        }
        if (event.getCode() == KeyCode.ENTER) {
            txtLeval_01_PlNIC.requestFocus();
        }
    }

    @FXML
    private void logo(MouseEvent event) throws IOException {
        Stage stage = (Stage) this.anchor.getScene().getWindow();
        Parent rt = FXMLLoader.load(getClass().getResource("/lk/betting/view/HomeForm.fxml"));
        Scene scen = new Scene(rt);
        stage.setScene(scen);
    }

    @FXML
    private void logout(ActionEvent event) throws IOException {
        Stage stage = (Stage) this.anchor.getScene().getWindow();
        Parent rt = FXMLLoader.load(getClass().getResource("/lk/betting/view/LoginForm.fxml"));
        Scene scen = new Scene(rt);
        stage.setScene(scen);
    }

    @FXML
    private void checkWinners(ActionEvent event) throws ClassNotFoundException, JRException, SQLException {
        InputStream is = this.getClass().getResourceAsStream("/lk/betting/reports/WinnersForm.jasper");
        Connection connection = DBConnection.getInstance().getConnection();
        JasperPrint print = JasperFillManager.fillReport(is, null, connection);
        JasperViewer.viewReport(print, false);
    }

    @FXML
    private void back(ActionEvent event) throws IOException {
        Stage stage = (Stage) this.anchor.getScene().getWindow();
        Parent rt = FXMLLoader.load(getClass().getResource("/lk/betting/view/OrganizingForm.fxml"));
        Scene scen = new Scene(rt);
        stage.setScene(scen);
    }

    public void clearAll() {
        txtLeval_01_PlNIC.setText("");
        txtLeval_02_PlNIC.setText("");
        txtLeval_03_PlNIC.setText("");
    }
}
