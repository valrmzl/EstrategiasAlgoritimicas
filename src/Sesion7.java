import java.util.Stack;

public class Sesion7 {
	
	static boolean isOpeningChar(char c) {
		 return (c=='(' || c=='{' || c=='[' );	
	}
	
	
	static boolean match(char c1, char c2) {
		return (c1=='(' && c2==')') ||
				(c1=='{' && c2=='}') ||
				(c1=='[' && c2==']');
	}
	
	
	static boolean isBalanced(String expression) {
		
	      if(expression.length()%2 !=0) return false;	
		  Stack<Character> stack = new Stack<>();
		  for(int i=0; i<expression.length();i++) {
			  char c= expression.charAt(i);
			  if(isOpeningChar(c)) {
				  stack.push(c);
			  } else {
				  if(stack.isEmpty()) return false;
				  char d=stack.pop();	
				  if(!match(d,c)) return false;
				  
			  }
			  
		  }
		  
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		//este algoritmo es O de N , PORQUE PUEDE TERMIANR ANTES 
		//Y SU MEMORIA TMB ES O DE N , EN EL CASO IDEAL LA MITAD SE GUARDA EN EL STACK 
		//
		String corchetes="({[]})";
		System.out.println(corchetes);
		System.out.println(isBalanced(corchetes));
		/*
		System.out.println(isBalanced("({[]})"));
		System.out.println(isBalanced("({[])}"));
		System.out.println(isBalanced("({[]}"));
		System.out.println(isBalanced("({[]}))"));
		System.out.println(isBalanced("(){}({[]})"));
		*/

	}

}
