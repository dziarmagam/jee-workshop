package my.dao.soulution;

import my.entity.Solution;

import java.util.List;

public interface SolutionDao {
    List<Solution> loadAll(int limit);
    Solution findById(int id);
}
