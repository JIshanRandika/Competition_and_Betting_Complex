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
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.animation.Animation;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
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
import lk.betting.bo.custom.BettersLevalsBO;
import lk.betting.db.DBConnection;
import lk.betting.dto.BettersLevalsDTO;
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
public class BettersLevalsController extends CommonMethods implements Initializable {

    @FXML
    private Pane titleBar;
    @FXML
    private JFXButton btnMin;
    @FXML
    private JFXButton btnClose;
    @FXML
    private JFXComboBox<String> cobBetID;
    @FXML
    private JFXTextField txtBetterNIC;
    @FXML
    private JFXTextField txtLeval_01_PlNIC;
    @FXML
    private JFXTextField txtLeval_02_PlNIC;
    @FXML
    private JFXTextField txtLeval_03_PlNIC;
    @FXML
    private JFXButton btnSave;
    @FXML
    private AnchorPane anchor;
    @FXML
    private Pane pane01;
    @FXML
    private ImageView image;
    @FXML
    private Pane bottom;
    @FXML
    private JFXButton btnlogout;
    @FXML
    private Pane pane02;
    @FXML
    private ImageView logo;
    @FXML
    private JFXButton btnBack;
    @FXML
    private JFXButton btnNew;
    @FXML
    private JFXButton btnCheckList;
    private JFXButton cancelbtn;
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
                txtBetterNIC.requestFocus();
            }
        });

        try {
            fillcombo();
        } catch (ClassNotFoundException ex) {
            Alert a = new Alert(Alert.AlertType.ERROR, "Please Enter Better NIC & BetID Correctly !!", ButtonType.OK);
            a.show();
        } catch (Exception ex) {
            Alert a = new Alert(Alert.AlertType.ERROR, "Please Enter Better NIC & BetID Correctly !!", ButtonType.OK);
            a.show();
        }
    }

    static BettersLevalsBO bo = (BettersLevalsBO) BOFactory.getInstace().getBO(BOFactory.BOTypes.BETTERSLEVALS);

    public static ObservableList<String> fillcomboBox() throws ClassNotFoundException, SQLException, Exception {
        return bo.fillcomboBox();
    }

    public static boolean saveBettersLevals(BettersLevalsDTO bt) throws SQLException, ClassNotFoundException, Exception {
        return bo.saveBettersLevals(bt);
    }

    private void fillcombo() throws SQLException, ClassNotFoundException, Exception {
        cobBetID.setItems(fillcomboBox());

    }

    public static ResultSet getleval02Pnic(String nic, String betID) throws SQLException, ClassNotFoundException, Exception {
        return bo.getleval02Pnic(nic, betID);
    }

    public static ResultSet getleval01Pnic(String nic, String betID) throws SQLException, ClassNotFoundException, Exception {
        return bo.getleval02Pnic(nic, betID);
    }

    public static ResultSet getleval03Pnic(String nic, String betID) throws SQLException, ClassNotFoundException, Exception {
        return bo.getleval02Pnic(nic, betID);
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
    private void addBetID(KeyEvent event) {
        if (event.getCode() == KeyCode.DOWN || event.getCode() == KeyCode.UP) {
            System.out.println("");
        }
        if (event.getCode() == KeyCode.ENTER) {
            txtLeval_01_PlNIC.requestFocus();
        }
    }

    @FXML
    private void betterNIC(ActionEvent event) {

        if (Pattern.compile("^[0-9]{9}[V]{1}$").matcher(txtBetterNIC.getText()).matches() || Pattern.compile("^[0-9]{11}$").matcher(txtBetterNIC.getText()).matches()) {
            cobBetID.requestFocus();
        } else {
            txtBetterNIC.requestFocus();
            Alert a = new Alert(Alert.AlertType.ERROR, "Input Your NIC format is Invalid", ButtonType.OK);
            a.show();
        }
    }

    @FXML
    private void leval_01_PlNIC(ActionEvent event) throws SQLException, Exception {
        if (Pattern.compile("^[0-9]{9}[V]{1}$").matcher(txtLeval_01_PlNIC.getText()).matches() || Pattern.compile("^[0-9]{11}$").matcher(txtLeval_01_PlNIC.getText()).matches()) {

            ResultSet resultSet = BettersLevalsController.getleval02Pnic(txtLeval_01_PlNIC.getText(), cobBetID.getSelectionModel().getSelectedItem());
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
    private void leval_02_PlNIC(ActionEvent event) throws ClassNotFoundException, Exception {

        if (Pattern.compile("^[0-9]{9}[V]{1}$").matcher(txtLeval_02_PlNIC.getText()).matches() || Pattern.compile("^[0-9]{11}$").matcher(txtLeval_02_PlNIC.getText()).matches()) {

            ResultSet resultSet = BettersLevalsController.getleval02Pnic(txtLeval_02_PlNIC.getText(), cobBetID.getSelectionModel().getSelectedItem());
            boolean empty = true;
            while (resultSet.next()) {
                empty = false;
            }

            if (empty) {
                Alert a = new Alert(Alert.AlertType.WARNING, "This Player will not partisipate to leval 02 in this competition", ButtonType.OK);
                a.show();
                txtLeval_02_PlNIC.requestFocus();
            } else {
                txtLeval_03_PlNIC.requestFocus();
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

            ResultSet resultSet = BettersLevalsController.getleval02Pnic(txtLeval_03_PlNIC.getText(), cobBetID.getSelectionModel().getSelectedItem());
            boolean empty = true;
            while (resultSet.next()) {
                empty = false;
            }

            if (empty) {
                Alert a = new Alert(Alert.AlertType.WARNING, "This Player will not partisipate to leval 03 in this competition", ButtonType.OK);
                a.show();
                txtLeval_03_PlNIC.requestFocus();
            } else {
                btnSave.fire();
            }

        } else {
            txtLeval_03_PlNIC.requestFocus();
            Alert a = new Alert(Alert.AlertType.ERROR, "Input Leval-03-Player's NIC format is Invalid", ButtonType.OK);
            a.show();
        }
    }

    @FXML
    private void save(ActionEvent event) throws ClassNotFoundException, SQLException, JRException {
        SequentialTransition fly = makeBtnFly(btnSave);
        fly.play();
        fly.setOnFinished(event1 -> {
        });

        try {
            String b_NIC = txtBetterNIC.getText();
            if (Pattern.compile("^[0-9]{9}[V]{1}$").matcher(b_NIC).matches() || Pattern.compile("^[0-9]{11}$").matcher(b_NIC).matches()) {
                String b_ID = cobBetID.getSelectionModel().getSelectedItem();
                String le01_P_NIC = txtLeval_01_PlNIC.getText();
                if (Pattern.compile("^[0-9]{9}[V]{1}$").matcher(le01_P_NIC).matches() || Pattern.compile("^[0-9]{11}$").matcher(le01_P_NIC).matches()) {
                    String le02_P_NIC = txtLeval_02_PlNIC.getText();
                    if (Pattern.compile("^[0-9]{9}[V]{1}$").matcher(le02_P_NIC).matches() || Pattern.compile("^[0-9]{11}$").matcher(le02_P_NIC).matches()) {
                        String le03_P_NIC = txtLeval_03_PlNIC.getText();
                        if (Pattern.compile("^[0-9]{9}[V]{1}$").matcher(le03_P_NIC).matches() || Pattern.compile("^[0-9]{11}$").matcher(le03_P_NIC).matches()) {
                            BettersLevalsDTO bt = new BettersLevalsDTO();
                            bt.setB_NIC(b_NIC);
                            bt.setB_ID(b_ID);
                            bt.setLe01_P_NIC(le01_P_NIC);
                            bt.setLe02_P_NIC(le02_P_NIC);
                            bt.setLe03_P_NIC(le03_P_NIC);

                            boolean addCom = BettersLevalsController.saveBettersLevals(bt);

                            if (addCom) {
                                Alert a = new Alert(Alert.AlertType.INFORMATION, "Done", ButtonType.OK);
                                a.show();

                            } else {
                                Alert a = new Alert(Alert.AlertType.ERROR, "Error", ButtonType.OK);
                                a.show();
                            }

                        } else {
                            txtLeval_03_PlNIC.requestFocus();
                            Alert a = new Alert(Alert.AlertType.ERROR, "Input Leval-03-Player's NIC format is Invalid", ButtonType.OK);
                            a.show();
                        }
                    } else {
                        txtLeval_02_PlNIC.requestFocus();
                        Alert a = new Alert(Alert.AlertType.ERROR, "Input Leval-02-Player's NIC format is Invalid", ButtonType.OK);
                        a.show();
                    }
                } else {
                    txtLeval_01_PlNIC.requestFocus();
                    Alert a = new Alert(Alert.AlertType.ERROR, "Input Leval-01-Player's NIC format is Invalid", ButtonType.OK);
                    a.show();
                }
            } else {
                txtBetterNIC.requestFocus();
                Alert a = new Alert(Alert.AlertType.ERROR, "Input Your NIC format is Invalid", ButtonType.OK);
                a.show();
            }
        } catch (NumberFormatException e) {
            Alert a = new Alert(Alert.AlertType.ERROR, "You Cannot Input :" + e.getMessage(), ButtonType.OK);
            a.show();

        } catch (Exception ex) {
            Alert a = new Alert(Alert.AlertType.ERROR, "You Cannot Input :" + ex.getMessage(), ButtonType.OK);
            a.show();
        }

        InputStream is = this.getClass().getResourceAsStream("/lk/betting/reports/BetLevals.jasper");
        Connection connection = DBConnection.getInstance().getConnection();
        HashMap map = new HashMap();
        map.put("bnic", txtBetterNIC.getText());
        map.put("bid", cobBetID.getSelectionModel().getSelectedItem());
        JasperPrint print = JasperFillManager.fillReport(is, map, connection);
        JasperViewer.viewReport(print, false);

        clearAll();

        txtBetterNIC.requestFocus();
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
        Parent rt = FXMLLoader.load(getClass().getResource("/lk/betting/view/OrganizingForm.fxml"));
        Scene scen = new Scene(rt);
        stage.setScene(scen);
    }

    public void clearAll() {
        txtBetterNIC.setText("");
        txtLeval_01_PlNIC.setText("");
        txtLeval_02_PlNIC.setText("");
        txtLeval_03_PlNIC.setText("");

    }

    @FXML
    private void btnnew(ActionEvent event) throws IOException {
        SequentialTransition fly = makeBtnFly(btnNew);
        fly.play();
        fly.setOnFinished(event1 -> {
            try {
                Stage stage = (Stage) this.anchor.getScene().getWindow();
                Parent rt = FXMLLoader.load(getClass().getResource("/lk/betting/view/RegisterForm.fxml"));
                Scene scen = new Scene(rt);
                stage.setScene(scen);
            } catch (IOException ex) {
                Alert a = new Alert(Alert.AlertType.ERROR, "Your System has some detail errors, Please call your manager", ButtonType.OK);
                a.show();
            }
        });
    }

    @FXML
    private void checkList(ActionEvent event) throws ClassNotFoundException, JRException, SQLException {
        InputStream is = this.getClass().getResourceAsStream("/lk/betting/reports/ListBetLevals.jasper");
        Connection connection = DBConnection.getInstance().getConnection();
        JasperPrint print = JasperFillManager.fillReport(is, null, connection);
        JasperViewer.viewReport(print, false);
    }

    private void handleCancellation(ActionEvent event) {
        SequentialTransition fly = makeBtnFly(cancelbtn);
        fly.play();
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
    private void cursor(MouseEvent event) {
    }
}
