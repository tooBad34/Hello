import java.util.Scanner;

public class test{
	
	public static void main (String[] arg){
		
		MyStack MyStack = new MyStack();
		
		Scanner input = new Scanner(System.in);
		
		
		
		
		System.out.println("Enter five Strings");
		
		int times = 1;
		while(times <= 5){
		
			MyStack.push(input.next());
			
			times++;
		}
		
		
		
		
		System.out.println()
		System.out.println("print:")
		
		
		
		while (!MyStack.isEmpty()) {
			
			System.out.println(MyStack.pop());
		}
		
	}
}


class MyStack  extends java.util.ArrayList<Object>{
	
	
	public boolean isEmpty(){
		return super.isEmpty();
	}
	
	public int getSize(){
		return super.size();
	}
	
	public Object peek(){
		return super.get(getSize() - 1);
	}
	
	public Object pop(){
		Object o = super.get(getSize() - 1);
		super.remove(getSize() - 1);
		return o;
	}
	
	public void push(Object o){
		super.add(o);
	}
	
	public String toString(){
		return "stack" + super.toString();
	}
}