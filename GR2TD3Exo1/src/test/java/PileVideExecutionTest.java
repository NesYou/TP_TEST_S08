import exceptions.PileVideException;
import exceptions.UnSeulElementException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PileVideExecutionTest {

    PileVideExecution pileVideExecution;

    @Before
    public void setPileVideExcution() {
        pileVideExecution = new PileVideExecution();
    }

    @Test(expected = PileVideException.class)
    public void getTail() throws PileVideException {
        pileVideExecution.getTail();
    }

    @Test(expected = PileVideException.class)
    public void getTailValue() throws PileVideException {
        pileVideExecution.getCellValue();
    }

    @Test
    public void push() throws PileVideException {
        /* On ajoute à notre pile vide un élément : 1D */
        IPileExecution resultat = pileVideExecution.push(1D);
        /* Taille est égale à 1 */
        Assert.assertEquals(1,resultat.taille());
        /* Le sommet est égale à 1D */
        Assert.assertEquals(1D,resultat.getCellValue(),0);
        /* La tail est bien la pile vide car sa taille est égale à 0 */
        Assert.assertEquals(0,resultat.getTail().taille());
    }

    @Test(expected = PileVideException.class)
    public void pop() throws PileVideException {
        pileVideExecution.pop();
    }

    @Test(expected = PileVideException.class)
    public void add() throws PileVideException, UnSeulElementException {
        pileVideExecution.add();
    }

    @Test(expected = PileVideException.class)
    public void minus() throws PileVideException, UnSeulElementException {
        pileVideExecution.minus();
    }

    @Test(expected = PileVideException.class)
    public void times() throws PileVideException, UnSeulElementException {
        pileVideExecution.times();
    }

    @Test(expected = PileVideException.class)
    public void div() throws PileVideException, UnSeulElementException {
        pileVideExecution.div();
    }

    /**
     * A KOI CA SER, ALLO ?!
     */
    @Test
    public void getFabrique() {
        pileVideExecution.getFabrique();
    }

}
