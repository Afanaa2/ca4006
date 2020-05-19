package ca4006;
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

public class Main{
    private static final Logger log = Logger.getLogger("ca4006");
    private static ConcurrentHashMap<String,AircraftQueue> queues = new ConcurrentHashMap<>();
    private static boolean running ;
    public static void productionLine(ConcurrentHashMap<String,AircraftQueue> queues){
        while (queues.get("0").size() != 0){
            Aircraft aircraft = queues.get("0").get() ;
            String queueName = aircraft.getTopOfQueue();
            queues.get(queueName).add(aircraft);
            log.info("added aircraft " + aircraft.getAircraftId() +  " to queue "  + queueName) ;
            try{
            Thread.sleep(1000);
            queues.get("0").remove(aircraft);
        }
            catch(InterruptedException e){
            }

        }
    }
    public static void main(String[] args){
        AircraftQueue aircraftQueue = new AircraftQueue() ;
        AircraftGenerator AircraftGenerator = new AircraftGenerator(aircraftQueue);
        Rescources rescource = new Rescources();
        queues.put("0",aircraftQueue);
        String[] tasks = {"part_A","part_B","part_C","part_D","part_E"};
        for(String s : tasks){
            queues.put(s,new AircraftQueue());
        }

        running = true;
        Thread t1 = new Thread(new Runnable() {
    @Override
    public void run() {
        while(running){
        productionLine(queues);
        running = !(queues.get("0").size() == 0 && queues.get("part_A").size() == 0
        && queues.get("part_B").size() == 0
        && queues.get("part_C").size() == 0
        && queues.get("part_D").size() == 0
        && queues.get("part_E").size() == 0
        );
    }
    try{
            Thread.sleep(1000);
        }
            catch(InterruptedException e){
        }

            log.info("finished running");
            System.exit(0);
        }
        });
        t1.start();
        Runnable robot_1 = new Robot(rescource,queues,"part_A");
        Thread robot = new Thread(robot_1);
        robot.start();
        Runnable robot_2 = new Robot(rescource,queues,"part_B");
        Thread robot2 = new Thread(robot_2);
        robot2.start();
        Runnable robot_3 = new Robot(rescource,queues,"part_C");
        Thread robot3 = new Thread(robot_3);
        robot3.start();
        Runnable robot_4 = new Robot(rescource,queues,"part_D");
        Thread robot4 = new Thread(robot_4);
        robot4.start();
        Runnable robot_5 = new Robot(rescource,queues,"part_E");
        Thread robot5 = new Thread(robot_5);
        robot5.start();

        Runnable RRobot_1 = new RRobot(rescource,"part_A");
        Thread RRobot = new Thread(RRobot_1);
        RRobot.start();
        Runnable RRobot_2 = new RRobot(rescource,"part_B");
        Thread RRobot2 = new Thread(RRobot_2);
        RRobot2.start();
        Runnable RRobot_3 = new RRobot(rescource,"part_C");
        Thread RRobot3 = new Thread(RRobot_3);
        RRobot3.start();
        Runnable RRobot_4 = new RRobot(rescource,"part_D");
        Thread RRobot4 = new Thread(RRobot_4);
        RRobot4.start();
        Runnable RRobot_5 = new RRobot(rescource,"part_E");
        Thread RRobot5 = new Thread(RRobot_5);
        RRobot5.start();

    }


}
