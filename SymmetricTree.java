package algorithm;
import algorithm.TreeNode;

public class SymmetricTree {
	
	public boolean isSymmetric(TreeNode root) {
		if(root==null) return true;
		if(root.left==null&&root.right==null) return true;
		if(root.left==null||root.right==null||root.left.val!=root.right.val) return false;
		return(isSubSymmetric(root.left,root.right));
		       
    }
	
	public boolean isSubSymmetric(TreeNode left_root, TreeNode right_root){
		if(left_root.val!=right_root.val) return false;
		TreeNode left_left = left_root.left;
		TreeNode left_right = left_root.right;
		TreeNode right_left =  right_root.left;
		TreeNode right_right = right_root.right;
		if(left_left==null&&left_right==null&&right_left==null&&right_right==null) return true;
		else if(left_left==null&&right_right==null&&left_right!=null&&right_left!=null) {
			
			return isSubSymmetric(left_right,right_left);	
		
		}else if(left_left!=null&&right_right!=null&&left_right==null&&right_left==null) {
			
			return isSubSymmetric(left_left,right_right);				
		}
		else if(left_left!=null&&left_right!=null&&right_left!=null&&right_right!=null&&
				left_left.val==right_right.val&&left_right.val== right_left.val){
			return (isSubSymmetric(left_left,right_right)&&isSubSymmetric(left_right,right_left));
		}else {
			return false;
		}				
	}
	
}
