package nl.tudelft.lifetiles.graph.model.jgrapht;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import nl.tudelft.lifetiles.graph.model.FactoryProducer;
import nl.tudelft.lifetiles.graph.model.Graph;
import nl.tudelft.lifetiles.graph.model.GraphFactory;
import nl.tudelft.lifetiles.sequence.model.DefaultSequence;
import nl.tudelft.lifetiles.sequence.model.SegmentEmpty;
import nl.tudelft.lifetiles.sequence.model.Sequence;
import nl.tudelft.lifetiles.sequence.model.SequenceSegment;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class SubGraphAdapterTest {
    GraphFactory<SequenceSegment> gf;
    static FactoryProducer<SequenceSegment> fp;
    SequenceSegment v1, v2, v3, v4;
    Graph<SequenceSegment> gr;
    Graph<SequenceSegment> subgr;
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @BeforeClass
    public static void runOnce() {
        fp = new FactoryProducer<SequenceSegment>();
    }

    @Before
    public void setUp() throws Exception {
        gf = fp.getFactory("JGraphT");

        Sequence s = new DefaultSequence("this");

        HashSet<Sequence> testt = new HashSet<Sequence>();
        testt.add(s);

        v1 = new SequenceSegment(testt, 0, 2, new SegmentEmpty(2));
        v2 = new SequenceSegment(new HashSet<Sequence>(), 1, 4,
                new SegmentEmpty(3));
        v3 = new SequenceSegment(new HashSet<Sequence>(), 3, 5,
                new SegmentEmpty(2));
        v4 = new SequenceSegment(new HashSet<Sequence>(), 1, 3,
                new SegmentEmpty(2));
        gr = gf.getGraph();

        s.appendSegment(v1);
        s.appendSegment(v2);
    }

    @Test
    public void testEmptyGraph() {
        subgr = gf.getSubGraph(gr, null);
        assertEquals(subgr.getAllVertices().size(), gr.getAllVertices().size());
        assertEquals(subgr.getAllEdges().size(), gr.getAllEdges().size());
    }

    @Test
    public void testGraphVertices() {
        gr.addVertex(v1);
        gr.addVertex(v2);
        subgr = gf.getSubGraph(gr, null);
        assertEquals(subgr.getAllVertices().size(), gr.getAllVertices().size());
    }

    @Test
    public void testGraphEdges() {
        gr.addVertex(v1);
        gr.addVertex(v2);
        gr.addEdge(v1, v2);
        subgr = gf.getSubGraph(gr, null);
        assertEquals(subgr.getAllEdges().size(), gr.getAllEdges().size());
    }

    @Test
    public void testSubsetVertices() {
        gr.addVertex(v1);
        gr.addVertex(v2);
        gr.addVertex(v3);

        Set<SequenceSegment> cpy = new TreeSet<SequenceSegment>();
        cpy.addAll(gr.getAllVertices());
        cpy.remove(v3);
        cpy.remove(v2);

        subgr = gf.getSubGraph(gr, cpy);

        assertEquals(subgr.getAllVertices().size(),
                gr.getAllVertices().size() - 2);

    }

    @Test
    public void testSubsetVerticesEdges() {
        gr.addVertex(v1);
        gr.addVertex(v2);
        gr.addVertex(v3);
        gr.addEdge(v1, v3);
        gr.addEdge(v2, v3);

        Set<SequenceSegment> cpy = new TreeSet<SequenceSegment>();
        cpy.addAll(gr.getAllVertices());
        cpy.remove(v3);

        subgr = gf.getSubGraph(gr, cpy);

        assertEquals(subgr.getAllEdges().size(), gr.getAllEdges().size() - 2);
    }

    @Test
    public void testCopyVertices() {
        gr.addVertex(v1);
        gr.addVertex(v2);
        gr.addVertex(v3);

        Set<SequenceSegment> cpy = new TreeSet<SequenceSegment>();
        cpy.addAll(gr.getAllVertices());

        subgr = gf.getSubGraph(gr, cpy);
        subgr = subgr.deepcopy(gf);

        assertTrue(gr.getAllVertices().containsAll(subgr.getAllVertices()));
    }

    @Test
    public void testCopyEdges() {
        gr.addVertex(v1);
        gr.addVertex(v2);
        gr.addVertex(v3);
        gr.addEdge(v1, v3);
        gr.addEdge(v2, v3);

        Set<SequenceSegment> cpy = new TreeSet<SequenceSegment>();
        cpy.addAll(gr.getAllVertices());
        subgr = gf.getSubGraph(gr, cpy);
        subgr = subgr.deepcopy(gf);

        assertTrue(gr.getAllEdges().containsAll(subgr.getAllEdges()));

    }

}
