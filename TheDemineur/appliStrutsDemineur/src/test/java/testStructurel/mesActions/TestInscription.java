package testStructurel.mesActions;

import com.opensymphony.xwork2.ActionProxy;
import mesActions.Inscription;
import mesActions.MonEnvironnementCommun;

import modele.GestionDemineurEvolueInterface;
import org.apache.commons.collections.map.HashedMap;
import org.apache.struts2.StrutsJUnit4TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;


/**
 * Created by YohanBoichut on 30/01/2017.
 */
public class TestInscription extends StrutsJUnit4TestCase{




    @Test
    public void testInscriptionOK() throws Exception {

        request.addParameter("username","Yoh");
        request.addParameter("password","babar");
        request.addParameter("confirmationMDP","babar");

        Map<String,Object> varApp = new HashedMap();
        Map<String,Object> varSession = new HashedMap();
        varApp.put(MonEnvironnementCommun.MAFACADE,null); /*Evidemment il faut changer la valeur null*/
        ActionProxy proxy = getActionProxy("/inscription");
        proxy.getInvocation().getInvocationContext().setApplication(varApp);
        proxy.getInvocation().getInvocationContext().setSession(varSession);
        String result = proxy.execute();

        Assert.assertTrue("soucis au niveau de la clé","success".equals(result));
        Assert.assertTrue("variable de session manquante",varSession.containsKey(MonEnvironnementCommun.MONID));

    }



    @Test
    public void testInscriptionKODejaPris() throws Exception {

        GestionDemineurEvolueInterface modele = null; /*Evidemment il faut changer la valeur null*/
        modele.inscription("Fred","babar");

        request.addParameter("username","Fred");
        request.addParameter("password","celestine");
        request.addParameter("confirmationMDP","celestine");

        Map<String,Object> varApp = new HashedMap();
        Map<String,Object> varSession = new HashedMap();
        varApp.put(MonEnvironnementCommun.MAFACADE,modele);
        ActionProxy proxy = getActionProxy("/inscription");
        proxy.getInvocation().getInvocationContext().setApplication(varApp);
        proxy.getInvocation().getInvocationContext().setSession(varSession);
        String result = proxy.execute();

        Assert.assertTrue("soucis au niveau de la clé","input".equals(result));
        Assert.assertTrue(((Inscription)proxy.getAction()).
                getFieldErrors().get("username").
                contains(((Inscription)proxy.getAction()).getText("Erreur.pseudopris")));

    }



    @Test
    public void testInscriptionKOMDPDIFF() throws Exception {

        GestionDemineurEvolueInterface modele = null; /*Evidemment il faut changer la valeur null*/

        request.addParameter("username","Fred1");
        request.addParameter("password","celestine");
        request.addParameter("confirmationMDP","celestine1");

        Map<String,Object> varApp = new HashedMap();
        Map<String,Object> varSession = new HashedMap();
        varApp.put(MonEnvironnementCommun.MAFACADE,modele);
        ActionProxy proxy = getActionProxy("/inscription");
        proxy.getInvocation().getInvocationContext().setApplication(varApp);
        proxy.getInvocation().getInvocationContext().setSession(varSession);
        String result = proxy.execute();

        Assert.assertTrue("soucis au niveau de la clé","input".equals(result));
        Assert.assertTrue(((Inscription)proxy.getAction()).
                getFieldErrors().get("confirmationMDP").
                contains(((Inscription)proxy.getAction()).getText("confirmationdifferente")));

    }


    public void inscriptionScenarioOk() throws Exception {

        request.addParameter("username","Yoh");
        request.addParameter("password","babar");
        request.addParameter("confirmationMDP","babar");

        Map<String,Object> varApp = new HashedMap();
        Map<String,Object> varSession = new HashedMap();

        GestionDemineurEvolueInterface modele = null; /*Evidemment il faut changer la valeur null*/

        varApp.put(MonEnvironnementCommun.MAFACADE, modele);
        ActionProxy proxy = getActionProxy("/inscription");
        proxy.getInvocation().getInvocationContext().setApplication(varApp);
        proxy.getInvocation().getInvocationContext().setSession(varSession);
        String result = proxy.execute();

        proxy = getActionProxy("/inscription");
        proxy.getInvocation().getInvocationContext().setApplication(varApp);
        proxy.getInvocation().getInvocationContext().setSession(varSession);
        result = proxy.execute();

        Assert.assertTrue("Soucis dans l'action",result.equals("input"));
        Assert.assertTrue(((Inscription)proxy.getAction()).getFieldErrors().get("username").contains(((Inscription)proxy.getAction()).getText("Erreur.pseudopris")));

    }
}
