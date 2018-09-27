package CodeSource_TP02;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class SubsetHashing {
	
    /* Return true si Tab2 [] est un sous-ensemble de Tab1 [] */
	static boolean isSubset(int Tab1[], int Tab2[], int m, int n)
    {
        // compléter 
		HashSet<Integer> mySet = new HashSet<Integer>();
		for(int i = 0; i < m; i++)
			mySet.add(Tab1[i]);
		for(int i = 0; i < n; i++) {
			if(mySet.contains(Tab2[i]))
				return false;
		}
        return true;
    } 
 
    public static void main(String[] args) 
    { 
        int T1[] = {5, 11, 12, 1, 10, 3, 7};
        int T2[] = {11, 1, 10};
         
        int m = T1.length;
        int n = T2.length;
     
        if(isSubset(T1, T2, m, n))
            System.out.print("Tab2 [] est un sous-ensemble de Tab1 [] ");
        else
            System.out.print("Tab2 [] n'est pas un sous-ensemble de Tab1 []"); 
    }
}


