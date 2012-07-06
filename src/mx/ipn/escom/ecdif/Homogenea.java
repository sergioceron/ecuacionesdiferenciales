package mx.ipn.escom.ecdif;

/**
 *
 * @author sergio
 */
public class Homogenea{
    
    private StringBuilder resultado;
    private int precision;
    private Double coeficientes[];
    
    public Homogenea( Double coeficientes[], int precision ){
        this.coeficientes = coeficientes;
        this.precision = precision;
        this.resultado = new StringBuilder();
    }
    
    public void resolver(){
        Raices raices = new Raices( coeficientes, precision );
        for( int i = 0; i < raices.getRaices().length -1; i++ ){
            Complejo raiz = raices.getRaices()[i];
            int m = multiplicidad( raiz, raices.getRaices(), i + 1 );
            String variableIndep = m > 0 ? m == 1 ? "x" : "x<sup>"+m+"</sup>" : "";
            String coeficiente = "</sup>c<sub>" + ( i + 1) + "</sub>";
            String subindice = raiz.getReal() != 0.0 ? "e<sup>" + (raiz.getReal() == 1.0 ? "" 
                    : (raiz.getReal() == -1.0 ? "-" 
                    :  raiz.getReal() + "") + "") + "<i>x</i></sup>" 
                    : "";
            String signo = ( i == raices.getRaices().length -2 ? "" : " + " );
            if( raiz.getImaginario() == 0.0 ){
                resultado.append( coeficiente )
                         .append( variableIndep )
                         .append( subindice)
                         .append( signo);
            }else{
                if( raiz.getImaginario() > 0.0 ){
                    resultado.append( coeficiente )
                             .append( variableIndep )
                             .append( subindice )
                             .append( signo )
                             .append( "<i>cos</i>(")
                             .append( Math.abs(raiz.getImaginario()) == 1.0 ? "" : Math.abs(raiz.getImaginario()) + "" )
                             .append( "<i>x</i>) " )
                             .append( signo ); 
                } else {
                    resultado.append( coeficiente )
                             .append( variableIndep )
                             .append( subindice )
                             .append( "<i>sen</i>(" )
                             .append( Math.abs(raiz.getImaginario()) == 1.0 ? "" : Math.abs(raiz.getImaginario()) + "" )
                             .append( "<i>x</i>) " )
                             .append( signo ); 
                }
            }
        }
    }
    
    public String getResultado(){
        StringBuilder resultadoFormateado = new StringBuilder();
        resultadoFormateado.append("<table width='100%' height='260px'>")
                           .append("    <tr>")
                           .append("        <td style='font-family:Monotype Corsiva; font-size:20px; color:#F6AE72;height:260px;text-align:center;' valign='top'>")
                           .append("            <b>")
                           .append("                ").append(resultado)
                           .append( "           </b>")
                           .append( "       </td>")
                           .append( "   </tr>")
                           .append( "</table>");
        return resultadoFormateado.toString();
    }
    
    private int multiplicidad( Complejo raiz, Complejo raices[], int indice ){
        int repeticiones = 0;
        for( int i = indice; i < raices.length-1; i++ ){
            Complejo ra = raices[i];
            if( raiz.getReal() == ra.getReal() && raiz.getImaginario() == ra.getImaginario() )
                repeticiones++;
        }
        return repeticiones;
    }
}