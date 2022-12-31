import java.util.Arrays;


public class DigitalTree {
	
	int bits;
	int tmpBits;
	int corrida=0;
	private class Node{
		Node parent,left,right = null;
		int key;
		public Node(int key,Node parent) {
			this.key=key;
		}
	}
	
	Node root;
	boolean added=false;
	
	
	public DigitalTree(int bits) {
		this.bits=bits;
		this.root=null;
	}
	
	
	private Node addRecursive(Node current, int key,boolean added) {
		if(current==null) {
			added=true;
			return new Node(key,null);
			
			
		}
		if(key<current.key) {
			current.left=addRecursive(current.left,key,added);
			added=true;
		}else if(key>current.key) {
			current.right=addRecursive(current.right,key,added);
			added=true;
		}else {
			return current;
		}
		return current;
		
	}
	public boolean add(int key) {
		Node current=this.root;
		tmpBits=bits;
		 boolean added=false;
	
		root=addRecursive(root,key,added);
		return added;
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


	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DigitalTree dt= new DigitalTree(4);
		for (int i=0;i<16;i++) dt.add(i);
		
		dt.print();
		//System.out.println(dt.add(1));
		//System.out.println(dt.add(5));
		//System.out.println(dt.root);
		
		

	}

}
