package search_solutions;

import core_search.BaseSearch;
import core_search.Node;
import core_search.SortedQueue;
import search_problems.Travel;

import java.util.Comparator;

public class Travel_AStar extends BaseSearch<String, String> {
    public Travel_AStar(String map, String estimates) {
        super(new Travel(map, estimates), new SortedQueue<>(new CompareDistances(new Travel(map, estimates))));
    }

    public static void main(String[] args) {
        Travel_AStar agent = new Travel_AStar("RomaniaMap.txt", "RomaniaMapEstimates.txt");
        agent.search();
    }

    public static class CompareDistances implements Comparator<Node<String, String>> {

        public final Travel problem;

        public CompareDistances(Travel problem) {
            this.problem = problem;
        }

        public int compare(Node<String, String> o1, Node<String, String> o2) {
            if (o1.getPathCost()+problem.getEstimatedDistance(o1.getState()) < o2.getPathCost()+problem.getEstimatedDistance(o2.getState())) {
                return -1;
            } else if (o1.getPathCost()+problem.getEstimatedDistance(o1.getState()) == o2.getPathCost()+problem.getEstimatedDistance(o2.getState())) {
                return 0;
            } else {
                return 1;
            }
        }
    }
}
