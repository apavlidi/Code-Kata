package org.apavlidi.stack;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class Stack {

  private List<String> stack = new ArrayList<>();

  public String pop() {
    if (stack.isEmpty()) {
      throw new EmptyStackException();
    }
    return stack.remove(stack.size() - 1);
  }

  public void push(String item) {
    stack.add(item);
  }
}
