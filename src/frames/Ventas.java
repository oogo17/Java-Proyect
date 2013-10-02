package frames;

import java.sql.ResultSet;
import java.sql.SQLException;
import conexiones.Conexion;
import java.awt.Component;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import utilidades.Fecha;
import utilidades.IconCellRenderer;

public class Ventas extends javax.swing.JDialog {

    private DefaultTableModel ModeloTabla, ModeloTabla1, ModeloTabla2;
    JLabel celda;
    Object fila[];
    DefaultTableCellRenderer Renderizado_Celdas_Tabla_Centro, Renderizado_Celdas_Tabla_Derecha, Renderizado_Celdas_Tabla_Izquierda;
    Object[] Filas;
    private int ContadorLlenadoTabla;
    String RenglonRegistro[];
    ResultSet resultado, eliminarv, ResultadoTabla, buscarV;
    private int Tipo_Busqueda_1;
    Conexion conexion;
    int art = 0;
    int contador_tabla = 0;
    boolean band = true;
    boolean bandclave = true;
    boolean bandera_panel = false;
    String empezar_fila = "";
    private boolean bandera_tecla_abajo3, bandera_tecla_abajo2, bandera_tecla_abajo;
    int valida_cantidad=0;
    
    
    public Ventas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(getClass().getResource("/imagenes/icono-proyecto.png")).getImage());

        lblFecha.setText(Fecha.getDia() + "-" + Fecha.getMes() + "-" + Fecha.getAño());
        fila = new Object[6];


        TablaVenta.setDefaultRenderer(Object.class, new IconCellRenderer());
        TablaConsultar.setDefaultRenderer(Object.class, new IconCellRenderer());
        TablaEliminar.setDefaultRenderer(Object.class, new IconCellRenderer());


        ModeloTabla = (DefaultTableModel) TablaEliminar.getModel();
        ModeloTabla1 = (DefaultTableModel) TablaConsultar.getModel();
        ModeloTabla2 = (DefaultTableModel) TablaVenta.getModel();

        Renderizado_Celdas_Tabla_Centro = new DefaultTableCellRenderer();
        Renderizado_Celdas_Tabla_Derecha = new DefaultTableCellRenderer();
        Renderizado_Celdas_Tabla_Izquierda = new DefaultTableCellRenderer();

        Renderizado_Celdas_Tabla_Centro.setHorizontalAlignment(SwingConstants.CENTER);
        Renderizado_Celdas_Tabla_Derecha.setHorizontalAlignment(SwingConstants.RIGHT);
        Renderizado_Celdas_Tabla_Izquierda.setHorizontalAlignment(SwingConstants.LEFT);

        TablaVenta.getColumnModel().getColumn(0).setCellRenderer(Renderizado_Celdas_Tabla_Izquierda);
        TablaVenta.getColumnModel().getColumn(1).setCellRenderer(Renderizado_Celdas_Tabla_Centro);
        TablaVenta.getColumnModel().getColumn(2).setCellRenderer(Renderizado_Celdas_Tabla_Izquierda);
        TablaVenta.getColumnModel().getColumn(3).setCellRenderer(Renderizado_Celdas_Tabla_Izquierda);
        TablaVenta.getColumnModel().getColumn(4).setCellRenderer(Renderizado_Celdas_Tabla_Centro);
        TablaVenta.getColumnModel().getColumn(5).setCellRenderer(Renderizado_Celdas_Tabla_Derecha);

        Tipo_Busqueda_1 = 1;

        Filas = new Object[5];

        RenglonRegistro = new String[5];

        Clavefield.requestFocus();

        conexion = new Conexion();
        conexion.conectarMySQL();

        estableceFolio();

        llenarTabla(1);
        llenarTabla(2);

        Busqueda_clave.setSelected(true);

        bandera_tecla_abajo = false;
        bandera_tecla_abajo2 = false;
        bandera_tecla_abajo3 = false;

        Buscarpanel.setVisible(false);

        //Esconder Botones
        AceptarVenta.setVisible(false);
        EliminarProducto.setVisible(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Cambiofield = new javax.swing.JTextField();
        Total = new javax.swing.JTextField();
        PagoField = new javax.swing.JTextField();
        botonCerrar = new javax.swing.JButton();
        Cortecaja = new javax.swing.JButton();
        EliminarProducto = new javax.swing.JButton();
        NuevaVenta = new javax.swing.JButton();
        Botoneliminar = new javax.swing.JButton();
        AceptarVenta = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaVenta = new javax.swing.JTable();
        Foliofield = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Buscarpanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Buscarfield = new javax.swing.JTextField();
        Autocompletar2 = new javax.swing.JComboBox();
        Busqueda_nombre = new javax.swing.JRadioButton();
        Busqueda_clave = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        Clavefield = new javax.swing.JTextField();
        Cantidadfield = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        Buscareliminar = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaEliminar = new javax.swing.JTable();
        desplegar2 = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TablaConsultar = new javax.swing.JTable();
        Desplegar3 = new javax.swing.JComboBox();
        lblTitulo = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ventas");
        setUndecorated(true);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setText("TOTAL");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("RECIBE");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("CAMBIO");

        Cambiofield.setEditable(false);
        Cambiofield.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Cambiofield.setForeground(new java.awt.Color(255, 0, 51));
        Cambiofield.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        Cambiofield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CambiofieldActionPerformed(evt);
            }
        });

        Total.setEditable(false);
        Total.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Total.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        Total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TotalActionPerformed(evt);
            }
        });

        PagoField.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        PagoField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        PagoField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PagoFieldActionPerformed(evt);
            }
        });
        PagoField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                PagoFieldKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PagoFieldKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(Cambiofield, javax.swing.GroupLayout.DEFAULT_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(23, 23, 23)
                        .addComponent(PagoField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(Total, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 26, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(PagoField, javax.swing.GroupLayout.DEFAULT_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(Cambiofield, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Total, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        jPanel4.setBounds(780, 40, 200, 250);
        jLayeredPane1.add(jPanel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        botonCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cerrar.png"))); // NOI18N
        botonCerrar.setToolTipText("Cerrar");
        botonCerrar.setContentAreaFilled(false);
        botonCerrar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cerrar2.png"))); // NOI18N
        botonCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCerrarActionPerformed(evt);
            }
        });
        botonCerrar.setBounds(0, 0, 30, 30);
        jLayeredPane1.add(botonCerrar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        Cortecaja.setText("Corte Caja");
        Cortecaja.setBounds(800, 500, 120, 40);
        jLayeredPane1.add(Cortecaja, javax.swing.JLayeredPane.DEFAULT_LAYER);

        EliminarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar.png"))); // NOI18N
        EliminarProducto.setText("Eliminar");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, EliminarProducto, org.jdesktop.beansbinding.ELProperty.create("Boton encargado de eliminar un producto"), EliminarProducto, org.jdesktop.beansbinding.BeanProperty.create("toolTipText"));
        bindingGroup.addBinding(binding);

        EliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarProductoActionPerformed(evt);
            }
        });
        EliminarProducto.setBounds(510, 670, 140, 50);
        jLayeredPane1.add(EliminarProducto, javax.swing.JLayeredPane.DEFAULT_LAYER);

        NuevaVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nuevo.png"))); // NOI18N
        NuevaVenta.setText("Nueva venta");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, NuevaVenta, org.jdesktop.beansbinding.ELProperty.create("Boton para realizar una nueva venta campos en blanco"), NuevaVenta, org.jdesktop.beansbinding.BeanProperty.create("toolTipText"));
        bindingGroup.addBinding(binding);

        NuevaVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevaVentaActionPerformed(evt);
            }
        });
        NuevaVenta.setBounds(670, 670, 140, 50);
        jLayeredPane1.add(NuevaVenta, javax.swing.JLayeredPane.DEFAULT_LAYER);

        Botoneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar.png"))); // NOI18N
        Botoneliminar.setText("Eliminar");
        Botoneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotoneliminarActionPerformed(evt);
            }
        });
        Botoneliminar.setBounds(800, 550, 130, 50);
        jLayeredPane1.add(Botoneliminar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        AceptarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/aceptar.png"))); // NOI18N
        AceptarVenta.setText("Aceptar");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, AceptarVenta, org.jdesktop.beansbinding.ELProperty.create("Realizar la venta de los articulos de la tabla"), AceptarVenta, org.jdesktop.beansbinding.BeanProperty.create("toolTipText"));
        bindingGroup.addBinding(binding);

        AceptarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AceptarVentaActionPerformed(evt);
            }
        });
        AceptarVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                AceptarVentaKeyPressed(evt);
            }
        });
        AceptarVenta.setBounds(820, 670, 140, 50);
        jLayeredPane1.add(AceptarVenta, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jTabbedPane1ComponentShown(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setAutoscrolls(true);
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel1ComponentShown(evt);
            }
        });

        TablaVenta.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        TablaVenta.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null, null, null}
            },
            new String [] {
                "Clave", "Cantidad", "Nombre", "Tipo", "Precio Unit.", "Sub. Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaVenta.setColumnSelectionAllowed(true);
        TablaVenta.getTableHeader().setReorderingAllowed(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, TablaVenta, org.jdesktop.beansbinding.ELProperty.create("Tabla donde se tienen las caracteristicas de los articulos"), TablaVenta, org.jdesktop.beansbinding.BeanProperty.create("toolTipText"));
        bindingGroup.addBinding(binding);

        TablaVenta.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TablaVentaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                TablaVentaFocusLost(evt);
            }
        });
        TablaVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TablaVentaKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(TablaVenta);
        TablaVenta.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        TablaVenta.getColumnModel().getColumn(0).setResizable(false);
        TablaVenta.getColumnModel().getColumn(1).setResizable(false);
        TablaVenta.getColumnModel().getColumn(1).setPreferredWidth(15);
        TablaVenta.getColumnModel().getColumn(2).setResizable(false);
        TablaVenta.getColumnModel().getColumn(3).setResizable(false);
        TablaVenta.getColumnModel().getColumn(4).setResizable(false);
        TablaVenta.getColumnModel().getColumn(4).setPreferredWidth(15);
        TablaVenta.getColumnModel().getColumn(5).setResizable(false);
        TablaVenta.getColumnModel().getColumn(5).setPreferredWidth(15);

        Foliofield.setEditable(false);
        Foliofield.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Foliofield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FoliofieldActionPerformed(evt);
            }
        });

        jLabel4.setText("Folio");

        Buscarpanel.setBackground(new java.awt.Color(255, 255, 255));
        Buscarpanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setText("Buscar:");

        Buscarfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarfieldActionPerformed(evt);
            }
        });
        Buscarfield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                BuscarfieldKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BuscarfieldKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                BuscarfieldKeyReleased(evt);
            }
        });

        Autocompletar2.setToolTipText("Selecciona un artículo");
        Autocompletar2.setName("");
        Autocompletar2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                Autocompletar2ItemStateChanged(evt);
            }
        });
        Autocompletar2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Autocompletar2KeyPressed(evt);
            }
        });

        buttonGroup1.add(Busqueda_nombre);
        Busqueda_nombre.setText("Nombre");
        Busqueda_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Busqueda_nombreActionPerformed(evt);
            }
        });

        buttonGroup1.add(Busqueda_clave);
        Busqueda_clave.setText("Clave");
        Busqueda_clave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Busqueda_claveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BuscarpanelLayout = new javax.swing.GroupLayout(Buscarpanel);
        Buscarpanel.setLayout(BuscarpanelLayout);
        BuscarpanelLayout.setHorizontalGroup(
            BuscarpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BuscarpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BuscarpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BuscarpanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Busqueda_clave)
                        .addGap(22, 22, 22))
                    .addComponent(Busqueda_nombre))
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Buscarfield, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Autocompletar2, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );
        BuscarpanelLayout.setVerticalGroup(
            BuscarpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BuscarpanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(Busqueda_clave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Busqueda_nombre)
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BuscarpanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(BuscarpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Buscarfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(Autocompletar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );

        Clavefield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClavefieldActionPerformed(evt);
            }
        });
        Clavefield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ClavefieldKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ClavefieldKeyTyped(evt);
            }
        });

        Cantidadfield.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Cantidadfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CantidadfieldActionPerformed(evt);
            }
        });
        Cantidadfield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CantidadfieldKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CantidadfieldKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CantidadfieldKeyReleased(evt);
            }
        });

        jLabel9.setText("Clave");

        jLabel10.setText("Cantidad");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Clavefield, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Cantidadfield, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Clavefield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cantidadfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 51, Short.MAX_VALUE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 643, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Foliofield, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(Buscarpanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 621, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Foliofield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Buscarpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Nueva", new javax.swing.ImageIcon(getClass().getResource("/imagenes/nuevo.png")), jPanel1); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel2ComponentShown(evt);
            }
        });

        jLabel2.setText("Buscar");

        Buscareliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscareliminarActionPerformed(evt);
            }
        });
        Buscareliminar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                BuscareliminarKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BuscareliminarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                BuscareliminarKeyReleased(evt);
            }
        });

        TablaEliminar.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        TablaEliminar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "FOLIO", "DIA", "MES", "AÑO", "TOTAL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaEliminar.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                TablaEliminarComponentShown(evt);
            }
        });
        TablaEliminar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TablaEliminarKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(TablaEliminar);

        desplegar2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                desplegar2ItemStateChanged(evt);
            }
        });
        desplegar2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                desplegar2KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                desplegar2KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Buscareliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(desplegar2, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(95, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Buscareliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(desplegar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                .addGap(90, 90, 90))
        );

        jTabbedPane1.addTab("Eliminar", new javax.swing.ImageIcon(getClass().getResource("/imagenes/borrar.png")), jPanel2); // NOI18N

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel3ComponentShown(evt);
            }
        });

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField2KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
        });

        jLabel5.setText("Buscar");

        TablaConsultar.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        TablaConsultar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "FOLIO", "CLAVE", "CANTIDAD", "TOTAL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(TablaConsultar);
        TablaConsultar.getColumnModel().getColumn(0).setResizable(false);
        TablaConsultar.getColumnModel().getColumn(1).setResizable(false);
        TablaConsultar.getColumnModel().getColumn(2).setResizable(false);
        TablaConsultar.getColumnModel().getColumn(3).setResizable(false);

        Desplegar3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                Desplegar3ItemStateChanged(evt);
            }
        });
        Desplegar3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Desplegar3KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(Desplegar3, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 643, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Desplegar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Consultar", new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar.png")), jPanel3); // NOI18N

        jTabbedPane1.setBounds(0, 40, 770, 580);
        jLayeredPane1.add(jTabbedPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lblTitulo.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Ventas");
        lblTitulo.setBounds(390, 10, 60, 23);
        jLayeredPane1.add(lblTitulo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lblFecha.setFont(new java.awt.Font("Candara", 1, 12)); // NOI18N
        lblFecha.setForeground(new java.awt.Color(255, 255, 255));
        lblFecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFecha.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblFecha.setBounds(830, 10, 130, 18);
        jLayeredPane1.add(lblFecha, javax.swing.JLayeredPane.DEFAULT_LAYER);

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoventanapro.png"))); // NOI18N
        fondo.setBounds(0, 0, 1000, 760);
        jLayeredPane1.add(fondo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1003, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 758, Short.MAX_VALUE)
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_botonCerrarActionPerformed

    private void NuevaVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevaVentaActionPerformed

        int art = 0;
        PagoField.setText("");
        Total.setText("");
        Buscarpanel.setVisible(false);
        TablaVenta.clearSelection();
        Cambiofield.setText("");
        Clavefield.setText("");
        Cantidadfield.setText("");
        limpiarTabla2(1);

        band = true;
        contador_tabla = 0;

        Clavefield.requestFocus();
        boolean bandclave = true;
        boolean bandera_panel = false;

        boolean band = true;
        AceptarVenta.setVisible(false);
        EliminarProducto.setVisible(false);
        RenglonRegistro[0] = "";
        RenglonRegistro[1] = "";
        RenglonRegistro[2] = "";
        RenglonRegistro[3] = "";
        RenglonRegistro[4] = "";

    }//GEN-LAST:event_NuevaVentaActionPerformed

    private void AceptarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AceptarVentaActionPerformed
/*
       String articulo = "";

        String pago = PagoField.getText();
        String t = Total.getText();

        if (!"".equals(Total.getText())) {

            if (!"".equals(PagoField.getText())) {
                ////////     

                float pa = Float.parseFloat(pago);
                float total = Float.parseFloat(t);
                if (pa >= total) {

                    if (JOptionPane.showConfirmDialog(this, "Seguro de realizar la venta", "venta", 0) == 0) {



                        try {
                            System.out.println("." + Foliofield.getText() + ".");
                            String[] encaventa = {Foliofield.getText(), Fecha.getDia(), Fecha.getMes(), Fecha.getAño(), Total.getText()};
                            conexion.insertar(4, encaventa);


                            for (int i = 0; i < contador_tabla; i++) {

                                String encaventa2[] = {Foliofield.getText(), (String.valueOf(TablaVenta.getValueAt(i, 0))), String.valueOf(TablaVenta.getValueAt(i, 1)), String.valueOf(TablaVenta.getValueAt(i, 5))};
                                conexion.insertar(5, encaventa2);

                            }


                            for (int i = 0; i < contador_tabla; i++) {
                                System.out.println("art = " + art);
                                resultado = conexion.consultar(1, "*", "Clave_A", String.valueOf(TablaVenta.getValueAt(i, 0)));
                                if (resultado.first()) {
                                    String clave_articulo = String.valueOf(TablaVenta.getValueAt(i, 0));
                                    int existencia = resultado.getInt(4);
                                    String costo_Compra = resultado.getString(5);
                                    String can = TablaVenta.getValueAt(i, 1).toString();
                                    int cantidad = Integer.parseInt(can);
                                    int nueva_existencia = existencia - cantidad;
                                    String encarticulo[] = {(String.valueOf(TablaVenta.getValueAt(i, 0))), String.valueOf(TablaVenta.getValueAt(i, 2)), String.valueOf(TablaVenta.getValueAt(i, 3)), String.valueOf(nueva_existencia), costo_Compra, String.valueOf(TablaVenta.getValueAt(i, 4))};
                                    conexion.modificar(1, encarticulo, clave_articulo);


                                    System.out.println("entra para cambiar valor articulo e imrimo i = " + i);
                                }



                            }


                            float re = pa - total;
                            System.out.println("imprime vuelto = " + re);
                            String cambio = String.valueOf(re);
                            Cambiofield.setText(cambio);


                            JOptionPane.showMessageDialog(this, "VENTA  REALIZADA", "", JOptionPane.PLAIN_MESSAGE);

                            AceptarVenta.setVisible(false);
                            EliminarProducto.setVisible(false);
                            Buscarpanel.setVisible(false);
                            TablaVenta.clearSelection();
                            PagoField.setText("");
                            Cambiofield.setText("");
                            Total.setText("");
                            
                            limpiarTabla2(1);

                            band = true;

                            contador_tabla = 0;
                            Clavefield.requestFocus();
                            estableceFolio();




                        } catch (SQLException ex) {
                            Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
                        }


                    }

                }//cambio
                else {
                    JOptionPane.showMessageDialog(this, "El pago es menor que el total", "ERROR", JOptionPane.ERROR_MESSAGE);
                    PagoField.requestFocus();
                }


            } else {
                JOptionPane.showMessageDialog(this, "Introduzca cantidad con la que le pagaron", "ERROR", JOptionPane.ERROR_MESSAGE);
                PagoField.requestFocus();
            }


        } else {
            JOptionPane.showMessageDialog(this, "Agregue un articulo para realizar la venta", "ERROR", JOptionPane.ERROR_MESSAGE);
            Clavefield.requestFocus();
        }
                    
   */
    }//GEN-LAST:event_AceptarVentaActionPerformed

    private void EliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarProductoActionPerformed

        int seleccion = (TablaVenta.getSelectedRow());

        System.out.println("imprime seleccion = " + seleccion);
        if (seleccion != -1) {

            if (JOptionPane.showConfirmDialog(this, "Seguro de eliminar el producto", "eliminar", 0) == 0) {

                String[] eliminar = new String[6];
                int fila_seleccionada = TablaVenta.getSelectedRow();
                System.out.println("contador fila = " + contador_tabla);
                System.out.println("fila seleccionada = " + fila_seleccionada);

                TablaVenta.setValueAt("", fila_seleccionada, 0);
                TablaVenta.setValueAt("", fila_seleccionada, 1);
                TablaVenta.setValueAt("", fila_seleccionada, 2);
                TablaVenta.setValueAt("", fila_seleccionada, 3);
                TablaVenta.setValueAt("", fila_seleccionada, 4);
                TablaVenta.setValueAt("", fila_seleccionada, 5);

                for (int i = fila_seleccionada + 1; i <= contador_tabla - 1; i++) {
                    eliminar[0] = String.valueOf(TablaVenta.getValueAt(i, 0));
                    eliminar[1] = String.valueOf(TablaVenta.getValueAt(i, 1));
                    eliminar[2] = (String) TablaVenta.getValueAt(i, 2);
                    eliminar[3] = (String) TablaVenta.getValueAt(i, 3);
                    eliminar[4] = (String) TablaVenta.getValueAt(i, 4);
                    eliminar[5] = String.valueOf(TablaVenta.getValueAt(i, 5));

                    TablaVenta.setValueAt(eliminar[0], i - 1, 0);
                    TablaVenta.setValueAt(eliminar[1], i - 1, 1);
                    TablaVenta.setValueAt(eliminar[2], i - 1, 2);
                    TablaVenta.setValueAt(eliminar[3], i - 1, 3);
                    TablaVenta.setValueAt(eliminar[4], i - 1, 4);
                    TablaVenta.setValueAt(eliminar[5], i - 1, 5);

                    TablaVenta.setValueAt("", i, 0);
                    TablaVenta.setValueAt("", i, 1);
                    TablaVenta.setValueAt("", i, 2);
                    TablaVenta.setValueAt("", i, 3);
                    TablaVenta.setValueAt("", i, 4);
                    TablaVenta.setValueAt("", i, 5);
                }
                contador_tabla -= 1;
                total(contador_tabla - 1);
                TablaVenta.clearSelection();
                Clavefield.requestFocus();


            } else {

                TablaVenta.clearSelection();
                Clavefield.requestFocus();

            }
        } else {
            JOptionPane.showMessageDialog(this, "Tiene que seleccionar una fila para elimianr", "Advertencia", JOptionPane.WARNING_MESSAGE);
            Clavefield.requestFocus();
        }

    }//GEN-LAST:event_EliminarProductoActionPerformed

    private void TablaVentaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TablaVentaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_TablaVentaKeyPressed

    private void TablaVentaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TablaVentaFocusGained
    }//GEN-LAST:event_TablaVentaFocusGained

    private void TablaVentaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TablaVentaFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_TablaVentaFocusLost

    private void Autocompletar2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_Autocompletar2ItemStateChanged


        int ElementoSeleccionado = Autocompletar2.getSelectedIndex();
        System.out.println(ElementoSeleccionado);//Se obtiene el elemento seleccionado en la lista NOTA: por default es el primero, por eso se agraga un espacion en blanco
        if (ElementoSeleccionado != -1 && bandera_tecla_abajo == false) {//Se hace la comparacion de que el item seleccionado no sea ni el primero o si este no se ha presionado, puesto que este evento tambien se acciona al agregar un nuevo item
            String Registro = (String) Autocompletar2.getSelectedItem(); //Se obtiene el elemento (String) seleccionado  de la lista desplegable
            String RegistroSeleccionado[] = Registro.split("-"); //Se separa por los guiones 

            System.out.println(" registro seleccionado = " + RegistroSeleccionado);


            for (int i = 0; i < RegistroSeleccionado.length; i++) {
                RegistroSeleccionado[i] = RegistroSeleccionado[i].trim();
                System.out.println("Registro seleccionado = " + RegistroSeleccionado[i]);

            }

            String clave = RegistroSeleccionado[0];


            if (Registro != "" && Registro != null) {



                for (int i = 0; i <= contador_tabla; i++) {
                    System.out.println("imprime i = " + i);
                    System.out.println("contador tabla = " + contador_tabla);
                    String otraclave = (String) TablaVenta.getValueAt(i, 0);
                    System.out.println("imrime otra clave = " + otraclave);
                    System.out.println("imprime clave seleccionada = " + clave);

                    if (clave.equals(otraclave)) {
                        System.out.println("entra");
                        int cantidad = Integer.parseInt(TablaVenta.getValueAt(i, 1).toString());
                        int res = cantidad + 1;

                        TablaVenta.setValueAt(RegistroSeleccionado[0], i, 0);
                        TablaVenta.setValueAt(res, i, 1);
                        TablaVenta.setValueAt(RegistroSeleccionado[1], i, 2);
                        TablaVenta.setValueAt(RegistroSeleccionado[2], i, 3);
                        TablaVenta.setValueAt(RegistroSeleccionado[4], i, 4);
                        subtotal(i);
                        AceptarVenta.setVisible(true);
                        EliminarProducto.setVisible(true);
                       
                        bandclave = false;


                        total(contador_tabla - 1);

                        Clavefield.setText("");
                        Clavefield.requestFocus();

                        Autocompletar2.setSelectedIndex(-1);


                        Buscarfield.setText("");
                        Buscarpanel.setVisible(false);

                        Clavefield.requestFocus();

                        bandera_tecla_abajo = (false);
                    }
                    bandera_panel = true;

                }



                if (bandclave == true) {

                    TablaVenta.setValueAt(RegistroSeleccionado[0], contador_tabla, 0);

                    TablaVenta.setValueAt("1", contador_tabla, 1);


                    TablaVenta.setValueAt(RegistroSeleccionado[1], contador_tabla, 2);
                    TablaVenta.setValueAt(RegistroSeleccionado[2], contador_tabla, 3);
                    TablaVenta.setValueAt(RegistroSeleccionado[4], contador_tabla, 4);
                    AceptarVenta.setVisible(true);
                        EliminarProducto.setVisible(true);
                    subtotal(contador_tabla);
                    total(contador_tabla);
                    Clavefield.setText("");
                    contador_tabla += 1;
                    System.out.println("contador tabla banclave buscar = " + contador_tabla);
                    bandera_panel = true;

                    Autocompletar2.setSelectedIndex(-1);


                    Buscarfield.setText("");
                    Buscarpanel.setVisible(false);

                    Clavefield.requestFocus();

                    bandera_tecla_abajo = (false);
                }


            }

        }


    }//GEN-LAST:event_Autocompletar2ItemStateChanged

    private void BuscarfieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BuscarfieldKeyReleased
        try {

            String contenido = (String) Buscarfield.getText();//Se obtiene el texto de la caja de texto de la busqueda
            if (!contenido.equals("")) {//se compara que el contenido no sea nulo
                if (bandera_tecla_abajo == false) {
                    switch (Tipo_Busqueda_1) {//Se elige el criterio de busqueda: nombre-clave-tipo, mediante unos rabiobuttons

                        case 1:
                            resultado = conexion.consultar(1, "*", "Clave_A", contenido);//Se hace la consulta (por ahora solo con la clave del producto)
                            if (resultado.first()) {//Se compara que el resultado no sea nulo(que exista el o los articulos buscados)
                                resultado.previous();
                                Autocompletar2.setVisible(true);//Se hace visible la lista desplegable (Jcombobox)
                                Autocompletar2.addItem("");//Se agrega un elemento vacio (Parche que evita que la seleccin por default sea un articulo, puesto que entraba en conflicto con el evento
                                while (resultado.next()) {//Se itera con el objeto resultado para obtener todos los valores que fueron encontrados con la consulta
                                    //Se asignan al Arreglo que contentra todos los elementos de la fila, los elementos de cada registro de la Tabla 

                                    RenglonRegistro[0] = resultado.getString(1);
                                    RenglonRegistro[1] = resultado.getString(2);
                                    RenglonRegistro[2] = resultado.getString(3);
                                    RenglonRegistro[3] = resultado.getString(4);
                                    RenglonRegistro[4] = resultado.getString(6);
                                    //Se agrega el elemento a la lista desplegable NOTA: se agregan "-" para despues poder separar los elementos cuando se selecciona un elemento de la lista
                                    Autocompletar2.addItem(RenglonRegistro[0] + "  -  " + RenglonRegistro[1] + "  -  " + RenglonRegistro[2] + "  -  " + RenglonRegistro[3] + "  -  " + RenglonRegistro[4]);

                                }


                                Autocompletar2.showPopup();//Se muestra la lista desplegable

                            }//
                            else {
                                //Si en la consulta, no se encuentran registros se remueven todos los elementos contenidos anteriormente, se esconde la lista  y se hace invisible
                                Autocompletar2.removeAllItems();
                                Autocompletar2.hidePopup();


                            }
                            break;
                        case 2:
                            resultado = conexion.consultar(1, "*", "Nombre_A", contenido);
                            if (resultado.first()) {
                                resultado.previous();
                               
                                Autocompletar2.addItem(" ");//Se agrega un elemento vacio (Parche que evita que la seleccin por default sea un articulo, puesto que entraba en conflicto con el evento
                                 Autocompletar2.setVisible(true);

                                while (resultado.next()) {

                                    RenglonRegistro[0] = resultado.getString(1);
                                    RenglonRegistro[1] = resultado.getString(2);
                                    RenglonRegistro[2] = resultado.getString(3);
                                    RenglonRegistro[3] = resultado.getString(4);
                                    RenglonRegistro[4] = resultado.getString(5);
                                    Autocompletar2.addItem(RenglonRegistro[0] + "  -  " + RenglonRegistro[1] + "  -  " + RenglonRegistro[2] + "  -  " + RenglonRegistro[3] + "  -  " + RenglonRegistro[4]);

                                }

                                Autocompletar2.showPopup();//Se muestra la lista desplegable


                            } else {
                                //Si en la consulta, no se encuentran registros se remueven todos los elementos contenidos anteriormente, se esconde la lista  y se hace invisible
                                Autocompletar2.removeAllItems();
                                Autocompletar2.hidePopup();

                            }
                            break;
                        default:
                            JOptionPane.showMessageDialog(this, "Tipo incorreco de búsqueda");
                            break;
                    }
//                    Autocompletar. 
                } else {
                    //Si las teclas flecha arriba y abajo son presionadas, se pasa el foco a la lista desplegable y se muestra el contenido, para permitir que se seleccione algun elemento y se pueda desplazar mediante estas teclas
                    Autocompletar2.requestFocus();
                    Autocompletar2.setSelectedIndex(0);
                    Autocompletar2.showPopup();


                }


            } else {// De lo contrario se oculta la lista desplegable (popup)
                Autocompletar2.hidePopup();

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al conectar con MySQL");
        }

    }//GEN-LAST:event_BuscarfieldKeyReleased

    private void BuscarfieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BuscarfieldKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!Character.isLetter(c) && !Character.isDigit(c)) {
            evt.consume();

        } else {
            if (Buscarfield.getText().length() > 49) {
                Toolkit.getDefaultToolkit().beep();
                evt.consume();
            }
        }
        //Se remueven todos los elementos de la lista que despliega los elementos de la busqueda, este metodo trabaja con el caracteristicaBuscarKeyRelease, para actualizar 
        //los elementos de la lista cada ves que se introduce un nuevo caracter
        Autocompletar2.removeAllItems();
        bandera_tecla_abajo = false;

    }//GEN-LAST:event_BuscarfieldKeyTyped

    private void FoliofieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FoliofieldActionPerformed
    }//GEN-LAST:event_FoliofieldActionPerformed

    private void TotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TotalActionPerformed

    private void CambiofieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CambiofieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CambiofieldActionPerformed

    private void BotoneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotoneliminarActionPerformed
        if (TablaEliminar.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Primero debes seleccionar una venta de la tabla");

        } else {

            int filatabla = TablaEliminar.getSelectedRow();
            int a = JOptionPane.showConfirmDialog(this, "¿Realmente desea eliminar esta venta?", "Advertencia", 0, 3);
            if (a == 0) {


                String valor = String.valueOf(TablaEliminar.getValueAt(filatabla, 0));

                try {

                    conexion.eliminar(5, valor);



                    conexion.eliminar(4, String.valueOf(TablaEliminar.getValueAt(filatabla, 0)));
                    JOptionPane.showMessageDialog(this, "Registro Borrado");


                    vaciarTabla2(1);
                    llenarTabla2(1);



                    //Se devuelve el foco al campo de busquedas
                    Buscareliminar.requestFocus();

                } catch (SQLException ex) {
                    Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
                }


            }

        }

        RenglonRegistro[0] = "";
        RenglonRegistro[1] = "";
        RenglonRegistro[2] = "";
        RenglonRegistro[3] = "";
        RenglonRegistro[4] = "";


    }//GEN-LAST:event_BotoneliminarActionPerformed

    private void ClavefieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClavefieldActionPerformed
    }//GEN-LAST:event_ClavefieldActionPerformed

    private void ClavefieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ClavefieldKeyPressed

        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_SPACE) {
            Cantidadfield.requestFocus();

        }
        if (key == KeyEvent.VK_ALT) {
            Cantidadfield.requestFocus();
            PagoField.requestFocus();
        }


        if (key == KeyEvent.VK_ENTER) { //obtiene la tecla que se a presionado y lo guarda en la variable key
            bandclave = true;
            bandera_panel = false;
            Cantidadfield.setText("");
            String clave = Clavefield.getText();

            int mayor = existencia(clave, 1);
            if (mayor != 1) {
                try {
                    resultado = conexion.consultar(1, "*", "Clave_A", clave);

                    if (resultado != null) {


                        while (resultado.next()) {

                            if (clave.equals(resultado.getString(1))) {

                                for (int i = 0; i <= contador_tabla; i++) {
                                    System.out.println("imprime i = " + i);
                                    System.out.println("contador tabla  = " + contador_tabla);
                                    String otraclave = (String) TablaVenta.getValueAt(i, 0);
                                    if (clave.equals(otraclave)) {
                                        System.out.println("entra");
                                        int cantidad = Integer.parseInt(TablaVenta.getValueAt(i, 1).toString());
                                        int res = cantidad + 1;

                                        TablaVenta.setValueAt(resultado.getString(1), i, 0);
                                        TablaVenta.setValueAt(res, i, 1);
                                        TablaVenta.setValueAt(resultado.getString(2), i, 2);
                                        TablaVenta.setValueAt(resultado.getString(3), i, 3);
                                        TablaVenta.setValueAt(resultado.getString(6), i, 4);
                                        subtotal(i);

                                        bandclave = false;




                                        total(contador_tabla - 1);

                                        Clavefield.setText("");
                                    }
                                    bandera_panel = true;
                                }
                                if (bandclave == true) {
                                    TablaVenta.setValueAt(resultado.getString(1), contador_tabla, 0);
                                    TablaVenta.setValueAt("1", contador_tabla, 1);
                                    TablaVenta.setValueAt(resultado.getString(2), contador_tabla, 2);
                                    TablaVenta.setValueAt(resultado.getString(3), contador_tabla, 3);
                                    TablaVenta.setValueAt(resultado.getString(6), contador_tabla, 4);

                                    subtotal(contador_tabla);
                                    total(contador_tabla);
                                    Clavefield.setText("");
                                    contador_tabla += 1;
                                    System.out.println("contador tabla banclave = " + contador_tabla);
                                    bandera_panel = true;
                                }




                            }





                        }

                        

                    }
                    System.out.println("bandera_panel = " + bandera_panel);
                    if (bandera_panel == false) {
                        System.out.println("aqui es el pedo");
                        Buscarpanel.setVisible(true);
                        Clavefield.setText("");
                        Buscarfield.requestFocus();
                    }


                } catch (SQLException ex) {
                    Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }

        /*
         * if(key == KeyEvent.VK_SPACE){
         *
         * Cantidadfield.requestFocus(); }
         */

    }//GEN-LAST:event_ClavefieldKeyPressed

    private void CantidadfieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CantidadfieldKeyPressed
        // TODO add your handling code here:

        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_SPACE) {
            bandclave = true;
            bandera_panel = false;
            PagoField.requestFocus();

        }
        int keys = evt.getKeyCode();  //obtiene la tecla que se a presionado y lo guarda en la variable key
        if (keys == KeyEvent.VK_ENTER) {

            bandclave = true;

            String clave = Clavefield.getText();
            String campo_cantidad = Cantidadfield.getText();

            if (campo_cantidad.equals("") || campo_cantidad == null) {
                campo_cantidad = "1";
            }
            int campo_cantidadint = Integer.parseInt(campo_cantidad);
            int mayor = existencia(clave, campo_cantidadint);

            if (mayor != 1) {
                try {
                    resultado = conexion.consultar(1, "*", "Clave_A", clave);

                    if (resultado != null) {


                        while (resultado.next()) {

                            if (clave.equals(resultado.getString(1))) {

                                for (int i = 0; i <= contador_tabla; i++) {
                                    System.out.println("imprime i = " + i);
                                    System.out.println("contador tabla = " + contador_tabla);
                                    String otraclave = (String) TablaVenta.getValueAt(i, 0);
                                    if (clave.equals(otraclave)) {
                                        System.out.println("entra");
                                        int cantidad = Integer.parseInt(TablaVenta.getValueAt(i, 1).toString());
                                        int res = cantidad + campo_cantidadint;

                                        TablaVenta.setValueAt(resultado.getString(1), i, 0);
                                        TablaVenta.setValueAt(res, i, 1);
                                        TablaVenta.setValueAt(resultado.getString(2), i, 2);
                                        TablaVenta.setValueAt(resultado.getString(3), i, 3);
                                        TablaVenta.setValueAt(resultado.getString(6), i, 4);
                                        subtotal(i);

                                        bandclave = false;

                                        total(contador_tabla - 1);

                                        Clavefield.setText("");
                                        Cantidadfield.setText("");
                                        Clavefield.requestFocus();
                                        bandera_panel = true;
                                    }

                                }
                                if (bandclave == true) {



                                    TablaVenta.setValueAt(resultado.getString(1), contador_tabla, 0);
                                    TablaVenta.setValueAt(campo_cantidad, contador_tabla, 1);
                                    TablaVenta.setValueAt(resultado.getString(2), contador_tabla, 2);
                                    TablaVenta.setValueAt(resultado.getString(3), contador_tabla, 3);
                                    TablaVenta.setValueAt(resultado.getString(6), contador_tabla, 4);

                                    subtotal(contador_tabla);
                                    total(contador_tabla);
                                    Clavefield.setText("");
                                    Cantidadfield.setText("");
                                    Clavefield.requestFocus();
                                    contador_tabla += 1;
                                    System.out.println("contador tabla banclave = " + contador_tabla);
                                    bandera_panel = true;
                                }
                            }

                        }
                        System.out.println("bandera_panel = " + bandera_panel);
                        if (bandera_panel == false) {
                            System.out.println("aqui es el pedo");
                            Buscarpanel.setVisible(true);
                            Clavefield.setText("");
                            Buscarfield.requestFocus();
                        }
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }


    }//GEN-LAST:event_CantidadfieldKeyPressed

    private void CantidadfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CantidadfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CantidadfieldActionPerformed

    private void ClavefieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ClavefieldKeyTyped
        char c = evt.getKeyChar();
        if (Character.isDigit(c) == false) {
            evt.consume();


        }        // TODO add your handling code here:
    }//GEN-LAST:event_ClavefieldKeyTyped

    private void CantidadfieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CantidadfieldKeyTyped
        char c = evt.getKeyChar();
        if (Character.isDigit(c) == false) {
            evt.consume();


        }        // TODO add your handling code here:
    }//GEN-LAST:event_CantidadfieldKeyTyped

//GEN-FIRST:event_PagoFieldsKeyPressed
 
//GEN-LAST:event_PagoFieldsKeyPressed

    private void desplegar2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_desplegar2ItemStateChanged
        int ElementoSeleccionado = desplegar2.getSelectedIndex();
        if (ElementoSeleccionado != -1 && bandera_tecla_abajo2 == false) {//Se obtiene el elemento seleccionado en la lista NOTA: por default es el primero, por eso se agraga un espacion en blanco
            if (ElementoSeleccionado != 0 && ElementoSeleccionado != -1) {//Se hace la comparacion de que el item seleccionado no sea ni el primero o si este no se ha presionado, puesto que este evento tambien se acciona al agregar un nuevo item
                String Registro = (String) desplegar2.getSelectedItem(); //Se obtiene el elemento (String) seleccionado  de la lista desplegable
                String RegistroSeleccionado[] = Registro.split("-"); //Se separa por los guiones 
                for (int i = 0; i < RegistroSeleccionado.length; i++) {
                    RegistroSeleccionado[i] = RegistroSeleccionado[i].trim();

                }
                for (int i = 0; i < TablaEliminar.getRowCount(); i++) {//Se recorre toda la tabla para encontrar el articulo y asi seleccionarlo,
                    //esto ayuda cuando se tiene mas elementos y no se pueden presentar todos dentro de los primeros elementos de la lista

                    if (String.valueOf(TablaEliminar.getValueAt(i, 0)).equals(RegistroSeleccionado[0])) {//Se hace la comparacion del elemento con lo que hay en la lista
                        //Si si, se selecciona automaticamente la fila, indicando el articulo que se encuentra

                        TablaEliminar.setRowSelectionInterval(i, i);

                        int fila_a_desplegar = (i + 1) * 16;
                        Point punto = new Point(0, fila_a_desplegar);
                        jScrollPane3.getViewport().setViewPosition(punto);
                        desplegar2.setVisible(false);//Se oculta la lista desplegable
                        Buscareliminar.setText("");//Se borra el texto de busqueda

                        break;
                    }
                }
            }
        }     // TODO add your handling code here:
    }//GEN-LAST:event_desplegar2ItemStateChanged

    private void BuscareliminarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BuscareliminarKeyReleased
        String Aux2 = "";
        try {

            Aux2 = (String) Buscareliminar.getText();
            if (!Aux2.equals("")) {
                if (bandera_tecla_abajo2 == false) {
                    eliminarv = conexion.consultar(4, "*", "Folio_V", Aux2);
                    if (eliminarv != null) {
                        desplegar2.setVisible(true);
                        desplegar2.addItem(" ");
                        while (eliminarv.next()) {

                            RenglonRegistro[0] = eliminarv.getString(1);
                            RenglonRegistro[1] = eliminarv.getString(2);
                            RenglonRegistro[2] = eliminarv.getString(3);
                            RenglonRegistro[3] = eliminarv.getString(4);

                            desplegar2.addItem(RenglonRegistro[0] + "-" + RenglonRegistro[1] + "-" + RenglonRegistro[2] + "-" + RenglonRegistro[3]);

                        }

                        desplegar2.showPopup();
                        desplegar2.revalidate();


                    }
                } else {

                    desplegar2.requestFocus();
                    desplegar2.setSelectedIndex(0);

                }
            } else {
                desplegar2.hidePopup();
                // desplegar2.setVisible(false);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al conectar con MySQL");

        }     // TODO add your handling code here:
    }//GEN-LAST:event_BuscareliminarKeyReleased

    private void BuscareliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscareliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BuscareliminarActionPerformed

    private void BuscareliminarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BuscareliminarKeyPressed
        if ((KeyEvent.getKeyText(evt.getKeyCode()).equals("Abajo") || KeyEvent.getKeyText(evt.getKeyCode()).equals("Arriba")) && desplegar2.isVisible()) {

            bandera_tecla_abajo2 = true;
        }        // TODO add your handling code here:
    }//GEN-LAST:event_BuscareliminarKeyPressed

    private void BuscareliminarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BuscareliminarKeyTyped
        char c = evt.getKeyChar();
        if (!Character.getName(c).equals("SPACE") && Character.isDigit(c) == false && !Character.getName(c).equals("FULL STOP")) {
            evt.consume();
        }

        desplegar2.removeAllItems();
        bandera_tecla_abajo2 = false;
        // TODO add your handling code here:
    }//GEN-LAST:event_BuscareliminarKeyTyped

    private void desplegar2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_desplegar2KeyPressed
        if (KeyEvent.getKeyText(evt.getKeyCode()).equals("Intro")) {//Se hace la comparacion de que el item seleccionado no sea ni el primero o si este no se ha presionado, puesto que este evento tambien se acciona al agregar un nuevo item
            String Registro = (String) desplegar2.getSelectedItem(); //Se obtiene el elemento (String) seleccionado  de la lista desplegable
            String RegistroSeleccionado[] = Registro.split("-"); //Se separa por los guiones 
            for (int i = 0; i < RegistroSeleccionado.length; i++) {
                RegistroSeleccionado[i] = RegistroSeleccionado[i].trim();

            }
            for (int i = 0; i < TablaEliminar.getRowCount(); i++) {//Se recorre toda la tabla para encontrar el articulo y asi seleccionarlo,
                //esto ayuda cuando se tiene mas elementos y no se pueden presentar todos dentro de los primeros elementos de la lista

                if (String.valueOf(TablaEliminar.getValueAt(i, 0)).equals(RegistroSeleccionado[0])) {//Se hace la comparacion del elemento con lo que hay en la lista
                    //Si si, se selecciona automaticamente la fila, indicando el articulo que se encuentra

                    TablaEliminar.setRowSelectionInterval(i, i);
                    //--Las siguientes lineas de codigo sirven para visualizar el renglon seleccionado anteriormente
                    int fila_a_desplegar = (i * 16) + 1; //se obtiene el valor de la coordenada en y del renglon seleccionado
                    Point punto = new Point(0, fila_a_desplegar);   //Se crea un objeto tipo Point que nos ayudara a visualizar el renglón
                    jScrollPane2.getViewport().setViewPosition(punto);//Se visualiza el renglon  del ScrollBar mediante el metodo setViewPort teniendo como parametro el objeto tipo Point

                    desplegar2.setVisible(false);//Se oculta la lista desplegable
                    Buscareliminar.setText("");//Se borra el texto de busqueda 

                    break;
                }
            }
            TablaEliminar.requestFocus(false);
            Botoneliminar.requestFocus();
            // BtnEliminar.requestFocus();

        }        // TODO add your handling code here:
    }//GEN-LAST:event_desplegar2KeyPressed

    private void jPanel2ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel2ComponentShown
        Cortecaja.setVisible(false);
        AceptarVenta.setVisible(false);

        NuevaVenta.setVisible(false);

        EliminarProducto.setVisible(false);
        Botoneliminar.setVisible(true);
        if (ContadorLlenadoTabla >= 2) {


            vaciarTabla2(1);
            llenarTabla2(1);
        }
    }//GEN-LAST:event_jPanel2ComponentShown

    private void jPanel3ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel3ComponentShown
        Cortecaja.setVisible(true);
        AceptarVenta.setVisible(false);
        NuevaVenta.setVisible(false);
        EliminarProducto.setVisible(false);
        Botoneliminar.setVisible(false);

        if (ContadorLlenadoTabla > 2) {



            vaciarTabla(2);
            llenarTabla(2);
        }
    }//GEN-LAST:event_jPanel3ComponentShown

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
        String Aux3 = "";
        try {

            Aux3 = (String) jTextField2.getText();
            if (!Aux3.equals("")) {
                if (bandera_tecla_abajo3 == false) {

                    buscarV = conexion.consultar(5, "*", "Folio_V", Aux3);

                    if (buscarV != null) {
                        Desplegar3.setVisible(true);
                        Desplegar3.addItem(" ");
                        while (buscarV.next()) {

                            RenglonRegistro[0] = buscarV.getString(1);
                            RenglonRegistro[1] = buscarV.getString(2);
                            RenglonRegistro[2] = buscarV.getString(3);
                            RenglonRegistro[3] = buscarV.getString(4);


                            Desplegar3.addItem(RenglonRegistro[0] + "-" + RenglonRegistro[1] + "-" + RenglonRegistro[2] + "-" + RenglonRegistro[3]);

                        }

                        Desplegar3.showPopup();
                        Desplegar3.revalidate();

                    }
                } else {

                    Desplegar3.requestFocus();
                    Desplegar3.setSelectedIndex(0);


                }
            } else {
                Desplegar3.hidePopup();
                Desplegar3.setVisible(false);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al conectar con MySQL");

        }        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2KeyReleased

    private void jTextField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyPressed
        if ((KeyEvent.getKeyText(evt.getKeyCode()).equals("Abajo") || KeyEvent.getKeyText(evt.getKeyCode()).equals("Arriba")) && Desplegar3.isVisible()) {

            bandera_tecla_abajo3 = true;
        }
    }//GEN-LAST:event_jTextField2KeyPressed

    private void Desplegar3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_Desplegar3ItemStateChanged
        int ElementoSeleccionado = Desplegar3.getSelectedIndex();
        if (ElementoSeleccionado != -1 && bandera_tecla_abajo3 == false) {//Se obtiene el elemento seleccionado en la lista NOTA: por default es el primero, por eso se agraga un espacion en blanco
            if (ElementoSeleccionado != 0 && ElementoSeleccionado != -1) {//Se hace la comparacion de que el item seleccionado no sea ni el primero o si este no se ha presionado, puesto que este evento tambien se acciona al agregar un nuevo item
                String Registro = (String) Desplegar3.getSelectedItem(); //Se obtiene el elemento (String) seleccionado  de la lista desplegable
                String RegistroSeleccionado[] = Registro.split("-"); //Se separa por los guiones 
                for (int i = 0; i < RegistroSeleccionado.length; i++) {
                    RegistroSeleccionado[i] = RegistroSeleccionado[i].trim();

                }
                for (int i = 0; i < TablaConsultar.getRowCount(); i++) {//Se recorre toda la tabla para encontrar el articulo y asi seleccionarlo,
                    //esto ayuda cuando se tiene mas elementos y no se pueden presentar todos dentro de los primeros elementos de la lista

                    if (String.valueOf(TablaConsultar.getValueAt(i, 0)).equals(RegistroSeleccionado[0])) {//Se hace la comparacion del elemento con lo que hay en la lista
                        //Si si, se selecciona automaticamente la fila, indicando el articulo que se encuentra

                        TablaConsultar.setRowSelectionInterval(i, i);

                        int fila_a_desplegar = (i + 1) * 16;
                        Point punto = new Point(0, fila_a_desplegar);
                        jScrollPane3.getViewport().setViewPosition(punto);
                        Desplegar3.setVisible(false);//Se oculta la lista desplegable
                        jTextField2.setText("");//Se borra el texto de busqueda
                        break;
                    }
                }
            }
        }
    }//GEN-LAST:event_Desplegar3ItemStateChanged

    private void Desplegar3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Desplegar3KeyPressed
        if (KeyEvent.getKeyText(evt.getKeyCode()).equals("Intro")) {//Se hace la comparacion de que el item seleccionado no sea ni el primero o si este no se ha presionado, puesto que este evento tambien se acciona al agregar un nuevo item
            String Registro = (String) Desplegar3.getSelectedItem(); //Se obtiene el elemento (String) seleccionado  de la lista desplegable
            String RegistroSeleccionado[] = Registro.split("-"); //Se separa por los guiones 
            for (int i = 0; i < RegistroSeleccionado.length; i++) {
                RegistroSeleccionado[i] = RegistroSeleccionado[i].trim();

            }
            for (int i = 0; i < TablaConsultar.getRowCount(); i++) {//Se recorre toda la tabla para encontrar el articulo y asi seleccionarlo,
                //esto ayuda cuando se tiene mas elementos y no se pueden presentar todos dentro de los primeros elementos de la lista

                if (String.valueOf(TablaConsultar.getValueAt(i, 0)).equals(RegistroSeleccionado[0])) {//Se hace la comparacion del elemento con lo que hay en la lista
                    //Si si, se selecciona automaticamente la fila, indicando el articulo que se encuentra

                    TablaConsultar.setRowSelectionInterval(i, i);
                    //--Las siguientes lineas de codigo sirven para visualizar el renglon seleccionado anteriormente
                    int fila_a_desplegar = (i * 16) + 1; //se obtiene el valor de la coordenada en y del renglon seleccionado
                    Point punto = new Point(0, fila_a_desplegar);   //Se crea un objeto tipo Point que nos ayudara a visualizar el renglón
                    jScrollPane3.getViewport().setViewPosition(punto);//Se visualiza el renglon  del ScrollBar mediante el metodo setViewPort teniendo como parametro el objeto tipo Point

                    Desplegar3.setVisible(false);//Se oculta la lista desplegable
                    jTextField2.setText("");//Se borra el texto de busqueda 

                    break;
                }
            }
            TablaConsultar.requestFocus(false);


        }
    }//GEN-LAST:event_Desplegar3KeyPressed

    private void desplegar2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_desplegar2KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_desplegar2KeyReleased

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped
        char c = evt.getKeyChar();
        if (Character.isDigit(c) == false) {
            evt.consume();
        }

        Desplegar3.removeAllItems();
        bandera_tecla_abajo3 = false;
        // TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2KeyTyped

    private void PagoFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PagoFieldKeyTyped
        char c = evt.getKeyChar();
        if (Character.isDigit(c) == false) {
            evt.consume();
        }// TODO add your handling code here:
    }//GEN-LAST:event_PagoFieldKeyTyped

    private void BuscarfieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BuscarfieldKeyPressed
        if ((KeyEvent.getKeyText(evt.getKeyCode()).equals("Abajo") || KeyEvent.getKeyText(evt.getKeyCode()).equals("Arriba"))) {
            bandera_tecla_abajo = true;
        }     // TODO add your handling code here:
    }//GEN-LAST:event_BuscarfieldKeyPressed

    private void Busqueda_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Busqueda_nombreActionPerformed
        Tipo_Busqueda_1 = 2;
        // TODO add your handling code here:
    }//GEN-LAST:event_Busqueda_nombreActionPerformed

    private void Busqueda_claveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Busqueda_claveActionPerformed
        Tipo_Busqueda_1 = 1;        // TODO add your handling code here:
    }//GEN-LAST:event_Busqueda_claveActionPerformed

    private void TablaEliminarComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_TablaEliminarComponentShown
        if (ContadorLlenadoTabla >= 2) {

            llenarTabla2(1);
            vaciarTabla2(1);
        }
    }//GEN-LAST:event_TablaEliminarComponentShown

    private void TablaEliminarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TablaEliminarKeyPressed
        if (KeyEvent.getKeyText(evt.getKeyCode()).equals("Intro")) {
        }
    }//GEN-LAST:event_TablaEliminarKeyPressed

    private void PagoFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PagoFieldActionPerformed
       /*bandclave = true;
        bandera_panel = false;
        AceptarVenta.requestFocus();*/
    }//GEN-LAST:event_PagoFieldActionPerformed

    private void PagoFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PagoFieldKeyPressed
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ALT) {
           
            bandclave = true;
            bandera_panel = false;
            AceptarVenta.requestFocus();

        }        // TODO add your handling code here:
    }//GEN-LAST:event_PagoFieldKeyPressed

    private void AceptarVentaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AceptarVentaKeyPressed
       
        
        int key = evt.getKeyCode();
        
        if(key == KeyEvent.VK_ALT){
        
            Clavefield.requestFocus();
        }
        
            
        
        
       if (key == KeyEvent.VK_ENTER) {
           

        

            bandclave = true;
            bandera_panel = false;
        
      

             if (!"".equals(PagoField.getText())) {
                ////////     
                String pago = PagoField.getText();
                String t = Total.getText();

                float pa = Float.parseFloat(pago);
                float total = Float.parseFloat(t);
                AceptarVenta.setSelected(false);
                
                if (pa >= total) {

                    if (JOptionPane.showConfirmDialog(this, "Seguro de realizar la venta", "venta", 0) == 0) {



                        try {
                            System.out.println("." + Foliofield.getText() + ".");
                            String[] encaventa = {Foliofield.getText(), Fecha.getDia(), Fecha.getMes(), Fecha.getAño(), Total.getText()};
                            conexion.insertar(4, encaventa);


                            for (int i = 0; i < contador_tabla; i++) {

                                String encaventa2[] = {Foliofield.getText(), (String.valueOf(TablaVenta.getValueAt(i, 0))), String.valueOf(TablaVenta.getValueAt(i, 1)), String.valueOf(TablaVenta.getValueAt(i, 5))};
                                conexion.insertar(5, encaventa2);

                            }


                            for (int i = 0; i < contador_tabla; i++) {
                                System.out.println("art = " + art);
                                resultado = conexion.consultar(1, "*", "Clave_A", String.valueOf(TablaVenta.getValueAt(i, 0)));
                                if (resultado.first()) {
                                    String clave_articulo = String.valueOf(TablaVenta.getValueAt(i, 0));
                                    int existencia = resultado.getInt(4);
                                    String costo_Compra = resultado.getString(5);
                                    String can = TablaVenta.getValueAt(i, 1).toString();
                                    int cantidad = Integer.parseInt(can);
                                    int nueva_existencia = existencia - cantidad;
                                    String encarticulo[] = {(String.valueOf(TablaVenta.getValueAt(i, 0))), String.valueOf(TablaVenta.getValueAt(i, 2)), String.valueOf(TablaVenta.getValueAt(i, 3)), String.valueOf(nueva_existencia), costo_Compra, String.valueOf(TablaVenta.getValueAt(i, 4))};
                                    conexion.modificar(1, encarticulo, clave_articulo);


                                    System.out.println("entra para cambiar valor articulo e imrimo i = " + i);
                                }



                            }


                            float re = pa - total;
                            System.out.println("imprime vuelto = " + re);
                            String cambio = String.valueOf(re);
                            Cambiofield.setText(cambio);


                            JOptionPane.showMessageDialog(this, "VENTA  REALIZADA", "", JOptionPane.PLAIN_MESSAGE);

                          //AceptarVenta.setVisible(false);
                            EliminarProducto.setVisible(false);
                            Buscarpanel.setVisible(false);
                            PagoField.setText("");
                            Cambiofield.setText("");
                            Total.setText("");
                            TablaVenta.clearSelection();
                            limpiarTabla2(1);

                            band = true;

                            contador_tabla = 0;
                            Clavefield.requestFocus();
                            estableceFolio();




                        } catch (SQLException ex) {
                            Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
                        }


                    }

                }//cambio
                else {
                    JOptionPane.showMessageDialog(this, "El pago es menor que el total", "ERROR", JOptionPane.WARNING_MESSAGE);
                    
                    PagoField.requestFocus();
                   
                    
                }


           } else {
                JOptionPane.showMessageDialog(this, "Introduzca cantidad con la que le pagaron", "ERROR", JOptionPane.ERROR_MESSAGE);
                
                PagoField.requestFocus();
            }


            
           

       }
             
    }//GEN-LAST:event_AceptarVentaKeyPressed

    private void Autocompletar2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Autocompletar2KeyPressed
        if (KeyEvent.getKeyText(evt.getKeyCode()).equals("Intro")) {

            int ElementoSeleccionado = Autocompletar2.getSelectedIndex();
            System.out.println(ElementoSeleccionado);//Se obtiene el elemento seleccionado en la lista NOTA: por default es el primero, por eso se agraga un espacion en blanco
            if (ElementoSeleccionado != -1 && bandera_tecla_abajo == true) {//Se hace la comparacion de que el item seleccionado no sea ni el primero o si este no se ha presionado, puesto que este evento tambien se acciona al agregar un nuevo item
                String Registro = (String) Autocompletar2.getSelectedItem(); //Se obtiene el elemento (String) seleccionado  de la lista desplegable
                String RegistroSeleccionado[] = Registro.split("-"); //Se separa por los guiones 

                System.out.println(" registro seleccionado = " + RegistroSeleccionado);


                for (int i = 0; i < RegistroSeleccionado.length; i++) {
                    RegistroSeleccionado[i] = RegistroSeleccionado[i].trim();
                    System.out.println("Registro seleccionado = " + RegistroSeleccionado[i]);

                }
                String clave = RegistroSeleccionado[0];

                for (int i = 0; i <= contador_tabla; i++) {
                    System.out.println("imprime i = " + i);
                    System.out.println("contador tabla = " + contador_tabla);
                    String otraclave = (String) TablaVenta.getValueAt(i, 0);
                    System.out.println("imrime otra clave = " + otraclave);
                    System.out.println("imprime clave seleccionada = " + clave);

                    if (clave.equals(otraclave)) {
                        System.out.println("entra");
                        int cantidad = Integer.parseInt(TablaVenta.getValueAt(i, 1).toString());
                        int res = cantidad + 1;

                        TablaVenta.setValueAt(RegistroSeleccionado[0], i, 0);
                        TablaVenta.setValueAt(res, i, 1);
                        TablaVenta.setValueAt(RegistroSeleccionado[1], i, 2);
                        TablaVenta.setValueAt(RegistroSeleccionado[2], i, 3);
                        TablaVenta.setValueAt(RegistroSeleccionado[4], i, 4);
                        subtotal(i);
                        AceptarVenta.setVisible(true);
                        EliminarProducto.setVisible(true);
                        bandclave = false;


                        total(contador_tabla - 1);

                        
                        Buscarfield.setText("");
                        Autocompletar2.setSelectedIndex(-1);
                        Clavefield.setText("");
                        Clavefield.requestFocus();
                        Buscarpanel.setVisible(false);
                        Autocompletar2.removeAllItems();
                    }
                }

                if (bandclave == true) {


                    TablaVenta.setValueAt(RegistroSeleccionado[0], contador_tabla, 0);

                    TablaVenta.setValueAt("1", contador_tabla, 1);


                    TablaVenta.setValueAt(RegistroSeleccionado[1], contador_tabla, 2);
                    TablaVenta.setValueAt(RegistroSeleccionado[2], contador_tabla, 3);
                    TablaVenta.setValueAt(RegistroSeleccionado[4], contador_tabla, 4);
                    AceptarVenta.setVisible(true);
                        EliminarProducto.setVisible(true);
                    subtotal(contador_tabla);
                    total(contador_tabla);
                    Clavefield.setText("");
                    contador_tabla += 1;
                    System.out.println("contador tabla banclave buscar = " + contador_tabla);
                    bandera_panel = true;

                    Buscarfield.setText("");
                    Autocompletar2.setSelectedIndex(-1);
                    Clavefield.setText("");
                    Clavefield.requestFocus();
                    Buscarpanel.setVisible(false);
                    Autocompletar2.removeAllItems();

                }





            }

        }
    }//GEN-LAST:event_Autocompletar2KeyPressed

    private void BuscarfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BuscarfieldActionPerformed

    private void jTabbedPane1ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jTabbedPane1ComponentShown
        // TODO add your handling code here:

        Clavefield.requestFocus();

    }//GEN-LAST:event_jTabbedPane1ComponentShown

    private void jPanel1ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel1ComponentShown
        // TODO add your handling code here:
        Clavefield.requestFocus();
        Cortecaja.setVisible(false);
   
        NuevaVenta.setVisible(true);
        Botoneliminar.setVisible(false);
    }//GEN-LAST:event_jPanel1ComponentShown

    private void CantidadfieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CantidadfieldKeyReleased
        // TODO add your handling code here:
       int key = evt.getKeyCode();
        if (key == KeyEvent.VK_0||key == KeyEvent.VK_1||key == KeyEvent.VK_2||key == KeyEvent.VK_3||key == KeyEvent.VK_4||key == KeyEvent.VK_5||key == KeyEvent.VK_6||key == KeyEvent.VK_7||key == KeyEvent.VK_8||key == KeyEvent.VK_9) {
        valida_cantidad+=1;
        System.out.println("imprime = " +valida_cantidad);        

        if(valida_cantidad>10){
        
        String rem= Cantidadfield.getText();
        String poner=rem.substring(0,10);
        
        Cantidadfield.setText(poner);        
        valida_cantidad=10;
            System.out.println(" valida can = "+valida_cantidad);
        }
        }
       
        if (key==KeyEvent.VK_BACK_SPACE)
        {
        valida_cantidad=Cantidadfield.getText().length();
        
            System.out.println("valida back space ="+valida_cantidad);
        }
        
  
        
        
    }//GEN-LAST:event_CantidadfieldKeyReleased

    private void estableceFolio() {
        String valor;


        String[] folio = new String[10];

        for (int i = 0; i < folio.length; i++) {
            int x = (int) (Math.random() * 9);
            System.out.println(x);
            folio[i] = String.valueOf(x);
            System.out.println(folio[i]);
        }

        valor = folio[0] + folio[1] + folio[2] + folio[3] + folio[4] + folio[5] + folio[6] + folio[7] + folio[8] + folio[9];



        System.out.println("valor = " + valor);
        Foliofield.setText(valor);




    }

    private void limpiarTabla2(int Tabla) {
        switch (Tabla) {
            case 1:
                for (int i = 0; i < TablaVenta.getRowCount(); i++) {
                    TablaVenta.setValueAt("", i, 0);
                    TablaVenta.setValueAt("", i, 1);
                    TablaVenta.setValueAt("", i, 2);
                    TablaVenta.setValueAt("", i, 3);
                    TablaVenta.setValueAt("", i, 4);
                    TablaVenta.setValueAt("", i, 5);



                }
                break;
            default:
                throw new AssertionError();
        }

    }

    private void subtotal(int cantidad_fila) {

        int cantidad = Integer.parseInt(TablaVenta.getValueAt(cantidad_fila, 1).toString());
        float precio = Float.parseFloat(TablaVenta.getValueAt(cantidad_fila, 4).toString());

        float resultado = cantidad * precio;

        TablaVenta.setValueAt(resultado, cantidad_fila, 5);


    }

    private void total(int cantidad_fila) {
        float res = 0;

        for (int i = 0; i <= cantidad_fila; i++) {
            System.out.println("imprime i = " + i);
            System.out.println("cantidad fila = " + cantidad_fila);
            float sub = Float.parseFloat(TablaVenta.getValueAt(i, 5).toString());

            res += sub;


        }

        String resultado = String.valueOf(res);
        Total.setText(resultado);
    }

    public int existencia(String clave, int campo_c) {
        int mayor = 0;
        try {
            resultado = conexion.consultar(1, "*", "Clave_A", clave);
            if (resultado != null) {


                while (resultado.next()) {

                    if (clave.equals(resultado.getString(1))) {

                        int cantidad_encontrada = resultado.getInt(4);


                        if (campo_c > cantidad_encontrada) {
                            JOptionPane.showMessageDialog(this, "la cantidad que se desea vender es mayor a la existente");

                            Cantidadfield.setText("");
                            Cantidadfield.requestFocus();
                            mayor = 1;



                        }


                    }




                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
        }


        return mayor;
    }

    private void llenarTabla(int tabla) {
        ContadorLlenadoTabla += 1;//contador de las veces que es utilizado este metodo
        try {

            ResultadoTabla = conexion.consultar(5);//Se invoca al metodo consultar generico para obtener todos los articulos de la tabla

            switch (tabla) {//Se hace la comparacion de la tabla a llenar
                case 1:
                    while (ResultadoTabla.next()) {//Se itera con el Objeto tipo ResulSet
                        //Se guarda en un arreglo los elementos del registro en la tabla para despues ser agregados como una fila
                        Filas[0] = ResultadoTabla.getString(1);//ID
                        Filas[1] = ResultadoTabla.getString(2);//Nombre
                        Filas[2] = ResultadoTabla.getString(3);//Ciudad
                        Filas[3] = ResultadoTabla.getString(4);//Colonia

                        //Se agrega la fila a la tabla, mandandole como parametro el arreglo asignado anteriormente
                        ModeloTabla.addRow(Filas);

                    }


                    break;
                case 2:
                    while (ResultadoTabla.next()) {//Se itera con el Objeto tipo ResulSet
                        //Se guarda en un arreglo los elementos del registro en la tabla para despues ser agregados como una fila
                        Filas[0] = ResultadoTabla.getString(1);//ID
                        Filas[1] = ResultadoTabla.getString(2);//Nombre
                        Filas[2] = ResultadoTabla.getString(3);//Ciudad
                        Filas[3] = ResultadoTabla.getString(4);//Colonia

                        //Se agrega la fila a la tabla, mandandole como parametro el arreglo asignado anteriormente
                        ModeloTabla1.addRow(Filas);

                    }


                    break;
                default:
                    throw new AssertionError();
            }



        } catch (SQLException ex) {
            Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void vaciarTabla(int tabla) {
        switch (tabla) {
            case 1:
                for (int i = TablaEliminar.getRowCount() - 1; i >= 0; i--) {//Se itera desde el ultimo elemento hasta el primero
                    //Se puede hacer al reves pero asi lo kise hcer XD
                    //Se elimina la fila
                    ModeloTabla.removeRow(i);

                }
                break;
            case 2:
                for (int i = TablaConsultar.getRowCount() - 1; i >= 0; i--) {//Se itera desde el ultimo elemento hasta el primero
                    //Se puede hacer al reves pero asi lo kise hcer XD
                    //Se elimina la fila    
                    ModeloTabla1.removeRow(i);

                }
                break;

            default:
                throw new AssertionError();
        }

    }

    private void llenarTabla2(int tabla) {
        ContadorLlenadoTabla += 1;//contador de las veces que es utilizado este metodo
        try {

            ResultadoTabla = conexion.consultar(4);//Se invoca al metodo consultar generico para obtener todos los articulos de la tabla

            switch (tabla) {//Se hace la comparacion de la tabla a llenar
                case 1:
                    while (ResultadoTabla.next()) {//Se itera con el Objeto tipo ResulSet
                        //Se guarda en un arreglo los elementos del registro en la tabla para despues ser agregados como una fila
                        Filas[0] = ResultadoTabla.getString(1);//ID
                        Filas[1] = ResultadoTabla.getString(2);//Nombre
                        Filas[2] = ResultadoTabla.getString(3);//Ciudad
                        Filas[3] = ResultadoTabla.getString(4);//Colonia
                        Filas[4] = ResultadoTabla.getString(5);//Colonia
                        //Se agrega la fila a la tabla, mandandole como parametro el arreglo asignado anteriormente
                        ModeloTabla.addRow(Filas);

                    }


                    break;
                case 2:
                    while (ResultadoTabla.next()) {//Se itera con el Objeto tipo ResulSet
                        //Se guarda en un arreglo los elementos del registro en la tabla para despues ser agregados como una fila
                        Filas[0] = ResultadoTabla.getString(1);//ID
                        Filas[1] = ResultadoTabla.getString(2);//Nombre
                        Filas[2] = ResultadoTabla.getString(3);//Ciudad
                        Filas[3] = ResultadoTabla.getString(4);//Colonia
                        Filas[4] = ResultadoTabla.getString(5);//Colonia
                        //Se agrega la fila a la tabla, mandandole como parametro el arreglo asignado anteriormente
                        ModeloTabla1.addRow(Filas);

                    }


                    break;
                default:
                    throw new AssertionError();
            }



        } catch (SQLException ex) {
            Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void vaciarTabla2(int tabla) {
        switch (tabla) {
            case 1:
                for (int i = TablaEliminar.getRowCount() - 1; i >= 0; i--) {//Se itera desde el ultimo elemento hasta el primero
                    //Se puede hacer al reves pero asi lo kise hcer XD
                    //Se elimina la fila
                    ModeloTabla.removeRow(i);

                }
                break;
            case 2:
                for (int i = TablaConsultar.getRowCount() - 1; i >= 0; i--) {//Se itera desde el ultimo elemento hasta el primero
                    //Se puede hacer al reves pero asi lo kise hcer XD
                    //Se elimina la fila    
                    ModeloTabla1.removeRow(i);

                }
                break;

            default:
                throw new AssertionError();
        }

    }
// 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AceptarVenta;
    private javax.swing.JComboBox Autocompletar2;
    private javax.swing.JButton Botoneliminar;
    private javax.swing.JTextField Buscareliminar;
    private javax.swing.JTextField Buscarfield;
    private javax.swing.JPanel Buscarpanel;
    private javax.swing.JRadioButton Busqueda_clave;
    private javax.swing.JRadioButton Busqueda_nombre;
    private javax.swing.JTextField Cambiofield;
    private javax.swing.JTextField Cantidadfield;
    private javax.swing.JTextField Clavefield;
    private javax.swing.JButton Cortecaja;
    private javax.swing.JComboBox Desplegar3;
    private javax.swing.JButton EliminarProducto;
    private javax.swing.JTextField Foliofield;
    private javax.swing.JButton NuevaVenta;
    private javax.swing.JTextField PagoField;
    private javax.swing.JTable TablaConsultar;
    private javax.swing.JTable TablaEliminar;
    private javax.swing.JTable TablaVenta;
    private javax.swing.JTextField Total;
    private javax.swing.JButton botonCerrar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JComboBox desplegar2;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblTitulo;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
