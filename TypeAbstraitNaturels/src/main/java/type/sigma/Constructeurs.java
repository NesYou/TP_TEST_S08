package type.sigma;

import type.Naturel;
import type.tools.FabriqueMouchard;

/**
 * Created by YohanBoichut on 12/10/2016.
 */
public abstract class Constructeurs extends Naturel {



    public Naturel succ() {

        return new Succ(this,new FabriqueMouchard());
    }





}
