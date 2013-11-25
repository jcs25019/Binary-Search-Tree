import java.io.PrintWriter;

public class BinarySearchTree<T> extends BinaryTree<T>
{
	public BinarySearchTree()
	{
		super();
	}
	
	public boolean add (T newMember)
	{
		boolean success = true;
		Node<T> newNode = new Node<T>(newMember);
		if (empty())
			setRoot(newNode);
		else
		{
			Node p = null;
			Node c = getRoot();
			int compare = 0;
			
			while (c != null)
			{
				compare = newMember.toString().compareTo(c.getData().toString());
				if (compare == 0)
				{
					success = false;
					return success;
				}
				else
				{
					p = c;
					if(compare > 0)
						c = c.getRight();
					else
						c = c.getLeft();
				}
			}
			
			if (compare > 0)
				p.setRight(newNode);
			else
				p.setLeft(newNode);
		}
		return success;
		
	}
	
	public T delete(Node key)
	{
		T dataInDeleted = null;
		if (!empty())
		{
			Node p = null;
			Node c = getRoot();
			int compare = 0;
			
			while (c != null)
			{
				compare = key.compareTo(c);
				if (compare == 0)
					break;
				else
				{
					p = c;
					if (compare > 0)
						c = c.getRight();
					else
						c = c.getLeft();
				}
			}
			
			if (c == null)
			{
				System.out.println("not found");
				return dataInDeleted;
			}
			else
			{
				dataInDeleted = (T) c.getData();
				Node betweenPnC = null;
				
				if (c == getRoot())
					betweenPnC = getRoot();
				else if (c == p.getLeft())
					betweenPnC = p.getLeft();
				else
					betweenPnC = p.getRight();
				
				if (betweenPnC.getRight() == null)
					betweenPnC = betweenPnC.getLeft();
				else if (betweenPnC.getLeft() == null)
					betweenPnC = betweenPnC.getRight();
				
				Node px = c;
				Node pc = c.getRight();
				while (pc.getLeft() != null)
				{
					px = pc;
					pc = pc.getLeft();
				}
				
				c.setData((T) pc.getData());
				
				if (px == c)
					px.setRight(pc.getRight());
				else
					px.setLeft(pc.getRight());
			}
		}
		return dataInDeleted;
	}
	
	public void traverse()
	{
		Node startPoint = getRoot();
		inOrder(startPoint);
	}
	
	public void TraverseAndPrint(PrintWriter outputFile)
	{
		Node startPoint = getRoot();
		inOrderPrint(startPoint, outputFile);
	}
	
	public Node binarySearch(Node key)
	{
		Node found = null;
		Node temp = getRoot();
		while (temp != null)
		{
			int x = key.compareTo(temp);
			if (x == 0)
			{
				found = temp;
				break;
			}
			else if (x < 0)
				temp = temp.getLeft();
			else
				temp = temp.getRight();
		}
		return found;
	}
}