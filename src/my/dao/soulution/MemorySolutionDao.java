package my.dao.soulution;

import my.entity.Exercise;
import my.entity.Solution;
import my.entity.User;
import my.entity.UserGroup;

import java.util.*;
import java.util.stream.Collectors;

public class MemorySolutionDao implements SolutionDao{

    private List<Solution> solutions;
    private Map<Integer, Solution> idSolutionMap;
    public MemorySolutionDao(){
        idSolutionMap = new HashMap<>();
        UserGroup userGroup = new UserGroup(1, "Klasa 1", Arrays.asList(0, 1));
        UserGroup userGroup2 = new UserGroup(2, "Klasa 2", Arrays.asList(2));
        User kamil = new User(0, "Kowalski Kamil", "kamil@gmail.com", userGroup);
        User ania = new User(1, "Wawrzyniak Ania", "ania@gmail.com", userGroup);
        User wojtek = new User(2, "Polak Wojtek", "wojtek@gmail.com", userGroup2);
        idSolutionMap.put(0, new Solution(0, "Rozwiazanie 1", new Date(), new Date(),
                new Exercise(0, "Zadanie 1", "Trudne zadanie"),
                kamil));
        idSolutionMap.put(1, new Solution(1, "Rozwiazanie 2", new Date(), new Date(),
                new Exercise(1, "Zadanie 2", "Latwe zadanie"),
                kamil));
        idSolutionMap.put(2, new Solution(2, "Rozwiazanie 3", new Date(), new Date(),
                new Exercise(1, "Zadanie 2", "Latwe zadanie"),
                ania));
        idSolutionMap.put(3, new Solution(3, "Rozwiazanie 4", new Date(), new Date(),
                new Exercise(2, "Zadanie 3", "Srednie zadanie"),
                wojtek));
        solutions = new ArrayList<>(idSolutionMap.values());

    }

    @Override
    public List<Solution> loadAll(int limit) {
        return solutions.stream().limit(limit).collect(Collectors.toList());
    }

    @Override
    public Solution findById(int id) {
        return idSolutionMap.get(id);
    }
}
