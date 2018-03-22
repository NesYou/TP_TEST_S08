package type;

import type.sigma.Succ;
import type.sigma.Zero;

/**
 * Created by YohanBoichut on 21/10/2016.
 */
public interface InstanceVisiteeInterface {
    Succ getSucc();

    void setSucc(Succ instanceSucc);

    Zero getZero();

    void setZero(Zero instanceZero);

    boolean isZero();

    boolean isSucc();
}
