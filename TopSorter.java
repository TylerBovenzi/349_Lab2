import java.io.FileNotFoundException;
import java.util.ArrayList;


//Author: Tyler Bovenzi
public class TopSorter {
    static ArrayList<Integer> srcRemTopSorter(String filename) throws FileNotFoundException {
        GraphStart3 gs = new GraphStart3();
        gs.readfile_graph(filename);



        ArrayList<Integer> inDegrees = new ArrayList<>();                   //Init Flag Arrays and Answer
        ArrayList<GraphStart3.Vertex> notRemoved = new ArrayList<>();
        ArrayList<Integer> removed = new ArrayList<>();


        for(GraphStart3.Vertex v: gs.vertices) {
            inDegrees.add(0);
            notRemoved.add(v);
        }                                                                   //<..>

        for(GraphStart3.Vertex v: gs.vertices) {                            //Initialize InDegrees for every vertex
            for(GraphStart3.Vertex e: v.edges){                             //Loops over all edges -> O(|E|)
                int index = e.key-1;
                inDegrees.set(index , inDegrees.get(index) + 1);
            }
        }

        int numLeft = gs.vertices.size();
        while(numLeft > 0){                                                 //Until all vertices are removed
            int able = 0;                                                   //flag to check for cycle issues
            for(GraphStart3.Vertex v: notRemoved){                          //for every vertex not removed
                if(inDegrees.get(v.key-1) == 0) {                           //check if inDegree is zero, if so:
                    for (GraphStart3.Vertex e : v.edges) {                      //reduce inDegree of children by 1
                        int index = e.key - 1;
                        inDegrees.set(index, inDegrees.get(index) - 1);
                    }
                    inDegrees.set(v.key-1, -1);                                 //remove vertex
                    removed.add(v.key);
                    numLeft -= 1;                                               //decrement counter
                    able = 1;
                    break;
                }                                                               //<..>
            }
            if(able == 0){                                                  //If cycle or other error
                ArrayList<Integer> neg1Array = new ArrayList<>();
                for(GraphStart3.Vertex v: gs.vertices)                      //Init arrays of -1s
                    neg1Array.add(-1);
                return neg1Array;                                           //and return
            }

        }
        return removed;                                                     //otherwise return Top Sort
    }

    static ArrayList<Integer> dfsTopSorter(String filename) throws FileNotFoundException {
        GraphStart3 gs = new GraphStart3();
        gs.readfile_graph(filename);
        ArrayList<Integer> inDegrees = new ArrayList<>();           //Setup flag and return arrays
        ArrayList<Integer> answer = new ArrayList<>();
        ArrayList<Integer> visited = new ArrayList<>();
        ArrayList<Integer> prev = new ArrayList<>();

        for(GraphStart3.Vertex v: gs.vertices) {
            visited.add(0);
            inDegrees.add(0);
            prev.add(0);
        }                                                           //<..>

        for(GraphStart3.Vertex v: gs.vertices) {                    //Initialize InDegrees for every vertex
            for(GraphStart3.Vertex e: v.edges){                     //Loops over all edges -> O(|E|)
                int index = e.key-1;
                inDegrees.set(index , inDegrees.get(index) + 1);
            }
        }

        for(GraphStart3.Vertex v: gs.vertices){                     //For all sources
            if(inDegrees.get(v.key-1) == 0) {
                prev.set(v.key - 1, 1);                             //Add source to loop checking array
                dfsRecursion(v, answer, visited, prev);             //Execute recursive algorithm
            }
        }
        if(answer.size() < gs.vertices.size()){                     //If errors or cycles
            ArrayList<Integer> newAns = new ArrayList<>();
            for(GraphStart3.Vertex v: gs.vertices)
                newAns.add(-1);                                     //Init -1 array and return
            return newAns;
        }

        return answer;                                              //Otherwise, return top sort

    }


    static int dfsRecursion(GraphStart3.Vertex v, ArrayList<Integer> l, ArrayList<Integer> visited, ArrayList<Integer> prev){
        visited.set(v.key-1, 1);                                //Mark vertex as visited
        for(GraphStart3.Vertex e: v.edges) {                    //For all vertex edges
            if(prev.get(e.key-1) == 1){                         //If a cycle exists, exit and report such
                return 0;
            }
            ArrayList<Integer> prevNew = new ArrayList<>(prev); //Add current edge to cycle checklist
            prevNew.set(e.key-1, 1);                            //..
            if (visited.get(e.key - 1) == 0)                    //If edge has not yet been visited
                if(dfsRecursion(e, l, visited,prevNew) == 0)    //Execute recursion on child
                    return 0;                                   //If there is an error with recursion, exit and report

        }
            l.add(0,v.key);                                //otherwise add vertex to beginning of list
            return 1;                                            //return without error
    }

}
