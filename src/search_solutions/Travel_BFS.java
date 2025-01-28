package search_solutions;

import core_search.BaseSearch;
import core_search.FIFOQueue;
import search_problems.Travel;

public class Travel_BFS extends BaseSearch<String,String> {
    public Travel_BFS(String mapFile){
        super(new Travel(mapFile), new FIFOQueue<>());
    }

    public static void main(String[] args){
        Travel_BFS t = new Travel_BFS("RomaniaMap.txt");
        t.search();
    }
}
