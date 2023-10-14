//package com.example.login_page;/*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
//
///**
// *
// * @author nur kn3n
// */
//
//import com.example.login_page.DatabaseConnection;
//
//import java.net.URL;
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ResourceBundle;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.fxml.Initializable;
//import javafx.scene.Node;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.TextField;
//import javafx.stage.Stage;
//
//
//
//public class PERSONAL_INFOCONTROLLER implements Initializable {
//    Connection con=DBConnector1.getConnection();
//    @FXML TextField firstname;
//    @FXML TextField lastname;
//    @FXML TextField phonenumber;
//    account acc=new account();
//    public void getInfo(account acc){
//        this.acc=acc;
//    }
//
//
//    public void  submitChangesHandler(ActionEvent event)throws Exception{
//        Statement st=null;
//        ResultSet rs=null;
//        if(!firstname.getText().isEmpty()){
//            try{
//                st=con.createStatement();
//                rs=st.executeQuery("UPDATE gym SET FIRSTNAME="+firstname.getText()+"WHERE EMAIL="+acc.getEmail()+";");
//                while(rs.next()){
//                    System.out.println("user registered");
//                }
//            }
//            catch(SQLException e){
//                e.printStackTrace();
//            }
//
//        }
//        if(!lastname.getText().isEmpty()){
//            try{
//                st=con.createStatement();
//                rs=st.executeQuery("UPDATE gym SET LASTNAME="+lastname.getText()+"WHERE EMAIL="+acc.getEmail()+";");
//                while(rs.next()){
//                    System.out.println("user registered");
//                }
//            }
//            catch(SQLException e){
//                e.printStackTrace();
//            }
//
//        }
//        if(!phonenumber.getText().isEmpty()){
//            try{
//                st=con.createStatement();
//                rs=st.executeQuery("UPDATE gym SET PHONE="+phonenumber.getText()+"WHERE EMAIL="+acc.getEmail()+";");
//                while(rs.next()){
//                    System.out.println("user registered");
//                }
//            }
//            catch(SQLException e){
//                e.printStackTrace();
//            }
//
//        }
//    }
//    public void backHandler(ActionEvent event)throws Exception{
//        Parent table;
//        table = FXMLLoader.load(getClass().getResource("S.fxml"));
//        Scene scene=new Scene(table);
//        scene.setRoot(table);
//        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
//        window.setScene(scene);
//        window.show();
//
//
//
//    }
//
//
//
//
//
//
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//
//    }
//}