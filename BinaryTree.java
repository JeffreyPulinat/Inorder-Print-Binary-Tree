public class BinaryTree{
	//INITIALIZATIONS---------------
	private BinaryNode root;
	public BinaryTree(){root=null;}		//initializes tree root to null
	public BinaryTree(Integer x){		//gives tree a head
		root=new BinaryNode(x);
	}
	
	//GENERAL UPDATE METHODS------------------
	public boolean isEmpty(){return root==null;}
	public void makeEmpty(){root=null;}
	public int nodeCount(){return BinaryNode.nodeCount(root);}
	public int height(){return BinaryNode.height(root);}
	
	//NODE UPDATE AND ACCESS METHODS-----------------
	public Object getRootObj()throws BinaryTreeException{		//returns element of node
		if(root==null)throw new BinaryTreeException("empty tree");
		else
			return root.element;
	}
	
	//updates root
	public void setRoot(int x)throws BinaryTreeException{
		if(root==null)throw new BinaryTreeException("empty tree");
		else
			root.element=x;
	}
	
	//access left node
	public BinaryTree getLeft() throws BinaryTreeException{
		if(root==null)throw new BinaryTreeException("empty tree");
		else{
			BinaryTree t= new BinaryTree();	
			t.root=root.left;
			return t;
		}
	}
	
	//update left node
	public void setLeft(BinaryTree t) throws BinaryTreeException{
		if(root==null)throw new BinaryTreeException("empty tree");
		else{
			root.left=t.root;
		}
	}
	
	//access right node
	public BinaryTree getRight() throws BinaryTreeException{
		if(root==null)throw new BinaryTreeException("empty tree");
		else{
			BinaryTree t= new BinaryTree();	
			t.root=root.right;
			return t;
		}
	}
	
	//update right node
	public void setRight(BinaryTree t) throws BinaryTreeException{
		if(root==null)throw new BinaryTreeException("empty tree");
		else{
			root.right=t.root;
		}
	}
	
	//FUNCTIONS-----------------
	
	//inserts integer into tree
	public static BinaryTree insert(BinaryTree t,Integer x){
		if(t.isEmpty())return new BinaryTree(x);		//if tree is empty assings the first root as x.
		else{
			if(((Integer)t.getRootObj()).intValue()<((Integer)x).intValue()){		//if root < inserted integer. insert to right node
				t.setRight(insert(t.getRight(),x));
				t.root.RightThread = false;				//since it went to right. that means that this we don't need to right thread this node.
			}
			else
				t.setLeft(insert(t.getLeft(),x));		//else inserts to left node
			return t;									//returns newly updated tree
		}
	}
	
	public void threadTree()
	{
		this.root = this.threadTree(this.root); //gets root of tree for threadtree function
	}
	
	//sets right threads to roots
	private BinaryNode threadTree(BinaryNode root) {
		if(root == null)return null;	//when root is null returns null
		BinaryNode originRootLeft = threadTree(root.left);	//keeps a pointer in roots left node
		if(originRootLeft != null) {
			BinaryNode copy = originRootLeft;		//copies roots left node
			while(copy.right != null && copy.right != originRootLeft)	//condition for left subtree.
				copy = copy.right;							//gets to the last right node of left subtree thats has no right child.
			copy.RightThread = true;		//sets flag boolean to true         
			copy.right = root;				//sets the rightnode to root
		}
		BinaryNode originRootRight = threadTree(root.right);
		if(originRootRight != null){	//copies roots right node
			BinaryNode copy = originRootRight;	
			
			while(copy.right != null && copy.right != originRootRight) //condition for right subtree
				copy = copy.right;		//gets to the last right node of right subtree thats has no right child.
			copy.RightThread = true;		//sets flag boolean to true 
			copy.right = root;			//sets the rightnode to root
		}
		
		return root;			//returns updated nodes
	}
	
	//prints numbers inorder
	//ex: 1,2,3,4,5    22,30,96,98
	public void inorderIterative(){
		BinaryNode current = this.root;
		boolean DidRT = false;  //when tree just finished a right thread node. set to false.
		
		while(true){		 //this will loop forever. Until I use break;
			if(current.left != null && DidRT == false){		//left subtree conditions
				
				current = current.left;				//gets leftmost node
				continue;	//keeps returning to the if statement. essentially like 2 while loops
			}
			
			System.out.print(current.element + " ");	//prints out leftmost node or parent root if no left subtree
			
			if(current.right == null || (current.right == root && (Integer)current.element >= (Integer)root.element)){		//end of BT case
			//these conditions when tree is already threaded and represents the end of the inorder transversal
				break;
			}
			
			if(current.right != null){		//right subtree conditions
				if(DidRT==true)					
					DidRT = false;		//resets local RT after every right thread

				if(current.RightThread==true){		//RightThread is true when right node is null(from insert method)
					DidRT = true;					//sets local RT boolean true
					System.out.print("-> ");		//prints as instructed in project to visually show right thread
				}
				
				current = current.right;			//moves pointer to the current node right node
			}
		}
	}
}
