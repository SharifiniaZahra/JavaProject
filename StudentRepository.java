package com.company.repository;

import java.sql.*;

public class StudentRepository {

    static final String DB_URL = "jdbc:oracle:thin:@192.168.100.121:1521/lcdev";
    static final String USER = "train";
    static final String PASS = "train";

    static final String QUERY = "SELECT * FROM STUDENT";
    static final String FIND_BY_ID = "SELECT * FROM STUDENT WHERE ID = ?";
    static final String QUERY2 = "SELECT * FROM STUDENT WHERE FIRSTNAME = 'ARIA'";
    static final String INSERT_QUERY = "INSERT INTO STUDENT (ID, FIRSTNAME, LASTNAME, STU_AGE) VALUES (?, ?, ?, ?)";
    static final String UPDATE_QUERY = "UPDATE STUDENT SET FIRSTNAME = ?,LASTNAME = ?,STU_AGE = ? WHERE ID = ? " ;

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(DB_URL, USER, PASS);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public  void findAll(){
        Statement statement = null;
        try{
            statement = getConnection().createStatement();
            ResultSet resultSet =statement.executeQuery("SELECT * FROM STUDENT");
            System.out.println("**************List Of Students:******************");
            while (resultSet.next()){
                System.out.println("ID : "+resultSet.getInt("ID"));
                System.out.println("FirstName : "+resultSet.getString("FIRSTNAME"));
                System.out.println("LastName : "+resultSet.getString("LASTNAME"));
                System.out.println("STU_AGE : "+resultSet.getInt("STU_AGE"));
                System.out.println("***********************************************");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void insert(int id,String name ,String family,int age){
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement =getConnection().prepareStatement(INSERT_QUERY);
            preparedStatement.setInt(1,id);
            preparedStatement.setString(2,name);
            preparedStatement.setString(3,family);
            preparedStatement.setInt(4,age);
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void update(int id,String name ,String family,int age){
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement =getConnection().prepareStatement(UPDATE_QUERY);
            preparedStatement.setInt(4,id);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,family);
            preparedStatement.setInt(3,age);
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void findByID(int id){
        Statement statement = null;

        try{
            statement = getConnection().createStatement();
            ResultSet resultSet =statement.executeQuery("SELECT * FROM STUDENT WHERE ID =" + id);
            while (resultSet.next()){
                System.out.println("Selected ID : "+resultSet.getInt("ID"));
                System.out.println("***********************************************");
                System.out.println("FirstName : "+resultSet.getString("FIRSTNAME"));
                System.out.println("LastName : "+resultSet.getString("LASTNAME"));
                System.out.println("STU_AGE : "+resultSet.getInt("STU_AGE"));
                System.out.println("***********************************************");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void deleteById(int id){
        Statement statement = null;

        try{
            statement = getConnection().createStatement();
            statement.executeUpdate("DELETE  FROM STUDENT WHERE ID =" + id);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }




}

