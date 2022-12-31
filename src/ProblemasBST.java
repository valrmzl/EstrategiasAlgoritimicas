
public class ProblemasBST {
	static class TreeNode{
		int key;
		TreeNode left=null, right=null;
		
		public TreeNode(int key) {
			this.key=key;
		}
	}
	
	static int countGreaterThan(TreeNode node, int key) {
		//(caso base
		if(node==null) return 0;
		int count= node.key > key ? 1 :0;
		System.out.println(node.key);
		if(node.key>key) 
			//viistar hijo izquierdo
			count +=countGreaterThan(node.left,key);
		return count +countGreaterThan(node.right,key);
	}
	
	
	static boolean containsOdd(TreeNode node) {
		//(caso base
		if(node==null) return false;
		System.out.println(node.key);
		if(node.key%2!=0) //soy impar ya no sigas buscando 
			return true;
		//si node.left es true ya no evalua el right
		
		return containsOdd(node.left) || containsOdd(node.right);
	}
	
	static int sumaLeafKeys(TreeNode node) {
		//caso base
		if(node==null) return 0;
		if(node.left== null && node.right==null)
			return node.key;
		return sumaLeafKeys(node.left) + sumaLeafKeys(node.right);
	}
	
	
	//cuenta el numero de rutas desde la raiz a alguna hoja
	static int countPath(TreeNode node, int key) {
		int count=0;
		if(node!=null && node.right==null && node.left==null) {
			if(node.key< key) return 1;
			 else return 0;
		}
		if(node==null) return 0;
		if(node.key< key && node.left!=null) {
			count+=countPath(node.left,key);
		}
		if(node.key < key && node.right!=null) {
			count+=countPath(node.right,key);
		}
		return count;
	}
	
		
	
	

	
	public static void main(String[] args) {
		
		TreeNode root= new TreeNode(4);
		root.left=new TreeNode(2);
		root.left.left=new TreeNode(1);
		root.left.right=new TreeNode(3);
		
		root.right=new TreeNode(6);
		root.right.left=new TreeNode(5);
		root.right.right=new TreeNode(7);
		System.out.println("CountPath de 5: "+countPath(root,5));
		System.out.println("CountPath de 3: "+countPath(root,3));
		System.out.println("CountPath de 7: "+countPath(root,7));
		/*
		TreeNode root= new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(15);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(8);
		root.right.left = new TreeNode(14);
		root.right.right = new TreeNode(16);
		root.left.left.left = new TreeNode(1);
		root.left.right.left = new TreeNode(7);
		root.right.right.right = new TreeNode(20);
		
		System.out.println(countGreaterThan(root,13));
		System.out.println("******");
		System.out.println(containsOdd(root));*/
		
	}

}
