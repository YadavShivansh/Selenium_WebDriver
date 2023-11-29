package googleSearch.mini;

import org.openqa.selenium.WebElement;

public class printCount{

	public static String count(WebElement wb) {
		
	
		String result = wb.getText();
		String res[] =result.split(" ");
		
		
		return res[1];

	}

}
