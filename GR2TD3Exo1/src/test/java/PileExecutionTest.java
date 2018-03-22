import exceptions.PileVideException;
import exceptions.UnSeulElementException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PileExecutionTest {

    PileExecution pileExecution;

    @Before
    public void setPileExecution() {
        pileExecution = new PileExecution(1D, new PileVideExecution());
    }

    @Test
    public void getTail() throws PileVideException {
        Assert.assertEquals(0,pileExecution.getTail().taille());
    }

    @Test
    public void getCellValue() throws PileVideException {
        Assert.assertEquals(1D,pileExecution.getCellValue(),0);
    }

    @Test
    public void push() throws PileVideException {
        /* Dans resultat on a notre ancienne pile avec en plus 2D en tête de pile */
        IPileExecution resultat = pileExecution.push(2D);
        /* Le sommet doit être égal à 2D */
        Assert.assertEquals(2D,resultat.getCellValue(),0);
        /* La taille de la nouvelle pile doit être égale à 2 */
        Assert.assertEquals(2,resultat.taille(),0);
        /* Le deuxième et dernier élément de la pile doit être égal à 1D */
        Assert.assertEquals(1D,resultat.getTail().getCellValue(),0);
    }

    @Test
    public void pop() throws PileVideException {
        /* La taille de la pile après avoir retiré son seul élément doit égale à 0 */
        Assert.assertEquals(0,pileExecution.pop().taille());
    }

    @Test
    public void taille() {
        /* Flemme d'écrire... */
        Assert.assertEquals(1,pileExecution.taille());
    }

    @Test
    public void add() throws UnSeulElementException, PileVideException {
        /* | 2D | 1D | PileVide | */
        IPileExecution pileExecution1 = new PileExecution(2D,pileExecution);
        /* 2D + 1D = 3D */
        Assert.assertEquals(3D,pileExecution1.add().getCellValue(),0);
    }

    @Test
    public void addTest() throws Exception {
        PileExecution pileExecution1 = new PileExecution(2D,pileExecution);
        IPileExecution resultat = pileExecution1.add();
        Assert.assertEquals(3D,resultat.getCellValue(),0);
        Assert.assertEquals(1,resultat.taille(),1);
        Assert.assertEquals(0,resultat.getTail().taille());
    }

    @Test(expected = UnSeulElementException.class)
    public void addAvecUnElement() throws Exception {
        IPileExecution pileExecution1 = pileExecution.add();
    }

    @Test(expected = UnSeulElementException.class)
    public void minusAvecUnElement() throws Exception {
        IPileExecution pileExecution1 = pileExecution.minus();
    }

    @Test(expected = UnSeulElementException.class)
    public void timesAvecUnElement() throws Exception {
        IPileExecution pileExecution1 = pileExecution.times();
    }

    @Test(expected = UnSeulElementException.class)
    public void divAvecUnElement() throws Exception {
        IPileExecution pileExecution1 = pileExecution.div();
    }

    @Test
    public void minus() throws Exception {
        PileExecution pileExecution1 = new PileExecution(1D,pileExecution);
        IPileExecution resultat = pileExecution1.minus();
        Assert.assertEquals(0D,resultat.getCellValue(),0);
        Assert.assertEquals(1,resultat.taille());
        Assert.assertEquals(0,resultat.getTail().taille());
    }

    @Test
    public void times() throws Exception {
        PileExecution pileExecution1 = new PileExecution(2D,pileExecution);
        IPileExecution resultat = pileExecution1.times();
        Assert.assertEquals(2D,resultat.getCellValue(),0);
        Assert.assertEquals(1,resultat.taille());
        Assert.assertEquals(0,resultat.getTail().taille());
    }

    @Test
    public void div() throws Exception {
        PileExecution pileExecution1 = new PileExecution(1D,pileExecution);
        IPileExecution resultat = pileExecution1.div();
        Assert.assertEquals(1D,resultat.getCellValue(),0);
        Assert.assertEquals(1,resultat.taille());
        Assert.assertEquals(0,resultat.getTail().taille());
    }

    @Test
    public void getFabrique() {
        pileExecution.getFabrique();
    }

}
