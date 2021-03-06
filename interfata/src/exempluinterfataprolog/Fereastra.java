/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exempluinterfataprolog;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Irina
 */
public class Fereastra extends javax.swing.JFrame {

    /**
     * Creates new form Fereastra
     * @param titlu
     */
    ConexiuneProlog conexiune;
    Intrebare_intrebatoare panou_intrebari;
    public Fereastra(String titlu) {
        super(titlu);
        panou_intrebari=new Intrebare_intrebatoare();
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupBtn = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaDebug = new javax.swing.JTextArea();
        b_incarca = new javax.swing.JButton();
        b_consulta = new javax.swing.JButton();
        tfFisier = new javax.swing.JTextField();
        b_reset = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(40, 168, 179));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(523, 700));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        textAreaDebug.setColumns(20);
        textAreaDebug.setRows(5);
        textAreaDebug.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 168, 179), 5, true));
        jScrollPane1.setViewportView(textAreaDebug);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(81, 520, 370, -1));

        b_incarca.setBackground(new java.awt.Color(40, 168, 179));
        b_incarca.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        b_incarca.setText("Incarca regulile");
        b_incarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_incarcaActionPerformed(evt);
            }
        });
        getContentPane().add(b_incarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, -1, -1));

        b_consulta.setBackground(new java.awt.Color(40, 168, 179));
        b_consulta.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        b_consulta.setText("Afla diagnostic");
        b_consulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_consultaActionPerformed(evt);
            }
        });
        getContentPane().add(b_consulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 480, -1, -1));

        tfFisier.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfFisier.setText("'reguli.txt'");
        tfFisier.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 168, 179), 5, true));
        tfFisier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfFisierActionPerformed(evt);
            }
        });
        getContentPane().add(tfFisier, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 130, -1));

        b_reset.setBackground(new java.awt.Color(40, 168, 179));
        b_reset.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        b_reset.setText("x");
        b_reset.setToolTipText("Resetare");
        b_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_resetActionPerformed(evt);
            }
        });
        getContentPane().add(b_reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(491, 0, 40, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/exempluinterfataprolog/medic.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 310, 363));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfFisierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfFisierActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfFisierActionPerformed

    private void b_incarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_incarcaActionPerformed
        Fereastra.AFISAT_SOLUTII=false;
        String valoareParametru=tfFisier.getText();
        tfFisier.setEnabled(false);
        String dir=System.getProperty("user.dir");
        dir=dir.replace("\\", "/");
        try {
            conexiune.expeditor.trimiteMesajSicstus("director('"+dir+"')");
            conexiune.expeditor.trimiteMesajSicstus("incarca("+valoareParametru+")");
            
        
        } catch (InterruptedException ex) {
            Logger.getLogger(Fereastra.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_b_incarcaActionPerformed
                                 
    
    private void b_consultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_consultaActionPerformed
       
        this.remove(this.b_incarca);
        this.remove(this.b_consulta);
        //this.remove(this.tfFisier);
        
        this.setLayout(new FlowLayout());
        this.add(this.panou_intrebari);
        this.panou_intrebari.paint(null);
        this.panou_intrebari.revalidate();
        this.repaint();
        this.revalidate();
        try {
            conexiune.expeditor.trimiteMesajSicstus("comanda(consulta)");
            
        
        } catch (InterruptedException ex) {
            Logger.getLogger(Fereastra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_b_consultaActionPerformed

    private void b_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_resetActionPerformed

        this.remove(this.b_incarca);
        this.remove(this.b_consulta);
        this.remove(this.tfFisier);
        this.remove(this.panou_intrebari);
        this.remove(this.textAreaDebug);
        this.remove(this.jScrollPane1);
        this.remove(this.jLabel2);
        this.remove(this.b_reset);
        
        this.repaint();
        this.revalidate();
        
        try {
            conexiune.expeditor.trimiteMesajSicstus("comanda(reset)");
            
        
        } catch (InterruptedException ex) {
            Logger.getLogger(Fereastra.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        panou_intrebari=new Intrebare_intrebatoare();
        initComponents();
    }//GEN-LAST:event_b_resetActionPerformed

    
     private void optiuneButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
       
       
        String raspuns= ((JButton)(evt.getSource())).getText();
        try {
            conexiune.expeditor.trimiteSirSicstus(raspuns);
            
        
        } catch (InterruptedException ex) {
            Logger.getLogger(Fereastra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Fereastra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Fereastra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Fereastra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Fereastra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Fereastra("Verificare").setVisible(true);
                
            }
        });
    }

    public javax.swing.JTextArea getDebugTextArea(){
        return textAreaDebug;
    }
    
    
    public void setConexiune(ConexiuneProlog _conexiune){
        conexiune=_conexiune;
    }
    public void setIntrebare(String intreb){
        this.panou_intrebari.label_intrebare.setText("<html><body style='width:100%;'>"+intreb+"</html>");
        this.panou_intrebari.repaint();
    }
     public void setOptiuni(String optiuni){
        this.panou_intrebari.panou_optiuni.removeAll();
        this.panou_intrebari.panou_optiuni.setLayout(new FlowLayout());
        optiuni=optiuni.trim();
        optiuni=optiuni.substring(1,optiuni.length()-1);
        optiuni=optiuni.trim();
        String[] vect_opt=optiuni.split(" ");
        for(int i=0;i<vect_opt.length;i++)
        {
            JButton b=new JButton(vect_opt[i]);
            b.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    optiuneButtonActionPerformed(evt);
                }
            });
            this.panou_intrebari.panou_optiuni.add(b);
        }
        this.panou_intrebari.panou_optiuni.repaint();
        this.panou_intrebari.panou_optiuni.revalidate();
        //this.revalidate();
    }  

     public void setSolutie(String solutie){
        if(!Fereastra.AFISAT_SOLUTII)
        {
            this.panou_intrebari.removeAll();
            this.panou_intrebari.setLayout(new FlowLayout());
            Fereastra.AFISAT_SOLUTII=true;
        }

        JLabel jsol=new JLabel(solutie);
        this.panou_intrebari.add(jsol);
       

        this.panou_intrebari.repaint();
        this.panou_intrebari.revalidate();
        //this.revalidate();
    } 
    
    public static boolean AFISAT_SOLUTII=false;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_consulta;
    private javax.swing.JButton b_incarca;
    private javax.swing.JButton b_reset;
    private javax.swing.ButtonGroup grupBtn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea textAreaDebug;
    private javax.swing.JTextField tfFisier;
    // End of variables declaration//GEN-END:variables
}
