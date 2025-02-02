package search_problems;

import core_search.Problem;
import core_search.Tuple;

import java.util.*;

public class TilePuzzle implements Problem<List<Integer>,String> {
    /*
    private final int SIZE = 3;
    private final List<Integer> INITIAL_STATE = new ArrayList<>(Arrays.asList(7, 2, 4, 5, 0, 6, 8, 3, 1));
    private final List<Integer> GOAL_STATE = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8));
*/
    private final int SIZE = 4;
    private final List<Integer> INITIAL_STATE = new ArrayList<>(Arrays.asList(12, 1, 2, 15, 11, 6, 5, 8, 7, 10, 9, 4, 0, 13, 14, 3));
    private final List<Integer> GOAL_STATE = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0));


    public List<Tuple<List<Integer>, String>> execution(List<Integer> currentState) {
        List<Tuple<List<Integer>, String>> moves = new ArrayList<>();
        int indexZero = currentState.indexOf(0);
        int row = indexZero / SIZE;
        int column = indexZero % SIZE;

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        String[] directionNames = {"Up", "Down", "Left", "Right"};

        for (int i = 0; i < directions.length; i++) {
            int newRow = row + directions[i][0];
            int newCol = column + directions[i][1];

            if (newRow >= 0 && newRow < SIZE && newCol >= 0 && newCol < SIZE) {
                List<Integer> newState = new ArrayList<>(currentState);
                Collections.swap(newState, indexZero, newRow * SIZE + newCol);
                moves.add(new Tuple<>(newState, directionNames[i], 1));
            }
        }
        return moves;
    }

    public List<Integer> initialState() {
        return INITIAL_STATE;
    }

    public List<Integer> goalState() {
        return GOAL_STATE;
    }

    public void printState(List<Integer> state) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(state.get(i * SIZE + j) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
