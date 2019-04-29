/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.betting.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
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
import lk.betting.bo.custom.PlayersLevalsBO;
import lk.betting.db.DBConnection;
import lk.betting.dto.PlayersLevalsDTO;
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
public class PlayersLevalsController extends CommonMethods implements Initializable {

    @FXML
    private Pane titleBar;
    @FXML
    private JFXButton btnMin;
    @FXML
    private JFXButton btnClose;
    @FXML
    private JFXTextField txtNIC;
    @FXML
    private JFXComboBox<String> cobCompetitionID;

    @FXML
    private JFXCheckBox checkBoxleval01;
    @FXML
    private JFXCheckBox checkBoxleval02;
    @FXML
    private JFXCheckBox checkBoxleval03;
    @FXML
    private JFXButton btnSave;
    @FXML
    private Pane pane02;
    @FXML
    private Pane pane01;
    @FXML
    private ImageView image;
    @FXML
    private ImageView logo;
    @FXML
    private Pane bottom;
    @FXML
    private JFXButton btnlogout;
    @FXML
    private AnchorPane anchor;
    @FXML
    private JFXButton btnBack;
    @FXML
    private JFXButton btnNew;
    @FXML
    private JFXButton btnCheckList;
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
                txtNIC.requestFocus();
            }
        });

        try {
            fillcombo();
        } catch (SQLException ex) {
            Alert a = new Alert(Alert.AlertType.ERROR, "Please Enter Details Correctly", ButtonType.OK);
            a.show();
        } catch (ClassNotFoundException ex) {
            Alert a = new Alert(Alert.AlertType.ERROR, "Please Enter Details Correctly", ButtonType.OK);
            a.show();
        } catch (Exception ex) {
            Alert a = new Alert(Alert.AlertType.ERROR, "Please Enter Details Correctly", ButtonType.OK);
            a.show();
        }
    }

    static PlayersLevalsBO bo = (PlayersLevalsBO) BOFactory.getInstace().getBO(BOFactory.BOTypes.PLAYERSLEVALS);

    public static ObservableList<String> fillcomboBox() throws ClassNotFoundException, SQLException, Exception {
        return bo.fillcomboBox();
    }

    public static boolean savePlayersLevals(PlayersLevalsDTO ju) throws SQLException, ClassNotFoundException, Exception {
        return bo.savePlayersLevals(ju);
    }

    private void fillcombo() throws SQLException, ClassNotFoundException, Exception {
        cobCompetitionID.setItems(fillcomboBox());
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
    private void nic(ActionEvent event) {
        if (Pattern.compile("^[0-9]{9}[V]{1}$").matcher(txtNIC.getText()).matches() || Pattern.compile("^[0-9]{11}$").matcher(txtNIC.getText()).matches()) {
            cobCompetitionID.requestFocus();
        } else {
            txtNIC.requestFocus();
            Alert a = new Alert(Alert.AlertType.ERROR, "Input Player NIC format is Invalid", ButtonType.OK);
            a.show();
        }
    }

    @FXML
    private void addcompetitionID(KeyEvent event) {

        if (event.getCode() == KeyCode.DOWN || event.getCode() == KeyCode.UP) {
            System.out.println("");
        }
        if (event.getCode() == KeyCode.ENTER) {
            checkBoxleval01.requestFocus();
        }
    }
    private boolean leval_01;
    private boolean leval_02;
    private boolean leval_03;

    @FXML
    private void selectLeval01(ActionEvent event) {
        if (checkBoxleval01.isSelected()) {
            leval_01 = true;
        } else {
            leval_01 = false;
        }
    }

    @FXML
    private void selectLeval02(ActionEvent event) {
        if (checkBoxleval02.isSelected()) {
            leval_02 = true;
        } else {
            leval_02 = false;
        }
    }

    @FXML
    private void selectLeval03(ActionEvent event) {
        if (checkBoxleval03.isSelected()) {
            leval_03 = true;
        } else {
            leval_03 = false;
        }
    }

    @FXML
    private void save(ActionEvent event) throws ClassNotFoundException, JRException, SQLException {
        try {
            boolean leval01 = leval_01;
            boolean leval02 = leval_02;
            boolean leval03 = leval_03;
            String plNIC = txtNIC.getText();
            String competitionID = cobCompetitionID.getSelectionModel().getSelectedItem();

            PlayersLevalsDTO players = new PlayersLevalsDTO();
            players.setPlNIC(plNIC);
            players.setC_ID(competitionID);
            players.setLeval_01(leval01);
            players.setLeval_02(leval02);
            players.setLeval_03(leval03);

            boolean addCom = PlayersLevalsController.savePlayersLevals(players);

            if (addCom) {
                Alert a = new Alert(Alert.AlertType.INFORMATION, "Done", ButtonType.OK);
                a.show();

            } else {
                Alert a = new Alert(Alert.AlertType.ERROR, "Error", ButtonType.OK);
                a.show();
            }

        } catch (NumberFormatException e) {
            Alert a = new Alert(Alert.AlertType.ERROR, "Please Enter Details Correctly", ButtonType.OK);
            a.show();

        } catch (Exception ex) {
            Alert a = new Alert(Alert.AlertType.ERROR, "Please Enter Details Correctly", ButtonType.OK);
            a.show();
        }

        InputStream is = this.getClass().getResourceAsStream("/lk/betting/reports/PlayersLevals.jasper");
        Connection connection = DBConnection.getInstance().getConnection();
        HashMap map = new HashMap();
        map.put("pnic", txtNIC.getText());
        map.put("cid", cobCompetitionID.getSelectionModel().getSelectedItem());
        JasperPrint print = JasperFillManager.fillReport(is, map, connection);
        JasperViewer.viewReport(print, false);

        clearAll();

        txtNIC.requestFocus();
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
        txtNIC.setText("");
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
    private void checkList(ActionEvent event) throws JRException, ClassNotFoundException, SQLException {
        InputStream is = this.getClass().getResourceAsStream("/lk/betting/reports/ListPlayersLevals.jasper");
        Connection connection = DBConnection.getInstance().getConnection();
        JasperPrint print = JasperFillManager.fillReport(is, null, connection);
        JasperViewer.viewReport(print, false);
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
