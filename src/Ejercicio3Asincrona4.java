import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class Ejercicio3Asincrona4 {
	
	static class Vertex {
		int key;
		List<Vertex> neighbors;
		public Vertex(int key) {
			this.key = key;
			
			this.neighbors = new ArrayList<>();
		}
	}
	
	static int maxDistanceFrom(Vertex start) {
		System.out.println("su key:"+ start.key);
		System.out.println("sus vecinos: ");
		int max=0;
		//System.out.println(start.neighbors.get(0).key);
		//System.out.println(start.neighbors.get(1).key);
		
		//si fuera un vertice sin vecinos
		//caso base 
		if(start.neighbors.size()==0) {
			return 0;
		}else {
			
		}
		
		
		for(int i=0;i<2;i++) {
			System.out.println(start.neighbors.get(0).neighbors.get(i).key);
		}
		
	
		
		return 0;
	}

	
	public static void main(String [] args) {
		   Vertex v1 = new Vertex(1);
		   Vertex v2 = new Vertex(2);
		   Vertex v3 = new Vertex(3);
		   Vertex v4 = new Vertex(4);
		   Vertex v5 = new Vertex(5);
		   
		   
		   v1.neighbors.add(v2); v2.neighbors.add(v1);
		   v2.neighbors.add(v3); v3.neighbors.add(v2);
		   v3.neighbors.add(v4); v4.neighbors.add(v3);
		   v4.neighbors.add(v5); v5.neighbors.add(v4);

		   int md1 = maxDistanceFrom(v1); 	// md1 = 4 [v5]
		   //int md2 = maxDistanceFrom(v4); 	// md2 = 3 [v1]

			//v1.neighbors.add(v5); v5.neighbors.add(v1);
			//int md3 = maxDistanceFrom(v1); 	// md3 = 2 [v3, v4]
		

	}

}
