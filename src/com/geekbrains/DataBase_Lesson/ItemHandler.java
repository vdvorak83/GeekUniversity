package com.geekbrains.DataBase_Lesson;

import java.sql.*;

public class ItemHandler {
    private Connection connection;
    private Statement statement;

    public void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:itemPrice.db");
        statement = connection.createStatement();
        System.out.println("Connection to SQLite has been established.");
    }

    public void fillTable() {
       batchInsert();
       System.out.println("Table items filled");
    }

    private void batchInsert(){
        try {
            connection.setAutoCommit(false);
            PreparedStatement prst = connection.prepareStatement("INSERT INTO items (item,price) VALUES (?,?);");
            /*Savepoint savepoint = connection.setSavepoint();
            connection.rollback(savepoint);
            connection.commit(); // если добавляли новые запси послше отката*/
            for (int i = 1; i <= 10000; i++) {
                prst.setString(1,"item_" + i);
                prst.setInt(2,i*10);
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

    public void deleteTestItem() throws SQLException {
        statement.executeUpdate("DELETE FROM items WHERE item = 'testItem'");
    }

    private void updateTestItem() throws SQLException {
        statement.executeUpdate("UPDATE items SET price = 1 WHERE id = 1");
    }

    public void insertTestItem() throws SQLException {
        statement.executeUpdate("INSERT INTO items (item,price) VALUES ('testItem',0);");
    }

    public void deleteTable() throws SQLException {
        statement.executeUpdate("DROP TABLE IF EXISTS items;");
        System.out.println("Table items deleted");
    }

    public void createTable() throws SQLException {
        String sqlCreateTable = "CREATE TABLE IF NOT EXISTS items (\n"
                +"id    INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                +"item  TEXT    UNIQUE\n"
                +"NOT NULL,\n"
                +"price INTEGER\n"
                +")";
        statement.execute(sqlCreateTable);
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
}
