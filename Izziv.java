import java.util.*;

public class Izziv{
	public static void main(String[] args){
		
		System.out.println("   n     |    linearno  |   dvojisko   |");
		System.out.println("---------+--------------+---------------");
		for(int i = 1000; i <= 100000; i=i+1000){
			System.out.printf("%8d |   %10d |   %10d\n", i, timeLinear(i), timeBinary(i));
		}	
	
		
	}


	static int[] generateTable(int n){
		int[] tabela = new int[n];
		for(int i = 1; i <= n; i++){
			tabela[i-1] = i;	
		}		
	
		return tabela;

	}
	
	static int findLinear(int[] a, int v){
		for(int i = 0; i < a.length; i++){
	 		if(a[i] == v)
				return i;	
		}

	return -1;		

	}

	static int findBinary(int[] a, int l, int r, int v){
		if (r >= l) { 
            	 int mid = l + (r - l) / 2; 
  
            
                if (a[mid] == v){
       	        	return mid; 
                }
 

                if (a[mid] > v) 
                 return findBinary(a, l, mid - 1, v); 
  

            	return findBinary(a, mid + 1, r, v); 
        	} 
  

        	return -1; 		

	
	}

	static long timeLinear(int n){
		Random rand = new Random();
		int[] tabela = generateTable(n);
		long startTime = System.nanoTime();
		for(int i = 0; i < 1000; i++){
			int randomNum = rand.nextInt((n - 1) + 1) + 1;
			findLinear(tabela, randomNum);
	
		}
		long executionTime = (System.nanoTime() - startTime)/1000;
		return executionTime;

	}

	static long timeBinary(int n){
		Random rand = new Random();
		int[] tabela = generateTable(n);
		long startTime = System.nanoTime();
		for(int i = 0; i < 1000; i++){
			int randomNum = rand.nextInt((n - 1) + 1) + 1;
			findBinary(tabela, 1, n, randomNum);
	
		}
		long executionTime = (System.nanoTime() - startTime)/1000;
		return executionTime;
	

	} 	


}