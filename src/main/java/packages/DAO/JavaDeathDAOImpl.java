package packages.DAO;

import packages.models.Account;
import packages.models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JavaDeathDAOImpl implements JavaDeathDAO {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:8500/javadeath?serverTimezone=Europe/Moscow&useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "Maxkozlov2mailru";

    private Connection getConnection() throws SQLException {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
    }

    public User getUserById(int id) {
        String getUser = "SELECT * FROM javadeath.user WHERE userid = '" + id + "'";
        User user = null;

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(getUser)) {
            if (resultSet.next()) {
                user = new User(resultSet.getInt("userid"),
                        resultSet.getString("name"),
                        resultSet.getString("sureName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    public List<Account> getAllAccounts() {
        String getAccounts = "SELECT * FROM javadeath.account";
        List<Account> accounts = new ArrayList<Account>();

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(getAccounts)) {
            while (resultSet.next()) {
                Account account = new Account(resultSet.getInt("accountId"),
                        resultSet.getInt("account"),
                        resultSet.getInt("userid"));
                accounts.add(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return accounts;
    }
}
