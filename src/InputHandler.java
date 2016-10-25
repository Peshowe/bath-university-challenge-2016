import java.util.Scanner;

public class InputHandler {
	
	Scanner scanner;
	
	public InputHandler(){
		scanner = new Scanner(System.in);
	}
	
	public int readMenuChoise(){
		String choise = scanner.nextLine();
		
		if(choise.equals("1")){
			return 1;
		}else if (choise.equals("2")){
			return 2;
		}else if (choise.equals("3")){
			return 3;
		}else{
			System.out.println("Invalid input");
			return readMenuChoise();
		}
		
	}
	
	public String inputURL (){
		System.out.println("Input URL of a website");
		return scanner.nextLine();
	}
	
	public int chooseEdit (){
		String answer = scanner.nextLine();
		if(answer.equals("title")){
			return 1;
		}else if(answer.equals("description")){
			return 2;
		}else if(answer.equals("keywords")){
			return 3;
		}else{
			System.out.println("Invalid input");
			return chooseEdit();
		}
	}
	
	public String getNewValue (){
		System.out.println("Input the new value of the element");
		return scanner.nextLine();
	}
}
