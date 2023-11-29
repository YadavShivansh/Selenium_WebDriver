package googleSearch.mini;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.utils.excelUtils;

public class write {
    public static  int rowcount=1;
	public static void setData(List<WebElement> lst , String path,String file) throws IOException {
		// TODO Auto-generated method stub
		
		
		for (int i = 0 ; i <lst.size(); i++ )
		{
			if(lst.get(i).getText().equals(""))
				excelUtils.setCellData(path,file,rowcount,i+1,"Element Text Not Available");
			else
				excelUtils.setCellData(path,file,rowcount,i+1,lst.get(i).getText());
			
		}
		
		rowcount++;
		
		

	}

}
