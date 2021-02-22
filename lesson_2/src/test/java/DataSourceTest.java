import java.sql.*;

public class DataSourceTest {

    public static void main(String[] args) throws SQLException {
        try(Connection connection = DataSource.getConnection();
            Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery("select * from users where id = 10");
            while (resultSet.next()){
                System.out.print(resultSet.getLong("StudID") + " ");
                System.out.print(resultSet.getString("Name")+ " ");
                System.out.print(resultSet.getString("GroupName")+ " ");
                System.out.print(resultSet.getInt("Score"));
                System.out.println();
            }
        }
    }
}
