package org.apavlidi.twitter;

import java.util.List;
import java.util.Objects;

public class Timeline {

  private final String username;
  private final List<String> messages;

  public Timeline(String username, List<String> messages) {
    this.username = username;
    this.messages = messages;
  }

  public String getUsername() {
    return username;
  }

  public List<String> getMessages() {
    return messages;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Timeline timeline = (Timeline) o;
    return Objects.equals(username, timeline.username) &&
        Objects.equals(messages, timeline.messages);
  }

  @Override
  public int hashCode() {
    return Objects.hash(username, messages);
  }
}
