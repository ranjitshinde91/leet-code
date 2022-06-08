package other.next_right_pointer;

import org.junit.jupiter.api.Test;
import other.next_right_pointer.Node;
import other.next_right_pointer.Solution;

import static org.assertj.core.api.Assertions.assertThat;

class NextRightPointerTest {

    @Test
    void test1() {
        var solution = new Solution();

        Node root = solution.connect(null);

        assertThat(root).isNull();

    }

    @Test
    void test2() {

        var solution = new Solution();

        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);

        two.left = four;
        two.right = five;
        three.left = six;
        three.right = seven;
        one.left = two;
        one.right = three;

        Node root = solution.connect(one);

        assertThat(root.next).isNull();
        assertThat(root.left.next.val).isEqualTo(3);
        assertThat(root.right.next).isNull();
        assertThat(root.left.left.next.val).isEqualTo(5);
        assertThat(root.left.right.next.val).isEqualTo(6);
        assertThat(root.right.left.next.val).isEqualTo(7);
        assertThat(root.right.right.next).isNull();
    }

    @Test
    void test3() {
        var solution = new Solution();
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);

        one.left = two;
        one.right = three;

        Node root = solution.connect(one);

        assertThat(root.next).isNull();
        assertThat(root.left.next.val).isEqualTo(3);
        assertThat(root.right.next).isNull();
    }

    @Test
    void test4() {
        var solution = new Solution();
        Node one = new Node(1);

        Node root = solution.connect(one);

        assertThat(root.next).isNull();
    }

    @Test
    void test5() {

        var solution = new Solution();

        Node negativeOne = new Node(-1);
        Node zero = new Node(0);
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);
        Node eight = new Node(8);
        Node nine = new Node(9);
        Node ten = new Node(10);
        Node eleven = new Node(11);
        Node twelve = new Node(12);
        Node thirteen = new Node(13);

        negativeOne.left = zero;
        negativeOne.right = one;

        zero.left = two;
        zero.right = three;

        one.left = four;
        one.right = five;

        two.left = six;
        two.right = seven;
        three.left = eight;
        three.right = nine;

        four.left = ten;
        four.right = eleven;
        five.left = twelve;
        five.right = thirteen;

        Node root = solution.connect(negativeOne);

        assertThat(root.next).isNull();

        assertThat(root.left.next.val).isEqualTo(1);
        assertThat(root.right.next).isNull();

        assertThat(root.left.left.next.val).isEqualTo(3);
        assertThat(root.left.right.next.val).isEqualTo(4);
        assertThat(root.right.left.next.val).isEqualTo(5);
        assertThat(root.right.right.next).isNull();

        assertThat(root.left.left.left.next.val).isEqualTo(7);
        assertThat(root.left.left.right.next.val).isEqualTo(8);
        assertThat(root.left.right.left.next.val).isEqualTo(9);
        assertThat(root.left.right.right.next.val).isEqualTo(10);
        assertThat(root.right.left.left.next.val).isEqualTo(11);
        assertThat(root.right.left.right.next.val).isEqualTo(12);
        assertThat(root.right.right.left.next.val).isEqualTo(13);
        assertThat(root.right.right.right.next).isNull();
    }

}