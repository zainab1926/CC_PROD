package Test;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import jxl.Sheet;
import jxl.Workbook;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.commons.lang3.StringUtils;

import au.com.bytecode.opencsv.CSVReader;


public class CommonUtils {
	static String x;

	// private final static Logger logger = Logger.getLogger(CommonUtils.class);
	private static final String CONFIG_PROPERTY_FILE_PATH = new File("src/config.properties").getAbsolutePath();
//	private static final String CONFIG_PROPERTY_FILE_PATH = ".src/config.properties";

	
	public static String currentDateFileName(String prefix) {
		DateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy-hh_mm_ss");
		String formattedTime = formatter.format(new Date());
		return (StringUtils.isEmpty(prefix) ? formattedTime : prefix
				+ formattedTime);
	}

	
	public static String readFromConfig(String input)
			throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream(CONFIG_PROPERTY_FILE_PATH));
		String returnVal = properties.getProperty(input);
		return returnVal;
	}

	
	public static String getHostOperatingSystem() {
		String osName = System.getProperty("os.name");
		// logger.info("Current Host Operating System is identified as " +
		// osName);
		return osName;
	}


	public static String getUserName() {
	     String uName = System.getProperty("user.name");
	     return uName;
	    }
	public static String getRandomString(int length) {
        final String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJLMNOPQRSTUVWXYZ";
        StringBuilder result = new StringBuilder();
        while(length > 0) {
            Random rand = new Random();
            result.append(characters.charAt(rand.nextInt(characters.length())));
            length--;
        }
        return result.toString();
                
     }
	public static String getRandomNumber(int length) {
        final String characters = "1234567890";
        StringBuilder result = new StringBuilder();
        while(length > 0) {
            Random rand = new Random();
            result.append(characters.charAt(rand.nextInt(characters.length())));
            length--;
        }
        return result.toString();
                
     }
	
		public static String read_excel(String filePath) throws Exception
		{
//			CSVReader reader = new CSVReader(new FileReader(filePath));
//			  String [] x;
//			 
//			  while ((x = reader.readNext()) != null) 
//			  {   
//			   String email_id = x[0];
//			   System.out.println(email_id);
//			   String password = x[1]; 
//			   System.out.println(password);
//			   }
//			return;
//			CSVReader csvSource;
//			     List<String[]> allLines;
//			     csvSource = new CSVReader(new FileReader(filePath));
//			     allLines = csvSource.readAll();
//			     Object[][] data = new Object[allLines.size()][];
//			     for (int lineNumber = 0; lineNumber < allLines.size(); lineNumber++)
//			         data[lineNumber] = allLines.get(lineNumber);            
//			     return;    
//			excel
//			Sheet s;
//			File src=new File(filePath);
//			  FileInputStream fis=new FileInputStream(src); 
//			  Workbook W = Workbook.getWorkbook(fis);
//			   s=W.getSheet(0); 
//			         int rowcount=s.getRows();
//			         System.out.println("Total number of row is"+rowcount+1);
//			         for(int row = 0;row <= s.getRows();row++)
//			         { 
//			        	 @SuppressWarnings("unused")
//						String Email_ID = s.getCell(0,row).getContents();
//			        	 @SuppressWarnings("unused")
//						String Password=s.getCell(1,row).getContents();
//			         }
//					return x;
			
			File src=new File(filePath);
			FileInputStream fis=new FileInputStream(src); 
			  
			  XSSFWorkbook wb= new XSSFWorkbook(fis);
			  
			  XSSFSheet sheet1=wb.getSheetAt(0); 
			 
			         int rowcount=sheet1.getLastRowNum();
			         
			         System.out.println("Total number of row is"+rowcount+1);
			 
			         for (int i=0;i<rowcount;i++)
			         { 
			          String data0=sheet1.getRow(i).getCell(0).getStringCellValue();
			            
			         System.out.println("Test Data from Excel is"+data0);
			         }
					return x;
			 
			
		}
		public static String fetchValues(String filePath)throws Exception
	     {
	     CommonUtils.read_excel(filePath);
	     return x;
	      
	     }
	
	
}
