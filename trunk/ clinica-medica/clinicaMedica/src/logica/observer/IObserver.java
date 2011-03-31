package logica.observer;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IObserver extends Remote
{
    public void update() throws RemoteException;
}