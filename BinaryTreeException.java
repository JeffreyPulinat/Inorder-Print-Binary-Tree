public class BinaryTreeException extends RuntimeException{
	/**
	 * serialization runtime associates with each serializable class a version number
	 * serialVersionUID,is needed
	 */
	private static final long serialVersionUID = 1L;

	public BinaryTreeException(String err){
			super (err);			//uses runtimeexception error
	}
}
