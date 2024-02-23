package com.example.proiectsqljava_vapoare;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 780, 814);
        stage.setTitle("Proiect Baze de date-S09");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        String dbURL="jdbc:oracle:thin:@localhost:1521:XE";
        String username="system";
        String password="LKLTLPHT2udfu";

        try {
            Connection connection = DriverManager.getConnection(dbURL, username, password);
            System.out.println("S-a realizat conexiunea la server");


            /*String sql="INSERT INTO BATALII(NUME,DATA,LOCATIE)"+"VALUES('Batalia 5', TO_DATE('1999-12-09','YYYY-MM-DD'), 'Marea neagra')";
            Statement statement=connection.createStatement();
            int rows=statement.executeUpdate(sql);

            if(rows>0){
                System.out.println("a row has been inserted");
            }
            statement.close();
             */
            String sql="SELECT * FROM BATALII";

            Statement statement=connection.createStatement();
            ResultSet result=statement.executeQuery(sql);

            while(result.next()){
                String name=result.getString("NUME");
                String data=result.getString("DATA");
                String locatie=result.getString("locatie");
                //System.out.println(name+" | "+data+" | "+locatie);
            }

            connection.close();
        }catch (SQLException e){
            System.out.println("Nu s-a putut face legatura la baza de date.");
            e.printStackTrace();
        }



        launch();
    }
}