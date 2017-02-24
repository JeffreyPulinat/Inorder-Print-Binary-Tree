public class BinaryNode{
	Object element;					// node value
	BinaryNode left,right;			// refers to left and right node
	boolean RightThread;		// boolean checks if right link is threaded. flag variable

	//Initializations--------------------
	BinaryNode(){
		this(null);					//makes empty node
	}
	BinaryNode(Integer e){
		this(e,null,null);			//null left and right for node
	}
	BinaryNode(Integer e,BinaryNode ln,BinaryNode rn){		//assigns nodes with left and right initialized
		element=e;
		left = ln;
		right=rn;
		
	}
	//FUNCTIONS-----------------------------
	//counts all the subnodes
	static int nodeCount(BinaryNode n){
		if(n==null)return 0;
		else{
			return 1+nodeCount(n.left)+nodeCount(n.right);		//adds 1 because nodecount counts the subnodes. the root is 1 extra node.
		}
	}
	
	//returns the height of the tree
	static int height(BinaryNode n){
		if(n==null)return -1;
		else
			return 1+Math.max(height(n.left),height(n.right));		//gives the higher height tin the left or right subtree
	}
}
