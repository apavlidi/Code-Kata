package org.apavlidi.twitter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwitterRepository {

  List<Timeline> timelines = new ArrayList<>();
  Map<String, List<String>> followers = new HashMap<>();

  public void publish(String publisherUsername, String message) {
    boolean userExists = false;

    for (Timeline timelineUsername : timelines) {
      if (publisherUsername.equals(timelineUsername.getUsername())) {
        timelineUsername.getMessages().add(message);
        userExists = true;
      }
    }

    if (!userExists) {
      createUser(publisherUsername, message);
    }

  }

  public List<String> read(String username) {
    return timeline(username);
  }

  public List<Timeline> wall(String username) {
    List<String> usernamesFollowed = getFollowersUsername(username);
    List<Timeline> timelinesFollowed = new ArrayList<>();

    for (String usernameFollowed : usernamesFollowed) {
      for (int i = 0; i < timelines.size(); i++) {
        if (timelines.get(i).getUsername().equals(usernameFollowed)) {
          timelinesFollowed.add(timelines.get(i));
        }
      }
    }

    return timelinesFollowed;
  }

  public void follow(String usernameWhoFollows, String usernameToBeFollowed) {

    for (String username : followers.keySet()) {
      if (usernameWhoFollows.equals(username)) {
        followers.get(usernameWhoFollows).add(usernameToBeFollowed);
      }
    }

  }

  public List<String> followers(String username) {
    return getFollowersUsername(username);
  }

  private List<String> getFollowersUsername(String username) {
    List<String> followersUsernames = new ArrayList<>();
    for (String usernameKey : followers.keySet()) {
      if (username.equals(usernameKey)) {
        followersUsernames = followers.get(usernameKey);
      }
    }

    return followersUsernames;
  }

  public List<String> timeline(String username) {
    List<String> messages = new ArrayList<>();

    for (Timeline timelineUsername : timelines) {
      if (username.equals(timelineUsername.getUsername())) {
        messages.addAll(timelineUsername.getMessages());
      }
    }

    return messages;
  }

  private Timeline createTimeline(String username) {
    return new Timeline(username, new ArrayList<>());
  }

  private void createUser(String publisherUsername, String message) {
    Timeline newUser = createTimeline(publisherUsername);
    newUser.getMessages().add(message);
    timelines.add(newUser);
    ArrayList<String> usernameFollowers = new ArrayList<>();
    usernameFollowers.add(publisherUsername);
    followers.put(publisherUsername, usernameFollowers);
  }
}
