import java.util.*;

class DepthFirstSearch_Using_STACK {
    private HashMap<Integer, List<Integer>> graph;

    public DepthFirstSearch_Using_STACK() {
        this.graph = new HashMap<>();
    }

    public void addEdge(int source, int destination) {
        if (!graph.containsKey(source)) {
            graph.put(source, new ArrayList<>());
        }
        graph.get(source).add(destination);
    }

    public void dfs(int start) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();

        stack.push(start);
        visited.add(start);

        while (!stack.isEmpty()) {
            int vertex = stack.pop();
            System.out.println(vertex + " ");

            List<Integer> neighbors = graph.get(vertex);
            if (neighbors != null) {
                for (int neighbor : neighbors) {
                    if (!visited.contains(neighbor)) {
                        stack.push(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        DepthFirstSearch_Using_STACK dfs = new DepthFirstSearch_Using_STACK();
        dfs.addEdge(0, 1);
        dfs.addEdge(0, 2);
        dfs.addEdge(1, 2);
        dfs.addEdge(2, 0);
        dfs.addEdge(2, 3);
        dfs.addEdge(3, 3);

        dfs.dfs(2);
    }
}