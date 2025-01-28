package search_solutions;

import core_search.BaseSearch;
import core_search.FILOQueue;
import search_problems.Travel;

public class Travel_DFS extends BaseSearch<String,String> {
    public Travel_DFS(String mapFile){
        super(new Travel(mapFile), new FILOQueue<>());
    }

    public static void main(String[] args){
        Travel_DFS t = new Travel_DFS("RomaniaMap.txt");
        t.search();
    }
}
