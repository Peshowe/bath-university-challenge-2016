
public class Main {

	private StringBuilder report;
	
	public Main (){
		report = new StringBuilder();
	}
	
	public void start(){
System.out.println("Select an option: \n 1. Edit a web page \n 2. Editting report \n 3. Exit application");
		
		InputHandler input = new InputHandler();
		while(1>0){
		int menuChoise = input.readMenuChoise();
		if(menuChoise == 1){
			HTMLReader reader = new HTMLReader();
			String url = " ";
			try{
				url = input.inputURL();
				reader.getContent(url);
			}catch (Exception e){
				System.out.println("Invalid URL");
			}
			System.out.println("Would you like to edit the title, description or keywords?");
			int answer = input.chooseEdit();
			if(answer == 1){
				 report.append(url + " | ");
				 report.append("title | ");
				 report.append(reader.editPage("title")+" | ");
				 report.append(input.getNewValue());
			}else if(answer == 2){
				 report.append(url + " | ");
				 report.append("description | ");
				 report.append(reader.editPage("description")+" | ");
				 report.append(input.getNewValue());
			}else if(answer == 3){
				 report.append(url + " | ");
				 report.append("keywords | ");
				 report.append(reader.editPage("keywords")+" | ");
				 report.append(input.getNewValue());
			}
			
			
		}else if (menuChoise == 2){
			System.out.println(report);
		}
		}

	}
	
	public static void main(String[] args) {
	 Main main = new Main();
	 main.start();
	}
}
