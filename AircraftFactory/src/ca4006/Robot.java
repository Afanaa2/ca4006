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
class Robot implements Runnable {
    private String addPart;
    private final Logger log = Logger.getLogger("ca4006");
    private Aircraft aircraft ;
    private AircraftQueue aircraftQueue;
    private Rescources rescource;
    private ConcurrentHashMap<String,AircraftQueue> queues;
    public Robot(Rescources rescource, ConcurrentHashMap<String,AircraftQueue> queues , String part){
        this.addPart = part ;
        this.queues = queues ;
        this.aircraftQueue = queues.get(addPart) ;
        this.rescource = rescource ;

    }
    public void run(){
        log.info("Starting robot " + addPart);
        while(true){
            try{
            Thread.sleep(1000);}
            catch(InterruptedException e){
            }
            while(aircraftQueue.size() > 0){
            try{
            Thread.sleep(1000);}
            catch(InterruptedException e){

            }
            Aircraft aircraft = aircraftQueue.get();
            aircraft.report();
            if (aircraft.getTopOfQueue() == addPart){
                rescource.remove(addPart);
                aircraft.remove();
                log.info("Added to aircraft " + aircraft.getAircraftId() + " " + addPart);
            }
            if(aircraft.getWorkPlan().size() == 0){
                log.info("aircraft + " + aircraft.getAircraftId()+" has been succesfully built");
                this.aircraftQueue.remove(aircraft);
            }
            else{
                queues.get("0").add(aircraft);
                this.aircraftQueue.remove(aircraft);
                log.info("aircraft "+ aircraft.getAircraftId()+" back in main queue");
            }
        }
        }
    }



}
