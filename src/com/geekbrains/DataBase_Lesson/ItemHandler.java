package com.geekbrains.DataBase_Lesson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class ItemHandler {
    private Connection connection;
    private Statement statement;

    public void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:itemPrice.db");
        statement = connection.createStatement();
        System.out.println("Connection to SQLite has been established.");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input you'r request:");
        while (true){
            try {
                String s = br.readLine();
                if (s.toLowerCase().startsWith("/end"))break;
                if (s.toLowerCase().startsWith("/price")){
                    System.out.println(getPriceByName(s));
                }
                if (s.toLowerCase().startsWith("/changeprice ")){
                    changePriceItem(s);
                }
                if (s.toLowerCase().startsWith("/itemsbyprice ")){
                    selectItemsByPrice(s);
                }
            } catch (SQLException e){
                System.out.println("This item not found");
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void selectItemsByPrice(String s) throws SQLException {
        String[] strings = s.toLowerCase().split(" ", 3);
        ResultSet resultSet = statement.executeQuery("SELECT item FROM items WHERE price >" + strings[1] +" AND price < " + strings[2]);
        while (resultSet.next()) System.out.println(resultSet.getString(1));
    }

    private void changePriceItem(String s) throws SQLException {
        String[] strings = s.toLowerCase().split(" ", 3);
        updateItemPrice(Integer.parseInt(strings[2]),strings[1]);
    }

    private int getPriceByName(String s) throws SQLException {
        String[] strings = s.toLowerCase().split("/price ", 2);
        ResultSet resultSet = statement.executeQuery("SELECT price FROM items WHERE item = '" + strings[1] +"'");
        resultSet.next();
        return resultSet.getInt(1);
    }

    private void updateItemPrice(int price,String item) throws SQLException {
        if (statement.executeUpdate("UPDATE items SET price = " + price + " WHERE item = '" + item + "'") == 1)
            System.out.println("Correct! New price for item: " + item + " is " + price);
        else System.out.println("Item: " + item + " not found");
    }

    public void fillTable() {
       batchInsert();
       System.out.println("Table items filled");
    }

    private void batchInsert(){
        try {
            connection.setAutoCommit(false);
            PreparedStatement prst = connection.prepareStatement("INSERT INTO items (item,price,prodid) VALUES (?,?,?);");
            /*Savepoint savepoint = connection.setSavepoint();
            connection.rollback(savepoint);
            connection.commit(); // если добавляли новые запси послше отката*/
            for (int i = 1; i <= 10000; i++) {
                prst.setString(1,"item_" + i);
                prst.setInt(2,i*10);
                prst.setString(3, "000_" + i);
                prst.addBatch();
            }
            prst.executeBatch();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addItemI(int i) throws SQLException {
        statement.executeUpdate("INSERT INTO items (item,price) VALUES ('item_" + i + "'," + i*10 +");");
    }

    public void deleteAllItems() throws SQLException {
        statement.executeUpdate("DELETE FROM items");
        System.out.println("All items deleted");
    }

    public void deleteTable() throws SQLException {
        statement.executeUpdate("DROP TABLE IF EXISTS items;");
        System.out.println("Table items deleted");
    }

    public void createTable() throws SQLException {
        String sqlCreateTable = "CREATE TABLE IF NOT EXISTS items (\n"
                +"id    INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                +"item  TEXT   NOT NULL,\n"
                +"price INTEGER, \n"
                +"prodid TEXT UNIQUE \n"
                +");";
        statement.execute(sqlCreateTable);
        System.out.println("Table created");
    }

    public void disconnect(){
        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*private void deleteTestItem() throws SQLException {
        statement.executeUpdate("DELETE FROM items WHERE item = 'testItem'");
    }

    private void insertTestItem() throws SQLException {
        statement.executeUpdate("INSERT INTO items (item,price) VALUES ('testItem',0);");
    }*/

}
