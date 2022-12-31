import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Ejercicio5_AV {
	
	static class Actividad implements Comparable<Actividad>{
		int start,end;
		int index;
		public Actividad(int s, int e,int i) {
			this.start=s;
			this.end=e;
			this.index=i;
		}
		@Override
		public int compareTo(Actividad actividad) {
			//entrega segun tiempo de finalizacion (orden creciente)
			if(  this.end> actividad.end) return 1;
			if( this.end< actividad.end) return -1;
			return 0;
		}	
	}
	public static List<Integer> selectActivities(int[][] star_ends){
		//cuantas actividades tenemos
		final int N=star_ends.length;
		List<Integer> result= new ArrayList<>();
		PriorityQueue<Actividad> A= new PriorityQueue<>();
		for(int i=0;i<N;i++) {
			//ordena segun tiempo de finalizacion
			Actividad act= new Actividad(star_ends[i][0],star_ends[i][1],i);
			//System.out.println(act.start+" "+act.end);	
			A.offer(act);
		}
		int index1=A.peek().index;
		Actividad act1=A.poll();
		result.add(index1);
		Actividad tmp= new Actividad(act1.start,act1.end,act1.index);
		while(!A.isEmpty()) {
			Actividad siguiente=A.poll();
			//si comienza despues de que la actividad previa en S haya 
			//termiando SELECCIOANRLA
			if(siguiente.start>=tmp.end) {
				//System.out.println(siguiente.index);
				result.add(siguiente.index);
				tmp.start=siguiente.start;
				tmp.end=siguiente.end;
				tmp.index=siguiente.index;	
			}	
		}
		return result;	
	}
	
	public static boolean isValid(int [][]star_ends, List<Integer> selected) {
		//se tiene que ver que los end de la hora anterior 
		//sea menor o igual que la que se esta
		//revisando
		
		
		//obtener primero la info  completa (end)
		//de las actividades que fueron seleccioandas
		int[][] toValid= new int[selected.size()][];
		
		for(int i=0;i<selected.size();i++)
			toValid[i]=star_ends[selected.get(i)];
		
		
		for(int i=0;i<selected.size()-1;i++)
			if(toValid[i][1]>toValid[i+1][0])
				return false;
			
		
		return true;
	}
	public static void main(String[] args) {
		int[][] start_ends1= {{0,6},{1,4},{2,14},{3,5},{4,5},{5,7},{5,9},{6,10},{8,11},{8,12},{12,16}};
		int[][] start_ends2= {{5,7},{1,4},{2,14},{0,6},{3,5},{8,12},{4,5},{5,9},{12,16},{6,10},{8,11}};
		
		//System.out.println(Arrays.deepToString(start_ends));
		
		List<Integer> selected1=selectActivities(start_ends1);
		List<Integer> selected2=selectActivities(start_ends2);
		System.out.println(selected1.toString());
		System.out.println(selected2.toString());
		
		boolean b1=isValid(start_ends1,selected1);
		System.out.println(b1);
		selected1.add(2); 		boolean b2=isValid(start_ends1,selected1);
		System.out.println(b2);
		
		boolean b3=isValid(start_ends2,selected2);
		System.out.println(b3);

	}
}
