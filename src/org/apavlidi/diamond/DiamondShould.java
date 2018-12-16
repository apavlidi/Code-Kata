package org.apavlidi.diamond;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DiamondShould {

    private Diamond diamond;

    @BeforeTest
    public void
    set_up() {
        diamond = new Diamond();
    }

    @Test
    public void
    return_diamond_for_A() {
        assertEquals(diamond.print('A'), "A\n");
    }

    @Ignore
    @Test
    public void
    B_should_give_character_sequence() {
        assertEquals(diamond.print('B'), "AB");
    }

    @Ignore
    @Test
    public void
    B_should_give_repeat_characters() {
        assertEquals(diamond.print('B'), "ABB");
    }

    @Ignore
    @Test
    public void
    B_should_have_separate_lines() {
        assertEquals(diamond.print('B'), "A\nB B");
    }

    @Ignore
    @Test
    public void
    C_should_have_separate_lines() {
        assertEquals(diamond.print('C'), "A\nB B\nC  C");
    }

    @Ignore
    @Test
    public void
    D_should_have_separate_lines() {
        assertEquals(diamond.print('D'), "A\nB B\nC  C\nD   D");
    }

    @Ignore
    @Test
    public void
    C_should_return_diamond_without_outer_spaces() {
        assertEquals(diamond.print('C'), "A\nB B\nC  C\nB B\nA");
    }

    @Test
    public void
    B_should_return_diamond() {
        assertEquals(diamond.print('B'), " A\nB B\n A");
    }

    @Test
    public void
    C_should_return_diamond() {
        assertEquals(diamond.print('C'), "  A\n B B\nC   C\n B B\n  A");
    }

    @Test
    public void
    D_should_return_diamond() {
        assertEquals(diamond.print('D'), "   A\n  B B\n C   C\nD     D\n C   C\n  B B\n   A");
    }

}
