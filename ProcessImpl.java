import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ProcessImpl extends UnicastRemoteObject implements Process {
    private long localClock;
    private TimeServer timeServer;

    protected ProcessImpl(String timeServerURL) throws RemoteException {
        super();
        this.localClock = System.currentTimeMillis();
        try {
            this.timeServer = (TimeServer) Naming.lookup(timeServerURL);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void synchronize() throws RemoteException {
        long serverTime = timeServer.getTime();
        long offset = serverTime - localClock;
        localClock += offset;

        System.out.println("Synchronized local clock. Offset: " + offset + "ms. New local time: " + localClock);
    }

    public static void main(String[] args) {
        try {
            ProcessImpl process = new ProcessImpl("//localhost/TimeServer");
            process.synchronize();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
