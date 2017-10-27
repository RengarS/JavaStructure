package com.aries.datastructure;

/**
 * @author create by aries
 */
public class BinaryTree {
    public TreeNode root;
    private static int count = 0;

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.addNode(1).addNode(2).addNode(3).addNode(4);
        tree.addNode(0).addNode(-1).addNode(-2);
        tree.inOrder(tree.root);
        tree.findInTree(tree.root, 3);
    }

    /**
     * 添加节点
     *
     * @param data
     */
    public BinaryTree addNode(int data) {
        //当树为空
        if (this.root == null) {
            root = new TreeNode(data);
            return this;
        }
        TreeNode current = root;
        while (true) {
            //如果data小于当前节点的值，go left
            if (data < current.data) {
                //如果当前节点的左子节点为空
                if (current.leftChild == null) {
                    current.leftChild = new TreeNode(data);
                    return this;
                } else {
                    //不为空，继续go left
                    current = current.leftChild;
                }
            } else {
                //如果data大于等于当前节点的值，go right
                if (current.rightChild == null) {
                    //如过当前节点的右子节点为空
                    current.rightChild = new TreeNode(data);
                    return this;
                } else {
                    // 不为空继续go right
                    current = current.rightChild;
                }
            }
        }
    }

    /**
     * 中序遍历
     *
     * @param node
     */
    public void inOrder(TreeNode node) {
        if (node != null) {
            inOrder(node.leftChild);
            System.out.println(node.data);
            inOrder(node.rightChild);
        }
    }

    /**
     * 搜索
     *
     * @param node
     * @param data
     */
    public boolean findInTree(TreeNode node, int data) {
        if (node == null) {
            return false;
        } else if (node.data == data) {
            System.out.println("共搜索了：" + count + "次");
            return true;
        } else if (data < node.data) {
            count += 1;
            findInTree(node.leftChild, data);
        } else {
            count += 1;
            findInTree(node.rightChild, data);
        }
        return false;
    }
}

class TreeNode {
    int data;
    TreeNode leftChild;
    TreeNode rightChild;

    public TreeNode(int data) {
        this.data = data;
        this.leftChild = null;
        this.rightChild = null;
    }
}