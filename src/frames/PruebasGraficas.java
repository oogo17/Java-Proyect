package frames;

import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.freixas.jcalendar.DateEvent;

import org.freixas.jcalendar.JCalendarCombo;

/**
 *
 * @author IvanSnek
 */
public class PruebasGraficas extends javax.swing.JFrame {

    private int contador_primer_caracter;
    private int contadortbla;
 
  
    JCalendarCombo calEjemplo2;

    public PruebasGraficas() {
        initComponents();
        iconoerror.setVisible(false);
        iconoerror1.setVisible(false);
        contador_primer_caracter = 0;
      
        
           //Se declara el combo para el calendario
        calEjemplo2 = new JCalendarCombo();
        //Se inicializa el Campo de texto cuando se carga la ventana
         txtfecha.setText(calEjemplo2.getSelectedItem().toString());
        //Se le agrega un DateListener al combo para capturar la fecha
        calEjemplo2.addDateListener( new org.freixas.jcalendar.DateListener(){

        
            
            //Si se sobre-lleva el metodo del cambio de fecha q se acciona cuando se elige una fecha del JCalendarCombo
            @Override
            public void dateChanged(DateEvent de) {
                 
                //SE invova al metodo que hara las acciones pertinentes 
                calendario_DateChanged(de);
                
            }

        });
         panelfecha.add(calEjemplo2).setBounds(30, 20, 230, 45);
         System.out.println(calEjemplo2.getDate().toString());
        this.setLocationRelativeTo(null);
       
      
        contadortbla = 0;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        boton = new javax.swing.JButton();
        formato1 = new javax.swing.JFormattedTextField();
        texto_numero_unespacio = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        iconoerror = new javax.swing.JLabel();
        Correo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        iconoerror1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        items = new javax.swing.JComboBox();
        botonitems = new javax.swing.JButton();
        textoespacio = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        lbltexto = new javax.swing.JLabel();
        nombreteclas = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblnombreteclas = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        columna = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        renglon = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        panelfecha = new javax.swing.JPanel();
        txtfecha = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        boton.setText("Posicionar");
        boton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActionPerformed(evt);
            }
        });

        try {
            formato1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        formato1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                formato1FocusLost(evt);
            }
        });

        texto_numero_unespacio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                texto_numero_unespacioKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                texto_numero_unespacioKeyTyped(evt);
            }
        });

        jLabel3.setText("Validacion letra-numero solo un espacio:");

        jLabel4.setText("Formato de solo 5 numeros:");

        iconoerror.setForeground(new java.awt.Color(102, 0, 0));
        iconoerror.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botonCerrarRojo.png"))); // NOI18N
        iconoerror.setText("Debe tener 5 digitos");

        Correo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CorreoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CorreoKeyTyped(evt);
            }
        });

        jLabel5.setText("Correo:");

        iconoerror1.setForeground(new java.awt.Color(102, 0, 0));
        iconoerror1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botonCerrarRojo.png"))); // NOI18N

        jButton1.setText("Ir a PAgina Proveedor");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###0"))));

        items.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4", "asdasd", "adasd", "fjdjdjd", "asdaa", "asd", "as", "a" }));
        items.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                itemsItemStateChanged(evt);
            }
        });

        botonitems.setText("Focus");
        botonitems.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonitemsActionPerformed(evt);
            }
        });

        jButton2.setText("espacios");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        lbltexto.setBackground(new java.awt.Color(204, 204, 204));
        lbltexto.setForeground(new java.awt.Color(0, 51, 204));
        lbltexto.setText("jLabel6");
        lbltexto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        nombreteclas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nombreteclasKeyPressed(evt);
            }
        });

        jLabel6.setText("Nombre de Teclas:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("=");

        lblnombreteclas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        columna.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                columnaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                columnaKeyReleased(evt);
            }
        });

        jLabel2.setText("Columna:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(columna, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(columna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Renglon:");

        renglon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                renglonKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                renglonKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(renglon, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(renglon)
                    .addComponent(jLabel1))
                .addGap(4, 4, 4))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jScrollPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tabla.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tabla.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        tabla.setRowHeight(25);
        jScrollPane1.setViewportView(tabla);

        panelfecha.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout panelfechaLayout = new javax.swing.GroupLayout(panelfecha);
        panelfecha.setLayout(panelfechaLayout);
        panelfechaLayout.setHorizontalGroup(
            panelfechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelfechaLayout.createSequentialGroup()
                .addContainerGap(345, Short.MAX_VALUE)
                .addComponent(txtfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );
        panelfechaLayout.setVerticalGroup(
            panelfechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelfechaLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(txtfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(Correo, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(formato1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(iconoerror)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(iconoerror1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(texto_numero_unespacio, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(boton)
                .addGap(254, 254, 254))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(nombreteclas, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)
                                .addGap(20, 20, 20)
                                .addComponent(lblnombreteclas, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(botonitems)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(items, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(textoespacio, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)
                        .addGap(29, 29, 29)
                        .addComponent(lbltexto, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 869, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(panelfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(panelfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(texto_numero_unespacio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(formato1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(iconoerror)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(boton)
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Correo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(iconoerror1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jButton1)))
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoespacio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(lbltexto))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(items, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonitems))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreteclas, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(lblnombreteclas, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE))
                .addGap(44, 44, 44))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Metodo asociado al evento que se dispara al seleccionar un elemento del JCalendarCombo
   private void calendario_DateChanged(org.freixas.jcalendar.DateEvent evt) {                                           
       
               txtfecha.setText(calEjemplo2.getSelectedItem().toString());

}
    private void botonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActionPerformed
        if (!renglon.getText().equals("") && !columna.getText().equals("")) {
            tabla.editCellAt(Integer.parseInt(renglon.getText()), Integer.parseInt(columna.getText()));
            Component aComp = tabla.getEditorComponent();
            aComp.requestFocus();

        }

    }//GEN-LAST:event_botonActionPerformed

    private void renglonKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_renglonKeyTyped
        char c = evt.getKeyChar();
        System.out.println(Character.getName(c));
//        System.out.println(Character.g);
    }//GEN-LAST:event_renglonKeyTyped

    private void texto_numero_unespacioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_texto_numero_unespacioKeyTyped
        char c = evt.getKeyChar();
        if (!Character.getName(c).equals("SPACE") && Character.isLetterOrDigit(c) == false && !Character.getName(c).equals("FULL STOP")) {
            evt.consume();
        }
    }//GEN-LAST:event_texto_numero_unespacioKeyTyped

    private void texto_numero_unespacioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_texto_numero_unespacioKeyReleased
        String ContenidoNuevo[] = texto_numero_unespacio.getText().split(" ");
        String aux = "";
        char c = evt.getKeyChar();
        if (!texto_numero_unespacio.getText().equals("")) {
            if (Character.getName(c).equals("SPACE")) {
                for (int i = 0; i < ContenidoNuevo.length; i++) {
                    aux = aux + ContenidoNuevo[i] + " ";
                }
                texto_numero_unespacio.setText(aux);
            }
        }
    }//GEN-LAST:event_texto_numero_unespacioKeyReleased

    private void formato1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formato1FocusLost
        String aux[] = formato1.getText().split(" ");
        if (!formato1.getText().equals("     ")) {
            if (aux[0].length() < 5) {
                iconoerror.setVisible(true);
            } else {
                iconoerror.setVisible(false);
            }
        }

    }//GEN-LAST:event_formato1FocusLost

    private void CorreoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CorreoKeyReleased
        char correo1[] = Correo.getText().toCharArray();
        String aux = "";
        if (!Correo.getText().equals("")) {
            if (Correo.getText().length() >= 3) {
                if (correo1[correo1.length - 1] == correo1[correo1.length - 2] && !Character.isLetter(correo1[correo1.length - 1]) && !Character.isLetter(correo1[correo1.length - 2])) {
                    for (int i = 0; i < correo1.length - 1; i++) {
                        aux = aux + correo1[i];
                    }
                    Correo.setText(aux);
                }
            }
            if (!isEmail(Correo.getText())) {
                iconoerror1.setVisible(true);


            } else {
                iconoerror1.setVisible(false);

            }
        } else {
            contador_primer_caracter = 0;
        }
    }//GEN-LAST:event_CorreoKeyReleased

    private void CorreoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CorreoKeyTyped
        char c = evt.getKeyChar();

        if (!Character.isLetter(c) && contador_primer_caracter == 0) {
            evt.consume();
        } else {
            if (!Character.isLetterOrDigit(c) && !Character.getName(c).equals("FULL STOP") && !Character.getName(c).equals("COMMERCIAL AT") && !Character.getName(c).equals("HYPHEN-MINUS") && !Character.getName(c).equals("LOW LINE")) {
                evt.consume();

            } else {
                contador_primer_caracter += 1;
            }

        }

    }//GEN-LAST:event_CorreoKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler http://www.google.com/");
        } catch (IOException ex) {
            Logger.getLogger(PruebasGraficas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void renglonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_renglonKeyPressed
        if (KeyEvent.getKeyText(evt.getKeyCode()).equals("Intro")) {
            tabla.setValueAt("hola", contadortbla, 0);
            tabla.setValueAt("hola", contadortbla, 1);
            tabla.setValueAt("hola", contadortbla, 2);
            tabla.setValueAt("hola", contadortbla, 3);
            tabla.setValueAt("hola", contadortbla, 4);
            tabla.setValueAt("hola", contadortbla, 5);
            contadortbla += 1;
            renglon.setText("");
        } else {
            if (KeyEvent.getKeyText(evt.getKeyCode()).equals("Espacio")) {
                columna.requestFocus();
            }
        }
//        System.out.println(KeyEvent.getKeyText(evt.getKeyCode()))

    }//GEN-LAST:event_renglonKeyPressed

    private void botonitemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonitemsActionPerformed
        items.requestFocus();
        items.showPopup();
        items.setSelectedIndex(0);
    }//GEN-LAST:event_botonitemsActionPerformed

    private void columnaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_columnaKeyReleased
        char c = evt.getKeyChar();

        System.out.println(KeyEvent.getKeyText(evt.getKeyCode()));


    }//GEN-LAST:event_columnaKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String arreglo[] = textoespacio.getText().split(" ");
        String aux = "";
        for (int i = 0; i < arreglo.length; i++) {
            aux = aux + arreglo[i];
        }
        lbltexto.setText(aux + ".");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void nombreteclasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreteclasKeyPressed
        lblnombreteclas.setText(KeyEvent.getKeyText(evt.getKeyCode()));
    }//GEN-LAST:event_nombreteclasKeyPressed

    private void columnaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_columnaKeyPressed
        if (KeyEvent.getKeyText(evt.getKeyCode()).equals("Intro")) {

            tabla.setValueAt(columna.getText(), 0, 1);
            renglon.setText("");
            renglon.requestFocus();
        }
    }//GEN-LAST:event_columnaKeyPressed

    private void itemsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_itemsItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_itemsItemStateChanged
    public boolean isEmail(String correo) {
        Pattern pat = null;
        Matcher mat = null;
        pat = Pattern.compile("^[a-zA-Z][\\w\\-\\_]+(\\.[\\w\\-\\_]+)*@([A-Za-z0-9-]+\\.)+[A-Za-z]{2,4}$");

        mat = pat.matcher(correo);
        if (mat.find()) {

            return true;
        } else {
            return false;
        }
    }

    public static void main(String args[]) {

        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PruebasGraficas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PruebasGraficas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PruebasGraficas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PruebasGraficas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new PruebasGraficas().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Correo;
    private javax.swing.JButton boton;
    private javax.swing.JButton botonitems;
    private javax.swing.JTextField columna;
    private javax.swing.JFormattedTextField formato1;
    private javax.swing.JLabel iconoerror;
    private javax.swing.JLabel iconoerror1;
    private javax.swing.JComboBox items;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblnombreteclas;
    private javax.swing.JLabel lbltexto;
    private javax.swing.JTextField nombreteclas;
    private javax.swing.JPanel panelfecha;
    private javax.swing.JTextField renglon;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField texto_numero_unespacio;
    private javax.swing.JTextField textoespacio;
    private javax.swing.JTextField txtfecha;
    // End of variables declaration//GEN-END:variables
}
