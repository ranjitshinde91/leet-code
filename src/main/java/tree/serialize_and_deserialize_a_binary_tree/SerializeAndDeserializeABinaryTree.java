package tree.serialize_and_deserialize_a_binary_tree;

import tree.Node;

import java.util.ArrayList;

public class SerializeAndDeserializeABinaryTree {

    public void serialize(Node root, ArrayList<Integer> list) {
        if (root == null) {
            list.add(-1);
            return;
        }
        list.add(root.data);
        serialize(root.left, list);
        serialize(root.right, list);
    }

    private int index = 0;
    public Node deSerialize(ArrayList<Integer> list) {
        if (index == list.size()) {
            return null;
        }
        int val = list.get(index);
        index++;
        if (val == -1) {
            return null;
        }
        Node node = new Node(val);
        node.left = deSerialize(list);
        node.right = deSerialize(list);

        return node;
    }
}
