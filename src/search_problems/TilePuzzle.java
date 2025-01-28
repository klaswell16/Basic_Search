package search_problems;

import core_search.Problem;
import core_search.Tuple;

import java.util.*;

public class TilePuzzle implements Problem<ArrayList<Integer>,int> {
    private final ArrayList<Integer> INITIAL_STATE = new ArrayList<>(Arrays.asList(7, 2, 4, 5, 0, 6, 8, 3, 1));

    private final ArrayList<Integer> GOAL_STATE = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8));

    private void buildTransitionModel(){

    }

    public ArrayList<Integer> initialState(){
        return INITIAL_STATE;
    }

    public ArrayList<Integer> goalState(){
        return GOAL_STATE;
    }



    private final Map<String, List<Tuple<String, String>>> transitionModel = new HashMap<>();
    private void buildTransitionModel(){
        while(INITIAL_STATE)
    }

}
