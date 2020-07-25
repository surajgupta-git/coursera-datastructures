package week1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

class Bracket {
    Bracket(char type, int position) {
        this.type = type;
        this.position = position;
    }
    boolean Match(char c) {
        if (this.type == '[' && c == ']')
            return true;
        if (this.type == '{' && c == '}')
            return true;
        if (this.type == '(' && c == ')')
            return true;
        return false;
    }
    char type;
    int position;
}

class check_brackets {
    public static void main(String[] args) throws IOException {
        InputStreamReader input_stream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input_stream);
        String text = reader.readLine();
        boolean flag=true;
        Stack<Bracket> opening_brackets_stack = new Stack<Bracket>();
        for (int position = 0; position < text.length(); ++position) {
            char next = text.charAt(position);
            if (next == '(' || next == '[' || next == '{') {
                // Process opening bracket, write your code here
            	Bracket ob= new Bracket(next,position);
            	opening_brackets_stack.push(ob);
            }
            if (next == ')' || next == ']' || next == '}') {
            	if(opening_brackets_stack.isEmpty()){
            		flag=false;
            		System.out.println(position+1);
            		return;
            	}
            	if(opening_brackets_stack.peek().Match(next)){
                // Process closing bracket, write your code here
            	Bracket cb=opening_brackets_stack.pop();
            	if(cb.Match(next)==false){
            		flag=false;
            		System.out.println(cb.position+1);
            		return;
            	}
            	if(cb.Match(next)==true){
            		flag=true;
            	}
                }
            	else{
            		flag=false;
            		System.out.println(position+1);
            		return;
            	}
            } }  
        // Printing answer, write your code here
        if(! opening_brackets_stack.isEmpty())
    	{
        	flag=false;
    		System.out.println(opening_brackets_stack.peek().position+1);
    	}
        if(flag==true)
        {System.out.println("Success");
    }
    }
}

