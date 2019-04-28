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
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.Cursor;
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
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 * FXML Controller class
 *
 * @author Your Name <Ishan Randika>
 */
public class BettersLevalsController implements Initializable {

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
                txtBetterNIC.requestFocus();
            }
        });

        try {
            fillcombo();
            // TODO
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BettersLevalsController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(BettersLevalsController.class.getName()).log(Level.SEVERE, null, ex);
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

//    public static boolean leval02Pnic(String nic, String betID) throws SQLException, ClassNotFoundException, Exception {
//        return bo.leval02Pnic(nic, betID);
//    }
//    public static boolean leval01Pnic(String nic, String betID) throws SQLException, ClassNotFoundException, Exception {
//        return bo.leval01Pnic(nic, betID);
//    }
//    
//    public static boolean leval04Pnic(String nic, String betID) throws SQLException, ClassNotFoundException, Exception {
//        return bo.leval03Pnic(nic, betID);
//    }
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

//            cobBetID.requestFocus();
    }

    @FXML
    private void leval_01_PlNIC(ActionEvent event) throws SQLException, Exception {
        if (Pattern.compile("^[0-9]{9}[V]{1}$").matcher(txtLeval_01_PlNIC.getText()).matches() || Pattern.compile("^[0-9]{11}$").matcher(txtLeval_01_PlNIC.getText()).matches()) {
//            txtLeval_02_PlNIC.requestFocus();

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
//        txtLeval_02_PlNIC.requestFocus();
    }

    @FXML
    private void leval_02_PlNIC(ActionEvent event) throws ClassNotFoundException, Exception {

//        String l2 = "not";
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
                System.out.println("empty");
            } else {
                txtLeval_03_PlNIC.requestFocus();
                System.out.println("Okay");
            }
//                l2 = resultSet.getString(1);
////                System.out.println(l2);
//            if (resultSet.getRow() == 2) {
////                    System.out.println("This Player will not partisipate to this leval in this competition");
////                    txtLeval_03_PlNIC.requestFocus();
//                System.out.println("2");
//            }
//            if (resultSet.getRow() == 0) {
//                System.out.println("0");
//            }
//            if (resultSet.getRow() == 1) {
//                System.out.println("1");
//            }
//            if (resultSet.getRow() == 3) {
//                System.out.println("3");
//            }
//            if (resultSet.getRow() == 4) {
//                System.out.println("4");
//            }
//                else {
//                    txtLeval_03_PlNIC.requestFocus();
//                    System.out.println("This Player will not partisipate to this leval in this competition");
////                    System.out.println("This Player will not partisipate to this leval in this competition");
//                }
//            if (resultSet.getRow() != 1) {
//                    txtLeval_03_PlNIC.requestFocus();
//                    System.out.println("Okay");
//            }

//            l2 = resultSet.getString(1);
//            javafx.scene.image.Image img = new javafx.scene.image.Image(selectedimg);
//            profilePic.setImage(img);
//            }
//            boolean nic = BettersLevalsController.leval02Pnic(txtLeval_02_PlNIC.getText(), cobBetID.getSelectionModel().getSelectedItem());
//            if (nic) {
//                System.out.println("Okay");
//            } else {
//                System.out.println("This Player will not partisipate to this leval in this competition");
//            }
        } else {
            txtLeval_02_PlNIC.requestFocus();
            Alert a = new Alert(Alert.AlertType.ERROR, "Input Leval-02-Player's NIC format is Invalid", ButtonType.OK);
            a.show();
        }
//        txtLeval_03_PlNIC.requestFocus();
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
                System.out.println("empty");
            } else {
                btnSave.fire();
                System.out.println("Okay");
            }
            
            
//            btnSave.fire();
        } else {
            txtLeval_03_PlNIC.requestFocus();
            Alert a = new Alert(Alert.AlertType.ERROR, "Input Leval-03-Player's NIC format is Invalid", ButtonType.OK);
            a.show();
        }
//        btnSave.requestFocus();
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
//            String b_ID = cobBetID.getSelectionModel().getSelectedItem();
//            String le01_P_NIC = txtLeval_01_PlNIC.getText();
//            String le02_P_NIC = txtLeval_02_PlNIC.getText();
//            String le03_P_NIC = txtLeval_03_PlNIC.getText();

//            BettersLevalsDTO bt = new BettersLevalsDTO();
//            bt.setB_NIC(b_NIC);
//            bt.setB_ID(b_ID);
//            bt.setLe01_P_NIC(le01_P_NIC);
//            bt.setLe02_P_NIC(le02_P_NIC);
//            bt.setLe03_P_NIC(le03_P_NIC);
//
//            boolean addCom = BettersLevalsController.saveBettersLevals(bt);
//
//            if (addCom) {
//                Alert a = new Alert(Alert.AlertType.INFORMATION, "Done", ButtonType.OK);
//                a.show();
//
//            } else {
//                Alert a = new Alert(Alert.AlertType.ERROR, "Error", ButtonType.OK);
//                a.show();
//            }
        } catch (NumberFormatException e) {
            Alert a = new Alert(Alert.AlertType.ERROR, "You Cannot Input :" + e.getMessage(), ButtonType.OK);
            a.show();

        } catch (Exception ex) {
            Alert a = new Alert(Alert.AlertType.ERROR, "You Cannot Input :" + ex.getMessage(), ButtonType.OK);
            a.show();
            Logger.getLogger(BettersLevalsController.class.getName()).log(Level.SEVERE, null, ex);
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
    private void logout(ActionEvent event) throws IOException {
        Stage stage = (Stage) this.anchor.getScene().getWindow();
        Parent rt = FXMLLoader.load(getClass().getResource("/lk/betting/view/LoginForm.fxml"));
        Scene scen = new Scene(rt);
        stage.setScene(scen);
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
//        cobBetID.getAccessibleText("");

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
                Logger.getLogger(BettersLevalsController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
//        Stage stage = (Stage) this.anchor.getScene().getWindow();
//        Parent rt = FXMLLoader.load(getClass().getResource("/lk/betting/view/RegisterForm.fxml"));
//        Scene scen = new Scene(rt);
//        stage.setScene(scen);
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
//        fly.setOnFinished(event1 -> {
//            checkoutController.seatsselected=false;
//            handleClose(event);
//        });
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
//        scene.setCursor(Cursor.HAND);
    }
}
