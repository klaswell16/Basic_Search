package search_solutions;

import core_search.BaseSearch;
import core_search.FILOQueue;
import search_problems.TilePuzzle;

import java.util.List;

public class STP_DFS extends BaseSearch<List<Integer>, String> {
    public STP_DFS(){
        super(new TilePuzzle(), new FILOQueue<>());
    }

    public static void main(String[] args){
        STP_DFS t = new STP_DFS();
        t.search();
    }
}
