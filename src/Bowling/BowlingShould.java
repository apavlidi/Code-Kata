package Bowling;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class BowlingShould {

    private Bowling bowling;

    @BeforeTest
    public void set_up() {
        bowling = new Bowling();
    }

    @Test
    public void
    calculate_score_for_pins() {
        assertEquals(bowling.score("0"), 0);
        assertEquals(bowling.score("1"), 1);
        assertEquals(bowling.score("2"), 2);
        assertEquals(bowling.score("23"), 5);
        assertEquals(bowling.score("237"), 12);
    }

    @Test
    public void
    calculate_score_for_miss() {
        assertEquals(bowling.score("-"), 0);
        assertEquals(bowling.score("1-"), 1);
        assertEquals(bowling.score("9-9"), 18);
        assertEquals(bowling.score("9-9-9-9-9-9-9-9-9-9-"), 90);
    }

    @Test
    public void
    calculate_score_for_spares() {
        assertEquals(bowling.score("3/-"), 10);
        assertEquals(bowling.score("3/5/-"), 25);
        assertEquals(bowling.score("7/7/7/7/7/7/7/7/7/-"), 146);
        assertEquals(bowling.score("5/5/5/5/5/5/5/5/5/5/5"), 150);
    }

    @Test
    public void
    calculate_score_for_strikes() {
        assertEquals(bowling.score("X"), 10);
        assertEquals(bowling.score("X52"), 24);
        assertEquals(bowling.score("X52X13"), 42);
        assertEquals(bowling.score("XXXXXXXXXXXX"), 300);
    }

    @Test
    public void
    calculate_score_for_spares_and_strikes() {
        assertEquals(bowling.score("1/X1/2"), 54);
    }

    @Test
    public void
    calculate_score_last_frame() {
        assertEquals(bowling.score("1/35XXX458/X3/XX6"), 189);
    }


}
