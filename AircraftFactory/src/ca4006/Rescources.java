package ca4006;
import java.util.logging.*;
import java.io.*;
import java.util.logging.*;
import java.util.Map;
import java.util.Queue;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.lang.*;

public class Rescources {
    private final Logger log = Logger.getLogger("ca4006");
    private  ConcurrentHashMap<String,Queue<String>> rescources = new ConcurrentHashMap<>();
    public Rescources(){
        String[] parts = {"part_A","part_B","part_C","part_D","part_E"};
        for(String s : parts){
            Queue<String> tmp = new LinkedList<>();
            for(int i = 0 ; i < 10; i++  ){
                tmp.add(s);
            }
            rescources.put(s,tmp);
        }
        log.info("rescources created");

    }
    public synchronized void add(String part) {
		this.rescources.get(part).add(part);
		log.info("added rescource " + part);
	}

    // remove Aircraft
	public synchronized String remove(String part) {
		log.info("used " + part);
        return this.rescources.get(part).remove();
	}
    public synchronized int size(String part) {
        return this.rescources.get(part).size();
    }


}
