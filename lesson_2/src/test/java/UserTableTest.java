import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;



/*

create table users
(
    id    INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    user_name      TEXT   UNIQUE                           NOT NULL,
    password TEXT                              NOT NULL
);
 */

public class UserTableTest {

    private static final String INSERT_USER = "insert into users (user_name, password) values (?, ?)";
    private static final String SELECT_USER_BY_NAME_AND_PASSWORD = "select * from users where user_name = ? and password = ?";
    private static final String SUPER_SECRET_SALT = "SUPER_SECRET_SALT";




//    @Test
    public void createUserTest(){
        String userName = "Stranger";
        String plainUserPassword = "qwerty123";
        createUser(userName, plainUserPassword);
    }

    private void createUser(String userName, String plainUserPassword){
        try(Connection connection = DataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(INSERT_USER)){
            ps.setString(1, userName);
            ps.setString(2, getPassword(plainUserPassword));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private String getPassword(String plainPassword){
        String hashedPassword = null;
        String passwordWithSalt = plainPassword + SUPER_SECRET_SALT;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            hashedPassword = bytesToHex(md.digest(passwordWithSalt.getBytes()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return hashedPassword;
    }

    public static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

//    @Test
    public void authorizeUser(){
        String userName = "Stranger";
        String plainUserPassword = "qwerty123";

        if(doesUserExist(userName, getPassword(plainUserPassword))){
            System.out.println("You are welcome!");
        } else {
            System.out.println("Wrong password or no user with that name.");
        }
    }

    private boolean doesUserExist(String userName, String cipheredPassword){
        boolean isAuthorized = false;
        try(Connection connection = DataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(SELECT_USER_BY_NAME_AND_PASSWORD)){
            ps.setString(1, userName);
            ps.setString(2, cipheredPassword);
            ResultSet resultSet = ps.executeQuery();
            isAuthorized = resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isAuthorized;
    }
}
