package search_solutions;

import core_search.BaseSearch;
import core_search.Node;
import core_search.SortedQueue;
import search_problems.TilePuzzle;
import search_problems.Travel;

import java.util.Comparator;
import java.util.List;

public class STP_UCS extends BaseSearch<List<Integer>,String> {
    public STP_UCS (){
        super(new TilePuzzle(), new SortedQueue<>(new STP_UCS.ComparePathCost()));
    }
    public static void main(String[] args){
        STP_UCS t = new STP_UCS();
        t.search();
    }
    public static class ComparePathCost implements Comparator<Node<String,String>> {
        public int compare (Node<String, String> o1, Node<String, String> o2){
            if(o1.getPathCost() < o2.getPathCost()){
                return -1;
            }else if (o1.getPathCost()==o2.getPathCost()){
                return 0;
            }else{
                return 1;
            }
        }
    }
}
