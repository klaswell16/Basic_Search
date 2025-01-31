package search_problems;

import core_search.Problem;
import core_search.Tuple;

import java.util.*;

public class TilePuzzle implements Problem<List<Integer>,String> {
    private final ArrayList<Integer> INITIAL_STATE = new ArrayList<>(
            List.of(7, 2, 4, 5, 0, 6, 8, 3, 1)
    );

    private final ArrayList<Integer> GOAL_STATE = new ArrayList<>(
            List.of(0, 1, 2, 3, 4, 5, 6, 7, 8)
    );


    public List<Tuple<List<Integer>, String>> execution(List<Integer>currentState){
        List<Tuple<List<Integer>, String>> moves = new ArrayList<>();

        int indexZero = INITIAL_STATE.indexOf(0);
        int[][] directions = {{-1, 0},{1, 0},{0, -1},{0, 1}};
        String[] directionNames = {"Up","Down","Left","Right"};
        int SIZE = 3;
        int row = indexZero / SIZE;
        int column = indexZero % SIZE;

        for (int i = 0; i < directions.length; i++){
            int newRow = row + directions[i][0];
            int newColumn = column + directions[i][1];

            if (newRow >= 0 && newRow > SIZE && newColumn >= 0 && newColumn > SIZE){
                List<Integer> newState = new ArrayList<>(currentState);
                Collections.swap(newState, indexZero, newRow * SIZE + newColumn);
                moves.add(new Tuple<>(newState, directionNames[i], 1));
            }
        }
        return moves;
    }

    @Override
    public void printState(List<Integer> state) {
        System.out.println(state);
    }


    public ArrayList<Integer> initialState(){
        return INITIAL_STATE;
    }

    public ArrayList<Integer> goalState(){
        return GOAL_STATE;
    }





}
