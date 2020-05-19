package ca4006;

import java.util.List;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.Queue;
import java.util.ArrayList;



public interface FileInterface extends Remote
{
    public String printFile()  throws RemoteException, Exception;
    public  ArrayList<String> chunkFile(char start , char fin) throws RemoteException, Exception;
    public String getMeta() throws RemoteException , Exception;
    public String getFile() throws RemoteException , Exception;
    public String getChunkName() throws RemoteException , Exception;
    public void addQueue(char start, char fin) throws RemoteException ,  Exception ;
    public Queue<String> getQueue() throws RemoteException ,  Exception ;


}
