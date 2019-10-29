import java.util.*;

public class DOS {
    public static void main(String argv[]) throws Exception {
        String filename = argv[0];
        String[] fields = filename.split("[.]");
        if (fields[1].equals("ig")) {
            Graph<Integer> g = GraphUtils.readIntegerGraph(fields[0]);
            Integer v1 = Integer.parseInt(argv[1]);
            Integer v2 = Integer.parseInt(argv[2]);
            BreadthFirstPaths bfp = new BreadthFirstPaths(g, v1);
            Deque<Integer> path = bfp.pathTo(v2);
            if (path == null)
                throw new Exception("No path found");
            System.out.println("Degrees of separation = " + bfp.distTo(v2));
            System.out.println("Sample Path:");
            for (Integer p : path)
                System.out.println(p);
        } else if (fields[1].equals("sg")) {
            Graph<String> g = GraphUtils.readStringGraph(fields[0],argv[1]);
            String v1 = argv[2];
            String v2 = argv[3];
            BreadthFirstPaths bfp = new BreadthFirstPaths(g, v1);
            Deque<String> path = bfp.pathTo(v2);
            if (path == null)
                throw new Exception("No path found");
            System.out.println("Degrees of separation = " + bfp.distTo(v2));
            System.out.println("Sample Path:");
            for (String p : path)
                System.out.println(p);
        } else throw new Exception("Bad filename");
    }
}
