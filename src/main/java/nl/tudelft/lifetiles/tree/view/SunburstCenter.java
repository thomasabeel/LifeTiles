package nl.tudelft.lifetiles.tree.view;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import nl.tudelft.lifetiles.sequence.SequenceColor;
import nl.tudelft.lifetiles.sequence.model.Sequence;
import nl.tudelft.lifetiles.tree.model.PhylogeneticTreeItem;

/**
 * A sunburstCenter represents the node that is displayed in the center.
 *
 * @author Albert Smit
 *
 */
public class SunburstCenter extends AbstractSunburstNode {

    /**
     * Generates an empty SunburstCenter.
     */
    public SunburstCenter() {
        setDisplay(new Circle(CENTER_RADIUS, Color.BLUE));
        getChildren().add(getDisplay());
    }

    /**
     * Generates a SunburstCenter for the node.
     *
     * @param value
     *            the node that this will represent
     */
    public SunburstCenter(final PhylogeneticTreeItem value) {
        setValue(value);
        setDisplay(new Circle(CENTER_RADIUS, createColor()));
        setName(new Text(getValue().getName()));
        this.getChildren().addAll(getDisplay(), getName());
    }

    /**
     * Creates a {@link Color} for this node. the color will be blue by default,
     * and the color associated with the sequence when the node has a sequence.
     *
     * @return a Color object that specifies what color this node will be.
     */
    private Color createColor() {
        Sequence sequence = getValue().getSequence();
        if (sequence == null) {
            return Color.BLUE;
        } else {
            return SequenceColor.getColor(sequence);
        }
    }

}
