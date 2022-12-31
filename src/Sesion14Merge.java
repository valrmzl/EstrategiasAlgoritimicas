import java.util.Arrays;

public class Sesion14Merge {
	
	public static int[] merge(int [] left, int [] right) {
		int [] merge= new int[left.length+right.length];
		for(int m=0,l=0,r=0;m<merge.length;m++) {
			if(l>=left.length) merge[m]=right[r++];
			else if (r>=right.length) merge[m]=left[l++];
			else if(left[l]<right[r])  merge[m]=left[l++]; //ya que la uso la sumo
			else merge[m]=right[r++];
		}
		return merge;
	}
	
	
	public static int[] mergeSort1(int[] arry) {
		System.out.println(Arrays.toString(arry));
		//caso base, no hay recursion
		if(arry.length<=1) return arry;
		//punnto medio
		int mp=arry.length/2;
		int [] left = Arrays.copyOf(arry,mp); //por lo regular el ultimo no se incluye
		int [] right = Arrays.copyOfRange(arry, mp,arry.length);
		//conquista
		left=mergeSort1(left);
		right=mergeSort1(right);
		return merge(left,right);
	}

	public static void main(String[] args) {
		int [] arry= {10,2,4,3,20,7,9,1};
		System.out.println(Arrays.toString(mergeSort1(arry)));

	}

}
