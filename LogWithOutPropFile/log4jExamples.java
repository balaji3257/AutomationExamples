import java.io.IOException;

import org.apache.log4j.Appender;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.RollingFileAppender;

public class log4jExamples {

	
	public static void main(String[] args) {
	    //calling initLogger() method to initialize properties. 
	    //You need to call this method only once.
		log4jExamples.initLogger(); 
	    
	    //Getting the already registered logger 'myFirstLog'
	    Logger accessLog = Logger.getLogger(log4jExamples.class);
	  
	    accessLog.info("This is my first info message.");
	    accessLog.warn("This is my first warn message.");
	    accessLog.error("This is my first error message.");
	    accessLog.fatal("This is my first fatal message.");
	  }
	
	public static void initLogger() {
	      PatternLayout layout = new PatternLayout("%-4r [%t] %-5p %c %x - %m%n");
	      Appender consoleAppender = new ConsoleAppender(layout);
	      Logger.getRootLogger().addAppender(consoleAppender);
	}
}
