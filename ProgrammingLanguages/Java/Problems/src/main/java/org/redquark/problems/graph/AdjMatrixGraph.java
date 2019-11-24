package org.redquark.problems.graph;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

public class AdjMatrixGraph {

	private static Random random;
	private static final String NEWLINE = System.getProperty("line.separator");

	private final int V;
	private int E;
	private boolean[][] adj;

	// empty graph with V vertices
	public AdjMatrixGraph(int V) {
		if (V < 0)
			throw new IllegalArgumentException("Too few vertices");
		this.V = V;
		this.E = 0;
		this.adj = new boolean[V][V];
	}

	// random graph with V vertices and E edges
	public AdjMatrixGraph(int V, int E) {
		this(V);
		random = new Random();
		if (E > (long) V * (V - 1) / 2 + V)
			throw new IllegalArgumentException("Too many edges");
		if (E < 0)
			throw new IllegalArgumentException("Too few edges");

		// can be inefficient
		while (this.E != E) {
			int v = uniform(V);
			int w = uniform(V);
			addEdge(v, w);
		}
	}

	public static int uniform(int n) {
		if (n <= 0)
			throw new IllegalArgumentException("argument must be positive: " + n);
		return random.nextInt(n);
	}

	// number of vertices and edges
	public int V() {
		return V;
	}

	public int E() {
		return E;
	}

	// add undirected edge v-w
	public void addEdge(int v, int w) {
		if (!adj[v][w])
			E++;
		adj[v][w] = true;
		adj[w][v] = true;
	}

	// does the graph contain the edge v-w?
	public boolean contains(int v, int w) {
		return adj[v][w];
	}

	// return list of neighbors of v
	public Iterable<Integer> adj(int v) {
		return new AdjIterator(v);
	}

	// support iteration over graph vertices
	private class AdjIterator implements Iterator<Integer>, Iterable<Integer> {
		private int v;
		private int w = 0;

		AdjIterator(int v) {
			this.v = v;
		}

		public Iterator<Integer> iterator() {
			return this;
		}

		public boolean hasNext() {
			while (w < V) {
				if (adj[v][w])
					return true;
				w++;
			}
			return false;
		}

		public Integer next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			return w++;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	// string representation of Graph - takes quadratic time
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(V + " " + E + NEWLINE);
		for (int v = 0; v < V; v++) {
			s.append(v + ": ");
			for (boolean w : adj[v]) {
				s.append((w ? 1 : 0) + " ");
			}
			s.append(NEWLINE);
		}
		return s.toString();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int V = sc.nextInt();
		int E = sc.nextInt();
		sc.close();
		AdjMatrixGraph G = new AdjMatrixGraph(V, E);
		G.addEdge(1, 2);
		System.out.println(G);
	}
}
