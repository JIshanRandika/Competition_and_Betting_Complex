/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.betting.main;

import java.awt.Color;
import static java.awt.Color.PINK;
import static java.awt.Color.red;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Your Name <Ishan Randika>
 */
public class Betting extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
//        Parent root = FXMLLoader.load(getClass().getResource("/lk/betting/view/LoginForm.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("/lk/betting/view/WonReports.fxml"));
        Scene scene = new Scene(root);
        stage.initStyle(StageStyle.UNDECORATED);
//       BackgroundFill background_fill = new BackgroundFill(PINK  
//                                          ); 
//VBox box = new VBox(20);
//  box.setMaxWidth(Region.USE_PREF_SIZE);
//  box.setMaxHeight(Region.USE_PREF_SIZE);
//  box.setBackground(Background.EMPTY);
//  String style = "-fx-background-color: rgba(255, 255, 255, 0.5);";
//  box.setStyle(style);

//  box.setPadding(new Insets(50));
//  BorderPane root = new BorderPane(box);
//  root.setStyle(style);
//  root.setBackground(Background.EMPTY);
//  Scene scene = new Scene(root);
//  scene.setFill(Color.TRANSPARENT);
//  stage.setScene(scene);        


        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
