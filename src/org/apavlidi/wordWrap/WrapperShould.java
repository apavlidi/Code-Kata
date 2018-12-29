package org.apavlidi.wordWrap;

import org.junit.jupiter.api.Test;

import static org.apavlidi.wordWrap.Wrapper.wrap;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class WrapperShould {

    @Test
    public void emptyString() {
        assertThat(Wrapper.wrap("", 1), equalTo(""));
    }

    @Test
    public void stringShorterThanCol() {
        assertThat(wrap("this", 10), equalTo("this"));
    }

    @Test
    public void wrapAfterWordBoundary() {
        assertThat(wrap("word word", 6), equalTo("word\nword"));
    }

    @Test
    public void wrapWellBeforeWordBoundary() {
        assertThat(wrap("word word", 3), equalTo("wor\nd\nwor\nd"));
    }

    @Test
    public void wrapJustBeforeWordBoundary() {
        assertThat(wrap("word word", 4), equalTo("word\nword"));
    }

    @Test
    public void wrapOnWordBoundary() {
        assertThat(wrap("word word", 5), equalTo("word\nword"));
    }

}
