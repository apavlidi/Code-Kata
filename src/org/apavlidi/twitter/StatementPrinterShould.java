package org.apavlidi.twitter;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class StatementPrinterShould {

  @Mock
  private Console console;

  private StatementPrinter statementPrinter;

  @Before
  public void initialise() {
    statementPrinter = new StatementPrinter(console);
  }

  @Test
  public void print_timeline() {
    statementPrinter.printTimeline(
        new Timeline("Alice", Collections.singletonList("I love the weather today")));

    verify(console).print("I love the weather today");
  }

  @Test
  public void print_wall() {
    List<Timeline> timelines = new ArrayList<>();
    timelines.add(new Timeline("Alice", Collections.singletonList("I love the weather today")));
    timelines.add(new Timeline("Charlie", Arrays.asList(
            "I'm in New York today! Anyone wants to have a coffee?"
            ,"Good game though.")));
    statementPrinter.printWall(timelines);

    InOrder inOrder = Mockito.inOrder(console);
    inOrder.verify(console).print("I love the weather today");
    inOrder.verify(console).print("I'm in New York today! Anyone wants to have a coffee?");
    inOrder.verify(console).print("Good game though.");
  }
}