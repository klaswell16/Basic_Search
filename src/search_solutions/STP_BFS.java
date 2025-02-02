package search_solutions;

import core_search.BaseSearch;
import core_search.FIFOQueue;
import search_problems.TilePuzzle;
import java.util.List;

public class STP_BFS extends BaseSearch<List<Integer>, String> {
    
    public STP_BFS() {
        super(new TilePuzzle(), new FIFOQueue<>());
    }

    public static void main(String[] args) {
        STP_BFS t = new STP_BFS();
        t.search();
    }
}
