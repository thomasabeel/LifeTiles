package nl.tudelft.lifetiles.graph;

import java.util.Set;

/**
 * @author Rutger van den Berg Contains a partial sequence.
 */
public class SequenceSegment {
    /**
     * Contains the sources containing this segment.
     */
    private Set<Sequence> sourcesVar;

    /**
     * The start position for this segment.
     */
    private long startVar;
    /**
     * The end position for this segment.
     */
    private long endVar;
    /**
     * The content of this segment.
     */
    private String contentVar;

    /**
     * @param sources
     *            The sources containing this segment.
     * @param startPosition
     *            The start position for this segment.
     * @param endPosition
     *            The end position for this segment.
     * @param content
     *            The content for this segment.
     */
    public SequenceSegment(final Set<Sequence> sources,
            final long startPosition, final long endPosition,
            final String content) {
        sourcesVar = sources;
        startVar = startPosition;
        endVar = endPosition;
        contentVar = content;
    }

    /**
     * @return the sources
     */
    public final Set<Sequence> getSources() {
        return sourcesVar;
    }

    /**
     * @return the start position
     */
    public final long getStart() {
        return startVar;
    }

    /**
     * @return the end position
     */
    public final long getEnd() {
        return endVar;
    }

    /**
     * @return the content
     */
    public final String getContent() {
        return contentVar;
    }
}