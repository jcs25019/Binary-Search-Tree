public class Node<T>
{
	private T data;
	private Node left;
	private Node right;
	
	public Node(T newData)
	{
		data = newData;
		left = null;
		right = null;
	}
	
	public Node()
	{
		data  = null;
		left = null;
		right = null;
	}
	
	public String toString()
	{
		return data.toString();
	}
	
	public void setData(T newData)
	{
		data = newData;
	}
	
	public T getData()
	{
		return data;
	}
	
	public void setLeft (Node newLeft)
	{
		left = newLeft;
	}
	
	public Node getLeft()
	{
		return left;
	}
	
	public void setRight (Node newRight)
	{
		right = newRight;
	}
	
	public Node getRight()
	{
		return right;
	}
	
	public boolean equals(Node theOther)
	{
		return this.data.equals(theOther.data);
	}

	public int compareTo(Node c)
	{
		
		String str1 = this.getData().toString();
	
		if (str1.contains(" "))
		{
		  str1 = str1.substring(0, str1.indexOf(" ")); 
		}
		
		String str2 = c.getData().toString();
		if (str2.contains(" "))
		{
			  str2 = str2.substring(0, str2.indexOf(" ")); 
		}

		return str1.compareTo(str2);
	}
}
