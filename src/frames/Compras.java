package frames;

//import java.sql.ResultSet;
import conexiones.Conexion;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import utilidades.Fecha;
import utilidades.IconCellRenderer;

public class Compras extends javax.swing.JDialog {

    int articulo_tabla1, contador_max_caracteres;
    Conexion conexion, conexion2, conexion3, conexion_elimina_compra, conexion_eliminar, conexion_eliminar_registro, conexion_consulta_articulo_borrar;
    ResultSet resultado, ResultadoTabla, ResultadoTabla2, ResultadoTabla3, Resultado_Encabezado_Eliminar, Resultado_Encabezado_Consultar;
    int Seleccion_Lista_Tipo;
    private DefaultTableModel ModeloTabla1, ModeloTabla2, ModeloTabla3, ModeloTabla4;
    private Object fila_cuentas_pagar[], fila_compras[];
    private int ContadorLlenadoTabla;
    private boolean Seleccion_Teclas;
    DefaultTableCellRenderer Renderizado_Celdas_Tabla_Centro, Renderizado_Celdas_Tabla_Derecha;
    private int aparicion = 0;
    private String nombre_proveedor;

    public Compras(java.awt.Frame parent, boolean modal) throws SQLException {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(getClass().getResource("/imagenes/icono-proyecto.png")).getImage());
        lblFecha.setText(Fecha.getDia() + "-" + Fecha.getMes() + "-" + Fecha.getAño());
        articulo_tabla1 = 0;
        txtFecha.setText(Fecha.getDia() + "/" + Fecha.getMes() + "/" + Fecha.getAño());
        CampoClave.requestFocus();
        Folio.setEditable(false);
        Autocompletar1.setVisible(false);
        Seleccion_Lista_Tipo = 0;
        opContado.setSelected(true);
        FolioEliminar.setEditable(false);
        ProveedorEliminar.setEditable(false);
        FechaEliminar.setEditable(false);
        TotalEliminar.setEditable(false);
        nombre_proveedor = "";
        conexion = new Conexion();
        conexion.conectarMySQL();
        conexion2 = new Conexion();
        conexion2.conectarMySQL();
        conexion3 = new Conexion();
        conexion3.conectarMySQL();
        conexion_elimina_compra = new Conexion();
        conexion_elimina_compra.conectarMySQL();
        conexion_eliminar = new Conexion();//conexion para Eliminar en el panel de eliminacion de compras
        conexion_eliminar.conectarMySQL();
        conexion_consulta_articulo_borrar = new Conexion();
        conexion_consulta_articulo_borrar.conectarMySQL();
        conexion_eliminar_registro = new Conexion();
        conexion_eliminar_registro.conectarMySQL();
        contador_max_caracteres = 0;
        fila_cuentas_pagar = new Object[4];
        fila_compras = new Object[6];
        ContadorLlenadoTabla = 0;
        Seleccion_Teclas = false;

        TablaCuentasPorPagar.setDefaultRenderer(Object.class, new IconCellRenderer());

        TablaEliminarCompras.setDefaultRenderer(Object.class, new IconCellRenderer());
        TablaEliminarCompras.setDefaultRenderer(Object.class, new IconCellRenderer());
        ModeloTabla1 = (DefaultTableModel) TablaCuentasPorPagar.getModel();

        ModeloTabla3 = (DefaultTableModel) TablaEliminarCompras.getModel();
        ModeloTabla4 = (DefaultTableModel) TablaConsultarCompras.getModel();
        Renderizado_Celdas_Tabla_Centro = new DefaultTableCellRenderer();
        Renderizado_Celdas_Tabla_Derecha = new DefaultTableCellRenderer();
        Renderizado_Celdas_Tabla_Centro.setHorizontalAlignment(SwingConstants.CENTER);
        Renderizado_Celdas_Tabla_Derecha.setHorizontalAlignment(SwingConstants.RIGHT);
        TablaNuevaCompra.getColumnModel().getColumn(0).setCellRenderer(Renderizado_Celdas_Tabla_Centro);
        TablaNuevaCompra.getColumnModel().getColumn(1).setCellRenderer(Renderizado_Celdas_Tabla_Centro);
        TablaNuevaCompra.getColumnModel().getColumn(4).setCellRenderer(Renderizado_Celdas_Tabla_Derecha);
        TablaNuevaCompra.getColumnModel().getColumn(5).setCellRenderer(Renderizado_Celdas_Tabla_Derecha);
        TablaEliminarCompras.getColumnModel().getColumn(3).setCellRenderer(Renderizado_Celdas_Tabla_Derecha);
        TablaEliminarCompras.getColumnModel().getColumn(4).setCellRenderer(Renderizado_Celdas_Tabla_Derecha);
        TablaEliminarCompras.getColumnModel().getColumn(0).setCellRenderer(Renderizado_Celdas_Tabla_Centro);
        TablaEliminarCompras.getColumnModel().getColumn(2).setCellRenderer(Renderizado_Celdas_Tabla_Centro);
        TablaCuentasPorPagar.getColumnModel().getColumn(0).setCellRenderer(Renderizado_Celdas_Tabla_Centro);
        TablaCuentasPorPagar.getColumnModel().getColumn(1).setCellRenderer(Renderizado_Celdas_Tabla_Centro);
        TablaCuentasPorPagar.getColumnModel().getColumn(3).setCellRenderer(Renderizado_Celdas_Tabla_Derecha);
        TablaConsultarCompras.getColumnModel().getColumn(3).setCellRenderer(Renderizado_Celdas_Tabla_Derecha);
        TablaConsultarCompras.getColumnModel().getColumn(4).setCellRenderer(Renderizado_Celdas_Tabla_Derecha);
        TablaConsultarCompras.getColumnModel().getColumn(0).setCellRenderer(Renderizado_Celdas_Tabla_Centro);
        TablaConsultarCompras.getColumnModel().getColumn(2).setCellRenderer(Renderizado_Celdas_Tabla_Centro);

        //-----------------------------------------------------------------------------

        Resultado_Encabezado_Consultar = conexion2.consultar(2);
        if (Resultado_Encabezado_Consultar.first() == false) {
            btnAnterior.setEnabled(false);
            btnSiguiente.setEnabled(false);
        }

        Resultado_Encabezado_Eliminar = conexion_eliminar.consultar(2);
        if (Resultado_Encabezado_Eliminar.first() == false) {
            btnAnterior1.setEnabled(false);
            btnSiguiente1.setEnabled(false);
        }

        //Se invoca al metodo de llenar tabla con su respectivo numero de tabla, para rellenar los datos pertinentes
        llenarTabla(1);
        llenarTabla(2);
        llenarTabla(3);
//        llenarTabla(4);

        estableceListaTipos();
        estableceFolio();
        rellenaProveedores();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        botonCerrar = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        PanelNuevaCompra = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaNuevaCompra = new javax.swing.JTable();
        botonGuardar1 = new javax.swing.JButton();
        botonCancelar1 = new javax.swing.JButton();
        txtFecha = new javax.swing.JTextField();
        lblFolioC = new javax.swing.JLabel();
        FechaCompra = new javax.swing.JLabel();
        Total = new javax.swing.JTextField();
        lblTotal = new javax.swing.JLabel();
        CampoClave = new javax.swing.JTextField();
        CampoCantidad = new javax.swing.JTextField();
        CampoNombre = new javax.swing.JTextField();
        CampoCosto = new javax.swing.JFormattedTextField();
        lblClave = new javax.swing.JLabel();
        lblCantidad = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblTipo = new javax.swing.JLabel();
        lblCosto = new javax.swing.JLabel();
        botonAñadir = new javax.swing.JButton();
        lblIDProveedor = new javax.swing.JLabel();
        ListaTipo = new javax.swing.JComboBox();
        Folio = new javax.swing.JTextField();
        opContado = new javax.swing.JRadioButton();
        opCredito = new javax.swing.JRadioButton();
        Autocompletar1 = new javax.swing.JComboBox();
        IDProveedor = new javax.swing.JTextField();
        PanelEliminarCompra = new javax.swing.JPanel();
        btnEliminarCompra = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        TablaEliminarCompras = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        FolioEliminar = new javax.swing.JTextField();
        ProveedorEliminar = new javax.swing.JTextField();
        FechaEliminar = new javax.swing.JTextField();
        TotalEliminar = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnPrimero1 = new javax.swing.JButton();
        btnAnterior1 = new javax.swing.JButton();
        btnSiguiente1 = new javax.swing.JButton();
        btnUltimo1 = new javax.swing.JButton();
        PanelConsultarCompra = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        TablaConsultarCompras = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        FolioConsultar = new javax.swing.JTextField();
        ProveedorConsultar = new javax.swing.JTextField();
        FechaConsultar = new javax.swing.JTextField();
        TotalConsultar = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnPrimero = new javax.swing.JButton();
        btnAnterior = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();
        btnUltimo = new javax.swing.JButton();
        PanelCuentasPorPagar = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaCuentasPorPagar = new javax.swing.JTable();
        btnGuardarAbono = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtAbono = new javax.swing.JFormattedTextField();
        lblTitulo = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(" Compras a Proveedores");
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
        botonCerrar.setBounds(5, 5, 30, 30);
        jLayeredPane1.add(botonCerrar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        PanelNuevaCompra.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        TablaNuevaCompra.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        TablaNuevaCompra.setModel(new javax.swing.table.DefaultTableModel(
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
                "Clave", "Cantidad", "Nombre", "Tipo", "Costo", "SubTotal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaNuevaCompra.setToolTipText("Tabla de Articulos a Comprar");
        TablaNuevaCompra.setRowHeight(17);
        jScrollPane1.setViewportView(TablaNuevaCompra);
        TablaNuevaCompra.getColumnModel().getColumn(0).setMinWidth(85);
        TablaNuevaCompra.getColumnModel().getColumn(0).setPreferredWidth(85);
        TablaNuevaCompra.getColumnModel().getColumn(0).setMaxWidth(85);
        TablaNuevaCompra.getColumnModel().getColumn(1).setMinWidth(60);
        TablaNuevaCompra.getColumnModel().getColumn(1).setPreferredWidth(60);
        TablaNuevaCompra.getColumnModel().getColumn(1).setMaxWidth(60);
        TablaNuevaCompra.getColumnModel().getColumn(4).setMinWidth(80);
        TablaNuevaCompra.getColumnModel().getColumn(4).setPreferredWidth(80);
        TablaNuevaCompra.getColumnModel().getColumn(4).setMaxWidth(80);
        TablaNuevaCompra.getColumnModel().getColumn(5).setMinWidth(90);
        TablaNuevaCompra.getColumnModel().getColumn(5).setPreferredWidth(90);
        TablaNuevaCompra.getColumnModel().getColumn(5).setMaxWidth(90);

        botonGuardar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar.png"))); // NOI18N
        botonGuardar1.setText("Guardar");
        botonGuardar1.setToolTipText("Presiona para Guardar los datos de la Compra");
        botonGuardar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonGuardar1.setMaximumSize(new java.awt.Dimension(125, 45));
        botonGuardar1.setMinimumSize(new java.awt.Dimension(125, 45));
        botonGuardar1.setPreferredSize(new java.awt.Dimension(125, 45));
        botonGuardar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardar1ActionPerformed(evt);
            }
        });

        botonCancelar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancelar.png"))); // NOI18N
        botonCancelar1.setText("Cancelar");
        botonCancelar1.setToolTipText("Presiona para cancelar la compra");
        botonCancelar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonCancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelar1ActionPerformed(evt);
            }
        });

        txtFecha.setEditable(false);
        txtFecha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFecha.setToolTipText("Fecha de la Compra");
        txtFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaActionPerformed(evt);
            }
        });

        lblFolioC.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        lblFolioC.setText("Folio");

        FechaCompra.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        FechaCompra.setText("Fecha");

        Total.setEditable(false);
        Total.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        Total.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        Total.setToolTipText("Total de la Compra");

        lblTotal.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblTotal.setText("Total:");

        CampoClave.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        CampoClave.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        CampoClave.setToolTipText("Clave del Producto");
        CampoClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoClaveActionPerformed(evt);
            }
        });
        CampoClave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CampoClaveKeyTyped(evt);
            }
        });

        CampoCantidad.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        CampoCantidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        CampoCantidad.setToolTipText("Cantidad del Artículo a comprar");
        CampoCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoCantidadActionPerformed(evt);
            }
        });
        CampoCantidad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                CampoCantidadFocusGained(evt);
            }
        });
        CampoCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CampoCantidadKeyTyped(evt);
            }
        });

        CampoNombre.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        CampoNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        CampoNombre.setToolTipText("Nombre del Artículo a comprar");
        CampoNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoNombreActionPerformed(evt);
            }
        });
        CampoNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CampoNombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CampoNombreKeyTyped(evt);
            }
        });

        CampoCosto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("##0.00"))));
        CampoCosto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        CampoCosto.setToolTipText("Costo Unitario del Producto");
        CampoCosto.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        CampoCosto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoCostoActionPerformed(evt);
            }
        });
        CampoCosto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CampoCostoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CampoCostoKeyTyped(evt);
            }
        });

        lblClave.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        lblClave.setText("Clave");

        lblCantidad.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        lblCantidad.setText("Cantidad");

        lblNombre.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        lblNombre.setText("Nombre");

        lblTipo.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        lblTipo.setText("Tipo");

        lblCosto.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        lblCosto.setText("Costo");

        botonAñadir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mas.png"))); // NOI18N
        botonAñadir.setToolTipText("Añadir Producto a la Lista");
        botonAñadir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonAñadir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonAñadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAñadirActionPerformed(evt);
            }
        });
        botonAñadir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                botonAñadirKeyPressed(evt);
            }
        });

        lblIDProveedor.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        lblIDProveedor.setText("Clave Proveedor");

        ListaTipo.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        ListaTipo.setToolTipText("Tipo de Artículo");
        ListaTipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ListaTipoItemStateChanged(evt);
            }
        });
        ListaTipo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ListaTipoFocusGained(evt);
            }
        });
        ListaTipo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ListaTipoKeyPressed(evt);
            }
        });

        Folio.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        Folio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Folio.setToolTipText("Numero de Folio de la Compra");

        buttonGroup1.add(opContado);
        opContado.setText("Contado");
        opContado.setToolTipText("La Compra será a Contado");

        buttonGroup1.add(opCredito);
        opCredito.setText("Crédito");
        opCredito.setToolTipText("La Compra será a Crédito");

        Autocompletar1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                Autocompletar1ItemStateChanged(evt);
            }
        });

        IDProveedor.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        IDProveedor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        IDProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                IDProveedorMouseClicked(evt);
            }
        });
        IDProveedor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                IDProveedorFocusGained(evt);
            }
        });

        javax.swing.GroupLayout PanelNuevaCompraLayout = new javax.swing.GroupLayout(PanelNuevaCompra);
        PanelNuevaCompra.setLayout(PanelNuevaCompraLayout);
        PanelNuevaCompraLayout.setHorizontalGroup(
            PanelNuevaCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelNuevaCompraLayout.createSequentialGroup()
                .addGroup(PanelNuevaCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 643, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelNuevaCompraLayout.createSequentialGroup()
                        .addGap(0, 381, Short.MAX_VALUE)
                        .addGroup(PanelNuevaCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelNuevaCompraLayout.createSequentialGroup()
                                .addComponent(botonCancelar1)
                                .addGap(18, 18, 18)
                                .addComponent(botonGuardar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelNuevaCompraLayout.createSequentialGroup()
                                .addComponent(lblTotal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Total, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13))))
                    .addGroup(PanelNuevaCompraLayout.createSequentialGroup()
                        .addGroup(PanelNuevaCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CampoClave, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblClave))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelNuevaCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCantidad)
                            .addComponent(CampoCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelNuevaCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CampoNombre)
                            .addGroup(PanelNuevaCompraLayout.createSequentialGroup()
                                .addComponent(lblNombre)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelNuevaCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ListaTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTipo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelNuevaCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCosto)
                            .addComponent(CampoCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonAñadir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelNuevaCompraLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(PanelNuevaCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelNuevaCompraLayout.createSequentialGroup()
                                .addGroup(PanelNuevaCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PanelNuevaCompraLayout.createSequentialGroup()
                                        .addComponent(lblFolioC)
                                        .addGap(59, 59, 59)
                                        .addComponent(lblIDProveedor))
                                    .addGroup(PanelNuevaCompraLayout.createSequentialGroup()
                                        .addComponent(Folio, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(IDProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(138, 138, 138)
                                .addComponent(opContado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(opCredito, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(PanelNuevaCompraLayout.createSequentialGroup()
                                .addComponent(Autocompletar1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(176, 176, 176)))
                        .addGroup(PanelNuevaCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtFecha)
                            .addComponent(FechaCompra, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))))
                .addContainerGap())
        );
        PanelNuevaCompraLayout.setVerticalGroup(
            PanelNuevaCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelNuevaCompraLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelNuevaCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelNuevaCompraLayout.createSequentialGroup()
                        .addComponent(FechaCompra)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelNuevaCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFecha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PanelNuevaCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(opContado)
                                .addComponent(opCredito))))
                    .addGroup(PanelNuevaCompraLayout.createSequentialGroup()
                        .addGroup(PanelNuevaCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFolioC)
                            .addComponent(lblIDProveedor))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelNuevaCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Folio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IDProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Autocompletar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(9, 9, 9)
                .addGroup(PanelNuevaCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonAñadir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelNuevaCompraLayout.createSequentialGroup()
                        .addGroup(PanelNuevaCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblClave)
                            .addComponent(lblCantidad)
                            .addComponent(lblNombre)
                            .addComponent(lblTipo)
                            .addComponent(lblCosto))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelNuevaCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CampoClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CampoCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CampoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ListaTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CampoCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelNuevaCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Total, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(lblTotal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelNuevaCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonGuardar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonCancelar1)))
        );

        jTabbedPane1.addTab("  Nueva  ", new javax.swing.ImageIcon(getClass().getResource("/imagenes/nuevo.png")), PanelNuevaCompra); // NOI18N

        PanelEliminarCompra.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PanelEliminarCompra.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                PanelEliminarCompraComponentShown(evt);
            }
        });

        btnEliminarCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar.png"))); // NOI18N
        btnEliminarCompra.setText("Eliminar");
        btnEliminarCompra.setToolTipText("");
        btnEliminarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarCompraActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jScrollPane6.setBorder(jScrollPane5.getBorder());

        TablaEliminarCompras.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        TablaEliminarCompras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Clave", "Nombre", "Precio", "Cantidad", "Subtotal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(TablaEliminarCompras);
        TablaEliminarCompras.getColumnModel().getColumn(0).setMinWidth(85);
        TablaEliminarCompras.getColumnModel().getColumn(0).setPreferredWidth(85);
        TablaEliminarCompras.getColumnModel().getColumn(0).setMaxWidth(85);
        TablaEliminarCompras.getColumnModel().getColumn(2).setMinWidth(70);
        TablaEliminarCompras.getColumnModel().getColumn(2).setPreferredWidth(70);
        TablaEliminarCompras.getColumnModel().getColumn(2).setMaxWidth(70);
        TablaEliminarCompras.getColumnModel().getColumn(3).setMinWidth(65);
        TablaEliminarCompras.getColumnModel().getColumn(3).setPreferredWidth(65);
        TablaEliminarCompras.getColumnModel().getColumn(3).setMaxWidth(65);
        TablaEliminarCompras.getColumnModel().getColumn(4).setMinWidth(80);
        TablaEliminarCompras.getColumnModel().getColumn(4).setPreferredWidth(80);
        TablaEliminarCompras.getColumnModel().getColumn(4).setMaxWidth(80);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel6.setText("Folio");

        FolioEliminar.setEditable(false);
        FolioEliminar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        FolioEliminar.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        ProveedorEliminar.setEditable(false);
        ProveedorEliminar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ProveedorEliminar.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        FechaEliminar.setEditable(false);
        FechaEliminar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        FechaEliminar.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        TotalEliminar.setEditable(false);
        TotalEliminar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TotalEliminar.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel7.setText("Total:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel8.setText("ID del Proveedor");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel9.setText("Fecha");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(FolioEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(ProveedorEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(53, 53, 53))
                            .addComponent(FechaEliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane6)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TotalEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FolioEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ProveedorEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FechaEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TotalEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap())
        );

        btnPrimero1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nav_jan_primeiro.gif"))); // NOI18N
        btnPrimero1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrimero1ActionPerformed(evt);
            }
        });

        btnAnterior1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nav_jan_anterior.gif"))); // NOI18N
        btnAnterior1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnterior1ActionPerformed(evt);
            }
        });

        btnSiguiente1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nav_jan_proximo.gif"))); // NOI18N
        btnSiguiente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguiente1ActionPerformed(evt);
            }
        });

        btnUltimo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nav_jan_ultimo.gif"))); // NOI18N
        btnUltimo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUltimo1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelEliminarCompraLayout = new javax.swing.GroupLayout(PanelEliminarCompra);
        PanelEliminarCompra.setLayout(PanelEliminarCompraLayout);
        PanelEliminarCompraLayout.setHorizontalGroup(
            PanelEliminarCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelEliminarCompraLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelEliminarCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PanelEliminarCompraLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnPrimero1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAnterior1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSiguiente1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUltimo1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(122, 122, 122)
                        .addComponent(btnEliminarCompra)))
                .addContainerGap())
        );
        PanelEliminarCompraLayout.setVerticalGroup(
            PanelEliminarCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelEliminarCompraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelEliminarCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEliminarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPrimero1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSiguiente1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUltimo1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAnterior1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68))
        );

        jTabbedPane1.addTab("Eliminar", new javax.swing.ImageIcon(getClass().getResource("/imagenes/borrar.png")), PanelEliminarCompra); // NOI18N

        PanelConsultarCompra.setBackground(new java.awt.Color(255, 255, 255));
        PanelConsultarCompra.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PanelConsultarCompra.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                PanelConsultarCompraComponentShown(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jScrollPane5.setBorder(jScrollPane5.getBorder());

        TablaConsultarCompras.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        TablaConsultarCompras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Clave", "Nombre", "Precio", "Cantidad", "Subtotal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(TablaConsultarCompras);
        TablaConsultarCompras.getColumnModel().getColumn(0).setMinWidth(85);
        TablaConsultarCompras.getColumnModel().getColumn(0).setPreferredWidth(85);
        TablaConsultarCompras.getColumnModel().getColumn(0).setMaxWidth(85);
        TablaConsultarCompras.getColumnModel().getColumn(2).setMinWidth(70);
        TablaConsultarCompras.getColumnModel().getColumn(2).setPreferredWidth(70);
        TablaConsultarCompras.getColumnModel().getColumn(2).setMaxWidth(70);
        TablaConsultarCompras.getColumnModel().getColumn(3).setMinWidth(65);
        TablaConsultarCompras.getColumnModel().getColumn(3).setPreferredWidth(65);
        TablaConsultarCompras.getColumnModel().getColumn(3).setMaxWidth(65);
        TablaConsultarCompras.getColumnModel().getColumn(4).setMinWidth(80);
        TablaConsultarCompras.getColumnModel().getColumn(4).setPreferredWidth(80);
        TablaConsultarCompras.getColumnModel().getColumn(4).setMaxWidth(80);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel1.setText("Folio");

        FolioConsultar.setEditable(false);
        FolioConsultar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        FolioConsultar.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        ProveedorConsultar.setEditable(false);
        ProveedorConsultar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ProveedorConsultar.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        FechaConsultar.setEditable(false);
        FechaConsultar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        FechaConsultar.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        TotalConsultar.setEditable(false);
        TotalConsultar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TotalConsultar.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel2.setText("Total:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel3.setText("ID del Proveedor");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel4.setText("Fecha");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(FolioConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(ProveedorConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(53, 53, 53))
                            .addComponent(FechaConsultar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane5)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TotalConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FolioConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ProveedorConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FechaConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TotalConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap())
        );

        btnPrimero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nav_jan_primeiro.gif"))); // NOI18N
        btnPrimero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrimeroActionPerformed(evt);
            }
        });

        btnAnterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nav_jan_anterior.gif"))); // NOI18N
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });

        btnSiguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nav_jan_proximo.gif"))); // NOI18N
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });

        btnUltimo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nav_jan_ultimo.gif"))); // NOI18N
        btnUltimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUltimoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelConsultarCompraLayout = new javax.swing.GroupLayout(PanelConsultarCompra);
        PanelConsultarCompra.setLayout(PanelConsultarCompraLayout);
        PanelConsultarCompraLayout.setHorizontalGroup(
            PanelConsultarCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelConsultarCompraLayout.createSequentialGroup()
                .addGroup(PanelConsultarCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelConsultarCompraLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(PanelConsultarCompraLayout.createSequentialGroup()
                        .addGap(226, 226, 226)
                        .addComponent(btnPrimero, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUltimo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PanelConsultarCompraLayout.setVerticalGroup(
            PanelConsultarCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelConsultarCompraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelConsultarCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPrimero, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUltimo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Consultar", new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar.png")), PanelConsultarCompra); // NOI18N

        PanelCuentasPorPagar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PanelCuentasPorPagar.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                PanelCuentasPorPagarComponentShown(evt);
            }
        });

        TablaCuentasPorPagar.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        TablaCuentasPorPagar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Folio ", "Fecha", "Proveedor", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(TablaCuentasPorPagar);
        TablaCuentasPorPagar.getColumnModel().getColumn(0).setMinWidth(100);
        TablaCuentasPorPagar.getColumnModel().getColumn(0).setPreferredWidth(100);
        TablaCuentasPorPagar.getColumnModel().getColumn(0).setMaxWidth(100);
        TablaCuentasPorPagar.getColumnModel().getColumn(1).setMinWidth(120);
        TablaCuentasPorPagar.getColumnModel().getColumn(1).setPreferredWidth(120);
        TablaCuentasPorPagar.getColumnModel().getColumn(1).setMaxWidth(120);
        TablaCuentasPorPagar.getColumnModel().getColumn(3).setMinWidth(150);
        TablaCuentasPorPagar.getColumnModel().getColumn(3).setPreferredWidth(150);
        TablaCuentasPorPagar.getColumnModel().getColumn(3).setMaxWidth(150);

        btnGuardarAbono.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btnGuardarAbono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cuentasporpagar.png"))); // NOI18N
        btnGuardarAbono.setText("Registrar Abono");
        btnGuardarAbono.setToolTipText("");
        btnGuardarAbono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarAbonoActionPerformed(evt);
            }
        });
        btnGuardarAbono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnGuardarAbonoKeyPressed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel5.setText("Cantidad a Abonar:  $");

        txtAbono.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("##0.00"))));
        txtAbono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAbono.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        txtAbono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAbonoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAbonoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAbono, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtAbono, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout PanelCuentasPorPagarLayout = new javax.swing.GroupLayout(PanelCuentasPorPagar);
        PanelCuentasPorPagar.setLayout(PanelCuentasPorPagarLayout);
        PanelCuentasPorPagarLayout.setHorizontalGroup(
            PanelCuentasPorPagarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCuentasPorPagarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelCuentasPorPagarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 631, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelCuentasPorPagarLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardarAbono)
                        .addGap(99, 99, 99)))
                .addContainerGap())
        );
        PanelCuentasPorPagarLayout.setVerticalGroup(
            PanelCuentasPorPagarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCuentasPorPagarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelCuentasPorPagarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelCuentasPorPagarLayout.createSequentialGroup()
                        .addComponent(btnGuardarAbono)
                        .addGap(10, 10, 10)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Crédito ", new javax.swing.ImageIcon(getClass().getResource("/imagenes/credito.png")), PanelCuentasPorPagar); // NOI18N

        jTabbedPane1.setBounds(10, 40, 770, 480);
        jLayeredPane1.add(jTabbedPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lblTitulo.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Compras a Proveedores");
        lblTitulo.setBounds(300, 10, 200, 22);
        jLayeredPane1.add(lblTitulo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lblFecha.setFont(new java.awt.Font("Candara", 1, 12)); // NOI18N
        lblFecha.setForeground(new java.awt.Color(255, 255, 255));
        lblFecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFecha.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblFecha.setBounds(660, 10, 130, 18);
        jLayeredPane1.add(lblFecha, javax.swing.JLayeredPane.DEFAULT_LAYER);

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoventanas2.png"))); // NOI18N
        fondo.setBounds(0, 0, 800, 600);
        jLayeredPane1.add(fondo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCerrarActionPerformed
        conexion.cerrarConexion();
        this.dispose();
    }//GEN-LAST:event_botonCerrarActionPerformed

    private void botonGuardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardar1ActionPerformed


        if (JOptionPane.showConfirmDialog(this, "¿Desea Guardar la Compra", "Mensaje", 0) == 0 && articulo_tabla1 != 0 && !IDProveedor.getText().equals("     ")) {
            String date[] = txtFecha.getText().split("/");
            try {
                String[] encabezado = {Folio.getText(), IDProveedor.getText(), date[0], date[1], date[2], Total.getText()};
                conexion.insertar(2, encabezado);


                for (int i = 0; i < articulo_tabla1; i++) {

                    String encabezado2[] = {Folio.getText(), (String.valueOf(TablaNuevaCompra.getValueAt(i, 0))), String.valueOf(TablaNuevaCompra.getValueAt(i, 1)), String.valueOf(TablaNuevaCompra.getValueAt(i, 5))};
                    conexion.insertar(3, encabezado2);

                }
                for (int i = 0; i < articulo_tabla1; i++) {

                    resultado = conexion.consultar(1, "*", "Clave_A", String.valueOf(TablaNuevaCompra.getValueAt(i, 0)), 1);
                    if (resultado.first()) {

                        int existencia = resultado.getInt(4);
                        String precio_venta = resultado.getString(6);
                        int nueva_existencia = existencia + (Integer.parseInt(String.valueOf(TablaNuevaCompra.getValueAt(i, 1))));
                        String encabezado3[] = {(String.valueOf(TablaNuevaCompra.getValueAt(i, 0))), String.valueOf(TablaNuevaCompra.getValueAt(i, 2)), String.valueOf(TablaNuevaCompra.getValueAt(i, 3)), String.valueOf(nueva_existencia), String.valueOf(TablaNuevaCompra.getValueAt(i, 4)), precio_venta};
                        conexion.modificar(1, encabezado3, (String) (TablaNuevaCompra.getValueAt(i, 0)));

                    } else {

                        String encabezado3[] = {(String.valueOf(TablaNuevaCompra.getValueAt(i, 0))), String.valueOf(TablaNuevaCompra.getValueAt(i, 2)), String.valueOf(TablaNuevaCompra.getValueAt(i, 3)), String.valueOf(TablaNuevaCompra.getValueAt(i, 1)), String.valueOf(TablaNuevaCompra.getValueAt(i, 4)), "0"};
                        conexion.insertar(1, encabezado3);
                    }

                }

                if (opCredito.isSelected()) {

                    String registro[] = {Folio.getText(), txtFecha.getText(), nombre_proveedor, Total.getText()};
                    conexion.insertar(7, registro);
                }

                JOptionPane.showMessageDialog(this, "La Compra se ha almacenado");
                btnAnterior.setEnabled(true);
                btnAnterior1.setEnabled(true);
                btnSiguiente.setEnabled(true);
                btnSiguiente1.setEnabled(true);
                limpiarTabla(1);
                IDProveedor.setText("");
                Total.setText("");
                estableceFolio();
                articulo_tabla1 = 0;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error al conectar con la Base de Datos");
                System.out.println(ex);
            }
        } else {
            if (articulo_tabla1 == 0 || IDProveedor.getText().equals("     ")) {
                JOptionPane.showMessageDialog(this, "Faltan Datos o no se ha agregado ningún Articulo");
            }
        }
    }//GEN-LAST:event_botonGuardar1ActionPerformed

    private void botonCancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelar1ActionPerformed

        if ((JOptionPane.showConfirmDialog(this, "Realmente desea cancelar esta Compra?", "Advertencia", 0)) == 0) {
            IDProveedor.setText("");
            CampoClave.setText("");
            CampoCantidad.setText("");
            CampoCosto.setText("");
            CampoNombre.setText("");
            Total.setText("");
            articulo_tabla1 = 0;
            limpiarTabla(1);
        }

    }//GEN-LAST:event_botonCancelar1ActionPerformed

    private void botonAñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAñadirActionPerformed
        double total = 0;
        boolean ban = false;
        if (!CampoClave.getText().equals("") && !CampoCantidad.getText().equals("") && !CampoNombre.getText().equals("") && ListaTipo.getSelectedIndex() != -1 && !CampoCosto.getText().equals("")) {

            for (int i = 0; i <= articulo_tabla1; i++) {
                if (CampoClave.getText().equals(String.valueOf(TablaNuevaCompra.getValueAt(i, 0)))) {
                    int cantidad1 = Integer.parseInt(CampoCantidad.getText());
                    int cantidad2 = Integer.parseInt((String) TablaNuevaCompra.getValueAt(i, 1));
                    int res = cantidad1 + cantidad2;

                    TablaNuevaCompra.setValueAt(String.valueOf(res), i, 1);
                    TablaNuevaCompra.setValueAt(((res) * Float.parseFloat((String) TablaNuevaCompra.getValueAt(i, 4))), i, 5);

                    ban = true;
                    break;
                }
            }

            if (!ban) {
                TablaNuevaCompra.setValueAt(CampoClave.getText(), articulo_tabla1, 0);
                TablaNuevaCompra.setValueAt(CampoCantidad.getText(), articulo_tabla1, 1);
                TablaNuevaCompra.setValueAt(CampoNombre.getText(), articulo_tabla1, 2);
                TablaNuevaCompra.setValueAt((String) ListaTipo.getSelectedItem(), articulo_tabla1, 3);
                TablaNuevaCompra.setValueAt(CampoCosto.getText(), articulo_tabla1, 4);
                TablaNuevaCompra.setValueAt((Float.parseFloat(CampoCantidad.getText()) * Float.parseFloat(CampoCosto.getText())), articulo_tabla1, 5);
                articulo_tabla1 += 1;
            }

            for (int i = 0; i < articulo_tabla1; i++) {
                total = total + Double.parseDouble(String.valueOf(TablaNuevaCompra.getValueAt(i, 5)));
            }
            Total.setText(String.valueOf(total));
            CampoClave.setText("");
            CampoCantidad.setText("");
            CampoCosto.setText("");
            CampoNombre.setText("");
            CampoClave.requestFocus();

        } else {
            JOptionPane.showMessageDialog(this, "Los campos no pueden estar vacíos");
            CampoClave.requestFocus();

        }
    }//GEN-LAST:event_botonAñadirActionPerformed

    private void txtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaActionPerformed

    private void CampoCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CampoCantidadKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        } else {
            if (CampoCantidad.getText().length() > 4) {
                Toolkit.getDefaultToolkit().beep();
                evt.consume();
            }
        }
    }//GEN-LAST:event_CampoCantidadKeyTyped

    private void ListaTipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ListaTipoItemStateChanged
        String Nuevo_Tipo = "";
        Seleccion_Lista_Tipo += 1;
        int Numero_de_Tipos = ListaTipo.getItemCount();
        if (ListaTipo.getSelectedIndex() == Numero_de_Tipos - 1 && Seleccion_Lista_Tipo > 1) {
            Nuevo_Tipo = JOptionPane.showInputDialog("Introduce el tipo de Artículo");
            if (Nuevo_Tipo != null) {
                if (!Nuevo_Tipo.equals("")) {
                    ListaTipo.removeItemAt(Numero_de_Tipos - 1);
                    ListaTipo.addItem(Nuevo_Tipo);
                    ListaTipo.addItem("Otro...");
                    ListaTipo.setSelectedIndex(Numero_de_Tipos - 1);

                } else {
                    ListaTipo.setSelectedIndex(1);
                }
            } else {
                ListaTipo.setSelectedIndex(1);
                ListaTipo.requestFocus();
            }
        } else {
            if (Seleccion_Lista_Tipo > 1 && Seleccion_Teclas == false) {
                CampoCosto.requestFocus();
            }
        }
    }//GEN-LAST:event_ListaTipoItemStateChanged

    private void CampoClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoClaveActionPerformed

        String clave_articulo = CampoClave.getText();
        if (!clave_articulo.equals("")) {
            try {
                resultado = conexion.consultar(1, "*", "Clave_A", clave_articulo, 1);
                if (resultado.first()) {

                    CampoClave.setText(resultado.getString(1));
                    CampoNombre.setText(resultado.getString(2));
                    CampoCosto.setText(resultado.getString(5));
                    for (int i = 0; i < ListaTipo.getItemCount(); i++) {
                        if (resultado.getString(3).equals((String) ListaTipo.getItemAt(i))) {
                            ListaTipo.setSelectedIndex(i);
                        }
                    }
                }
                contador_max_caracteres = 0;
                CampoCantidad.requestFocus();


            } catch (SQLException ex) {
                Logger.getLogger(Compras.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_CampoClaveActionPerformed

    private void CampoCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoCantidadActionPerformed
        CampoNombre.requestFocus();
    }//GEN-LAST:event_CampoCantidadActionPerformed

    private void botonAñadirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_botonAñadirKeyPressed
        double total = 0;
        boolean ban = false;
        if (!CampoClave.getText().equals("") && !CampoCantidad.getText().equals("") && !CampoNombre.getText().equals("") && ListaTipo.getSelectedIndex() != -1 && !CampoCosto.getText().equals("")) {

            for (int i = 0; i <= articulo_tabla1; i++) {
                if (CampoClave.getText().equals(String.valueOf(TablaNuevaCompra.getValueAt(i, 0)))) {
                    int cantidad1 = Integer.parseInt(CampoCantidad.getText());
                    int cantidad2 = Integer.parseInt((String) TablaNuevaCompra.getValueAt(i, 1));
                    int res = cantidad1 + cantidad2;

                    TablaNuevaCompra.setValueAt(String.valueOf(res), i, 1);
                    TablaNuevaCompra.setValueAt(((res) * Float.parseFloat((String) TablaNuevaCompra.getValueAt(i, 4))), i, 5);

                    ban = true;
                    break;
                }
            }
            if (!ban) {
                TablaNuevaCompra.setValueAt(CampoClave.getText(), articulo_tabla1, 0);
                TablaNuevaCompra.setValueAt(CampoCantidad.getText(), articulo_tabla1, 1);
                TablaNuevaCompra.setValueAt(CampoNombre.getText(), articulo_tabla1, 2);
                TablaNuevaCompra.setValueAt((String) ListaTipo.getSelectedItem(), articulo_tabla1, 3);
                TablaNuevaCompra.setValueAt(CampoCosto.getText(), articulo_tabla1, 4);
                TablaNuevaCompra.setValueAt((Float.parseFloat(CampoCantidad.getText()) * Float.parseFloat(CampoCosto.getText())), articulo_tabla1, 5);
                articulo_tabla1 += 1;
            }
            for (int i = 0; i < articulo_tabla1; i++) {
                total = total + Double.parseDouble(String.valueOf(TablaNuevaCompra.getValueAt(i, 5)));
            }
            Total.setText(String.valueOf(total));
            CampoClave.setText("");
            CampoCantidad.setText("");
            CampoCosto.setText("");
            CampoNombre.setText("");
            CampoClave.requestFocus();

        } else {
            JOptionPane.showMessageDialog(this, "Los campos no pueden estar vacíos");
            CampoClave.requestFocus();

        }
    }//GEN-LAST:event_botonAñadirKeyPressed

    private void Autocompletar1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_Autocompletar1ItemStateChanged
        if (Autocompletar1.getSelectedIndex() != 0) {
            String elementos[] = String.valueOf(Autocompletar1.getSelectedItem()).split("-");
            IDProveedor.setText(elementos[0]);
            nombre_proveedor = elementos[1];
            Autocompletar1.setSelectedIndex(0);
            Autocompletar1.setVisible(false);
            CampoClave.requestFocus();
        }
    }//GEN-LAST:event_Autocompletar1ItemStateChanged

    private void CampoNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoNombreActionPerformed
        ListaTipo.requestFocus();
    }//GEN-LAST:event_CampoNombreActionPerformed

    private void ListaTipoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ListaTipoFocusGained
        ListaTipo.showPopup();
    }//GEN-LAST:event_ListaTipoFocusGained

    private void CampoClaveKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CampoClaveKeyTyped
        char c = evt.getKeyChar();

        if (!Character.isDigit(c)) {

            evt.consume();
        } else {
            if (CampoClave.getText().length() > 11) {
                Toolkit.getDefaultToolkit().beep();
                evt.consume();
            }
        }
    }//GEN-LAST:event_CampoClaveKeyTyped

    private void CampoCantidadFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CampoCantidadFocusGained
        contador_max_caracteres = 0;
    }//GEN-LAST:event_CampoCantidadFocusGained

    private void PanelCuentasPorPagarComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_PanelCuentasPorPagarComponentShown
        if (ContadorLlenadoTabla >= 1) {

            vaciarTabla(1);
            llenarTabla(1);
        }
        txtAbono.setText("");
    }//GEN-LAST:event_PanelCuentasPorPagarComponentShown

    private void CampoNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CampoNombreKeyReleased
        String aux = "";
        if (!CampoNombre.getText().equals("")) {
            String ContenidoNuevo[] = CampoNombre.getText().split(" ");
            if (KeyEvent.getKeyText(evt.getKeyCode()).equals("Espacio")) {

                for (int i = 0; i < ContenidoNuevo.length; i++) {
                    if (i == ContenidoNuevo.length) {
                        aux = aux + ContenidoNuevo[i];
                    } else {
                        aux = aux + ContenidoNuevo[i] + " ";
                    }
                }
                CampoNombre.setText(aux);
            }
        }
    }//GEN-LAST:event_CampoNombreKeyReleased

    private void CampoNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CampoNombreKeyTyped
        char c = evt.getKeyChar();
        if ((!Character.getName(c).equals("SPACE") && !Character.isLetterOrDigit(c))) {
            evt.consume();
        } else {
            if (CampoNombre.getText().length() > 49) {
                Toolkit.getDefaultToolkit().beep();
                evt.consume();
            }
        }
    }//GEN-LAST:event_CampoNombreKeyTyped

    private void ListaTipoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ListaTipoKeyPressed
        if ((KeyEvent.getKeyText(evt.getKeyCode()).equals("Abajo") || KeyEvent.getKeyText(evt.getKeyCode()).equals("Arriba"))) {
            Seleccion_Teclas = true;
        } else {
            if ((KeyEvent.getKeyText(evt.getKeyCode()).equals("Intro"))) {
                CampoCosto.requestFocus();
            }
        }
    }//GEN-LAST:event_ListaTipoKeyPressed

    private void CampoCostoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoCostoActionPerformed
        botonAñadir.requestFocus();
    }//GEN-LAST:event_CampoCostoActionPerformed

    private void CampoCostoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CampoCostoKeyTyped
        char c = evt.getKeyChar();
        if (!Character.getName(c).equals("FULL STOP") && !Character.isDigit(c)) {
            evt.consume();
        } else {
            if(CampoCosto.getText().length()>6){
            evt.consume();
            }
        }
    }//GEN-LAST:event_CampoCostoKeyTyped

    private void CampoCostoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CampoCostoKeyPressed
        if ((KeyEvent.getKeyText(evt.getKeyCode()).equals("Intro"))) {
            botonAñadir.requestFocus();
        }
    }//GEN-LAST:event_CampoCostoKeyPressed

    private void IDProveedorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_IDProveedorFocusGained
        Autocompletar1.setVisible(true);


    }//GEN-LAST:event_IDProveedorFocusGained

    private void IDProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IDProveedorMouseClicked
        Autocompletar1.showPopup();
    }//GEN-LAST:event_IDProveedorMouseClicked

    private void PanelConsultarCompraComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_PanelConsultarCompraComponentShown
        vaciarTabla(2);
        llenarTabla(3);
    }//GEN-LAST:event_PanelConsultarCompraComponentShown

    private void btnPrimeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrimeroActionPerformed

        try {
            vaciarTabla(2);
            Object fila2[] = new Object[5];
            ResultSet resultado_articulo_primer, resultado_articulo;
            ResultSet Resultado_Encabezado = conexion.consultar(2);
            if (Resultado_Encabezado.first()) {

                FolioConsultar.setText(Resultado_Encabezado.getString(1));
                ProveedorConsultar.setText(Resultado_Encabezado.getString(2));
                FechaConsultar.setText(Resultado_Encabezado.getString(3) + "/" + Resultado_Encabezado.getString(4) + "/" + Resultado_Encabezado.getString(5));
                TotalConsultar.setText(Resultado_Encabezado.getString(6));
                resultado_articulo_primer = conexion.consultar(3, "*", "Folio_C", FolioConsultar.getText(), 2);

                while (resultado_articulo_primer.next()) {
                    fila2[0] = resultado_articulo_primer.getString(2);
                    fila2[3] = resultado_articulo_primer.getString(3);
                    fila2[4] = resultado_articulo_primer.getString(4);
                    resultado_articulo = conexion3.consultar(1, "*", "Clave_A", String.valueOf(fila2[0]));
                    resultado_articulo.first();
                    fila2[1] = resultado_articulo.getString(2);

                    fila2[2] = resultado_articulo.getString(5);

                    ModeloTabla4.addRow(fila2);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Compras.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnPrimeroActionPerformed

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
        try {
            vaciarTabla(2);
            Object fila2[] = new Object[5];
            ResultSet resultado_articulo_primer, resultado_articulo;
            if (Resultado_Encabezado_Consultar.previous()) {
                FolioConsultar.setText(Resultado_Encabezado_Consultar.getString(1));
                ProveedorConsultar.setText(Resultado_Encabezado_Consultar.getString(2));
                FechaConsultar.setText(Resultado_Encabezado_Consultar.getString(3) + "/" + Resultado_Encabezado_Consultar.getString(4) + "/" + Resultado_Encabezado_Consultar.getString(5));
                TotalConsultar.setText(Resultado_Encabezado_Consultar.getString(6));
                resultado_articulo_primer = conexion.consultar(3, "*", "Folio_C", FolioConsultar.getText(), 2);

                while (resultado_articulo_primer.next()) {
                    fila2[0] = resultado_articulo_primer.getString(2);
                    fila2[3] = resultado_articulo_primer.getString(3);
                    fila2[4] = resultado_articulo_primer.getString(4);
                    resultado_articulo = conexion3.consultar(1, "*", "Clave_A", String.valueOf(fila2[0]));
                    resultado_articulo.first();
                    fila2[1] = resultado_articulo.getString(2);

                    fila2[2] = resultado_articulo.getString(5);

                    ModeloTabla4.addRow(fila2);
                }

            } else {
                Resultado_Encabezado_Consultar.first();
                FolioConsultar.setText(Resultado_Encabezado_Consultar.getString(1));
                ProveedorConsultar.setText(Resultado_Encabezado_Consultar.getString(2));
                FechaConsultar.setText(Resultado_Encabezado_Consultar.getString(3) + "/" + Resultado_Encabezado_Consultar.getString(4) + "/" + Resultado_Encabezado_Consultar.getString(5));
                TotalConsultar.setText(Resultado_Encabezado_Consultar.getString(6));
                resultado_articulo_primer = conexion.consultar(3, "*", "Folio_C", FolioConsultar.getText(), 2);

                while (resultado_articulo_primer.next()) {
                    fila2[0] = resultado_articulo_primer.getString(2);
                    fila2[3] = resultado_articulo_primer.getString(3);
                    fila2[4] = resultado_articulo_primer.getString(4);
                    resultado_articulo = conexion3.consultar(1, "*", "Clave_A", String.valueOf(fila2[0]));
                    resultado_articulo.first();
                    fila2[1] = resultado_articulo.getString(2);

                    fila2[2] = resultado_articulo.getString(5);

                    ModeloTabla4.addRow(fila2);
                }
            }





        } catch (SQLException ex) {
            Logger.getLogger(Compras.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAnteriorActionPerformed

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        try {
            vaciarTabla(2);
            Object fila2[] = new Object[5];
            ResultSet resultado_articulo_primer, resultado_articulo;
            if (Resultado_Encabezado_Consultar.next()) {
                FolioConsultar.setText(Resultado_Encabezado_Consultar.getString(1));
                ProveedorConsultar.setText(Resultado_Encabezado_Consultar.getString(2));
                FechaConsultar.setText(Resultado_Encabezado_Consultar.getString(3) + "/" + Resultado_Encabezado_Consultar.getString(4) + "/" + Resultado_Encabezado_Consultar.getString(5));
                TotalConsultar.setText(Resultado_Encabezado_Consultar.getString(6));
                resultado_articulo_primer = conexion.consultar(3, "*", "Folio_C", FolioConsultar.getText(), 2);

                while (resultado_articulo_primer.next()) {
                    fila2[0] = resultado_articulo_primer.getString(2);
                    fila2[3] = resultado_articulo_primer.getString(3);
                    fila2[4] = resultado_articulo_primer.getString(4);
                    resultado_articulo = conexion3.consultar(1, "*", "Clave_A", String.valueOf(fila2[0]));
                    resultado_articulo.first();
                    fila2[1] = resultado_articulo.getString(2);

                    fila2[2] = resultado_articulo.getString(5);

                    ModeloTabla4.addRow(fila2);
                }

            } else {


                Resultado_Encabezado_Consultar.last();
                FolioConsultar.setText(Resultado_Encabezado_Consultar.getString(1));
                ProveedorConsultar.setText(Resultado_Encabezado_Consultar.getString(2));
                FechaCompra.setText(Resultado_Encabezado_Consultar.getString(3) + "/" + Resultado_Encabezado_Consultar.getString(4) + "/" + Resultado_Encabezado_Consultar.getString(5));
                TotalConsultar.setText(Resultado_Encabezado_Consultar.getString(6));
                resultado_articulo_primer = conexion.consultar(3, "*", "Folio_C", FolioConsultar.getText(), 2);

                while (resultado_articulo_primer.next()) {
                    fila2[0] = resultado_articulo_primer.getString(2);
                    fila2[3] = resultado_articulo_primer.getString(3);
                    fila2[4] = resultado_articulo_primer.getString(4);
                    resultado_articulo = conexion3.consultar(1, "*", "Clave_A", String.valueOf(fila2[0]));
                    resultado_articulo.first();
                    fila2[1] = resultado_articulo.getString(2);

                    fila2[2] = resultado_articulo.getString(5);

                    ModeloTabla4.addRow(fila2);
                }
            }





        } catch (SQLException ex) {
            Logger.getLogger(Compras.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void btnUltimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUltimoActionPerformed
        try {
            vaciarTabla(2);
            Object fila2[] = new Object[5];
            ResultSet resultado_articulo_primer, resultado_articulo;
            ResultSet Resultado_Encabezado = conexion.consultar(2);
            if (Resultado_Encabezado.last()) {

                FolioConsultar.setText(Resultado_Encabezado.getString(1));
                ProveedorConsultar.setText(Resultado_Encabezado.getString(2));
                FechaConsultar.setText(Resultado_Encabezado.getString(3) + "/" + Resultado_Encabezado.getString(4) + "/" + Resultado_Encabezado.getString(5));
                TotalConsultar.setText(Resultado_Encabezado.getString(6));
                resultado_articulo_primer = conexion.consultar(3, "*", "Folio_C", FolioConsultar.getText(), 2);

                while (resultado_articulo_primer.next()) {
                    fila2[0] = resultado_articulo_primer.getString(2);
                    fila2[3] = resultado_articulo_primer.getString(3);
                    fila2[4] = resultado_articulo_primer.getString(4);
                    resultado_articulo = conexion3.consultar(1, "*", "Clave_A", String.valueOf(fila2[0]));
                    resultado_articulo.first();
                    fila2[1] = resultado_articulo.getString(2);

                    fila2[2] = resultado_articulo.getString(5);

                    ModeloTabla4.addRow(fila2);
                }
            }





        } catch (SQLException ex) {
            Logger.getLogger(Compras.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUltimoActionPerformed

    private void btnGuardarAbonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarAbonoActionPerformed
        int fila = TablaCuentasPorPagar.getSelectedRow();
        double total_nuevo = 0;
        if (fila != -1) {
            double total_anterior = Double.parseDouble((String) TablaCuentasPorPagar.getValueAt(fila, 3));
            if (!txtAbono.getText().equals("")) {
                double abono = Double.parseDouble(txtAbono.getText());
                if (!(abono > total_anterior)) {
                    try {
                        String cuenta_modificada[] = new String[4];
                        total_nuevo = total_anterior - abono;
                        cuenta_modificada[0] = (String) TablaCuentasPorPagar.getValueAt(fila, 0);
                        cuenta_modificada[1] = (String) TablaCuentasPorPagar.getValueAt(fila, 1);
                        cuenta_modificada[2] = (String) TablaCuentasPorPagar.getValueAt(fila, 2);
                        cuenta_modificada[3] = String.valueOf(total_nuevo);
                        conexion_elimina_compra.modificar(7, cuenta_modificada, cuenta_modificada[0]);
                        JOptionPane.showMessageDialog(this, "Se abono a la cuenta con exito", "Abonado", 1);
                        if (total_nuevo == 0) {
                            JOptionPane.showMessageDialog(this, "Se ha saldado la cuenta", "Abonado", 1);
                            System.out.println("." + String.valueOf(TablaCuentasPorPagar.getValueAt(fila, 0)) + ".");
                            conexion_elimina_compra.eliminar(7, String.valueOf(TablaCuentasPorPagar.getValueAt(fila, 0)));
                        }
                        txtAbono.setText("");
                        vaciarTabla(1);
                        llenarTabla(1);
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(this, "Error al actualizar el abono, problema con la conexión con la Base de Datos", "Error", 0);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "El abono es mas que la cantidad a saldar", "Mensaje", 2);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Debes introducir el abono que se hara a la cuenta", "Mensaje", 2);
            }

        } else {
            JOptionPane.showMessageDialog(this, "Primero debes seleccionar una fila de la Tabla", "Mensaje", 2);
        }
    }//GEN-LAST:event_btnGuardarAbonoActionPerformed

    private void txtAbonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAbonoKeyTyped
        char c = evt.getKeyChar();
        if (!Character.getName(c).equals("FULL STOP") && !Character.isDigit(c)) {
            evt.consume();
        } else {
            if (txtAbono.getText().length() > 7) {
                Toolkit.getDefaultToolkit().beep();
                evt.consume();
            }
        }
    }//GEN-LAST:event_txtAbonoKeyTyped

    private void txtAbonoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAbonoKeyPressed
        if ((KeyEvent.getKeyText(evt.getKeyCode()).equals("Intro"))) {
            btnGuardarAbono.requestFocus();
        }
    }//GEN-LAST:event_txtAbonoKeyPressed

    private void btnGuardarAbonoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnGuardarAbonoKeyPressed
        int fila = TablaCuentasPorPagar.getSelectedRow();
        double total_nuevo = 0;
        if (fila != -1) {
            double total_anterior = Double.parseDouble((String) TablaCuentasPorPagar.getValueAt(fila, 3));
            if (!txtAbono.getText().equals("")) {
                double abono = Double.parseDouble(txtAbono.getText());
                if (!(abono > total_anterior)) {
                    try {
                        String cuenta_modificada[] = new String[4];
                        total_nuevo = total_anterior - abono;



                        cuenta_modificada[0] = (String) TablaCuentasPorPagar.getValueAt(fila, 0);
                        cuenta_modificada[1] = (String) TablaCuentasPorPagar.getValueAt(fila, 1);
                        cuenta_modificada[2] = (String) TablaCuentasPorPagar.getValueAt(fila, 2);
                        cuenta_modificada[3] = String.valueOf(total_nuevo);
                        conexion_elimina_compra.modificar(7, cuenta_modificada, cuenta_modificada[0]);
                        JOptionPane.showMessageDialog(this, "Se abono a la cuenta con exito", "Abonado", 1);
                        if (total_nuevo == 0) {
                            JOptionPane.showMessageDialog(this, "Se ha saldado la cuenta", "Abonado", 1);
                            System.out.println("." + String.valueOf(TablaCuentasPorPagar.getValueAt(fila, 0)) + ".");
                            conexion_elimina_compra.consultar(7, String.valueOf(TablaCuentasPorPagar.getValueAt(fila, 0)));

                        }

                        txtAbono.setText("");
                        vaciarTabla(1);
                        llenarTabla(1);
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(this, "Error al actualizar el abono, problema con la conexión con la Base de Datos", "Error", 0);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "El abono es mas que la cantidad a saldar", "Mensaje", 2);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Debes introducir el abono que se hara a la cuenta", "Mensaje", 2);
            }

        } else {
            JOptionPane.showMessageDialog(this, "Primero debes seleccionar una fila de la Tabla", "Mensaje", 2);
        }
    }//GEN-LAST:event_btnGuardarAbonoKeyPressed

    private void btnEliminarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarCompraActionPerformed

        if (JOptionPane.showConfirmDialog(this, "Se borrara el registro de la compra, ¿Desea continuar?", "Advertencia", 0, 2) == 0) {
            try {
                ResultSet resultado_cuentas = conexion_eliminar_registro.consultar(7, "*", "Folio_C", FolioEliminar.getText(), 1);


                if (resultado_cuentas.first() == false) {
                    ResultSet resultado_articulo = conexion_eliminar_registro.consultar(3, "*", "Folio_C", FolioEliminar.getText(), 1);

                    int nueva = 0;

                    while (resultado_articulo.next()) {
                        ResultSet resultado_articulo2 = conexion_consulta_articulo_borrar.consultar(1, "*", "Clave_A", resultado_articulo.getString(2), 1);
                        resultado_articulo2.first();
                        int cantidad_borrar = resultado_articulo.getInt(3);
                        int cantidad_antigua = resultado_articulo2.getInt(4);
                        nueva = cantidad_antigua - cantidad_borrar;
                        String valores[] = new String[6];
                        valores[0] = resultado_articulo2.getString(1);
                        valores[1] = resultado_articulo2.getString(2);
                        valores[2] = resultado_articulo2.getString(3);
                        valores[3] = String.valueOf(nueva);
                        valores[4] = resultado_articulo2.getString(5);
                        valores[5] = resultado_articulo2.getString(6);


                        conexion_consulta_articulo_borrar.modificar(1, valores, valores[0]);

                    }


                    conexion_eliminar_registro.eliminar(2, FolioEliminar.getText());
                    conexion_eliminar_registro.eliminar(3, FolioEliminar.getText());

                    JOptionPane.showMessageDialog(this, "El registro de la compra fue eliminado correctamente");

                    vaciarTabla(3);
                    llenarTabla(2);
                   
                    vaciarTabla(2);
                    llenarTabla(3);
                } else {
                    JOptionPane.showMessageDialog(this, "No se puede eliminar este registro, existe un registro de credito con esta compra");
                }

            } catch (SQLException ex) {
                Logger.getLogger(Compras.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_btnEliminarCompraActionPerformed

    private void btnPrimero1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrimero1ActionPerformed
        vaciarTabla(3);
        llenarTabla(2);
    }//GEN-LAST:event_btnPrimero1ActionPerformed

    private void PanelEliminarCompraComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_PanelEliminarCompraComponentShown
        vaciarTabla(3);
        llenarTabla(2);
    }//GEN-LAST:event_PanelEliminarCompraComponentShown

    private void btnSiguiente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguiente1ActionPerformed
        try {
            vaciarTabla(3);
            Object fila2[] = new Object[5];
            ResultSet resultado_articulo_primer, resultado_articulo;
            if (Resultado_Encabezado_Eliminar.next()) {
                FolioEliminar.setText(Resultado_Encabezado_Eliminar.getString(1));
                ProveedorEliminar.setText(Resultado_Encabezado_Eliminar.getString(2));
                FechaEliminar.setText(Resultado_Encabezado_Eliminar.getString(3) + "/" + Resultado_Encabezado_Eliminar.getString(4) + "/" + Resultado_Encabezado_Eliminar.getString(5));
                TotalEliminar.setText(Resultado_Encabezado_Eliminar.getString(6));
                resultado_articulo_primer = conexion.consultar(3, "*", "Folio_C", FolioEliminar.getText(), 2);

                while (resultado_articulo_primer.next()) {
                    fila2[0] = resultado_articulo_primer.getString(2);
                    fila2[3] = resultado_articulo_primer.getString(3);
                    fila2[4] = resultado_articulo_primer.getString(4);
                    resultado_articulo = conexion3.consultar(1, "*", "Clave_A", String.valueOf(fila2[0]));
                    resultado_articulo.first();
                    fila2[1] = resultado_articulo.getString(2);

                    fila2[2] = resultado_articulo.getString(5);

                    ModeloTabla3.addRow(fila2);
                }

            } else {
                Resultado_Encabezado_Eliminar.last();
                FolioEliminar.setText(Resultado_Encabezado_Eliminar.getString(1));
                ProveedorEliminar.setText(Resultado_Encabezado_Eliminar.getString(2));
                FechaEliminar.setText(Resultado_Encabezado_Eliminar.getString(3) + "/" + Resultado_Encabezado_Eliminar.getString(4) + "/" + Resultado_Encabezado_Eliminar.getString(5));
                TotalEliminar.setText(Resultado_Encabezado_Eliminar.getString(6));
                resultado_articulo_primer = conexion.consultar(3, "*", "Folio_C", FolioEliminar.getText(), 2);

                while (resultado_articulo_primer.next()) {
                    fila2[0] = resultado_articulo_primer.getString(2);
                    fila2[3] = resultado_articulo_primer.getString(3);
                    fila2[4] = resultado_articulo_primer.getString(4);
                    resultado_articulo = conexion3.consultar(1, "*", "Clave_A", String.valueOf(fila2[0]));
                    resultado_articulo.first();
                    fila2[1] = resultado_articulo.getString(2);

                    fila2[2] = resultado_articulo.getString(5);

                    ModeloTabla3.addRow(fila2);
                }
            }





        } catch (SQLException ex) {
            Logger.getLogger(Compras.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSiguiente1ActionPerformed

    private void btnAnterior1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnterior1ActionPerformed
        try {
            vaciarTabla(3);
            Object fila2[] = new Object[5];
            ResultSet resultado_articulo_primer, resultado_articulo;
            if (Resultado_Encabezado_Eliminar.previous()) {
                FolioEliminar.setText(Resultado_Encabezado_Eliminar.getString(1));
                ProveedorEliminar.setText(Resultado_Encabezado_Eliminar.getString(2));
                FechaEliminar.setText(Resultado_Encabezado_Eliminar.getString(3) + "/" + Resultado_Encabezado_Eliminar.getString(4) + "/" + Resultado_Encabezado_Eliminar.getString(5));
                TotalEliminar.setText(Resultado_Encabezado_Eliminar.getString(6));
                resultado_articulo_primer = conexion.consultar(3, "*", "Folio_C", FolioEliminar.getText(), 2);

                while (resultado_articulo_primer.next()) {
                    fila2[0] = resultado_articulo_primer.getString(2);
                    fila2[3] = resultado_articulo_primer.getString(3);
                    fila2[4] = resultado_articulo_primer.getString(4);
                    resultado_articulo = conexion3.consultar(1, "*", "Clave_A", String.valueOf(fila2[0]));
                    resultado_articulo.first();
                    fila2[1] = resultado_articulo.getString(2);

                    fila2[2] = resultado_articulo.getString(5);

                    ModeloTabla3.addRow(fila2);
                }

            } else {
                Resultado_Encabezado_Eliminar.first();
                FolioEliminar.setText(Resultado_Encabezado_Eliminar.getString(1));
                ProveedorEliminar.setText(Resultado_Encabezado_Eliminar.getString(2));
                FechaEliminar.setText(Resultado_Encabezado_Eliminar.getString(3) + "/" + Resultado_Encabezado_Eliminar.getString(4) + "/" + Resultado_Encabezado_Eliminar.getString(5));
                TotalEliminar.setText(Resultado_Encabezado_Eliminar.getString(6));
                resultado_articulo_primer = conexion.consultar(3, "*", "Folio_C", FolioEliminar.getText(), 2);

                while (resultado_articulo_primer.next()) {
                    fila2[0] = resultado_articulo_primer.getString(2);
                    fila2[3] = resultado_articulo_primer.getString(3);
                    fila2[4] = resultado_articulo_primer.getString(4);
                    resultado_articulo = conexion3.consultar(1, "*", "Clave_A", String.valueOf(fila2[0]));
                    resultado_articulo.first();
                    fila2[1] = resultado_articulo.getString(2);

                    fila2[2] = resultado_articulo.getString(5);

                    ModeloTabla3.addRow(fila2);
                }
            }





        } catch (SQLException ex) {
            Logger.getLogger(Compras.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAnterior1ActionPerformed

    private void btnUltimo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUltimo1ActionPerformed
        try {
            vaciarTabla(3);
            Object fila2[] = new Object[5];
            ResultSet resultado_articulo_primer, resultado_articulo;
            ResultSet Resultado_Encabezado = conexion.consultar(2);
            if (Resultado_Encabezado.last()) {

                FolioEliminar.setText(Resultado_Encabezado.getString(1));
                ProveedorEliminar.setText(Resultado_Encabezado.getString(2));
                FechaEliminar.setText(Resultado_Encabezado.getString(3) + "/" + Resultado_Encabezado.getString(4) + "/" + Resultado_Encabezado.getString(5));
                TotalEliminar.setText(Resultado_Encabezado.getString(6));
                resultado_articulo_primer = conexion.consultar(3, "*", "Folio_C", FolioEliminar.getText(), 2);

                while (resultado_articulo_primer.next()) {
                    fila2[0] = resultado_articulo_primer.getString(2);
                    fila2[3] = resultado_articulo_primer.getString(3);
                    fila2[4] = resultado_articulo_primer.getString(4);
                    resultado_articulo = conexion3.consultar(1, "*", "Clave_A", String.valueOf(fila2[0]));
                    resultado_articulo.first();
                    fila2[1] = resultado_articulo.getString(2);

                    fila2[2] = resultado_articulo.getString(5);

                    ModeloTabla3.addRow(fila2);
                }
            }





        } catch (SQLException ex) {
            Logger.getLogger(Compras.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUltimo1ActionPerformed
    private void estableceFolio() {
        Calendar fecha = Calendar.getInstance();

        int n1 = (int) (Math.round(Math.random() * (9 - 0) + 0.01));
        int n2 = (int) (Math.round(Math.random() * (9 - 0) + 0.01));
        int n3 = (int) (Math.round(Math.random() * (9 - 0) + 0.01));
        int n4 = (int) (Math.round(Math.random() * (9 - 0) + 0.01));
        int n5 = (int) (Math.round(Math.random() * (9 - 0) + 0.01));
        int n6 = (int) (Math.round(Math.random() * (9 - 0) + 0.01));
        int n7 = (int) (Math.round(Math.random() * (9 - 0) + 0.01));
        int n8 = (int) (Math.round(Math.random() * (9 - 0) + 0.01));
        int n9 = (int) (Math.round(Math.random() * (9 - 0) + 0.01));
        int n10 = (int) (Math.round(Math.random() * (9 - 0) + 0.01));
        Folio.setText(String.valueOf(n1) + String.valueOf(n2) + String.valueOf(n3) + String.valueOf(n4) + String.valueOf(n5) + String.valueOf(n6) + String.valueOf(n7) + String.valueOf(n8) + String.valueOf(n9) + String.valueOf(n10));

    }

    private void estableceListaTipos() {
        try {
            resultado = conexion.consultar(1, "Tipo_A");
            ListaTipo.addItem(" ");
            while (resultado.next()) {
                ListaTipo.addItem(resultado.getString(1));
            }
            ListaTipo.addItem("Otro...");

        } catch (SQLException ex) {
            Logger.getLogger(Compras.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void limpiarTabla(int Tabla) {
        switch (Tabla) {
            case 1:
                for (int i = 0; i < TablaNuevaCompra.getRowCount(); i++) {
                    TablaNuevaCompra.setValueAt("", i, 0);
                    TablaNuevaCompra.setValueAt("", i, 1);
                    TablaNuevaCompra.setValueAt("", i, 2);
                    TablaNuevaCompra.setValueAt("", i, 3);
                    TablaNuevaCompra.setValueAt("", i, 4);
                    TablaNuevaCompra.setValueAt("", i, 5);

                }
                break;
            default:
                throw new AssertionError();
        }


    }

    private void rellenaProveedores() {
        try {
            resultado = conexion.consultar(6);
            Autocompletar1.addItem(" ");
            while (resultado.next()) {
                Autocompletar1.addItem(resultado.getString(1) + "-" + resultado.getString(2));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Compras.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void llenarTabla(int tabla) {
        ContadorLlenadoTabla += 1;//contador de las veces que es utilizado este metodo
        try {



            switch (tabla) {//Se hace la comparacion de la tabla a llenar
                case 1:
                    ResultadoTabla = conexion.consultar(7);//Se invoca al metodo Eliminar generico para obtener todos los articulos de la tabla
                    while (ResultadoTabla.next()) {//Se itera con el Objeto tipo ResulSet
                        //Se guarda en un arreglo los elementos del registro en la tabla para despues ser agregados como una fila
                        fila_cuentas_pagar[0] = ResultadoTabla.getString(1);
                        fila_cuentas_pagar[1] = ResultadoTabla.getString(2);
                        fila_cuentas_pagar[2] = ResultadoTabla.getString(3);
                        fila_cuentas_pagar[3] = ResultadoTabla.getString(4);

                        //Se agrega la fila a la tabla, mandandole como parametro el arreglo asignado anteriormente
                        ModeloTabla1.addRow(fila_cuentas_pagar);

                    }
                    //Se revalidan los elementos que se renovaron
                    TablaCuentasPorPagar.revalidate();

                    break;
                case 2://llenar tablas de eliminar
                    Object fila[] = new Object[6];
                    Object fila2[] = new Object[5];
                    ResultSet resultado_encabezado_compra,
                     resultado_articulo_primer,
                     resultado_articulo;
                    try {
                        resultado_encabezado_compra = conexion.consultar(2);
                        if (resultado_encabezado_compra.next()) {

                            fila[0] = resultado_encabezado_compra.getString(1);
                            fila[1] = resultado_encabezado_compra.getString(2);
                            fila[2] = resultado_encabezado_compra.getString(3);
                            fila[3] = resultado_encabezado_compra.getString(4);
                            fila[4] = resultado_encabezado_compra.getString(5);
                            fila[5] = resultado_encabezado_compra.getString(6);
                            FolioEliminar.setText((String) fila[0]);
                            ProveedorEliminar.setText((String) fila[1]);
                            FechaEliminar.setText((String) fila[2] + "/" + (String) fila[3] + "/" + (String) fila[4]);
                            TotalEliminar.setText((String) fila[5]);

                        }
                        resultado_articulo_primer = conexion.consultar(3, "*", "Folio_C", FolioEliminar.getText(), 2);

                        while (resultado_articulo_primer.next()) {
                            fila2[0] = resultado_articulo_primer.getString(2);
                            fila2[3] = resultado_articulo_primer.getString(3);
                            fila2[4] = resultado_articulo_primer.getString(4);
                            resultado_articulo = conexion3.consultar(1, "*", "Clave_A", String.valueOf(fila2[0]));
                            resultado_articulo.first();
                            fila2[1] = resultado_articulo.getString(2);

                            fila2[2] = resultado_articulo.getString(5);

                            ModeloTabla3.addRow(fila2);
                        }

                    } catch (SQLException ex) {
                        Logger.getLogger(Compras.class.getName()).log(Level.SEVERE, null, ex);
                    }



                    break;
                case 3://Llenar tabla de consultas
                    Object fila_Consulta[] = new Object[6];
                    Object fila2_Consulta[] = new Object[5];
                    ResultSet resultado_encabezado_compra_consulta,
                     resultado_articulo_primer_consulta,
                     resultado_articulo_consulta;
                    try {
                        resultado_encabezado_compra_consulta = conexion.consultar(2);
                        if (resultado_encabezado_compra_consulta.next()) {

                            fila_Consulta[0] = resultado_encabezado_compra_consulta.getString(1);
                            fila_Consulta[1] = resultado_encabezado_compra_consulta.getString(2);
                            fila_Consulta[2] = resultado_encabezado_compra_consulta.getString(3);
                            fila_Consulta[3] = resultado_encabezado_compra_consulta.getString(4);
                            fila_Consulta[4] = resultado_encabezado_compra_consulta.getString(5);
                            fila_Consulta[5] = resultado_encabezado_compra_consulta.getString(6);
                            FolioConsultar.setText((String) fila_Consulta[0]);
                            ProveedorConsultar.setText((String) fila_Consulta[1]);
                            FechaConsultar.setText((String) fila_Consulta[2] + "/" + (String) fila_Consulta[3] + "/" + (String) fila_Consulta[4]);
                            TotalConsultar.setText((String) fila_Consulta[5]);

                        }
                        resultado_articulo_primer_consulta = conexion.consultar(3, "*", "Folio_C", FolioConsultar.getText(), 2);

                        while (resultado_articulo_primer_consulta.next()) {
                            fila2_Consulta[0] = resultado_articulo_primer_consulta.getString(2);
                            fila2_Consulta[3] = resultado_articulo_primer_consulta.getString(3);
                            fila2_Consulta[4] = resultado_articulo_primer_consulta.getString(4);
                            resultado_articulo_consulta = conexion3.consultar(1, "*", "Clave_A", String.valueOf(fila2_Consulta[0]));
                            resultado_articulo_consulta.first();
                            fila2_Consulta[1] = resultado_articulo_consulta.getString(2);

                            fila2_Consulta[2] = resultado_articulo_consulta.getString(5);

                            ModeloTabla4.addRow(fila2_Consulta);
                        }

                    } catch (SQLException ex) {
                        Logger.getLogger(Compras.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    break;

                default:
                    throw new AssertionError();
            }



        } catch (SQLException ex) {
            Logger.getLogger(Almacen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void vaciarTabla(int tabla) {
        switch (tabla) {
            case 1:
                for (int i = TablaCuentasPorPagar.getRowCount() - 1; i >= 0; i--) {//Se itera desde el ultimo elemento hasta el primero
                    //Se puede hacer al reves pero asi lo kise hcer XD
                    //Se elimina la fila
                    ModeloTabla1.removeRow(i);

                }
                break;
            case 2:
                for (int i = TablaConsultarCompras.getRowCount() - 1; i >= 0; i--) {//Se itera desde el ultimo elemento hasta el primero
                    //Se puede hacer al reves pero asi lo kise hcer XD
                    //Se elimina la fila    
                    ModeloTabla4.removeRow(i);

                }
                break;
            case 3:
                for (int i = TablaEliminarCompras.getRowCount() - 1; i >= 0; i--) {//Se itera desde el ultimo elemento hasta el primero
                    //Se puede hacer al reves pero asi lo kise hcer XD
                    //Se elimina la fila    
                    ModeloTabla3.removeRow(i);

                }
                break;

            default:
                throw new AssertionError();
        }



    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox Autocompletar1;
    private javax.swing.JTextField CampoCantidad;
    private javax.swing.JTextField CampoClave;
    private javax.swing.JFormattedTextField CampoCosto;
    private javax.swing.JTextField CampoNombre;
    private javax.swing.JLabel FechaCompra;
    private javax.swing.JTextField FechaConsultar;
    private javax.swing.JTextField FechaEliminar;
    private javax.swing.JTextField Folio;
    private javax.swing.JTextField FolioConsultar;
    private javax.swing.JTextField FolioEliminar;
    private javax.swing.JTextField IDProveedor;
    private javax.swing.JComboBox ListaTipo;
    private javax.swing.JPanel PanelConsultarCompra;
    private javax.swing.JPanel PanelCuentasPorPagar;
    private javax.swing.JPanel PanelEliminarCompra;
    private javax.swing.JPanel PanelNuevaCompra;
    private javax.swing.JTextField ProveedorConsultar;
    private javax.swing.JTextField ProveedorEliminar;
    private javax.swing.JTable TablaConsultarCompras;
    private javax.swing.JTable TablaCuentasPorPagar;
    private javax.swing.JTable TablaEliminarCompras;
    private javax.swing.JTable TablaNuevaCompra;
    private javax.swing.JTextField Total;
    private javax.swing.JTextField TotalConsultar;
    private javax.swing.JTextField TotalEliminar;
    private javax.swing.JButton botonAñadir;
    private javax.swing.JButton botonCancelar1;
    private javax.swing.JButton botonCerrar;
    private javax.swing.JButton botonGuardar1;
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnAnterior1;
    private javax.swing.JButton btnEliminarCompra;
    private javax.swing.JButton btnGuardarAbono;
    private javax.swing.JButton btnPrimero;
    private javax.swing.JButton btnPrimero1;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JButton btnSiguiente1;
    private javax.swing.JButton btnUltimo;
    private javax.swing.JButton btnUltimo1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblClave;
    private javax.swing.JLabel lblCosto;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblFolioC;
    private javax.swing.JLabel lblIDProveedor;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JRadioButton opContado;
    private javax.swing.JRadioButton opCredito;
    private javax.swing.JFormattedTextField txtAbono;
    private javax.swing.JTextField txtFecha;
    // End of variables declaration//GEN-END:variables
}
