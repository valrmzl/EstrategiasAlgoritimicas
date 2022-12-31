import java.util.Scanner;

public class I {
	
	public static char process(String bytes) {
		
		for(int i=0;i<bytes.length();i++) {
			if(bytes.charAt(i)=='0' || bytes.charAt(i)=='1') {
				i++;
			}else {
				return 'F';
			}
		}
		return 'S';
	}

	public static void main(String[] args) {
		
		Scanner in= new Scanner(System.in);
		String input= in.nextLine();
		String[] numbers= input.split(" ");
		if(numbers.length!=8) {
			System.out.println("F");
			
		}else {
			System.out.println(process(input));
			
		}
	
	

	}

}
