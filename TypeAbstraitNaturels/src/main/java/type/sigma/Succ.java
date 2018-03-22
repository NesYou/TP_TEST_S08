package type.sigma;

import type.tools.FabriqueMouchard;

import type.InstanceVisiteeInterface;
import type.Naturel;


/**
 * Created by YohanBoichut on 12/10/2016.
 */
public class Succ extends Constructeurs {
    Naturel x;

    private FabriqueMouchard fabriqueMouchard;

    Succ(Naturel x, FabriqueMouchard fabriqueMouchard) {
        this.x = x;
        this.fabriqueMouchard = fabriqueMouchard;
    }

    public FabriqueMouchard getFabriqueMouchard() {
        return fabriqueMouchard;
    }

    public Naturel add(Naturel y) {

        return this.getX().add(y.succ());

    }

    public Naturel minus(Naturel y) {

        InstanceVisiteeInterface e = this.getFabriqueMouchard().analyse(y);
        if (e.isZero()) {
            return this;
        }
        else {
            return this.getX().minus(e.getSucc().getX());
        }

    }



    public boolean geq(Naturel y) {
        InstanceVisiteeInterface e = getFabriqueMouchard().analyse(y);
        if (e.isZero()) {
            return true;
        }
        else {
            return this.x.geq(e.getSucc().getX());
        }

    }

    public boolean egalite(Naturel y) {

        InstanceVisiteeInterface e = getFabriqueMouchard().analyse(y);
        if (e.isZero()) {
            return false;
        }
        else {
            return x.egalite(e.getSucc().getX());
        }

    }





    public Naturel getX() {
        return x;
    }


    @Override
    public void accept(InstanceVisiteeInterface e){
        e.setSucc(this);
    }


}
