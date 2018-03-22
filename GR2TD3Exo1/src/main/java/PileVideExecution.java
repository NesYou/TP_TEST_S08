import exceptions.PileVideException;
import exceptions.UnSeulElementException;

public class PileVideExecution implements IPileExecution {

    private IFabriquePile fabriquePile;

    public IPileExecution getTail() throws PileVideException {
        throw new PileVideException();
    }

    public double getCellValue() throws PileVideException {
        throw new PileVideException();
    }

    public IPileExecution push(double e) {
        return new PileExecution(e,this);
    }

    public IPileExecution pop() throws PileVideException {
        throw new PileVideException();
    }

    public int taille() {
        return 0;
    }

    public IPileExecution add() throws PileVideException, UnSeulElementException {
        throw new PileVideException();
    }

    public IPileExecution minus() throws PileVideException, UnSeulElementException {
        throw new PileVideException();
    }

    public IPileExecution times() throws PileVideException, UnSeulElementException {
        throw new PileVideException();
    }

    public IPileExecution div() throws PileVideException, UnSeulElementException {
        throw new PileVideException();
    }

    public IFabriquePile getFabrique() {
        return fabriquePile;
    }

}
