package type.tools;

import type.sigma.Succ;
import type.sigma.Zero;
import type.InstanceVisiteeInterface;
import type.Naturel;

/**
 * Created by YohanBoichut on 19/10/2016.
 */
public class FabriqueMouchard {





    public InstanceVisiteeInterface analyse(Naturel n) {
        InstanceVisiteeInterface e = new InstanceVisiteeInterface() {
            Succ x;
            Zero y;
            @Override
            public Succ getSucc() {
                return x;
            }

            @Override
            public void setSucc(Succ instanceSucc) {
                this.x = instanceSucc;
            }

            @Override
            public Zero getZero() {
                return this.y;
            }

            @Override
            public void setZero(Zero instanceZero) {
                this.y = instanceZero;
            }

            @Override
            public boolean isZero() {
                return this.x == null;
            }

            @Override
            public boolean isSucc() {
                return this.y == null;
            }
        };
        n.accept(e);
        return e;
    }
}
