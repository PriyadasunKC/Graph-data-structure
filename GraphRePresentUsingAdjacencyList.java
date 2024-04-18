
// Import the LinkedList class from the java.util package
import java.util.LinkedList;

// Define a new class named Graph
class Graph {
    // Declare a private integer to store the number of vertices in the graph
    private int numbVertices;
    // Declare an array of LinkedLists to store the adjacency list representation of
    // the graph
    private LinkedList<Integer>[] adjacencyList;

    // Suppress warnings related to unchecked operations, which are necessary here
    // due to the creation of an array of a generic type
    @SuppressWarnings("unchecked")
    // Define a constructor for the Graph class that takes an integer as an argument
    public Graph(int numberOfVertices) {
        // Initialize the number of vertices
        this.numbVertices = numberOfVertices;
        // Initialize the adjacency list as an array of LinkedLists with size equal to
        // the number of vertices
        adjacencyList = new LinkedList[numberOfVertices];
        // For each vertex in the graph
        for (int i = 0; i < numberOfVertices; i++) {
            // Initialize the adjacency list for that vertex as a new LinkedList
            adjacencyList[i] = new LinkedList<>();
        }
    }

    // Define a method to add an edge to the graph
    public void addEdge(int source, int destination) {
        // Add the destination to the adjacency list of the source vertex
        adjacencyList[source].add(destination);
        // For an undirected graph, you would also add the source to the adjacency list
        // of the destination vertex
        // adjacencyList[destination].add(source);
    }

    // Define a method to print the graph
    public void printGraph() {
        // For each vertex in the graph
        for (int v = 0; v < numbVertices; v++) {
            // Print the vertex number
            System.out.println("Adjacency list of vertex " + v);
            System.out.print("head");
            // For each vertex in the adjacency list of the current vertex
            for (Integer pCrawl : adjacencyList[v]) {
                // Print the vertex number
                System.out.print(" -> " + pCrawl);
            }
            // Print a newline
            System.out.println("\n");
        }
    }
}

// Define a new public class named GraphRePresentUsingAdjacencyList
public class GraphRePresentUsingAdjacencyList {
    // Define the main method, which is the entry point of the program
    public static void main(String[] args) {
        // Create a new Graph object with 5 vertices
        Graph graph = new Graph(5);
        // Add edges to the graph
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        // Print the graph
        graph.printGraph();
    }
}