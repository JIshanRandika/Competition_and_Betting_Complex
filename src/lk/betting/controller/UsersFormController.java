/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.betting.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import static lk.betting.controller.LoginFormController.infoBox;
import lk.betting.db.DBConnection;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import lk.betting.bo.BOFactory;
import lk.betting.bo.custom.UserBO;
import lk.betting.dto.LoginDTO;
import lk.betting.dto.UserDTO;
import lk.betting.entity.User;
import lk.betting.tablemodal.UserTM;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 * FXML Controller class
 *
 * @author Your Name <Ishan Randika>
 */
public class UsersFormController implements Initializable {

    @FXML
    private Pane titleBar;
    @FXML
    private JFXTextField txtUserName;
    @FXML
    private JFXTextField txtUserAddress;
    @FXML
    private JFXTextField txtUserMobile;
    @FXML
    private JFXTextField txtNIC;
    @FXML
    private JFXTextField txtUserBOD;
    @FXML
    private JFXTextField txtUserEmail;
    @FXML
    private JFXButton btnUpdate;
    @FXML
    private JFXButton btnRegister;
    @FXML
    private TableView<UserTM> tblUsers;
    @FXML
    private JFXButton btnRemove;
    @FXML
    private JFXButton btnClose;
    @FXML
    private JFXButton btnMin;
    @FXML
    private JFXPasswordField txtUserPassword;
    @FXML
    private JFXPasswordField txtUserComfirmPassword;
    @FXML
    private Label lblDate;
    @FXML
    private ImageView profilePic;
    @FXML
    private Label lblID;
    @FXML
    private JFXButton btnUsersReport;
    @FXML
    private ImageView logo;
    @FXML
    private Pane bottom;
    @FXML
    private JFXButton btnlogout;
    @FXML
    private ImageView image;
    @FXML
    private Pane pane01;
    @FXML
    private Pane profilePane;
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
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(24));
        transition.setToX(808);
//        transition.setToY(500);
        transition.setAutoReverse(true);
        transition.setCycleCount(Animation.INDEFINITE);
        transition.setNode(ishan);
        transition.play();

        Image image = new Image("/lk/betting/image/PageUsers.jpg");
        this.image.setImage(image);
        Image logo = new Image("/lk/betting/image/logo.png");
        this.logo.setImage(logo);
        Image p = new Image("/lk/betting/image/p.png");
        this.profilePic.setImage(p);

        tblUsers.getColumns().get(0).setStyle("-fx-alignment: CENTER;");
        tblUsers.getColumns().get(1).setStyle("-fx-alignment: CENTER;");
        tblUsers.getColumns().get(2).setStyle("-fx-alignment: CENTER;");
        tblUsers.getColumns().get(3).setStyle("-fx-alignment: CENTER;");
        tblUsers.getColumns().get(4).setStyle("-fx-alignment: CENTER;");
        tblUsers.getColumns().get(5).setStyle("-fx-alignment: CENTER;");
        tblUsers.getColumns().get(6).setStyle("-fx-alignment: CENTER;");

//        --------------------------------------------------------------------
        tblUsers.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblUsers.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblUsers.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("nic"));
        tblUsers.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("address"));
        tblUsers.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("dob"));
        tblUsers.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("mobile"));
        tblUsers.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("email"));

        
        try {
            loadAll();
        } catch (Exception ex) {
            Logger.getLogger(UsersFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
//        try {
//            loadAll();
//
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(UsersFormController.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(UsersFormController.class.getName()).log(Level.SEVERE, null, ex);
//        }
        loadOrdeID();
        setDate();

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                txtUserName.requestFocus();
            }
        });

        // TODO
    }

    static UserBO bo = (UserBO) BOFactory.getInstace().getBO(BOFactory.BOTypes.USERS);

    public static boolean registerUser(UserDTO user) throws SQLException, ClassNotFoundException, Exception {
        System.out.println("Controller");
        return bo.registerUser(user);

    }

    public static boolean UpdateUser(UserDTO user) throws SQLException, ClassNotFoundException, Exception {
        return bo.UpdateUser(user);
    }

    public static boolean removeUser(String userID) throws SQLException, ClassNotFoundException, Exception {
        return bo.removeUser(userID);
    }

    public static ArrayList<UserTM> getAllUsers() throws ClassNotFoundException, SQLException, Exception {
        return bo.getAllUsers();
    }
    
     public static ResultSet getimage(String nic) throws SQLException, ClassNotFoundException, Exception {
        return bo.getimage(nic);
    }
    
    
    
    private void loadOrdeID() {
        int i = new Random().nextInt(90000);
        lblID.setText("U" + i);
    }

    private void setDate() {
        lblDate.setText(LocalDate.now().toString());
    }

    double x, y;

    @FXML
    private void dragged(MouseEvent event) {
        Stage stage = (Stage) titleBar.getScene().getWindow();
        stage.setX(x = event.getScreenX());
        stage.setY(y = event.getScreenY());
    }

    boolean updateUser;

    @FXML
    private void update(ActionEvent event) throws ParseException, Exception {
        try {
            String userID = lblID.getText();
            String userName = txtUserName.getText();
            String u_NIC = txtNIC.getText();
            String mobile_No = txtUserMobile.getText();
            String u_Email = txtUserEmail.getText();
            String u_Address = txtUserAddress.getText();
            String bod = txtUserBOD.getText();

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

            Date date = formatter.parse(bod);
//            Date.parseInt(txtUserBOD.getText());
//            String password = txtUserPassword.getText();

//            ====================
//     String email = textEmail.getText();
            String password = txtUserPassword.getText();
//==================
            LoginDTO login = new LoginDTO();
            login.setPassword(password);
            login.setU_Email(u_Email);

            boolean log = LoginFormController.login(login);
//  ================      
            try {
//            Connection connection = DBConnection.getInstance().getConnection();
//            String sql = "SELECT * FROM users WHERE U_Email = ? and password =MD5(?)";
//            PreparedStatement pstm = connection.prepareStatement(sql);
//            pstm.setString(1, u_Email);
//            pstm.setString(2, password);
//            ResultSet rst = pstm.executeQuery();
                if (!log) {
                    infoBox("Please enter correct Password", null, "Failed");
                } else {

                    UserDTO tempuser = new UserDTO(userID, userName, u_NIC, mobile_No, u_Email, u_Address, date, imgPath);

                    updateUser = UsersFormController.UpdateUser(tempuser);
                    System.out.println("Test2");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
//        ====================================================================

//            User tempuser = new User(userID, userName, u_NIC, mobile_No, u_Email, u_Address, bod);
//            
//            boolean updateUser = UsersFormController.updateUsers(tempuser);
            if (updateUser) {
                System.out.println("Test 1");
                Alert a = new Alert(Alert.AlertType.INFORMATION, "User Updated...!", ButtonType.OK);
                a.show();
//                JOptionPane.showMessageDialog(this, "Customer Updated...!");
//                loadAllCustomer();
                loadAll();
                clearAll();

            } else {
                Alert a = new Alert(Alert.AlertType.WARNING, "User Not Updated...!", ButtonType.OK);
                a.show();
//                JOptionPane.showMessageDialog(this, "Customer Not Updated...!", "Warning", JOptionPane.WARNING_MESSAGE);
            }

        } catch (ClassNotFoundException ex) {
            Alert a = new Alert(Alert.AlertType.ERROR, "Exeption!", ButtonType.OK);
            a.show();
//            JOptionPane.showMessageDialog(this, ex.getMessage(), "Exeption", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            Alert a = new Alert(Alert.AlertType.ERROR, "Exeption!", ButtonType.OK);
            a.show();
//            JOptionPane.showMessageDialog(this, ex.getMessage(), "Exeption", JOptionPane.ERROR_MESSAGE);
        }

    }

    //                userID,U_Name,U_NIC,Mobile_No,U_Email,U_Address,BOD,image
//    public static boolean updateUsers(User user) throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getInstance().getConnection();
//        String sql = "update users set U_Name=?, U_NIC=? ,Mobile_No=? ,U_Email=?, U_Address=?,image=?  where userID=?";
//        PreparedStatement pstm = connection.prepareStatement(sql);
//        pstm.setObject(7, user.getUserID());
//        pstm.setObject(1, user.getU_Name());
//        pstm.setObject(2, user.getU_NIC());
//        pstm.setObject(3, user.getMobile_No());
//        pstm.setObject(4, user.getU_Email());
//        pstm.setObject(5, user.getU_Address());
//        pstm.setObject(6, user.getImage());
//        return pstm.executeUpdate() > 0;
//    }
    String password;

    @FXML
    private void register(ActionEvent event) throws SQLException, ClassNotFoundException, Exception {
        try {
            String userID = lblID.getText();
            String userName = txtUserName.getText();
            String u_NIC = txtNIC.getText();
            String mobile_No = txtUserMobile.getText();
            String u_Email = txtUserEmail.getText();
            String u_Address = txtUserAddress.getText();

            String bod = txtUserBOD.getText();

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

            Date date = formatter.parse(bod);

            System.out.println(formatter.format(date));

//            formatter.format(date)
//            String password=txtUserPassword.getText();
            if (txtUserPassword.getText().equals(txtUserComfirmPassword.getText())) {
                password = txtUserPassword.getText();
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR, "Not compatible password", ButtonType.OK);
                a.show();

            }

            UserDTO user = new UserDTO();

            user.setUserID(userID);
            user.setU_Name(userName);
            user.setU_NIC(u_NIC);
            user.setMobile_No(mobile_No);
            user.setU_Email(u_Email);
            user.setU_Address(u_Address);
            user.setbOD(date);
            user.setPassword(password);
            user.setImage(imgPath);

            boolean regUsers = UsersFormController.registerUser(user);

            if (regUsers) {
//                loadAllCustomer();
                loadAll();
                clearAll();
                Alert a = new Alert(Alert.AlertType.INFORMATION, "Done", ButtonType.OK);
                a.show();
//                JOptionPane.showMessageDialog(rootPane, "Done", "Done", JOptionPane.INFORMATION_MESSAGE);
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR, "Not Done", ButtonType.OK);
                a.show();
            }

        } catch (NumberFormatException e) {
            Alert a = new Alert(Alert.AlertType.ERROR, "Error", ButtonType.OK);
            a.show();
        }
        txtUserName.requestFocus();
    }

    @FXML
    private void remove(ActionEvent event) throws Exception {

        try {
            String userID = lblID.getText();
            boolean deleteUser = UsersFormController.removeUser(userID);
            if (deleteUser) {
                clearAll();
                loadAll();
//                JOptionPane.showMessageDialog(this, "Customer Deleted...!");
                Alert a = new Alert(Alert.AlertType.INFORMATION, "User Deleted...!", ButtonType.OK);
                a.show();
            } else {
                Alert a = new Alert(Alert.AlertType.WARNING, "User Not Deleted...!", ButtonType.OK);
                a.show();
//                JOptionPane.showMessageDialog(this, "Customer Not Deleted...!",
//                        "Warning", JOptionPane.WARNING_MESSAGE);
            }
//            loadAllCustomer();

        } catch (ClassNotFoundException ex) {
            Alert a = new Alert(Alert.AlertType.ERROR, "Not Done", ButtonType.OK);
            a.show();
//            JOptionPane.showMessageDialog(this, ex.getMessage(), "Exeption", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            Alert a = new Alert(Alert.AlertType.ERROR, "Not Done", ButtonType.OK);
            a.show();
//            JOptionPane.showMessageDialog(this, ex.getMessage(), "Exeption", JOptionPane.ERROR_MESSAGE);
        }
        txtUserName.requestFocus();
    }

//    public static boolean deleteUser(String id) throws ClassNotFoundException, SQLException {
//        Connection connection = DBConnection.getInstance().getConnection();
//        String sql = "delete from users where userID=?";
//        PreparedStatement pstm = connection.prepareStatement(sql);
//        pstm.setObject(1, id);
//        return pstm.executeUpdate() > 0;
//    }
    @FXML
    private void close(ActionEvent event) {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void min(ActionEvent event) {
        Stage stage = (Stage) btnMin.getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    private void txtName(ActionEvent event) {
        txtNIC.requestFocus();

    }

    @FXML
    private void txtAddress(ActionEvent event) {
        txtUserMobile.requestFocus();
    }

    @FXML
    private void txtMobile(ActionEvent event) {
        if (Pattern.compile("^[+]{1}(94)[-]{1}[0-9]{9}$").matcher(txtUserMobile.getText()).matches()) {
            txtUserBOD.requestFocus();
        } else {
            txtUserMobile.requestFocus();
            Alert a = new Alert(Alert.AlertType.ERROR, "Input Mobile Number format is Invalid", ButtonType.OK);
            a.show();
        }

    }

    @FXML
    private void txtNIC(ActionEvent event) {
        if (Pattern.compile("^[0-9]{9}[V]{1}$").matcher(txtNIC.getText()).matches() || Pattern.compile("^[0-9]{11}$").matcher(txtNIC.getText()).matches()) {
            txtUserEmail.requestFocus();
        } else {
            txtNIC.requestFocus();
            Alert a = new Alert(Alert.AlertType.ERROR, "Input Leval-01-Player's NIC format is Invalid", ButtonType.OK);
            a.show();
        }
//        
//        try {
//            String nic =  txtUserName.getText();
//            User searchUser = UsersFormController.searchUser(nic);
////            clearAll();
//            lblID.setText(searchUser.getUserID());
//            txtUserName.setText(searchUser.getU_Name());
//            txtNIC.setText(searchUser.getU_NIC());
//            txtUserAddress.setText(searchUser.getU_Address());
//            txtUserBOD.setText(searchUser.getbOD());
//            txtUserMobile.setText(searchUser.getMobile_No());
//            txtUserEmail.setText(searchUser.getU_Email());
//            
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(UsersFormController.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(UsersFormController.class.getName()).log(Level.SEVERE, null, ex);
//        }

    }

//    public static User searchUser(String nic) throws ClassNotFoundException, SQLException {
//        Connection connection = DBConnection.getInstance().getConnection();
//        String sql = "select (userID,U_Name,U_NIC,Mobile_No,U_Email,U_Address,BOD,image) from users  where U_NIC=?";
//        PreparedStatement pstm = connection.prepareStatement(sql);
//        pstm.setObject(1, nic);
//        ResultSet rst = pstm.executeQuery();
//        User user = null;
//        while (rst.next()) {
//            user = new User(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6), rst.getString(7), rst.getString(8));
//        }
//        return user;
//    }
    @FXML
    private void txtBOD(ActionEvent event) {
        if (Pattern.compile("^[0-9]{4}[-]{1}[0-9]{2}[-]{1}[0-9]{2}$").matcher(txtUserBOD.getText()).matches()) {
            txtUserPassword.requestFocus();
        } else {
            txtUserBOD.requestFocus();
            Alert a = new Alert(Alert.AlertType.ERROR, "Input BOD format is Invalid->[YYYY-MM-DD]", ButtonType.OK);
            a.show();
        }

    }

    @FXML
    private void txtEmail(ActionEvent event) {
        if (Pattern.compile("[a-z0-9.]{1,}[@]{1}[a-z]{1,}[.]{1}(com)$").matcher(txtUserEmail.getText()).matches()) {
            txtUserAddress.requestFocus();
        } else {
            txtUserEmail.requestFocus();
            Alert a = new Alert(Alert.AlertType.ERROR, "Input Email Address format is Invalid", ButtonType.OK);
            a.show();
        }
    }

    @FXML
    private void txtPassword(ActionEvent event) {
        txtUserComfirmPassword.requestFocus();

    }

    @FXML
    private void txtComfirmPassword(ActionEvent event) {
    }
    static String imgPath = null;

    @FXML
    private void addImage(MouseEvent event) {
        // browse image

        JFileChooser file = new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.home")));
        //filter the files
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg", "gif", "png");
        file.addChoosableFileFilter(filter);
        int result = file.showSaveDialog(null);
        //if the user click on save in Jfilechooser
        if (result == JFileChooser.APPROVE_OPTION) {

            File selectedFile = file.getSelectedFile();
            String name = selectedFile.getName();

            System.out.println(name);

            javafx.scene.image.Image img = new javafx.scene.image.Image("/lk/betting/image/" + name);
//            img.getRequestedHeight();

            profilePic.setImage(img);
            imgPath = "/lk/betting/image/" + name;
        } //if the user click on save in Jfilechooser
        else if (result == JFileChooser.CANCEL_OPTION) {
            System.out.println("No File Select");
        }

    }

//    void loadAll() throws ClassNotFoundException, SQLException {

//        String id;
//        String name;
//        String nic;
//        String address;
//        String dob;
//        String mobile;
//        String email;
//
//        Connection connection = DBConnection.getInstance().getConnection();
//
//        String sql = "SELECT*FROM users";
//        PreparedStatement pstm = connection.prepareStatement(sql);
//        ResultSet rst = pstm.executeQuery();
//        //----------------------------------
//        ArrayList<UserTM> all = new ArrayList<>();
//        while (rst.next()) {
//            id = rst.getString(1);
//            name = rst.getString(2);
//            nic = rst.getString(3);
//            mobile = rst.getString(4);
//            email = rst.getString(5);
//            address = rst.getString(6);
//            dob = rst.getString(7);
//
//            UserTM UserTM = new UserTM(id, name, nic, address, dob, mobile, email);
//            all.add(UserTM);
//        }
//        //--------------------------------------
//
//        //----------------------------------------
//        tblUsers.setItems(FXCollections.observableArrayList(all));
//    }
    
    void loadAll() throws SQLException, Exception{
        
//         ArrayList<CustomerDTO> allCustomers = CustomerController.getAllCustomers();
         ArrayList<UserTM> loadall = UsersFormController.getAllUsers();
         
         tblUsers.setItems(FXCollections.observableArrayList(loadall));
    }
    

    @FXML
    private void tblUsersMouseClicked(MouseEvent event) throws ClassNotFoundException, SQLException, Exception {
        String selectedimg;
        UserTM selectedrow = tblUsers.getSelectionModel().getSelectedItem();

        txtUserName.setText(selectedrow.getName());
        txtNIC.setText(selectedrow.getNic());
        txtUserAddress.setText(selectedrow.getAddress());
        txtUserBOD.setText(selectedrow.getDob());
        txtUserEmail.setText(selectedrow.getEmail());
        txtUserMobile.setText(selectedrow.getMobile());
        lblID.setText(selectedrow.getId());

        
        ResultSet resultSet=UsersFormController.getimage(txtNIC.getText());
        
        
//        Connection connection = DBConnection.getInstance().getConnection();
//        String sql = "select image from users where U_NIC=?";
//        PreparedStatement pstm = connection.prepareStatement(sql);
//        pstm.setObject(1, txtNIC.getText());
//        ResultSet rst = pstm.executeQuery();
        while (resultSet.next()) {
            selectedimg = resultSet.getString(1);
            javafx.scene.image.Image img = new javafx.scene.image.Image(selectedimg);
            profilePic.setImage(img);
        }
        
    }

    public void clearAll() {
        txtNIC.setText("");
        txtUserAddress.setText("");
        txtUserBOD.setText("");
        txtUserComfirmPassword.setText("");
        txtUserEmail.setText("");
        txtUserMobile.setText("");
        txtUserName.setText("");
        txtUserPassword.setText("");
    }

    @FXML
    private void userReports(ActionEvent event) throws ClassNotFoundException, JRException, SQLException {
        InputStream is = this.getClass().getResourceAsStream("/lk/betting/reports/UserForm.jasper");
        Connection connection = DBConnection.getInstance().getConnection();
        JasperPrint print = JasperFillManager.fillReport(is, null, connection);
        JasperViewer.viewReport(print, false);
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
    private void back(ActionEvent event) throws IOException {
        Stage stage = (Stage) this.anchor.getScene().getWindow();
        Parent rt = FXMLLoader.load(getClass().getResource("/lk/betting/view/HomeForm.fxml"));
        Scene scen = new Scene(rt);
        stage.setScene(scen);
    }

}
