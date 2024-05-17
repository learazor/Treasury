package org.example.logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Logger;


public final class LoggerSingleton {
    private static final LoggerSingleton instance = new LoggerSingleton();
    public String logger = "logger";
    static final Logger log = Logger.getLogger("org.example.logger");
    private static final String ENV = System.getProperty("user.dir");
    private static File logFile;

    public static LoggerSingleton getInstance() {
        return instance;
    }

    public static LoggerSingleton getInstance(String withName) {
        instance.logger = withName;
        instance.createLogFile();
        return instance;
    }

    public void createLogFile() {
        File logsFolder = new File(ENV + '/' + "logs");
        if (!logsFolder.exists()) {
            System.err.println("INFO: Creating new logs directory in " + ENV);
            logsFolder.mkdir();

        }

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();

        //Create the name of the file from the path and current time
        logger = logger + '-' + dateFormat.format(cal.getTime()) + ".log";
        LoggerSingleton.logFile = new File(logsFolder.getName(), logger);
/*        try {
            if (logFile.createNewFile()) {
                //New file made
                System.out.println("INFO: Creating new log file");
            }
        } catch (IOException e) {
            System.out.println("ERROR: Cannot create log file");
            System.exit(1);
        }*/
    }

    private LoggerSingleton() {
        if (instance != null) {
            throw new IllegalStateException("Cannot instantiate a new singleton instance of log");
        }
        this.createLogFile();
    }

    public static void log(String message) {
        try {
            log.info(message);
            FileWriter out = new FileWriter(LoggerSingleton.logFile, true);
            out.write(message.toCharArray());
            out.close();
        } catch (IOException e) {
            System.err.println("ERROR: Could not write to log file");
        }
    }

    public static void main(String[] args) {

        LoggerSingleton.log("This is a message");
    }

}