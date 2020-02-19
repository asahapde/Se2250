/* Authors: Abdullah Sahapdeen - Id: asahapde - Student Number: 251033977 and Mayank Sood - Id: msood - Student Number: 251000865
   Date Created: December 3, 2019
*/
import java.util.*;

public class Graph {

    private HashMap<Node, LinkedList<Node>> adjacencyMap;
    private boolean printed = false;
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

    void BFS(Node node) {
    	//implement the BFS code
      Queue<Node> q = new<Node>LinkedList();
      q.add(node);
      System.out.print("The output for BFS is : ");
      while(!(q.isEmpty())){
        Node tmp = q.remove();
        while(!(tmp.isVisited())){
          tmp.visit();
          System.out.print(tmp.name + " ");
          for(Node a : adjacencyMap.get(tmp)){
            if(!(a.isVisited())){
            q.add(a);
            }
          }
        }
      }
      System.out.println();

    }


   public void DFS(Node node) {
     //Implement DFS
     if(!printed){
       System.out.print("The output for DFS is : ");
       printed = true;
     }
     node.visit();
     System.out.print(node.name + " ");
     {
       for(Node a : adjacencyMap.get(node)){
         if(!(a.isVisited())){
           DFS(a);
         }
       }
     }

   }

   public void printEdges() {
       //implement printEdges
       for (Node n : adjacencyMap.keySet()) {
         LinkedList<Node> tmp = adjacencyMap.get(n);
         System.out.print(n.name + " has an edge towards: ");
         for(Node m: tmp){
           System.out.print(m.name + " ");
         }
         System.out.println();
       }
   }
}
