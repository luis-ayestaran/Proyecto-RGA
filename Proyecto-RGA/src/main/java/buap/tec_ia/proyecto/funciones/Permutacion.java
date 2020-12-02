package buap.tec_ia.proyecto.funciones;

import buap.tec_ia.proyecto.estructuras.Individuo;

public class Permutacion {

	public static void funcionPermutacion(Individuo individuo) {
		int idrg,idsg;
		int contador=0;
		
		/*System.out.println("IdRg    vrg    IdSg    vsg\n");
		for(int i=0; i<individuo.getCv().getConexiones().size(); i++) {
			
			System.out.print(individuo.getCv().getConexiones().get(i).getIdRg()+ "\t" );//id del gen regulador
			idrg=individuo.getCv().getConexiones().get(i).getIdRg();
			System.out.print(individuo.getRv().getGenesReguladores().get(idrg).getValor()+"\t" );
			
			System.out.print(individuo.getCv().getConexiones().get(i).getIdSg()+ "\t" );//id del gen estructural
			idsg=individuo.getCv().getConexiones().get(i).getIdSg();
			System.out.print(individuo.getSv().getGenesEstructurales().get(idsg).getValor()+"\t" );
			
			System.out.println("\n");
		}*/
		

		//System.out.println("Lista de vrg cuyo valor es 1\n");
		//System.out.println("IdRg    vrg    IdSg    vsg\n");
		
		for(int i=0; i<individuo.getCv().getConexiones().size(); i++) {
			idrg=individuo.getCv().getConexiones().get(i).getIdRg();
			if(individuo.getRv().getGenesReguladores().get(idrg).getValor()==1){
				
				//System.out.print(individuo.getCv().getConexiones().get(i).getIdRg()+ "\t" );//id del gen regulador
				idrg=individuo.getCv().getConexiones().get(i).getIdRg();
				//System.out.print(individuo.getRv().getGenesReguladores().get(idrg).getValor()+"\t" );
				
				//System.out.print(individuo.getCv().getConexiones().get(i).getIdSg()+ "\t" );//id del gen estructural
				idsg=individuo.getCv().getConexiones().get(i).getIdSg();
				//System.out.print(individuo.getSv().getGenesEstructurales().get(idsg).getValor()+"\t" );
				
				//System.out.println("\n");
				
				contador=contador+1;
			}
		}
		
		int[] idSg = new int[contador];
		int[] vsg = new int[contador];
		int[] vectaux = new int [contador];
		int p=0,m=0;
		//System.out.println("contador: "+(contador)+"\n");
		
		for(int i=0; i<individuo.getCv().getConexiones().size(); i++) {
			idrg=individuo.getCv().getConexiones().get(i).getIdRg();
			if(individuo.getRv().getGenesReguladores().get(idrg).getValor()==1){
				idrg=individuo.getCv().getConexiones().get(i).getIdRg();
				idsg=individuo.getCv().getConexiones().get(i).getIdSg();
				idSg[p]=idsg;
				vsg[p]=individuo.getSv().getGenesEstructurales().get(idsg).getValor();
				p=p+1;
			}
		}
		
		/*System.out.println("Cambio de posi\n");
		System.out.println("IdSg    vsg\n");
		for(int i=0; i<idSg.length;i++) {
			System.out.print(idSg[i]+"\t");
			System.out.print(vsg[i]+"\t");
			System.out.println("\n");
		}*/
		
		//permutacion
		int n=vsg.length-1;
		for(int i=0;i<idSg.length;i++) {
			int aux=vsg[i];
			individuo.getSv().getGenesEstructurales().get(idSg[i]).setValor(vsg[n]);
			individuo.getSv().getGenesEstructurales().get(idSg[n]).setValor(aux);
			n=n-1;
			
		}
		
		
		//ver cambios
		//System.out.println("Ver Cambios\n");
		//System.out.println("IdRg    vrg    IdSg    vsg\n");
		
		/*for(int i=0; i<individuo.getCv().getConexiones().size(); i++) {
			idrg=individuo.getCv().getConexiones().get(i).getIdRg();
			if(individuo.getRv().getGenesReguladores().get(idrg).getValor()==1){
				
				System.out.print(individuo.getCv().getConexiones().get(i).getIdRg()+ "\t" );//id del gen regulador
				idrg=individuo.getCv().getConexiones().get(i).getIdRg();
				System.out.print(individuo.getRv().getGenesReguladores().get(idrg).getValor()+"\t" );
				
				System.out.print(individuo.getCv().getConexiones().get(i).getIdSg()+ "\t" );//id del gen estructural
				idsg=individuo.getCv().getConexiones().get(i).getIdSg();
				System.out.print(individuo.getSv().getGenesEstructurales().get(idsg).getValor()+"\t" );
				
				System.out.println("\n");
				
			}
		}*/
	}

}
