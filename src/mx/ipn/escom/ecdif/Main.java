package mx.ipn.escom.ecdif;

/**
 *
 * @author  sxceron
 */
public class Main extends javax.swing.JFrame {

    public Main() {
        initComponents();
        try {
            javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
        } catch (Exception e) {
            System.out.println("El LookAndFeel no existe.");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        precision = new javax.swing.JSlider();
        ecuacion = new javax.swing.JTextPane();
        jLabel6 = new javax.swing.JLabel();
        solucion = new javax.swing.JEditorPane();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setTitle("Ecuaciones Diferenciales: Homogeneas");
        setBackground(new java.awt.Color(0, 0, 0));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });
        getContentPane().setLayout(null);

        precision.setMajorTickSpacing(1);
        precision.setMaximum(10);
        precision.setMinorTickSpacing(1);
        precision.setPaintLabels(true);
        precision.setPaintTicks(true);
        precision.setSnapToTicks(true);
        precision.setValue(0);
        precision.setOpaque(false);
        precision.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                precisionStateChanged(evt);
            }
        });
        getContentPane().add(precision);
        precision.setBounds(560, 100, 200, 45);

        ecuacion.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true), "Ecuación Diferencial", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        ecuacion.setFont(new java.awt.Font("Monotype Corsiva", 1, 18)); // NOI18N
        ecuacion.setForeground(new java.awt.Color(255, 255, 255));
        ecuacion.setOpaque(false);
        getContentPane().add(ecuacion);
        ecuacion.setBounds(20, 150, 740, 100);

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 0, 18));
        jLabel6.setForeground(new java.awt.Color(0, 102, 153));
        jLabel6.setText("Homogeneas");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(330, 50, 350, 20);

        solucion.setBackground(new java.awt.Color(235, 233, 237));
        solucion.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true));
        solucion.setContentType("text/html");
        solucion.setFont(new java.awt.Font("Verdana", 0, 18));
        solucion.setText("<html>\r\n  <head>\r\n\r\n  </head>\r\n  <body>\r\n\n  </body>\r\n</html>\r\n");
        solucion.setCaret(null);
        solucion.setOpaque(false);
        getContentPane().add(solucion);
        solucion.setBounds(20, 300, 740, 230);

        jButton1.setText("Obtener raices");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(20, 260, 740, 23);

        jLabel1.setFont(new java.awt.Font("Impact", 0, 24));
        jLabel1.setForeground(new java.awt.Color(0, 153, 204));
        jLabel1.setText("ECUACIONES DIFERENCIALES");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(260, 20, 310, 30);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Sergio Ceron Figueroa");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(640, 540, 160, 14);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("INSTITUTO POLITÉCNICO NACIONAL");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(330, 540, 210, 14);

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Decimales de precisión:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(560, 80, 150, 14);

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mx/ipn/escom/ecdif/resources/200810032050-6722.jpg"))); // NOI18N
        jLabel8.setText("jLabel8");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(0, 0, 790, 570);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-800)/2, (screenSize.height-600)/2, 800, 600);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (ecuacion.getText().trim().length() != 0) {
            Coeficientes c = new Coeficientes(ecuacion.getText());
            Double coef[] = c.getCoeficientes();
            Homogenea h = new Homogenea(coef, precision.getValue());
            h.resolver();
            solucion.setText(h.getResultado());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        System.exit(0);
    }//GEN-LAST:event_exitForm

    private void precisionStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_precisionStateChanged
        if (ecuacion.getText().trim().length() != 0) {
            Coeficientes c = new Coeficientes(ecuacion.getText());
            Double coef[] = c.getCoeficientes();
            Homogenea h = new Homogenea(coef, precision.getValue());
            h.resolver();
            solucion.setText(h.getResultado());
        }
    }//GEN-LAST:event_precisionStateChanged

    @SuppressWarnings("deprecation")
    public static void main(String args[]) {
        new Main().setVisible(true);

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextPane ecuacion;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JSlider precision;
    public static javax.swing.JEditorPane solucion;
    // End of variables declaration//GEN-END:variables
}
