import java.io.FileNotFoundException;
import java.io.IOException;

public class TreeWalker extends IOTree {

	// it inherits root and size from LinkedBinaryTree vis IOTree;
	Position current;

	/************************************************************************************************/
	/** Constructors                                                                               **/
	/**     @param ()            ==> use default tree description                                  **/
	/**       (String toParse)   ==> Tree built from this parsing                                  **/
	/**                                                                                            **/
	/************************************************************************************************/

	public TreeWalker() throws IOException
	{
		this("((10 20 30) 40 (null 50 (60 70 80)))");  // The TreeWalker constructor with use default tree description  
	}

	public TreeWalker(String toParse) 
	{
		super(toParse);
		makeCurrent(root());	
	}	


	/************************************************************************************************
	 * root, parent, leftChild, and rightChild return the state position of given position.         *
	 *    - They create it if it is not there.                                                      *	
	 ************************************************************************************************/

	public Position root(Position position) 
	{
	    /* My code had 7 */
		return makeCurrent(position);
	}

	public Position parent(Position position)  throws InvalidPositionException 
	{
	    /* My code had 11 lines */
		return makeCurrent(position);
	}

	public Position leftChild(Position position)  
	{
	    /* My code had 7 lines */
	}

	public Position rightChild(Position position) 
	{
	    /* My code had 7 lines */
	}


	/************************************************************************************************
	 * rotateR rotates a node raising its left child to its position and lowering itself to the right *
	 * rotateL rotateR does the reverse                                                           *
	 ************************************************************************************************/

	public Position rotateR(Position position)  
	{
	    /* My code had 16 lines */
	}

	public Position rotateL(Position position)  
	{
	    /* My code had 16 lines */
	}

	/************************************************************************************************
	 * first, last, next, previous return this position according to the infix traversal order.     *
	 *    - The last two create it if it is not there.                                                      *	
	 ************************************************************************************************/

	public Position first(Position position)  
	{
	    /* My code had 4 lines */
	}

	public Position last(Position position)  
	{
	    /* My code had 4 lines */
	}

	public Position next(Position position) 
	{
	    /* My code had 13 lines */
	}

	public Position previous(Position position) 
	{
	    /* My code had 13 lines */
	}

	/************************************************************************************************
	 * set sets the value of a position to be an integer within its binary search tree order        *
	 *        (set returns the same position to allow   position = set(leftChild(position1))        *
	 ************************************************************************************************/

	public Position set(Position position)  
	{
	    /* My code had 11 lines */
	}

	/*************************************************************************************************
	 * insert inserts a new node after the current node according to the tree's infix Traversal order,* 
	 * i.e. go right and then left left left and put the new node there.                             * 
	 ************************************************************************************************/

	public Position insert(Position position)  
	{
	    /* My code had 5 lines */
	}

	/*************************************************************************************************
	 * deletes the current node                                                                      *
	 * If no right child use deleteNoRight, if no left use deleteNoLeft                              *
	 * else move contents of next to current and delete next                                         *   
	 ************************************************************************************************/

	/* Deletes current when no right child */
	/* Parent adopts left child            */
	
	private Position deleteNoRight(Position position)  
	{
		if( super.rightChild(position)==null) 
		{
			BTNode parent = (BTNode) super.parent(position);
			BTNode node = (BTNode) position;
			BTNode child = (BTNode) super.leftChild(position);
			if( parent!=null && parent.getLeft()==node ) parent.setLeft(child);
			if( parent!=null && parent.getRight()==node ) parent.setRight(child);
			if( node==root() ) setRoot(child);
			if( child!=null ) {
				child.setParent(parent);
				position = child;
			}
			else
				position = parent;
			return position;
		}
		else
		{
			System.out.println("Panic: Is right child");
			return null;
		}
	}

	/* Deletes current when no left child */
	/* Parent adopts right child            */

	private Position deleteNoLeft(Position position)  
	{
	}

	public Position delete(Position position)  
	{
	    /* My code had 10 lines */
	}

}
