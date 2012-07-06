package mx.ipn.escom.ecdif;
/**
 *
 * @author sergio
 */
public class Raices {
    private Complejo raices[];
    private int precision;
    
    /**
     * Constructor
     * @param coef
     * @param precision
     */
    public Raices(Double[] coef, int precision) {
        this.precision = precision;
        Double a[] = new Double[coef.length];
        for( int i = 0; i < coef.length; i++ ){
            a[coef.length-1-i] = coef[i];
        }
        int n = a.length;
        Double re[] = new Double[n];
        Double im[] = new Double[n];
        a(a, -1.0, -1.0, re, im);
    }
    
    private void a(Double a[], Double r0, Double s0, Double re[], Double im[]) {
        raices = new Complejo[a.length];
        int n = a.length, iter =0;
        Double b[] = new Double[n], c[] = new Double[n];
        Double ea1 = 1.0, ea2 = 1.0, T = 0.00001;
        Double r=r0, s=s0,det, ds, dr;
        int MaxIter = 100, i;
        for(iter=0; iter< MaxIter && n>3; iter++) {
            do {
                b(a, b, c, r, s, n);
                det = c[2]*c[2] - c[3]*c[1];
                if(det!=0) {
                    dr = (-b[1]*c[2] + b[0]*c[3])/det;
                    ds = (-b[0]*c[2] + b[1]*c[1])/det;
                    r = r+dr;
                    s = s+ds;
                    if(r!=0) ea1 = Math.abs(dr/r)*100.0;
                    if(s!=0) ea2 = Math.abs(ds/s)*100.0;
                }
                else {
                    r = 5*r+1;
                    s = s+1;
                    iter = 0;
                }
            }
            while ((ea1 > T) && (ea2 > T));
            e(r, s, re, im, n);
            n = n-2;
            for(i=0; i<n; i++)
                a[i] = b[i+2];
            if (n < 4) break;
        }
        if(n==3) {
            r = -a[1]/a[2];
            s = -a[0]/a[2];
            e(r, s, re, im, n);
        }
        else {
            re[n-1] = -a[0]/a[1];
            im[n-1] = 0.0;
        }
        for(i=1; i<re.length; i++)
            raices[i-1] = new Complejo( r( re[i], precision), r(im[i], precision) );
    }
    private void b(Double a[], Double b[], Double c[], Double r, Double s, int n) {
        int i;
        b[n-1] = a[n-1];
        b[n-2] = a[n-2] + r*b[n-1];
        c[n-1] = b[n-1];
        c[n-2] = b[n-2] + r*c[n-1];
        for(i=n-3; i>=0; i--) {
            b[i] = a[i] + r*b[i+1] + s*b[i+2];
            c[i] = b[i] + r*c[i+1] + s*c[i+2];
        }
    }
    
    private void e(Double r, Double s, Double re[], Double im[], int n) {
        Double d = r*r + 4*s;
        if(d > 0) {
            re[n-1] = (r + Math.sqrt(d))/2.0;
            re[n-2] = (r - Math.sqrt(d))/2.0;
            im[n-1] = 0.0;
            im[n-2] = 0.0;
        }else{
            re[n-1] = r/2.0;
            re[n-2] = re[n-1];
            im[n-1] = Math.sqrt(-d)/2.0;
            im[n-2] = -im[n-1];
        }
    }
    
    private Double r( Double n, int d ) {
        return Math.round(n*Math.pow(10,d))/Math.pow(10,d);
    }
    
    /**
     * Regresa las raices obtenidas del polinomio
     * @return Arreglo de raices reales y complejas
     */
    public Complejo getRaices()[]{
        return raices;
    }
}