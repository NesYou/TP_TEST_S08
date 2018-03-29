package testStructurel.mesActions;

import com.opensymphony.xwork2.ActionProxy;
import mesActions.Inscription;
import mesActions.MonEnvironnementCommun;

import modele.GestionDemineurEvolueInterface;
import modele.exceptions.ExceptionLoginDejaPris;
import org.apache.commons.collections.map.HashedMap;
import org.apache.struts2.StrutsJUnit4TestCase;
import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by YohanBoichut on 30/01/2017.
 */
public class TestInscription extends StrutsJUnit4TestCase{

    private GestionDemineurEvolueInterface modelMock;

    @Before
    public void before() {
        modelMock = EasyMock.createMock(GestionDemineurEvolueInterface.class);
    }




    @Test
    public void executeTestSuccess() throws Exception {

        int id = 816;
        String username = "Yoh";
        String mdp = "babar";

        //On créer les maps qui vont contenir les données de l'application et de la session
        Map<String,Object> varApp = new HashMap<>();
        Map<String,Object> varSession = new HashMap<>();

        //On ajoute le modèle à l'application
        varApp.put(MonEnvironnementCommun.MAFACADE, modelMock);


        // On ajoute à la requête la valeur du champs du formulaire
        request.addParameter("username",username);
        request.addParameter("password",mdp);
        request.addParameter("confirmationMDP",mdp);

        //On crée le scénario des mocks
        EasyMock.expect(modelMock.inscription(username,mdp)).andReturn(id);

        // On lance notre requête sur l'url inscription
        ActionProxy proxy = getActionProxy("/inscription");

        // On transmet les données de session et d'application à l'action
        proxy.getInvocation().getInvocationContext().setApplication(varApp);
        proxy.getInvocation().getInvocationContext().setSession(varSession);

        //On replay les mocks
        EasyMock.replay(modelMock);

        //On execute la requete
        String result = proxy.execute();

        EasyMock.verify(modelMock);

        //On vérigie le resultat
        Assert.assertTrue("Soucis au niveau de la clé","success".equals(result));
        Assert.assertTrue("Variable de session manquante",varSession.containsKey(MonEnvironnementCommun.MONID));
        Assert.assertEquals("L'id doit etre le même que celui retourne",id,varSession.get(MonEnvironnementCommun.MONID));

    }

    @Test
    public void executeTestDejaPris() throws Exception {

        String username = "Yoh";
        String mdp = "babar";

        //On créer les maps qui vont contenir les données de l'application et de la session
        Map<String,Object> varApp = new HashMap<>();
        Map<String,Object> varSession = new HashMap<>();

        //On ajoute le modèle à l'application
        varApp.put(MonEnvironnementCommun.MAFACADE, modelMock);


        // On ajoute à la requête la valeur du champs du formulaire
        request.addParameter("username",username);
        request.addParameter("password",mdp);
        request.addParameter("confirmationMDP",mdp);

        //On crée le scénario des mocks
        EasyMock.expect(modelMock.inscription(username,mdp)).andThrow(new ExceptionLoginDejaPris());

        // On lance notre requête sur l'url inscription
        ActionProxy proxy = getActionProxy("/inscription");

        // On transmet les données de session et d'application à l'action
        proxy.getInvocation().getInvocationContext().setApplication(varApp);
        proxy.getInvocation().getInvocationContext().setSession(varSession);

        //On replay les mocks
        EasyMock.replay(modelMock);

        //On execute la requete
        String result = proxy.execute();

        EasyMock.verify(modelMock);

        Inscription action = (Inscription) proxy.getAction();

        //On vérigie le resultat
        Assert.assertEquals("Soucis au niveau de la clé","input",result);

        Assert.assertEquals("IL n'y a qu'un champ qui a des erreurs"
                , 1
                ,action.getFieldErrors().size());

        Assert.assertTrue("Il doit y avoir un message d'erreur pour le champ \"username\""
                ,action.getFieldErrors().containsKey("username"));

        Assert.assertEquals("Il doit y avoir d'une erruer pour le champ \"username\""
                ,1
                ,action.getFieldErrors().get("username").size());

        Assert.assertEquals("Le message d'erreur doit être le bon",
                action.getText("Erreur.pseudopris"),
                action.getFieldErrors().get("username").get(0));

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
