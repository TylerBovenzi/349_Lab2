import org.jetbrains.annotations.Contract;

import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class TopSorter {
    static ArrayList<Integer> srcRemTopSorter(String filename) throws FileNotFoundException {
        GraphStart3 gs = new GraphStart3();
        gs.readfile_graph(filename);
//        for(GraphStart3.Vertex v: gs.vertices) {
//            if(v.)
//        }

        gs.print_graph();
        return new ArrayList<>();
    }

    static ArrayList<Integer> dfsTopSorter(String filename){
        return new ArrayList<>();
    }

}
