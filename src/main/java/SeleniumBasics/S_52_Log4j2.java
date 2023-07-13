// Go to Maven repository
	// Search for Apache Log4j Core: Log4j - Core
		// https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-core
		// Select a stable version
			// Copy the maven dependency into Projest's pom.xml file
	// Search for Apache Log4j API: Log4j - API
		// https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-api
		// Select a stable version
			// Copy the maven dependency into Projest's pom.xml file
// Create log4j2 properties file OR log4j2 xml file
	// log4j2 properties/ xml is a loj4j2 configuration file which store all runtime configuration used by log4j2
	// Project: Right click -> New -> File
		// Name it: log4j2.xml [Name should be exactly the same]
			// Add following code block to xml file
				/*
						<?xml version="1.0" encoding="UTF-8"?>
						<Configuration status="WARN" strict="true">
							<Appenders>
								<Appender type="Console" name="STDOUT">
									<Layout type="PatternLayout"
										pattern="%d{HH:mm:ss.SSS} [%t]%-5level %logger{36} - %msg%n" />
								</Appender>
						
								<Appender type="File" name="file" fileName="Log4j2_Logs.log">
									<Layout type="PatternLayout"
										pattern="%d{HH:mm:ss.SSS} [%t]%-5level %logger{36} - %msg%n" />
								</Appender>
							</Appenders>
						
						
							<Loggers>
								<Root level="all">
									<AppenderRef ref="file" />
								</Root>
							</Loggers>
						</Configuration>
				 */
// Create a resource folder if not already present
	// Right click project -> New -> Source Folder
		// Name it: src/test/resources
		// This source folder will contain all the external files used in the project
			// Example: xml files, json files, properties, excel sheets etc
// Move the xml file to resource folder

// Benefits
	// Creates a log file and logs all the application behavior during execution

// reference: https://www.youtube.com/watch?v=ThVgu0dmhNY

package SeleniumBasics;

import org.apache.logging.log4j.*;

public class S_52_Log4j2
{
	public static void main(String[] args)
	{
		Logger logger = LogManager.getLogger(S_52_Log4j2.class);
		
		logger.debug("Sample DEBUG message");
		logger.error("Sample ERROR message");
		logger.info("Sample INFO message");
		logger.warn("Sample WARN message");
	}
}
