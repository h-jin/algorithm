package algorithm;
import algorithm.TreeNode;

public class BinaryTree {

	public boolean isBalance(TreeNode root){
		if(root == null){
			return true;
			
		}
		if(root.right==null&& root.left==null){
			return true;
			
		}
		if(root.right!=null && root.left==null){
			root = root.right;
			if(root.right==null&& root.left==null){
				return true;
				
			}
			else  return false;
			
		}
		if(root.right==null && root.left!=null){
			root = root.left;
			if(root.right==null&& root.left==null){
				return true;
				
			}
			else  return false;
			
		}
		if(root.right!=null && root.left!=null){
			boolean flag1 = isBalance(root.right);
			boolean flag2 = isBalance(root.left);
			if(!flag1&&flag2){
				return false;
				
			}else{
				int x = Math.abs(Depth(root.right)-Depth(root.left));
				if(x >1){
					
					return false;
				}else{
					return true;
				}
			}
			
		}
		return true;
		
	}

	private int Depth(TreeNode root) {
		if(root == null){
			return 0;
			
		}
		if(root.right==null && root.left==null){
			return 1;
			
		}
		if(root.right!=null && root.left==null){
			root = root.right;
			return Depth(root)+1;
			
		}
		if(root.right==null && root.left!=null){
			root = root.left;
			return Depth(root)+1;
			
		}
		if(root.right!=null && root.left!=null){
			
			return Math.max(Depth(root.right), Depth(root.left))+1;
			
		}
		
		return 0;
	}
	
	
}
