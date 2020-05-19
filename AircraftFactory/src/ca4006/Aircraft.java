package ca4006;
import java.util.ArrayList;
import java.lang.*;
import java.util.logging.*;
import java.util.*;



public class Aircraft
{
    private final Logger log = Logger.getLogger("ca4006");
    private final int id; // uniqe id
    private final double arrivalTime; // arrivalTime of Aircraft
    //private final int arrivalFloor ; //TODO
    private String priority ; // priority in the task manager
    private  long startTime; // startTime of work on Aircraft
    private Queue<String> workPlan ; // list of tasks to accomplish
    private ArrayList<String> tasksCompleted; //list of acomplished tasks
    private long runTime;
    private String task = "No task";
    private Object lock1 = new Object() ;

    public Aircraft(int uid , long arrivalTime, String priority ,Queue<String> workPlan )
    {
        this.id = uid ;
        this.arrivalTime = arrivalTime;
        this.priority = priority;
        this.workPlan = workPlan ;
        log.info("Created Aircraft " + uid );
        report();
    }
    public int getAircraftId(){
        return this.id ;
    }

    public double getArrivalTime()
    {
        return arrivalTime;
    }

    public double getStartTime()
    {
        return this.startTime;
    }

    public Queue<String> getWorkPlan()
    {
        return this.workPlan;
    }

    public String getTopOfQueue(){
        return this.workPlan.peek();
    }

    public void remove(){
        this.workPlan.remove();
    }

    public void addCompletedTask(String task)
    {
        synchronized (lock1){
            tasksCompleted.add(task );
        }
    }

    public String report()
    {
        String msg = String.format("Aircraft " + id +" Currently has [%d] tasks left.",
               this.workPlan.size());
        log.info(msg);
        return msg;
    }
}
