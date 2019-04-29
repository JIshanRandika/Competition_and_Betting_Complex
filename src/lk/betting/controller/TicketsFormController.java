/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.betting.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Random;
import java.util.ResourceBundle;
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
import lk.betting.bo.custom.TicketsBO;
import lk.betting.db.DBConnection;
import lk.betting.dto.TicketsDTO;
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
public class TicketsFormController extends CommonMethods implements Initializable {

    @FXML
    private Pane titleBar;
    @FXML
    private JFXButton btnClose;
    @FXML
    private JFXButton btnMin;
    @FXML
    private ImageView logo;
    @FXML
    private AnchorPane anchor;
    @FXML
    private JFXTextField txtSpectatorID;
    @FXML
    private JFXComboBox<String> cobCompetitionID;
    @FXML
    private JFXTextField txtTicketNo;
    @FXML
    private JFXButton E1;
    @FXML
    private JFXButton E2;
    @FXML
    private JFXButton E3;
    @FXML
    private JFXButton E4;
    @FXML
    private JFXButton E5;
    @FXML
    private JFXButton E6;
    @FXML
    private JFXButton E7;
    @FXML
    private JFXButton E8;
    @FXML
    private JFXButton E9;
    @FXML
    private JFXButton E10;
    @FXML
    private JFXButton F1;
    @FXML
    private JFXButton F2;
    @FXML
    private JFXButton F3;
    @FXML
    private JFXButton F4;
    @FXML
    private JFXButton F5;
    @FXML
    private JFXButton F6;
    @FXML
    private JFXButton F7;
    @FXML
    private JFXButton F8;
    @FXML
    private JFXButton F9;
    @FXML
    private JFXButton F10;
    @FXML
    private JFXButton btnComfirmSeat;
    @FXML
    private Label lblSelectedSeat;
    @FXML
    private Pane pane01;
    @FXML
    private Pane bottom;
    @FXML
    private JFXButton btnBack;
    @FXML
    private JFXButton btnlogout;
    @FXML
    private ImageView image;
    @FXML
    private JFXButton btnNew;
    @FXML
    private Label ishan;
    @FXML
    private StackPane stackpane;
    @FXML
    private Label conditions;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        moveWindow(titleBar);

        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(30));
        transition.setToX(1000);
        transition.setAutoReverse(true);
        transition.setCycleCount(Animation.INDEFINITE);
        transition.setNode(ishan);
        transition.play();

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                txtSpectatorID.requestFocus();
            }
        });
        try {
            fillcombo();
        } catch (ClassNotFoundException ex) {
            Alert a = new Alert(Alert.AlertType.ERROR, "Please Enter Details Correctly", ButtonType.OK);
            a.show();
        } catch (Exception ex) {
            Alert a = new Alert(Alert.AlertType.ERROR, "Please Enter Details Correctly", ButtonType.OK);
            a.show();
        }
        Image logo = new Image("/lk/betting/image/logo.png");
        this.logo.setImage(logo);
        Image image = new Image("/lk/betting/image/Tickets.jpg");
        this.image.setImage(image);
    }
    static TicketsBO bo = (TicketsBO) BOFactory.getInstace().getBO(BOFactory.BOTypes.TICKETS);

    public static ObservableList<String> fillcomboBox() throws ClassNotFoundException, SQLException, Exception {
        return bo.fillcomboBox();
    }

    public static boolean comfirmSeat(TicketsDTO ti) throws SQLException, ClassNotFoundException, Exception {
        return bo.comfirmSeat(ti);

    }

    public static ResultSet getseat(String cid) throws SQLException, ClassNotFoundException, Exception {
        return bo.getseat(cid);
    }
    private String seatNo;

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
    private void spectatorID(ActionEvent event) {
        cobCompetitionID.requestFocus();
    }

    @FXML
    private void addcompetitionID(KeyEvent event) throws ClassNotFoundException, SQLException, Exception {
        if (event.getCode() == KeyCode.DOWN || event.getCode() == KeyCode.UP) {
            System.out.println("");
        }
        if (event.getCode() == KeyCode.ENTER) {
            bookedSeats();
            txtTicketNo.requestFocus();
        }
    }

    @FXML
    private void ticketNo(ActionEvent event) {
        int i = new Random().nextInt(9000000);
        txtTicketNo.setText("BC" + i);
    }

    private void fillcombo() throws SQLException, ClassNotFoundException, Exception {
        cobCompetitionID.setItems(fillcomboBox());
    }

    @FXML
    private void e1(ActionEvent event) {
        seatNo = "E1";
        lblSelectedSeat.setText(seatNo);

    }

    @FXML
    private void e2(ActionEvent event) {
        seatNo = "E2";
        lblSelectedSeat.setText(seatNo);
    }

    @FXML
    private void e3(ActionEvent event) {
        seatNo = "E3";
        lblSelectedSeat.setText(seatNo);
    }

    @FXML
    private void e4(ActionEvent event) {
        seatNo = "E4";
        lblSelectedSeat.setText(seatNo);
    }

    @FXML
    private void comfirmSeat(ActionEvent event) throws ClassNotFoundException, SQLException, JRException, Exception {

        try {
            String spectatorID = txtSpectatorID.getText();
            String competitionID = cobCompetitionID.getSelectionModel().getSelectedItem();
            String seat = seatNo;
            String ticketNo = txtTicketNo.getText();

            TicketsDTO tickets = new TicketsDTO();
            tickets.setS_ID(spectatorID);
            tickets.setC_ID(competitionID);
            tickets.setSheat_No(seat);
            tickets.setTicket_No(ticketNo);

            boolean addCom = TicketsFormController.comfirmSeat(tickets);

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

        InputStream is = this.getClass().getResourceAsStream("/lk/betting/reports/Tickets.jasper");
        Connection connection = DBConnection.getInstance().getConnection();
        HashMap map = new HashMap();
        map.put("sid", txtSpectatorID.getText());
        map.put("cid", cobCompetitionID.getSelectionModel().getSelectedItem());
        JasperPrint print = JasperFillManager.fillReport(is, map, connection);
        JasperViewer.viewReport(print, false);

        clearAll();
        bookedSeats();
        txtSpectatorID.requestFocus();
    }

    @FXML
    private void selectedSeat(MouseEvent event) {

    }

    void bookedSeats() throws ClassNotFoundException, SQLException, Exception {
        E1.setStyle("-fx-background-color:  #8EA6B4");
        E2.setStyle("-fx-background-color:  #8EA6B4");
        E3.setStyle("-fx-background-color:  #8EA6B4");
        E4.setStyle("-fx-background-color:  #8EA6B4");
        E5.setStyle("-fx-background-color:  #8EA6B4");
        E6.setStyle("-fx-background-color:  #8EA6B4");
        E7.setStyle("-fx-background-color:  #8EA6B4");
        E8.setStyle("-fx-background-color:  #8EA6B4");
        E9.setStyle("-fx-background-color:  #8EA6B4");
        E10.setStyle("-fx-background-color:  #8EA6B4");

        F1.setStyle("-fx-background-color:  #8EA6B4");
        F2.setStyle("-fx-background-color:  #8EA6B4");
        F3.setStyle("-fx-background-color:  #8EA6B4");
        F4.setStyle("-fx-background-color:  #8EA6B4");
        F5.setStyle("-fx-background-color:  #8EA6B4");
        F6.setStyle("-fx-background-color:  #8EA6B4");
        F7.setStyle("-fx-background-color:  #8EA6B4");
        F8.setStyle("-fx-background-color:  #8EA6B4");
        F9.setStyle("-fx-background-color:  #8EA6B4");
        F10.setStyle("-fx-background-color:  #8EA6B4");
        String seat;

        ResultSet resultSet = TicketsFormController.getseat(cobCompetitionID.getSelectionModel().getSelectedItem());
        Connection connection = DBConnection.getInstance().getConnection();

        while (resultSet.next()) {
            seat = resultSet.getString(1);
            if (seat.equals("E1")) {
                E1.setStyle("-fx-background-color:  #003399");
            }
            if (seat.equals("E2")) {
                E2.setStyle("-fx-background-color:  #003399");
            }
            if (seat.equals("E3")) {
                E3.setStyle("-fx-background-color:  #003399");
            }
            if (seat.equals("E4")) {
                E4.setStyle("-fx-background-color:  #003399");
            }
            if (seat.equals("E5")) {
                E5.setStyle("-fx-background-color:  #003399");
            }
            if (seat.equals("E6")) {
                E6.setStyle("-fx-background-color:  #003399");
            }
            if (seat.equals("E7")) {
                E7.setStyle("-fx-background-color:  #003399");
            }
            if (seat.equals("E8")) {
                E8.setStyle("-fx-background-color:  #003399");
            }
            if (seat.equals("E9")) {
                E9.setStyle("-fx-background-color:  #003399");
            }
            if (seat.equals("E10")) {
                E10.setStyle("-fx-background-color:  #003399");
            }

            if (seat.equals("F1")) {
                F1.setStyle("-fx-background-color:  #003399");
            }
            if (seat.equals("F2")) {
                F2.setStyle("-fx-background-color:  #003399");
            }
            if (seat.equals("F3")) {
                F3.setStyle("-fx-background-color:  #003399");
            }
            if (seat.equals("F4")) {
                F4.setStyle("-fx-background-color:  #003399");
            }
            if (seat.equals("F5")) {
                F5.setStyle("-fx-background-color:  #003399");
            }
            if (seat.equals("F6")) {
                F6.setStyle("-fx-background-color:  #003399");
            }
            if (seat.equals("F7")) {
                F7.setStyle("-fx-background-color:  #003399");
            }
            if (seat.equals("F8")) {
                F8.setStyle("-fx-background-color:  #003399");
            }
            if (seat.equals("F9")) {
                F9.setStyle("-fx-background-color:  #003399");
            }
            if (seat.equals("F10")) {
                F10.setStyle("-fx-background-color:  #003399");
            }
        }

    }

    @FXML
    private void back(ActionEvent event) throws IOException {
        Stage stage = (Stage) this.anchor.getScene().getWindow();
        Parent rt = FXMLLoader.load(getClass().getResource("/lk/betting/view/HomeForm.fxml"));
        Scene scen = new Scene(rt);
        stage.setScene(scen);
    }

    @FXML
    private void e5(ActionEvent event) {
        seatNo = "E5";
        lblSelectedSeat.setText(seatNo);
    }

    @FXML
    private void e6(ActionEvent event) {
        seatNo = "E6";
        lblSelectedSeat.setText(seatNo);
    }

    @FXML
    private void e7(ActionEvent event) {
        seatNo = "E7";
        lblSelectedSeat.setText(seatNo);
    }

    @FXML
    private void e8(ActionEvent event) {
        seatNo = "E8";
        lblSelectedSeat.setText(seatNo);
    }

    @FXML
    private void e9(ActionEvent event) {
        seatNo = "E9";
        lblSelectedSeat.setText(seatNo);
    }

    @FXML
    private void e10(ActionEvent event) {
        seatNo = "E10";
        lblSelectedSeat.setText(seatNo);
    }

    @FXML
    private void f1(ActionEvent event) {
        seatNo = "F1";
        lblSelectedSeat.setText(seatNo);
    }

    @FXML
    private void f2(ActionEvent event) {
        seatNo = "F2";
        lblSelectedSeat.setText(seatNo);
    }

    @FXML
    private void f3(ActionEvent event) {
        seatNo = "F3";
        lblSelectedSeat.setText(seatNo);
    }

    @FXML
    private void f4(ActionEvent event) {
        seatNo = "F4";
        lblSelectedSeat.setText(seatNo);
    }

    @FXML
    private void f5(ActionEvent event) {
        seatNo = "F5";
        lblSelectedSeat.setText(seatNo);
    }

    @FXML
    private void f6(ActionEvent event) {
        seatNo = "F6";
        lblSelectedSeat.setText(seatNo);
    }

    @FXML
    private void f7(ActionEvent event) {
        seatNo = "F7";
        lblSelectedSeat.setText(seatNo);
    }

    @FXML
    private void f8(ActionEvent event) {
        seatNo = "F8";
        lblSelectedSeat.setText(seatNo);
    }

    @FXML
    private void f9(ActionEvent event) {
        seatNo = "F9";
        lblSelectedSeat.setText(seatNo);
    }

    @FXML
    private void f10(ActionEvent event) {
        seatNo = "F10";
        lblSelectedSeat.setText(seatNo);
    }

    public void clearAll() {
        txtTicketNo.setText("");
        txtSpectatorID.setText("");
    }

    @FXML
    private void btnnew(ActionEvent event) throws IOException {
        SequentialTransition fly = makeBtnFly(btnNew);
        fly.play();
        fly.setOnFinished(event1 -> {
            try {
                Stage stage = (Stage) this.anchor.getScene().getWindow();
                Parent rt = FXMLLoader.load(getClass().getResource("/lk/betting/view/SpectatorForm.fxml"));
                Scene scen = new Scene(rt);
                stage.setScene(scen);
            } catch (IOException ex) {
                Alert a = new Alert(Alert.AlertType.ERROR, "Your System has some detail errors, Please call your manager", ButtonType.OK);
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

    @FXML
    private void conditions(MouseEvent event) {
        showDialog();
    }

    public void showDialog() {
        Text title = new Text("Terms & Conditions For Tickets");
        title.setFont(Font.font("arial", FontWeight.SEMI_BOLD, FontPosture.REGULAR, 13));
        String content = "First spectator should pay money,\nbefore booking a seat and issue Tickets "
                + "\n\n"
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
