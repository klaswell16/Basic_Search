package search_problems;

import core_search.Problem;
import core_search.Tuple;

import java.util.*;

public class TilePuzzle implements Problem<LinkedList<Integer>,int> {
    private final LinkedList<Integer> INITIAL_STATE = new LinkedList<Integer>(Arrays.asList(7, 2, 4, 5, 0, 6, 8, 3, 1));

    private final LinkedList<Integer> GOAL_STATE = new LinkedList<Integer>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8));

    public LinkedList<Integer> initialState(){
        return INITIAL_STATE;
    }

    public LinkedList<Integer> goalState(){
        return GOAL_STATE;
    }

    public actions(){

    }

    private final Map<String, List<Tuple<String, String>>> transitionModel = new HashMap<>();
    private void buildTransitionModel(){

    }

}
