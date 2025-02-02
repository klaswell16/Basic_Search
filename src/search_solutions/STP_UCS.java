package search_solutions;

import core_search.BaseSearch;
import core_search.Node;
import core_search.SortedQueue;
import search_problems.TilePuzzle;


import java.util.Comparator;
import java.util.List;

public class STP_UCS extends BaseSearch<List<Integer>,String> {
    public STP_UCS (){
        super(new TilePuzzle(), new SortedQueue<>(new STPComparePathCost()));
    }
    public static void main(String[] args){
        STP_UCS t = new STP_UCS();
        t.search();
    }
    public static class STPComparePathCost implements Comparator<Node<List<Integer>, String>> {
        public int compare(Node<List<Integer>, String> o1, Node<List<Integer>, String> o2) {
            return Double.compare(o1.getPathCost(), o2.getPathCost());
        }
    }
}
