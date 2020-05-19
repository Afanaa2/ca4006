package ca4006;
import java.lang.*;
import java.util.logging.*;
import java.util.logging.*;
import java.io.*;
import java.util.logging.*;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.lang.*;
class RRobot implements Runnable {
    private String part;
    private final Logger log = Logger.getLogger("ca4006");
    private Rescources rescource;
    public RRobot(Rescources rescource,String part){
        this.part = part ;
        this.rescource = rescource ;

    }
    public void run(){
        log.info("Starting RRobot " + part);
        while(true){
            while( rescource.size(part) < 10){
            try{
            Thread.sleep(1000);}
            catch(InterruptedException e){
                }
                rescource.add(part);
                log.info("created and added to rescources " + part);

            }
        }
    }
}
