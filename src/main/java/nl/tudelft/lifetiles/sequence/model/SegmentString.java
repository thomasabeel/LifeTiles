package nl.tudelft.lifetiles.sequence.model;

/**
 * Segment content with as content a string.
 *
 * @author Jos
 *
 */
public class SegmentString implements SegmentContent {

    /**
     * content of the segment content.
     */
    private String contentVar;

    /**
     * Constructs a sequence segment with given string as content.
     *
     * @param content
     *            + * String to be set as content of the sequence segment.
     */
    public SegmentString(final String content) {
        contentVar = content;
    }

    /**
     * @return length of the string content in the segment.
     */
    @Override
    public final long getLength() {
        return contentVar.length();
    }

    /**
     * @return string representation of the empty segment.
     */
    public final String toString() {
        return contentVar;
    }

    /**
     * @return that the segment content is not an empty node.
     */
    @Override
    public final boolean isEmpty() {
        return false;
    }

}