package cu.edu.cujae.backend.core.service;


import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

public interface Service {
    void createUser(Objects objects) throws SQLException;

    void updateUser(Objects objects);

    List<Objects> listUsers() throws SQLException;

    Objects getUserById(String userId) throws SQLException;

    void deleteUser(String id) throws SQLException;
}
