package my.dao.soulution;

import my.DbUtil;
import my.entity.Solution;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcSolutionDao {

    private String FIND_ALL_QUERY = "SELECT * FROM SOLUTION LIMIT ?";
    private String FIND_BY_ID_QUERY = "SELECT * FROM SOLUTION WHERE id = ?";

    public Solution findById(int id) {
        try (Connection connection = DbUtil.getConn();
             PreparedStatement preparedStatement =
                     connection.prepareStatement(FIND_BY_ID_QUERY)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return mapToSolution(resultSet);
                }else {
                    throw new RuntimeException("No Solution found");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public List<Solution> loadAll(int limit) {
        List<Solution> solutions = new ArrayList<>();
        try (Connection connection = DbUtil.getConn();
             PreparedStatement preparedStatement =
                     connection.prepareStatement(FIND_ALL_QUERY)) {
            preparedStatement.setInt(1, limit);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    solutions.add(mapToSolution(resultSet));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return solutions;
    }


    private Solution mapToSolution(ResultSet resultSet) {
        return null;
    }
}
