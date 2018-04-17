package JZOffer.Tree;
/*题目：输入某二叉树的前序遍历和中序遍历结果，请重建该二叉树。
（假设输入的前序遍历和中序遍历的结果中都不包含重复的数字）*/

/*思路：在二叉树的前序遍历中，第一个数字总是树的根节点的值；
在中序遍历中，根节点的值在序列的中间，左子树节点的值位于根节点的值的左边；
而右子树的节点的值位于根节点的值的右边。因此，我们需要扫描中序遍历序列，才能找到根节点的值。
这样我们就在前序遍历和中序遍历两个序列中，分别找到了左右子树对应的子序列。（接下来通过递归即可）*/


public class ConstructBinaryTree {
    BinaryTreeNode Construct(int[] preorder,int[] inorder,int length){
        if(preorder == null || inorder == null|| length < 0){
            return null;
        }
        return
    }
    BinaryTreeNode ConstructCore(int[] preorder,int[] inorder){
        
    }
}
