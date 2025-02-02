package search_solutions;

import core_search.BaseSearch;
import core_search.Node;
import core_search.SortedQueue;
import search_problems.TilePuzzle;

import java.util.Comparator;
import java.util.List;

public class STP_GBFS extends BaseSearch<List<Integer>, String> {
    public STP_GBFS() {
        super(new TilePuzzle(), new SortedQueue<>(new STPCompareEstimates(new TilePuzzle())));
    }

    public static void main(String[] args) {
        STP_GBFS t = new STP_GBFS();
        t.search();
    }

    // Comparator to compare nodes based on the heuristic estimate
    public static class STPCompareEstimates implements Comparator<Node<List<Integer>, String>> {
        private final TilePuzzle problem;

        public STPCompareEstimates(TilePuzzle problem) {
            this.problem = problem;
        }

        @Override
        public int compare(Node<List<Integer>, String> o1, Node<List<Integer>, String> o2) {
            double h1 = calculateHeuristic(o1.getState());
            double h2 = calculateHeuristic(o2.getState());
            return Double.compare(h1, h2);
        }

        // Heuristic function: number of misplaced tiles + sum of Manhattan distances
        private double calculateHeuristic(List<Integer> state) {
            int misplacedTiles = 0;
            int sumManhattanDistance = 0;
            List<Integer> goalState = problem.goalState();

            for (int i = 0; i < state.size(); i++) {
                int tile = state.get(i);
                if (tile != 0 && tile != goalState.get(i)) { // 0 represents the empty tile
                    misplacedTiles++;
                    sumManhattanDistance += calculateManhattanDistance(state, i, goalState);
                }
            }

            return misplacedTiles + sumManhattanDistance;
        }

        // Helper method to calculate Manhattan distance for a tile
        private int calculateManhattanDistance(List<Integer> state, int index, List<Integer> goalState) {
            int size = (int) Math.sqrt(state.size()); // Assuming the puzzle is square
            int currentRow = index / size;
            int currentCol = index % size;
            int goalIndex = goalState.indexOf(state.get(index));
            int goalRow = goalIndex / size;
            int goalCol = goalIndex % size;
            return Math.abs(currentRow - goalRow) + Math.abs(currentCol - goalCol);
        }
    }
}