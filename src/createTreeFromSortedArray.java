public class createTreeFromSortedArray {
	//nodos 
	private static class TreeNode{
		int key;
		TreeNode left=null, right=null;
		
		public TreeNode(int key) {
			this.key=key;
		}
	}
	
	//esta es la que se llama en el main
	  public static TreeNode createTreeFromSortedArray(int array[]) {
		  return createBST(array, 0, array.length-1);  
	  }
	  
	 private static TreeNode createBST(int[] array, int start, int end) {
		 if(array== null || array.length==0 || start>end) {
			 return null;
		 }
		 
		 //el numero que se encuentre a la mitad debe de ser la raiz del arbol
		 //cada vez que se vuelva a entrar
		 //se va generando nuevas "mini" roots, debiod a que se va partiendo el arreglo
		 int mp=(start+end)/2;
		 //System.out.println(array[mp]);
		 TreeNode root= new TreeNode(array[mp]);
		 //System.out.println(root.key);
		 root.left=(createBST(array, start, mp-1));
		 //System.out.println(root.key);
		 root.right=(createBST(array, mp+1, end));
		 return root;
	 }
	  
	
	 private static void printTreeFromSortedArray(TreeNode node, String spaces, char c, int level) {
		 if(node==null) return;
		 System.out.println(spaces+level+"."+c+" "+node.key);
		 printTreeFromSortedArray(node.left,spaces+" ",'I',level+1);
		 printTreeFromSortedArray(node.right,spaces+" ",'D',level+1);

	 }
	 
	 public static void printTreeFromSortedArray(TreeNode node) {
		 printTreeFromSortedArray(node,"",'#',0);
		 
	 }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array1 = { 1, 2, 3, 4, 5, 6, 7 };
		TreeNode tree1 = createTreeFromSortedArray(array1);
		
		printTreeFromSortedArray(tree1);
		System.out.println("***********");
		int[] array2= {2,3,4,5,7,8,9};
		TreeNode tree2=createTreeFromSortedArray(array2);
		printTreeFromSortedArray(tree2);
	}

}
