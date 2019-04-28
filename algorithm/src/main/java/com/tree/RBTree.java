package com.tree;

/**
 * Created by GD on 2019/4/11.
 */

/**
 *
 * @Description TODO
 * @Author GD
 * @Date 2019/4/11 22:54
 * @Version 1.0V
 */

public class RBTree<T extends Comparable> {


    private RBTNode<T> root; // 根节点

    private static final boolean RED = false;
    private static final boolean BLACK = true;

    private void put(RBTNode<T> node){

    }

    public void put(T key){
        RBTNode node = new RBTNode(true,key,null,null,null);
        put(node);
    }

    /*
     * 对红黑树的节点(x)进行左旋转
     *
     * 左旋示意图(对节点x进行左旋)：
     *      px                              px
     *     /                               /
     *    x                               y
     *   /  \      --(左旋)-.           / \                #
     *  lx   y                         x  ry
     *     /   \                      / \
     *    ly   ry                    lx ly
     *
     *
     */
    private void leftRotare(RBTNode<T> x){
        // 1. 提取出有节点y
        RBTNode<T> y = x.right;
        // 2. 设置x 的右节点
        x.right = y.left;
        // 3. 如果y 的左节点不是空，则要设置做节点的parent
        if(y.left != null){
            y.left.parent = x;
        }
        // 4. 设置y 连接x 的父亲节点
        y.parent = x.parent;
        // 5. 设置元x 的父亲节点的子节点，判断x 节点是的节点位置，进行设置
        if(x.parent == null){
            this.root = y;
        }else if(x.parent.left == x){
            x.parent.left = y;
        }else{
            x.parent.right = y;
        }
        // 6. 将 “x” 设为 “y的左孩子”
        y.left = x;
        // 7. 将 “x的父节点” 设为 “y”
        x.parent = y;
    }
    /*
     * 对红黑树的节点(y)进行右旋转
     *
     * 右旋示意图(对节点y进行左旋)：
     *            py                               py
     *           /                                /
     *          y                                x
     *         /  \      --(右旋)-.            /  \                     #
     *        x   ry                           lx   y
     *       / \                                   / \                   #
     *      lx  rx                                rx  ry
     *
     */
    private void rightRotate(RBTNode<T> y) {
        RBTNode<T> x = y.left;
        y.left = x.right;
        if(y.left != null){
            y.left.parent = y;
        }
        x.parent = y.parent;
        if(y.parent == null){
            this.root = x;
        }else if(y.parent.right == y){
            y.parent.right = x;
        }else{
            y.parent.left = x;
        }
        x.right = y;
        y.parent = x;
    }


    class RBTNode<T extends Comparable>{
        boolean color;
        T key;
        RBTNode<T> left;
        RBTNode<T> right;
        RBTNode<T> parent;

        public RBTNode(boolean color, T key, RBTNode<T> left, RBTNode<T> right, RBTNode<T> parent) {
            this.color = color;
            this.key = key;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }
    }

    /**
     * //前序遍历递归的方式
     * @param node
     */
    public void preOrder(RBTNode<T> node){
        if(node == null){
            return ;
        }
        System.out.println(node);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * //中序遍历采用递归的方式
     * @param node
     */
    public void inOrder(RBTNode<T> node){
        if(node == null){
            return ;
        }
        inOrder(node.left);
        System.out.println(node);
        inOrder(node.right);
    }

    /**
     * //后序遍历采用递归的方式
     * @param node
     */
    public void postOrder(RBTNode<T> node){
        if(node == null){
            return ;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node);
    }

}
