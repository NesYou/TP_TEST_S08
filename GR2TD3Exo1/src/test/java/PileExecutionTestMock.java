import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Test;

public class PileExecutionTestMock {

    @Test
    public void add() throws Exception{
        PileExecution pileExecution;
        pileExecution= EasyMock.createMock(PileExecution.class);

        EasyMock.expect(pileExecution.getCellValue()).andReturn(1D);
        EasyMock.expect(pileExecution.getTail()).andReturn(new PileVideExecution());
        EasyMock.expect(pileExecution.taille()).andReturn(1);
        EasyMock.expect(pileExecution.pop()).andReturn(new PileVideExecution());

        EasyMock.replay(pileExecution);

        PileExecution pileExecution1 = new PileExecution(2D,pileExecution);
        IPileExecution pileExecution2 = pileExecution1.add();
        Assert.assertEquals(pileExecution2.getCellValue(),3D,0);
        Assert.assertEquals(pileExecution2.taille(),1);
    }

}
