import Model.Monom;
import Model.Polinom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class TestPolinom {

    @Test
    public void testMonomsList(){
        Polinom p = new Polinom();
        Monom m = new Monom(1,2);
        p.addMonom(m);
        Assertions.assertEquals(p.getMonoms().get(0), m);
    }

    @Test
    public void testAdd(){
        Polinom p1 = new Polinom(List.of(new Monom(1,2)));
        Polinom p2 = new Polinom(List.of(new Monom(1,1)));

        Polinom p = p1.add(p2);
        Assertions.assertEquals(p.getMonoms().get(0),new Monom(1,2));
        Assertions.assertEquals(p.getMonoms().get(1),new Monom(1,1));

    }

    @Test
    public void testSubb(){
        Polinom p1 = new Polinom(List.of(new Monom(2,2), new Monom(2,1)));
        Polinom p2 = new Polinom(List.of(new Monom(1,2), new Monom(1,1)));

        Polinom p = p2.subb(p1);
        Assertions.assertEquals(p.getMonoms().get(0),new Monom(1,2));
        Assertions.assertEquals(p.getMonoms().get(1),new Monom(1,1));
    }


}
