import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Process extends Remote {
    void synchronize() throws RemoteException;
}
