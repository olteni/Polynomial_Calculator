package Model;

public class Monom {

    private double constant;
    private double exponent;

    public Monom(double constant, double exponent) {
        this.constant = constant;
        this.exponent = exponent;
    }

    public double getConstant() {
        return constant;
    }

    public void setConstant(double constant) {
        this.constant = constant;
    }

    public double getExponent() {
        return exponent;
    }

    public void setExponent(double exponent) {
        this.exponent = exponent;
    }

   /* public double evaluate(double value){
        return this.constant * ((double) Math.pow(value,this.exponent));
    }*/

    @Override
    public boolean equals(Object other){
        if(other instanceof Monom){
            return this.constant == ((Monom) other).getConstant() && this.exponent == ((Monom) other).getExponent();
        }
        return false;
    }

    @Override
    public String toString() {
        String cstring = "";
        String estring = "";

        if(this.constant == 0){
            return "";
        }

        if (this.constant > 0) {
            cstring = "+";
        }

        if(this.constant != 1 || this.exponent == 0) {
            if (Math.floor(this.constant) == this.constant) {
                cstring += String.valueOf((int) this.constant);
            }
            else{
                cstring += String.valueOf(this.constant);
            }

        }
        if (this.exponent != 0) {
            estring = "X^" + String.valueOf((int) this.exponent);
        }

        return cstring + estring;
    }

    public Monom add(Monom other) {
        if (this.exponent == other.getExponent()) {
            return new Monom(this.constant + other.getConstant(), this.exponent);
        } else {
            throw new RuntimeException("Monoms have different exponents");
        }
    }

    public Monom subb(Monom other) {
        if (this.exponent == other.getExponent()) {
            return new Monom(this.constant - other.getConstant(), this.exponent);
        } else {
            throw new RuntimeException("Monoms have different exponents");
        }
    }

    public Monom multiplication(Monom other){
            return new Monom(this.constant * other.getConstant(), this.exponent + other.getExponent());
    }

    public Monom derivation(){
        if(this.exponent == 0){
            return new Monom(0, 0);
        }
        else {
            return new Monom(this.constant * this.exponent, this.exponent - 1);
        }
    }

    public Monom integration() {
       /* if (this.exponent == 0) {
            return new Monom(this.constant, 1);
        }*/
        return new Monom(this.constant / (this.exponent + 1), this.exponent + 1);
    }

    public static Monom divide(Monom m1, Monom m2){
        if(m2.getConstant() == 0){
            throw new RuntimeException("Division by zero!");
        }
        return new Monom(m1.getConstant() / m2.getConstant(), m1.getExponent()- m2.getExponent());
    }

}