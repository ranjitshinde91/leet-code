package stack.two_stacks_in_an_array;

import org.junit.jupiter.api.Test;

class TwoStacksInAnArrayTest {

    @Test
    void test1() {

        Stacks stacks = new Stacks();

        TwoStack twoStack = new TwoStack();
        stacks.push1(2, twoStack);
        stacks.push1(3, twoStack);
        stacks.push2(4, twoStack);

        stacks.pop1(twoStack);
        stacks.pop1(twoStack);
        stacks.pop1(twoStack);
        stacks.pop1(twoStack);
        stacks.pop2(twoStack);
        stacks.pop2(twoStack);

        System.out.println(twoStack.top1);
        System.out.println(twoStack.top2);

    }

}