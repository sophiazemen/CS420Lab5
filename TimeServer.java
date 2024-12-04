import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TimeServer extends Remote {
    long getTime() throws RemoteException;
    void register(Process process) throws RemoteException; // Optional
}
