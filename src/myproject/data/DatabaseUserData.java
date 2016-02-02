package myproject.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import myproject.exception.DataAccessException;
import myproject.exception.UnknownUserException;
import myproject.exception.UserAlreadyExistsException;
import myproject.model.User;

public class DatabaseUserData implements UserDataAccess {

    private static final String MYSQL_HOST = "localhost";
    private static final String MYSQL_PORT = "3306";
    private static final String MYSQL_DATABASE = "tpjava";
    private static final String MYSQL_USER = "root";
    private static final String MYSQL_PWD = "";

    private Connection getConnection() throws SQLException {
	return DriverManager.getConnection("jdbc:mysql://" + MYSQL_HOST + ":" + MYSQL_PORT + "/" + MYSQL_DATABASE,
		MYSQL_USER, MYSQL_PWD);
    }

    private void closeConnection(Connection conn) {
	if (conn != null) {
	    try {
		conn.close();
	    } catch (SQLException e) {
		System.err.println("Error while closing the connection with the database");
	    }
	}
    }

    @Override
    public User findUser(String username) throws UnknownUserException, DataAccessException {

	Connection conn = null;

	try {
	    conn = getConnection();
	    Statement stmt = conn.createStatement();

	    ResultSet results = stmt.executeQuery("SELECT * FROM users where username=" + username);

	    if (results.next()) {
		return new User(results.getString("username"), results.getString("password"));
	    }

	    throw new UnknownUserException();

	} catch (SQLException e) {
	    throw new DataAccessException();
	} finally {
	    closeConnection(conn);
	}
    }

    @Override
    public List<User> getAllUser() throws DataAccessException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public void createUser(User newUser) throws UserAlreadyExistsException, DataAccessException {
	// TODO Auto-generated method stub

    }

    @Override
    public void updateUser(User user) throws UnknownUserException, DataAccessException {
	// TODO Auto-generated method stub

    }

    @Override
    public void removeUser(String username) throws UnknownUserException, DataAccessException {
	// TODO Auto-generated method stub

    }

}
