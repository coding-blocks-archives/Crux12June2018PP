package L13_July8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import L10_July1.HeapGeneric;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 08-Jul-2018
 */

public class Graph {

	private class Vertex {
		HashMap<String, Integer> nbrs = new HashMap<>();
	}

	HashMap<String, Vertex> vertices = new HashMap<>();

	public int numVertex() {
		return vertices.size();
	}

	public boolean containsVertex(String vname) {
		return vertices.containsKey(vname);
	}

	public void addVertex(String vname) {

		Vertex vtx = new Vertex();
		vertices.put(vname, vtx);
	}

	public void removeVertex(String vname) {

		Vertex vtx = vertices.get(vname);
		for (String key : vtx.nbrs.keySet()) {

			Vertex nbrvtx = vertices.get(key);
			nbrvtx.nbrs.remove(vname);
		}

		vertices.remove(vname);
	}

	public int numEdges() {

		int sum = 0;

		ArrayList<String> keys = new ArrayList<>(vertices.keySet());

		for (String key : keys) {

			Vertex vtx = vertices.get(key);
			sum += vtx.nbrs.size();
		}

		return sum / 2;
	}

	public boolean containsEdge(String vname1, String vname2) {

		Vertex vtx1 = vertices.get(vname1);
		Vertex vtx2 = vertices.get(vname2);

		if (vtx1 == null || vtx2 == null || !vtx1.nbrs.containsKey(vname2)) {
			return false;
		}

		return true;
	}

	public void addEdge(String vname1, String vname2, int cost) {

		Vertex vtx1 = vertices.get(vname1);
		Vertex vtx2 = vertices.get(vname2);

		if (vtx1 == null || vtx2 == null || vtx1.nbrs.containsKey(vname2)) {
			return;
		}

		vtx1.nbrs.put(vname2, cost);
		// vtx2.nbrs.put(vname1, cost);
	}

	public void removeEdge(String vname1, String vname2) {

		Vertex vtx1 = vertices.get(vname1);
		Vertex vtx2 = vertices.get(vname2);

		if (vtx1 == null || vtx2 == null || !vtx1.nbrs.containsKey(vname2)) {
			return;
		}

		vtx1.nbrs.remove(vname2);
		vtx2.nbrs.remove(vname1);
	}

	public void display() {

		System.out.println("---------------------");
		for (String key : vertices.keySet()) {
			Vertex vtx = vertices.get(key);
			System.out.println(key + " -> " + vtx.nbrs);
		}
		System.out.println("---------------------");

	}

	public boolean hasPath(String src, String dst, HashMap<String, Boolean> processed) {

		processed.put(src, true);

		// de
		if (containsEdge(src, dst)) {
			return true;
		}

		Vertex vtx = vertices.get(src);

		for (String nbr : vtx.nbrs.keySet()) {

			if (!processed.containsKey(nbr) && hasPath(nbr, dst, processed)) {
				return true;
			}
		}

		return false;

	}

	private class Pair {
		String vname;
		Vertex vtx;
		String psf;
	}

	public boolean BFS(String src, String dst) {

		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> queue = new LinkedList<>();

		// make a sp and put in queue
		Pair sp = new Pair();
		sp.vname = src;
		sp.psf = src;
		sp.vtx = vertices.get(src);

		queue.addLast(sp);

		// work till queue is not empty
		while (!queue.isEmpty()) {

			// remove a pair
			Pair rp = queue.removeFirst();

			if (processed.containsKey(rp.vname)) {
				continue;
			}

			// processing
			processed.put(rp.vname, true);

			// de
			if (containsEdge(rp.vname, dst)) {
				System.out.println(rp.psf + dst);
				return true;
			}

			// nbrs
			for (String nbr : rp.vtx.nbrs.keySet()) {

				// put only unprocessed nbrs in queue
				if (!processed.containsKey(nbr)) {
					Pair np = new Pair();
					np.vname = nbr;
					np.psf = rp.psf + nbr;
					np.vtx = vertices.get(nbr);

					queue.addLast(np);
				}
			}

		}

		return false;

	}

	public boolean DFS(String src, String dst) {

		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> stack = new LinkedList<>();

		// make a sp and put in queue
		Pair sp = new Pair();
		sp.vname = src;
		sp.psf = src;
		sp.vtx = vertices.get(src);

		stack.addFirst(sp);

		// work till queue is not empty
		while (!stack.isEmpty()) {

			// remove a pair
			Pair rp = stack.removeFirst();

			if (processed.containsKey(rp.vname)) {
				continue;
			}

			// processing
			processed.put(rp.vname, true);

			// de
			if (containsEdge(rp.vname, dst)) {
				System.out.println(rp.psf + dst);
				return true;
			}

			// nbrs
			for (String nbr : rp.vtx.nbrs.keySet()) {

				// put only unprocessed nbrs in queue
				if (!processed.containsKey(nbr)) {
					Pair np = new Pair();
					np.vname = nbr;
					np.psf = rp.psf + nbr;
					np.vtx = vertices.get(nbr);

					stack.addFirst(np);
				}
			}

		}

		return false;

	}

	public void BFT() {
		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> queue = new LinkedList<>();

		for (String key : vertices.keySet()) {

			if (processed.containsKey(key)) {
				continue;
			}

			// make a sp and put in queue
			Pair sp = new Pair();
			sp.vname = key;
			sp.psf = key;
			sp.vtx = vertices.get(key);

			queue.addLast(sp);

			// work till queue is not empty
			while (!queue.isEmpty()) {

				// remove a pair
				Pair rp = queue.removeFirst();

				if (processed.containsKey(rp.vname)) {
					continue;
				}

				// processing
				processed.put(rp.vname, true);

				// syso
				System.out.println(rp.vname + " via " + rp.psf);

				// nbrs
				for (String nbr : rp.vtx.nbrs.keySet()) {

					// put only unprocessed nbrs in queue
					if (!processed.containsKey(nbr)) {
						Pair np = new Pair();
						np.vname = nbr;
						np.psf = rp.psf + nbr;
						np.vtx = vertices.get(nbr);

						queue.addLast(np);
					}
				}

			}

		}

	}

	public void DFT() {

		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> stack = new LinkedList<>();

		for (String key : vertices.keySet()) {

			if (processed.containsKey(key)) {
				continue;
			}

			// make a sp and put in queue
			Pair sp = new Pair();
			sp.vname = key;
			sp.psf = key;
			sp.vtx = vertices.get(key);

			stack.addFirst(sp);

			// work till queue is not empty
			while (!stack.isEmpty()) {

				// remove a pair
				Pair rp = stack.removeFirst();

				if (processed.containsKey(rp.vname)) {
					continue;
				}

				// processing
				processed.put(rp.vname, true);

				// syso
				System.out.println(rp.vname + " via " + rp.psf);

				// nbrs
				for (String nbr : rp.vtx.nbrs.keySet()) {

					// put only unprocessed nbrs in queue
					if (!processed.containsKey(nbr)) {
						Pair np = new Pair();
						np.vname = nbr;
						np.psf = rp.psf + nbr;
						np.vtx = vertices.get(nbr);

						stack.addFirst(np);
					}
				}

			}

		}

	}

	public boolean isConnected() {

		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> queue = new LinkedList<>();

		int flag = 0;

		for (String key : vertices.keySet()) {

			if (processed.containsKey(key)) {
				continue;
			}

			flag++;
			// make a sp and put in queue
			Pair sp = new Pair();
			sp.vname = key;
			sp.psf = key;
			sp.vtx = vertices.get(key);

			queue.addLast(sp);

			// work till queue is not empty
			while (!queue.isEmpty()) {

				// remove a pair
				Pair rp = queue.removeFirst();

				if (processed.containsKey(rp.vname)) {
					continue;
				}

				// processing
				processed.put(rp.vname, true);

				// nbrs
				for (String nbr : rp.vtx.nbrs.keySet()) {

					// put only unprocessed nbrs in queue
					if (!processed.containsKey(nbr)) {
						Pair np = new Pair();
						np.vname = nbr;
						np.psf = rp.psf + nbr;
						np.vtx = vertices.get(nbr);

						queue.addLast(np);
					}
				}

			}

		}

		if (flag > 1) {
			return false;
		} else {
			return true;
		}

	}

	public boolean isCyclic() {

		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> queue = new LinkedList<>();

		int flag = 0;

		for (String key : vertices.keySet()) {

			if (processed.containsKey(key)) {
				continue;
			}

			// make a sp and put in queue
			Pair sp = new Pair();
			sp.vname = key;
			sp.psf = key;
			sp.vtx = vertices.get(key);

			queue.addLast(sp);

			// work till queue is not empty
			while (!queue.isEmpty()) {

				// remove a pair
				Pair rp = queue.removeFirst();

				if (processed.containsKey(rp.vname)) {
					flag++;
					continue;
				}

				// processing
				processed.put(rp.vname, true);

				// nbrs
				for (String nbr : rp.vtx.nbrs.keySet()) {

					// put only unprocessed nbrs in queue
					if (!processed.containsKey(nbr)) {
						Pair np = new Pair();
						np.vname = nbr;
						np.psf = rp.psf + nbr;
						np.vtx = vertices.get(nbr);

						queue.addLast(np);
					}
				}

			}

		}

		if (flag >= 1) {
			return true;
		} else {
			return false;
		}

	}

	public boolean isTree() {
		return isConnected() && !isCyclic();
	}

	public ArrayList<ArrayList<String>> getCC() {

		ArrayList<ArrayList<String>> ans = new ArrayList<>();

		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> queue = new LinkedList<>();

		for (String key : vertices.keySet()) {

			if (processed.containsKey(key)) {
				continue;
			}

			ArrayList<String> subans = new ArrayList<>();

			// make a sp and put in queue
			Pair sp = new Pair();
			sp.vname = key;
			sp.psf = key;
			sp.vtx = vertices.get(key);

			queue.addLast(sp);

			// work till queue is not empty
			while (!queue.isEmpty()) {

				// remove a pair
				Pair rp = queue.removeFirst();

				if (processed.containsKey(rp.vname)) {
					continue;
				}

				// processing
				processed.put(rp.vname, true);

				// nbrs
				for (String nbr : rp.vtx.nbrs.keySet()) {

					// put only unprocessed nbrs in queue
					if (!processed.containsKey(nbr)) {
						Pair np = new Pair();
						np.vname = nbr;
						np.psf = rp.psf + nbr;
						np.vtx = vertices.get(nbr);

						queue.addLast(np);
					}
				}

			}

			ans.add(subans);

		}

		return ans;
	}

	private class PrimsPair implements Comparable<PrimsPair> {

		String vname;
		String acqvname;
		int cost;

		@Override
		public int compareTo(PrimsPair o) {
			return o.cost - this.cost;
		}
	}

	// ELog(V) + VLog(V)
	public Graph prims() {

		// heap, processed, mst
		HeapGeneric<PrimsPair> heap = new HeapGeneric<>();
		HashMap<String, PrimsPair> processed = new HashMap<>();
		Graph mst = new Graph();

		// make a pair of every vertex and put in heap
		for (String keys : vertices.keySet()) {

			PrimsPair np = new PrimsPair();
			np.vname = keys;
			np.acqvname = null;
			np.cost = Integer.MAX_VALUE;

			// also put the pair in heap and processed
			heap.insert(np);
			processed.put(keys, np);
		}

		// work till heap is not empty
		while (!heap.isEmpty()) {

			// remove the pair from heap and also remove from processed
			PrimsPair rp = heap.remove();
			processed.remove(rp.vname);

			// create a mst
			if (rp.acqvname == null) {
				mst.addVertex(rp.vname);
			} else {
				mst.addVertex(rp.vname);
				mst.addEdge(rp.acqvname, rp.vname, rp.cost);
			}

			// nbrs
			for (String nbr : vertices.get(rp.vname).nbrs.keySet()) {

				// update only those nbrs which are present in heap
				if (processed.containsKey(nbr)) {

					// find the oc and nc
					int oc = processed.get(nbr).cost;
					int nc = vertices.get(rp.vname).nbrs.get(nbr);

					// update only when nc < oc
					if (nc < oc) {

						// update the pair of heap
						processed.get(nbr).cost = nc;
						processed.get(nbr).acqvname = rp.vname;

						// update the priority in heap
						heap.updatePriority(processed.get(nbr));

					}
				}

			}

		}

		return mst;

	}

	private class DijkstraPair implements Comparable<DijkstraPair> {

		String vname;
		String psf;
		int cost;

		@Override
		public int compareTo(DijkstraPair o) {
			return o.cost - this.cost;
		}
	}

	public void dijkstra(String src) {

		HeapGeneric<DijkstraPair> heap = new HeapGeneric<>();
		HashMap<String, DijkstraPair> processed = new HashMap<>();

		// make a pair of every vertex and put in heap
		for (String keys : vertices.keySet()) {

			DijkstraPair np = new DijkstraPair();
			np.vname = keys;
			np.psf = "";
			np.cost = Integer.MAX_VALUE;

			if (keys.equals(src)) {
				np.psf = keys;
				np.cost = 0;
			}
			// also put the pair in heap and processed
			heap.insert(np);
			processed.put(keys, np);

		}

		// work till heap is not empty
		while (!heap.isEmpty()) {

			// remove the pair from heap and also remove from processed
			DijkstraPair rp = heap.remove();
			processed.remove(rp.vname);

			// print
			System.out.println(rp.vname + " via " + rp.psf);

			// nbrs
			for (String nbr : vertices.get(rp.vname).nbrs.keySet()) {

				// update only those nbrs which are present in heap
				if (processed.containsKey(nbr)) {

					// find the oc and nc
					int oc = processed.get(nbr).cost;
					int nc = rp.cost + vertices.get(rp.vname).nbrs.get(nbr);

					// update only when nc < oc
					if (nc < oc) {

						// update the pair of heap
						processed.get(nbr).cost = nc;
						processed.get(nbr).psf = rp.psf + nbr;

						// update the priority in heap
						heap.updatePriority(processed.get(nbr));

					}
				}

			}

		}

	}

	private class BFPair {

		String v1;
		String v2;
		int cost;

	}

	public ArrayList<BFPair> getAllEdges() {

		ArrayList<BFPair> ans = new ArrayList<>();

		for (String vname : vertices.keySet()) {

			Vertex vtx = vertices.get(vname);
			for (String nbr : vtx.nbrs.keySet()) {

				BFPair np = new BFPair();
				np.v1 = vname;
				np.v2 = nbr;
				np.cost = vtx.nbrs.get(nbr);
				ans.add(np);
			}

		}

		return ans;
	}

	public void BellmanFord(String src) throws Exception {

		HashMap<String, Integer> map = new HashMap<>();

		// prepare your map, which contains vertex names and their cost
		ArrayList<String> keys = new ArrayList<>(vertices.keySet());
		for (String key : keys) {
			map.put(key, Integer.MAX_VALUE);

			if (key.equals(src)) {
				map.put(key, 0);
			}
		}

		int V = map.size();

		ArrayList<BFPair> list = getAllEdges();

		// relax each edge V-1 times
		for (int i = 1; i <= V - 1; i++) {

			for (BFPair pair : list) {

				int oc = map.get(pair.v2);

				int nc = Integer.MAX_VALUE;
				if (!map.get(pair.v1).equals(Integer.MAX_VALUE)) {
					nc = map.get(pair.v1) + pair.cost;
				}

				if (nc < oc) {
					map.put(pair.v2, nc);
				}

			}
		}

		// relax all edges Vth time
		for (BFPair pair : list) {

			int oc = map.get(pair.v2);

			int nc = Integer.MAX_VALUE;
			if (!map.get(pair.v1).equals(Integer.MAX_VALUE)) {
				nc = map.get(pair.v1) + pair.cost;
			}

			if (nc < oc) {
				throw new Exception("-ve wt cycle is present");
			}

		}
		// System.out.println(map);

	}

}
