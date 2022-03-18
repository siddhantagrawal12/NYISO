package CatMouse;

import org.junit.Assert;
import org.junit.Test;

import static CatMouse.CatMouse.catmouse;

public class CatMouseTest {
    //Test Cases:

    //Test Case 1 - All three animals are not present
    @Test
    public void test_noCatnoDognoMouse() {
        Assert.assertEquals("boring without all three", catmouse(".......................", 5));
    }

    //Test Case 2 - Cat and Dog are not present
    @Test
    public void test_noCatnoDog() {
        Assert.assertEquals("Escaped, NO CAT NO DOG!", catmouse("..........m......", 10));
    }
    
    //Test Case 3 - Cat and mouse are not present
    @Test
    public void test_noCatnoMouse() {
        Assert.assertEquals("Boring, NO CAT NO MOUSE!", catmouse("..........D......", 10));
    }

    //Test Case 4 - Dog and mouse are not present
    @Test
    public void test_noDognoMouse() {
        Assert.assertEquals("Boring, NO DOG NO MOUSE!", catmouse(".....C....", 8));
    }

    //Test Case 5 - mouse is not present
    @Test
    public void test_noMouse() {
        Assert.assertEquals("Boring, NO MOUSE!", catmouse(".....C............D......", 9));
    }

    //Test Case 6 - Cat is not present
    @Test
    public void test_noCat() {
        Assert.assertEquals("Escaped, NO CAT!", catmouse("...m............D", 10));
    }

    //Test Case 7 - Cat caught the mouse!
    @Test
    public void test_caught_noDog() {
        Assert.assertEquals("Caught!", catmouse("..C.....m.", 5));
    }

    //Test Case 8 - mouse escaped!
    @Test
    public void test_escaped_NotEnoughJump() {
        Assert.assertEquals("Escaped!", catmouse(".....C............m......", 5));
    }

    //Test Case 9 - Cat caught the mouse!
    @Test
    public void test_caught() {
        Assert.assertEquals("Caught!", catmouse("...m.........C...D", 10));
    }

    //Test Case 10 - Dog is between the mouse and Cat (mouse, Dog, Cat)
    @Test
    public void test_Protected_mDC() {
        Assert.assertEquals("Protected!", catmouse("...m....D....C.......", 10));
    }

    //Test Case 11 - Dog is between the Cat and mouse (Cat, Dog, mouse)
    @Test
    public void test_Protected_CDm() {
        Assert.assertEquals("Protected!", catmouse("...C....D....m.......", 10));
    }

    //Test Case 12 - mouse escaped!
    @Test
    public void test_escaped_BehindTheCat() {
        Assert.assertEquals("Escaped!", catmouse("...m................C..D.....", 8));
    }
}
