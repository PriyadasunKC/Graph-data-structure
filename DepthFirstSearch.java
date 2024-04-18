import java.util.*;

class DepthFirstSearch {
    private HashMap<Integer, List<Integer>> graph;

    public DepthFirstSearch() {
        this.graph = new HashMap<>();
    }

    public void addEdge(int source, int destination) {
        if (!graph.containsKey(source)) {
            graph.put(source, new ArrayList<>());
        }
        graph.get(source).add(destination);
    }

    public void dfs(int start) {
        Set<Integer> visited = new HashSet<>();
        dfsHelper(start, visited);
    }

    private void dfsHelper(int vertex, Set<Integer> visited) {
        visited.add(vertex);
        System.out.println(vertex + " ");
        List<Integer> neighbors = graph.get(vertex);

        if (neighbors != null) {
            for (int neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    dfsHelper(neighbor, visited);
                }
            }
        }
    }

    public static void main(String[] args) {
        DepthFirstSearch dfs = new DepthFirstSearch();
        dfs.addEdge(0, 1);
        dfs.addEdge(0, 2);
        dfs.addEdge(1, 2);
        dfs.addEdge(2, 0);
        dfs.addEdge(2, 3);
        dfs.addEdge(3, 3);

        dfs.dfs(2);
    }
}