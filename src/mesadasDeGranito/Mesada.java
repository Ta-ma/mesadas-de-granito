package mesadasDeGranito;

public class Mesada implements Comparable<Mesada>
{
	private double largo;
	private double ancho;

	public double getLargo()
	{
		return largo;
	}

	public void setLargo(double largo)
	{
		this.largo = largo;
	}

	public double getAncho()
	{
		return ancho;
	}

	public void setAncho(double ancho)
	{
		this.ancho = ancho;
	}

	public Mesada(final double largo, final double ancho)
	{
		this.largo = largo;
		this.ancho = ancho;
	}

	public int entraEn(Mesada that)
	{
		if ((this.largo >= that.largo && this.ancho >= that.ancho) || (this.ancho >= that.largo && this.largo >= that.ancho))
			return 1;
		else if ((this.largo <= that.largo && this.ancho <= that.ancho) || (this.ancho <= that.largo && this.largo <= that.ancho))
			return 2;
		
		return 0;
	}

	@Override
	public int compareTo(Mesada that)
	{

		if (this.largo < that.largo)
			return 1;
		// SI SON IGUALES PREGUNTO POR EL ANCHO
		if (this.largo == that.largo)
		{
			// ORDENA POR ORDEN DE LECTURA SI SON IGUALES.
			if (this.ancho <= that.ancho)
				return 1;
		}

		return -1;
	}

	@Override
	public String toString()
	{
		return "Mesada [largo=" + largo + ", ancho=" + ancho + "]";
	}

}
