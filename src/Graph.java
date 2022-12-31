import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Graph<T> {
	
	private class Vertex{
		T key;
		
		//clavesde los vecinos
		Set<T> neighborSet;
		//lista de los vecino 
		List<Vertex> neighbors;
		boolean visited=false;
		List <Double> weights;
		
		public Vertex(T key) {
			this.key=key;
			this.neighbors= new ArrayList<>();
			this.neighborSet= new HashSet<>();
			this.weights= new ArrayList<>();
			
		}
		
		
		public String toString(){
			return ""+this.neighborSet+", "+this.weights;
		}
	}
	
	//un mapa es la manera más rápida de hacer la búsqueda
	//trabaja con claves
	
	//este realmente es mi grafo
	private Map<T, Vertex> vertexMap = new HashMap<>();
	
	//añadir vertex
	public boolean addVertex(T key) {
		if(vertexMap.containsKey(key)) return false;
		
		vertexMap.put(key, new Vertex(key));
		
		return true;
		
	}
	
	
	//edge es bidireccional (arista)
	public boolean addEdge(T key1, T key2,double weight) {
		//si no contiene cualquiera de las 2  devolvemos falso
		if(!vertexMap.containsKey(key1) || !vertexMap.containsKey(key1))
			return false;
		
		//ya estamos seguros q ambas claves estan en el mapa
		
		//tengo que extraer el vertex 
		Vertex v1=vertexMap.get(key1);
		//ver vecinos y ver si esta 
		if(v1.neighborSet.contains(key2)) return false;
		Vertex v2 = vertexMap.get(key2);
		v1.neighborSet.add(key2);
		v1.neighbors.add(v2);
		v1.weights.add(weight);
		v2.neighborSet.add(key1);
		v2.neighbors.add(v1);
		v2.weights.add(weight);
		return true;


	}
	
	//arco es flecha, 1 direccion
	public boolean addArc(T key1, T key2,double weight) {
		//si no contiene cualquiera de las 2  devolvemos falso
		if(!vertexMap.containsKey(key1) || !vertexMap.containsKey(key2))
			return false;
			Vertex v1 = vertexMap.get(key1);
			if(v1.neighborSet.contains(key2)) return false;
			Vertex v2 = vertexMap.get(key2);
			v1.neighborSet.add(key2);
			v1.neighbors.add(v2);
			v1.weights.add(weight);
			return true;
		
	}
	
	public boolean addEdge(T key1, T key2) {
		return addEdge(key1, key2, 1.0);
	}
	
	public boolean addArc(T key1, T key2) {
		return addArc(key1, key2, 1.0);
	}
	
	public String toString() {
		return vertexMap.toString();
	}
	
	private void reset() {
		for(Vertex v: vertexMap.values())
			v.visited = false;
	}
		
	private void visit(Vertex v) {
		System.out.println("Visited: " + v.key);
		v.visited = true;
		for(Vertex n: v.neighbors) {
			if(!n.visited) visit(n);
			}
	}
	
	
	public void dfs(T startKey) {
		if(!vertexMap.containsKey(startKey)) return;
		reset();
		Vertex startVertex = vertexMap.get(startKey);
		visit(startVertex);
		System.out.println("--------------");
		}
	
	public void bfs(T startKey) {
		if(!vertexMap.containsKey(startKey))
			return;
		reset();
		Vertex startVertex = vertexMap.get(startKey);
		Queue<Vertex> vertexQueue = new ArrayDeque<>();
		vertexQueue.offer(startVertex);
		while(!vertexQueue.isEmpty() ) {
			Vertex v = vertexQueue.poll();
			if(v.visited) continue;
			System.out.println("Visited: " + v.key);
			v.visited = true;
			for(Vertex n: v.neighbors) {
				if(!n.visited) vertexQueue.offer(n);
				}
		}
		System.out.println("--------------");
		}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph<String> g1 = new Graph<>();
		g1.addVertex("A"); g1.addVertex("B");
		g1.addVertex("C"); g1.addVertex("D");
		g1.addVertex("E"); g1.addVertex("F");
		g1.addVertex("G"); g1.addVertex("H");
		g1.addEdge("A", "B"); g1.addEdge("A", "C");
		g1.addEdge("B", "D"); g1.addEdge("B", "F");
		g1.addEdge("C", "D"); g1.addEdge("C", "E");
		g1.addEdge("A", "D", 3.5);
		g1.addEdge("D", "F", 4);
		g1.addEdge("G", "H");
		g1.dfs("A");
		g1.dfs("E");
		g1.dfs("G");
		g1.dfs("H");
		g1.bfs("A");
		// A --- B --  F
		// |  \  |   / 
		// C --- D -
		// |
		// E     G --- H
		//
		// B squeda en profundidad: DFS
		// Resultado:    A - B - D - C - E - F
		// Primer vecino, primer vecino no visitado del primer vecino, primer 
		//vecino no visitado del primer vecino del primer vecino
		
		
		// Se esperan 3 false
		// System.out.println(g1.addVertex("A")); // A ya existe
		// System.out.println(g1.addEdge("D", "C")); // (D, C) ya existe
		// System.out.println(g1.addEdge("A", "G")); // G no existe
		//
		// g1.addEdge("E", "F");
		// System.out.println(g1);
		/*
		Graph<Integer> g2 = new Graph<>();
		int N = 100;
		for(int i = 1; i <= N; i ++) g2.addVertex(i);
		for(int i = 1; i <= N; i ++) {
		g2.addArc(i, (i + 1) % N);
		g2.addArc(i, (i + 2) % N, 3 * Math.random());
		}
		System.out.println(g2);*/

	}

}
