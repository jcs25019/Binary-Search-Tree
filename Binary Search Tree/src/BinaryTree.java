import java.io.PrintWriter;

public class BinaryTree<T>
{
	private Node<T> root;
	
	public BinaryTree()
	{
		root = null;
	}
	
	public void inOrder(Node root)
	{
		if(root != null)
		{
			inOrder(root.getLeft());
			System.out.println(root);
			inOrder(root.getRight());
		}
	}

	public void inOrderPrint(Node root, PrintWriter txtFile)
	{
		if(root != null)
		{
			inOrderPrint(root.getLeft(), txtFile);
			txtFile.println(root.getData());
			inOrderPrint(root.getRight(), txtFile);
		}
	}

	
	public boolean empty()
	{
		return (root == null);
	}
	
	public Node getRoot()
	{
		return root;
	}
	
	public void setRoot(Node newRoot)
	{
		root = newRoot;
	}
}