/* Authors: Abdullah Sahapdeen - Id: asahapde - Student Number: 251033977 and Mayank Sood - Id: msood - Student Number: 251000865
   Date Created: December 3, 2019
*/
import java.util.*;

public class Graph {

    private HashMap<Node, LinkedList<Node>> adjacencyMap;
    public boolean printed = false;
    public String dfsString = "";

    public Graph() {
        adjacencyMap = new HashMap<>();
    }

    public void addEdgeHelper(Node a, Node b) {
        LinkedList<Node> tmp = adjacencyMap.get(a);

        if (tmp != null) {
            tmp.remove(b);
        }
        else tmp = new LinkedList<>();
        tmp.add(b);
        adjacencyMap.put(a,tmp);
    }

    public void addEdge(Node source, Node destination) {

        if (!adjacencyMap.keySet().contains(source))
            adjacencyMap.put(source, null);

        if (!adjacencyMap.keySet().contains(destination))
            adjacencyMap.put(destination, null);

        addEdgeHelper(source, destination);
        addEdgeHelper(destination, source);

    }
    public boolean hasEdge(Node source, Node destination) {
        return adjacencyMap.containsKey(source) && adjacencyMap.get(source).contains(destination);
    }

    public void resetNodesVisited()
    {
    	 for (Node n : adjacencyMap.keySet()) {
             n.unvisit();
         }

    }

    String BFS(Node node) {
    	//implement the BFS code
      String output = "";
      Queue<Node> q = new<Node>LinkedList();
      q.add(node);
      output += ("The output for BFS is : ");
      while(!(q.isEmpty())){
        Node tmp = q.remove();
        while(!(tmp.isVisited())){
          tmp.visit();
          output += (tmp.name + " ");
          for(Node a : adjacencyMap.get(tmp)){
            if(!(a.isVisited())){
            q.add(a);
            }
          }
        }
      }
      return output;

    }


   public String DFS(Node node) {
     //Implement DFS
     if(!printed){
       dfsString += ("The output for DFS is : ");
       printed = true;
     }
     node.visit();
     dfsString += (node.name + " ");
     {
       for(Node a : adjacencyMap.get(node)){
         if(!(a.isVisited())){
           DFS(a);
         }
       }
     }
     return dfsString;
   }

   public String printEdges() {
     String output = "";
       //implement printEdges
       for (Node n : adjacencyMap.keySet()) {
         LinkedList<Node> tmp = adjacencyMap.get(n);
         output += (n.name + " has an edge towards: ");
         for(Node m: tmp){
           output += (m.name + " ");
         }
         output += ("\n");
       }
       return output;
   }
}
