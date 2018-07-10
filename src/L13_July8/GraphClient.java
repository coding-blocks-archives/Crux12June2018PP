package L13_July8;

import java.util.HashMap;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 07-Jul-2018
 */

public class GraphClient {

	public static void main(String[] args) throws Exception {

		Graph graph = new Graph();

		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addVertex("E");
		graph.addVertex("F");
		// graph.addVertex("G");

		// graph.addEdge("A", "B", 1);
		// graph.addEdge("A", "D", 5);
		// graph.addEdge("C", "B", 2);
		// graph.addEdge("C", "D", 10);
		// graph.addEdge("D", "E", 15);
		// graph.addEdge("E", "F", 2);
		// graph.addEdge("G", "E", 5);
		// graph.addEdge("F", "G", 6);

		graph.addEdge("A", "B", 6);
		graph.addEdge("A", "E", 5);
		graph.addEdge("A", "D", 4);
		graph.addEdge("E", "F", 4);
		graph.addEdge("D", "E", -3);
		graph.addEdge("B", "C", 2);
		graph.addEdge("C", "F", -3);
		graph.addEdge("F", "C", 2);

		// graph.addEdge("A", "B", 5);
		// graph.addEdge("B", "C", -2);
		// graph.addEdge("A", "C", 4);
		//
		// graph.addEdge("A", "B", 1);
		// graph.addEdge("B", "C", 2);
		// graph.addEdge("C", "D", 2);
		// graph.addEdge("D", "B", 6);

		graph.display();

		// graph.removeVertex("A");
		// graph.removeEdge("B", "C");
		// graph.removeEdge("E", "G");
		// graph.display();

		// System.out.println(graph.hasPath("A", "F", new HashMap<>()));
		// System.out.println(graph.BFS("A", "F"));
		// System.out.println(graph.DFS("A", "F"));
		// graph.BFT();
		// graph.DFT();

		// System.out.println(graph.isConnected());
		// System.out.println(graph.getCC());
		// System.out.println(graph.isCyclic());
		// System.out.println(graph.isTree());

		// graph.prims().display();

		// graph.dijkstra("A");

		graph.BellmanFord("A");
	}

}
