package type.sigma;

import org.easymock.EasyMock;
import org.easymock.IMockBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import type.InstanceVisiteeInterface;
import type.Naturel;
import type.tools.FabriqueMouchard;

public class SuccTest {

    private Succ subject;
    private IMockBuilder<Succ> subjectBuilder;


    @Before
    public void before() {

        subjectBuilder = EasyMock.createMockBuilder(Succ.class);

    }

    @Test
    public void addTest() {

        //Création des mocks
        Naturel yMock = EasyMock.createMock(Naturel.class);
        Naturel ySuccMock = EasyMock.createMock(Naturel.class);


        //TODO
        Naturel xMock = EasyMock.createMock(Naturel.class);
        Naturel resultMock = EasyMock.createMock(Naturel.class);


        subject = subjectBuilder.addMockedMethod("getX").createMock();

        //Scénario
        /* y.succ */
        EasyMock.expect(yMock.succ()).andReturn(ySuccMock);
        /* this.getX() */
        EasyMock.expect(subject.getX()).andReturn(xMock);
        /* x.add(ySucc) */
        EasyMock.expect(xMock.add(ySuccMock)).andReturn(resultMock);

        //Passer les mocks en mode replay
        EasyMock.replay(yMock,ySuccMock,xMock,resultMock, subject);

        //Appel de la méthode testée
        Naturel returnedValue = subject.add(yMock);

        //Vérification
        EasyMock.verify(yMock,ySuccMock,subject);

        Assert.assertEquals("La valeur issue de l'addition doit être retournée.",resultMock,returnedValue);

    }

    @Test
    public void minusZeroTestTrue() {

        //Création des mocks
        Naturel yMock = EasyMock.createMock(Naturel.class);
        FabriqueMouchard fabriqueMouchardMock = EasyMock.createMock(FabriqueMouchard.class);
        InstanceVisiteeInterface eMock = EasyMock.createMock(InstanceVisiteeInterface.class);
        subject = subjectBuilder.addMockedMethod("getFabriqueMouchard").createMock();

        //Scénario
        /* this.getFabriqueMouchard */
        EasyMock.expect(subject.getFabriqueMouchard()).andReturn(fabriqueMouchardMock);
        /* e = this.getFabriqueMouchard().analyse(y); */
        EasyMock.expect(fabriqueMouchardMock.analyse(yMock)).andReturn(eMock);
        /* On entre dans le if */
        EasyMock.expect(eMock.isZero()).andReturn(true);

        //Passer le mock en mode replay
        EasyMock.replay(yMock,fabriqueMouchardMock,eMock,subject);

        //Appel de la méthode testée
        Naturel returnedValue = subject.minus(yMock);

        //Vérification
        EasyMock.verify(yMock,fabriqueMouchardMock,eMock,subject);

        //Test
        Assert.assertSame("Une soustraction par zéro doit retourner le subject",subject,returnedValue);

    }

    @Test
    public void minusZeroTestFalse() {

        //Création des mocks
        Naturel yMock = EasyMock.createMock(Naturel.class);
        FabriqueMouchard fabriqueMouchardMock = EasyMock.createMock(FabriqueMouchard.class);
        InstanceVisiteeInterface eMock = EasyMock.createMock(InstanceVisiteeInterface.class);
        Naturel xMock = EasyMock.createMock(Naturel.class);
        Succ eSuccMock = EasyMock.createMock(Succ.class);
        Succ eSuccXMock = EasyMock.createMock(Succ.class);
        Naturel resultMock = EasyMock.createMock(Naturel.class);
        subject = subjectBuilder.addMockedMethod("getFabriqueMouchard").addMockedMethod("getX").createMock();

        //Scénario
        /* this.getFabriqueMouchard */
        EasyMock.expect(subject.getFabriqueMouchard()).andReturn(fabriqueMouchardMock);
        /* e = this.getFabriqueMouchard().analyse(y); */
        EasyMock.expect(fabriqueMouchardMock.analyse(yMock)).andReturn(eMock);
        /* On entre dans le else */
        EasyMock.expect(eMock.isZero()).andReturn(false);
        /* e.getSucc() */
        EasyMock.expect(eMock.getSucc()).andReturn(eSuccMock);
        /* e.getSucc().getX() */
        EasyMock.expect(eSuccMock.getX()).andReturn(eSuccXMock);
        /* this.getX() */
        EasyMock.expect(subject.getX()).andReturn(xMock);
        /* this.getX().minus... */
        EasyMock.expect(xMock.minus(eSuccXMock)).andReturn(resultMock);

        //Passer le mock en mode replay
        EasyMock.replay(yMock,fabriqueMouchardMock,eMock,xMock,eSuccMock,eSuccXMock,resultMock,subject);

        //Appel de la méthode testée
        Naturel returnedValue = subject.minus(yMock);

        //Vérification
        EasyMock.verify(yMock,fabriqueMouchardMock,eMock,xMock,eSuccMock,eSuccXMock,resultMock,subject);


        //Test
        Assert.assertSame("Une soustraction ",resultMock,returnedValue);

    }

}
