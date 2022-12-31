public class Ejercicio2 {
	static class RBNode{
		int key;
		RBNode left, right=null;
		//TRUE ES ROJO
		//FALSE ES NEGRO
		boolean color =true;
		
		public RBNode(int key, boolean color) {
			this.key=key;
			this.color=color;
		}
	}
	//devuele la cantidad de nodos negros
	//en base  a la info que se le paso en el constructor
	static int countBlackNodes(RBNode node) {
		int count=0;
		if(node==null) return 0;
	
		count+=countBlackNodes(node.left);
		count+=countBlackNodes(node.right);
		if(node.color==false) 
			count++;
		
		return count;
	}
	
	static boolean holdsBlackProperty(RBNode node) {
		
		//estas impresiones nos muestran el numero de 
		//negros hasta llegar a una hoja
		//nos ayudo a comprobar
		
		//System.out.println("L:"+countBlackNodes(node.left));
		//System.out.println("R:"+countBlackNodes(node.right));
		
		return countBlackNodes(node.left)==countBlackNodes(node.right);
	}
	
	private static void printRBNode(RBNode node, String spaces, char c, int level) {
		 if(node==null) return;
		 System.out.println(spaces+level+"."+c+" "+node.key);
		 printRBNode(node.left,spaces+" ",'I',level+1);
		 printRBNode(node.right,spaces+" ",'D',level+1);
	 }
	 
	 public static void printRBNode(RBNode node) {
		 printRBNode(node,"",'#',0);	 
	 }

	public static void main(String[] args) {
		RBNode root1= new RBNode(2,false);
		root1.left = new RBNode(1,false);
		root1.right = new RBNode(6,true);
		root1.right.left = new RBNode(4,false);
		root1.right.left.right = new RBNode(5,false);
		root1.right.right = new RBNode(8,false);
		
		printRBNode(root1);
		
		//boolean holds1= holdsBlackProperty(root1); //false
		System.out.println("Nodos negros totales: "+countBlackNodes(root1));
		boolean holds1= holdsBlackProperty(root1);
		System.out.println(holds1);
		
		
		System.out.println("**********");
		RBNode root2= new RBNode(4,false);
		
		root2.left= new RBNode (2,false);
		root2.left.left= new RBNode (1,true);
		root2.left.right= new RBNode (3,true);
		
		root2.right= new RBNode (6,false);
		root2.right.left= new RBNode (5,true);
		root2.left.right= new RBNode (7,true);
		printRBNode(root2);
		System.out.println("Nodos negros totales: "+countBlackNodes(root2));
		boolean holds2= holdsBlackProperty(root2);
		System.out.println(holds2);
	}
}
