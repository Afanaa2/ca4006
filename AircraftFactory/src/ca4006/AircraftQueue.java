package ca4006;

import java.util.logging.*;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.*;

public class AircraftQueue
{
	private Queue<Aircraft> aircraftQueue; //queue of aircrafts
    private final Logger log = Logger.getLogger("ca4006");
    public AircraftQueue()
    {
        aircraftQueue = new LinkedList<>();
    }
    public synchronized void add(Aircraft aircraft) {
		aircraftQueue.add(aircraft);
	}

    // remove Aircraft
	public synchronized void remove(Aircraft aircraft) {
		aircraftQueue.remove();
	}
	public synchronized Aircraft get() {
		return aircraftQueue.peek();
	}



	public boolean isEmpty() {
		return size() == 0;
	}

	public int size() {
		return aircraftQueue.size();
	}

}
