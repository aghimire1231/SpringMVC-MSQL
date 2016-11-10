package com.example.repository;

import com.example.model.LoginCredentials;
import com.example.utils.DatabaseConnection;
import org.junit.Test;

import java.sql.*;

import static org.junit.Assert.*;

/**
 * Created by ashish on 11/8/2016.
 */
public class LoginRepository {

    public LoginCredentials getLoginCredentials(String username){
        Connection connection = DatabaseConnection.getDatabaseConnection();

        LoginCredentials credentials = null;
        String getQuery = "select * from users where USERNAME=?";
        try {
            PreparedStatement ps = connection.prepareStatement(getQuery);
            ps.setString(1,username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                credentials = new LoginCredentials();
                credentials.setUsername(rs.getString("USERNAME"));
                credentials.setPassword(rs.getString("PASSWORD"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return credentials;
    }

    @Test
    public void testGetLoginCredentials(){
        LoginCredentials credentials = getLoginCredentials("dbadmin1");
        assertNotNull(credentials);
        assertEquals("dbadmin1",credentials.getUsername());
        assertEquals("12345",credentials.getPassword());
    }
}
