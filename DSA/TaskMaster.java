package java_collection.DSA;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TaskMaster {

    public static int tasks(int n, List<Integer> a, List<Integer> b) {
        // Create adjacency list and in-degree array
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // Build the graph
        for (int i = 0; i < a.size(); i++) {
            graph.get(a.get(i)).add(b.get(i));
            inDegree[b.get(i)]++;
        }

        // Topological sort using a queue
        Queue<Integer> queue = new LinkedList<>();
        int completedTasks = 0;

        // Add tasks with no dependencies to the queue
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        // Process the tasks
        while (!queue.isEmpty()) {
            int current = queue.poll();
            completedTasks++;

            for (int neighbor : graph.get(current)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        // Check if there are any tasks left with non-zero in-degree
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] > 0) {
                return 0; // Not all tasks can be completed
            }
        }

        return 1; // All tasks can be completed
    }


    public static void main(String[] args) throws IOException {
        // Example Input
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bufferedReader.readLine().trim());
        int aCount = Integer.parseInt(bufferedReader.readLine().trim());
        List<String> aTemp = new ArrayList<>();
        IntStream.range(0, aCount).forEach(i -> {
            try {
                aTemp.add(bufferedReader.readLine().trim());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        List<Integer> a = aTemp.stream().map(String::trim).map(Integer::parseInt).collect(Collectors.toList());
        int bCount = Integer.parseInt(bufferedReader.readLine().trim());
        List<String> bTemp = new ArrayList<>();
        IntStream.range(0, bCount).forEach(i -> {
            try {
                bTemp.add(bufferedReader.readLine().trim());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        List<Integer> b = bTemp.stream().map(String::trim).map(Integer::parseInt).collect(Collectors.toList());
        // Function Call
        int result = tasks(n, a, b);
        System.out.println(result);
        bufferedReader.close();
        bufferedWriter.close();
    }

}
