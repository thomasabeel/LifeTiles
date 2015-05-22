package nl.tudelft.lifetiles.graph.models.sequence;

import static org.junit.Assert.assertEquals;
import nl.tudelft.lifetiles.graph.view.Mutation;

import org.junit.Before;
import org.junit.Test;

public class SequenceSegmentTest {

    SequenceSegment v1, v2, v3;

    @Before
    public void setUp() throws Exception {
        v1 = new SequenceSegment(null, 1, 10, new SegmentString("AAAAAAAAAA"));
        v1.setUnifiedStart(1);
        v1.setUnifiedEnd(10);
        v2 = new SequenceSegment(null, 11, 20, new SegmentEmpty(10));
        v2.setUnifiedStart(11);
        v2.setUnifiedEnd(20);
        v3 = new SequenceSegment(null, 21, 30, new SegmentString("AAAAAAAAAA"));
        v3.setUnifiedStart(21);
        v3.setUnifiedEnd(30);
    }

    @Test
    public void testDistanceToAdjacent() {
        assertEquals(0, v1.distanceTo(v2));
    }

    @Test
    public void testDistanceToPositive() {
        assertEquals(10, v1.distanceTo(v3));
    }

    @Test
    public void testDistanceToNegative() {
        assertEquals(-30, v3.distanceTo(v1));
    }

    @Test
    public void testLengthEmpty() {
        assertEquals(10, v2.getContent().getLength());
    }

    @Test
    public void testLengthString() {
        assertEquals(10, v1.getContent().getLength());
    }

    @Test
    public void testMutation() {
        Mutation insertion = Mutation.INSERTION;
        v1.setMutation(insertion);
        assertEquals(insertion, v1.getMutation());
    }

    @Test
    public void testCompare() {
        assertEquals(-1, v1.compareTo(v2));
    }
}
