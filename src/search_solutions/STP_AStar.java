package search_solutions;

import core_search.BaseSearch;
import core_search.Node;
import core_search.SortedQueue;
import search_problems.TilePuzzle;

import java.util.Comparator;
import java.util.List;

public class STP_AStar extends BaseSearch<List<Integer>, String> {
    public STP_AStar() {
        super(new TilePuzzle(), new SortedQueue<>(new STPCompareEstimates(new TilePuzzle())));
    }

    public static void main(String[] args) {
        STP_AStar t = new STP_AStar();
        t.search();
    }


    public static class STPCompareEstimates implements Comparator<Node<List<Integer>, String>> {
        private final TilePuzzle problem;

        public STPCompareEstimates(TilePuzzle problem) {
            this.problem = problem;
        }


        public int compare(Node<List<Integer>, String> o1, Node<List<Integer>, String> o2) {
            double f1 = calculateTotalCost(o1);
            double f2 = calculateTotalCost(o2);
            return Double.compare(f1, f2);
        }


        private double calculateTotalCost(Node<List<Integer>, String> node) {
            double g = node.getPathCost();
            double h = calculateHeuristic(node.getState());
            return g + h;
        }


        private double calculateHeuristic(List<Integer> state) {
            int misplacedTiles = 0;
            int sumDistance = 0;
            List<Integer> goalState = problem.goalState();

            for (int i = 0; i < state.size(); i++) {
                int tile = state.get(i);
                if (tile != 0 && tile != goalState.get(i)) {
                    misplacedTiles++;
                    sumDistance += calculateDistance(state, i, goalState);
                }
            }

            return misplacedTiles + sumDistance;
        }


        private int calculateDistance(List<Integer> state, int index, List<Integer> goalState) {
            int size = (int) Math.sqrt(state.size());
            int currentRow = index / size;
            int currentCol = index % size;
            int goalIndex = goalState.indexOf(state.get(index));
            int goalRow = goalIndex / size;
            int goalCol = goalIndex % size;
            return Math.abs(currentRow - goalRow) + Math.abs(currentCol - goalCol);
        }
    }
}