package stack.min_stack;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class MinStackTest {

  @Test
  void test() {
    var minStack = new MinStack();

    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);

    assertThat(minStack.getMin()).isEqualTo(-3);

    minStack.pop();
    assertThat(minStack.top()).isEqualTo(0);
    assertThat(minStack.getMin()).isEqualTo(-2);
  }
}
