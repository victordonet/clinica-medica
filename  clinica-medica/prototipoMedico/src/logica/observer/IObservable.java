package logica.observer;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IObservable extends Remote
{
    public void addObserver (IObserver obs) throws RemoteException;
    
    public void remObserver (IObserver obs) throws RemoteException;    
 
    public void notificar() throws RemoteException;
}
