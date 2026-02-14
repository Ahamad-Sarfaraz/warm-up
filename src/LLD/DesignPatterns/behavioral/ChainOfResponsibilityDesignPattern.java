package LLD.DesignPatterns.behavioral;

import java.util.HashMap;
import java.util.logging.Handler;

public class ChainOfResponsibilityDesignPattern {
    public static void main(String[] args) {
        LogHandler infoHandler = new InfoLogger();
        LogHandler debugHandler = new DebugLogger();
        infoHandler.setNextHandler(debugHandler);
        debugHandler.setNextHandler(new ErrorLogger());

        infoHandler.handleRequest(1,"message that need to logged based on level");
        infoHandler.handleRequest(2,"message that need to logged based on level");
        infoHandler.handleRequest(3,"message that need to logged based on level");
        infoHandler.handleRequest(4,"message that need to logged based on level");
    }
}


interface LogHandler{
     void handleRequest(int logLevel, String message);
     void setNextHandler(LogHandler handler);
     void writeMessages(String message);
}


class LogLevels {
    public static final int INFO = 1;
    public static final int DEBUG = 2;
    public static final int ERROR = 3;
}

class InfoLogger implements LogHandler{

    private LogHandler logHandler;

    @Override
    public void handleRequest(int logLevel, String message) {


        if(logLevel > 3) throw new RuntimeException(STR."Invalid log level :\{logLevel}");


        if(logLevel == LogLevels.INFO){
            writeMessages(message);
        }
        else{
            System.out.println("INFO: can't handle, passing it to DEBUG handler");
            this.logHandler.handleRequest(logLevel,message);
        }
    }

    @Override
    public void setNextHandler(LogHandler logHandler) {
        this.logHandler = logHandler;
    }

    @Override
    public void writeMessages(String message) {
        System.out.println(STR."INFO : \{message}");
    }
}

class DebugLogger implements LogHandler{

    private LogHandler logHandler;

    @Override
    public void handleRequest(int logLevel, String message) {
        if(logLevel == LogLevels.DEBUG){
            writeMessages(message);
        }else{
            System.out.println("DEBUG: Can't handle, passing it to ERROR handler");
            this.logHandler.handleRequest(logLevel,message);
        }
    }

    @Override
    public void setNextHandler(LogHandler logHandler) {
        this.logHandler = logHandler;

    }

    @Override
    public void writeMessages(String message) {
        System.out.println(STR."DEBUG : \{message}");
    }
}

class ErrorLogger implements LogHandler{

    private LogHandler logHandler;

    @Override
    public void handleRequest(int logLevel, String message) {
        if(logLevel == LogLevels.ERROR){
            writeMessages(message);
        }else{
            System.out.println("ERROR: can't handle, passing it to next handler");
            this.logHandler.handleRequest(logLevel,message);
        }
    }

    @Override
    public void setNextHandler(LogHandler logHandler) {
        this.logHandler = logHandler;

    }

    @Override
    public void writeMessages(String message) {
        System.out.println(STR."ERROR: \{message}");
    }
}
