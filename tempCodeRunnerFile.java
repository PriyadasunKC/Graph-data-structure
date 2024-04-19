import java.util.*;

class BreadthFirstSearch_Using_Recursion {
    private HashMap<Integer, List<Integer>> graph;

    public BreadthFirstSearch_Using_Recursion() {
        this.graph = new HashMap<>();
    }

    public void addEdge(int source, int destination) {
        if (!graph.containsKey(source)) {
            graph.put(source, new ArrayList<>());
        }
        graph.get(source).add(destination);
    }

    public void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);

        bfsRecursive(queue, visited);
    }

    private void bfsRecursive(Queue<Integer> queue, Set<Integer> visited) {
        if (queue.isEmpty()) {
            return;
        }

        int vertex = queue.poll();
        System.out.println(vertex + " ");

        List<Integer> neighbors = graph.get(vertex);
        if (neighbors != null) {
            for (int neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }

        bfsRecursive(queue, visited);
    }

    public static void main(String[] args) {
        BreadthFirstSearch_Using_Recursion bfs = new BreadthFirstSearch_Using_Recursion();
        bfs.addEdge(0, 1);
        bfs.addEdge(0, 2);
        bfs.addEdge(1, 2);
        bfs.addEdge(2, 0);
        bfs.addEdge(2, 3);
        bfs.addEdge(3, 3);

        bfs.bfs(2);
    }
}