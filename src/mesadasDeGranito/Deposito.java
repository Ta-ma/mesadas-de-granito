package mesadasDeGranito;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Scanner;
import java.util.Vector;

public class Deposito
{
	private Vector<Mesada> vec;
	
	public Deposito(File lote) throws FileNotFoundException
	{
		this.vec = new Vector<Mesada>();
		Scanner sc = new Scanner(lote);
		sc.useLocale(Locale.ENGLISH);
		int cant = sc.nextInt();
		System.out.println(cant);

		for (int i = 0; i < cant; i++)
		{
			vec.add(new Mesada(sc.nextDouble(), sc.nextDouble()));
		}

		sc.close();
	}

	public void Mostrar()
	{
		for (Mesada mesada : vec)
		{
			System.out.println(mesada);
		}
	}

	public void Resolver(String pathS) throws IOException
	{
		int cant = 0;
		vec.sort(null);
		
		while(vec.size() > 0)
		{
			Mesada mesadaInferior = vec.remove(0);
			System.out.println(mesadaInferior);
			
			for(int i = 0; i < vec.size(); i++)
			{
				switch (vec.get(i).entraEn(mesadaInferior))
				{
				case 0:
					break;
				case 1:
					mesadaInferior = vec.remove(i);
					break;
				case 2:
					vec.remove(i);
				}
			}
			cant++;
		}
		
		PrintWriter pw = new PrintWriter(new FileWriter(pathS));
		pw.print(cant);
		pw.close();
	}
}
