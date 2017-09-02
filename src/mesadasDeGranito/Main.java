package mesadasDeGranito;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class Main
{

	public static void main(String[] args) throws IOException
	{
		BuscadorDeLotes buscador = new BuscadorDeLotes("./IN/");
		File[] lotesDePrueba = buscador.buscarLotes();
		
		for(File lote : lotesDePrueba)
		{
			Deposito depo = new Deposito(lote);

			//depo.Ordenar();
			//depo.Mostrar();
			depo.Resolver("./OUT/" + lote.getName());
		}
		

		// System.out.println("La cantidad de pilas son:" + depo.Apilar());
	}

}
