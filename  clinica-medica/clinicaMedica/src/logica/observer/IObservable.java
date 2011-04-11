package logica.observer;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IObservable extends Remote
{
    public void addObsMenuGA (IObserver obs) throws RemoteException;
    
    public void remObsMenuGA (IObserver obs) throws RemoteException;    
 
    public void notificarMenuGA() throws RemoteException;
    
    public void addObsReservaTurno (IObserver obs) throws RemoteException;
    
    public void remObsRservaTurno (IObserver obs) throws RemoteException;    
 
    public void notificarReservaTurno() throws RemoteException;
}
