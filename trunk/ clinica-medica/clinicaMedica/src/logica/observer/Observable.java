package logica.observer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;



public class Observable extends UnicastRemoteObject implements IObservable
{
    private LinkedList colMenuGA, colReservaTurno;

    public Observable() throws RemoteException
    {
        colMenuGA = new LinkedList();
        colReservaTurno = new LinkedList();
        
    }

    public void addObsMenuGA (IObserver obs) throws RemoteException
    {
        colMenuGA.add(obs);
    }
    
    public void remObsMenuGA (IObserver obs) throws RemoteException
    {
    	colMenuGA.remove(obs);
    }

    public void notificarMenuGA() throws RemoteException
    {
        for (int i=0; i<colMenuGA.size(); i++)
        {
            IObserver obs = (IObserver) colMenuGA.get(i);
            obs.update();
        }
    }
    public void addObsReservaTurno (IObserver obs) throws RemoteException
    {
        colReservaTurno.add(obs);
    }
    
    public void remObsRservaTurno (IObserver obs) throws RemoteException
    {
    	colReservaTurno.remove(obs);
    }

    public void notificarReservaTurno() throws RemoteException
    {
        for (int i=0; i<colReservaTurno.size(); i++)
        {
            IObserver obs = (IObserver) colReservaTurno.get(i);
            obs.update();
        }
    }

	
}