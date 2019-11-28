package org.apavlidi.stack;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.EmptyStackException;
import org.junit.Before;
import org.junit.Test;

public class StackShould {

  public static final String SOME_OBJECT = "SOME OBJECT";
  public static final String ANOTHER_OBJECT = "ANOTHER OBJECT";
  private Stack stack;

  @Before
  public void initialise() {
    stack = new Stack();
  }

  @Test(expected = EmptyStackException.class)
  public void throw_an_exception_if_there_are_no_items() {
    stack.pop();
  }

  @Test
  public void pop_the_last_object_pushed() {
    stack.push(SOME_OBJECT);

    assertThat(stack.pop(), is(SOME_OBJECT));
  }

  @Test
  public void pop_objects_in_the_reverse_order_they_were_pushed() {
    stack.push(SOME_OBJECT);
    stack.push(ANOTHER_OBJECT);

    assertThat(stack.pop(), is(ANOTHER_OBJECT));
    assertThat(stack.pop(), is(SOME_OBJECT));
  }

  @Test(expected = EmptyStackException.class)
  public void remove_the_items_from_its_storage() {
    stack.push(SOME_OBJECT);
    stack.push(ANOTHER_OBJECT);

    stack.pop();
    stack.pop();
    stack.pop();
  }

}
