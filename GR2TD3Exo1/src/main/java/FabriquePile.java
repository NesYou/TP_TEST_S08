
public class FabriquePile {

    public IPileExecution pileVide () {
        return new PileVideExecution();
    }

    public IPileExecution empiler (double nombre, IPileExecution next) {
        return new PileExecution(nombre, next);
    }

}
