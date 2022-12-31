
public class BST<T extends Comparable<T>> {
	
	private class Node{
		Node left,right,parent=null;
		T key;
		public Node(T key, Node parent) {
			this.key=key;
			this.parent=parent;
		}
	}
	
	private Node root=null;
	public int size=0;
	
	public boolean add(T key) {
		if(this.root == null) {
			this.root = new Node(key, null);
			this.size = 1;
			return true;
		} else {
			Node tmp = this.root;
			boolean found = false, added = false;
			while(!found && !added) {
				if(key.compareTo(tmp.key) == 0) {
					found = true;
				} else if(key.compareTo(tmp.key) < 0) {
					if(tmp.left == null) {
						tmp.left = new Node(key, tmp);
						added = true;
					} else {
						tmp = tmp.left;
					}				
				} else {
					if(tmp.right == null) {
						tmp.right = new Node(key, tmp);
						added = true;
					} else {
						tmp = tmp.right;
					}	
				}	
			}
			if(added) this.size ++;
			return added;
		}	
	}
	
	
	public int size() {
		return this.size;
	}
	
	private Node search(T key, Node tmp) {
		if(tmp== null) return null;
		int res = key.compareTo(tmp.key);
		if(res== 0) return tmp;
		if(res<0) return search(key, tmp.left);
		return search(key, tmp.right);
	}
	public boolean contains(T key) {
		Node n= search(key, this.root);
		return n!=null;
	}
	
	private Node minimun(Node node) {
		if(node.left==null) return node;
		return minimun(node.left);
	}
	
	public T minimun() {
		if(this.root==null) return null;
		Node m=minimun(this.root);
		return m.key;
	}
	
	private Node maximum(Node node) {
		while(node.right!= null) node=node.right;
		return node;
	}
	
	public T maximum() {
		if(this.root == null) return null;
		return maximum(this.root).key;
	}
	
	
	private Node predecessor(Node node) {
		if(node.left != null) return maximum(node.left);
		Node p = node.parent;
		while(p != null && node == p.left) {
			node = p;
			p = p.parent;
		}
		return p;
	}
	
	public T predecessor(T key) {
		Node node = search(key, this.root);
		if(node == null) return null;
		Node preNode = predecessor(node);
		return preNode != null? preNode.key : null;
	}
	
	private void print(Node node, String spaces, char c, int level) {
		if(node == null) return;
		//System.out.printf("%s%c%s\n", spaces, c, node.key);
		System.out.println(spaces + level + "." + c + " " + node.key);
		print(node.left,  spaces + " ", 'I', level + 1);
		print(node.right, spaces + " ", 'D', level + 1);
	}
	
	public void print() {
		print(this.root, "", '#', 0);
	}
		
	private boolean isLeaf(Node node) {
		return node.left == null && node.right == null;
	}
	
	private boolean isComplete(Node node) {
		return node.left != null && node.right != null;
	}
	
	private void remove(Node node) {
//		Caso 1. El nodo es hoja
		if(isLeaf(node)) {
			Node p = node.parent;
			if(node == p.left) p.left = null;
			else p.right = null;
		}
//		Caso 2. El nodo tiene 2 hijos
		else if(isComplete(node)) {
			Node pre = predecessor(node);
			node.key = pre.key;
			remove(pre);			
		}		
//		Caso 3. El nodo tiene 1 hijo
		else {
//			Enlazar al abuelo con el nieto
			Node grand=node.parent.parent;
			grand.key=node.key;
			remove(node);
		}		
		this.size --;
	}
	
	public boolean remove(T key) {
		Node node = search(key, this.root);
		if(node == null) return false;
		remove(node);
		return true;
	}
	


	
	
	public static void main (String args[]) {
		BST<Integer> bst1 = new BST<>();
		bst1.add(5);
		bst1.add(2);	bst1.add(8);
		bst1.add(1);	bst1.add(3);
		bst1.add(6);	bst1.add(9);
		System.out.println(bst1.add(6));
		System.out.println(bst1.add(10));
		bst1.add(0);	bst1.add(4);	bst1.add(7);
		
		System.out.println(bst1.contains(5));
		System.out.println(bst1.contains(3));
		System.out.println("Mínimo: " + bst1.minimun());
		System.out.println("Máximo: " + bst1.maximum());
		System.out.println("Tamaño: " + bst1.size());
		System.out.println("Pre de 5: " + bst1.predecessor(5));
		System.out.println("Pre de 8: " + bst1.predecessor(8));
		System.out.println("Pre de 2: " + bst1.predecessor(2));
		System.out.println("Pre de 3: " + bst1.predecessor(3));
		System.out.println("Pre de 0: " + bst1.predecessor(0));
		bst1.print();
		// bst1.add("Mario");  // No debería permitirse porque bst1 admite sólo Integers
		BST<String> bst2 = new BST<>();
		bst2.add("Laura");
		bst2.add("Oscar");
		bst2.add("Christian");
		bst2.add("Jazmín");
		bst2.add("Valeria");
		bst2.add("Ana");
		bst2.add("Beto");
		bst2.add("Francisco");
		bst2.add("Cynthia");
		bst2.add("Sebastián");
		bst2.add("Pablo");
		bst2.add("Iker");
		
		System.out.println(bst2.contains("Oscar"));
		System.out.println(bst2.contains("Laura"));
		System.out.println("Mínimo: " + bst2.minimun());
		System.out.println("Máximo: " + bst2.maximum());
		System.out.println("Tamaño: " + bst2.size());
		System.out.println("Pre de Laura: " + bst2.predecessor("Laura"));
		System.out.println("Pre de Jazmín: " + bst2.predecessor("Jazmín"));
		System.out.println("Pre de Valeria: " + bst2.predecessor("Valeria"));
		System.out.println("Pre de Francisco: " + bst2.predecessor("Francisco"));
		System.out.println("Pre de Oscar: " + bst2.predecessor("Oscar"));
		System.out.println("Pre de Beto: " + bst2.predecessor("Beto"));
		System.out.println("Pre de Ana: " + bst2.predecessor("Ana"));
		bst2.print();
		bst2.remove("Laura");
		bst2.print();
		// bst2.add(9); // No debería permitirse porque bst2 admite sólo Strings
		
//		BST<JFrame> bst3 = new BST<>();		No debería permitirse porque JFrame no es Comparable
//		bst3.add(new JFrame("Ventana 1"));
		
	}

}
