/******************************************************************************************************************************
 Author Name : Surabhi Sanjan
 Project : Database Automation
 Date : 27/01/2023
 *********************************************************************************************************************************/
package com.bridgelabz.DB;
import org.testng.annotations.*;
import java.sql.*;
public class DBAutomationTest {

    public String dburl = "jdbc:mysql://localhost:3306/spotifydb";
    public String user = "root";
    public String pass = "Ardent@1";
    public Connection connection;

    //SELECT QUERY
    @Test
    public void getTableData_Successfully() throws SQLException {
        try {
            connection = DriverManager.getConnection(dburl, user, pass);
            Statement smt = connection.createStatement();
            ResultSet result = smt.executeQuery("select * from playlist;");
            while (result.next()) {
                System.out.println("PID :" + result.getString(1));
                System.out.println("PName :" + result.getString(2));
                System.out.println("UID :" + result.getString(3));
                System.out.println();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    //INSERT INTO QUERY
    @Test
    public void insertDataIntoTable_Successfully() {
        try {
            connection = DriverManager.getConnection(dburl, user, pass);
            PreparedStatement ps = connection.prepareStatement("Insert into Playlist values (?,?,?);");
            ps.setString(1, "suru26RvLqeqpYefr7Mgv8Msul");
            ps.setString(2, "Playlist 18");
            ps.setString(3, "5e1daa087jlvs214o2w3gvkjh");
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    //DELETE QUERY
    @Test
    public void deletePlaylist_Successfully() {
        try {
            connection = DriverManager.getConnection(dburl, user, pass);
            PreparedStatement ps = connection.prepareStatement("DELETE from Playlist where PName = (?);");
            ps.setString(1, "Playlist 18");
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    //UPDATE QUERY
    @Test
    public void updatePlaylist_Successfully() {
        try {
            connection = DriverManager.getConnection(dburl, user, pass);
            PreparedStatement ps = connection.prepareStatement("Update Playlist set PName = (?) where PName =(?);");
            ps.setString(1, "Playlist 2");
            ps.setString(2, "Playlist 20");
            getTableData_Successfully();
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}

