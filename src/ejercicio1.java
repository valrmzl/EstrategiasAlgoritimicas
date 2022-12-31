import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ejercicio1 {
	
	public static void facebook(int n, String...word) {
		
		int word_case=0;
	
		for(String w:word) {
			word_case++;
			
			
			//System.out.println(w);
			List<Character> list= new ArrayList<>();
			Stack<Character> stack = new Stack<>();
		
			stack.push('k'); stack.push('o'); stack.push('o');
			stack.push('b'); stack.push('e'); stack.push('c');
			stack.push('a'); stack.push('f');
			char c=0;
			
			
			
	
			for(int i=0;i<w.length();i++) {
				c=w.charAt(i);
				if(c==stack.peek() && (!stack.isEmpty())) {
					stack.pop();
				}
				/*
				if(c=='f'|| c=='a'||c=='c'|| c=='e'||
				   c=='b'||c=='o'||c=='k') {
					list.add(c);	
				}*/
			}
			if(stack.isEmpty()) {
				System.out.printf("CASE #"+word_case+" YES\n");
			}
			else {
				System.out.printf("CASE #"+word_case+" NO\n");
				
			}
			
			/*
			
			if(        list.get(0)=='f' &&
					   list.get(1)=='a' &&
					   list.get(2)=='c' &&
					   list.get(3)=='e' &&
					   list.get(4)=='b' &&
					   list.get(5)=='o' &&
					   list.get(6)=='o' &&
					   list.get(7)=='k') {
						System.out.printf("CASE #"+word_case+" YES\n");
			}else
					{
						System.out.printf("CASE #"+word_case+" NO\n");
					}*/
			
		}
		
	}

	public static void main(String[] args) {
		
		facebook(4,"fsacsebsooks","facpebppok","facetsofexcitinginformationaboutoklahoma","thisstringcontainsbooksbutnofaces");
		/*
		String str="";
		
		String s1="fsacsebsooks";
		List<Character> list= new ArrayList<>();
		char c = 0;
		for(int i=0;i<s1.length();i++) {
			c=s1.charAt(i);
			if(c=='f'|| c=='a'||c=='c'|| c=='e'||
			   c=='b'||c=='o'||c=='k') {
				//System.out.println(c);
				list.add(c);
				
			}
		}
		
		if(list.get(0)=='f' &&
				   list.get(1)=='a' &&
				   list.get(2)=='c' &&
				   list.get(3)=='e' &&
				   list.get(4)=='b' &&
				   list.get(5)=='o' &&
				   list.get(6)=='o' &&
				   list.get(7)=='k') {
					System.out.println("YES");
		}else
				{
					System.out.println("NO");
				}*/
		
		

	}

}
