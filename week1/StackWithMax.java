package week1;
import java.util.*;
import java.io.*;

public class StackWithMax {
    class FastScanner {
        StringTokenizer tok = new StringTokenizer("");
        BufferedReader in;
        FastScanner() {
            in = new BufferedReader(new InputStreamReader(System.in));
        }
        String next() throws IOException {
            while (!tok.hasMoreElements())
                tok = new StringTokenizer(in.readLine());
            return tok.nextToken();
        }
        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
    
    public void solve() throws IOException {
        FastScanner scanner = new FastScanner();
        int queries = scanner.nextInt();
        Stack<Integer> stack = new Stack<Integer>();
        int max=0;
        Stack<Integer> maxstack = new Stack<Integer>();
        for (int qi = 0; qi < queries; ++qi) {
            String operation = scanner.next();
            if ("push".equals(operation)) {
                int value = scanner.nextInt();
	                if(value>=max)
	                {
	                	max=value;
	                    maxstack.push(value);
	                } 
                stack.push(value);
            } else if ("pop".equals(operation)) {
	            	if((int)(stack.peek())==(int) maxstack.peek())
	            	{
	            		maxstack.pop();
	            		max=maxstack.peek();
	            	}
                stack.pop();
            } else if ("max".equals(operation)) {
            	System.out.println(maxstack.peek());
            }
        }
    }
    
    static public void main(String[] args) throws IOException {
        new StackWithMax().solve();
    }
}
