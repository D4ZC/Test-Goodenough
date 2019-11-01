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
import java.util.Collections;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
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
    enum Calificacion {
    NEGATIVO, POSITIVO, INDETERMINADO;
    }
    Calificacion Califica() {
        if (radOpcion1.isSelected() && !radOpcion2.isSelected())
            return Calificacion.POSITIVO;
        if (!radOpcion1.isSelected() && radOpcion2.isSelected())
            return Calificacion.NEGATIVO;
        return Calificacion.INDETERMINADO;
    }
    
    MainMenu mm;
    final JFileChooser fc = new JFileChooser();
    BufferedImage img = null;
    
    int actual = 0;
    ArrayList<Opcion> opciones = new ArrayList<Opcion>();
    ArrayList<Calificacion> calificacion = new ArrayList<Calificacion>(Collections.nCopies(51, null));
    
    /**
     * Creates new form Goodenough
     */
    public Goodenough(MainMenu mm) {
        initComponents();
        this.mm = mm;
        this.radGroup.add(radOpcion1);
        this.radGroup.add(radOpcion2);
        
        // Diferentes preguntas
        opciones.add(new Opcion(
                "1) Precencia de cabeza",
                "Tiene contorno bien definido.",
                "No tiene contorno"));
        opciones.add(new Opcion(
                "2) Precencia de piernas",
                "Tiene dos piernas o una sola con dos pies.",
                "No tiene piernas o están desprendidas del tronco"));
        opciones.add(new Opcion(
                "3) Precencia de brazos",
                "El dibujo es de frente y los brazos tienen dos intersecciones.", 
                "El dibujo es de perfil o tiene un solo brazo."));
        opciones.add(new Opcion(
                "4a) Precencia de tronco",
                "El tronco está bien definido.\nExiste una diferencia clara de cabeza y tronco.",
                "Tiene una hilera de botones extendida hacia abajo entre ambas piernas y no trazó una horizontal para figurar el tronco."));
        opciones.add(new Opcion(
                "4b) Longitud y anchura del tronco", 
                "Es más largo que ancho",
                "Es más ancho que largo"));
        opciones.add(new Opcion(
                "4c) Indicación del hombro",
                "Recto con águlos redondeados o aparece un cambio de dirección en la línea superior del contorno del tronco que se vea cóncavo.",
                "Hombros completamente cuadrados o convexos."));
        opciones.add(new Opcion(
                "5a) Brazos y piernas unidos al tronco",
                "Brazos y piernas están unidos al tronco o al cuello.",
                "Los brazos no están unidos al tronco o están unidos a las piernas."));
        opciones.add(new Opcion(
                "5b) Brazos y piernas unidos al tronco correctamente",
                "Si está de frente y tiene hombros, los brazos están unidos a estos.\nSi está de perfil, los brazos están poco debajo del cuello.\nSi no tiene hombros, los brazos están donde deberían estar los hombros.",
                "Tiene hombros pero los brazos no están pegados a estos.\nLos brazos están unidos en otra parte distinta (en el cuello, en las piernas, en el abdomen)."));
        opciones.add(new Opcion(
                "6a) Precencia de cuello",
                "El cuello se diferencia de la cabeza y el tronco.",
                "La cabeza está yuxtapuesta en el tronco."));
        opciones.add(new Opcion(
                "6b) Contorno del cuello",
                "La línea del cuello es la continuación de la línea de la cabeza y del tronco.",
                "No tiene cuello o la línea de este no se une continuamente a la cabeza y el tronco."));
        opciones.add(new Opcion(
                "7a) Precencia de ojos",
                "Si está de frente, tiene ambos ojos.\nSi está de perfil, tiene un solo ojo.",
                "Carece de ojos."));
        opciones.add(new Opcion(
                "7b) Precencia de nariz",
                "Tiene cualquier forma que represente una nariz.",
                "Carece completamente de cualquier indicio de nariz."));
        opciones.add(new Opcion(
                "7c) Precencia de boca",
                "Tiene cualquier forma que indique una boca.",
                "Carece completamente de boca."));
        opciones.add(new Opcion(
                "7d) Representación de boca y nariz",
                "La nariz es un triángulo equilátero con la base hacia abajo. La boca tiene algún indicio de labios.",
                "La nariz es representada únicamente como dos puntos."));
        opciones.add(new Opcion(
                "7e) Orificios de la nariz",
                "Cualquier indicación clara de concavidad enla parte inferior de la nariz.",
                "Nariz plana sin orificios ni concavidad."));
        opciones.add(new Opcion(
                "8a) Precencia de cabello",
                "Cualquier indicación de que existe cabello.",
                "Completamente calvo."));
        opciones.add(new Opcion(
                "8b) Representación del cabello",
                "Los cabellos exceden la circunferencia de la cabeza, no son transparentes, no son garabatos y el contorno del cráneo no se ve a través del cabello.",
                "No cumple con las tres anteriores."));
        opciones.add(new Opcion(
                "9a) Precencia de ropa",
                "Cualquier indicación de prendas de vestir (botones, sombrero, lineas horizontales en el tronco, etc).",
                "Ningún indicio de vestimenta."));
        opciones.add(new Opcion(
                "9b) Dos prendas de vestir no transparentes",
                "Dos prendas que cubran u oculten partes del cuerpo.",
                "Solo una o ninguna prenda."));
        opciones.add(new Opcion(
                "9c) Ropa sin transparencia, con mangas y pantalones",
                "El dibujo está completo sin transparencia, tiene mangas y pantalones.",
                "No comple con las tres anteriores."));
        opciones.add(new Opcion(
                "9d) Cuatro o más artículos de vestir",
                "Posee cuatro prendas de vestir (sombrero, zapatos, paleto, camisa, cuello, corbata, tirantes, pantalón, etc).",
                "Tiene menos de cuatro o solo botones."));
        opciones.add(new Opcion(
                "9e) Vestimenta completa sin incongruencia",
                "Vestuario reconocible y de especie definida (ropa de tranajo, uniforme de soldado, etc).",
                "Prendas al azar que no hacen juego."));
        opciones.add(new Opcion(
                "10a) Indicación de dedos",
                "Tiene cualquier indicio de dedos, indiferentemente del diseño de estos.",
                "Carece completamente de dedos (por ejemplo manos bola)."));
        opciones.add(new Opcion(
                "10b) Número correcto de dedos",
                "Cinco dedos por mano.",
                "Más o menos que cinco dedos por mano."));
        opciones.add(new Opcion(
                "10c) Detalle de los dedos",
                "Los dedos son representaos en dos dimensiones, son más largos que anchos y en conjunto no forman un ángulo mayor que 180°.",
                "No comple con las tres indicaciones anteriores (dedos de palo, muy anchos o muy extendidos)."));
        opciones.add(new Opcion(
                "10d) Indicación del pulgar en oposición",
                "El pulgar está clarametne diferenciado de los demás dedos.\nEl ángulo que forma cualquier par de dedos es menor que la mitad del ángulo que forma el índice con el pulgar.\nLa inserción del pulgar se acerca más a la muñeca que al resto de dedos.",
                "El pulgar no se caracteriza de ninguna manera o no existe."));
        opciones.add(new Opcion(
                "10e) Indicación de la mano diferenciada del brazo o de los dedos",
                "Se percibe claramente la diferencia entre mano y brazo.\nSi tiene las manos en los bolsillos, se considera positivo si se logra notar la parte superior de estas, asomandas por el borde del bolsillo.",
                "Sin diferencia clara mano y brazo o con las manos completamente en los bolsillos."));
        opciones.add(new Opcion(
                "11a) Presencia de articulación el brazo, codo, hombro y manos",
                "Tiene articulación en el hombro.\nEl brazo debe colgar al costado en dirección aproximadamente paralela al cuerpo.\nUna curva indicadora de la articulación del hombro debe marcar la inserción de brazo en el tronco.",
                "Los codos y las rodillas son indicados con desconocimiento evidente de su función articulatoria."));
        opciones.add(new Opcion(
                "11b) Articulación de la pierna, rodilla, cadera o ambas",
                "La rodilla tiene una articulación en cono.\nEl codo hace una flexión angular hacia la mitad de la pierna.\nLa articulación de la pierna se indica por un adelgazamiento.\nLa cadera converge con las líneas interiores de las piernas.",
                "Carece de articulaciones."));
        opciones.add(new Opcion(
                "12a) Proporción de la cabeza",
                "La cabeza es aproximadametne 1/2 del tronco y 1/10 del cuerpo completo.",
                "Es muy grande o muy pequeña."));
        opciones.add(new Opcion(
                "12b) Proporción de los brazos",
                "La longitud de los brazos es igual o ligeramente mayor que la del tronco, pero no llega a la rodilla. El ancho es menor que el del tronco.",
                "Brazos muy cortos o muy largos."));
        opciones.add(new Opcion(
                "12c) Proporción de las piernas",
                "La longitud de las piernas puede ser igual o el doble que el tronco. El ancho debe ser menor que el del tronco.",
                "Piernas muy cortas o muy largas."));
        opciones.add(new Opcion(
                "12d) Proporción de los pies",
                "Los pies son más largos que altos, aproximadamente 1/3 que las piernas. El largo del pie es igual a 1/10 que las pernas.",
                "Pies como palos de golf."));
        opciones.add(new Opcion(
                "12e) Porporción de pies y brazos en dos dimensiones",
                "Tanto los pies como los brazos son dibujados en dos dismensiones, incluso si las manos son simples líneas.",
                "Brazos y pies de palo."));
        opciones.add(new Opcion(
                "13) Represetnación del taco",
                "Cualquier forma que represente clarametne el taco. También en los dibujos de frente con pie en perspectiva.",
                "No se distingue el taco."));
        opciones.add(new Opcion(
                "14a) Coordinación motora en primer grado",
                "Todas las líneas deben estar tratadas con cierta firmeza, los puntos de unión entre ellas serán netos, sin tendencia a entrecruzarlas o superponerlas o dejar espacios en blanco entre dos extremos.",
                "Las líneas son discontinuas o muy tenues."));
        opciones.add(new Opcion(
                "14b) Coordinación motora de segundo grado",
                "Todas las líneas son trazadas formemente y con unión correcta.",
                "Alguna línea no es trazada correctamente."));
        opciones.add(new Opcion(
                "14c) Coordinación motora: Contorno de la cabeza",
                "El contorno de la cabeza no tiene irregularidades inintencionadas. El dibujo de la cabeza acusa un progreso sobre las rudimentarias formas del círculo y elipse.",
                "La cabeza es irregular o tiene irregularidades accidentales."));
        opciones.add(new Opcion(
                "14d) Coordinación motora: Controrno del tronco",
                "El contorno del tronco no tiene irregularidades inintencionadas.",
                "El dibujo del tronco acusa formas primitivas del círculo o elipse."));
        opciones.add(new Opcion(
                "14e) Coordinación motora: Brazos y piernas",
                "Brazos y piernas sin irregularidades y sin estrechamientos en sus inserciones con el tronco. Miembos superiores e inferiores representados en dos dimensiones.",
                "Se estrechan en su inserción al tronco o simplemente son de palo."));
        opciones.add(new Opcion(
                "14f) Coordinacion motora: Facciones",
                "Relaciones de simetría en las facciones. Ojos equistandes con la nariz y de las comisuras de los labios. No deben estar en contacto absurdo con las líneas del contorno de la cabeza. La nariz de forma simétrica debe estar ubicada sobre el punto medio de la boca.",
                "La cara carece de simetría."));
        opciones.add(new Opcion(
                "15a) Presencia de orejas",
                "Posee dos orjeas de frente o una de perfil.",
                "Carece de orejas."));
        opciones.add(new Opcion(
                "15b) Orejas proporcionadas y correctamente ubicadas",
                "Si está de frente, el diámetro vertrical es mayor que el horizontal.\nSi está de perfil, posee algún detalle como un punto que represente el conducto auditivo.",
                "Desproporcionadas y sin detalle."));
        opciones.add(new Opcion(
                "16a) Detalles del ojo: Cejas, pestañas o ambas",
                "Tiene cualquier indicador claro de representar cejas o pestañas.",
                "Carece completamente de ellas."));
        opciones.add(new Opcion(
                "16b) Detalle del ojo: Pupila",
                "La pupila se encuentra presente en ambos ojos.",
                "Carece de pupilas."));
        opciones.add(new Opcion(
                "16c) Detalle del ojo: Proporción",
                "Diámetro horizontal y mayor que el vertical. Si está de frente, ambos deben serlo. Si está de perfil, solo uno",
                "Ojos de diámetro vertical mayor que el horizontal."));
        opciones.add(new Opcion(
                "16d) Detalle del ojo: Mirada",
                "La cara debe verse de perfil. La pupila debe señalarse desplazada hacia adelante.",
                "Mirada desorvitada o viendo a cualquier dirección."));
        opciones.add(new Opcion(
                "17a) Representación de la frente y el mentón",
                "Si está de frente, debe existir espacio arriba del ojo y debajo del labio inferior.\nSi está de perfil, deben expresarse prominencias de la frente y mentón.",
                "Los ojos y la boca están tan pegados al contorno que carece de frente o mentón."));
        opciones.add(new Opcion(
                "17b) Representación de la proyección del mentón: Barbilla claramente diferenciada del labio inferior",
                "El mentón está modelado de alguna manera clara, como una lína curva debajo del labio inferior. Por lo general solo se acredita en los dibujos de perfil.",
                "El mentón no está concretamente definido"));
        opciones.add(new Opcion(
                "18a) Perfil sin más de un error",
                "La babeza, el tronco y los pies deben verse de perfil sin errores.\nEl dibujo completó podrá tener únicamente un error:\na) Una transparencia (que se vea el contorno a través del brazo).\nb) Piernas que no estén de perfil.\nc) Brazos unidos al borde de la espalda y que se extienden hacia adelante.",
                "El perfil contiene más de uno de los errores anteriores."));
        opciones.add(new Opcion(
                "18b) Perfil correcto",
                "La figura debe mostrar un perfil correcto o transparencia. Puede exceptuarse la perspectiva del ojo.",
                "La figura tiene un perfil incorecto."));
        
        Opcion op = opciones.get(actual);
        lblTitulo.setText(op.titulo);
        txtOpcion1.setText(op.positiva);
        txtOpcion2.setText(op.negativa);
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
        btnAnterior = new javax.swing.JButton();
        btnFinalizar = new javax.swing.JButton();

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

        lblTitulo.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(imgDibujo, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(radOpcion2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(radOpcion1, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAnterior)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnFinalizar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSiguiente)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 14, Short.MAX_VALUE)
                        .addComponent(imgDibujo, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(radOpcion1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(radOpcion2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
            if (actual < 51){
                siguienteOpcion();
            } else {
                JOptionPane.showMessageDialog(null, "Ya estás en la última pregunta.",
                    "Error", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debes seleccionar alguna opción.",
                    "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnSiguienteMouseClicked

    private void btnAnteriorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAnteriorMouseClicked
        if (actual > 0){
            anteriorOpcion();
        } else {
            JOptionPane.showMessageDialog(null, "Ya estás en la primer pregunta.",
                    "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnAnteriorMouseClicked

    private void btnFinalizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFinalizarMouseClicked
        JOptionPane.showMessageDialog(
                null, "Has respondido a " + String.valueOf(51 - Collections.frequency(calificacion, null)) + " / 51",
                "Error", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnFinalizarMouseClicked

    private void siguienteOpcion() {
        
        if (calificacion.get(actual) == null || calificacion.get(actual) != Califica()) {
            calificacion.set(actual, Califica());
        }
        ++actual;
        Opcion op = opciones.get(actual);
        lblTitulo.setText(op.titulo);
        txtOpcion1.setText(op.positiva);
        txtOpcion2.setText(op.negativa);
        
        if (calificacion.get(actual) == null) {
            radOpcion1.setSelected(false);
            radOpcion2.setSelected(false);
            radGroup.clearSelection();
        } else {
            radGroup.clearSelection();
            radOpcion1.setSelected(calificacion.get(actual) == Calificacion.POSITIVO);
            radOpcion2.setSelected(calificacion.get(actual) == Calificacion.NEGATIVO);
        }
        
        if (actual == 37 && calificacion.get(36) == Calificacion.NEGATIVO) {
            radGroup.clearSelection();
            radOpcion1.setSelected(false);
            radOpcion2.setSelected(true);
        }
    }
    
    private void anteriorOpcion() {
        --actual;
        Opcion op = opciones.get(actual);
        lblTitulo.setText(op.titulo);
        txtOpcion1.setText(op.positiva);
        txtOpcion2.setText(op.negativa);
        
        radGroup.clearSelection();
        radOpcion1.setSelected(calificacion.get(actual) == Calificacion.POSITIVO);
        radOpcion2.setSelected(calificacion.get(actual) == Calificacion.NEGATIVO);
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
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnFinalizar;
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
