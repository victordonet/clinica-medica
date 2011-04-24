package vista.ventanas;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class PanelConImagen extends Container
{

	private static final long serialVersionUID = 1L;
	// La imagen que queremos de fondo, un fichero .gif
	public ImageIcon icono;

	public PanelConImagen(String imagen){
		 icono = new ImageIcon (imagen);
	}
			
	// Redefinición del método paint()
	public void paint (Graphics g)
	{
		// Borramos todo y lo pintamos del color de fondo por defecto.
		Rectangle r = g.getClipBounds();
		g.setColor(this.getBackground());
		g.fillRect (r.x, r.y, r.width, r.height);
		
		// Pintamos la imagen
		g.drawImage (icono.getImage(), 0, 0, this.getWidth(), 
					this.getHeight(), this.getBackground(), this);

		// Hacemos que se pinten los botones dentro de este contenedor
		super.paintComponents(g);
	}
}