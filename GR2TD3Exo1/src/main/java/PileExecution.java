import exceptions.PileVideException;
import exceptions.UnSeulElementException;

public class PileExecution implements IPileExecution{

    private double nombre;

    private IPileExecution next;

    public PileExecution(double nombre, IPileExecution next) {
        this.nombre = nombre;
        this.next = next;
    }

    public IPileExecution getTail() throws PileVideException {
        return next;
    }

    public double getCellValue() throws PileVideException {
        return nombre;
    }

    public IPileExecution push(double e) {
        return new PileExecution(e,this);
    }

    public IPileExecution pop() throws PileVideException {
        return next;
    }

    public int taille() {
        return 1 + next.taille();
    }

    public IPileExecution add() throws PileVideException, UnSeulElementException {

        if(taille()==1) throw new UnSeulElementException();
        double s = getCellValue() + next.getCellValue();
        return pop().pop().push(s);

    }

    public IPileExecution minus() throws PileVideException, UnSeulElementException {
        if(taille()==1) throw new UnSeulElementException();
        double s = getCellValue() - next.getCellValue();
        return pop().pop().push(s);
    }

    public IPileExecution times() throws PileVideException, UnSeulElementException {
        if(taille()==1) throw new UnSeulElementException();
        double s = getCellValue() * next.getCellValue();
        return pop().pop().push(s);
    }

    public IPileExecution div() throws PileVideException, UnSeulElementException {
        if(taille()==1) throw new UnSeulElementException();
        double s = getCellValue() / next.getCellValue();
        return pop().pop().push(s);
    }

    public IFabriquePile getFabrique() {
        return next.getFabrique();
    }
}