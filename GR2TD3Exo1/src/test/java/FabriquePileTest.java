import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FabriquePileTest {

    FabriquePile fabriquePile;

    @Before
    public void setFabriquePile() {
        fabriquePile = new FabriquePile();
    }

    @Test
    public void testPileVide1() throws Exception {
        IPileExecution resultat = fabriquePile.pileVide();
        Assert.assertEquals(0,resultat.taille());
    }

    @Test
    public void empiler() throws Exception {
        IPileExecution resultat = fabriquePile.empiler(1, new PileVideExecution());
        Assert.assertEquals(1,resultat.getCellValue(),0);
        Assert.assertEquals(1,resultat.taille());
    }

}
