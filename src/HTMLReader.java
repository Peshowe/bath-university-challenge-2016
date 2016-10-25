import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class HTMLReader {
	
	private StringBuilder content = new StringBuilder();
	
	public String getContent (String theUrl) throws Exception{
		
		
			URL url = new URL(theUrl);
			
			URLConnection urlConnection = url.openConnection();
			
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
			
			String line;
			
			while( (line = bufferedReader.readLine()) !=null){
				content.append(line + "\n");
			}
			bufferedReader.close();
			
		
		return content.toString();
	}
	
	public String editPage(String element){
		int startIndex;
		int endIndex = -1;
		int temp = -1;
		if(element.equals("title")){
			startIndex = content.toString().indexOf("<" + element + ">") + element.length()+2;
			endIndex = content.toString().indexOf("</" + element + ">") + element.length() +3;
		}else{
			
			startIndex = content.toString().indexOf("<" + element + "/>") + element.length()+3;
			temp = content.toString().substring(startIndex - element.length()-3, startIndex).indexOf("content");
		}
		
		String oldTitle;
		if(endIndex>0){
			oldTitle = content.toString().substring(startIndex, endIndex);
		}else{
			oldTitle = content.toString().substring(temp, startIndex - 4);
		}
		
		
		return oldTitle;
	}
	
}
