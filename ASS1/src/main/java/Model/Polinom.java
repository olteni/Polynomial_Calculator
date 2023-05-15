package Model;

import java.util.*;

public class Polinom {

    private final List<Monom> monoms;

    public Polinom() {
        monoms = new ArrayList<>();
    }

    public Polinom(List<Monom> monoms) {
        this.monoms = monoms;
    }

    public void addMonom(Monom m) {
        monoms.add(m);
    }

    public List<Monom> getMonoms() {
        return monoms;
    }

    @Override
    public String toString() {
        StringBuilder polu = new StringBuilder();
        for(Monom m: monoms){
            polu.append(m.toString());
        }

        if(polu.toString().equals("")){
            return "0";
        }

        return polu.toString();
    }

    public Polinom add(Polinom other) {
        Map<Double, Monom> map = new HashMap<>();
        List<Monom> m1 = new ArrayList<>(this.monoms);

        m1.addAll(other.getMonoms());

        for (Monom m : m1) {
            if (map.containsKey(m.getExponent())) {
                map.put(m.getExponent(), m.add(map.get(m.getExponent())));
            } else {
                map.put(m.getExponent(), m);
            }
        }
        List<Monom> monomList = new ArrayList<>(map.values());
        monomList.sort((p1, p2) -> Double.compare(-p1.getExponent(), -p2.getExponent()));
        return new Polinom(monomList);
    }

    public Polinom subb(Polinom other) {
        Map<Double, Monom> map = new HashMap<>();
        List<Monom> m1 = new ArrayList<>(this.monoms);

        m1.addAll(other.getMonoms());

        for (Monom m : m1) {
            if (map.containsKey(m.getExponent())) {
                map.put(m.getExponent(), m.subb(map.get(m.getExponent())));
            } else {
                map.put(m.getExponent(), m);
            }
        }

        List<Monom> monomList = new ArrayList<>(map.values());
        monomList.removeIf(m-> m.getConstant() == 0);
        monomList.sort((p1, p2) -> Double.compare(-p1.getExponent(), -p2.getExponent()));

        return new Polinom(monomList);
    }

    public Polinom multiplication(Polinom other) {

        Polinom p = new Polinom();

        for (Monom m : this.monoms) {
            for( Monom m2 : other.getMonoms()){
                List<Monom> l1 = new ArrayList<>();
                l1.add(m.multiplication(m2));
                p = p.add(new Polinom(l1));
            }
        }
        return p;
    }

    public Polinom derivation() {
        List<Monom> m2 = new ArrayList<>();

        for (Monom m : this.monoms) {
            if (m.derivation().getConstant() != 0) {
                m2.add(m.derivation());
            }
        }
        return new Polinom(m2);
    }

    public Polinom integration() {
        List<Monom> m2 = new ArrayList<>();

        for (Monom m : this.monoms) {
                m2.add(m.integration());
        }
        return new Polinom(m2);
    }

    public Monom maximumMonom(){
        if(monoms.size() == 0){
            return new Monom(0,0);
        }
        Monom max = this.monoms.get(0);

        for(Monom m : monoms){
            if(max.getExponent() < m.getExponent()){
                max = m;
            }
        }
        return max;
    }

    public static Map.Entry<Polinom, Polinom> divide(Polinom p, Polinom q){
        List<Monom> monomQuotient = new ArrayList<>();
        Monom d;
        Polinom dstarq;
        while(q.maximumMonom().getExponent() <= p.maximumMonom().getExponent()){
            d = Monom.divide(p.maximumMonom(), q.maximumMonom());
            monomQuotient.add(d);
            dstarq = q.multiplication(new Polinom(new ArrayList<>(List.of(d))));
            p = dstarq.subb(p);
        }

        return new AbstractMap.SimpleEntry<>(p,new Polinom(monomQuotient));
    }
    /* public double evaluate(double value){
        double poliValue = 0;
        for(Monom m : monoms){
            poliValue += m.evaluate(value);
        }

        return poliValue;

    }*/

}