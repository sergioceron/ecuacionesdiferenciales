package mx.ipn.escom.ecdif;

/**
 *
 * @author sergio
 */
class Complejo{
    private double real;
    private double imaginario;
    
    public Complejo( double real, double imaginario ){
        this.real=real;
        this.imaginario=imaginario;
    }

    public double getImaginario() {
        return imaginario;
    }

    public void setImaginario(double imaginario) {
        this.imaginario = imaginario;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }
}
