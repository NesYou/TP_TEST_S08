package type;


/**
 * Created by YohanBoichut on 12/10/2016.
 */
public abstract class Naturel extends StructureVisitable {

    public abstract Naturel succ();

    public abstract Naturel add(Naturel y);

    public abstract Naturel minus(Naturel y);

    public abstract boolean geq(Naturel y);

    public abstract boolean egalite(Naturel y);
}
