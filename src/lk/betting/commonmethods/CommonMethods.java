package lk.betting.commonmethods;

import com.jfoenix.controls.JFXButton;
import com.mysql.fabric.Server;
import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import java.io.IOException;

public class CommonMethods {

    public static boolean confirmed = false;      //used in loggin out
    public static boolean disablelogin = true;    //used for login btn animation
    public static String leftpanecolor = "";      //used for btn drop shadow colours
    private double initialx, initialy;          //used for dragging window
    protected static String page = "";            //used for keeping track of current pages
    private boolean rotatedpane = false;         //used for rotate pane animation
    public static String username = "";
    public static Server server = null;
    public static boolean loggedout = false;
    public static boolean running = true;
    private boolean loading = false;

    public void handleClose(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    public void displayUserName(Label label) {
        label.setText("Logged in as: " + username);
    }

    public AnchorPane findPane(AnchorPane parent, String id) {
        if (parent.getId().equals(id)) {
            return parent;
        }
        for (Node node : parent.getChildren()) {
            if (node.getId().equals(id)) {
                return (AnchorPane) node;
            }
        }
        return null;
    }

    public void loadScene(ActionEvent event) {
        if (loading) {
            return;
        }
        loading = true;
        String newscene = "";
        CommonMethods.confirmed = false;
        if (((JFXButton) (event.getSource())).getId().equals("homebtn")) {
            newscene = "home.fxml";
        } else if (((JFXButton) (event.getSource())).getId().equals("moviescreensbtn")) {
            newscene = "movies.fxml";
        } else if (((JFXButton) (event.getSource())).getId().equals("addbtn")) {
            newscene = "checkout.fxml";
        } else if (((JFXButton) (event.getSource())).getId().equals("checkoutbtn")) {
            newscene = "checkout.fxml";
        }

        Timeline t = dropShadow(event, 0.75, leftpanecolor);
        t.play();
        String finalNewscene = newscene;
        t.setOnFinished(event1 -> {
            ((JFXButton) (event.getSource())).setEffect(null);
            if (finalNewscene.isEmpty()) {
                return;
            }
            try {
                Parent parent = FXMLLoader.load(getClass().getResource(finalNewscene));
                Node source = (Node) event.getSource();
                Stage stage = (Stage) source.getScene().getWindow();
                Scene scene = new Scene(parent);
                scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
                stage.setScene(scene);
                stage.show();
                loading = false;
            } catch (IOException ex) {
                System.out.println("Error in switching stages");
            }
        });
    }

    public void rotateButton(JFXButton btn) {
        if (rotatedpane == false) {
            rotatedpane = true;
            RotateTransition rt = new RotateTransition(Duration.millis(60), btn);
            rt.setByAngle(45);
            rt.setCycleCount(2);
            rt.setAutoReverse(true);
            rt.play();

            rt.setOnFinished(event -> {
                RotateTransition rt2 = new RotateTransition(Duration.millis(60), btn);
                rt2.setByAngle(-45);
                rt2.setCycleCount(2);
                rt2.setAutoReverse(true);
                rt2.play();
                rt2.setOnFinished(event1 -> rotatedpane = false);
            });
        }
    }

    public Timeline dropShadow(ActionEvent event, double shadowspread, String color) {
        JFXButton btn = (JFXButton) event.getSource();
        Color origcolor = Color.web(color);
        Color newcolor = origcolor.brighter();
        String darker = ("#" + newcolor.toString().substring(2, 8));
        DropShadow shadow = new DropShadow();
        shadow.setColor(Color.web(darker));
        shadow.setSpread(shadowspread);

        Timeline shadowAnimation = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(shadow.radiusProperty(), 0d)),
                new KeyFrame(Duration.millis(150), new KeyValue(shadow.radiusProperty(), 20d)));
        shadowAnimation.setAutoReverse(true);
        shadowAnimation.setCycleCount(2);
        Node target = btn;
        target.setEffect(shadow);
        return shadowAnimation;
    }

    public void tileHover(MouseEvent event) {
        AnchorPane pane = (AnchorPane) event.getSource();
        String original = pane.getStyle().substring(22, 29);
        Color origcolor = Color.web(original);

        Color newcolor = origcolor.darker();
        String darker = ("#" + newcolor.toString().substring(2, 8));
        pane.setStyle("-fx-background-color: " + darker);
        pane.setEffect(new Bloom(0.85));
    }

    public void tileExit(MouseEvent event) {
        AnchorPane pane = (AnchorPane) event.getSource();
        String original = pane.getStyle().substring(22, 29);
        Color origcolor = Color.web(original);

        Color newcolor = origcolor.brighter();
        String brighter = ("#" + newcolor.toString().substring(2, 8));
        pane.setStyle("-fx-background-color: " + brighter);
        pane.setEffect(new Bloom(1));

    }

    public void btnHover(MouseEvent event) {
        JFXButton btn = (JFXButton) event.getSource();
        Color origcolor = Color.web(leftpanecolor);
        Color newcolor = origcolor.darker();

        btn.setOpacity(1.0);
        String darker = ("#" + newcolor.toString().substring(2, 8));
        btn.setStyle("-fx-background-color: " + darker);
        btn.setEffect(new Bloom(0.75));
    }

    public void btnExit(MouseEvent event) {
        JFXButton btn = (JFXButton) event.getSource();
        if ((btn.getText().equals(page))) {
            btn.setOpacity(1.0);
        } else {
            btn.setOpacity(0.8);
        }
        btn.setStyle("-fx-background-color: transparent");
        btn.setEffect(new Bloom(1));
    }

    public void btnEffect(JFXButton btn) {
        String btncolor = btn.getStyle().substring(22, 29);
        Color origcolor = Color.web(btncolor);
        Color newcolor = origcolor.darker();
        String darker = ("#" + newcolor.toString().substring(2, 8));

        btn.setOnMouseEntered(event -> {
            btn.setStyle("-fx-background-color: " + darker);
            btn.setEffect(new Bloom(0.85));
        });
        String brighter = ("#" + origcolor.toString().substring(2, 8));
        btn.setOnMouseExited(event -> {
            btn.setStyle("-fx-background-color: " + brighter);
            btn.setEffect(new Bloom(1));
        });
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

    public void customiseWindowButtons(JFXButton closebtn, JFXButton minimisebtn) {
        closebtn.setOnMouseEntered(e -> {
            closebtn.setStyle("-fx-background-color:  #F6490D");
            closebtn.setEffect(new Bloom(0.7));
        });
        closebtn.setOnMouseExited(e -> {
            closebtn.setStyle("-fx-background-color: transparent");
            closebtn.setEffect(new Bloom(1));
        });

        minimisebtn.setOnMouseEntered(e -> {
            minimisebtn.setStyle("-fx-background-color:  #F6490D");
            minimisebtn.setEffect(new Bloom(0.7));
        });
        minimisebtn.setOnMouseExited(e -> {
            minimisebtn.setStyle("-fx-background-color: transparent");
            minimisebtn.setEffect(new Bloom(1));
        });
    }

    public void minimiseWindow(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.setIconified(true);
    }

    public void popNode(AnchorPane pane) {
        ScaleTransition st = new ScaleTransition(Duration.millis(800), pane);
        st.setFromX(0.5);
        st.setFromY(0.5);
        st.setToX(1.0);
        st.setToY(1.0);
        st.setRate(1.5);
        st.setCycleCount(1);
        st.play();
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

    public SequentialTransition popButton(JFXButton btn, double scale) {
        ScaleTransition st1 = new ScaleTransition(Duration.millis(200), btn);
        st1.setToX(scale);
        st1.setToY(scale);
        st1.setRate(1.5);
        st1.setCycleCount(1);

        ScaleTransition st2 = new ScaleTransition(Duration.millis(200), btn);
        st2.setToX(1);
        st2.setToY(1);
        st2.setRate(1.5);
        st2.setCycleCount(1);
        SequentialTransition transition = new SequentialTransition(btn, st1, st2);
        return transition;
    }
}
