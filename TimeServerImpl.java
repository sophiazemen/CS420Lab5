import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class TimeServerImpl extends UnicastRemoteObject implements TimeServer {
    private long referenceClock;
    private List<Process> registeredProcesses;

    protected TimeServerImpl() throws RemoteException {
        super();
        this.referenceClock = System.currentTimeMillis(); // Initialize with system time
        this.registeredProcesses = new ArrayList<>();
    }

    @Override
    public long getTime() throws RemoteException {
        return System.currentTimeMillis();
    }

    @Override
    public void register(Process process) throws RemoteException {
        registeredProcesses.add(process);
        System.out.println("Registered process: " + process);
    }
}
