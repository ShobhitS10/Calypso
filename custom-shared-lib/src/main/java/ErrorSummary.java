import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

import java.io.FileWriter;

public class ErrorSummary {

	public static void main(String[] args) {
		try (InputStream input = ErrorSummary.class.getClassLoader().getResourceAsStream("config.properties")) {

            Properties prop = new Properties();

            // load a properties file
            prop.load(input);

            String logFile = prop.getProperty("LOG_FILE");
            String errorString = prop.getProperty("ERROR_STRING");
            String errorSummary = prop.getProperty("LOG_SUMMARY_FILE");
            
            File file = new File(logFile);
            ArrayList<String> allErrors = new ArrayList<String>();

            try {
                Scanner scanner = new Scanner(file);

                //now read the file line by line...
                int lineNum = 0;
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    lineNum++;
                    if(line.contains(errorString)) {
                    	allErrors.add("Error at line no. " + lineNum + "\n");
                    	allErrors.add(line+"\n");
                    }
                }
                
                scanner.close();
            } catch(FileNotFoundException e) { 
            	e.printStackTrace();
            }
            
            String errors = allErrors.toString();
            
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");  
            LocalDateTime now = LocalDateTime.now();
            
            File errorLogSum = new File(errorSummary+dtf.format(now)+".log");
            try { 
            	  
                // Open given file in append mode. 
                BufferedWriter out = new BufferedWriter( 
                       new FileWriter(errorLogSum, true)); 
                out.write(errors);
                out.close(); 
            } 
            catch (IOException e) { 
                System.out.println("exception occoured" + e); 
            }
            

        } catch (IOException ex) {
            ex.printStackTrace();
        }
	}

}
