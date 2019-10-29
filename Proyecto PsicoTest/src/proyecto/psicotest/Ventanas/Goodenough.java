/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.psicotest.Ventanas;

import java.awt.List;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import proyecto.psicotest.MainMenu;

/**
 *
 * @author Yooma
 */
class Opcion {
    public String titulo;
    public String positiva;
    public String negativa;
    
    public Opcion(String t, String p, String n) {
        titulo = t;
        positiva = p;
        negativa = n;
    }
}

public class Goodenough extends javax.swing.JFrame {
    MainMenu mm;
    final JFileChooser fc = new JFileChooser();
    BufferedImage img = null;
    
    int actual = -1;
    ArrayList<Opcion> opciones = new ArrayList<Opcion>();
    boolean[] calificacion = new boolean[51];
    
    /**
     * Creates new form Goodenough
     */
    public Goodenough(MainMenu mm) {
        initComponents();
        this.mm = mm;
        this.radGroup.add(radOpcion1);
        this.radGroup.add(radOpcion2);
        
        // Diferentes preguntas
        opciones.add(new Opcion("Cabeza", "Tiene contorno", "No tiene contorno"));
        opciones.add(new Opcion("Piernas", "Tiene una o dos piernas con o sin pies", "No tiene piernas o están desprendidas del tronco"));
        opciones.add(new Opcion("Brazos", "El dibujo es de frente y los brazos tienen dos intersecciones.", 
                "El dibujo es de perfil o tiene un solo brazo."));
        opciones.add(new Opcion("Tronco", "escriban algo aqui porfa", "aaaaxd"));
        
        siguienteOpcion();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        radGroup = new javax.swing.ButtonGroup();
        imgDibujo = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        radOpcion1 = new javax.swing.JRadioButton();
        radOpcion2 = new javax.swing.JRadioButton();
        btnSiguiente = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtOpcion2 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtOpcion1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        imgDibujo.setBackground(new java.awt.Color(255, 255, 255));
        imgDibujo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imgDibujo.setText("doble clic");
        imgDibujo.setToolTipText("");
        imgDibujo.setOpaque(true);
        imgDibujo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imgDibujoMouseClicked(evt);
            }
        });

        lblTitulo.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        lblTitulo.setText("Cabeza");

        radOpcion1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        radOpcion1.setText("Positivo");

        radOpcion2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        radOpcion2.setText("Negativo");

        btnSiguiente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSiguiente.setText("Siguiente");
        btnSiguiente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSiguienteMouseClicked(evt);
            }
        });

        txtOpcion2.setColumns(20);
        txtOpcion2.setLineWrap(true);
        txtOpcion2.setRows(5);
        txtOpcion2.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txtOpcion2);

        txtOpcion1.setColumns(20);
        txtOpcion1.setLineWrap(true);
        txtOpcion1.setRows(5);
        txtOpcion1.setWrapStyleWord(true);
        jScrollPane2.setViewportView(txtOpcion1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgDibujo, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSiguiente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(radOpcion2)
                                    .addComponent(radOpcion1)))
                            .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(43, Short.MAX_VALUE))
                    .addComponent(jScrollPane2)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTitulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radOpcion1)
                        .addGap(7, 7, 7)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radOpcion2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(imgDibujo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        mm.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    private void imgDibujoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgDibujoMouseClicked
        if (fc.showDialog(this, "Aceptar") == 0)
        {
            try {
                img = ImageIO.read(fc.getSelectedFile());
                
                imgDibujo.setIcon(new ImageIcon(img));
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "La imagen seleccionada no pudo ser abierta.\n"+e.toString(),
                    "No se pudo abrir la imagen.", JOptionPane.INFORMATION_MESSAGE);
            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(null, "La imagen seleccionada no pudo ser abierta.\n"+e.toString(),
                    "No se pudo abrir la imagen.", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_imgDibujoMouseClicked

    private void btnSiguienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSiguienteMouseClicked
        if (radOpcion1.isSelected() || radOpcion2.isSelected()){
            siguienteOpcion();
        } else {
            JOptionPane.showMessageDialog(null, "Debes seleccionar alguna opción.",
                    "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnSiguienteMouseClicked

    private void siguienteOpcion() {
        ++actual;
        Opcion op = opciones.get(actual);
        lblTitulo.setText(op.titulo);
        txtOpcion1.setText(op.positiva);
        txtOpcion2.setText(op.negativa);
        
        calificacion[actual] = radOpcion1.isSelected();
        
        radOpcion1.setSelected(false);
        radOpcion2.setSelected(false);
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
            java.util.logging.Logger.getLogger(Goodenough.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Goodenough.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Goodenough.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Goodenough.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Goodenough(new MainMenu()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JLabel imgDibujo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.ButtonGroup radGroup;
    private javax.swing.JRadioButton radOpcion1;
    private javax.swing.JRadioButton radOpcion2;
    private javax.swing.JTextArea txtOpcion1;
    private javax.swing.JTextArea txtOpcion2;
    // End of variables declaration//GEN-END:variables
}
