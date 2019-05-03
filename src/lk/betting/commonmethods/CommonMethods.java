package lk.betting.commonmethods;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;

public class CommonMethods {

    public static boolean confirmed = false;
    public static boolean disablelogin = true;
    private double initialx, initialy;
    protected static String page = "";
    public static boolean loggedout = false;

    public void handleClose(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    public void disableAllFocus(Pane pane) {
        for (Node n : pane.getChildren()) {
            if (n instanceof JFXButton) {
                ((JFXButton) n).setDisableVisualFocus(true);
            } else if ((n instanceof AnchorPane) || (n instanceof HBox)) {
                disableAllFocus((Pane) n);
            }
        }
    }

    public void logout(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        AnchorPane mainpane = (AnchorPane) ((Node) event.getSource()).getParent();
        mainpane.setEffect(new ColorAdjust(0, 0, -0.25, 0));
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/lk/betting/view/logoutpop.fxml"));
            Stage popup = new Stage();
            Scene scene = new Scene(parent);
            popup.initOwner(stage);
            popup.setScene(scene);
            popup.initStyle(StageStyle.UNDECORATED);
            popup.initModality(Modality.APPLICATION_MODAL);
            popup.showAndWait();
            if (confirmed == true) {
                stage.close();
                loadLogin();
            } else {
                disableAllFocus(mainpane);
                mainpane.setEffect(new ColorAdjust(0, 0, 0, 0));
            }
        } catch (IOException ex) {
            System.out.println("Error in switching stages logout btn");
            ex.printStackTrace();
        }
    }

    public void logouts(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        AnchorPane mainpane = (AnchorPane) ((Node) event.getSource()).getParent().getParent();
        mainpane.setEffect(new ColorAdjust(0, 0, -0.25, 0));
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/lk/betting/view/logoutpop.fxml"));
            Stage popup = new Stage();
            Scene scene = new Scene(parent);

            popup.initOwner(stage);
            popup.setScene(scene);
            popup.initStyle(StageStyle.UNDECORATED);
            popup.initModality(Modality.APPLICATION_MODAL);
            popup.showAndWait();
            if (confirmed == true) {
                stage.close();
                loadLogin();
            } else {
                disableAllFocus(mainpane);
                mainpane.setEffect(new ColorAdjust(0, 0, 0, 0));
            }
        } catch (IOException ex) {
            System.out.println("Error in switching stages logout btn");
            ex.printStackTrace();
        }
    }

    public void close(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        AnchorPane mainpane = (AnchorPane) ((Node) event.getSource()).getParent().getParent();
        mainpane.setEffect(new ColorAdjust(0, 0, -0.25, 0));
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/lk/betting/view/Closepop.fxml"));
            Stage popup = new Stage();
            Scene scene = new Scene(parent);

            popup.initOwner(stage);
            popup.setScene(scene);
            popup.initStyle(StageStyle.UNDECORATED);
            popup.initModality(Modality.APPLICATION_MODAL);
            popup.showAndWait();
            if (confirmed == true) {
                stage.close();
            } else {
                disableAllFocus(mainpane);
                mainpane.setEffect(new ColorAdjust(0, 0, 0, 0));
            }
        } catch (IOException ex) {
            System.out.println("Error in switching stages logout btn");
            ex.printStackTrace();
        }
    }

    public void loadLogin() {
        try {
            loggedout = true;
            Parent parent = FXMLLoader.load(getClass().getResource("/lk/betting/view/LoginForm.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.show();
        } catch (IOException ex) {
            System.out.println("Error in switching stages");
        }
    }

    public void moveWindow(Pane pane) {
        pane.setOnMousePressed(e -> {
            initialx = e.getSceneX();
            initialy = e.getSceneY();
        });
        pane.setOnMouseDragged(e -> {
            Node source = (Node) e.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            stage.setX(e.getScreenX() - initialx);
            stage.setY(e.getScreenY() - initialy);
        });
    }

}
