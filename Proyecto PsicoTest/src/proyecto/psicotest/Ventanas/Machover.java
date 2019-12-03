/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.psicotest.Ventanas;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.IOException;
import static java.lang.Double.max;
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
    Point img_pos = new Point(0,0);
    Point2D.Double img_sca = new Point2D.Double(1,1);
    Point mouse_pos;
    
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
        opciones.add(new Opcion("Boca", new Razgo[]{
            new Razgo("El énfasis excesivo y la proyección de la boca", "Capricho de los alimentos y a los síntomas gástricos, lenguaje incidente y arranques de mal humor"),
            new Razgo("Boca detallada con dientes a la vista", "Si es adulto infantilidad y agresión oral, si es niño deficientes mentales"),
            new Razgo("La lengua es indicada", "Señal eróticca primitiva. Posible impotencia sexual"),
            new Razgo("La boca está representada por una gruesa línea entrecortada", "Agresión"),
            new Razgo("La boca es una línea simple con una marcada expresión de tensión", "Ha tenido experiencias con la felación"),
            new Razgo("La boca es una línea amplia, tornada hacia arriba, dando el efecto de un payaso haciendo mueca", "Esfuerzo por ganar aprobación"),
            new Razgo("Omite la boca", "Puede ser asmático")}));
        opciones.add(new Opcion("Labios", new Razgo[]{
            new Razgo("Labios gruesos en figura masculina", "Signo de afeminamiento"),
            new Razgo("Labios como 'arcos de cupido'", "Sexualmente precoces"),
            new Razgo("Línea fuera de lugar colocada entre los labios de manera de palillo de dientes", "Historia de erotismo oral en sus relaciones sexuales"),
            new Razgo("Inclusión de llamativo cigarrillo", "Énfasis erótico-anal")}));
        opciones.add(new Opcion("Ojos", new Razgo[]{
            new Razgo("Mucho énfasis en los ojos", "Paranoide"),
            new Razgo("Ojos penetrantes", "Actitud socialmente agresiva"),
            new Razgo("Ojo grande, oscuro, acentuado o amenazante con hostilidad o sospecha", "Paranoide"),
            new Razgo("Ojos grandes con pestañas y tacón alto", "Inclinaciones homosexuales"),
            new Razgo("El área de la órbita del ojo es grande pero el ojo pequeño", "Fuerte curiosidad visual pero con culpa"),
            new Razgo("Ojos cerrados", "Cierra el mundo a propósito para aislarse mejor en su propio narcisismo"),
            new Razgo("Ojo vacío", "Inmadurez emocional y egocentrismo")}));
        opciones.add(new Opcion("Ceja", new Razgo[]{
            new Razgo("Ceja bien arreglada", "Refinamiento y cuidado personal"),
            new Razgo("Ceja peluda", "Características primitavas, ásperas y no inhibidas"),
            new Razgo("Ceja levantada", "Desdén, arrogancia o duda")}));
        opciones.add(new Opcion("Oreja", new Razgo[]{
            new Razgo("Se destaca por el tamaño, reforzamiento, forma, colocación, borraduras o transparencia a través del pelo", "Reacciones a la crítica u opinión social o alucinaciones auditivas (en cuyo caso el grado de distorsión es la intensidad de la experiencia auditiva)"),
            new Razgo("Énfasis en la oreja", "Paranoide cauteloso, sospechoso y desconfiado")}));
        opciones.add(new Opcion("Pelo", new Razgo[]{
            new Razgo("Énfasis en el pelo de la cabeza, pecho, barba o bigote", "Pujanza viril"),
            new Razgo("Pelo desordenado", "Desorden sexual"),
            new Razgo("Hembra con pelo desordenado y abundante. Varón con peinado cuidadoso y preciso", "Hostilidad hacia la mujer. Hombre psicosexual inmaduro"),
            new Razgo("Énfasis en el pelo ondulado, hechizante, en forma de cascada combinado con otros detalles cosméticos llamativos", "Muchacha delincuente sexual o aspira deslumbrar por su apariencia"),
            new Razgo("Pelo en la quijada", "Adolescente cuyo conlictos de virilidad se han convertido en rasgos esquizoides")}));
        opciones.add(new Opcion("Nariz", new Razgo[]{
            new Razgo("Nariz sombreada o cortada", "Temores de castración a causa de prácticas onanistas"),
            new Razgo("Nariz reforzada", "Sugiere intento de compensación a causa de una sexualidad inadecuada"),
            new Razgo("Nariz excesivamente larga", "Hombre con impotencia sexual"),
            new Razgo("Corte en la nariz", "Adolescente indeciso o con problemas sexuales"),
            new Razgo("Ventanas de la nariz señaladas", "Agresión")}));
        opciones.add(new Opcion("Cuello", new Razgo[]{
            new Razgo("Cuello alto y delgado", "Moralista, educado, rígido."),
            new Razgo("Cuello corto", "Impulsivo y de mal humor"),
            new Razgo("Omisión del cuello", "Inmadurez, deficientes mentales e individuos regresivos"),
            new Razgo("Cuello largo y muy fino", "Esquizoide o esquizofrénico")}));
        opciones.add(new Opcion("Nuez de Adán", new Razgo[]{
            new Razgo("Especial interés en la nuez de Adán", "Sexualmente débil que se halla confundido acerca de su propio papel sexual")}));
        opciones.add(new Opcion("Brazos y manos", new Razgo[]{
            new Razgo("Manos oscuresidas o contornos imprecisos", "Falta de confianza en los contactos sociales"),
            new Razgo("Manos sombreadas vigorosamente", "Culpabilidad con relación a los impulsos agresivos o de actividad onanísticas"),
            new Razgo("Manos detrás de la espalda", "Muchacha jóven que aspira a fascinar y se apena por comerse las uñas"),
            new Razgo("Manos en los bolsillos", "Masturbación y haranganería"),
            new Razgo("Omisión del brazo en la figura femenina", "Ha sido rechazado por su madre y/o otras mujeres"),
            new Razgo("Brazo exremadamente largo", "Ambición"),
            new Razgo("Mano en la región genital", "individuo con prácticas onanistas")}));
        opciones.add(new Opcion("Dedos de la mano", new Razgo[]{
            new Razgo("Sin dedos de mano", "Agresión infantil"),
            new Razgo("Dedos cortos y redondos", "Poca habilidad manual e infantilidad"),
            new Razgo("Dedos severamente sombreados o forzados", "Indicadores de culpabilidad, principalmente referida al robo y masturbación"),
            new Razgo("Dedos en forma de lanza o de talón", "Paranoide y agresivo"),
            new Razgo("Puño cerrado con brazo extendido", "Adolescente delincuente rebelde"),
            new Razgo("Mano con dedos cuidadosamente articulados pero cerrada con una línea", "Cierra la posibilidad de contacto. Agresión reprimida."),
            new Razgo("Dedos anormalmente largos", "Rasgos agresivos"),
            new Razgo("Más de cinco dedos en cada mano", "Ambicioso y agresivo"),
            new Razgo("Se dubijan conyunturas y uñas cuidadosamente destacadas", "Control obsesivo de la agresión"),
            new Razgo("Dedos en forma de garra o herramienta mecánica", "Agresión")}));
        opciones.add(new Opcion("Tronco", new Razgo[]{
            new Razgo("Tronco redondeado", "Poca agresividad y mucha feminidad"),
            new Razgo("Tronco anguloso", "masculinidad"),
            new Razgo("Se muestra reacio a cerrar la parte inferior del tronco", "Indicativo de preocupación sexual"),
            new Razgo("Cuerpo especialmente delgado", "Descontento con su propio cuerpo")}));
        opciones.add(new Opcion("Senos", new Razgo[]{
            new Razgo("Senos sombreados, borrados", "Varón emocionalmente y psicosexualmente inmaduro"),
            new Razgo("Busto acentuado y caderas desarrolladas", "Madre productiva y dominante"),
            new Razgo("Adolescente con senos grandes", "Deseos de madurez y desarrollo como madre"),
            new Razgo("Adolescente con senos pequeños", "Timidez y temor a la madurez")}));
        opciones.add(new Opcion("Hombros", new Razgo[]{
            new Razgo("Hombros destacados", "Hombre con insuficiencia corporal o mujer con protesta viril"),
            new Razgo("Hombros con borraduras, refuerzos e incertidumbres", "Preocupación respecto a la masculinidad")}));
        opciones.add(new Opcion("Caderas y nalgas", new Razgo[]{
            new Razgo("Atención especial en caderas y nalgas como líneas confusas, interrupción, cambios abruptos o ampliación destacada", "Varón con conflictos homosexuales"),
            new Razgo("Línea exagerada en las caderas", "Conciencia de poder")}));
        opciones.add(new Opcion("Línea de la cintura", new Razgo[]{
            new Razgo("Las tres zonas del cuerpo (cabeza, tronco y cintura para abajo) se dibujan separadas o desviadas de su línea natural", "Insuficiencia en la integración de la personalidad"),
            new Razgo("Cintura excesivamente apretada, dando apariencia de corsé", "Control precario que puede irrumpir en arranques impulsivos")}));
        opciones.add(new Opcion("Indicaciones anatómicas", new Razgo[]{
            new Razgo("Indicaciones claras de los órganos internos", "Maniático o esquizofrénico"),
            new Razgo("Piernas con pantalón transparente", "Temor sexual"),
            new Razgo("Colocación de unas cuantas líneas incompletas en el pecho o en la región pélvica", "Conciencia somática")}));
        opciones.add(new Opcion("Articulaciones", new Razgo[]{
            new Razgo("Dibujo muy pequeño", "Evasión frente a los problemas del cuerpo"),
            new Razgo("Articulaciones definidas", "Fortaleza")}));
        opciones.add(new Opcion("Ropa", new Razgo[]{
            new Razgo("Ropa adornada", "Narcisista de la ropa, superficial y extrovertido"),
            new Razgo("Cuerpo musculoso", "Narcisista del cuerpo, concentrados en sí mismos e introvertidos. Se hallan preocupados por la apariencia y su cuerpo en general. Sexualmente probable que se restrinja o cohiba.")}));
        opciones.add(new Opcion("Botones", new Razgo[]{
            new Razgo("Énfasis en los botones", "Dependiente, infantil y desadaptado"),
            new Razgo("Botones en uniforme", "Complejo de sumisión a la autoridad")}));
        opciones.add(new Opcion("Bolsillos", new Razgo[]{
            new Razgo("Tiene bolsillos", "Adolescente o niño que expresa lucha de la virilidad que antagoniza con la dependencia emocional de la madre")}));
        opciones.add(new Opcion("Zapato y sombrero", new Razgo[]{
            new Razgo("Zapato con forma de pene y/o con borraduras", "Hombre impotente o mujer con impulsos sexuales"),
            new Razgo("Con sombrero y sin ropa", "Signos de regresión"),
            new Razgo("Sombrero transparente", "Conducta sexual primitiva"),
            new Razgo("Pipa, cigarrillo, pistola o bastón", "Impulsos sexuales"),
            new Razgo("Cartera grande y sencilla sobre el área sexual", "Se esfuerza por superar sus actuales dificultades sexuales"),
            new Razgo("Señalamiento específico del pliegue del pantalón", "Preocupación por la masturbación")}));
        opciones.add(new Opcion("Temática", new Razgo[]{
            new Razgo("Dibujo de una figura del propio sexo más jóven que el propio sujeto", "Deseos de volver a edades anteriores"),
            new Razgo("Dibujo de un personaje ridículo como representación de una persona seria", "Evasión ante los sentimientos de inferioridad física"),
            new Razgo("Dibujo de una figura vieja", "Identidad con la imagen de los padres")}));
        opciones.add(new Opcion("Acción o movimiento", new Razgo[]{
            new Razgo("Está caminando, combatiendo, saludando, etc", "Tendencia a la fantasía"),
            new Razgo("El dibujo indica un impulso claro hacia el movimiento, pero se halla bloqueado y contrarrestado por rasgos estáticos o introvertidos", "Esquizoide o esquizofrénico")}));
        opciones.add(new Opcion("Sucesión", new Razgo[]{
            new Razgo("Dibuja desordenadamente", "Impulso desordenado, exitación maníaca o pensamiento esquizofrenico"),
            new Razgo("Dibuja parte a parte con temor a adentrarse en el todo", "Precavido y/o compulsivo"),
            new Razgo("Indecisión para proseguir más allá de la cabeza o la cintura", "Temor para enfrentarse a los conflictos"),
            new Razgo("Comienza con el sombrero en lugar de la cabeza, dibuja la cabeza al final, inicia con los rasgos faciales o dibuja de pies a cabeza", "Incapacidad para tratar de lobrar el propio equilibrio emocional")}));
        opciones.add(new Opcion("Simetría", new Razgo[]{
            new Razgo("Exceso de simetría", "Defensa contra lo repimido y/o contra un medio ambiente amenazador. Compulsivo y/o emocionalmente fríos. Personalidad precariamente controlada."),
            new Razgo("Perfeccionismo o exhibicionismo", "Defensa contra la despersonalización"),
            new Razgo("Confusión en la simetría", "Neurótico"),
            new Razgo("Descuido en la simetría", "Hipomaniaco o histérico")}));
        opciones.add(new Opcion("Línea media", new Razgo[]{
            new Razgo("Énfasis en la línea media", "Preocupación somática, sentimiento de inferioridad corporal, inmadurez emocional y dependencia materna"),
            new Razgo("Hilera de botones", "Esquizoides o esquizofrénicos cuya inferioridad física y dependencia maternal predominan"),
            new Razgo("Énfasis imperfecto a la línea media", "Infantil, narcisista que se aproximan a una declinación involucional y son incapaces de aceptarlo")}));
        opciones.add(new Opcion("Tamaño y colocación", new Razgo[]{
            new Razgo("Dibujo a la derecha de la página", "Se encuentra en el medio ambiente"),
            new Razgo("Dibujo a la izquierda", "Se halla orientado por sí mismo"),
            new Razgo("Dibujo en la parte alta", "Optimismo"),
            new Razgo("Dibujo en la parte baja", "Depresión")}));
        /*
        opciones.add(new Opcion("Postura", new Razgo[]{
            new Razgo("", ""),
            new Razgo("", "")}));
        opciones.add(new Opcion("Perspectiva", new Razgo[]{
            new Razgo("", ""),
            new Razgo("", "")}));
        opciones.add(new Opcion("Tipo de línea", new Razgo[]{
            new Razgo("", ""),
            new Razgo("", "")}));
        opciones.add(new Opcion("Indicadores de conflicto", new Razgo[]{
            new Razgo("", ""),
            new Razgo("", "")}));
        opciones.add(new Opcion("Borraduras", new Razgo[]{
            new Razgo("", ""),
            new Razgo("", "")}));
        opciones.add(new Opcion("Sombreamiento", new Razgo[]{
            new Razgo("", ""),
            new Razgo("", "")}));
        opciones.add(new Opcion("Tratamiento diferencial de las figuras masculinas y femeninas", new Razgo[]{
            new Razgo("", ""),
            new Razgo("", "")}));
        opciones.add(new Opcion("Consideraciones sobre el desarrollo", new Razgo[]{
            new Razgo("", ""),
            new Razgo("", "")}));
        */
        
        Opcion op = opciones.get(actual);
        lstModelEs.clear();
        lstModelNoEs.clear();
        lstElDibujoEs.setModel(lstModelEs);
        lstElDibujoNoEs.setModel(lstModelNoEs);
        
        for (int i=0; i<opciones.size(); ++i) {
            cbxTitulo.addItem(opciones.get(i).titulo);
        }
        
        /*
        for (int i=0; i<op.razgos.size(); ++i) {
            lstModelNoEs.addElement(op.razgos.get(i).razgo);
        }*/
        cbxTitulo.setSelectedItem(0);
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
        btnSiguiente = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstElDibujoEs = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        lstElDibujoNoEs = new javax.swing.JList<>();
        cbxTitulo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(9999, 9999));
        setMinimumSize(new java.awt.Dimension(675, 530));
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
        imgDibujo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                imgDibujoMouseDragged(evt);
            }
        });
        imgDibujo.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                imgDibujoMouseWheelMoved(evt);
            }
        });
        imgDibujo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imgDibujoMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                imgDibujoMousePressed(evt);
            }
        });

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

        lstElDibujoEs.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lstElDibujoEs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstElDibujoEsMouseClicked(evt);
            }
        });
        lstElDibujoEs.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lstElDibujoEsKeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(lstElDibujoEs);

        lstElDibujoNoEs.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lstElDibujoNoEs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstElDibujoNoEsMouseClicked(evt);
            }
        });
        lstElDibujoNoEs.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lstElDibujoNoEsKeyPressed(evt);
            }
        });
        jScrollPane4.setViewportView(lstElDibujoNoEs);

        cbxTitulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cbxTitulo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxTituloItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxTitulo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(imgDibujo, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnFinalizar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAnterior)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSiguiente))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
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
                .addComponent(cbxTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(imgDibujo, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
                        .addContainerGap(22, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(22, Short.MAX_VALUE))))
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
        /*
        String s = "Dado lo que respondió el paciente, su diagnóstico es el siguiente:\n\n";
        for (int i=0; i<opciones.size(); ++i) {
            Opcion op = opciones.get(i);
            for (int j=0; j<op.razgos.size(); ++j) { 
                if (op.razgos.get(j).tiene)
                    s += op.razgos.get(j).descripcion + ".\n";
            }
        }
        JOptionPane.showMessageDialog(null, s, "Respuestas", JOptionPane.INFORMATION_MESSAGE);
        */
        MachoverReporte abrir = new MachoverReporte(mm, img, opciones, img_pos, img_sca); //Abrir la ventana del formulario al terminar de llenar el Test
        abrir.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnFinalizarMouseClicked

    private static BufferedImage resize(BufferedImage img, int width, int height) {
        //Image tmp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        Image tmp = img;
        BufferedImage resized = new BufferedImage(
                (int) max(img.getWidth(), width), 
                (int) max(img.getHeight(), height), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = resized.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        return resized;
    }
    
    private void imgDibujoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgDibujoMouseClicked
        if (evt.getClickCount() != 2)
            return;
        
        if (fc.showDialog(this, "Aceptar") == 0)
        {
            try {
                img_pos.x = 0;
                img_pos.y = 0;
                img_sca.x = 1;
                img_sca.y = 1;
    
                img = resize(ImageIO.read(fc.getSelectedFile()), imgDibujo.getWidth(), imgDibujo.getHeight());
                
                imgDibujo.setText("");
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
        if (actual+1 < opciones.size()){
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

    private void cbxTituloItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxTituloItemStateChanged
        actual = cbxTitulo.getSelectedIndex();
        Opcion op = opciones.get(actual);
        
        lstModelEs.clear();
        lstModelNoEs.clear();
        for (int i=0; i<op.razgos.size(); ++i)
            if (op.razgos.get(i).tiene)
                lstModelEs.addElement(op.razgos.get(i).razgo);
            else
                lstModelNoEs.addElement(op.razgos.get(i).razgo);
    }//GEN-LAST:event_cbxTituloItemStateChanged

    private void img_repaint()
    {
        if (img == null)
            return;
        
        int w = img.getWidth();
        int h = img.getHeight();
        
        BufferedImage newimg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        
        AffineTransform at = new AffineTransform();
        at.scale(img_sca.x, img_sca.y);
        at.translate(img_pos.x, img_pos.y);
        
        AffineTransformOp scaleOp = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
        newimg = scaleOp.filter(img, newimg);
        
        imgDibujo.setIcon(new ImageIcon(newimg));
        
        imgDibujo.repaint();
    }
    
    private void imgDibujoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgDibujoMousePressed
        mouse_pos = evt.getPoint();
        img_repaint();
    }//GEN-LAST:event_imgDibujoMousePressed

    private void imgDibujoMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgDibujoMouseDragged
        img_pos.x += evt.getX() - mouse_pos.x;
        img_pos.y += evt.getY() - mouse_pos.y;
        
        mouse_pos = evt.getPoint();
        img_repaint();
    }//GEN-LAST:event_imgDibujoMouseDragged

    private void imgDibujoMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_imgDibujoMouseWheelMoved
        img_sca.x -= evt.getWheelRotation() * 0.1;
        img_sca.y -= evt.getWheelRotation() * 0.1;
        
        if (img_sca.x <= 0) img_sca.x = 0.1;
        if (img_sca.y <= 0) img_sca.y = 0.1;
        if (img_sca.x > 10) img_sca.x = 10;
        if (img_sca.y > 10) img_sca.y = 10;
        
        img_repaint();
    }//GEN-LAST:event_imgDibujoMouseWheelMoved

    private void lstElDibujoEsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lstElDibujoEsKeyPressed
        
        int index = lstElDibujoEs.getSelectedIndex();
        lstModelNoEs.addElement(lstModelEs.get(index));
        lstModelEs.remove(index);
        
        recalcularSeleccionados();
    }//GEN-LAST:event_lstElDibujoEsKeyPressed

    private void lstElDibujoNoEsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lstElDibujoNoEsKeyPressed
        
        int index = lstElDibujoNoEs.getSelectedIndex();
        lstModelEs.addElement(lstModelNoEs.get(index));
        lstModelNoEs.remove(index);
        
        recalcularSeleccionados();
    }//GEN-LAST:event_lstElDibujoNoEsKeyPressed

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
        cbxTitulo.setSelectedIndex(actual);
        
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
        cbxTitulo.setSelectedIndex(actual);
        
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
    private javax.swing.JComboBox<String> cbxTitulo;
    private javax.swing.JLabel imgDibujo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JList<String> lstElDibujoEs;
    private javax.swing.JList<String> lstElDibujoNoEs;
    // End of variables declaration//GEN-END:variables
}
