package CodeSource_TP02;

import java.util.Random;
import java.util.ArrayList;

public class LinearSpacePerfectHashing<AnyType>
{
	static int p = 46337;

	QuadraticSpacePerfectHashing<AnyType>[] data;
	int a, b;

	LinearSpacePerfectHashing()
	{
		a=b=0; data = null;
	}

	LinearSpacePerfectHashing(ArrayList<AnyType> array)
	{
		AllocateMemory(array);
	}

	public void SetArray(ArrayList<AnyType> array)
	{
		AllocateMemory(array);
	}

	@SuppressWarnings("unchecked")
	private void AllocateMemory(ArrayList<AnyType> array)
	{
		Random generator = new Random( System.nanoTime() );

		if(array == null || array.size() == 0)
		{
			// A completer
			a =  b = 0; data = null;
			return;
		}
		if(array.size() == 1)
		{
			a = b = 0;
			data = (QuadraticSpacePerfectHashing<AnyType>[]) new Object[1];
			data[0].SetArray(array);
			// A completer
			return;
		}
		
		data = (QuadraticSpacePerfectHashing<AnyType>[]) new Object[array.size()];
		/*
		int[] keys = new int[array.size()]; 
		for (int i =0; i<array.size(); i++) {
			keys[i]= getKey(array.get(i));			
		}
		
		for (int i =0; i<array.size(); i++) {
			ArrayList<AnyType>
			for (int j =0; j<array.size(); j++) {
				
				if (keys[j]==i)
				
			}
		}
		*/
		
		// A completer
		for(int i = 0 ; i <array.size() ; i ++) {
			int key = getKey(array.get(i));
			int size = 0;
			for(int j = 0; j < data[key].Size() ; j++) {
				if(data[key].containsKey(j))
					size++;
			}
			ArrayList<AnyType> arrayValues = new ArrayList<AnyType>(size);
			for(int j = 0; j < data[key].Size() ; j++) {
				if(data[key].containsKey(j))
					arrayValues.add(data[key].items[j]);
			}
			arrayValues.add(array.get(i));
			data[key] = new QuadraticSpacePerfectHashing<AnyType>(arrayValues);
		}
	}

	public int Size()
	{
		if( data == null ) return 0;

		int size = 0;
		for(int i=0; i<data.length; ++i)
		{
			size += (data[i] == null ? 1 : data[i].Size());
		}
		return size;
	}

	public boolean containsKey(int key)
	{
		// A completer
		

	}
	
	public int getKey (AnyType x) {
		// A completer
		
	}
	
	public boolean containsValue (AnyType x) {
		// A completer

	}
	
	public void remove (AnyType x) {
		// A completer
		
	}

	public String toString () {
		String result = "";
		
		// A completer
		
		
		return result; 
	}

	public void makeEmpty () {
		// A completer

   	}
	
}
