import Model.Monom;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestMonom {

    @Test
    public void testGettersSetters(){

        Monom m = new Monom(69, 420);
        Assertions.assertEquals(69,m.getConstant());
        Assertions.assertEquals(420,m.getExponent());
        m.setConstant(45);
        Assertions.assertEquals(45,m.getConstant());
        m.setExponent(67);
        Assertions.assertEquals(67, m.getExponent());
    }

    @Test
    public void testAdd(){
        Monom m1 = new Monom(45,23);
        Monom m2 = new Monom(23,12);
        Monom m3 = new Monom(13,12);
        Monom m4;
        m4 = m2.add(m3);
        Assertions.assertEquals(36,m4.getConstant());
        Assertions.assertEquals(12,m4.getExponent());

        try{
            m1.add(m3);
            assert(false);
        }
        catch(RuntimeException re){
            assert(true);
        }

    }

    @Test
    public void testSubb(){
        Monom m1 = new Monom(45,23);
        Monom m2 = new Monom(23,12);
        Monom m3 = new Monom(13,12);
        Monom m4;
        m4 = m2.subb(m3);
        Assertions.assertEquals(10,m4.getConstant());
        Assertions.assertEquals(12,m4.getExponent());

        try{
            m1.subb(m3);
            assert(false);
        }
        catch(RuntimeException re){
            assert(true);
        }
    }

    @Test
    public void testMultiplication(){
        Monom m1 = new Monom(2,4);
        Monom m2 = new Monom(3,5);
        Monom m3 = m1.multiplication(m2);
        Assertions.assertEquals(6,m3.getConstant());
        Assertions.assertEquals(9, m3.getExponent());
    }

    @Test
    public void testDivision(){
        Monom m1 = new Monom(6,10);
        Monom m2 = new Monom(3,5);
        Monom mz = new Monom(0,5);
        Monom m3 = Monom.divide(m1,m2);

        Assertions.assertEquals(2, m3.getConstant());
        Assertions.assertEquals(5, m3.getExponent());

        try{
            Monom.divide(m1,mz);
            assert(false);
        }
        catch(RuntimeException re){
            assert(true);
        }

    }

    @Test
    public void testDerivation(){
        Monom m = new Monom(4,0);
        Monom r = m.derivation();
        Assertions.assertEquals(0,r.getConstant());
        Assertions.assertEquals(0,r.getExponent());

        m.setExponent(5);

        r = m.derivation();

        Assertions.assertEquals(20,r.getConstant());
        Assertions.assertEquals(4,r.getExponent());
    }

    @Test
    public void testIntegration(){
        Monom m = new Monom(4,3);
        Monom r = m.integration();
        Assertions.assertEquals(1,r.getConstant());
        Assertions.assertEquals(4,r.getExponent());
    }

}
