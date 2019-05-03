/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.betting.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.io.InputStream;
import lk.betting.db.DBConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.animation.Animation;
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
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.betting.bo.BOFactory;
import lk.betting.bo.custom.RegisterBettersBO;
import lk.betting.bo.custom.RegisterJudgersBO;
import lk.betting.bo.custom.RegisterPlayersBO;
import lk.betting.dto.BettersDTO;
import lk.betting.dto.JudgersDTO;
import lk.betting.dto.PlayersDTO;
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
public class RegisterFormController extends CommonMethods implements Initializable {

    @FXML
    private Pane titleBar;
    @FXML
    private JFXButton btnClose;
    @FXML
    private JFXButton btnMin;
    @FXML
    private JFXTextField txtJuNIC;
    @FXML
    private JFXTextField txtJuName;
    @FXML
    private JFXTextField txtJuMobile;
    @FXML
    private JFXTextField txtJuEmail;
    @FXML
    private JFXButton btnJuRegister;
    @FXML
    private JFXTextField txtplName;
    @FXML
    private JFXTextField txtPlNIC;
    @FXML
    private JFXTextField txtplAddress;
    @FXML
    private JFXTextField txtplMobile;
    @FXML
    private JFXTextField txtplBOD;
    @FXML
    private JFXTextField txtplAge;
    @FXML
    private JFXButton btnplRegister;
    @FXML
    private JFXTextField txtbtName;
    @FXML
    private JFXTextField txtbtNIC;
    @FXML
    private JFXTextField txtbtAddress;
    @FXML
    private JFXTextField txtbtMobile;
    @FXML
    private JFXTextField txtbtBOD;
    @FXML
    private JFXTextField txtbtAge;
    @FXML
    private JFXButton btnbtRegister;
    @FXML
    private ImageView logo;
    @FXML
    private Pane bottom;
    @FXML
    private JFXButton btnlogout;
    @FXML
    private ImageView image;
    @FXML
    private TabPane tabPane;
    @FXML
    private AnchorPane anchor;
    @FXML
    private Tab btnBetter;
    @FXML
    private Tab btnPlayers;
    @FXML
    private Tab btnJudgers;
    @FXML
    private Pane pane01;
    @FXML
    private JFXButton btnBack;
    @FXML
    private JFXButton btnRegisteredBetters;
    @FXML
    private JFXButton btnRegisteredPlayers;
    @FXML
    private StackPane stackpane;
    @FXML
    private Label conditions;
    @FXML
    private Label ishan;
    @FXML
    private JFXButton btnJuUpdate;
    @FXML
    private Label juconditions;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        moveWindow(titleBar);

        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(24));
        transition.setToX(808);
        transition.setAutoReverse(true);
        transition.setCycleCount(Animation.INDEFINITE);
        transition.setNode(ishan);
        transition.play();

        Image image = new Image("/lk/betting/image/PageUsers.jpg");
        this.image.setImage(image);
        Image logo = new Image("/lk/betting/image/logo.png");
        this.logo.setImage(logo);
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
    private void juName(ActionEvent event) {
        txtJuNIC.requestFocus();
    }

    @FXML
    private void juMobile(ActionEvent event) {
        if (Pattern.compile("^[+]{1}(94)[-]{1}[0-9]{9}$").matcher(txtJuMobile.getText()).matches()) {
            txtJuEmail.requestFocus();
        } else {
            txtJuMobile.requestFocus();
            Alert a = new Alert(Alert.AlertType.ERROR, "Input Mobile Number format is Invalid", ButtonType.OK);
            a.show();
        }

    }

    @FXML
    private void juEmail(ActionEvent event) {
        if (Pattern.compile("[a-z0-9.]{1,}[@]{1}[a-z]{1,}[.]{1}(com)$").matcher(txtJuEmail.getText()).matches()) {
            btnJuRegister.fire();
        } else {
            txtJuEmail.requestFocus();
            Alert a = new Alert(Alert.AlertType.ERROR, "Input Email Address format is Invalid", ButtonType.OK);
            a.show();
        }

    }
    static RegisterJudgersBO bo = (RegisterJudgersBO) BOFactory.getInstace().getBO(BOFactory.BOTypes.REGISTERJUDGERS);

    public static boolean registerJudgers(JudgersDTO ju) throws SQLException, ClassNotFoundException, Exception {
        return bo.registerJudgers(ju);
    }

    @FXML
    private void juregister(ActionEvent event) throws ClassNotFoundException, JRException, SQLException {

        try {
            String juName = txtJuName.getText();
            String juNIC = txtJuNIC.getText();
            String juMobile = txtJuMobile.getText();
            String juEmail = txtJuEmail.getText();

            JudgersDTO judgers = new JudgersDTO();
            judgers.setJuName(juName);
            judgers.setJuNIC(juNIC);
            judgers.setJuEmail(juEmail);
            judgers.setJuMobile(juMobile);

            boolean addCom = RegisterFormController.registerJudgers(judgers);

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

        InputStream is = this.getClass().getResourceAsStream("/lk/betting/reports/JudgersRegister.jasper");
        Connection connection = DBConnection.getInstance().getConnection();
        HashMap map = new HashMap();
        map.put("jnic", txtJuNIC.getText());
        JasperPrint print = JasperFillManager.fillReport(is, map, connection);
        JasperViewer.viewReport(print, false);
        clearAllJudger();

        txtJuName.requestFocus();
    }

    @FXML
    private void plName(ActionEvent event) {
        txtPlNIC.requestFocus();
    }

    @FXML
    private void plNIC(ActionEvent event) {
        if (Pattern.compile("^[0-9]{9}[V]{1}$").matcher(txtPlNIC.getText()).matches() || Pattern.compile("^[0-9]{11}$").matcher(txtPlNIC.getText()).matches()) {
            txtplAddress.requestFocus();
        } else {
            txtPlNIC.requestFocus();
            Alert a = new Alert(Alert.AlertType.ERROR, "Input Player's NIC format is Invalid", ButtonType.OK);
            a.show();
        }
    }

    @FXML
    private void plAddress(ActionEvent event) {
        txtplMobile.requestFocus();
    }

    @FXML
    private void plMobile(ActionEvent event) {
        if (Pattern.compile("^[+]{1}(94)[-]{1}[0-9]{9}$").matcher(txtplMobile.getText()).matches()) {
            txtplBOD.requestFocus();
        } else {
            txtplMobile.requestFocus();
            Alert a = new Alert(Alert.AlertType.ERROR, "Input Mobile Number format is Invalid", ButtonType.OK);
            a.show();
        }

    }

    @FXML
    private void plBOD(ActionEvent event) throws ParseException {

        String bod = txtplBOD.getText();
        System.out.println(bod);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd");
        SimpleDateFormat formatt = new SimpleDateFormat("yyyy");
        String dateInString = bod;

        try {

            Date date = formatter.parse(dateInString);
            System.out.println(date);
            System.out.println(formatter.format(date));

            int bodyear = Integer.parseInt(formatt.format(date));

            Calendar calOne = Calendar.getInstance();
            int currentyear = calOne.get(Calendar.YEAR);

            int age = currentyear - bodyear;
            if (age >= 18) {
                txtplAge.setText(age + "");
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR, "Your age is not enough...!!!!", ButtonType.OK);
                a.show();
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (Pattern.compile("^[0-9]{4}[.]{1}[0-9]{2}[.]{1}[0-9]{2}$").matcher(txtplBOD.getText()).matches()) {
            btnplRegister.fire();
        } else {
            txtplBOD.requestFocus();
            Alert a = new Alert(Alert.AlertType.ERROR, "Input BOD format is Invalid->[YYYY.MM.DD]", ButtonType.OK);
            a.show();
        }
    }

    @FXML
    private void plAge(ActionEvent event) {
    }

    static RegisterPlayersBO bop = (RegisterPlayersBO) BOFactory.getInstace().getBO(BOFactory.BOTypes.REGISTERPLAYERS);

    public static boolean registerPlayers(PlayersDTO pl) throws SQLException, ClassNotFoundException, Exception {
        return bop.registerPlayers(pl);
    }

    @FXML
    private void plRegister(ActionEvent event) throws ClassNotFoundException, SQLException, JRException {

        try {
            String plName = txtplName.getText();
            String plNIC = txtPlNIC.getText();
            String plMobile = txtplMobile.getText();
            String plAddress = txtplAddress.getText();
            String plBOD = txtplBOD.getText();
            String plage = txtplAge.getText();

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd");

            Date date = formatter.parse(plBOD);

            PlayersDTO players = new PlayersDTO();
            players.setPlName(plName);
            players.setPlNIC(plNIC);
            players.setPlAddress(plAddress);
            players.setPlMobile(plMobile);
            players.setPlBOD(date);
            players.setPlAge(plage);

            boolean addCom = RegisterFormController.registerPlayers(players);

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
        InputStream is = this.getClass().getResourceAsStream("/lk/betting/reports/PlayersRegister.jasper");
        Connection connection = DBConnection.getInstance().getConnection();
        HashMap map = new HashMap();
        map.put("pnic", txtPlNIC.getText());
        JasperPrint print = JasperFillManager.fillReport(is, map, connection);
        JasperViewer.viewReport(print, false);

        clearAllPlayer();

        txtplName.requestFocus();
    }

    @FXML
    private void btname(ActionEvent event) {
        txtbtNIC.requestFocus();
    }

    @FXML
    private void btNIC(ActionEvent event) {
        if (Pattern.compile("^[0-9]{9}[V]{1}$").matcher(txtbtNIC.getText()).matches() || Pattern.compile("^[0-9]{11}$").matcher(txtbtNIC.getText()).matches()) {
            txtbtAddress.requestFocus();
        } else {
            txtbtNIC.requestFocus();
            Alert a = new Alert(Alert.AlertType.ERROR, "Input Better's NIC format is Invalid", ButtonType.OK);
            a.show();
        }
    }

    @FXML
    private void btAddress(ActionEvent event) {
        txtbtMobile.requestFocus();
    }

    @FXML
    private void btMobile(ActionEvent event) {
        if (Pattern.compile("^[+]{1}(94)[-]{1}[0-9]{9}$").matcher(txtbtMobile.getText()).matches()) {
            txtbtBOD.requestFocus();
        } else {
            txtbtMobile.requestFocus();
            Alert a = new Alert(Alert.AlertType.ERROR, "Input Mobile Number format is Invalid", ButtonType.OK);
            a.show();
        }

    }

    @FXML
    private void btBOD(ActionEvent event) {

        String bod = txtbtBOD.getText();
        System.out.println(bod);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd");
        SimpleDateFormat formatt = new SimpleDateFormat("yyyy");
        String dateInString = bod;

        try {

            Date date = formatter.parse(dateInString);
            System.out.println(date);
            System.out.println(formatter.format(date));
            int bodyear = Integer.parseInt(formatt.format(date));

            Calendar calOne = Calendar.getInstance();
            int currentyear = calOne.get(Calendar.YEAR);

            int age = currentyear - bodyear;
            if (age >= 18) {
                txtbtAge.setText(age + "");
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR, "Your age is not enough...!!!!", ButtonType.OK);
                a.show();
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (Pattern.compile("^[0-9]{4}[.]{1}[0-9]{2}[.]{1}[0-9]{2}$").matcher(txtbtBOD.getText()).matches()) {
            btnbtRegister.fire();
        } else {
            txtbtBOD.requestFocus();
            Alert a = new Alert(Alert.AlertType.ERROR, "Input BOD format is Invalid->[YYYY.MM.DD]", ButtonType.OK);
            a.show();
        }
    }

    @FXML
    private void btAge(ActionEvent event) {
    }

    static RegisterBettersBO bobt = (RegisterBettersBO) BOFactory.getInstace().getBO(BOFactory.BOTypes.REGISTERBETTERS);

    public static boolean registerBetters(BettersDTO bt) throws SQLException, ClassNotFoundException, Exception {
        return bobt.registerBetters(bt);
    }

    @FXML
    private void btRegister(ActionEvent event) throws JRException, ClassNotFoundException, SQLException {

        try {
            String btName = txtbtName.getText();
            String btNIC = txtbtNIC.getText();
            String btMobile = txtbtMobile.getText();
            String btAddress = txtbtAddress.getText();
            String btBOD = txtbtBOD.getText();
            String btage = txtbtAge.getText();

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd");

            Date date = formatter.parse(btBOD);

            BettersDTO betters = new BettersDTO();
            betters.setBtName(btName);
            betters.setBtNIC(btNIC);
            betters.setBtAddress(btAddress);
            betters.setBtMobile(btMobile);
            betters.setBtBOD(date);
            betters.setBtAge(btage);

            boolean addCom = RegisterFormController.registerBetters(betters);

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

        InputStream is = this.getClass().getResourceAsStream("/lk/betting/reports/BettersRegister.jasper");
        Connection connection = DBConnection.getInstance().getConnection();
        HashMap map = new HashMap();
        map.put("bnic", txtbtNIC.getText());
        JasperPrint print = JasperFillManager.fillReport(is, map, connection);
        JasperViewer.viewReport(print, false);

        clearAllBetter();

        txtbtName.requestFocus();
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

    public void clearAllBetter() {
        txtbtAddress.setText("");
        txtbtAge.setText("");
        txtbtBOD.setText("");
        txtbtMobile.setText("");
        txtbtNIC.setText("");
        txtbtName.setText("");

    }

    public void clearAllPlayer() {
        txtplAddress.setText("");
        txtplAge.setText("");
        txtplBOD.setText("");
        txtplMobile.setText("");
        txtPlNIC.setText("");
        txtplName.setText("");

    }

    public void clearAllJudger() {
        txtJuEmail.setText("");
        txtJuMobile.setText("");
        txtJuNIC.setText("");
        txtJuName.setText("");

    }

    @FXML
    private void registeredBetters(ActionEvent event) throws ClassNotFoundException, JRException, SQLException {
        InputStream is = this.getClass().getResourceAsStream("/lk/betting/reports/RegisteredBetters.jasper");
        Connection connection = DBConnection.getInstance().getConnection();
        JasperPrint print = JasperFillManager.fillReport(is, null, connection);
        JasperViewer.viewReport(print, false);
    }

    @FXML
    private void registeredPlayers(ActionEvent event) throws ClassNotFoundException, JRException, SQLException {
        InputStream is = this.getClass().getResourceAsStream("/lk/betting/reports/RegisteredPlayers.jasper");
        Connection connection = DBConnection.getInstance().getConnection();
        JasperPrint print = JasperFillManager.fillReport(is, null, connection);
        JasperViewer.viewReport(print, false);
    }

    public void showDialog() {
        Text title = new Text("Terms & Conditions For Registation");
        title.setFont(Font.font("arial", FontWeight.SEMI_BOLD, FontPosture.REGULAR, 13));
        String content = "Children can not regster as a Player or,\na Better. "
                + "They can get only Spectator \nTickets for enterance.If the age over 18 \nwho can register as a Player or a Better\n\n"
                + "Please Enter Correct & Permenant Details \nPlayers & Betters can't change or Update their\nDetails \n\n"
                + "Thanks\nJ. Ishan Randika,\nYour Manager";
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

    @FXML
    private void conditions(MouseEvent event) {
        showDialog();

    }

    public static JudgersDTO searchJu(String juNIC) throws ClassNotFoundException, SQLException, Exception {
        return bo.searchJu(juNIC);
    }

    @FXML
    private void jadgeNIC(KeyEvent event) throws SQLException, Exception {

        if (event.getCode() == KeyCode.SPACE) {
            if (Pattern.compile("^[0-9]{9}[V]{1}$").matcher(txtJuNIC.getText()).matches() || Pattern.compile("^[0-9]{11}$").matcher(txtJuNIC.getText()).matches()) {

                String juNIC = txtJuNIC.getText();
                JudgersDTO searchJudgers = RegisterFormController.searchJu(juNIC);
                clearAllJudger();
                txtJuName.setText(searchJudgers.getJuName());
                txtJuNIC.setText(searchJudgers.getJuNIC());
                txtJuMobile.setText(searchJudgers.getJuMobile());
                txtJuEmail.setText(searchJudgers.getJuEmail());

            } else {
                txtJuNIC.requestFocus();
                Alert a = new Alert(Alert.AlertType.ERROR, "Input Judjer's NIC format is Invalid", ButtonType.OK);
                a.show();
            }

        }
        if (event.getCode() == KeyCode.ENTER) {
            if (Pattern.compile("^[0-9]{9}[V]{1}$").matcher(txtJuNIC.getText()).matches() || Pattern.compile("^[0-9]{11}$").matcher(txtJuNIC.getText()).matches()) {
                txtJuMobile.requestFocus();

            } else {
                txtJuNIC.requestFocus();
                Alert a = new Alert(Alert.AlertType.ERROR, "Input Judjer's NIC format is Invalid", ButtonType.OK);
                a.show();
            }
        }
    }

    public static boolean UpdateJudgers(JudgersDTO judgers) throws SQLException, ClassNotFoundException, Exception {
        return bo.UpdateJudgers(judgers);
    }

    @FXML
    private void juUpdate(ActionEvent event) {

        try {
            String juName = txtJuName.getText();
            String juNIC = txtJuNIC.getText();
            String juMobile = txtJuMobile.getText();
            String juEmail = txtJuEmail.getText();

            JudgersDTO judgers = new JudgersDTO();
            judgers.setJuName(juName);
            judgers.setJuNIC(juNIC);
            judgers.setJuEmail(juEmail);
            judgers.setJuMobile(juMobile);

            boolean addCom = RegisterFormController.UpdateJudgers(judgers);

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

    }

    @FXML
    private void juconditions(MouseEvent event) {
        showDialogju();
    }

    public void showDialogju() {
        Text title = new Text("Terms & Conditions For Judgers Registation");
        title.setFont(Font.font("arial", FontWeight.SEMI_BOLD, FontPosture.REGULAR, 13));
        String content = "Please enter correct & permenant details,because judgers \ncan change only  "
                + "their mobile number before their registation. \n\n"
                + "Thanks\nJ. Ishan Randika,\nYour Manager";
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
