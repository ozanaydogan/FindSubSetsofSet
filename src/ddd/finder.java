package ddd;

import java.util.ArrayList;

public class finder {

	
	public ArrayList<int[]> Find_SubArray(int[] Array) {
		
		ArrayList<int[]> SubSets = new ArrayList<int[]>();
		ArrayList<Integer> SubSets_of_SubSets = new ArrayList<Integer>();
		
		int[] binaryValues_of_SubSets = new int[Array.length];
		int[] SubSets_of_SubSets2;
		
		
		int SubsetNumber = Find_SubsetNumber(Array);
		
		int x = 1;
		int y = 0;
		for (x = 1; x <= SubsetNumber ; x++) {
			
			binaryValues_of_SubSets = Find_BinaryNumber(x, Array.length);
			
			// System.out.println("\n"+x+". elemanin ikili tabanda gosterimi ");
			
			for(y = 0 ; y < binaryValues_of_SubSets.length ; y++) {
				
				System.out.print(binaryValues_of_SubSets[y]+" ");
				
			}
			
			System.out.println();
			
			
			for(y = Array.length-1; y >= 0 ; y--) {
				
				if(binaryValues_of_SubSets[y] == 1) {
					
					SubSets_of_SubSets.add(Array[y]);
					
					
				}
				
			
			}
			
			
			
			SubSets_of_SubSets2 = new int[SubSets_of_SubSets.size()];
			
			for(y = 1 ; y <= SubSets_of_SubSets.size() ; y++) {
				
				SubSets_of_SubSets2[y-1] = SubSets_of_SubSets.get(y-1);
								
				
			}
			
			SubSets.add(SubSets_of_SubSets2);
			
			
			SubSets_of_SubSets2 = null;
			System.gc();
			SubSets_of_SubSets.clear();
			
			
		}
		
		System.out.println("\n"+"////////////////////////////////////////////////////////"+"\n");
		
		return SubSets;
		
	}
	
	public int Find_SubsetNumber(int[] Array) {
		
		int Array_Length = Array.length;
		
		
		return  (int) Math.pow(2,Array_Length);	
	
	}
	
	public int[] Find_BinaryNumber(int number, int Arraylength) {
		
		int[] Subset = new int[Arraylength];
		
		for(int x = 0; x < Arraylength; x++) {
			Subset[x] = 0;
		}
		

		int y = Arraylength-1;
			
		while(number > 0 && y >= 0) {
			
			Subset[y] = number % 2 ;
			number = number / 2;
			
			y--;
		
		}
		
		return Subset;
	}

	
	public static void main(String [] arg) 
    {   
		
		ArrayList<int[]> SubSets ;
		
		int[] x = new int[] {1,2,3,4,5};
		int[] k ;
		
		finder bul = new finder();
		
		SubSets = bul.Find_SubArray(x);
		
		for(int y = 0; y < SubSets.size() ; y++) {
			
			k = SubSets.get(y);
			
			System.out.print(y+1+". alt kume" + " " +" = ");
			
			for(int l = 0; l < k.length ; l++) {
				
				System.out.print(k[l]+" ");
				
			}
			
			System.out.println();
		}
		
		System.out.println("\n"+"Ozan Aydogan Kocaeli Universitesi");
    }	 
}

