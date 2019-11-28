package org.apavlidi.twitter;

import java.util.List;

public class StatementPrinter {

  private Console console;

  public StatementPrinter(Console console) {
    this.console = console;
  }

  public void printTimeline(Timeline timeline) {
    for (String message : timeline.getMessages()) {
      console.print(message);
    }
  }

  public void printWall(List<Timeline> timelines) {
    for (Timeline timeline : timelines) {
      for (String message : timeline.getMessages()) {
        console.print(message);
      }
    }
  }
}
