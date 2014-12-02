import java.util.Stack;


public class Evaluator {
	
	@SuppressWarnings("rawtypes")
	public static Stack p = new Stack();
	//Gets RPN
	//returns int
	static int evaluate(String s) {

		//final
		int answer = 0;
		
		//Runs through string
		//If number adds to the stack
		//If factor takes numbers from the stack
		for (int x = 0; x < s.length(); ++x) {
			//Pulls the first segment of the substring
			String r = s.substring(x,x+1);
			if (r.equals("+"))
				add();
			else if (r.equals("-"))
				sub();
			else if (r.equals("*"))
				mult();
			else if (r.equals("/"))
				divi();
			else if (r.equals(" ")) //does nothing
				System.out.print("");
			else
			//adds to stack if neither of these
				p.push(r);		
		}
		//System.out.println(p.peek());
		answer = Integer.parseInt((String) p.pop());
	return answer;
	}
	public static void add() {
		int one = Integer.parseInt((String) p.pop());
		int two = Integer.parseInt((String) p.pop());
		
		String s = Integer.toString(one + two);
		
		p.push(s);		
	}
	public static void sub() {
		int one = Integer.parseInt((String) p.pop());
		int two = Integer.parseInt((String) p.pop());
		
		String s = Integer.toString(two - one);
		
		p.push(s);	
	}
	public static void mult() {
		int one = Integer.parseInt((String) p.pop());
		int two = Integer.parseInt((String) p.pop());
		
		String s = Integer.toString(one * two);
		
		p.push(s);	
	}
	public static void divi() {
		int one = Integer.parseInt((String) p.pop());
		int two = Integer.parseInt((String) p.pop());
		
		String s = Integer.toString(two / one);
		
		p.push(s);	
	}
	
	public static void main(String[] args) {
		String s = "5 1 2 + 4 * + 3 -";
		
		System.out.println(evaluate(s));
	}
}
