package persistencia.mains;

import java.rmi.RemoteException;
import java.util.Calendar;

import javax.swing.JOptionPane;

import persistencia.dao.DaoAdmGenMySQL;
import persistencia.dao.IDaoAdmGen;
import persistencia.fabrica.FabricaMySQL;
import persistencia.transacciones.Pool;
import persistencia.transacciones.Transaccion;

import logica.Configuracion;
import logica.fachada.IfachadaLogica;
import logica.fachada.ProxyFachadaLogica;
import vista.controladores.CdorMantEsp;
import vista.dataobjet.DataAdmin;
import excepciones.LogicaException;
import excepciones.PersistenciaException;

public class MainDaoAdm {
	
	public static void main(String[] args) throws LogicaException, PersistenciaException {
		try 
		{
			
			IfachadaLogica facade = new ProxyFachadaLogica();
			DataAdmin adm = new DataAdmin("FEDE", "FEDERICO", 1, "A");
			facade.altaAdmin(adm);
			JOptionPane.showMessageDialog(null,"Alta ADM");
			
			JOptionPane.showMessageDialog(null,"Validando Id FEDE" + facade.validarAdmin("FEDE"));
			
			facade.bajaAdmin("FEDE");
			JOptionPane.showMessageDialog(null,"Bajo Id FEDE");
			
		} catch (RemoteException e) {
			e.printStackTrace();			
			JOptionPane.showMessageDialog(null,"Error de conexion con el Servidor");
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
