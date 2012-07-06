package mx.ipn.escom.ecdif;

import java.util.StringTokenizer;

/**
 *
 * @author sergio
 */
public class Coeficientes{
    final static private Character VAR = 'y';
    
    private Double coeficientes[];
    
    public Coeficientes( String e ){
        Integer signo, variable, nprima;
        String coeficiente;
        String primerToken, siguienteToken;
        StringTokenizer st = new StringTokenizer( e, "+-" , true);
        primerToken = st.nextToken();
        
        if( primerToken.charAt(0) == '-'  ){
            signo = -1;
            siguienteToken = st.nextToken();
        } else {
            signo = 1;
            siguienteToken = primerToken;
        }
        variable = siguienteToken.indexOf( VAR );
        nprima = siguienteToken.substring( variable + 1 ).length() + 1;

        coeficientes = new Double[nprima];
        for ( int i = 0; i < nprima; i++ ){
            coeficientes[i] = 0.0;
        }
        
        try{
            coeficiente = variable <= 0 ? "1" : siguienteToken.substring( 0, variable );
            coeficientes[0] = signo * Double.parseDouble( coeficiente );
            while( st.hasMoreTokens() )
            {
                signo =  st.nextToken().equals( "-" ) ? -1 : 1;
                siguienteToken = st.nextToken();
                if( siguienteToken.indexOf( VAR ) < 0 ) continue;
                variable = siguienteToken.indexOf( VAR );
                nprima = - siguienteToken.substring( variable + 1 ).length() - 1 + nprima;
                coeficiente = variable <= 0 ? "1" : siguienteToken.substring( 0, variable );
                coeficientes[nprima] = signo * Double.parseDouble( coeficiente );
            }
        }catch( Exception err ){
            err.printStackTrace();
        }
    }
    
    public Double getCoeficientes()[]{
        return coeficientes;
    }
}