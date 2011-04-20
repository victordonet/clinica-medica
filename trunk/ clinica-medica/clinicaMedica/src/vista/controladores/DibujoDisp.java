package vista.controladores;

import java.awt.Color;
import java.awt.Component;


import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;


public class DibujoDisp implements TableCellRenderer {


	private static final long serialVersionUID = 1L;

	public Component getTableCellRendererComponent(JTable tabla, Object valor,
			boolean isSelected, boolean hasFocus, int row, int column) {
		//super.getTableCellRendererComponent (tabla, valor, isSelected, hasFocus, row, column);
		JCheckBox jchk = new JCheckBox();
		jchk.setSelected((Boolean) valor);
	if(tabla.isCellEditable(row, column)==false){
			  jchk.setOpaque(true);
		      jchk.setBackground(Color.RED);
		}
		return jchk;
	}

}
