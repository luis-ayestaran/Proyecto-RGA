package buap.tec_ia.proyecto.funciones;

import java.util.Random;

import buap.tec_ia.proyecto.estructuras.Individuo;


public class Mutacion {
	
	public static void funcionMutacion(Individuo individuo) {
		
		int posi;
		
		/*for(int i=0; i<individuo.getRv().getGenesReguladores().size(); i++) {
		
			System.out.println(individuo.getRv().getGenesReguladores().get(i).getValor() + "\t");//obtengo objeto tipo gen regulador sin el getvalor
			
		}
		
		System.out.println("");*/
		
		Random generadorRandom = new Random();//probalidad de 0.75
		if(generadorRandom.nextInt(1000) < 75) {
			posi= new Random().nextInt( individuo.getRv().getGenesReguladores().size() );
			//System.out.println("Posicion a cambia: " +posi);
			if(individuo.getRv().getGenesReguladores().get(posi).getValor()==1) {
				individuo.getRv().getGenesReguladores().get(posi).setValor(0);
			}else {
				individuo.getRv().getGenesReguladores().get(posi).setValor(1);
			}
			
		}
		
		/*System.out.println("");
		
		for(int i=0; i<individuo.getRv().getGenesReguladores().size(); i++) {
			
			System.out.println(individuo.getRv().getGenesReguladores().get(i).getValor() +"\t");
			
		}*/
		
		
		
	}
}
