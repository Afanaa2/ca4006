package ca4006;
import java.util.*;
import java.lang.*;
import java.util.logging.*;
import java.util.LinkedList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

class AircraftGenerator {
    private final Logger log = Logger.getLogger("ca4006");
    private AircraftQueue aircraftQueue;
    public AircraftGenerator(AircraftQueue aircraftQueue){
        this.aircraftQueue = aircraftQueue;
        int i =0;
            while(i <= 50){
                Random random = new Random();
                int id = random.nextInt(50) ;
                long arrivalTime = System.currentTimeMillis();
                Queue<String> workPlan = randomWorkPlan();
                Aircraft aircraft = new Aircraft(id , arrivalTime, "low" ,workPlan );
                aircraftQueue.add(aircraft);
                log.info("added aircraft " + aircraft.getAircraftId() + "to queue "  + "Main") ;
                i ++;

        }
        }

        private Queue<String> randomWorkPlan(){
            String[] parts = {"part_A","part_B","part_C","part_D","part_E",""};
            Queue<String> workPlan = new LinkedList<String>();
            Random random = new Random();
            for(int i=0; i <=  5; i++){
                int j = random.nextInt(6);
                if(parts[j] != ""){
                    workPlan.add(parts[j]);
                }

        }
        return workPlan ;
        }

}
