/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.psicotest.Ventanas;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javafx.util.Pair;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;
import proyecto.psicotest.MainMenu;
import static proyecto.psicotest.Ventanas.Goodenough.radOpcion1;
import static proyecto.psicotest.Ventanas.Goodenough.radOpcion2;

/**
 *
 * @author Yooma
 */

public class Machover extends javax.swing.JFrame {
    class Razgo {
        String razgo;
        String descripcion;
        boolean tiene;
        
        public Razgo (String r, String d) {
            razgo = r;
            descripcion = d;
            tiene = false;
        }
    }
    class Opcion {
        public String titulo;
        ArrayList<Razgo> razgos = new ArrayList<Razgo>();
        
        public Opcion(String t, Razgo [] arr)
        {
            titulo = t;
            for (int i=0; i<arr.length; ++i)
            {
                razgos.add(new Razgo(arr[i].razgo, arr[i].descripcion));
            }
        }
    }
    
    MainMenu mm;
    final JFileChooser fc = new JFileChooser();
    BufferedImage img = null;
    
    DefaultListModel lstModelEs = new DefaultListModel();
    DefaultListModel lstModelNoEs = new DefaultListModel();
    
    int actual = 0;
    ArrayList<Opcion> opciones = new ArrayList<Opcion>();
    /**
     * Creates new form Machover
     */
    public Machover(MainMenu mm) {
        initComponents();
        this.mm = mm;
        
        opciones.add(new Opcion("Cabeza", new Razgo[]{
            new Razgo("Cabeza desproporcinalmente grande", "Especial sensibilidad en la cabeza"),
            new Razgo("Dibujó la cabeza al final", "Padece transtornos en relaciones interpesonales")}));
        opciones.add(new Opcion("Rasgos faciales", new Razgo[]{
            new Razgo("Omite rasgos faciales con delineación cuidadosa y agresiva del contorno", "Es un individuo evasivo en cuanto al carácter de sus relaciones interpersonales. La superficialidad, cautela y hostilidad pueden caracterizar sus contactos sociales."),
            new Razgo("Rasgos faciales oscurecidos y traza con fuerza del contorno de la cabeza", "Es tímido y huidizo"),
            new Razgo("Trazado del perfil y combinación de líneas oscuras a través del balance de la figura", "Posee una deficiente estimacion de sí mismo por una imagen propia de un individuo agresivo y socialmente dominante")}));
        opciones.add(new Opcion("Expresión facial", new Razgo[]{
            new Razgo("Preocupación autística y narcisista, con gran tamaño y abortado o bloqueado movimiento que se inclina a reforzar su tendencia a la fantasía, este movimiento es fuerte, lo cual procura exhibicionismo, resultando en una pose estática, que contrasta con el movimiento externo", "Es esquizoide"),
            new Razgo("Las líneas naso-facial y en la frente", "Intenta añadir profundidad y madurez a la cara"),
            new Razgo("Especial pandeo de la frente (en vista de perfil) o pandeo occipital", "Tiene capacidad intelecual")}));
        opciones.add(new Opcion("", new Razgo[]{
            new Razgo("", ""),
            new Razgo("", "")}));
        opciones.add(new Opcion("", new Razgo[]{
            new Razgo("", ""),
            new Razgo("", "")}));
        opciones.add(new Opcion("", new Razgo[]{
            new Razgo("", ""),
            new Razgo("", "")}));
        opciones.add(new Opcion("", new Razgo[]{
            new Razgo("", ""),
            new Razgo("", "")}));
        
        Opcion op = opciones.get(actual);
        lstModelEs.clear();
        lstModelNoEs.clear();
        lstElDibujoEs.setModel(lstModelEs);
        lstElDibujoNoEs.setModel(lstModelNoEs);
        
        lblTitulo.setText(op.titulo);
        for (int i=0; i<op.razgos.size(); ++i)
            lstModelNoEs.addElement(op.razgos.get(i).razgo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAnterior = new javax.swing.JButton();
        btnFinalizar = new javax.swing.JButton();
        imgDibujo = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        btnSiguiente = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstElDibujoEs = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        lstElDibujoNoEs = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(9999, 9999));
        setMinimumSize(new java.awt.Dimension(675, 530));
        setPreferredSize(new java.awt.Dimension(675, 530));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        btnAnterior.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAnterior.setText("Anterior");
        btnAnterior.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAnteriorMouseClicked(evt);
            }
        });

        btnFinalizar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnFinalizar.setText("Finalizar");
        btnFinalizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFinalizarMouseClicked(evt);
            }
        });

        imgDibujo.setBackground(new java.awt.Color(255, 255, 255));
        imgDibujo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imgDibujo.setText("Pulsa para cargar imagen");
        imgDibujo.setToolTipText("");
        imgDibujo.setOpaque(true);
        imgDibujo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imgDibujoMouseClicked(evt);
            }
        });

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTitulo.setText("Cabeza");

        btnSiguiente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSiguiente.setText("Siguiente");
        btnSiguiente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSiguienteMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Es falso que");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Es verdad que");

        lstElDibujoEs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstElDibujoEsMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(lstElDibujoEs);

        lstElDibujoNoEs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstElDibujoNoEsMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(lstElDibujoNoEs);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(imgDibujo, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnAnterior)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnFinalizar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSiguiente))
                            .addComponent(jScrollPane3)
                            .addComponent(jScrollPane4)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(imgDibujo, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        mm.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    private void btnAnteriorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAnteriorMouseClicked
        if (actual > 0){
            anteriorOpcion();
        } else {
            JOptionPane.showMessageDialog(null, "Ya estás en la primer pregunta.",
                    "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnAnteriorMouseClicked

    private void btnFinalizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFinalizarMouseClicked
        String s = "Dado lo que respondió el paciente, su diagnóstico es el siguiente:\n\n";
        for (int i=0; i<opciones.size(); ++i) {
            Opcion op = opciones.get(i);
            for (int j=0; j<op.razgos.size(); ++j) { 
                if (op.razgos.get(j).tiene)
                    s += op.razgos.get(j).descripcion + ".\n";
            }
        }
        JOptionPane.showMessageDialog(null, s, "Respuestas", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnFinalizarMouseClicked

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
        if (actual < opciones.size()){
                siguienteOpcion();
        } else {
            JOptionPane.showMessageDialog(null, "Ya estás en la última pregunta.",
                "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnSiguienteMouseClicked

    private void lstElDibujoNoEsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstElDibujoNoEsMouseClicked
        JList lst = (JList)evt.getSource();
        if (evt.getClickCount() == 2) {
            int index = lst.locationToIndex(evt.getPoint());
            lstModelEs.addElement(lstModelNoEs.get(index));
            lstModelNoEs.remove(index);
            
            recalcularSeleccionados();
        }
    }//GEN-LAST:event_lstElDibujoNoEsMouseClicked

    private void lstElDibujoEsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstElDibujoEsMouseClicked
        JList lst = (JList)evt.getSource();
        if (evt.getClickCount() == 2) {
            int index = lst.locationToIndex(evt.getPoint());
            lstModelNoEs.addElement(lstModelEs.get(index));
            lstModelEs.remove(index);
            
            recalcularSeleccionados();
        }
    }//GEN-LAST:event_lstElDibujoEsMouseClicked

    // Actualiza el campo "tiene" de las opciones para registrar si fue seleccionado o no
    private void recalcularSeleccionados() {
        Opcion op = opciones.get(actual);
        for (int i=0; i<op.razgos.size(); ++i) {
            if (lstModelEs.contains(op.razgos.get(i).razgo))
                op.razgos.get(i).tiene = true;
            else
                op.razgos.get(i).tiene = false;
        }
    }
    
    private void siguienteOpcion() {
        ++actual;
        Opcion op = opciones.get(actual);
        lblTitulo.setText(op.titulo);
        
        lstModelEs.clear();
        lstModelNoEs.clear();
        for (int i=0; i<op.razgos.size(); ++i)
            if (op.razgos.get(i).tiene)
                lstModelEs.addElement(op.razgos.get(i).razgo);
            else
                lstModelNoEs.addElement(op.razgos.get(i).razgo);
    }
    
    private void anteriorOpcion() {
        --actual;
        Opcion op = opciones.get(actual);
        lblTitulo.setText(op.titulo);
        
        lstModelEs.clear();
        lstModelNoEs.clear();
        for (int i=0; i<op.razgos.size(); ++i)
            if (op.razgos.get(i).tiene)
                lstModelEs.addElement(op.razgos.get(i).razgo);
            else
                lstModelNoEs.addElement(op.razgos.get(i).razgo);
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
            java.util.logging.Logger.getLogger(Machover.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Machover.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Machover.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Machover.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Machover(new MainMenu()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JLabel imgDibujo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JList<String> lstElDibujoEs;
    private javax.swing.JList<String> lstElDibujoNoEs;
    // End of variables declaration//GEN-END:variables
}
