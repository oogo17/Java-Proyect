package frames;

import conexiones.Conexion;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import utilidades.IconCellRenderer;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import utilidades.Fecha;
//import java.awt.Toolkit;
//import jxl.read.biff.BiffException;

public class Proveedores extends javax.swing.JDialog {

    ResultSet IDproveedor, IDproveedorEli, IDproveedorBus;
    Conexion conexion;
    String ArrayEditarPro[], ArrayEliminarPro[], ArrayBuscarPro[];
    private DefaultTableModel ModeloTabla1, ModeloTabla2, ModeloTabla3;
    Object Filas[];
    private int ContadorLlenadoTabla;
    ResultSet resultado, ResultadoTabla;
    int tabla_proveedores;
    private int contador_primer_caracter;
    private boolean bandera_tecla_abajo, bandera_tecla_abajo2, bandera_tecla_abajo3;

    public Proveedores(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(getClass().getResource("/imagenes/icono-proyecto.png")).getImage());


        lblFecha.setText(Fecha.getDia() + "-" + Fecha.getMes() + "-" + Fecha.getAño());
        conexion = new Conexion();
        conexion.conectarMySQL();
        tabla_proveedores = 0;


        PanelModificarProveedor.setVisible(false);
        Desplegar1.setVisible(false);
        Desplegar2.setVisible(false);
        Desplegar3.setVisible(false);
        MensajeMod.setVisible(false);
        iconoerror.setVisible(false);
        iconoerror2.setVisible(false);
        btncanpro.setVisible(false);
        btnguapro.setVisible(false);
        BtnGuardar.setVisible(false);
        BtnCancelar.setVisible(false);
        ArrayEditarPro = new String[12];
        ArrayEliminarPro = new String[2];
        ArrayBuscarPro = new String[2];
        idpro.requestFocus();
         iconomal1.setVisible(false);
        tablamod.setDefaultRenderer(Object.class, new IconCellRenderer());
        TablaEliminarPro.setDefaultRenderer(Object.class, new IconCellRenderer());
        Filas = new Object[12]; //Inicializacion del arreglo que contendra las filas
        ModeloTabla1 = (DefaultTableModel) tablamod.getModel();
        ModeloTabla2 = (DefaultTableModel) TablaEliminarPro.getModel();
        ModeloTabla3 = (DefaultTableModel) TablaConsultarProveedor.getModel();
        ContadorLlenadoTabla = 0;

        llenarTabla(1);
        llenarTabla(2);
        llenarTabla(3);


        bandera_tecla_abajo = false;
        bandera_tecla_abajo2 = false;
        bandera_tecla_abajo3 = false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        botonCerrar = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nompro = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        callepro = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        numepro = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        numipro = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        webpro = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tnewpro = new javax.swing.JTable();
        btnañadir = new javax.swing.JButton();
        btncanpro = new javax.swing.JButton();
        btnguapro = new javax.swing.JButton();
        emailpro = new javax.swing.JTextField();
        ciudadpro = new javax.swing.JComboBox();
        colpro = new javax.swing.JComboBox();
        cppro = new javax.swing.JComboBox();
        iconoerror = new javax.swing.JLabel();
        iconoerror2 = new javax.swing.JLabel();
        idpro = new javax.swing.JFormattedTextField();
        telppro = new javax.swing.JFormattedTextField();
        telcpro = new javax.swing.JFormattedTextField();
        PanelModificarPro = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        modipro = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablamod = new javax.swing.JTable();
        BtnCancelar = new javax.swing.JButton();
        BtnModificar = new javax.swing.JButton();
        BtnGuardar = new javax.swing.JButton();
        Desplegar1 = new javax.swing.JComboBox();
        PanelModificarProveedor = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        NombreModificar = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        EmailModificar = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        WebModificar = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        CalleModificar = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        ExtModificar = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        IntModificar = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        ParModificar = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        CelModificar = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        CiudadModificar = new javax.swing.JComboBox();
        ColoniaModificar = new javax.swing.JComboBox();
        CpModificar = new javax.swing.JComboBox();
        iconomal1 = new javax.swing.JLabel();
        MensajeMod = new javax.swing.JLabel();
        PanelEliminar = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        TxtEliminarPro = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        TablaEliminarPro = new javax.swing.JTable();
        BtnEliminarPro = new javax.swing.JButton();
        Desplegar2 = new javax.swing.JComboBox();
        panelBuscar = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        TxtBuscarProveedor = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        TablaConsultarProveedor = new javax.swing.JTable();
        Desplegar3 = new javax.swing.JComboBox();
        lblTitulo = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        jScrollBar1 = new javax.swing.JScrollBar();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Proveedores");
        setUndecorated(true);

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

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("ID");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Nombre");

        nompro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomproActionPerformed(evt);
            }
        });
        nompro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                nomproFocusLost(evt);
            }
        });
        nompro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nomproKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nomproKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Email");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Tel_Particular");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Tel_Celular");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("CP");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Ciudad");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Colonia");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Domicilio");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Calle");

        callepro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calleproActionPerformed(evt);
            }
        });
        callepro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                calleproFocusLost(evt);
            }
        });
        callepro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                calleproKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                calleproKeyTyped(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Num_Ext");

        numepro.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        numepro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numeproActionPerformed(evt);
            }
        });
        numepro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                numeproKeyTyped(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Num_Int");

        numipro.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        numipro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numiproActionPerformed(evt);
            }
        });
        numipro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                numiproKeyTyped(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Pág Web");

        webpro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                webproActionPerformed(evt);
            }
        });

        tnewpro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Ciudad", "Colonia", "CP", "Calle", "Num_Ext", "Num_Int", "Tel_Par", "Tel_Cel", "Email", "Pag_Web"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tnewpro.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(tnewpro);

        btnañadir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mas.png"))); // NOI18N
        btnañadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnañadirActionPerformed(evt);
            }
        });
        btnañadir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnañadirKeyPressed(evt);
            }
        });

        btncanpro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancelar.png"))); // NOI18N
        btncanpro.setText("Cancelar");
        btncanpro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncanproActionPerformed(evt);
            }
        });

        btnguapro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar.png"))); // NOI18N
        btnguapro.setText("Guardar");
        btnguapro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguaproActionPerformed(evt);
            }
        });
        btnguapro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnguaproKeyPressed(evt);
            }
        });

        emailpro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailproActionPerformed(evt);
            }
        });
        emailpro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                emailproKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                emailproKeyTyped(evt);
            }
        });

        ciudadpro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CD Guzmán", "Guadalajara" }));
        ciudadpro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ciudadproKeyPressed(evt);
            }
        });

        colpro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Centro", "Independencia" }));
        colpro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                colproKeyPressed(evt);
            }
        });

        cppro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "49000", "44241", "49095" }));
        cppro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cpproKeyPressed(evt);
            }
        });

        iconoerror.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botonCerrarRojo.png"))); // NOI18N
        iconoerror.setText("Mínimo 5 dígitos");

        iconoerror2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botonCerrarRojo.png"))); // NOI18N
        iconoerror2.setText("Incorrecto");

        try {
            idpro.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        idpro.setAutoscrolls(false);
        idpro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idproActionPerformed(evt);
            }
        });
        idpro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                idproFocusLost(evt);
            }
        });
        idpro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                idproKeyTyped(evt);
            }
        });

        try {
            telppro.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-###-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        telppro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telpproActionPerformed(evt);
            }
        });
        telppro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                telpproKeyTyped(evt);
            }
        });

        try {
            telcpro.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-###-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        telcpro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telcproActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(611, 611, 611)
                        .addComponent(btnguapro)
                        .addGap(18, 18, 18)
                        .addComponent(btncanpro))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 847, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(366, 366, 366)
                        .addComponent(iconoerror2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel2)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel15)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(11, 11, 11)
                                    .addComponent(jLabel3)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(webpro)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(emailpro, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))))
                        .addComponent(nompro, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(idpro, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(iconoerror)))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 654, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(603, 603, 603))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(telppro, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                            .addComponent(telcpro))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ciudadpro, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(colpro, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)
                                    .addComponent(cppro, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(37, 37, 37)
                                        .addComponent(callepro, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jLabel13)
                                                    .addComponent(jLabel14)
                                                    .addComponent(numepro, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                                                    .addComponent(numipro))
                                                .addGap(43, 43, 43))
                                            .addComponent(btnañadir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(45, 45, 45)
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(callepro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(numepro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(ciudadpro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(telppro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(colpro, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(telcpro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(numipro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cppro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnañadir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(iconoerror, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idpro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nompro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(webpro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(emailpro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(iconoerror2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(325, 325, 325)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btncanpro)
                            .addComponent(btnguapro))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Agregar", new javax.swing.ImageIcon(getClass().getResource("/imagenes/nuevo.png")), jPanel1); // NOI18N

        PanelModificarPro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PanelModificarPro.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                PanelModificarProComponentShown(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Buscar");

        modipro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                modiproKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                modiproKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                modiproKeyTyped(evt);
            }
        });

        tablamod.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Ciudad", "Colonia", "CP", "Calle", "Num_Ext", "Num_Int", "Tel_Par", "Tel_Cel", "Email", "Pag_Web"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablamod.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tablamod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tablamodKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(tablamod);

        BtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancelar.png"))); // NOI18N
        BtnCancelar.setText("Cancelar");
        BtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCancelarActionPerformed(evt);
            }
        });

        BtnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/editar.png"))); // NOI18N
        BtnModificar.setText("Modifcar");
        BtnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnModificarActionPerformed(evt);
            }
        });
        BtnModificar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnModificarKeyPressed(evt);
            }
        });

        BtnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar.png"))); // NOI18N
        BtnGuardar.setText("Guardar");
        BtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGuardarActionPerformed(evt);
            }
        });
        BtnGuardar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnGuardarKeyPressed(evt);
            }
        });

        Desplegar1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                Desplegar1ItemStateChanged(evt);
            }
        });
        Desplegar1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Desplegar1KeyPressed(evt);
            }
        });

        PanelModificarProveedor.setBorder(javax.swing.BorderFactory.createTitledBorder("Nuevos Datos"));

        jLabel20.setText("Nombre");

        NombreModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NombreModificarActionPerformed(evt);
            }
        });
        NombreModificar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                NombreModificarFocusLost(evt);
            }
        });
        NombreModificar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                NombreModificarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                NombreModificarKeyTyped(evt);
            }
        });

        jLabel21.setText("Email");

        EmailModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmailModificarActionPerformed(evt);
            }
        });
        EmailModificar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                EmailModificarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EmailModificarKeyTyped(evt);
            }
        });

        jLabel22.setText("Pag Web");

        WebModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WebModificarActionPerformed(evt);
            }
        });

        jLabel23.setText("Ciudad");

        jLabel24.setText("CP");

        jLabel25.setText("Calle");

        CalleModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalleModificarActionPerformed(evt);
            }
        });
        CalleModificar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                CalleModificarFocusLost(evt);
            }
        });
        CalleModificar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CalleModificarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CalleModificarKeyTyped(evt);
            }
        });

        jLabel26.setText("Num Ext");

        ExtModificar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ExtModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExtModificarActionPerformed(evt);
            }
        });
        ExtModificar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ExtModificarKeyTyped(evt);
            }
        });

        jLabel27.setText("Num Int");

        IntModificar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        IntModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IntModificarActionPerformed(evt);
            }
        });
        IntModificar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                IntModificarKeyTyped(evt);
            }
        });

        jLabel28.setText("Tel Par");

        ParModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ParModificarActionPerformed(evt);
            }
        });
        ParModificar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ParModificarKeyTyped(evt);
            }
        });

        jLabel29.setText("Tel Cel");

        CelModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CelModificarActionPerformed(evt);
            }
        });
        CelModificar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CelModificarKeyTyped(evt);
            }
        });

        jLabel30.setText("Colonia");

        CiudadModificar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CD Guzmán", "Guadalajara" }));
        CiudadModificar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CiudadModificarKeyPressed(evt);
            }
        });

        ColoniaModificar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Centro", "Independencia" }));
        ColoniaModificar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ColoniaModificarKeyPressed(evt);
            }
        });

        CpModificar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "49000", "44241" }));
        CpModificar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CpModificarKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CpModificarKeyTyped(evt);
            }
        });

        iconomal1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botonCerrarRojo.png"))); // NOI18N

        javax.swing.GroupLayout PanelModificarProveedorLayout = new javax.swing.GroupLayout(PanelModificarProveedor);
        PanelModificarProveedor.setLayout(PanelModificarProveedorLayout);
        PanelModificarProveedorLayout.setHorizontalGroup(
            PanelModificarProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelModificarProveedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelModificarProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelModificarProveedorLayout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(WebModificar))
                    .addGroup(PanelModificarProveedorLayout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addGap(18, 18, 18)
                        .addComponent(ParModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CelModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelModificarProveedorLayout.createSequentialGroup()
                        .addGroup(PanelModificarProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelModificarProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(EmailModificar)
                            .addComponent(NombreModificar))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelModificarProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelModificarProveedorLayout.createSequentialGroup()
                        .addGroup(PanelModificarProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(PanelModificarProveedorLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel23))
                            .addGroup(PanelModificarProveedorLayout.createSequentialGroup()
                                .addComponent(iconomal1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                                .addComponent(jLabel30)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelModificarProveedorLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel24)
                        .addGap(13, 13, 13)))
                .addGroup(PanelModificarProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(CiudadModificar, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ColoniaModificar, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CpModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(PanelModificarProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelModificarProveedorLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CalleModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelModificarProveedorLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(PanelModificarProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelModificarProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(IntModificar, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                            .addComponent(ExtModificar))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelModificarProveedorLayout.setVerticalGroup(
            PanelModificarProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelModificarProveedorLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(PanelModificarProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelModificarProveedorLayout.createSequentialGroup()
                        .addGroup(PanelModificarProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CiudadModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelModificarProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ColoniaModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelModificarProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CpModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24)))
                    .addGroup(PanelModificarProveedorLayout.createSequentialGroup()
                        .addGroup(PanelModificarProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(NombreModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25)
                            .addComponent(CalleModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelModificarProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(jLabel26)
                            .addComponent(ExtModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EmailModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(iconomal1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelModificarProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelModificarProveedorLayout.createSequentialGroup()
                                .addGroup(PanelModificarProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel22)
                                    .addComponent(WebModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(5, 5, 5)
                                .addGroup(PanelModificarProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel28)
                                    .addComponent(ParModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel29)
                                    .addComponent(CelModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(PanelModificarProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel27)
                                .addComponent(IntModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
        );

        javax.swing.GroupLayout PanelModificarProLayout = new javax.swing.GroupLayout(PanelModificarPro);
        PanelModificarPro.setLayout(PanelModificarProLayout);
        PanelModificarProLayout.setHorizontalGroup(
            PanelModificarProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelModificarProLayout.createSequentialGroup()
                .addGroup(PanelModificarProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MensajeMod, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelModificarProLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(PanelModificarProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelModificarProLayout.createSequentialGroup()
                                .addGroup(PanelModificarProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PanelModificarProLayout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(PanelModificarProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Desplegar1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(modipro, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(PanelModificarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelModificarProLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(BtnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnGuardar)))
                .addContainerGap())
        );
        PanelModificarProLayout.setVerticalGroup(
            PanelModificarProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelModificarProLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelModificarProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(modipro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(Desplegar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MensajeMod)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelModificarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelModificarProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnCancelar)
                    .addComponent(BtnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnGuardar))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Modificar", new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconomodificar.png")), PanelModificarPro); // NOI18N

        PanelEliminar.setBackground(new java.awt.Color(255, 255, 255));
        PanelEliminar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PanelEliminar.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                PanelEliminarComponentShown(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("Buscar");

        TxtEliminarPro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TxtEliminarProKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtEliminarProKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtEliminarProKeyTyped(evt);
            }
        });

        TablaEliminarPro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Ciudad", "Colonia", "CP", "Calle", "Num_Ext", "Num_Int", "Tel_par", "Tel_Cel", "Email", "Pag_Web"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaEliminarPro.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane3.setViewportView(TablaEliminarPro);

        BtnEliminarPro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar.png"))); // NOI18N
        BtnEliminarPro.setText("Eliminar");
        BtnEliminarPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarProActionPerformed(evt);
            }
        });

        Desplegar2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                Desplegar2ItemStateChanged(evt);
            }
        });
        Desplegar2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Desplegar2KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout PanelEliminarLayout = new javax.swing.GroupLayout(PanelEliminar);
        PanelEliminar.setLayout(PanelEliminarLayout);
        PanelEliminarLayout.setHorizontalGroup(
            PanelEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelEliminarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 827, Short.MAX_VALUE)
                    .addGroup(PanelEliminarLayout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Desplegar2, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtEliminarPro, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelEliminarLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(BtnEliminarPro)))
                .addContainerGap())
        );
        PanelEliminarLayout.setVerticalGroup(
            PanelEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelEliminarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(TxtEliminarPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addComponent(Desplegar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                .addComponent(BtnEliminarPro, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Eliminar", new javax.swing.ImageIcon(getClass().getResource("/imagenes/borrar.png")), PanelEliminar); // NOI18N

        panelBuscar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelBuscar.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                panelBuscarComponentShown(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setText("Buscar");

        TxtBuscarProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TxtBuscarProveedorKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtBuscarProveedorKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtBuscarProveedorKeyTyped(evt);
            }
        });

        TablaConsultarProveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Ciudad", "Colonia", "CP", "Calle", "Num_Ext", "Num_Int", "Tel_Par", "Tel_Cel", "Email", "Pag_Web"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaConsultarProveedor.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        TablaConsultarProveedor.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                TablaConsultarProveedorComponentShown(evt);
            }
        });
        TablaConsultarProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TablaConsultarProveedorKeyPressed(evt);
            }
        });
        jScrollPane4.setViewportView(TablaConsultarProveedor);

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

        javax.swing.GroupLayout panelBuscarLayout = new javax.swing.GroupLayout(panelBuscar);
        panelBuscar.setLayout(panelBuscarLayout);
        panelBuscarLayout.setHorizontalGroup(
            panelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBuscarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBuscarLayout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Desplegar3, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtBuscarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 827, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelBuscarLayout.setVerticalGroup(
            panelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBuscarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(TxtBuscarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addComponent(Desplegar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(134, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Consultar", new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar.png")), panelBuscar); // NOI18N

        jTabbedPane1.setBounds(10, 40, 970, 600);
        jLayeredPane1.add(jTabbedPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lblTitulo.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Proveedores");
        lblTitulo.setBounds(440, 10, 110, 22);
        jLayeredPane1.add(lblTitulo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lblFecha.setFont(new java.awt.Font("Candara", 1, 12)); // NOI18N
        lblFecha.setForeground(new java.awt.Color(255, 255, 255));
        lblFecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFecha.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblFecha.setBounds(850, 10, 130, 18);
        jLayeredPane1.add(lblFecha, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jScrollBar1.setBounds(460, 390, 21, 48);
        jLayeredPane1.add(jScrollBar1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoventanapro.png"))); // NOI18N
        fondo.setBounds(0, 0, 1000, 750);
        jLayeredPane1.add(fondo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_botonCerrarActionPerformed

    private void btnañadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnañadirActionPerformed

        if (!idpro.getText().equals("") && !nompro.getText().equals("") && !ciudadpro.getSelectedItem().equals("") && !colpro.getSelectedItem().equals("") && !cppro.getSelectedItem().equals("") && !callepro.getText().equals("") && !numepro.getText().equals("") && !numipro.getText().equals("") && !telppro.getText().equals("") && !telcpro.getText().equals("") && !emailpro.getText().equals("") && !webpro.getText().equals("")) {
           
            
            tnewpro.setValueAt(idpro.getText(), tabla_proveedores, 0);
            tnewpro.setValueAt(nompro.getText(), tabla_proveedores, 1);
            tnewpro.setValueAt(ciudadpro.getSelectedItem(), tabla_proveedores, 2);
            tnewpro.setValueAt(colpro.getSelectedItem(), tabla_proveedores, 3);
            tnewpro.setValueAt(cppro.getSelectedItem(), tabla_proveedores, 4);
            tnewpro.setValueAt(callepro.getText(), tabla_proveedores, 5);
            tnewpro.setValueAt(numepro.getText(), tabla_proveedores, 6);
            tnewpro.setValueAt(numipro.getText(), tabla_proveedores, 7);
            tnewpro.setValueAt(telppro.getText(), tabla_proveedores, 8);
            tnewpro.setValueAt(telcpro.getText(), tabla_proveedores, 9);
            tnewpro.setValueAt(emailpro.getText(), tabla_proveedores, 10);
            tnewpro.setValueAt(webpro.getText(), tabla_proveedores, 11);

            idpro.setText("");
            nompro.setText("");
            ciudadpro.setSelectedItem("");
            colpro.setSelectedItem("");
            callepro.setText("");
            cppro.setSelectedItem("");
            numepro.setText("");
            numipro.setText("");
            telppro.setText("");
            telcpro.setText("");
            emailpro.setText("");
            webpro.setText("");
            idpro.requestFocus();
             btncanpro.setVisible(true);
            idpro.requestFocus();  btnguapro.setVisible(true);
            tabla_proveedores += 1;

        } else {
            JOptionPane.showMessageDialog(this, "Los campos no pueden estar vacios");


        }
    }//GEN-LAST:event_btnañadirActionPerformed

    private void btncanproActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncanproActionPerformed

        idpro.setText("");
        nompro.setText("");
        ciudadpro.setSelectedItem("");
        colpro.setSelectedItem("");
        cppro.setSelectedItem("");
        callepro.setText("");
        numepro.setText("");
        numipro.setText("");
        telppro.setText("");
        telcpro.setText("");
        emailpro.setText("");
        webpro.setText("");
        btncanpro.setVisible(false);
        btnguapro.setVisible(false);
        limpiarTabla(1);
    }//GEN-LAST:event_btncanproActionPerformed

    private void limpiarTabla(int Tabla) {
        switch (Tabla) {
            case 1:
                for (int i = 0; i < tnewpro.getRowCount(); i++) {
                    tnewpro.setValueAt("", i, 0);
                    tnewpro.setValueAt("", i, 1);
                    tnewpro.setValueAt("", i, 2);
                    tnewpro.setValueAt("", i, 3);
                    tnewpro.setValueAt("", i, 4);
                    tnewpro.setValueAt("", i, 5);
                    tnewpro.setValueAt("", i, 6);
                    tnewpro.setValueAt("", i, 7);
                    tnewpro.setValueAt("", i, 8);
                    tnewpro.setValueAt("", i, 9);
                    tnewpro.setValueAt("", i, 10);
                    tnewpro.setValueAt("", i, 11);

                }
                break;
            default:
                throw new AssertionError();
        }

    }

    private void btnguaproActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguaproActionPerformed

        if (JOptionPane.showConfirmDialog(this, "¿Desea Almacenar Proveedor", "Mensaje", 1) == 0) {
            try {

                for (int i = 0; i < tabla_proveedores; i++) {
                    String encabezado_proveedores[] = {(String.valueOf(tnewpro.getValueAt(i, 0))), String.valueOf(tnewpro.getValueAt(i, 1)), String.valueOf(tnewpro.getValueAt(i, 8)), String.valueOf(tnewpro.getValueAt(i, 9)), String.valueOf(tnewpro.getValueAt(i, 5)), String.valueOf(tnewpro.getValueAt(i, 7)), String.valueOf(tnewpro.getValueAt(i, 6)), String.valueOf(tnewpro.getValueAt(i, 3)), String.valueOf(tnewpro.getValueAt(i, 2)), String.valueOf(tnewpro.getValueAt(i, 4)), String.valueOf(tnewpro.getValueAt(i, 10)), String.valueOf(tnewpro.getValueAt(i, 11))};
                    conexion.insertar(6, encabezado_proveedores);
                }

                JOptionPane.showMessageDialog(this, "El proveedor se ha almacenado");
                btncanpro.setVisible(false);
                btnguapro.setVisible(false);
                idpro.requestFocus();
                tabla_proveedores = 0;
                contador_primer_caracter=0;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error al conectar con SQL");
            }
        }
    }//GEN-LAST:event_btnguaproActionPerformed

    private void nomproKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomproKeyTyped
        char c = evt.getKeyChar();
        if (!Character.getName(c).equals("SPACE") && Character.isLetter(c) == false && !Character.getName(c).equals("FULL STOP")) {
            evt.consume();
        } else {
            if (nompro.getText().length() > 49) {
                Toolkit.getDefaultToolkit().beep();
                evt.consume();
            }
        }
    }//GEN-LAST:event_nomproKeyTyped

    private void emailproKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailproKeyTyped
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
    }//GEN-LAST:event_emailproKeyTyped

    private void numiproKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numiproKeyTyped
        char c = evt.getKeyChar();
        if (Character.isDigit(c) == false) {
            evt.consume();
        } else {
            if (numipro.getText().length() > 6) {
                Toolkit.getDefaultToolkit().beep();
                evt.consume();
            }
        }
    }//GEN-LAST:event_numiproKeyTyped

    private void numeproKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numeproKeyTyped
        char c = evt.getKeyChar();
        if (Character.isDigit(c) == false) {
            evt.consume();
        } else {
            if (numepro.getText().length() > 6) {
                Toolkit.getDefaultToolkit().beep();
                evt.consume();
            }
        }
    }//GEN-LAST:event_numeproKeyTyped

    private void calleproKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_calleproKeyTyped
        char c = evt.getKeyChar();
        if (!Character.getName(c).equals("SPACE") && Character.isLetter(c) == false && !Character.getName(c).equals("FULL STOP")) {
            evt.consume();
        }
        else{
            if(callepro.getText().length()>24){
                evt.consume();
            }
        }
    }//GEN-LAST:event_calleproKeyTyped

    private void modiproKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_modiproKeyReleased

        String Aux = "";
        try {


            Aux = (String) modipro.getText();
            if (!Aux.equals("")) {
                if (bandera_tecla_abajo == false) {
                    IDproveedor = conexion.consultar(6, "*", "Nom_Pro", Aux);
                    if (IDproveedor != null) {
                        Desplegar1.setVisible(true);
                        Desplegar1.addItem(" ");
                        while (IDproveedor.next()) {

                            ArrayEditarPro[0] = IDproveedor.getString(1);
                            ArrayEditarPro[1] = IDproveedor.getString(2);


                            Desplegar1.addItem(ArrayEditarPro[0] + "-" + ArrayEditarPro[1]);

                        }

                        Desplegar1.showPopup();
                        Desplegar1.revalidate();

                    }
                } else {

                    Desplegar1.requestFocus();
                    Desplegar1.setSelectedIndex(0);


                }
            } else {
                Desplegar1.hidePopup();
                Desplegar1.setVisible(false);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al conectar con MySQL");

        }
    }//GEN-LAST:event_modiproKeyReleased

    private void modiproKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_modiproKeyTyped
        char c = evt.getKeyChar();
        if (!Character.getName(c).equals("SPACE") && Character.isLetter(c) == false && !Character.getName(c).equals("FULL STOP")) {
            evt.consume();
        }

        Desplegar1.removeAllItems();
        bandera_tecla_abajo = false;
    }//GEN-LAST:event_modiproKeyTyped

    private void TxtEliminarProKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtEliminarProKeyReleased

        String Aux2 = "";
        try {

            Aux2 = (String) TxtEliminarPro.getText();
            if (!Aux2.equals("")) {
                if (bandera_tecla_abajo2 == false) {
                    IDproveedorEli = conexion.consultar(6, "*", "Nom_Pro", Aux2);
                    if (IDproveedorEli != null) {
                        Desplegar2.setVisible(true);
                        Desplegar2.addItem(" ");
                        while (IDproveedorEli.next()) {

                            ArrayEliminarPro[0] = IDproveedorEli.getString(1);
                            ArrayEliminarPro[1] = IDproveedorEli.getString(2);


                            Desplegar2.addItem(ArrayEliminarPro[0] + "-" + ArrayEliminarPro[1]);

                        }

                        Desplegar2.showPopup();
                        Desplegar2.revalidate();


                    }
                } else {

                    Desplegar2.requestFocus();
                    Desplegar2.setSelectedIndex(0);

                }
            } else {
                Desplegar2.hidePopup();
                Desplegar2.setVisible(false);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al conectar con MySQL");

        }
    }//GEN-LAST:event_TxtEliminarProKeyReleased

    private void TxtEliminarProKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtEliminarProKeyTyped

        char c = evt.getKeyChar();
        if (!Character.getName(c).equals("SPACE") && Character.isLetter(c) == false && !Character.getName(c).equals("FULL STOP")) {
            evt.consume();
        }

        Desplegar2.removeAllItems();
        bandera_tecla_abajo2 = false;
    }//GEN-LAST:event_TxtEliminarProKeyTyped

    private void TxtBuscarProveedorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtBuscarProveedorKeyReleased

        String Aux3 = "";
        try {

            Aux3 = (String) TxtBuscarProveedor.getText();
            if (!Aux3.equals("")) {
                if (bandera_tecla_abajo3 == false) {

                    IDproveedorBus = conexion.consultar(6, "*", "Nom_Pro", Aux3);

                    if (IDproveedorBus != null) {
                        Desplegar3.setVisible(true);
                        Desplegar3.addItem(" ");
                        while (IDproveedorBus.next()) {

                            ArrayBuscarPro[0] = IDproveedorBus.getString(1);
                            ArrayBuscarPro[1] = IDproveedorBus.getString(2);


                            Desplegar3.addItem(ArrayBuscarPro[0] + "-" + ArrayBuscarPro[1]);

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

        }

    }//GEN-LAST:event_TxtBuscarProveedorKeyReleased

    private void TxtBuscarProveedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtBuscarProveedorKeyTyped

        char c = evt.getKeyChar();
        if (!Character.getName(c).equals("SPACE") && Character.isLetter(c) == false && !Character.getName(c).equals("FULL STOP")) {
            evt.consume();
        }

        Desplegar3.removeAllItems();
    }//GEN-LAST:event_TxtBuscarProveedorKeyTyped

    private void emailproKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailproKeyReleased
        char correo1[] = emailpro.getText().toCharArray();
        String aux = "";
        if (!emailpro.getText().equals("")) {
            if (emailpro.getText().length() >= 3) {
                if (correo1[correo1.length - 1] == correo1[correo1.length - 2] && !Character.isLetter(correo1[correo1.length - 1]) && !Character.isLetter(correo1[correo1.length - 1])) {
                    for (int i = 0; i < correo1.length - 1; i++) {
                        aux = aux + correo1[i];
                    }
                    emailpro.setText(aux);
                }
            }
            if (!isEmail(emailpro.getText())) {
                iconoerror2.setVisible(true);
            } else {
                contador_primer_caracter=0;
                iconoerror2.setVisible(false);

            }
        } else {
            contador_primer_caracter = 0;
        }

    }//GEN-LAST:event_emailproKeyReleased

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

    private void Desplegar1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_Desplegar1ItemStateChanged

        int ElementoSeleccionado = Desplegar1.getSelectedIndex();//Se obtiene el elemento seleccionado en la lista NOTA: por default es el primero, por eso se agraga un espacion en blanco
        if (ElementoSeleccionado != -1 && bandera_tecla_abajo == false) {//Se hace la comparacion de que el item seleccionado no sea ni el primero o si este no se ha presionado, puesto que este evento tambien se acciona al agregar un nuevo item
            String Registro = (String) Desplegar1.getSelectedItem(); //Se obtiene el elemento (String) seleccionado  de la lista desplegable
            String RegistroSeleccionado[] = Registro.split("-"); //Se separa por los guiones 
            for (int i = 0; i < RegistroSeleccionado.length; i++) {
                RegistroSeleccionado[i] = RegistroSeleccionado[i].trim();

            }
            for (int i = 0; i < tablamod.getRowCount(); i++) {//Se recorre toda la tabla para encontrar el articulo y asi seleccionarlo,
                //esto ayuda cuando se tiene mas elementos y no se pueden presentar todos dentro de los primeros elementos de la lista

                if (String.valueOf(tablamod.getValueAt(i, 0)).equals(RegistroSeleccionado[0])) {//Se hace la comparacion del elemento con lo que hay en la lista
                    //Si si, se selecciona automaticamente la fila, indicando el articulo que se encuentra

                    tablamod.setRowSelectionInterval(i, i);

                    int fila_a_desplegar = (i + 1) * 16;
                    Point punto = new Point(0, fila_a_desplegar);
                    jScrollPane2.getViewport().setViewPosition(punto);
                    Desplegar1.setVisible(false);//Se oculta la lista desplegable
                    modipro.setText("");//Se borra el texto de busqueda
                    break;
                }
            }
        }

    }//GEN-LAST:event_Desplegar1ItemStateChanged

    private void BtnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnModificarActionPerformed
        
        if (tablamod.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Primero debes seleccionar un artículo de la tabla");

        } else {
            BtnGuardar.setVisible(true);//Se hace visible el boton guardar para permitir guardar los cambios
            BtnCancelar.setVisible(true);//Se hace visible el boton cancelar para permitir cancelar los cambios
            int filatabla = tablamod.getSelectedRow();//Se asigna a una variable el numero de fila que esta seleccionada
            PanelModificar(filatabla);//Se invoca al metodo que se encarga de visualizar el panel de los campos a modificar así como tambien llenarlos con los antiguos datos
        }
    }//GEN-LAST:event_BtnModificarActionPerformed

    private void BtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGuardarActionPerformed
        int columna = tablamod.getSelectedRow();

        String Registro[] = {String.valueOf(tablamod.getValueAt(columna, 0)), NombreModificar.getText(), ParModificar.getText(), CelModificar.getText(), CalleModificar.getText(), IntModificar.getText(), ExtModificar.getText(), (String) ColoniaModificar.getSelectedItem(), (String) CiudadModificar.getSelectedItem(), (String) CpModificar.getSelectedItem(), EmailModificar.getText(), WebModificar.getText()};

        try {

            int a = JOptionPane.showConfirmDialog(this, "¿Realmente deseas guardar las Modificaciones?", "Advertencia", 0, 3);
            if (a == 0) {

                conexion.modificar(6, Registro, String.valueOf(tablamod.getValueAt(columna, 0)));
                JOptionPane.showMessageDialog(this, "Proveedor Modificado");


                PanelModificarProveedor.setVisible(false);
                modipro.setText("");
                MensajeMod.setVisible(false);
                BtnGuardar.setVisible(false);
                Desplegar1.setVisible(false);


                vaciarTabla(1);
                llenarTabla(1);
                modipro.requestFocus();


            }


        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al guardar los cambios al artículo");
            Logger.getLogger(Proveedores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BtnGuardarActionPerformed

    private void BtnEliminarProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarProActionPerformed

        if (TablaEliminarPro.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Primero debes seleccionar un provedor de la tabla");

        } else {

            int filatabla = TablaEliminarPro.getSelectedRow();
            int a = JOptionPane.showConfirmDialog(this, "¿Realmente desea eliminar este proveedor?", "Advertencia", 0, 3);
            if (a == 0) {

                try {

                    conexion.eliminar(6, String.valueOf(TablaEliminarPro.getValueAt(filatabla, 0)));
                    JOptionPane.showMessageDialog(this, "Registro Borrado");


                    vaciarTabla(2);
                    llenarTabla(2);

                    //Se devuelve el foco al campo de busquedas
                    TxtEliminarPro.requestFocus();

                } catch (SQLException ex) {
                    Logger.getLogger(Proveedores.class.getName()).log(Level.SEVERE, null, ex);
                }


            }

        }

        ArrayEditarPro[0] = "";
        ArrayEditarPro[1] = "";
        ArrayEditarPro[2] = "";
        ArrayEditarPro[3] = "";
        ArrayEditarPro[4] = "";
        ArrayEditarPro[5] = "";
        ArrayEditarPro[6] = "";
        ArrayEditarPro[7] = "";
        ArrayEditarPro[8] = "";
        ArrayEditarPro[9] = "";
        ArrayEditarPro[10] = "";
        ArrayEditarPro[11] = "";


    }//GEN-LAST:event_BtnEliminarProActionPerformed

    private void BtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelarActionPerformed

        PanelModificarProveedor.setVisible(false);
        Desplegar2.setVisible(false);
        MensajeMod.setVisible(false);
        modipro.setText("");

        //IdModificar.setText("");
        NombreModificar.setText("");
        CiudadModificar.setSelectedItem("");
        ColoniaModificar.setSelectedItem("");
        CpModificar.setSelectedItem("");
        CalleModificar.setText("");
        ExtModificar.setText("");
        IntModificar.setText("");
        ParModificar.setText("");
        CelModificar.setText("");
        EmailModificar.setText("");
        WebModificar.setText("");

        ArrayEditarPro[0] = "";
        ArrayEditarPro[1] = "";
        ArrayEditarPro[2] = "";
        ArrayEditarPro[3] = "";
        ArrayEditarPro[4] = "";
        ArrayEditarPro[5] = "";
        ArrayEditarPro[6] = "";
        ArrayEditarPro[7] = "";
        ArrayEditarPro[8] = "";
        ArrayEditarPro[9] = "";
        ArrayEditarPro[10] = "";
        ArrayEditarPro[11] = "";
        BtnCancelar.setVisible(false);
        BtnGuardar.setVisible(false);


    }//GEN-LAST:event_BtnCancelarActionPerformed

    private void PanelModificarProComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_PanelModificarProComponentShown
        if (ContadorLlenadoTabla > 2) {

            vaciarTabla(1);
            llenarTabla(1);
        }
    }//GEN-LAST:event_PanelModificarProComponentShown

    private void nomproKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomproKeyReleased
     String aux = "";
        if (!nompro.getText().equals("")) {
            String ContenidoNuevo[] = nompro.getText().split(" ");
            if (KeyEvent.getKeyText(evt.getKeyCode()).equals("Espacio")) {

                for (int i = 0; i < ContenidoNuevo.length; i++) {
                    if (i == ContenidoNuevo.length) {
                        aux = aux + ContenidoNuevo[i];
                    } else {
                        aux = aux + ContenidoNuevo[i] + " ";
                    }

                }
                nompro.setText(aux);

            } else {
                char correo1[] = nompro.getText().toCharArray();
                String aux2 = "";
                if (nompro.getText().length() >= 3) {
                    if (correo1[correo1.length - 1] == correo1[correo1.length - 2] && !Character.isLetter(correo1[correo1.length - 1]) && !Character.isLetter(correo1[correo1.length - 1])) {
                        for (int i = 0; i < correo1.length - 1; i++) {
                            aux = aux + correo1[i];
                        }
                        nompro.setText(aux);
                    }
                }

            }

        }
    }//GEN-LAST:event_nomproKeyReleased

    private void calleproKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_calleproKeyReleased
        char correo1[] = callepro.getText().toCharArray();
        String aux = "";
        if (!callepro.getText().equals("")) {
            if (callepro.getText().length() >= 3) {
                if (correo1[correo1.length - 1] == correo1[correo1.length - 2] && !Character.isLetter(correo1[correo1.length - 1]) && !Character.isLetter(correo1[correo1.length - 1])) {
                    for (int i = 0; i < correo1.length - 1; i++) {
                        aux = aux + correo1[i];
                    }
                    callepro.setText(aux);
                }
            }

        } else {
            contador_primer_caracter = 0;
        }
    }//GEN-LAST:event_calleproKeyReleased

    private void webproActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_webproActionPerformed
        emailpro.requestFocus();
    }//GEN-LAST:event_webproActionPerformed

    private void idproFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_idproFocusLost
        String aux[] = idpro.getText().split(" ");
        if (!idpro.getText().equals("     ")) {
            if (aux[0].length() < 5) {
                iconoerror.setVisible(true);
            } else {
                iconoerror.setVisible(false);
            }
        }
    }//GEN-LAST:event_idproFocusLost

    private void telpproKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telpproKeyTyped
        char c = evt.getKeyChar();
        if (Character.isDigit(c) == false) {
            evt.consume();
        }
    }//GEN-LAST:event_telpproKeyTyped

    private void Desplegar2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_Desplegar2ItemStateChanged
        int ElementoSeleccionado = Desplegar2.getSelectedIndex();
        if (ElementoSeleccionado != -1 && bandera_tecla_abajo2 == false) {//Se obtiene el elemento seleccionado en la lista NOTA: por default es el primero, por eso se agraga un espacion en blanco
            if (ElementoSeleccionado != 0 && ElementoSeleccionado != -1) {//Se hace la comparacion de que el item seleccionado no sea ni el primero o si este no se ha presionado, puesto que este evento tambien se acciona al agregar un nuevo item
                String Registro = (String) Desplegar2.getSelectedItem(); //Se obtiene el elemento (String) seleccionado  de la lista desplegable
                String RegistroSeleccionado[] = Registro.split("-"); //Se separa por los guiones 
                for (int i = 0; i < RegistroSeleccionado.length; i++) {
                    RegistroSeleccionado[i] = RegistroSeleccionado[i].trim();

                }
                for (int i = 0; i < TablaEliminarPro.getRowCount(); i++) {//Se recorre toda la tabla para encontrar el articulo y asi seleccionarlo,
                    //esto ayuda cuando se tiene mas elementos y no se pueden presentar todos dentro de los primeros elementos de la lista

                    if (String.valueOf(TablaEliminarPro.getValueAt(i, 0)).equals(RegistroSeleccionado[0])) {//Se hace la comparacion del elemento con lo que hay en la lista
                        //Si si, se selecciona automaticamente la fila, indicando el articulo que se encuentra

                        TablaEliminarPro.setRowSelectionInterval(i, i);

                        int fila_a_desplegar = (i + 1) * 16;
                        Point punto = new Point(0, fila_a_desplegar);
                        jScrollPane2.getViewport().setViewPosition(punto);
                        Desplegar2.setVisible(false);//Se oculta la lista desplegable
                        TxtEliminarPro.setText("");//Se borra el texto de busqueda
                        break;
                    }
                }
            }
        }
    }//GEN-LAST:event_Desplegar2ItemStateChanged

    private void Desplegar3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_Desplegar3ItemStateChanged
        int ElementoSeleccionado = Desplegar3.getSelectedIndex();//Se obtiene el elemento seleccionado en la lista NOTA: por default es el primero, por eso se agraga un espacion en blanco
        if (ElementoSeleccionado != -1 && bandera_tecla_abajo3 == false) {//Se hace la comparacion de que el item seleccionado no sea ni el primero o si este no se ha presionado, puesto que este evento tambien se acciona al agregar un nuevo item
            String Registro = (String) Desplegar3.getSelectedItem(); //Se obtiene el elemento (String) seleccionado  de la lista desplegable
            String RegistroSeleccionado[] = Registro.split("-"); //Se separa por los guiones 
            for (int i = 0; i < RegistroSeleccionado.length; i++) {
                RegistroSeleccionado[i] = RegistroSeleccionado[i].trim();

            }
            for (int i = 0; i < TablaConsultarProveedor.getRowCount(); i++) {//Se recorre toda la tabla para encontrar el articulo y asi seleccionarlo,
                //esto ayuda cuando se tiene mas elementos y no se pueden presentar todos dentro de los primeros elementos de la lista

                if (String.valueOf(TablaConsultarProveedor.getValueAt(i, 0)).equals(RegistroSeleccionado[0])) {//Se hace la comparacion del elemento con lo que hay en la lista
                    //Si si, se selecciona automaticamente la fila, indicando el articulo que se encuentra

                    TablaConsultarProveedor.setRowSelectionInterval(i, i);

                    int fila_a_desplegar = (i + 1) * 16;
                    Point punto = new Point(0, fila_a_desplegar);
                    jScrollPane2.getViewport().setViewPosition(punto);
                    Desplegar3.setVisible(false);//Se oculta la lista desplegable
                    TxtBuscarProveedor.setText("");//Se borra el texto de busqueda
                    break;
                }
            }
        }

    }//GEN-LAST:event_Desplegar3ItemStateChanged

    private void PanelEliminarComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_PanelEliminarComponentShown

        TxtEliminarPro.requestFocus();
        if (ContadorLlenadoTabla > 2) {

            vaciarTabla(2);
            llenarTabla(2);
        }
    }//GEN-LAST:event_PanelEliminarComponentShown

    private void panelBuscarComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_panelBuscarComponentShown

        if (ContadorLlenadoTabla > 2) {

            vaciarTabla(3);
            llenarTabla(3);
        }
    }//GEN-LAST:event_panelBuscarComponentShown

    private void BtnGuardarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnGuardarKeyPressed
        int columna = tablamod.getSelectedRow();
        String ValoresRegistro[] = {String.valueOf(tablamod.getValueAt(columna, 0)), NombreModificar.getText(), ParModificar.getText(), CelModificar.getText(), CalleModificar.getText(), IntModificar.getText(), ExtModificar.getText(), (String) ColoniaModificar.getSelectedItem(), (String) CiudadModificar.getSelectedItem(), (String) CpModificar.getSelectedItem(), EmailModificar.getText(), WebModificar.getText()};
        try {
            char c = evt.getKeyChar();
            if (KeyEvent.getKeyText(evt.getKeyCode()).equals("Intro")) {

                int a = JOptionPane.showConfirmDialog(this, "¿Realmente desea Modificar proveedor?", "Guardar Modificaciones", 0, 3);
                if (a == 0) {

                    conexion.modificar(6, ValoresRegistro, String.valueOf(tablamod.getValueAt(columna, 0)));
                    JOptionPane.showMessageDialog(this, "Proveedor Modificado");

                    PanelModificarProveedor.setVisible(false);
                    modipro.setText("");
                    MensajeMod.setVisible(false);
                    BtnGuardar.setVisible(false);
                    BtnCancelar.setVisible(false);
                    Desplegar1.setVisible(false);
                    modipro.requestFocus();

                    vaciarTabla(1);
                    llenarTabla(1);

                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al guardar los cambios del proveedor");
            Logger.getLogger(Proveedores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BtnGuardarKeyPressed

    private void tablamodKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablamodKeyPressed
        if (KeyEvent.getKeyText(evt.getKeyCode()).equals("Intro")) {
        }
    }//GEN-LAST:event_tablamodKeyPressed

    private void BtnModificarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnModificarKeyPressed
        if (KeyEvent.getKeyText(evt.getKeyCode()).equals("Intro")) {
            if (tablamod.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(this, "Primero debes seleccionar un artículo de la tabla");

            } else {
                BtnGuardar.setVisible(true);//Se hace visible el boton guardar para permitir guardar los cambios
                BtnCancelar.setVisible(true);//Se hace visible el boton cancelar para permitir cancelar los cambios
                int filatabla = tablamod.getSelectedRow();//Se asigna a una variable el numero de fila que esta seleccionada
                PanelModificar(filatabla);//Se invoca al metodo que se encarga de visualizar el panel de los campos a modificar así como tambien llenarlos con los antiguos datos
            }
        }
    }//GEN-LAST:event_BtnModificarKeyPressed

    private void TablaConsultarProveedorComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_TablaConsultarProveedorComponentShown
        TxtBuscarProveedor.requestFocus();
        if (ContadorLlenadoTabla > 2) {

            llenarTabla(3);
            vaciarTabla(3);
        }
    }//GEN-LAST:event_TablaConsultarProveedorComponentShown

    private void TablaConsultarProveedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TablaConsultarProveedorKeyPressed
        if (KeyEvent.getKeyText(evt.getKeyCode()).equals("Intro")) {
        }
    }//GEN-LAST:event_TablaConsultarProveedorKeyPressed

    private void modiproKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_modiproKeyPressed
        if ((KeyEvent.getKeyText(evt.getKeyCode()).equals("Abajo") || KeyEvent.getKeyText(evt.getKeyCode()).equals("Arriba")) && Desplegar1.isVisible()) {
            bandera_tecla_abajo = true;
        }
    }//GEN-LAST:event_modiproKeyPressed

    private void Desplegar1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Desplegar1KeyPressed
        if (KeyEvent.getKeyText(evt.getKeyCode()).equals("Intro")) {//Se hace la comparacion de que el item seleccionado no sea ni el primero o si este no se ha presionado, puesto que este evento tambien se acciona al agregar un nuevo item
            String Registro = (String) Desplegar1.getSelectedItem(); //Se obtiene el elemento (String) seleccionado  de la lista desplegable
            String RegistroSeleccionado[] = Registro.split("-"); //Se separa por los guiones 
            for (int i = 0; i < RegistroSeleccionado.length; i++) {
                RegistroSeleccionado[i] = RegistroSeleccionado[i].trim();

            }
            for (int i = 0; i < tablamod.getRowCount(); i++) {//Se recorre toda la tabla para encontrar el articulo y asi seleccionarlo,
                //esto ayuda cuando se tiene mas elementos y no se pueden presentar todos dentro de los primeros elementos de la lista

                if (String.valueOf(tablamod.getValueAt(i, 0)).equals(RegistroSeleccionado[0])) {//Se hace la comparacion del elemento con lo que hay en la lista
                    //Si si, se selecciona automaticamente la fila, indicando el articulo que se encuentra

                    tablamod.setRowSelectionInterval(i, i);
                    //--Las siguientes lineas de codigo sirven para visualizar el renglon seleccionado anteriormente
                    int fila_a_desplegar = (i * 16) + 1; //se obtiene el valor de la coordenada en y del renglon seleccionado
                    Point punto = new Point(0, fila_a_desplegar);   //Se crea un objeto tipo Point que nos ayudara a visualizar el renglón
                    jScrollPane1.getViewport().setViewPosition(punto);//Se visualiza el renglon  del ScrollBar mediante el metodo setViewPort teniendo como parametro el objeto tipo Point
                    PanelModificar(i); //Se muestran el panel que contiene los campos para modificar los datos
                    BtnCancelar.setVisible(true);
                    BtnGuardar.setVisible(true);
                    Desplegar1.setVisible(false);//Se oculta la lista desplegable
                    modipro.setText("");//Se borra el texto de busqueda
                    break;
                }
            }

        }
    }//GEN-LAST:event_Desplegar1KeyPressed

    private void TxtEliminarProKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtEliminarProKeyPressed
        if ((KeyEvent.getKeyText(evt.getKeyCode()).equals("Abajo") || KeyEvent.getKeyText(evt.getKeyCode()).equals("Arriba")) && Desplegar2.isVisible()) {

            bandera_tecla_abajo2 = true;
        }
    }//GEN-LAST:event_TxtEliminarProKeyPressed

    private void Desplegar2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Desplegar2KeyPressed
        if (KeyEvent.getKeyText(evt.getKeyCode()).equals("Intro")) {//Se hace la comparacion de que el item seleccionado no sea ni el primero o si este no se ha presionado, puesto que este evento tambien se acciona al agregar un nuevo item
            String Registro = (String) Desplegar2.getSelectedItem(); //Se obtiene el elemento (String) seleccionado  de la lista desplegable
            String RegistroSeleccionado[] = Registro.split("-"); //Se separa por los guiones 
            for (int i = 0; i < RegistroSeleccionado.length; i++) {
                RegistroSeleccionado[i] = RegistroSeleccionado[i].trim();

            }
            for (int i = 0; i < TablaEliminarPro.getRowCount(); i++) {//Se recorre toda la tabla para encontrar el articulo y asi seleccionarlo,
                //esto ayuda cuando se tiene mas elementos y no se pueden presentar todos dentro de los primeros elementos de la lista

                if (String.valueOf(TablaEliminarPro.getValueAt(i, 0)).equals(RegistroSeleccionado[0])) {//Se hace la comparacion del elemento con lo que hay en la lista
                    //Si si, se selecciona automaticamente la fila, indicando el articulo que se encuentra

                    TablaEliminarPro.setRowSelectionInterval(i, i);
                    //--Las siguientes lineas de codigo sirven para visualizar el renglon seleccionado anteriormente
                    int fila_a_desplegar = (i * 16) + 1; //se obtiene el valor de la coordenada en y del renglon seleccionado
                    Point punto = new Point(0, fila_a_desplegar);   //Se crea un objeto tipo Point que nos ayudara a visualizar el renglón
                    jScrollPane2.getViewport().setViewPosition(punto);//Se visualiza el renglon  del ScrollBar mediante el metodo setViewPort teniendo como parametro el objeto tipo Point

                    Desplegar2.setVisible(false);//Se oculta la lista desplegable
                    TxtEliminarPro.setText("");//Se borra el texto de busqueda 

                    break;
                }
            }
            TablaEliminarPro.requestFocus(false);
            BtnEliminarPro.requestFocus();

        }
    }//GEN-LAST:event_Desplegar2KeyPressed

    private void TxtBuscarProveedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtBuscarProveedorKeyPressed
        if ((KeyEvent.getKeyText(evt.getKeyCode()).equals("Abajo") || KeyEvent.getKeyText(evt.getKeyCode()).equals("Arriba")) && Desplegar3.isVisible()) {
            bandera_tecla_abajo3 = true;
        }
    }//GEN-LAST:event_TxtBuscarProveedorKeyPressed

    private void Desplegar3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Desplegar3KeyPressed
        if (KeyEvent.getKeyText(evt.getKeyCode()).equals("Intro")) {//Se hace la comparacion de que el item seleccionado no sea ni el primero o si este no se ha presionado, puesto que este evento tambien se acciona al agregar un nuevo item
            String Registro = (String) Desplegar3.getSelectedItem(); //Se obtiene el elemento (String) seleccionado  de la lista desplegable
            String RegistroSeleccionado[] = Registro.split("-"); //Se separa por los guiones 
            for (int i = 0; i < RegistroSeleccionado.length; i++) {
                RegistroSeleccionado[i] = RegistroSeleccionado[i].trim();

            }
            for (int i = 0; i < TablaConsultarProveedor.getRowCount(); i++) {//Se recorre toda la tabla para encontrar el articulo y asi seleccionarlo,
                //esto ayuda cuando se tiene mas elementos y no se pueden presentar todos dentro de los primeros elementos de la lista

                if (String.valueOf(TablaConsultarProveedor.getValueAt(i, 0)).equals(RegistroSeleccionado[0])) {//Se hace la comparacion del elemento con lo que hay en la lista
                    //Si si, se selecciona automaticamente la fila, indicando el articulo que se encuentra

                    TablaConsultarProveedor.setRowSelectionInterval(i, i);
                    //--Las siguientes lineas de codigo sirven para visualizar el renglon seleccionado anteriormente
                    int fila_a_desplegar = (i * 16) + 1; //se obtiene el valor de la coordenada en y del renglon seleccionado
                    Point punto = new Point(0, fila_a_desplegar);   //Se crea un objeto tipo Point que nos ayudara a visualizar el renglón
                    jScrollPane3.getViewport().setViewPosition(punto);//Se visualiza el renglon  del ScrollBar mediante el metodo setViewPort teniendo como parametro el objeto tipo Point

                    Desplegar3.setVisible(false);//Se oculta la lista desplegable
                    TxtBuscarProveedor.setText("");//Se borra el texto de busqueda 

                    break;
                }
            }
            TablaConsultarProveedor.requestFocus(false);


        }
    }//GEN-LAST:event_Desplegar3KeyPressed

    private void nomproFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nomproFocusLost
        String contenido_campo[] = nompro.getText().split(" ");
        String Aux_Contenido_Campo = "";
        for (int i = 0; i < contenido_campo.length; i++) {
            if (i == contenido_campo.length - 1) {
                if (!contenido_campo[i].equals("")) {
                    Aux_Contenido_Campo = Aux_Contenido_Campo + contenido_campo[i];
                }
            } else {
                if (!contenido_campo[i].equals("")) {
                    Aux_Contenido_Campo = Aux_Contenido_Campo + contenido_campo[i] + " ";
                }
            }
        }
        nompro.setText(Aux_Contenido_Campo);
    }//GEN-LAST:event_nomproFocusLost

    private void idproActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idproActionPerformed
        nompro.requestFocus();
    }//GEN-LAST:event_idproActionPerformed

    private void nomproActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomproActionPerformed
        webpro.requestFocus();
    }//GEN-LAST:event_nomproActionPerformed

    private void emailproActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailproActionPerformed
        telppro.requestFocus();
    }//GEN-LAST:event_emailproActionPerformed

    private void telpproActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telpproActionPerformed
        telcpro.requestFocus();
    }//GEN-LAST:event_telpproActionPerformed

    private void telcproActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telcproActionPerformed
        ciudadpro.requestFocus();
        ciudadpro.showPopup();
    }//GEN-LAST:event_telcproActionPerformed

    private void ciudadproKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ciudadproKeyPressed
        if (KeyEvent.getKeyText(evt.getKeyCode()).equals("Intro")) {
            colpro.requestFocus();
            colpro.showPopup();
        }
    }//GEN-LAST:event_ciudadproKeyPressed

    private void colproKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_colproKeyPressed
        if (KeyEvent.getKeyText(evt.getKeyCode()).equals("Intro")) {
            cppro.requestFocus();
            cppro.showPopup();
        }
    }//GEN-LAST:event_colproKeyPressed

    private void cpproKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cpproKeyPressed
        if (KeyEvent.getKeyText(evt.getKeyCode()).equals("Intro")) {
            callepro.requestFocus();
        }
    }//GEN-LAST:event_cpproKeyPressed

    private void calleproActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calleproActionPerformed
        numepro.requestFocus();
    }//GEN-LAST:event_calleproActionPerformed

    private void numeproActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numeproActionPerformed
        numipro.requestFocus();
    }//GEN-LAST:event_numeproActionPerformed

    private void numiproActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numiproActionPerformed
        btnañadir.requestFocus();
    }//GEN-LAST:event_numiproActionPerformed

    private void btnañadirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnañadirKeyPressed

        ///
        if (KeyEvent.getKeyText(evt.getKeyCode()).equals("Intro")) {
            if (!idpro.getText().equals("") && !nompro.getText().equals("") && !ciudadpro.getSelectedItem().equals("") && !colpro.getSelectedItem().equals("") && !cppro.getSelectedItem().equals("") && !callepro.getText().equals("") && !numepro.getText().equals("") && !numipro.getText().equals("") && !telppro.getText().equals("") && !telcpro.getText().equals("") && !emailpro.getText().equals("") && !webpro.getText().equals("")) {
               
                tnewpro.setValueAt(idpro.getText(), tabla_proveedores, 0);
                tnewpro.setValueAt(nompro.getText(), tabla_proveedores, 1);
                tnewpro.setValueAt(ciudadpro.getSelectedItem(), tabla_proveedores, 2);
                tnewpro.setValueAt(colpro.getSelectedItem(), tabla_proveedores, 3);
                tnewpro.setValueAt(cppro.getSelectedItem(), tabla_proveedores, 4);
                tnewpro.setValueAt(callepro.getText(), tabla_proveedores, 5);
                tnewpro.setValueAt(numepro.getText(), tabla_proveedores, 6);
                tnewpro.setValueAt(numipro.getText(), tabla_proveedores, 7);
                tnewpro.setValueAt(telppro.getText(), tabla_proveedores, 8);
                tnewpro.setValueAt(telcpro.getText(), tabla_proveedores, 9);
                tnewpro.setValueAt(emailpro.getText(), tabla_proveedores, 10);
                tnewpro.setValueAt(webpro.getText(), tabla_proveedores, 11);

                idpro.setText("");
                nompro.setText("");
                ciudadpro.setSelectedItem("");
                colpro.setSelectedItem("");
                callepro.setText("");
                cppro.setSelectedItem("");
                numepro.setText("");
                numipro.setText("");
                telppro.setText("");
                telcpro.setText("");
                emailpro.setText("");
                webpro.setText("");
                 btncanpro.setVisible(true);
            idpro.requestFocus();  btnguapro.setVisible(true);
                tabla_proveedores += 1;

            } else {
                JOptionPane.showMessageDialog(this, "Los campos no pueden estar vacios");


            }
        }
    }//GEN-LAST:event_btnañadirKeyPressed

    private void btnguaproKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnguaproKeyPressed
       if (KeyEvent.getKeyText(evt.getKeyCode()).equals("Intro")) {
        if (JOptionPane.showConfirmDialog(this, "¿Desea Almacenar Proveedor", "Mensaje", 1) == 0) {
            try {

                for (int i = 0; i < tabla_proveedores; i++) {
                    String encabezado_proveedores[] = {(String.valueOf(tnewpro.getValueAt(i, 0))), String.valueOf(tnewpro.getValueAt(i, 1)), String.valueOf(tnewpro.getValueAt(i, 8)), String.valueOf(tnewpro.getValueAt(i, 9)), String.valueOf(tnewpro.getValueAt(i, 5)), String.valueOf(tnewpro.getValueAt(i, 7)), String.valueOf(tnewpro.getValueAt(i, 6)), String.valueOf(tnewpro.getValueAt(i, 3)), String.valueOf(tnewpro.getValueAt(i, 2)), String.valueOf(tnewpro.getValueAt(i, 4)), String.valueOf(tnewpro.getValueAt(i, 10)), String.valueOf(tnewpro.getValueAt(i, 11))};
                    conexion.insertar(6, encabezado_proveedores);
                }

                JOptionPane.showMessageDialog(this, "El proveedor se ha almacenado");
                btncanpro.setVisible(false);
                btnguapro.setVisible(false);
                idpro.requestFocus();
                contador_primer_caracter=0;
                tabla_proveedores = 0;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error al conectar con SQL");
            }
        }
       
    }
    }//GEN-LAST:event_btnguaproKeyPressed

    private void idproKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idproKeyTyped
        if (KeyEvent.getKeyText(evt.getKeyCode()).equals("G")||KeyEvent.getKeyText(evt.getKeyCode()).equals("g")) {
            btnguapro.requestFocus();        
        }
    }//GEN-LAST:event_idproKeyTyped

    private void NombreModificarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NombreModificarKeyTyped
         char c = evt.getKeyChar();
        if (!Character.getName(c).equals("SPACE") && Character.isLetter(c) == false && !Character.getName(c).equals("FULL STOP")) {
            evt.consume();
        } else {
            if (NombreModificar.getText().length() > 49) {
                Toolkit.getDefaultToolkit().beep();
                evt.consume();
            }
        }
    }//GEN-LAST:event_NombreModificarKeyTyped

    private void NombreModificarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NombreModificarKeyReleased
          String aux = "";
        if (!NombreModificar.getText().equals("")) {
            String ContenidoNuevo[] = NombreModificar.getText().split(" ");
            if (KeyEvent.getKeyText(evt.getKeyCode()).equals("Espacio")) {

                for (int i = 0; i < ContenidoNuevo.length; i++) {
                    if (i == ContenidoNuevo.length) {
                        aux = aux + ContenidoNuevo[i];
                    } else {
                        aux = aux + ContenidoNuevo[i] + " ";
                    }

                }
                NombreModificar.setText(aux);

            } else {
                char correo1[] = NombreModificar.getText().toCharArray();
                String aux2 = "";
                if (NombreModificar.getText().length() >= 3) {
                    if (correo1[correo1.length - 1] == correo1[correo1.length - 2] && !Character.isLetter(correo1[correo1.length - 1]) && !Character.isLetter(correo1[correo1.length - 1])) {
                        for (int i = 0; i < correo1.length - 1; i++) {
                            aux = aux + correo1[i];
                        }
                        NombreModificar.setText(aux);
                    }
                }

            }

        }
    }//GEN-LAST:event_NombreModificarKeyReleased

    private void EmailModificarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EmailModificarKeyTyped
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
    }//GEN-LAST:event_EmailModificarKeyTyped

    private void EmailModificarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EmailModificarKeyReleased
            char correo1[] = EmailModificar.getText().toCharArray();
        String aux = "";
        if (!EmailModificar.getText().equals("")) {
            if (emailpro.getText().length() >= 3) {
                if (correo1[correo1.length - 1] == correo1[correo1.length - 2] && !Character.isLetter(correo1[correo1.length - 1]) && !Character.isLetter(correo1[correo1.length - 1])) {
                    for (int i = 0; i < correo1.length - 1; i++) {
                        aux = aux + correo1[i];
                    }
                    EmailModificar.setText(aux);
                }
            }
            if (!isEmail(EmailModificar.getText())) {
                iconomal1.setVisible(true);
            } else {
                contador_primer_caracter=0;
                iconomal1.setVisible(false);

            }
        } else {
            contador_primer_caracter = 0;
        }

    }//GEN-LAST:event_EmailModificarKeyReleased

    private void ParModificarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ParModificarKeyTyped
       char c = evt.getKeyChar();
        if ( !Character.isDigit(c)) {
            evt.consume();
        } else {
            if(ParModificar.getText().length()>11){
            evt.consume();
            }
        }
    }//GEN-LAST:event_ParModificarKeyTyped

    private void CelModificarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CelModificarKeyTyped
         char c = evt.getKeyChar();
        if ( !Character.isDigit(c)) {
            evt.consume();
        } else {
            if(CelModificar.getText().length()>11){
            evt.consume();
            }
        }
    }//GEN-LAST:event_CelModificarKeyTyped

    private void CalleModificarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CalleModificarKeyTyped
        char c = evt.getKeyChar();
        if (!Character.getName(c).equals("SPACE") && Character.isLetter(c) == false && !Character.getName(c).equals("FULL STOP")) {
            evt.consume();
        }
         else{
            if(CalleModificar.getText().length()>24){
                evt.consume();
            }
        }
    }//GEN-LAST:event_CalleModificarKeyTyped

    private void CalleModificarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CalleModificarKeyReleased
        char correo1[] = CalleModificar.getText().toCharArray();
        String aux = "";
        if (!CalleModificar.getText().equals("")) {
            if (CalleModificar.getText().length() >= 3) {
                if (correo1[correo1.length - 1] == correo1[correo1.length - 2] && !Character.isLetter(correo1[correo1.length - 1]) && !Character.isLetter(correo1[correo1.length - 1])) {
                    for (int i = 0; i < correo1.length - 1; i++) {
                        aux = aux + correo1[i];
                    }
                    CalleModificar.setText(aux);
                }
            }

        } else {
            contador_primer_caracter = 0;
        }
    }//GEN-LAST:event_CalleModificarKeyReleased

    private void ExtModificarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ExtModificarKeyTyped
         char c = evt.getKeyChar();
        if (Character.isDigit(c) == false) {
            evt.consume();
        } else {
            if (ExtModificar.getText().length() > 6) {
                Toolkit.getDefaultToolkit().beep();
                evt.consume();
            }
        }
    }//GEN-LAST:event_ExtModificarKeyTyped

    private void IntModificarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_IntModificarKeyTyped
         char c = evt.getKeyChar();
        if (Character.isDigit(c) == false) {
            evt.consume();
        } else {
            if (IntModificar.getText().length() > 6) {
                Toolkit.getDefaultToolkit().beep();
                evt.consume();
            }
        }
    }//GEN-LAST:event_IntModificarKeyTyped

    private void NombreModificarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_NombreModificarFocusLost
               String contenido_campo[] = NombreModificar.getText().split(" ");
        String Aux_Contenido_Campo = "";
        for (int i = 0; i < contenido_campo.length; i++) {
            if (i == contenido_campo.length - 1) {
                if (!contenido_campo[i].equals("")) {
                    Aux_Contenido_Campo = Aux_Contenido_Campo + contenido_campo[i];
                }
            } else {
                if (!contenido_campo[i].equals("")) {
                    Aux_Contenido_Campo = Aux_Contenido_Campo + contenido_campo[i] + " ";
                }
            }
        }
        NombreModificar.setText(Aux_Contenido_Campo);
    }//GEN-LAST:event_NombreModificarFocusLost

    private void CalleModificarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CalleModificarFocusLost
              String contenido_campo[] = CalleModificar.getText().split(" ");
        String Aux_Contenido_Campo = "";
        for (int i = 0; i < contenido_campo.length; i++) {
            if (i == contenido_campo.length - 1) {
                if (!contenido_campo[i].equals("")) {
                    Aux_Contenido_Campo = Aux_Contenido_Campo + contenido_campo[i];
                }
            } else {
                if (!contenido_campo[i].equals("")) {
                    Aux_Contenido_Campo = Aux_Contenido_Campo + contenido_campo[i] + " ";
                }
            }
        }
        CalleModificar.setText(Aux_Contenido_Campo);
    }//GEN-LAST:event_CalleModificarFocusLost

    private void calleproFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_calleproFocusLost
             String contenido_campo[] = callepro.getText().split(" ");
        String Aux_Contenido_Campo = "";
        for (int i = 0; i < contenido_campo.length; i++) {
            if (i == contenido_campo.length - 1) {
                if (!contenido_campo[i].equals("")) {
                    Aux_Contenido_Campo = Aux_Contenido_Campo + contenido_campo[i];
                }
            } else {
                if (!contenido_campo[i].equals("")) {
                    Aux_Contenido_Campo = Aux_Contenido_Campo + contenido_campo[i] + " ";
                }
            }
        }
        callepro.setText(Aux_Contenido_Campo);
    }//GEN-LAST:event_calleproFocusLost

    private void NombreModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NombreModificarActionPerformed
       EmailModificar.requestFocus();
    }//GEN-LAST:event_NombreModificarActionPerformed

    private void EmailModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailModificarActionPerformed
        WebModificar.requestFocus();
    }//GEN-LAST:event_EmailModificarActionPerformed

    private void WebModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WebModificarActionPerformed
       ParModificar.requestFocus();
    }//GEN-LAST:event_WebModificarActionPerformed

    private void ParModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ParModificarActionPerformed
      CelModificar.requestFocus();
    }//GEN-LAST:event_ParModificarActionPerformed

    private void CelModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CelModificarActionPerformed
       CiudadModificar.requestFocus();
       CiudadModificar.showPopup();
    }//GEN-LAST:event_CelModificarActionPerformed

    private void CiudadModificarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CiudadModificarKeyPressed
      if (KeyEvent.getKeyText(evt.getKeyCode()).equals("Intro")) {
            ColoniaModificar.requestFocus();
            ColoniaModificar.showPopup();
        }
    }//GEN-LAST:event_CiudadModificarKeyPressed

    private void ColoniaModificarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ColoniaModificarKeyPressed
        if (KeyEvent.getKeyText(evt.getKeyCode()).equals("Intro")) {
            CpModificar.requestFocus();
            CpModificar.showPopup();
        }
    }//GEN-LAST:event_ColoniaModificarKeyPressed

    private void CpModificarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CpModificarKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_CpModificarKeyTyped

    private void CpModificarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CpModificarKeyPressed
        if (KeyEvent.getKeyText(evt.getKeyCode()).equals("Intro")) {
            CalleModificar.requestFocus();
          
        }
    }//GEN-LAST:event_CpModificarKeyPressed

    private void CalleModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalleModificarActionPerformed
        ExtModificar.requestFocus();
    }//GEN-LAST:event_CalleModificarActionPerformed

    private void ExtModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExtModificarActionPerformed
    IntModificar.requestFocus();
    }//GEN-LAST:event_ExtModificarActionPerformed

    private void IntModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IntModificarActionPerformed
       BtnGuardar.requestFocus();
    }//GEN-LAST:event_IntModificarActionPerformed

    private void llenarTabla(int tabla) {
        ContadorLlenadoTabla += 1;//contador de las veces que es utilizado este metodo
        try {

            ResultadoTabla = conexion.consultar(6);//Se invoca al metodo consultar generico para obtener todos los articulos de la tabla

            switch (tabla) {//Se hace la comparacion de la tabla a llenar
                case 1:
                    while (ResultadoTabla.next()) {//Se itera con el Objeto tipo ResulSet
                        //Se guarda en un arreglo los elementos del registro en la tabla para despues ser agregados como una fila
                        Filas[0] = ResultadoTabla.getString(1);//ID
                        Filas[1] = ResultadoTabla.getString(2);//Nombre
                        Filas[2] = ResultadoTabla.getString(9);//Ciudad
                        Filas[3] = ResultadoTabla.getString(8);//Colonia
                        Filas[4] = ResultadoTabla.getString(10);//CP
                        Filas[5] = ResultadoTabla.getString(5);//Calle
                        Filas[6] = ResultadoTabla.getString(7);//NumE
                        Filas[7] = ResultadoTabla.getString(6);//NumI
                        Filas[8] = ResultadoTabla.getString(3);//TelP
                        Filas[9] = ResultadoTabla.getString(4); //TelC
                        Filas[10] = ResultadoTabla.getString(11);//Email
                        Filas[11] = ResultadoTabla.getString(12);//Web
                        //Se agrega la fila a la tabla, mandandole como parametro el arreglo asignado anteriormente
                        ModeloTabla1.addRow(Filas);

                    }


                    break;
                case 2:
                    while (ResultadoTabla.next()) {//Se itera con el Objeto tipo ResulSet
                        //Se guarda en un arreglo los elementos del registro en la tabla para despues ser agregados como una fila
                        Filas[0] = ResultadoTabla.getString(1);//ID
                        Filas[1] = ResultadoTabla.getString(2);//Nombre
                        Filas[2] = ResultadoTabla.getString(9);//Ciudad
                        Filas[3] = ResultadoTabla.getString(8);//Colonia
                        Filas[4] = ResultadoTabla.getString(10);//CP
                        Filas[5] = ResultadoTabla.getString(5);//Calle
                        Filas[6] = ResultadoTabla.getString(7);//NumE
                        Filas[7] = ResultadoTabla.getString(6);//NumI
                        Filas[8] = ResultadoTabla.getString(3);//TelP
                        Filas[9] = ResultadoTabla.getString(4); //TelC
                        Filas[10] = ResultadoTabla.getString(11);//Email
                        Filas[11] = ResultadoTabla.getString(12);//Web
                        //Se agrega la fila a la tabla, mandandole como parametro el arreglo asignado anteriormente
                        ModeloTabla2.addRow(Filas);

                    }


                    break;
                case 3:
                    while (ResultadoTabla.next()) {//Se itera con el Objeto tipo ResulSet
                        //Se guarda en un arreglo los elementos del registro en la tabla para despues ser agregados como una fila
                        Filas[0] = ResultadoTabla.getString(1);//ID
                        Filas[1] = ResultadoTabla.getString(2);//Nombre
                        Filas[2] = ResultadoTabla.getString(9);//Ciudad
                        Filas[3] = ResultadoTabla.getString(8);//Colonia
                        Filas[4] = ResultadoTabla.getString(10);//CP
                        Filas[5] = ResultadoTabla.getString(5);//Calle
                        Filas[6] = ResultadoTabla.getString(7);//NumE
                        Filas[7] = ResultadoTabla.getString(6);//NumI
                        Filas[8] = ResultadoTabla.getString(3);//TelP
                        Filas[9] = ResultadoTabla.getString(4); //TelC
                        Filas[10] = ResultadoTabla.getString(11);//Email
                        Filas[11] = ResultadoTabla.getString(12);//Web
                        //Se agrega la fila a la tabla, mandandole como parametro el arreglo asignado anteriormente
                        ModeloTabla3.addRow(Filas);

                    }

                    break;
                default:
                    throw new AssertionError();
            }



        } catch (SQLException ex) {
            Logger.getLogger(Proveedores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//Este metodo se utiliza para borrar todos los elementos de la tabla(filas)
    //recibe como parametro un numero que hace alucion a que tabla es la que se kiere vaciar

    private void vaciarTabla(int tabla) {
        switch (tabla) {
            case 1:
                for (int i = tablamod.getRowCount() - 1; i >= 0; i--) {//Se itera desde el ultimo elemento hasta el primero
                    //Se puede hacer al reves pero asi lo kise hcer XD
                    //Se elimina la fila
                    ModeloTabla1.removeRow(i);

                }
                break;
            case 2:
                for (int i = TablaEliminarPro.getRowCount() - 1; i >= 0; i--) {//Se itera desde el ultimo elemento hasta el primero
                    //Se puede hacer al reves pero asi lo kise hcer XD
                    //Se elimina la fila    
                    ModeloTabla2.removeRow(i);

                }
                break;

            case 3:
                for (int i = TablaConsultarProveedor.getRowCount() - 1; i >= 0; i--) {//Se itera desde el ultimo elemento hasta el primero
                    //Se puede hacer al reves pero asi lo kise hcer XD
                    //Se elimina la fila    
                    ModeloTabla3.removeRow(i);

                }

                break;
            default:
                throw new AssertionError();
        }

    }

    private void PanelModificar(int filatabla) {

        PanelModificarProveedor.setVisible(true);
        MensajeMod.setText("Ingresa los nuevos datos del Proveedor");
        NombreModificar.requestFocus();
        MensajeMod.setVisible(true);


        NombreModificar.setText(String.valueOf(tablamod.getValueAt(filatabla, 1)));
        ParModificar.setText(String.valueOf(tablamod.getValueAt(filatabla, 8)));
        CelModificar.setText(String.valueOf(tablamod.getValueAt(filatabla, 9)));
        CalleModificar.setText(String.valueOf(tablamod.getValueAt(filatabla, 5)));
        IntModificar.setText(String.valueOf(tablamod.getValueAt(filatabla, 7)));
        ExtModificar.setText(String.valueOf(tablamod.getValueAt(filatabla, 6)));
        ColoniaModificar.setSelectedItem(String.valueOf(tablamod.getValueAt(filatabla, 3)));
        CiudadModificar.setSelectedItem(String.valueOf(tablamod.getValueAt(filatabla, 2)));
        CpModificar.setSelectedItem(String.valueOf(tablamod.getValueAt(filatabla, 4)));
        EmailModificar.setText(String.valueOf(tablamod.getValueAt(filatabla, 10)));
        WebModificar.setText(String.valueOf(tablamod.getValueAt(filatabla, 11)));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCancelar;
    private javax.swing.JButton BtnEliminarPro;
    private javax.swing.JButton BtnGuardar;
    private javax.swing.JButton BtnModificar;
    private javax.swing.JTextField CalleModificar;
    private javax.swing.JTextField CelModificar;
    private javax.swing.JComboBox CiudadModificar;
    private javax.swing.JComboBox ColoniaModificar;
    private javax.swing.JComboBox CpModificar;
    private javax.swing.JComboBox Desplegar1;
    private javax.swing.JComboBox Desplegar2;
    private javax.swing.JComboBox Desplegar3;
    private javax.swing.JTextField EmailModificar;
    private javax.swing.JTextField ExtModificar;
    private javax.swing.JTextField IntModificar;
    private javax.swing.JLabel MensajeMod;
    private javax.swing.JTextField NombreModificar;
    private javax.swing.JPanel PanelEliminar;
    private javax.swing.JPanel PanelModificarPro;
    private javax.swing.JPanel PanelModificarProveedor;
    private javax.swing.JTextField ParModificar;
    private javax.swing.JTable TablaConsultarProveedor;
    private javax.swing.JTable TablaEliminarPro;
    private javax.swing.JTextField TxtBuscarProveedor;
    private javax.swing.JTextField TxtEliminarPro;
    private javax.swing.JTextField WebModificar;
    private javax.swing.JButton botonCerrar;
    private javax.swing.JButton btnañadir;
    private javax.swing.JButton btncanpro;
    private javax.swing.JButton btnguapro;
    private javax.swing.JTextField callepro;
    private javax.swing.JComboBox ciudadpro;
    private javax.swing.JComboBox colpro;
    private javax.swing.JComboBox cppro;
    private javax.swing.JTextField emailpro;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel iconoerror;
    private javax.swing.JLabel iconoerror2;
    private javax.swing.JLabel iconomal1;
    private javax.swing.JFormattedTextField idpro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField modipro;
    private javax.swing.JTextField nompro;
    private javax.swing.JTextField numepro;
    private javax.swing.JTextField numipro;
    private javax.swing.JPanel panelBuscar;
    private javax.swing.JTable tablamod;
    private javax.swing.JFormattedTextField telcpro;
    private javax.swing.JFormattedTextField telppro;
    private javax.swing.JTable tnewpro;
    private javax.swing.JTextField webpro;
    // End of variables declaration//GEN-END:variables
}
