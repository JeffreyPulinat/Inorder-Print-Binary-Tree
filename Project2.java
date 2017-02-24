import java.io.File;
import java.io.IOException;
import java.util.Scanner;
public class Project2 {
	private static Scanner scan;

	public static void main(String[] args) throws NumberFormatException, IOException{
		if(args.length ==0)System.out.println("No file specified");		//If user does not identify a file to be used
		else{
			//Strings to be used to by one line of the textfile
			String p1text = null;
			try{
				File input = new File(args[0]);
				scan = new Scanner(input);
				int setnum=1;			//count for the set of trees given
				
				while(scan.hasNext()){ 				//keeps going to next line of textfile
					p1text=scan.nextLine();			//assigns string to next line
					BinaryTree BT = new BinaryTree();
					String[] p1 = p1text.split(" "); // split string by space into an array
					for(int i =0;i <p1.length; i++){	
						int num = Integer.parseInt(p1[i]);		//parses the array elements
						BT = BinaryTree.insert(BT,num);		//inserts the number
					}
					
					System.out.println("Tree "+ setnum+":");//prints out count of tree set it is
					BT.threadTree();				//right threads tree
					BT.inorderIterative();			//prints tree in order(iteratively)
					System.out.println("\n_____________________");
					setnum++;				//increment tree set count
				}
			}
		
			catch (Exception e) {		//error prints trace if anything goes wrong. nfe,io
				e.printStackTrace();
			
			}	
		} 
	}
		
}