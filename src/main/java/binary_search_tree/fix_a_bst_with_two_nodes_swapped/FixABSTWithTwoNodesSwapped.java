package binary_search_tree.fix_a_bst_with_two_nodes_swapped;

import tree.Node;

public class FixABSTWithTwoNodesSwapped {

    private Node previous = null;
    private Node first = null;
    private Node second = null;

    public Node correctBST(Node root)
    {
        findNodes(root);
        if(first != null && second != null){
            int temp = first.data;
            first.data = second.data;
            second.data = temp;
        }
        return root;
    }

    private void findNodes(Node node){
        if(node != null){
            findNodes(node.left);

            if(previous != null && node.data < previous.data){
                if(first == null){
                    this.first = previous;
                }
                this.second = node;
            }
            previous = node;
            findNodes(node.right);
        }
    }

}
