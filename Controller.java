package Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import java.sql.*;
import oracle.jdbc.OracleTypes;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import static javafx.scene.layout.CornerRadii.*;
import static javafx.scene.paint.Color.color;
import static javafx.scene.paint.Color.rgb;

public class Controller implements Initializable {





    @FXML
    private Button btnBatalii;

    @FXML
    private Button btnClase;

    @FXML
    private Button btnConsecinte;

    @FXML
    private Button btnNave;

    @FXML
    private Button btnQr11;

    @FXML
    private Button btnQr12;

    @FXML
    private Button btnQr21;

    @FXML
    private Button btnQr22;

    @FXML
    private Button btnQr31;

    @FXML
    private Button btnQr32;

    @FXML
    private Button btnQr41;

    @FXML
    private Button btnQr42;

    @FXML
    private TableColumn<?, ?> colC1;

    @FXML
    private TableColumn<?, ?> colC2;

    @FXML
    private TableColumn<?, ?> colC3;

    @FXML
    private TableColumn<?, ?> colC4;

    @FXML
    private TableColumn<?, ?> colC5;

    @FXML
    private TableColumn<?, ?> colC6;

    @FXML
    private VBox pnlStatus;

    @FXML
    private TableView<ObjectBuilder> tableView;

    @FXML
    private Label textNavBar;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //colC1.setCellValueFactory(new PropertyValueFactory<Nave,String>("C1"));
    }
    @FXML
    private void handleClicks(ActionEvent event){
        String dbURL="jdbc:oracle:thin:@localhost:1521:XE";
        String username="system";
        String password="LKLTLPHT2udfu";

        ObservableList<ObjectBuilder> tableList = FXCollections.observableArrayList();
        try {
            Connection connection = DriverManager.getConnection(dbURL, username, password);
            if(event.getSource()==btnNave){
                tableList.clear();
                tableView.setItems(tableList);
                textNavBar.setText(" Nave");
                pnlStatus.setBackground(new Background(new BackgroundFill(Color.rgb(115,163,193), EMPTY,Insets.EMPTY)));

                colC1.setText("NUME");
                colC2.setText("Clasa");
                colC3.setText("Anul_Lansarii");
                colC4.setText("-");
                colC5.setText("-");
                colC6.setText("-");

                colC1.setCellValueFactory(new PropertyValueFactory<>("col1"));
                colC2.setCellValueFactory(new PropertyValueFactory<>("col2"));
                colC3.setCellValueFactory(new PropertyValueFactory<>("col3"));
                colC4.setCellValueFactory(new PropertyValueFactory<>("col4"));
                colC5.setCellValueFactory(new PropertyValueFactory<>("col5"));
                colC6.setCellValueFactory(new PropertyValueFactory<>("col6"));
                String sql="SELECT * FROM Nave";

                Statement statement2=connection.createStatement();
                ResultSet result=statement2.executeQuery(sql);
                while(result.next()){
                    String nume=result.getString(1);
                    String clasa=result.getString(2);
                    String anulLansarii=result.getString(3);
                    String aux="-";
                    //System.out.println(clase+" | "+tip+" | "+tara+" | "+diamTun+" | "+nrArme+" | "+deplasament);
                    //Clase newClas= new Clase(clase,tip,tara,diamTun,nrArme,deplasament);
                    ObjectBuilder newObj = new ObjectBuilder(nume,clasa,anulLansarii,aux,aux,aux);
                    tableList.add(newObj);
                }
            }
            else if(event.getSource()==btnClase){
                tableList.clear();
                tableView.setItems(tableList);
                textNavBar.setText(" Clase");
                pnlStatus.setBackground(new Background(new BackgroundFill(Color.rgb(115,163,193), EMPTY,Insets.EMPTY)));

                colC1.setText("CLASA");
                colC2.setText("TIP");
                colC3.setText("Tara");
                colC4.setText("Diametru tun");
                colC5.setText("nr_arme");
                colC6.setText("deplasament");

                colC1.setCellValueFactory(new PropertyValueFactory<>("col1"));
                colC2.setCellValueFactory(new PropertyValueFactory<>("col2"));
                colC3.setCellValueFactory(new PropertyValueFactory<>("col3"));
                colC4.setCellValueFactory(new PropertyValueFactory<>("col4"));
                colC5.setCellValueFactory(new PropertyValueFactory<>("col5"));
                colC6.setCellValueFactory(new PropertyValueFactory<>("col6"));

                String sql="SELECT * FROM Clase";

                Statement statement=connection.createStatement();
                ResultSet result=statement.executeQuery(sql);

                while(result.next()){
                    String clase=result.getString(1);
                    String tip=result.getString(2);
                    String tara=result.getString(3);
                    String diamTun=result.getString(4);
                    String nrArme=result.getString(5);
                    String deplasament=result.getString(6);
                    System.out.println(clase+" | "+tip+" | "+tara+" | "+diamTun+" | "+nrArme+" | "+deplasament);
                   //Clase newClas= new Clase(clase,tip,tara,diamTun,nrArme,deplasament);
                    ObjectBuilder newObj = new ObjectBuilder(clase,tip,tara,diamTun,nrArme,deplasament);
                    tableList.add(newObj);
                }
            }
            else if(event.getSource()==btnBatalii){
                tableList.clear();
                tableView.setItems(tableList);
                textNavBar.setText(" Batalii");
                pnlStatus.setBackground(new Background(new BackgroundFill(Color.rgb(65,106 ,163), EMPTY,Insets.EMPTY)));


                colC1.setText("NUME");
                colC2.setText("DATA");
                colC3.setText("Locatie");
                colC1.setCellValueFactory(new PropertyValueFactory<>("col1"));
                colC2.setCellValueFactory(new PropertyValueFactory<>("col2"));
                colC3.setCellValueFactory(new PropertyValueFactory<>("col3"));
                colC4.setText("-");
                colC5.setText("-");
                colC6.setText("-");

                String sql="SELECT * FROM BATALII";

                Statement statement=connection.createStatement();
                ResultSet result=statement.executeQuery(sql);



                while(result.next()){
                    String name=result.getString("NUME");
                    String data=result.getString("DATA");
                    String locatie=result.getString(3);
                    String col41="-";
                    String col51="-";
                    String col61="-";
                    System.out.println(name+" | "+data+" | "+locatie);
                    //colC1.
                    //Nave batalieite = new Nave("a","b","apai");

                    //Nave newNave = new Nave(name, data, locatie);
                    //naveList.add(newNave);
                    ObjectBuilder newObgect= new ObjectBuilder(name,data,locatie,col41,col51,col61);
                    tableList.add(newObgect);
                }
                tableView.setItems(tableList);

            }
            else if(event.getSource()==btnConsecinte){
                tableList.clear();
                tableView.setItems(tableList);
                textNavBar.setText(" Consecinte");
                pnlStatus.setBackground(new Background(new BackgroundFill(Color.rgb(45,74,114), EMPTY,Insets.EMPTY)));

                colC1.setText("nava");
                colC2.setText("batalie");
                colC3.setText("rezultat");
                colC4.setText("-");
                colC5.setText("-");
                colC6.setText("-");

                colC1.setCellValueFactory(new PropertyValueFactory<>("col1"));
                colC2.setCellValueFactory(new PropertyValueFactory<>("col2"));
                colC3.setCellValueFactory(new PropertyValueFactory<>("col3"));
                colC4.setCellValueFactory(new PropertyValueFactory<>("col4"));
                colC5.setCellValueFactory(new PropertyValueFactory<>("col5"));
                colC6.setCellValueFactory(new PropertyValueFactory<>("col6"));



                String sql="SELECT * FROM CONSECINTE";

                Statement statement4=connection.createStatement();
                ResultSet result=statement4.executeQuery(sql);

                while(result.next()){
                    String name=result.getString(1);
                    String data=result.getString(2);
                    String locatie=result.getString(3);
                    String col41="-";
                    String col51="-";
                    String col61="-";
                    //System.out.println(name+" | "+data+" | "+locatie);
                    //colC1.
                    //Nave batalieite = new Nave("a","b","apai");

                    //Nave newNave = new Nave(name, data, locatie);
                    //naveList.add(newNave);
                    ObjectBuilder newObgect= new ObjectBuilder(name,data,locatie,col41,col51,col61);
                    tableList.add(newObgect);
                }
                tableView.setItems(tableList);
            }
            else if(event.getSource()==btnQr11){
                tableList.clear();
                tableView.setItems(tableList);
                textNavBar.setText("Denumirea clasei si tara pentru cls-le de tip crucișator cu\n" +
                        "deplasament între 4000 și 6000.");
                pnlStatus.setBackground(new Background(new BackgroundFill(Color.rgb( 21, 107,163 ), EMPTY,Insets.EMPTY)));

                colC1.setText("Clasa");
                colC2.setText("Tara");
                colC3.setText("-");
                colC4.setText("-");
                colC5.setText("-");
                colC6.setText("-");

                colC1.setCellValueFactory(new PropertyValueFactory<>("col1"));
                colC2.setCellValueFactory(new PropertyValueFactory<>("col2"));
                colC3.setCellValueFactory(new PropertyValueFactory<>("col3"));
                colC4.setCellValueFactory(new PropertyValueFactory<>("col4"));
                colC5.setCellValueFactory(new PropertyValueFactory<>("col5"));
                colC6.setCellValueFactory(new PropertyValueFactory<>("col6"));


                /*String sql="select clasa,tara\n" +
                        "                from clase\n" +
                        "                where tip='cr' and deplasament between 4000 and 6000";*/

                try (CallableStatement callableStatement = connection.prepareCall("{call proc1(?)}")) {
                    callableStatement.registerOutParameter(1, OracleTypes.CURSOR);
                    callableStatement.execute();
                    try (ResultSet resultSet = (ResultSet) callableStatement.getObject(1)) {
                        while (resultSet.next()) {
                            String name = resultSet.getString(1);
                            String data = resultSet.getString(2);
                            String aux="-";
                            // Process retrieved data as needed
                            ObjectBuilder newObgect= new ObjectBuilder(name,data,aux,aux,aux,aux);
                            tableList.add(newObgect);
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }


                tableView.setItems(tableList);
            }
            else if(event.getSource()==btnQr12){
                tableList.clear();
                tableView.setItems(tableList);

                pnlStatus.setBackground(new Background(new BackgroundFill(Color.rgb( 29 ,122,182), EMPTY,Insets.EMPTY)));

                textNavBar.setText(" Numele navelor și anul lansării pentru navele lansate după\n" +
                        "1975 ordonate descrescător după anul lansării.");

                colC1.setText("Nume");
                colC2.setText("Anul Lansarii");
                colC3.setText("-");
                colC4.setText("-");
                colC5.setText("-");
                colC6.setText("-");

                colC1.setCellValueFactory(new PropertyValueFactory<>("col1"));
                colC2.setCellValueFactory(new PropertyValueFactory<>("col2"));
                colC3.setCellValueFactory(new PropertyValueFactory<>("col3"));
                colC4.setCellValueFactory(new PropertyValueFactory<>("col4"));
                colC5.setCellValueFactory(new PropertyValueFactory<>("col5"));
                colC6.setCellValueFactory(new PropertyValueFactory<>("col6"));


                String sql="select nume, anul_lansarii from nave where anul_lansarii>1975 order by anul_lansarii desc";
                Statement statement6=connection.createStatement();
                ResultSet result=statement6.executeQuery(sql);


                while(result.next()){
                    String name=result.getString(1);
                    String data=result.getString(2);
                    String col31="-";
                    String col41="-";
                    String col51="-";
                    String col61="-";

                    ObjectBuilder newObgect= new ObjectBuilder(name,data,col31,col41,col51,col61);
                    tableList.add(newObgect);
                }
                tableView.setItems(tableList);
            }
            else if(event.getSource()==btnQr21){
                tableList.clear();
                tableView.setItems(tableList);

                pnlStatus.setBackground(new Background(new BackgroundFill(Color.rgb(43 ,137, 198), EMPTY,Insets.EMPTY)));

                textNavBar.setText(" Numele, deplasamentul și numărul de arme pentru navele\n" +
                        "angrenate în bătălia ‘Battle of Chemulpo Bay’.");

                colC1.setText("Numele");
                colC2.setText("Deplasamentul");
                colC3.setText("Numar Arme");
                colC4.setText("-");
                colC5.setText("-");
                colC6.setText("-");

                colC1.setCellValueFactory(new PropertyValueFactory<>("col1"));
                colC2.setCellValueFactory(new PropertyValueFactory<>("col2"));
                colC3.setCellValueFactory(new PropertyValueFactory<>("col3"));
                colC4.setCellValueFactory(new PropertyValueFactory<>("col4"));
                colC5.setCellValueFactory(new PropertyValueFactory<>("col5"));
                colC6.setCellValueFactory(new PropertyValueFactory<>("col6"));


                String sql="select nave.nume, clase.deplasament,clase.nr_arme\n" +
                        "from Nave\n" +
                        "inner join Consecinte ON Nave.nume=Consecinte.nava\n" +
                        "inner join Clase ON Nave.clasa=Clase.clasa\n";
                        //"where Consecinte.batalie='Battle of Chemulpo Bay'";
                Statement statement7=connection.createStatement();
                ResultSet result=statement7.executeQuery(sql);


                while(result.next()){
                    String name=result.getString(1);
                    String data=result.getString(2);
                    String col31=result.getString(3);
                    String col41="-";
                    String col51="-";
                    String col61="-";

                    ObjectBuilder newObgect= new ObjectBuilder(name,data,col31,col41,col51,col61);
                    tableList.add(newObgect);
                }
                tableView.setItems(tableList);
            }
            else if(event.getSource()==btnQr22){
                tableList.clear();
                tableView.setItems(tableList);
                pnlStatus.setBackground(new Background(new BackgroundFill(Color.rgb(64 ,150, 207), EMPTY,Insets.EMPTY)));
                textNavBar.setText(" Perechi de clase (clasa1, clasa2) ce aparțin aceleeași țări dar\n" +
                        "sunt de tipuri diferite.");

                colC1.setText("Numele");
                colC2.setText("Deplasamentul");
                colC3.setText("Numar Arme");
                colC4.setText("-");
                colC5.setText("-");
                colC6.setText("-");

                colC1.setCellValueFactory(new PropertyValueFactory<>("col1"));
                colC2.setCellValueFactory(new PropertyValueFactory<>("col2"));
                colC3.setCellValueFactory(new PropertyValueFactory<>("col3"));
                colC4.setCellValueFactory(new PropertyValueFactory<>("col4"));
                colC5.setCellValueFactory(new PropertyValueFactory<>("col5"));
                colC6.setCellValueFactory(new PropertyValueFactory<>("col6"));


                String sql="select distinct c1.clasa,c2.clasa\n" +
                        "from clase c1\n" +
                        "join clase c2 on c1.tara=c2.tara and c1.tip != c2.tip and c1.clasa<c2.clasa";

                Statement statement7=connection.createStatement();
                ResultSet result=statement7.executeQuery(sql);


                while(result.next()){
                    String name=result.getString(1);
                    String data=result.getString(2);
                    String col31=result.getString(3);
                    String col41="-";
                    String col51="-";
                    String col61="-";

                    ObjectBuilder newObgect= new ObjectBuilder(name,data,col31,col41,col51,col61);
                    tableList.add(newObgect);
                }
                tableView.setItems(tableList);
            }
            else if(event.getSource()==btnQr31){
                tableList.clear();
                tableView.setItems(tableList);

                pnlStatus.setBackground(new Background(new BackgroundFill(Color.rgb(83 ,161, 211), EMPTY,Insets.EMPTY)));
                textNavBar.setText(" Să se găsească detaliile claselor ce au cele mai puține arme.");

                colC1.setText("CLASA");
                colC2.setText("TIP");
                colC3.setText("Tara");
                colC4.setText("Diametru tun");
                colC5.setText("nr_arme");
                colC6.setText("deplasament");

                colC1.setCellValueFactory(new PropertyValueFactory<>("col1"));
                colC2.setCellValueFactory(new PropertyValueFactory<>("col2"));
                colC3.setCellValueFactory(new PropertyValueFactory<>("col3"));
                colC4.setCellValueFactory(new PropertyValueFactory<>("col4"));
                colC5.setCellValueFactory(new PropertyValueFactory<>("col5"));
                colC6.setCellValueFactory(new PropertyValueFactory<>("col6"));


                String sql="SELECT *\n" +
                        "FROM Clase c1\n" +
                        "WHERE NOT EXISTS (\n" +
                        "    SELECT 1\n" +
                        "    FROM Clase c2\n" +
                        "    WHERE c2.nr_arme < c1.nr_arme\n" +
                        ")";

                Statement statement7=connection.createStatement();
                ResultSet result=statement7.executeQuery(sql);


                while(result.next()){
                    String name=result.getString(1);
                    String data=result.getString(2);
                    String col31=result.getString(3);
                    String col41=result.getString(4);
                    String col51=result.getString(5);
                    String col61=result.getString(6);

                    ObjectBuilder newObgect= new ObjectBuilder(name,data,col31,col41,col51,col61);
                    tableList.add(newObgect);
                }
                tableView.setItems(tableList);
            }
            else if(event.getSource()==btnQr32){
                tableList.clear();
                tableView.setItems(tableList);

                pnlStatus.setBackground(new Background(new BackgroundFill(Color.rgb(102 ,172, 218), EMPTY,Insets.EMPTY)));
                textNavBar.setText(" Detaliile bătăliilor la care au participat navele clasei\n" +
                        "‘Ticonderoga’.");

                colC1.setText("NUME");
                colC2.setText("DATA");
                colC3.setText("Locatie");
                colC4.setText("-");
                colC5.setText("-");
                colC6.setText("-");


                colC1.setCellValueFactory(new PropertyValueFactory<>("col1"));
                colC2.setCellValueFactory(new PropertyValueFactory<>("col2"));
                colC3.setCellValueFactory(new PropertyValueFactory<>("col3"));
                colC4.setCellValueFactory(new PropertyValueFactory<>("col4"));
                colC5.setCellValueFactory(new PropertyValueFactory<>("col5"));
                colC6.setCellValueFactory(new PropertyValueFactory<>("col6"));


                String sql="SELECT Batalii.*\n" +
                        "FROM Batalii\n" +
                        "WHERE nume IN (\n" +
                        "    SELECT ce.batalie\n" +
                        "    FROM Consecinte ce\n" +
                        "    JOIN Nave n ON ce.nava = n.nume\n" +
                        "    JOIN Clase cl ON n.clasa = cl.clasa\n" +
                        "    WHERE cl.tip = 'tr'\n" +
                        ")";

                Statement statement7=connection.createStatement();
                ResultSet result=statement7.executeQuery(sql);


                while(result.next()){
                    String name=result.getString(1);
                    String data=result.getString(2);
                    String col31=result.getString(3);
                    String col41="-";
                    String col51="-";
                    String col61="-";

                    ObjectBuilder newObgect= new ObjectBuilder(name,data,col31,col41,col51,col61);
                    tableList.add(newObgect);
                }
                tableView.setItems(tableList);
            }
            else if(event.getSource()==btnQr41){
                tableList.clear();
                tableView.setItems(tableList);
                pnlStatus.setBackground(new Background(new BackgroundFill(Color.rgb( 122 ,185, 226), EMPTY,Insets.EMPTY)));
                textNavBar.setText(" Tara ce deține clasa cu maximul dimensiunii tunurilor\n" +
                        "crucișătoarelor.");

                colC1.setText("Tara");
                colC2.setText("-");
                colC3.setText("-");
                colC4.setText("-");
                colC5.setText("-");
                colC6.setText("-");


                colC1.setCellValueFactory(new PropertyValueFactory<>("col1"));
                colC2.setCellValueFactory(new PropertyValueFactory<>("col2"));
                colC3.setCellValueFactory(new PropertyValueFactory<>("col3"));
                colC4.setCellValueFactory(new PropertyValueFactory<>("col4"));
                colC5.setCellValueFactory(new PropertyValueFactory<>("col5"));
                colC6.setCellValueFactory(new PropertyValueFactory<>("col6"));


                String sql="select tara\n" +
                        "from Clase\n" +
                        "where diametru_tun = (SELECT MAX(diametru_tun) FROM Clase WHERE tip = 'cr')";

                Statement statement12=connection.createStatement();
                ResultSet result=statement12.executeQuery(sql);


                while(result.next()){
                    String name=result.getString(1);
                    String data="-";//result.getString(2);
                    String col31="-";//result.getString(3);
                    String col41="-";
                    String col51="-";
                    String col61="-";

                    ObjectBuilder newObgect= new ObjectBuilder(name,data,col31,col41,col51,col61);
                    tableList.add(newObgect);
                }
                tableView.setItems(tableList);
            }
            else if(event.getSource()==btnQr42){
                tableList.clear();
                tableView.setItems(tableList);
                textNavBar.setText(" Consecinte");
                pnlStatus.setBackground(new Background(new BackgroundFill(Color.rgb(151 ,201, 233), EMPTY,Insets.EMPTY)));
                textNavBar.setText("pentru fiecare bătălie numărul navelor din fiecare categorie\n" +
                        "rezultat.");

                colC1.setText("Nume");
                colC2.setText("Scufundate");
                colC3.setText("Avariate");
                colC4.setText("Nevatamate");
                colC5.setText("-");
                colC6.setText("-");


                colC1.setCellValueFactory(new PropertyValueFactory<>("col1"));
                colC2.setCellValueFactory(new PropertyValueFactory<>("col2"));
                colC3.setCellValueFactory(new PropertyValueFactory<>("col3"));
                colC4.setCellValueFactory(new PropertyValueFactory<>("col4"));
                colC5.setCellValueFactory(new PropertyValueFactory<>("col5"));
                colC6.setCellValueFactory(new PropertyValueFactory<>("col6"));


                String sql="select B.nume, \n" +
                        "       SUM(case when Con.rezultat = 'scufundat' then 1 else 0 end) as scufundate,\n" +
                        "       SUM(case when Con.rezultat = 'avariat' then 1 else 0 end) as avariate,\n" +
                        "       SUM(case when Con.rezultat = 'nevatamat' then 1 else 0 end) as nevatamate\n" +
                        "from Batalii B\n" +
                        "left join Consecinte Con on B.nume = Con.batalie\n" +
                        "group by B.nume";

                Statement statement12=connection.createStatement();
                ResultSet result=statement12.executeQuery(sql);


                while(result.next()){
                    String name=result.getString(1);
                    String data=result.getString(2);
                    String col31=result.getString(3);
                    String col41=result.getString(4);
                    String col51="-";
                    String col61="-";

                    ObjectBuilder newObgect= new ObjectBuilder(name,data,col31,col41,col51,col61);
                    tableList.add(newObgect);
                }
                tableView.setItems(tableList);
            }

            connection.close();
        }catch (SQLException e){
            //System.out.println("Nu s-a putut face legatura la baza de date.");
            e.printStackTrace();
        }

    }
}
