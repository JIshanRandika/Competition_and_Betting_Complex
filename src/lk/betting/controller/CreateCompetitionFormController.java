/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.betting.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import java.io.IOException;
import java.io.InputStream;
import lk.betting.db.DBConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.animation.Animation;
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
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Duration;
import lk.betting.bo.BOFactory;
import lk.betting.bo.custom.CreateBetBO;
import lk.betting.bo.custom.CreateCompetitionBO;
import lk.betting.dto.CreateBetDTO;
import lk.betting.dto.CreateCompetitionDTO;
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
public class CreateCompetitionFormController extends CommonMethods implements Initializable {

    @FXML
    private Pane titleBar;
    @FXML
    private JFXButton btnClose;
    @FXML
    private JFXButton btnMin;
    @FXML
    private JFXDatePicker datePicker;
    @FXML
    private JFXTimePicker timePicker;
    @FXML
    private JFXButton btnCreateBet;
    @FXML
    private JFXTextField txtpoolno;
    @FXML
    private JFXTextField txtTracks;
    @FXML
    private JFXTextField txtcomID;
    @FXML
    private JFXTextField txtBetID;
    @FXML
    private JFXButton btnCheckBets;
    @FXML
    private JFXButton btnCheckCompetition;
    @FXML
    private JFXButton btnCreateCompetition;
    @FXML
    private ImageView image;
    @FXML
    private Pane pane02;
    @FXML
    private Pane pane01;
    @FXML
    private Pane bottom;
    @FXML
    private JFXButton btnlogout;
    @FXML
    private ImageView logo;
    @FXML
    private AnchorPane anchor;
    @FXML
    private JFXButton btnBack;
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
                txtcomID.requestFocus();
            }
        });
        Callback<DatePicker, DateCell> callB = new Callback<DatePicker, DateCell>() {
               @Override
               public DateCell call(final DatePicker param) {
                   return new DateCell() {
                       @Override
                       public void updateItem(LocalDate item, boolean empty) {
                           super.updateItem(item, empty); //To change body of generated methods, choose Tools | Templates.
                           LocalDate today = LocalDate.now();
                           setDisable(empty || item.compareTo(today) < 0);
                       }

                   };
               }

           };
           datePicker.setDayCellFactory(callB);
    }

    static CreateCompetitionBO bo = (CreateCompetitionBO) BOFactory.getInstace().getBO(BOFactory.BOTypes.CREATECOMPETITION);

    static CreateBetBO bobet = (CreateBetBO) BOFactory.getInstace().getBO(BOFactory.BOTypes.CREATEBET);

    public static boolean createCompetition(CreateCompetitionDTO crcom) throws SQLException, ClassNotFoundException, Exception {
        return bo.createCompetition(crcom);
    }

    public static boolean createBet(CreateBetDTO crbet) throws SQLException, ClassNotFoundException, Exception {
        return bobet.createBet(crbet);
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
    private void CreateBet(ActionEvent event) {
        int i = new Random().nextInt(90000);
        txtBetID.setText("Bet" + i);

        try {
            String competitionID = txtcomID.getText();
            String betID = txtBetID.getText();

            CreateBetDTO bet = new CreateBetDTO();
            bet.setCompetitionID(competitionID);
            bet.setBetID(betID);

            boolean addbet = CreateCompetitionFormController.createBet(bet);

            if (addbet) {
                Alert a = new Alert(Alert.AlertType.INFORMATION, "Done", ButtonType.OK);
                a.show();
            } else {
            }

        } catch (NumberFormatException e) {
            Alert a = new Alert(Alert.AlertType.ERROR, "Please Enter Details Correctly", ButtonType.OK);
            a.show();
        } catch (Exception ex) {
            Alert a = new Alert(Alert.AlertType.ERROR, "Please Enter Details Correctly", ButtonType.OK);
            a.show();
        }

        txtcomID.requestFocus();
    }

    @FXML
    private void checkBets(ActionEvent event) throws ClassNotFoundException, SQLException, JRException {
        InputStream is = this.getClass().getResourceAsStream("/lk/betting/reports/Check_Bets.jasper");
        Connection connection = DBConnection.getInstance().getConnection();
        JasperPrint print = JasperFillManager.fillReport(is, null, connection);
        JasperViewer.viewReport(print, false);
    }

    @FXML
    private void checkCompetition(ActionEvent event) throws ClassNotFoundException, SQLException, JRException {
        InputStream is = this.getClass().getResourceAsStream("/lk/betting/reports/Check_Competition.jasper");
        Connection connection = DBConnection.getInstance().getConnection();
        JasperPrint print = JasperFillManager.fillReport(is, null, connection);
        JasperViewer.viewReport(print, false);
    }

    @FXML
    private void createCompetition(ActionEvent event) {
        if (Pattern.compile("^[C]{1}[0-9]{1,}$").matcher(txtcomID.getText()).matches()) {

            try {
                String competitionID = txtcomID.getText();
                String competitionDate = datePicker.getValue().toString();
                String competitionTime = timePicker.getValue().toString();
                String poolNo = txtpoolno.getText();
                String tracks = txtTracks.getText();

                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                Date date = formatter.parse(competitionDate);

                LocalTime localTime = LocalTime.parse(competitionTime);

                CreateCompetitionDTO com = new CreateCompetitionDTO();
                com.setCompetitionID(competitionID);
                com.setCompetitionDate(date);
                com.setCompetitionTime(competitionTime);
                com.setPoolNo(poolNo);
                com.setTracks(tracks);

                boolean addCom = CreateCompetitionFormController.createCompetition(com);

                if (addCom) {
                    Alert a = new Alert(Alert.AlertType.INFORMATION, "Done", ButtonType.OK);
                    a.show();

                } else {
                }

            } catch (NumberFormatException e) {
                Alert a = new Alert(Alert.AlertType.ERROR, "Please Enter Details Correctly", ButtonType.OK);
                a.show();

            } catch (Exception ex) {
                Alert a = new Alert(Alert.AlertType.ERROR, "Please Enter Details Correctly", ButtonType.OK);
                a.show();
            }
            btnCreateBet.requestFocus();

        } else {
            txtcomID.requestFocus();
            Alert a = new Alert(Alert.AlertType.ERROR, "Input CompetitionID format is Invalid=>Cxxxxx x=0-9", ButtonType.OK);
            a.show();
        }
    }

    @FXML
    private void datePicker(ActionEvent event) {
        timePicker.requestFocus();
    }

    @FXML
    private void timePicker(ActionEvent event) {
        txtpoolno.requestFocus();
    }

    @FXML
    private void poolNo(ActionEvent event) {
        txtTracks.requestFocus();
    }

    @FXML
    private void tracks(ActionEvent event) {
        btnCreateCompetition.fire();
    }

    @FXML
    private void comID(ActionEvent event) {
        if (Pattern.compile("^[C]{1}[0-9]{1,}$").matcher(txtcomID.getText()).matches()) {
            datePicker.requestFocus();
        } else {
            txtcomID.requestFocus();
            Alert a = new Alert(Alert.AlertType.ERROR, "Input CompetitionID format is Invalid=>Cxxxxx x=0-9", ButtonType.OK);
            a.show();
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
    private void back(ActionEvent event) throws IOException {
        Stage stage = (Stage) this.anchor.getScene().getWindow();
        Parent rt = FXMLLoader.load(getClass().getResource("/lk/betting/view/OrganizingForm.fxml"));
        Scene scen = new Scene(rt);
        stage.setScene(scen);
    }
}
