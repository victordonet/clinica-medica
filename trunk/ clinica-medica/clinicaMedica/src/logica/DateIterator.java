package logica;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

public class DateIterator implements Iterator<Date>, Iterable<Date> {

	private Calendar inicio = Calendar.getInstance();
	private Calendar fin = Calendar.getInstance();
	private Calendar actual = Calendar.getInstance();

	public DateIterator(Date inicio, Date fin) {
		this.inicio.setTime(inicio);
		this.fin.setTime(fin);
		this.actual.setTime(inicio);
	}

	public boolean hasNext() {
		return !actual.after(fin);
	}

	public Date next() {
		actual.add(Calendar.DATE, 1);
		return actual.getTime();
	}

	public void remove() {
		throw new UnsupportedOperationException("No se puede eliminar.");
	}

	public Iterator<Date> iterator() {
		return this;
	}
}
