package lesson_2;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws Exception {
    }


    private static void rollbackExample() throws Exception{
        Connection connection = getConnection();
        try{
            Statement statement = connection.createStatement();

            statement.executeUpdate("insert into students (name, groupName, score) values ('Alex', 'CS', 5)");
            Savepoint sp = connection.setSavepoint();
            statement.executeUpdate("insert into students (name, groupName, score) values ('Katy', 'Bio', 5)");
            connection.rollback(sp);
            statement.executeUpdate("insert into students (name, groupName, score) values ('Fil', 'Bio', 5)");
            connection.commit();

        } catch (Exception e){
            e.printStackTrace();
        }
    }


    private static void commitExBatch() throws Exception{
        Connection connection = getConnection();
        String req = "insert into students (name, groupName, score) values (?, ?, ?)";
        Long start = System.currentTimeMillis();
        try(PreparedStatement preparedStatement = connection.prepareStatement(req)){
            connection.setAutoCommit(false);
            for (int i = 0; i < 10000; i++) {
                preparedStatement.setString(1, "John");
                preparedStatement.setString(2, "CS_" + i);
                preparedStatement.setInt(3, i * 17 % 5);
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
            connection.commit();
        } catch (Exception e){
            e.printStackTrace();
        }
        Long finish = System.currentTimeMillis();
        System.out.println("Time is: " + (finish - start));
    }

    private static void commitEx() throws Exception{
        Connection connection = getConnection();
        String req = "insert into students (name, groupName, score) values (?, ?, ?)";
        Long start = System.currentTimeMillis();
        try(PreparedStatement preparedStatement = connection.prepareStatement(req)){
            connection.setAutoCommit(false);
            for (int i = 0; i < 10000; i++) {
                preparedStatement.setString(1, "John");
                preparedStatement.setString(2, "CS_" + i);
                preparedStatement.setInt(3, i * 17 % 5);
                preparedStatement.executeUpdate();
            }
            connection.commit();
        } catch (Exception e){
            e.printStackTrace();
        }
        Long finish = System.currentTimeMillis();
        System.out.println("Time is: " + (finish - start));
    }

    private static void statementVsPS() throws Exception{
        String name = "Alex";
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from students where Name = '" + name + "'");
        print(resultSet);


        System.out.println("Injected version");
        String injectedName = "A' or 1 = 1;";
        ResultSet injectedResultSet = statement.executeQuery("select * from students where Name = '" + injectedName + "'");
        print(injectedResultSet);

        String preparedStatementSQL = "select * from students where Name = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(preparedStatementSQL);
        preparedStatement.setString(1, injectedName);
        ResultSet injectedResultSetPS = preparedStatement.executeQuery();
        print(injectedResultSetPS);



        resultSet.close();
        statement.close();
        connection.close();
    }

    private static void firstSelect() throws Exception{
        String name = "Alex";
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from students where Name = '" + name + "'");
        print(resultSet);

        resultSet.close();
        statement.close();
        connection.close();
    }

    private static void print(ResultSet resultSet) throws SQLException {
        while (resultSet.next()){
            System.out.print(resultSet.getLong("StudID") + " ");
            System.out.print(resultSet.getString("Name") + " ");
            System.out.print(resultSet.getString("GroupName") + " ");
            System.out.print(resultSet.getLong("Score") + " ");
            System.out.println();
        }
    }

    private static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        return DriverManager.getConnection("jdbc:sqlite:lesson_2/mydatabase.db");
    }
}
