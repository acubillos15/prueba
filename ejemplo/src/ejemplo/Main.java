/**
 * 
 */
package ejemplo;

/**
 * @author andre
 *
 */
import java.math.BigInteger;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		Scanner op=new Scanner(System.in);
		
		ArrayList <BigInteger> respuesta = new ArrayList <BigInteger>();
		Queue<ArrayList<BigInteger> >entradas=new LinkedList<ArrayList<BigInteger> >();
		String instr;

		ArrayList<BigInteger> aux=new ArrayList<BigInteger>();

		while(op.hasNext()!=false){
			
			instr=op.next();
			BigInteger in=new BigInteger(instr);
			
			if(in.equals(new BigInteger(Integer.toString(-999999)))){
				entradas.add(aux);
				aux=new ArrayList<BigInteger>();
			}
			else
				aux.add(in);

			
		}

		while(!entradas.isEmpty()){

			aux=entradas.poll();
			int aux_bool;
			BigInteger mayor=aux.get(0);
			int tam=aux.size();

			for(int i=0;i<tam;i++) {
				aux_bool=aux.get(i).compareTo(mayor);
				if(aux_bool==1)mayor=aux.get(i);
			}

			BigInteger matrix[][]=new BigInteger [tam-1][tam-1];

			for(int i=0;i<tam-1;i++){

				matrix[0][i]=aux.get(i).multiply(aux.get(i+1));
				aux_bool=matrix[0][i].compareTo(mayor);
				if(aux_bool==1)mayor=matrix[0][i];

			}

			for(int i=1;i<tam-1;i++){
				for(int j=i;j<tam-1;j++){

					matrix[i][j]=matrix[i-1][j-1].multiply(aux.get(j+1));
					aux_bool=matrix[i][j].compareTo(mayor);
					if(aux_bool==1)mayor=matrix[i][j];

				}
			}
			respuesta.add(mayor);
		}

		int tamano=respuesta.size();

		for(int i=0;i<tamano;i++){
			System.out.println(respuesta.get(i).toString());
		}
		op.close();
	}

}
