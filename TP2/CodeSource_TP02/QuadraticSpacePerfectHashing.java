package CodeSource_TP02;

import java.util.ArrayList;
import java.util.Random;

public class QuadraticSpacePerfectHashing<AnyType> 
{
	static int p = 46337;

	int a, b;
	AnyType[] items;

	QuadraticSpacePerfectHashing()
	{
		a=b=0; items = null;
	}

	QuadraticSpacePerfectHashing(ArrayList<AnyType> array)
	{
		AllocateMemory(array);
	}

	public void SetArray(ArrayList<AnyType> array)
	{
		AllocateMemory(array);
	}

	public int Size()
	{
		if( items == null ) return 0;

		return items.length;
	}

	public boolean containsKey(int key)
	{
		// A completer
		if(items == null)
			return false;
		return (items[key]!=null);

	}

	public boolean containsValue(AnyType x )
	{
		// A completer
		int key = getKey(x);
		if(Size()==0 || items[key] == null) return false;
		return (items[key].equals(x));
	}

	public void remove (AnyType x) {
		// A completer
		int key = getKey(x);
		items[key] = null;
	}

	public int getKey (AnyType x) {
		// A completer
		return (((a*x.hashCode()+b)%p)%Size());
	}

	@SuppressWarnings("unchecked")
	private void AllocateMemory(ArrayList<AnyType> array)
	{
		Random generator = new Random( System.nanoTime() );

		if(array == null || array.size() == 0)
		{
			// A completer
			a=b=0; 
			items = null;
			return;
		}
		if(array.size() == 1)
		{
			a = b = 0;
			items = (AnyType[]) new Object[1];
			items[0] = array.get(0);
			// A completer			
			return;
		}
		int m = array.size()*array.size();
		items = (AnyType[]) new Object[m];
		int index = 0;
		while(index < array.size()) {
			index = 0;
			a=generator.nextInt(p-1)+1; //pcq 0<a<p, 0 doit être exclus
			b=generator.nextInt(p);
			for(; index < array.size(); index++) {
				int key = getKey(array.get(index));
				if(containsKey(key)) {
					makeEmpty();
					//items = (AnyType[]) new Object[m];
					break; //s'il y a collision on recommence le processus...?
				}
				items[key]=array.get(index);
			}
		}
	}

	
	
	public String toString () {
		String result = "";
		
		for(int i = 0; i < Size(); i++) {
			if(containsKey(i)) {
				result += "(clé_" + i + ", " + items[i].toString() + ") ";
			}
		}
		
		return result;
		
	}

	public void makeEmpty () {
		   // A completer
		for(int i = 0; i < items.length ; i++)
			items[i] = null;
   	}
}
