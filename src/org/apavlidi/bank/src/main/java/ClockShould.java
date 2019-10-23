package org.apavlidi.bank.src.main.java;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

public class ClockShould {

  public static final String TODAY = "24/04/2015";
  private Clock clock;

  @Before
  public void initialise() {
    clock = new TestableClock();
  }

  @Test
  public void return_todays_date_as_dd_MM_yyyy() {
    String date = clock.getCurrentDate();

    assertThat(date, is(TODAY));
  }

  private class TestableClock extends Clock {

    @Override
    protected LocalDate today() {
      return LocalDate.of(2015, 4, 24);
    }
  }
}