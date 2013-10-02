package frames;

import conexiones.Conexion;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import utilidades.Fecha;
import utilidades.IconCellRenderer;

public class Almacen extends javax.swing.JDialog {

    ResultSet resultado, ResultadoTabla;//Variables utilizadas para instanciar los objetos de la clase Resulset para manejar los resultados de las consultas
    Conexion conexion;//Variable utilizada para instanciar el objeto de la clase Conexion, que nos da la pauta para manejar la conexión con la base de datos
    String RenglonRegistro[];//Arreglo de tipo String que sirve para obtener y almacenar temporalmente los resultados de la consulta a la tabla en la Base de Datos
    private DefaultTableModel ModeloTabla1, ModeloTabla2;// Variable utilizada para instanciar un objeto de la clase DefaultTableModel que nos ayuda a cambiar el modelo de la tabla
    Object fila[];//Arreglo de tipo Object que nos servira para agregar una nueva fila
    private int ContadorLlenadoTabla;//Esta en una variable global que se utiliza para auxiliar en llevar la cuenta de cuantas veces se manda llamar al metodo llenarTabla()
    private int Tipo_Busqueda_1, Tipo_Busqueda_2;//Variables utilizadas para elegir el tipo de busqueda que se hara
    private boolean bandera_tecla_abajo, bandera_tecla_abajo2; //Banderas utilizadas para comparar si en el campo de busqueda se presiona la tecla Arriba o Abajo del teclado, las cuales le cambian el foco al la lista desplegable
    DefaultTableCellRenderer Renderizado_Celdas_Tabla_Centro, Renderizado_Celdas_Tabla_Derecha;//Variables de instancia utilizadas para los objetos tipo DefaultTableCellRender que son utilizados para alinear los elementos en las tablas
//    private boolean Primer_Caracter_Busqueda;
    /*
     * El siguiente metodos es el constructor utilizado para la inicializacion
     * de componentes y la generacion de las conexiones
     */

    public Almacen(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        //Se inician todos los componentes graficos y se le asigna un icono a esta ventana
        initComponents();
        this.setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(getClass().getResource("/imagenes/icono-proyecto.png")).getImage());


        //--------------------
        //Se hace la conexion con la base de datos mediante la clase Conexion
        conexion = new Conexion();
        conexion.conectarMySQL();
        //-----------------------

        //Se asigna el foco a la caja de texto de buscar para cuando se carga la ventana
        caracteristicaBuscar.requestFocus();
        //----------------------------------

        //Se esconden algunos componentes que seran visibles solo si se activan las funciones de modificar o consultar
        PanelCamposModificar.setVisible(false);
        Autocompletar.setVisible(false);
        Autocompletar2.setVisible(false);
        lblMensajes.setVisible(false);
        botonGuardar.setVisible(false);
        botonCancelar.setVisible(false);
        //--------------------------------------

        //Se inicializa el tipo de busqueda por defecto
        TipoBusquedaNombre1.setSelected(true);
        TipoBusquedaNombre2.setSelected(true);
        //Se establece la fecha en el label destinado para desplegar la fecha-----------
        lblFecha.setText(Fecha.getDia() + "-" + Fecha.getMes() + "-" + Fecha.getAño());
        //------------------------------------------------------------------------------

        //Arreglos utilizados para agregar nuevos elementos a la lista desplegable de la busqueda sensible
        RenglonRegistro = new String[6];
        //------------------------------------------------------------------------------------------------

        /*
         * Las siguientes lineas se utilizan para modificar el modelo de las
         * tablas utilizadas para desplegar los datos, utilizando la clase
         * DefaultTableModel y la clase IconCellRender (contenida en el paquete
         * utilidades), generando dinamicamente las filas, para asi manejar mas
         * de 100 filas en la tabla si es que esta asi lo requiere
         */
        TablaArticulosModificar.setDefaultRenderer(Object.class, new IconCellRenderer());
        TablaArticulosBorrar.setDefaultRenderer(Object.class, new IconCellRenderer());
        fila = new Object[6]; //Inicializacion del arreglo que contendra las filas
        ModeloTabla1 = (DefaultTableModel) TablaArticulosModificar.getModel();
        ModeloTabla2 = (DefaultTableModel) TablaArticulosBorrar.getModel();
        //------------------------------------------------------------------------------

        //Alineacion de Celdas--------------------------------------------------------------------------------
        Renderizado_Celdas_Tabla_Centro = new DefaultTableCellRenderer();
        Renderizado_Celdas_Tabla_Derecha = new DefaultTableCellRenderer();
        Renderizado_Celdas_Tabla_Centro.setHorizontalAlignment(SwingConstants.CENTER);
        Renderizado_Celdas_Tabla_Derecha.setHorizontalAlignment(SwingConstants.RIGHT);
        TablaArticulosModificar.getColumnModel().getColumn(0).setCellRenderer(Renderizado_Celdas_Tabla_Centro);
        TablaArticulosModificar.getColumnModel().getColumn(3).setCellRenderer(Renderizado_Celdas_Tabla_Derecha);
        TablaArticulosModificar.getColumnModel().getColumn(4).setCellRenderer(Renderizado_Celdas_Tabla_Derecha);
        TablaArticulosModificar.getColumnModel().getColumn(5).setCellRenderer(Renderizado_Celdas_Tabla_Derecha);
        
        TablaArticulosBorrar.getColumnModel().getColumn(0).setCellRenderer(Renderizado_Celdas_Tabla_Centro);
        TablaArticulosBorrar.getColumnModel().getColumn(3).setCellRenderer(Renderizado_Celdas_Tabla_Derecha);
        TablaArticulosBorrar.getColumnModel().getColumn(4).setCellRenderer(Renderizado_Celdas_Tabla_Derecha);
        TablaArticulosBorrar.getColumnModel().getColumn(5).setCellRenderer(Renderizado_Celdas_Tabla_Derecha);
        //------------------------------------------------------------------------------------------------------

        ContadorLlenadoTabla = 0;//Se inicializa el contador a 0
        Tipo_Busqueda_1 = 1;//Variables Utilizadas para elegir el criterio de busqueda
        Tipo_Busqueda_2 = 1;
        //--Banderas utilizadas para evaluar si se presiona la tecla "Flecha hacia abajo" en la busqueda sensible 
        bandera_tecla_abajo = false;
        bandera_tecla_abajo2 = false;
        //------------------------------

        //Se invoca a estos metodos para rellenar las tablas (modificar y borrar) con todos los articulos de la base de datos
        llenarTabla(1);
        llenarTabla(2);
        //------------------------------
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TipoBusqueda1 = new javax.swing.ButtonGroup();
        TipoBusqueda2 = new javax.swing.ButtonGroup();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        botonCerrar = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        PanelModificar = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaArticulosModificar = new javax.swing.JTable();
        caracteristicaBuscar = new javax.swing.JTextField();
        botonGuardar = new javax.swing.JButton();
        botonModificar = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();
        lblBuscar = new javax.swing.JLabel();
        lblMensajes = new javax.swing.JLabel();
        PanelCamposModificar = new javax.swing.JPanel();
        campoNombre = new javax.swing.JTextField();
        campoTipo = new javax.swing.JTextField();
        campoExistencia = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        campoCosto = new javax.swing.JFormattedTextField();
        campoCosto2 = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        Autocompletar = new javax.swing.JComboBox();
        PanelTipoBusqueda1 = new javax.swing.JPanel();
        TipoBusquedaClave1 = new javax.swing.JRadioButton();
        TipoBusquedaTipo1 = new javax.swing.JRadioButton();
        TipoBusquedaNombre1 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        PanelBorrar = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        caracteristicaBuscar2 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaArticulosBorrar = new javax.swing.JTable();
        botonBorrar = new javax.swing.JButton();
        Autocompletar2 = new javax.swing.JComboBox();
        PanelTipoBusqueda = new javax.swing.JPanel();
        TipoBusquedaClave2 = new javax.swing.JRadioButton();
        TipoBusquedaTipo2 = new javax.swing.JRadioButton();
        TipoBusquedaNombre2 = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Almacén");
        setLocationByPlatform(true);
        setName("VentanaAlmacen");
        setResizable(false);
        setUndecorated(true);

        botonCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cerrar.png"))); // NOI18N
        botonCerrar.setToolTipText("Salir de Almacén");
        botonCerrar.setContentAreaFilled(false);
        botonCerrar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cerrar2.png"))); // NOI18N
        botonCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCerrarActionPerformed(evt);
            }
        });
        botonCerrar.setBounds(5, 5, 30, 30);
        jLayeredPane1.add(botonCerrar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTabbedPane1.setRequestFocusEnabled(false);

        PanelModificar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PanelModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        PanelModificar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        PanelModificar.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                PanelModificarComponentShown(evt);
            }
        });

        TablaArticulosModificar.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        TablaArticulosModificar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Clave", "Nombre", "Tipo", "Existencia", "Costo Compra", "Costo Venta"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaArticulosModificar.setToolTipText("Articulos existentes en la Base de Datos");
        TablaArticulosModificar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TablaArticulosModificarKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(TablaArticulosModificar);
        TablaArticulosModificar.getColumnModel().getColumn(0).setMinWidth(75);
        TablaArticulosModificar.getColumnModel().getColumn(0).setPreferredWidth(75);
        TablaArticulosModificar.getColumnModel().getColumn(0).setMaxWidth(75);
        TablaArticulosModificar.getColumnModel().getColumn(1).setMinWidth(205);
        TablaArticulosModificar.getColumnModel().getColumn(1).setPreferredWidth(205);
        TablaArticulosModificar.getColumnModel().getColumn(1).setMaxWidth(205);
        TablaArticulosModificar.getColumnModel().getColumn(2).setMinWidth(135);
        TablaArticulosModificar.getColumnModel().getColumn(2).setPreferredWidth(135);
        TablaArticulosModificar.getColumnModel().getColumn(2).setMaxWidth(135);
        TablaArticulosModificar.getColumnModel().getColumn(3).setMinWidth(65);
        TablaArticulosModificar.getColumnModel().getColumn(3).setPreferredWidth(65);
        TablaArticulosModificar.getColumnModel().getColumn(3).setMaxWidth(65);
        TablaArticulosModificar.getColumnModel().getColumn(4).setMinWidth(85);
        TablaArticulosModificar.getColumnModel().getColumn(4).setPreferredWidth(85);
        TablaArticulosModificar.getColumnModel().getColumn(4).setMaxWidth(85);
        TablaArticulosModificar.getColumnModel().getColumn(5).setMinWidth(80);
        TablaArticulosModificar.getColumnModel().getColumn(5).setPreferredWidth(80);
        TablaArticulosModificar.getColumnModel().getColumn(5).setMaxWidth(80);

        caracteristicaBuscar.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        caracteristicaBuscar.setToolTipText("Ingrese algún dato para buscar un Articulo");
        caracteristicaBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                caracteristicaBuscarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                caracteristicaBuscarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                caracteristicaBuscarKeyTyped(evt);
            }
        });

        botonGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar.png"))); // NOI18N
        botonGuardar.setText("Guardar Modificaciones");
        botonGuardar.setToolTipText("Presiona para guardar los cambios en el artículo");
        botonGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonGuardar.setMaximumSize(new java.awt.Dimension(125, 45));
        botonGuardar.setMinimumSize(new java.awt.Dimension(125, 45));
        botonGuardar.setPreferredSize(new java.awt.Dimension(125, 45));
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });
        botonGuardar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                botonGuardarKeyPressed(evt);
            }
        });

        botonModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/editar.png"))); // NOI18N
        botonModificar.setText("Modificar Artículo Seleccionado");
        botonModificar.setToolTipText("Presiona para modificar el artículo seleccionado");
        botonModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarActionPerformed(evt);
            }
        });
        botonModificar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                botonModificarKeyPressed(evt);
            }
        });

        botonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancelar.png"))); // NOI18N
        botonCancelar.setText("Cancelar Modificación");
        botonCancelar.setToolTipText("Presiona para cancelar ");
        botonCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });
        botonCancelar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                botonCancelarKeyPressed(evt);
            }
        });

        lblBuscar.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        lblBuscar.setText("Buscar:");

        lblMensajes.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblMensajes.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        PanelCamposModificar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PanelCamposModificar.setPreferredSize(new java.awt.Dimension(424, 45));

        campoNombre.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        campoNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoNombre.setToolTipText("Introduce el nuevo Nombre");
        campoNombre.setName("");
        campoNombre.setPreferredSize(new java.awt.Dimension(72, 22));
        campoNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNombreActionPerformed(evt);
            }
        });
        campoNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoNombreFocusLost(evt);
            }
        });
        campoNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoNombreKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoNombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoNombreKeyTyped(evt);
            }
        });

        campoTipo.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        campoTipo.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        campoTipo.setPreferredSize(new java.awt.Dimension(72, 22));
        campoTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoTipoActionPerformed(evt);
            }
        });
        campoTipo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoTipoFocusLost(evt);
            }
        });
        campoTipo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoTipoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoTipoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoTipoKeyTyped(evt);
            }
        });

        campoExistencia.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        campoExistencia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoExistencia.setToolTipText("Introduce el nuevo nuemro de articulos");
        campoExistencia.setPreferredSize(new java.awt.Dimension(72, 22));
        campoExistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoExistenciaActionPerformed(evt);
            }
        });
        campoExistencia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoExistenciaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoExistenciaKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel3.setText("Nuevo Nombre");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel4.setText("Nuevo Tipo");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel5.setText("Existencia");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel6.setText("Costo_C");

        campoCosto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("##0.00"))));
        campoCosto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoCosto.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        campoCosto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoCostoActionPerformed(evt);
            }
        });
        campoCosto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoCostoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoCostoKeyTyped(evt);
            }
        });

        campoCosto2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("##0.00"))));
        campoCosto2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoCosto2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        campoCosto2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoCosto2ActionPerformed(evt);
            }
        });
        campoCosto2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoCosto2KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoCosto2KeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel8.setText("Costo_V");

        javax.swing.GroupLayout PanelCamposModificarLayout = new javax.swing.GroupLayout(PanelCamposModificar);
        PanelCamposModificar.setLayout(PanelCamposModificarLayout);
        PanelCamposModificarLayout.setHorizontalGroup(
            PanelCamposModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCamposModificarLayout.createSequentialGroup()
                .addGroup(PanelCamposModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelCamposModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelCamposModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(campoExistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelCamposModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoCosto)
                    .addGroup(PanelCamposModificarLayout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 12, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelCamposModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8)
                    .addComponent(campoCosto2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        PanelCamposModificarLayout.setVerticalGroup(
            PanelCamposModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCamposModificarLayout.createSequentialGroup()
                .addGroup(PanelCamposModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelCamposModificarLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(PanelCamposModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelCamposModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoExistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoCosto)
                    .addComponent(campoCosto2))
                .addGap(19, 19, 19))
        );

        Autocompletar.setToolTipText("Selecciona un elemento");
        Autocompletar.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                AutocompletarItemStateChanged(evt);
            }
        });
        Autocompletar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                AutocompletarKeyPressed(evt);
            }
        });

        PanelTipoBusqueda1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        TipoBusqueda1.add(TipoBusquedaClave1);
        TipoBusquedaClave1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        TipoBusquedaClave1.setText("Clave");
        TipoBusquedaClave1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TipoBusquedaClave1ActionPerformed(evt);
            }
        });

        TipoBusqueda1.add(TipoBusquedaTipo1);
        TipoBusquedaTipo1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        TipoBusquedaTipo1.setText("Tipo");
        TipoBusquedaTipo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TipoBusquedaTipo1ActionPerformed(evt);
            }
        });

        TipoBusqueda1.add(TipoBusquedaNombre1);
        TipoBusquedaNombre1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        TipoBusquedaNombre1.setText("Nombre");
        TipoBusquedaNombre1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TipoBusquedaNombre1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelTipoBusqueda1Layout = new javax.swing.GroupLayout(PanelTipoBusqueda1);
        PanelTipoBusqueda1.setLayout(PanelTipoBusqueda1Layout);
        PanelTipoBusqueda1Layout.setHorizontalGroup(
            PanelTipoBusqueda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTipoBusqueda1Layout.createSequentialGroup()
                .addComponent(TipoBusquedaNombre1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TipoBusquedaClave1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TipoBusquedaTipo1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelTipoBusqueda1Layout.setVerticalGroup(
            PanelTipoBusqueda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTipoBusqueda1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(PanelTipoBusqueda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TipoBusquedaClave1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, Short.MAX_VALUE)
                    .addComponent(TipoBusquedaNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(TipoBusquedaTipo1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel1.setText("Característica:");

        javax.swing.GroupLayout PanelModificarLayout = new javax.swing.GroupLayout(PanelModificar);
        PanelModificar.setLayout(PanelModificarLayout);
        PanelModificarLayout.setHorizontalGroup(
            PanelModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelModificarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelModificarLayout.createSequentialGroup()
                        .addComponent(lblBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelModificarLayout.createSequentialGroup()
                                .addComponent(caracteristicaBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PanelTipoBusqueda1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(PanelModificarLayout.createSequentialGroup()
                                .addComponent(Autocompletar, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(lblMensajes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PanelModificarLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botonCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelModificarLayout.createSequentialGroup()
                        .addComponent(PanelCamposModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 642, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jScrollPane1)
        );
        PanelModificarLayout.setVerticalGroup(
            PanelModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelModificarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblBuscar)
                        .addComponent(caracteristicaBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(PanelTipoBusqueda1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Autocompletar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMensajes, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelCamposModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(botonModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(botonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Modificar ", new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconomodificar.png")), PanelModificar, "Opcion de Modificar un Articulo"); // NOI18N

        PanelBorrar.setBackground(new java.awt.Color(255, 255, 255));
        PanelBorrar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PanelBorrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        PanelBorrar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        PanelBorrar.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                PanelBorrarComponentShown(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(226, 226, 226));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel2.setText("Buscar:");

        caracteristicaBuscar2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        caracteristicaBuscar2.setToolTipText("Ingrese algún dato para buscar un Articulo");
        caracteristicaBuscar2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                caracteristicaBuscar2KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                caracteristicaBuscar2KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                caracteristicaBuscar2KeyTyped(evt);
            }
        });

        TablaArticulosBorrar.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        TablaArticulosBorrar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Clave", "Nombre", "Tipo", "Existencia", "Costo Compra", "Costo Venta"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaArticulosBorrar.setToolTipText("Artículos en Almacén");
        TablaArticulosBorrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TablaArticulosBorrarKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(TablaArticulosBorrar);
        TablaArticulosBorrar.getColumnModel().getColumn(0).setMinWidth(75);
        TablaArticulosBorrar.getColumnModel().getColumn(0).setPreferredWidth(75);
        TablaArticulosBorrar.getColumnModel().getColumn(0).setMaxWidth(75);
        TablaArticulosBorrar.getColumnModel().getColumn(1).setMinWidth(205);
        TablaArticulosBorrar.getColumnModel().getColumn(1).setPreferredWidth(205);
        TablaArticulosBorrar.getColumnModel().getColumn(1).setMaxWidth(205);
        TablaArticulosBorrar.getColumnModel().getColumn(2).setMinWidth(135);
        TablaArticulosBorrar.getColumnModel().getColumn(2).setPreferredWidth(135);
        TablaArticulosBorrar.getColumnModel().getColumn(2).setMaxWidth(135);
        TablaArticulosBorrar.getColumnModel().getColumn(3).setMinWidth(65);
        TablaArticulosBorrar.getColumnModel().getColumn(3).setPreferredWidth(65);
        TablaArticulosBorrar.getColumnModel().getColumn(3).setMaxWidth(65);
        TablaArticulosBorrar.getColumnModel().getColumn(4).setMinWidth(85);
        TablaArticulosBorrar.getColumnModel().getColumn(4).setPreferredWidth(85);
        TablaArticulosBorrar.getColumnModel().getColumn(4).setMaxWidth(85);
        TablaArticulosBorrar.getColumnModel().getColumn(5).setMinWidth(80);
        TablaArticulosBorrar.getColumnModel().getColumn(5).setPreferredWidth(80);
        TablaArticulosBorrar.getColumnModel().getColumn(5).setMaxWidth(80);

        botonBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar.png"))); // NOI18N
        botonBorrar.setText("Eliminar Artículo Seleccionado");
        botonBorrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBorrarActionPerformed(evt);
            }
        });
        botonBorrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                botonBorrarKeyPressed(evt);
            }
        });

        Autocompletar2.setToolTipText("Selecciona un Articulo");
        Autocompletar2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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

        PanelTipoBusqueda.setBackground(new java.awt.Color(255, 255, 255));
        PanelTipoBusqueda.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        TipoBusquedaClave2.setBackground(new java.awt.Color(255, 255, 255));
        TipoBusqueda2.add(TipoBusquedaClave2);
        TipoBusquedaClave2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        TipoBusquedaClave2.setText("Clave");
        TipoBusquedaClave2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TipoBusquedaClave2ActionPerformed(evt);
            }
        });

        TipoBusquedaTipo2.setBackground(new java.awt.Color(255, 255, 255));
        TipoBusqueda2.add(TipoBusquedaTipo2);
        TipoBusquedaTipo2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        TipoBusquedaTipo2.setText("Tipo");
        TipoBusquedaTipo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TipoBusquedaTipo2ActionPerformed(evt);
            }
        });

        TipoBusquedaNombre2.setBackground(new java.awt.Color(255, 255, 255));
        TipoBusqueda2.add(TipoBusquedaNombre2);
        TipoBusquedaNombre2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        TipoBusquedaNombre2.setText("Nombre");
        TipoBusquedaNombre2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TipoBusquedaNombre2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelTipoBusquedaLayout = new javax.swing.GroupLayout(PanelTipoBusqueda);
        PanelTipoBusqueda.setLayout(PanelTipoBusquedaLayout);
        PanelTipoBusquedaLayout.setHorizontalGroup(
            PanelTipoBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTipoBusquedaLayout.createSequentialGroup()
                .addComponent(TipoBusquedaNombre2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TipoBusquedaClave2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TipoBusquedaTipo2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelTipoBusquedaLayout.setVerticalGroup(
            PanelTipoBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTipoBusquedaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(PanelTipoBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TipoBusquedaClave2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, Short.MAX_VALUE)
                    .addComponent(TipoBusquedaNombre2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(TipoBusquedaTipo2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel7.setText("Característica:");

        javax.swing.GroupLayout PanelBorrarLayout = new javax.swing.GroupLayout(PanelBorrar);
        PanelBorrar.setLayout(PanelBorrarLayout);
        PanelBorrarLayout.setHorizontalGroup(
            PanelBorrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBorrarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelBorrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelBorrarLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelBorrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelBorrarLayout.createSequentialGroup()
                                .addComponent(Autocompletar2, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(PanelBorrarLayout.createSequentialGroup()
                                .addComponent(caracteristicaBuscar2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PanelTipoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelBorrarLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botonBorrar)))
                .addContainerGap())
            .addComponent(jScrollPane2)
        );
        PanelBorrarLayout.setVerticalGroup(
            PanelBorrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelBorrarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelBorrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelBorrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(caracteristicaBuscar2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addComponent(PanelTipoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Autocompletar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83))
        );

        jTabbedPane1.addTab("Eliminar", new javax.swing.ImageIcon(getClass().getResource("/imagenes/borrar.png")), PanelBorrar, "Opcion de Borrar un Articulo"); // NOI18N

        jTabbedPane1.setBounds(5, 40, 780, 470);
        jLayeredPane1.add(jTabbedPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jTabbedPane1.getAccessibleContext().setAccessibleName("Modificar Articulo");

        lblTitulo.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Almacén");
        lblTitulo.setBounds(380, 10, 80, 22);
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

    //metodo asociado con el evento que se acciona al cerrar la ventana
    private void botonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCerrarActionPerformed
        conexion.cerrarConexion();
        this.dispose();
    }//GEN-LAST:event_botonCerrarActionPerformed
    //metodo asociado con el evento que se acciona al presionar el botón de modificar
    private void botonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificarActionPerformed
        //Analiza si se ha seleccionado alguna fila en la tabla, de lo contrario despliega mensaje de advertencia
        if (TablaArticulosModificar.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Primero debes seleccionar un artículo de la tabla");

        } else {
            botonGuardar.setVisible(true);//Se hace visible el boton guardar para permitir guardar los cambios
            botonCancelar.setVisible(true);//Se hace visible el boton cancelar para permitir cancelar los cambios
            int filatabla = TablaArticulosModificar.getSelectedRow();//Se asigna a una variable el numero de fila que esta seleccionada
            mostrarPanelModificar(filatabla);//Se invoca al metodo que se encarga de visualizar el panel de los campos a modificar así como tambien llenarlos con los antiguos datos
        }
    }//GEN-LAST:event_botonModificarActionPerformed
//metodo asociado con el evento que se acciona al presionar el botón de cancelar
    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        //Se reestablecen los valores iniciales de todos los componentes

        lblMensajes.setVisible(false);
        campoCosto.setText("");
        campoExistencia.setText("");
        campoNombre.setText("");
        campoTipo.setText("");
        PanelCamposModificar.setVisible(false);
        caracteristicaBuscar.setText("");
        Autocompletar.setVisible(false);
        RenglonRegistro[0] = "";
        RenglonRegistro[1] = "";
        RenglonRegistro[2] = "";
        RenglonRegistro[3] = "";
        RenglonRegistro[4] = "";
        botonGuardar.setVisible(false);
        botonCancelar.setVisible(false);
        caracteristicaBuscar.requestFocus();

    }//GEN-LAST:event_botonCancelarActionPerformed
    //metodo asociado con el evento que se acciona al presionar el botón de borrar
    private void botonBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBorrarActionPerformed
        //Analiza si se ha seleccionado alguna fila en la tabla, de lo contrario despliega mensaje de advertencia
        if (TablaArticulosBorrar.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Primero debes seleccionar un artículo de la tabla");

        } else {

            int filatabla = TablaArticulosBorrar.getSelectedRow();//Se asigna a una variable el numero de fila que esta seleccionada
            int a = JOptionPane.showConfirmDialog(this, "¿Realmente desea eliminar este artículo?", "Advertencia", 0, 3);//Mensaje de confirmacion para borrar el articulo
            if (a == 0) { //si la opcion del usuario es si la variable "a" toma el valor de 0
                int existencia = Integer.parseInt(String.valueOf(TablaArticulosBorrar.getValueAt(filatabla, 3)));//Obtenemos el numero de articulos en existencia en almacen

                if (existencia == 0) {//Se compara si el numero de articulos es 0 para asegurarnos de que no se elimine si todavia hay en existencia
                    try {
                        //Se invoca al metodo eliminar
                        conexion.eliminar(1, String.valueOf(TablaArticulosBorrar.getValueAt(filatabla, 0)));
                        //Mensaje de Confirmación
                        JOptionPane.showMessageDialog(this, "Registro Borrado");
                        //Se invoca a estos dos metodos para actualizar la tabla, borrando y volviendo a rellenar las filas
                        vaciarTabla(2);
                        llenarTabla(2);

                        //Se devuelve el foco al campo de busquedas
                        caracteristicaBuscar2.requestFocus();

                    } catch (SQLException ex) {
                        Logger.getLogger(Almacen.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "No puedes borrarlo, todavía hay artculos en existencia", "Acción no válida", 2);
                    caracteristicaBuscar2.requestFocus();// Se devuelve el foco al campo de busquedas
                }
            }



        }
        //Se borra el contenido del arreglo 
        RenglonRegistro[0] = "";
        RenglonRegistro[1] = "";
        RenglonRegistro[2] = "";
        RenglonRegistro[3] = "";
        RenglonRegistro[4] = "";

    }//GEN-LAST:event_botonBorrarActionPerformed
//metodo asociado con el evento que se acciona al presionar una tecla en la caja de texto de buscar
    private void caracteristicaBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_caracteristicaBuscarKeyTyped
        //Se valida que lo que sea introducido solo sean numeros, letras o un espacio
        char c = evt.getKeyChar();
        if (!Character.isLetter(c) && !Character.isDigit(c)) {
            evt.consume();

        }
        else {
            if (caracteristicaBuscar.getText().length() > 49) {
                Toolkit.getDefaultToolkit().beep();
                evt.consume();
            }
        }
        //Se remueven todos los elementos de la lista que despliega los elementos de la busqueda, este metodo trabaja con el caracteristicaBuscarKeyRelease, para actualizar 
        //los elementos de la lista cada ves que se introduce un nuevo caracter
        Autocompletar.removeAllItems();
        bandera_tecla_abajo = false;

    }//GEN-LAST:event_caracteristicaBuscarKeyTyped
    //metodo asociado con el evento que se acciona al soltar una tecla en la caja de texto de buscar
    private void caracteristicaBuscar2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_caracteristicaBuscar2KeyReleased
        try {

            String contenido = (String) caracteristicaBuscar2.getText();//Se obtiene el texto de la caja de texto de la busqueda
            if (!contenido.equals("")) {//se compara que el contenido no sea nulo
                if (bandera_tecla_abajo2 == false) {//Se compara el valor de  esta bandera para sabeer si la tecla que se presiona no sean las de flecha arriba o abajo, para poder ejecutar lo siguiente 
                    
                    switch (Tipo_Busqueda_2) {//Se elige el criterio de busqueda: nombre-clave-tipo, mediante unos rabiobuttons
                        case 1:
                            resultado = conexion.consultar(1, "*", "Nombre_A", contenido);//Se hace la consulta (por ahora solo con la clave del producto)
                            if (resultado.first()) {//Se compara que el resultado no sea nulo(que exista el o los articulos buscados)
                                resultado.previous();
                                Autocompletar2.setVisible(true);//Se hace visible la lista desplegable (Jcombobox)
                                Autocompletar2.addItem(" ");//Se agrega un elemento vacio (Parche que evita que la seleccin por default sea un articulo, puesto que entraba en conflicto con el evento
                                while (resultado.next()) {//Se itera con el objeto resultado para obtener todos los valores que fueron encontrados con la consulta
                                    //Se asignan al Arreglo que contentra todos los elementos de la fila, los elementos de cada registro de la Tabla 

                                    RenglonRegistro[0] = resultado.getString(1);
                                    RenglonRegistro[1] = resultado.getString(2);
                                    RenglonRegistro[2] = resultado.getString(3);
                                    RenglonRegistro[3] = resultado.getString(4);
                                    RenglonRegistro[4] = resultado.getString(5);
                                    //Se agrega el elemento a la lista desplegable NOTA: se agregan "-" para despues poder separar los elementos cuando se selecciona un elemento de la lista
                                    Autocompletar2.addItem(RenglonRegistro[0] + "  -  " + RenglonRegistro[1] + "  -  " + RenglonRegistro[2] + "  -  " + RenglonRegistro[3] + "  -  " + RenglonRegistro[4]);

                                }
                               
                                Autocompletar2.showPopup();//Se muestra la lista desplegable
                                resultado = null;
                            }//
                            else {
                                //Si en la consulta, no se encuentran registros se remueven todos los elementos contenidos anteriormente, se esconde la lista  y se hace invisible
                                Autocompletar2.removeAllItems();
                                Autocompletar2.hidePopup();
                                Autocompletar2.setVisible(false);
                            }
                            break;
                        case 2:
                            resultado = conexion.consultar(1, "*", "Clave_A", contenido);
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
                                resultado = null;

                            } else {
                                 //Si en la consulta, no se encuentran registros se remueven todos los elementos contenidos anteriormente, se esconde la lista  y se hace invisible
                                Autocompletar.removeAllItems();
                                Autocompletar2.hidePopup();
                                Autocompletar2.setVisible(false);
                            }
                            break;
                        case 3:
                            resultado = conexion.consultar(1, "*", "Tipo_A", contenido);
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
                                resultado = null;

                            } else {
                                 //Si en la consulta, no se encuentran registros se remueven todos los elementos contenidos anteriormente, se esconde la lista  y se hace invisible
                                Autocompletar2.removeAllItems();
                                Autocompletar2.hidePopup();
                                Autocompletar2.setVisible(false);
                            }
                            break;
                        default:
                            JOptionPane.showMessageDialog(this, "Tipo incorreco de búsqueda");
                            break;
                    }

                } else {
                    //Si las teclas flecha arriba y abajo son presionadas, se pasa el foco a la lista desplegable y se muestra el contenido, para permitir que se seleccione algun elemento y se pueda desplazar mediante estas teclas
                    Autocompletar2.requestFocus();
                    Autocompletar2.setSelectedIndex(0);
                    Autocompletar2.showPopup();
                }

                //
            } else {// De lo contrario se oculta la lista desplegable (popup)

                Autocompletar2.hidePopup();
                Autocompletar2.setVisible(false);
            }


        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al conectar con MySQL");

        }
    }//GEN-LAST:event_caracteristicaBuscar2KeyReleased
//metodo asociado con el evento que se acciona al presionar una tecla en la caja de texto de buscar
    private void caracteristicaBuscar2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_caracteristicaBuscar2KeyTyped
        //Se valida que lo que sea introducido solo sean numeros y letras
        char c = evt.getKeyChar();
        if (Character.isLetter(c) == false && Character.isDigit(c) == false) {
            evt.consume();

        }
          else {
            if (caracteristicaBuscar2.getText().length() > 49) {
                Toolkit.getDefaultToolkit().beep();
                evt.consume();
            }
        }
        //Se remueven todos los elementos de la lista que despliega los elementos de la busqueda, este metodo trabaja con el caracteristicaBuscar2KeyRelease, para actualizar 
        //los elementos de la lista cada ves que se introduce un nuevo caracter
        Autocompletar2.removeAllItems();
        bandera_tecla_abajo2 = false;
    }//GEN-LAST:event_caracteristicaBuscar2KeyTyped
    //metodo asociado con el evento que se acciona al cambiar o seleccionar un elemento de la lista
    private void Autocompletar2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_Autocompletar2ItemStateChanged
        int ElementoSeleccionado = Autocompletar2.getSelectedIndex();//Se obtiene el elemento seleccionado en la lista NOTA: por default es el primero, por eso se agraga un espacion en blanco
        if (ElementoSeleccionado != -1 && bandera_tecla_abajo2 == false) {//Se hace la comparacion de que el item seleccionado no sea ni el primero o si este no se ha presionado, puesto que este evento tambien se acciona al agregar un nuevo item
            String Registro = (String) Autocompletar2.getSelectedItem(); //Se obtiene el elemento (String) seleccionado  de la lista desplegable
            String RegistroSeleccionado[] = Registro.split("-"); //Se separa por los guiones 
            for (int i = 0; i < RegistroSeleccionado.length; i++) {
                RegistroSeleccionado[i] = RegistroSeleccionado[i].trim();

            }
            for (int i = 0; i < TablaArticulosBorrar.getRowCount(); i++) {//Se recorre toda la tabla para encontrar el articulo y asi seleccionarlo,
                //esto ayuda cuando se tiene mas elementos y no se pueden presentar todos dentro de los primeros elementos de la lista

                if (String.valueOf(TablaArticulosBorrar.getValueAt(i, 0)).equals(RegistroSeleccionado[0])) {//Se hace la comparacion del elemento con lo que hay en la lista
                    //Si si, se selecciona automaticamente la fila, indicando el articulo que se encuentra

                    TablaArticulosBorrar.setRowSelectionInterval(i, i);

                    int fila_a_desplegar = (i * 16) + 1;
                    Point punto = new Point(0, fila_a_desplegar);
                    jScrollPane2.getViewport().setViewPosition(punto);
                    botonBorrar.requestFocus();
                    Autocompletar2.setVisible(false);//Se oculta la lista desplegable
                    caracteristicaBuscar2.setText("");//Se borra el texto de busqueda
                    break;
                }
            }

        }
    }//GEN-LAST:event_Autocompletar2ItemStateChanged

//metodo asociado con el evento que se acciona al introducir valores al campo
    //valida que sean solo numeros
    private void campoExistenciaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoExistenciaKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
        else {
            if ( campoExistencia.getText().length() > 5) {
                Toolkit.getDefaultToolkit().beep();
                 evt.consume();
            }
        }
    }//GEN-LAST:event_campoExistenciaKeyTyped
//metodo asociado con el evento que se acciona al presionar el botón de guardar
    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        int filatabla = TablaArticulosModificar.getSelectedRow();//Se obtiene el numero de la fila seleccionada
        //Se guardan los valores del articulo en un arreglo que se enviara como parametro al metodo de insertar, NOTA: la clave se obtiene de la tabla, ya que esta no se permite modificar
        String ValoresRegistro[] = {String.valueOf(TablaArticulosModificar.getValueAt(filatabla, 0)), campoNombre.getText(), campoTipo.getText(), campoExistencia.getText(), campoCosto.getText(),campoCosto2.getText()};
        try {
            //Confirma si se desea guardar el elemento
            int a = JOptionPane.showConfirmDialog(this, "¿Realmente desea Modificar este artículo?", "Guardar Modificaciones", 0, 3);
            if (a == 0) {//Si el usuario presiona OK
                //Se invoca al metodo insertar mandando como parametros: numero de tabla, los valores almacenados en el arreglo
                conexion.modificar(1, ValoresRegistro, String.valueOf(TablaArticulosModificar.getValueAt(filatabla, 0)));
                JOptionPane.showMessageDialog(this, "Articulo Modificado");//Mensaje de confirmacion
                //Se Establecen los valores iniciales

                PanelCamposModificar.setVisible(false);
                caracteristicaBuscar.setText("");
                lblMensajes.setVisible(false);
                botonGuardar.setVisible(false);
                botonCancelar.setVisible(false);
                Autocompletar.setVisible(false);

                //Se invocan los siguientes metodos para refrescar la tabla
                vaciarTabla(1);
                llenarTabla(1);
                //Se devuele el foco al campo de buscar
                caracteristicaBuscar.requestFocus();
            }


        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al guardar los cambios al artículo");
            Logger.getLogger(Almacen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botonGuardarActionPerformed
    //metodo asociado con el evento que se acciona al suelta una tecla en la caja de texto de buscar
    private void caracteristicaBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_caracteristicaBuscarKeyReleased
        try {

            String contenido = (String) caracteristicaBuscar.getText();//Se obtiene el texto de la caja de texto de la busqueda
            if (!contenido.equals("")) {//se compara que el contenido no sea nulo
                if (bandera_tecla_abajo == false) {
                    switch (Tipo_Busqueda_1) {//Se elige el criterio de busqueda: nombre-clave-tipo, mediante unos rabiobuttons
                        case 1:
                            resultado = conexion.consultar(1, "*", "Nombre_A", contenido);//Se hace la consulta (por ahora solo con la clave del producto)
                            if (resultado.first()) {//Se compara que el resultado no sea nulo(que exista el o los articulos buscados)
                                resultado.previous();
                                Autocompletar.setVisible(true);//Se hace visible la lista desplegable (Jcombobox)
                                Autocompletar.addItem(" ");//Se agrega un elemento vacio (Parche que evita que la seleccin por default sea un articulo, puesto que entraba en conflicto con el evento
                                while (resultado.next()) {//Se itera con el objeto resultado para obtener todos los valores que fueron encontrados con la consulta
                                    //Se asignan al Arreglo que contentra todos los elementos de la fila, los elementos de cada registro de la Tabla 

                                    RenglonRegistro[0] = resultado.getString(1);
                                    RenglonRegistro[1] = resultado.getString(2);
                                    RenglonRegistro[2] = resultado.getString(3);
                                    RenglonRegistro[3] = resultado.getString(4);
                                    RenglonRegistro[4] = resultado.getString(5);
                                    RenglonRegistro[5] = resultado.getString(6);
                                    //Se agrega el elemento a la lista desplegable NOTA: se agregan "-" para despues poder separar los elementos cuando se selecciona un elemento de la lista
                                    Autocompletar.addItem(RenglonRegistro[0] + "  -  " + RenglonRegistro[1] + "  -  " + RenglonRegistro[2] + "  -  " + RenglonRegistro[3] + "  -  " + RenglonRegistro[4]+ "  -  " + RenglonRegistro[5]);

                                }


                                Autocompletar.showPopup();//Se muestra la lista desplegable

                            }//
                            else {
                                //Si en la consulta, no se encuentran registros se remueven todos los elementos contenidos anteriormente, se esconde la lista  y se hace invisible
                                Autocompletar.removeAllItems();
                                Autocompletar.hidePopup();
                                Autocompletar.setVisible(false);

                            }
                            break;
                        case 2:
                            resultado = conexion.consultar(1, "*", "Clave_A", contenido);
                            if (resultado.first()) {
                                resultado.previous();
                                Autocompletar.addItem(" ");//Se agrega un elemento vacio (Parche que evita que la seleccin por default sea un articulo, puesto que entraba en conflicto con el evento
                                Autocompletar.setVisible(true);

                                while (resultado.next()) {

                                    RenglonRegistro[0] = resultado.getString(1);
                                    RenglonRegistro[1] = resultado.getString(2);
                                    RenglonRegistro[2] = resultado.getString(3);
                                    RenglonRegistro[3] = resultado.getString(4);
                                    RenglonRegistro[4] = resultado.getString(5);
                                    RenglonRegistro[5] = resultado.getString(6);
                                    Autocompletar.addItem(RenglonRegistro[0] + "  -  " + RenglonRegistro[1] + "  -  " + RenglonRegistro[2] + "  -  " + RenglonRegistro[3] + "  -  " + RenglonRegistro[4]+ "  -  " + RenglonRegistro[5]);

                                }

                                Autocompletar.showPopup();//Se muestra la lista desplegable


                            } else {
                                //Si en la consulta, no se encuentran registros se remueven todos los elementos contenidos anteriormente, se esconde la lista  y se hace invisible
                                Autocompletar.removeAllItems();
                                Autocompletar.hidePopup();
                                Autocompletar.setVisible(false);
                            }
                            break;
                        case 3:
                            resultado = conexion.consultar(1, "*", "Tipo_A", contenido);
                            if (resultado.first()) {
                                resultado.previous();
                                Autocompletar.addItem(" ");//Se agrega un elemento vacio (Parche que evita que la seleccin por default sea un articulo, puesto que entraba en conflicto con el evento
                                Autocompletar.setVisible(true);
                                while (resultado.next()) {

                                    RenglonRegistro[0] = resultado.getString(1);
                                    RenglonRegistro[1] = resultado.getString(2);
                                    RenglonRegistro[2] = resultado.getString(3);
                                    RenglonRegistro[3] = resultado.getString(4);
                                    RenglonRegistro[4] = resultado.getString(5);
                                    RenglonRegistro[5] =  resultado.getString(6);
                                    Autocompletar.addItem(RenglonRegistro[0] + "  -  " + RenglonRegistro[1] + "  -  " + RenglonRegistro[2] + "  -  " + RenglonRegistro[3] + "  -  " + RenglonRegistro[4]+ "  -  " + RenglonRegistro[5]);

                                }

                                Autocompletar.showPopup();//Se muestra la lista desplegable

                            } else {
                                //Si en la consulta, no se encuentran registros se remueven todos los elementos contenidos anteriormente, se esconde la lista  y se hace invisible
                                Autocompletar.removeAllItems();
                                Autocompletar.hidePopup();
                                Autocompletar.setVisible(false);
                            }
                            break;
                        default:
                            JOptionPane.showMessageDialog(this, "Tipo incorreco de búsqueda");
                            break;
                    }
//                    Autocompletar. 
                } else {
                    //Si las teclas flecha arriba y abajo son presionadas, se pasa el foco a la lista desplegable y se muestra el contenido, para permitir que se seleccione algun elemento y se pueda desplazar mediante estas teclas
                    Autocompletar.requestFocus();
                    Autocompletar.setSelectedIndex(0);
                    Autocompletar.showPopup();


                }


            } else {// De lo contrario se oculta la lista desplegable (popup)
                Autocompletar.hidePopup();
                Autocompletar.setVisible(false);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al conectar con MySQL");
        }
      
    }//GEN-LAST:event_caracteristicaBuscarKeyReleased
    /*
     * Metodo asociado con el evento que se acciona al cambiar de
     * panel(Borrar-Modificar) Este metodo sirver para refrescar las tablas
     * cuando se cambia de panel, esto con el fin de que se vea la actualizacion
     * de los datos si es que hay alguna
     */
    private void PanelBorrarComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_PanelBorrarComponentShown
        //Se hace la comparacion del contador para ver si no es la primera ves que se manda llamar al metodo de llenar tabla, puesto que generaba bugs
        caracteristicaBuscar2.requestFocus();
        if (ContadorLlenadoTabla > 2) {

            vaciarTabla(2);
            llenarTabla(2);
        }
    }//GEN-LAST:event_PanelBorrarComponentShown
    /*
     * Metodo asociado con el evento que se acciona al cambiar de
     * panel(Borrar-Modificar) Este metodo sirver para refrescar las tablas
     * cuando se cambia de panel, esto con el fin de que se vea la actualizacion
     * de los datos si es que hay alguna
     */
    private void PanelModificarComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_PanelModificarComponentShown
        //Se hace la comparacion del contador para ver si no es la primera ves que se manda llamar al metodo de llenar tabla, puesto que generaba bugs
        if (ContadorLlenadoTabla > 2) {

            vaciarTabla(1);
            llenarTabla(1);
        }
    }//GEN-LAST:event_PanelModificarComponentShown
//metodo asociado con el evento que se acciona al cambiar o seleccionar un elemento de la lista
    private void AutocompletarItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_AutocompletarItemStateChanged
        
        int ElementoSeleccionado = Autocompletar.getSelectedIndex();//Se obtiene el elemento seleccionado en la lista NOTA: por default es el primero, por eso se agraga un espacion en blanco
        if (ElementoSeleccionado != -1 && bandera_tecla_abajo == false ) {//Se hace la comparacion de que el item seleccionado no sea ni el primero o si este no se ha presionado, puesto que este evento tambien se acciona al agregar un nuevo item
            String Registro = (String) Autocompletar.getSelectedItem(); //Se obtiene el elemento (String) seleccionado  de la lista desplegable
            String RegistroSeleccionado[] = Registro.split("-"); //Se separa por los guiones 
            for (int i = 0; i < RegistroSeleccionado.length; i++) {
                RegistroSeleccionado[i] = RegistroSeleccionado[i].trim();

            }
            for (int i = 0; i < TablaArticulosModificar.getRowCount(); i++) {//Se recorre toda la tabla para encontrar el articulo y asi seleccionarlo,
                //esto ayuda cuando se tiene mas elementos y no se pueden presentar todos dentro de los primeros elementos de la lista

                if (String.valueOf(TablaArticulosModificar.getValueAt(i, 0)).equals(RegistroSeleccionado[0])) {//Se hace la comparacion del elemento con lo que hay en la lista
                    //Si si, se selecciona automaticamente la fila, indicando el articulo que se encuentra

                    TablaArticulosModificar.setRowSelectionInterval(i, i);
                    //--Las siguientes lineas de codigo sirven para visualizar el renglon seleccionado anteriormente
                    int fila_a_desplegar = (i * 16) + 1; //se obtiene el valor de la coordenada en y del renglon seleccionado
                    Point punto = new Point(0, fila_a_desplegar);   //Se crea un objeto tipo Point que nos ayudara a visualizar el renglón
                    jScrollPane1.getViewport().setViewPosition(punto);//Se visualiza el renglon  del ScrollBar mediante el metodo setViewPort teniendo como parametro el objeto tipo Point
                    botonCancelar.setVisible(true);
                    botonGuardar.setVisible(true);
                    mostrarPanelModificar(i); //Se muestran el panel que contiene los campos para modificar los datos
                    Autocompletar.setVisible(false);//Se oculta la lista desplegable
                    caracteristicaBuscar.setText("");//Se borra el texto de busqueda
                    break;
                }
            }

        }
    }//GEN-LAST:event_AutocompletarItemStateChanged
    //Este metodo  esta asociado al tipo de busqueda que se selecciona mediante los RadioButtons
    private void TipoBusquedaNombre1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TipoBusquedaNombre1ActionPerformed
        Tipo_Busqueda_1 = 1;//Se le asigna el valir 1 a la variable para compararlo posteriormente
        caracteristicaBuscar.requestFocus();//Se devuelve el focus al campo de buscar
    }//GEN-LAST:event_TipoBusquedaNombre1ActionPerformed
    //Este metodo  esta asociado al tipo de busqueda que se selecciona mediante los RadioButtons
    private void TipoBusquedaClave1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TipoBusquedaClave1ActionPerformed
        Tipo_Busqueda_1 = 2;//Se le asigna el valir 2 a la variable para compararlo posteriormente
        caracteristicaBuscar.requestFocus();//Se devuelve el focus al campo de buscar
    }//GEN-LAST:event_TipoBusquedaClave1ActionPerformed
//Este metodo  esta asociado al tipo de busqueda que se selecciona mediante los RadioButtons
    private void TipoBusquedaTipo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TipoBusquedaTipo1ActionPerformed
        Tipo_Busqueda_1 = 3;//Se le asigna el valir 3 a la variable para compararlo posteriormente
        caracteristicaBuscar.requestFocus();//Se devuelve el focus al campo de buscar
    }//GEN-LAST:event_TipoBusquedaTipo1ActionPerformed
//Este metodo esta asociado al evento que se dispara al presionar una tecla, cuando se encuentra sobre el campo del nombre
    private void campoNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoNombreKeyTyped
        char c = evt.getKeyChar();//Se almacena el valor de la tecla que se ha precionado en una variable
        if ((!Character.getName(c).equals("SPACE") && !Character.isLetterOrDigit(c))) { //Se hace la comparacion de la tecla que se presiono, si es espacios, letra o caracter,  para impedir que se siga tecleando si es el caso contrario

            evt.consume();//Se impide que se sigan tecleando cosas en la caja de texto

            } else {
            if (campoNombre.getText().length() > 49) {//Se hace una comparacion del numero de caracteres que e han ingresado, para limitarlos a 50
                Toolkit.getDefaultToolkit().beep(); // si es excedido se dispara el sonido y se impide el seguir tecleando
                evt.consume();
            }
        }
    }//GEN-LAST:event_campoNombreKeyTyped

    private void campoNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoNombreKeyReleased
        String aux = "";
        if (!campoNombre.getText().equals("")) {
            String ContenidoNuevo[] = campoNombre.getText().split(" ");
            if (KeyEvent.getKeyText(evt.getKeyCode()).equals("Espacio")) {

                for (int i = 0; i < ContenidoNuevo.length; i++) {
                    if(i==ContenidoNuevo.length){
                        aux = aux + ContenidoNuevo[i];
                    }
                    else{
                        aux = aux + ContenidoNuevo[i] + " ";
                    }
                    
                }
                campoNombre.setText(aux);
                
            }
            
        }
    }//GEN-LAST:event_campoNombreKeyReleased

    private void campoTipoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoTipoKeyTyped

        char c = evt.getKeyChar();
        if ((!Character.getName(c).equals("SPACE") && !Character.isLetter(c) && !Character.getName(c).equals("HYPHEN-MINUS")) ) {
            
            evt.consume();
        } else {
            if ( campoTipo.getText().length() > 24) {
                Toolkit.getDefaultToolkit().beep();
                
                 evt.consume();
            }
        }
    }//GEN-LAST:event_campoTipoKeyTyped

    private void campoTipoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoTipoKeyReleased
        String aux = "";
        if (!campoTipo.getText().equals("")) {
            String ContenidoNuevo[] = campoTipo.getText().split(" ");
            if (KeyEvent.getKeyText(evt.getKeyCode()).equals("Espacio")) {

                for (int i = 0; i < ContenidoNuevo.length; i++) {
                    if(i==ContenidoNuevo.length){
                        aux = aux + ContenidoNuevo[i];
                    }
                    else{
                        aux = aux + ContenidoNuevo[i] + " ";
                    }
                    
                }
               campoTipo.setText(aux);
                
            }
            else{
                
            }


        }
    }//GEN-LAST:event_campoTipoKeyReleased

    private void campoCostoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoCostoKeyTyped
        char c = evt.getKeyChar();
        if (!Character.getName(c).equals("FULL STOP") && !Character.isDigit(c)) {
            evt.consume();
        } else {
        }
    }//GEN-LAST:event_campoCostoKeyTyped

    private void campoNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNombreActionPerformed
        campoTipo.requestFocus();
    }//GEN-LAST:event_campoNombreActionPerformed

    private void campoTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoTipoActionPerformed
        campoExistencia.requestFocus();
    }//GEN-LAST:event_campoTipoActionPerformed

    private void campoExistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoExistenciaActionPerformed
        campoCosto.requestFocus();
    }//GEN-LAST:event_campoExistenciaActionPerformed

    private void campoCostoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoCostoActionPerformed
        campoCosto2.requestFocus();
    }//GEN-LAST:event_campoCostoActionPerformed

    private void botonGuardarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_botonGuardarKeyPressed
        int filatabla = TablaArticulosModificar.getSelectedRow();//Se obtiene el numero de la fila seleccionada
        //Se guardan los valores del articulo en un arreglo que se enviara como parametro al metodo de insertar, NOTA: la clave se obtiene de la tabla, ya que esta no se permite modificar
        String ValoresRegistro[] = {String.valueOf(TablaArticulosModificar.getValueAt(filatabla, 0)), campoNombre.getText(), campoTipo.getText(), campoExistencia.getText(), campoCosto.getText(),campoCosto2.getText()};
        try {
            char c = evt.getKeyChar();
            if (KeyEvent.getKeyText(evt.getKeyCode()).equals("Intro")) {
                //Confirma si se desea guardar el elemento
                int a = JOptionPane.showConfirmDialog(this, "¿Realmente desea Modificar este artículo?", "Guardar Modificaciones", 0, 3);
                if (a == 0) {//Si el usuario presiona OK
                    //Se invoca al metodo insertar mandando como parametros: numero de tabla, los valores almacenados en el arreglo
                    conexion.modificar(1, ValoresRegistro, String.valueOf(TablaArticulosModificar.getValueAt(filatabla, 0)));
                    JOptionPane.showMessageDialog(this, "Articulo Modificado");//Mensaje de confirmacion
                    //Se Establecen los valores iniciales
                    PanelCamposModificar.setVisible(false);
                    caracteristicaBuscar.setText("");
                    lblMensajes.setVisible(false);
                    botonGuardar.setVisible(false);
                    botonCancelar.setVisible(false);
                    Autocompletar.setVisible(false);
                    caracteristicaBuscar.requestFocus();
                    //Se invocan los siguientes metodos para refrescar la tabla
                    vaciarTabla(1);
                    llenarTabla(1);

                }
            } else {
                if (KeyEvent.getKeyText(evt.getKeyCode()).equals("F3")) {
                    PanelCamposModificar.setVisible(false);
                    lblMensajes.setVisible(false);
                    botonGuardar.setVisible(false);
                    botonCancelar.setVisible(false);
                    caracteristicaBuscar.requestFocus();
                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al guardar los cambios al artículo");
            Logger.getLogger(Almacen.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    }//GEN-LAST:event_botonGuardarKeyPressed

    private void TipoBusquedaClave2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TipoBusquedaClave2ActionPerformed
        Tipo_Busqueda_2 = 2;
        caracteristicaBuscar2.requestFocus();
    }//GEN-LAST:event_TipoBusquedaClave2ActionPerformed

    private void TipoBusquedaTipo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TipoBusquedaTipo2ActionPerformed
        Tipo_Busqueda_2 = 3;
        caracteristicaBuscar2.requestFocus();
    }//GEN-LAST:event_TipoBusquedaTipo2ActionPerformed

    private void TipoBusquedaNombre2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TipoBusquedaNombre2ActionPerformed
        Tipo_Busqueda_2 = 1;
        caracteristicaBuscar2.requestFocus();
    }//GEN-LAST:event_TipoBusquedaNombre2ActionPerformed

    private void campoCostoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoCostoKeyPressed
        if (KeyEvent.getKeyText(evt.getKeyCode()).equals("Intro")) {
            campoCosto2.requestFocus();
        }
        else{
        
            if (KeyEvent.getKeyText(evt.getKeyCode()).equals("F3")) {
                    PanelCamposModificar.setVisible(false);
                    lblMensajes.setVisible(false);
                    botonGuardar.setVisible(false);
                    botonCancelar.setVisible(false);
                    caracteristicaBuscar.requestFocus();
                }
        }

    }//GEN-LAST:event_campoCostoKeyPressed

    private void caracteristicaBuscar2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_caracteristicaBuscar2KeyPressed
        if ((KeyEvent.getKeyText(evt.getKeyCode()).equals("Abajo") || KeyEvent.getKeyText(evt.getKeyCode()).equals("Arriba")) && Autocompletar2.isVisible()) {

            bandera_tecla_abajo2 = true;
        }
    }//GEN-LAST:event_caracteristicaBuscar2KeyPressed

    private void caracteristicaBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_caracteristicaBuscarKeyPressed
        if ((KeyEvent.getKeyText(evt.getKeyCode()).equals("Abajo") || KeyEvent.getKeyText(evt.getKeyCode()).equals("Arriba")) && Autocompletar.isVisible()) {
            bandera_tecla_abajo = true;
        }
    }//GEN-LAST:event_caracteristicaBuscarKeyPressed

    private void AutocompletarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AutocompletarKeyPressed

        if (KeyEvent.getKeyText(evt.getKeyCode()).equals("Intro")) {//Se hace la comparacion de que el item seleccionado no sea ni el primero o si este no se ha presionado, puesto que este evento tambien se acciona al agregar un nuevo item
            String Registro = (String) Autocompletar.getSelectedItem(); //Se obtiene el elemento (String) seleccionado  de la lista desplegable
            String RegistroSeleccionado[] = Registro.split("-"); //Se separa por los guiones 
            for (int i = 0; i < RegistroSeleccionado.length; i++) {
                RegistroSeleccionado[i] = RegistroSeleccionado[i].trim();

            }
            for (int i = 0; i < TablaArticulosModificar.getRowCount(); i++) {//Se recorre toda la tabla para encontrar el articulo y asi seleccionarlo,
                //esto ayuda cuando se tiene mas elementos y no se pueden presentar todos dentro de los primeros elementos de la lista

                if (String.valueOf(TablaArticulosModificar.getValueAt(i, 0)).equals(RegistroSeleccionado[0])) {//Se hace la comparacion del elemento con lo que hay en la lista
                    //Si si, se selecciona automaticamente la fila, indicando el articulo que se encuentra

                    TablaArticulosModificar.setRowSelectionInterval(i, i);
                    //--Las siguientes lineas de codigo sirven para visualizar el renglon seleccionado anteriormente
                    int fila_a_desplegar = (i * 16) + 1; //se obtiene el valor de la coordenada en y del renglon seleccionado
                    Point punto = new Point(0, fila_a_desplegar);   //Se crea un objeto tipo Point que nos ayudara a visualizar el renglón
                    jScrollPane1.getViewport().setViewPosition(punto);//Se visualiza el renglon  del ScrollBar mediante el metodo setViewPort teniendo como parametro el objeto tipo Point
                    mostrarPanelModificar(i); //Se muestran el panel que contiene los campos para modificar los datos
                    botonCancelar.setVisible(true);
                    botonGuardar.setVisible(true);
                    Autocompletar.setVisible(false);//Se oculta la lista desplegable
                    caracteristicaBuscar.setText("");//Se borra el texto de busqueda
                    break;
                }
            }
        }
    }//GEN-LAST:event_AutocompletarKeyPressed

    private void Autocompletar2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Autocompletar2KeyPressed

        if (KeyEvent.getKeyText(evt.getKeyCode()).equals("Intro")) {//Se hace la comparacion de que el item seleccionado no sea ni el primero o si este no se ha presionado, puesto que este evento tambien se acciona al agregar un nuevo item
            String Registro = (String) Autocompletar2.getSelectedItem(); //Se obtiene el elemento (String) seleccionado  de la lista desplegable
            String RegistroSeleccionado[] = Registro.split("-"); //Se separa por los guiones 
            for (int i = 0; i < RegistroSeleccionado.length; i++) {
                RegistroSeleccionado[i] = RegistroSeleccionado[i].trim();

            }
            for (int i = 0; i < TablaArticulosBorrar.getRowCount(); i++) {//Se recorre toda la tabla para encontrar el articulo y asi seleccionarlo,
                //esto ayuda cuando se tiene mas elementos y no se pueden presentar todos dentro de los primeros elementos de la lista

                if (String.valueOf(TablaArticulosBorrar.getValueAt(i, 0)).equals(RegistroSeleccionado[0])) {//Se hace la comparacion del elemento con lo que hay en la lista
                    //Si si, se selecciona automaticamente la fila, indicando el articulo que se encuentra

                    TablaArticulosBorrar.setRowSelectionInterval(i, i);
                    //--Las siguientes lineas de codigo sirven para visualizar el renglon seleccionado anteriormente
                    int fila_a_desplegar = (i * 16) + 1; //se obtiene el valor de la coordenada en y del renglon seleccionado
                    Point punto = new Point(0, fila_a_desplegar);   //Se crea un objeto tipo Point que nos ayudara a visualizar el renglón
                    jScrollPane2.getViewport().setViewPosition(punto);//Se visualiza el renglon  del ScrollBar mediante el metodo setViewPort teniendo como parametro el objeto tipo Point

                    Autocompletar2.setVisible(false);//Se oculta la lista desplegable
                    caracteristicaBuscar2.setText("");//Se borra el texto de busqueda 

                    break;
                }
            }
            TablaArticulosBorrar.requestFocus(false);
            botonBorrar.requestFocus();

        }
    }//GEN-LAST:event_Autocompletar2KeyPressed

    private void TablaArticulosModificarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TablaArticulosModificarKeyPressed
          if (KeyEvent.getKeyText(evt.getKeyCode()).equals("F3")) {
                    PanelCamposModificar.setVisible(false);
                    lblMensajes.setVisible(false);
                    botonGuardar.setVisible(false);
                    botonCancelar.setVisible(false);
                    caracteristicaBuscar.requestFocus();
                }
    }//GEN-LAST:event_TablaArticulosModificarKeyPressed

    private void botonCancelarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_botonCancelarKeyPressed
        //Se reestablecen los valores iniciales de todos los componentes
        if (KeyEvent.getKeyText(evt.getKeyCode()).equals("Intro")) {
            lblMensajes.setVisible(false);
            campoCosto.setText("");
            campoExistencia.setText("");
            campoNombre.setText("");
            campoTipo.setText("");
            PanelCamposModificar.setVisible(false);
            caracteristicaBuscar.setText("");
            Autocompletar.setVisible(false);
            RenglonRegistro[0] = "";
            RenglonRegistro[1] = "";
            RenglonRegistro[2] = "";
            RenglonRegistro[3] = "";
            RenglonRegistro[4] = "";
            botonGuardar.setVisible(false);
            botonCancelar.setVisible(false);
            caracteristicaBuscar.requestFocus();
        }
        else{
            if (KeyEvent.getKeyText(evt.getKeyCode()).equals("F3")) {
                PanelCamposModificar.setVisible(false);
                lblMensajes.setVisible(false);
                botonGuardar.setVisible(false);
                botonCancelar.setVisible(false);
                caracteristicaBuscar.requestFocus();
            }
        }

    }//GEN-LAST:event_botonCancelarKeyPressed

    private void botonModificarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_botonModificarKeyPressed
        //Analiza si se ha seleccionado alguna fila en la tabla, de lo contrario despliega mensaje de advertencia

        if (KeyEvent.getKeyText(evt.getKeyCode()).equals("Intro")) {
            if (TablaArticulosModificar.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(this, "Primero debes seleccionar un artículo de la tabla");

            } else {
                botonGuardar.setVisible(true);//Se hace visible el boton guardar para permitir guardar los cambios
                botonCancelar.setVisible(true);//Se hace visible el boton cancelar para permitir cancelar los cambios
                int filatabla = TablaArticulosModificar.getSelectedRow();//Se asigna a una variable el numero de fila que esta seleccionada
                mostrarPanelModificar(filatabla);//Se invoca al metodo que se encarga de visualizar el panel de los campos a modificar así como tambien llenarlos con los antiguos datos
            }
        }
           else{
            if (KeyEvent.getKeyText(evt.getKeyCode()).equals("F3")) {
                PanelCamposModificar.setVisible(false);
                botonGuardar.setVisible(false);
                lblMensajes.setVisible(false);
                botonCancelar.setVisible(false);
                caracteristicaBuscar.requestFocus();
            }
        }

    }//GEN-LAST:event_botonModificarKeyPressed

    private void botonBorrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_botonBorrarKeyPressed
        if (KeyEvent.getKeyText(evt.getKeyCode()).equals("Intro")) {
            //Analiza si se ha seleccionado alguna fila en la tabla, de lo contrario despliega mensaje de advertencia
            if (TablaArticulosBorrar.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(this, "Primero debes seleccionar un artículo de la tabla");

            } else {

                int filatabla = TablaArticulosBorrar.getSelectedRow();//Se asigna a una variable el numero de fila que esta seleccionada
                int a = JOptionPane.showConfirmDialog(this, "¿Realmente desea eliminar este artículo?", "Advertencia", 0, 3);//Mensaje de confirmacion para borrar el articulo
                if (a == 0) { //si la opcion del usuario es si la variable "a" toma el valor de 0
                    int existencia = Integer.parseInt(String.valueOf(TablaArticulosBorrar.getValueAt(filatabla, 3)));//Obtenemos el numero de articulos en existencia en almacen

                    if (existencia == 0) {//Se compara si el numero de articulos es 0 para asegurarnos de que no se elimine si todavia hay en existencia
                        try {
                            //Se invoca al metodo eliminar
                            conexion.eliminar(1, String.valueOf(TablaArticulosBorrar.getValueAt(filatabla, 0)));
                            //Mensaje de Confirmación
                            JOptionPane.showMessageDialog(this, "Registro Borrado");
                            //Se invoca a estos dos metodos para actualizar la tabla, borrando y volviendo a rellenar las filas
                            vaciarTabla(2);
                            llenarTabla(2);

                            //Se devuelve el foco al campo de busquedas
                            caracteristicaBuscar2.requestFocus();

                        } catch (SQLException ex) {
                            Logger.getLogger(Almacen.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "No puedes borrarlo, todavía hay artculos en existencia", "Acción no válida", 2);
                        caracteristicaBuscar2.requestFocus();// Se devuelve el foco al campo de busquedas
                    }
                }



            }
            //Se borra el contenido del arreglo 
            RenglonRegistro[0] = "";
            RenglonRegistro[1] = "";
            RenglonRegistro[2] = "";
            RenglonRegistro[3] = "";
            RenglonRegistro[4] = "";

        }
        
        else{
           if (KeyEvent.getKeyText(evt.getKeyCode()).equals("F3")) {                 
                    caracteristicaBuscar2.requestFocus();
                }
        }
    }//GEN-LAST:event_botonBorrarKeyPressed

    private void campoNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoNombreFocusLost
        String contenido_campo[] = campoNombre.getText().split(" ");
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
        campoNombre.setText(Aux_Contenido_Campo);
    }//GEN-LAST:event_campoNombreFocusLost

    private void campoTipoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoTipoFocusLost
          String contenido_campo[] = campoTipo.getText().split(" ");
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
        campoTipo.setText(Aux_Contenido_Campo);
    }//GEN-LAST:event_campoTipoFocusLost

    private void campoNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoNombreKeyPressed
     
                if (KeyEvent.getKeyText(evt.getKeyCode()).equals("F3")) {
                    PanelCamposModificar.setVisible(false);
                    lblMensajes.setVisible(false);
                    botonGuardar.setVisible(false);
                    botonCancelar.setVisible(false);
                    caracteristicaBuscar.requestFocus();
                }
          
    }//GEN-LAST:event_campoNombreKeyPressed

    private void campoTipoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoTipoKeyPressed
       if (KeyEvent.getKeyText(evt.getKeyCode()).equals("F3")) {
                    PanelCamposModificar.setVisible(false);
                    botonGuardar.setVisible(false);
                    lblMensajes.setVisible(false);
                    botonCancelar.setVisible(false);
                    caracteristicaBuscar.requestFocus();
                }
    }//GEN-LAST:event_campoTipoKeyPressed

    private void campoExistenciaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoExistenciaKeyPressed
     if (KeyEvent.getKeyText(evt.getKeyCode()).equals("F3")) {
                    PanelCamposModificar.setVisible(false);
                    botonGuardar.setVisible(false);
                    lblMensajes.setVisible(false);
                    botonCancelar.setVisible(false);
                    caracteristicaBuscar.requestFocus();
                }
    }//GEN-LAST:event_campoExistenciaKeyPressed

    private void TablaArticulosBorrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TablaArticulosBorrarKeyPressed
           if (KeyEvent.getKeyText(evt.getKeyCode()).equals("F3")) {
                   
                    caracteristicaBuscar2.requestFocus();
                }
    }//GEN-LAST:event_TablaArticulosBorrarKeyPressed

    private void campoCosto2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoCosto2ActionPerformed
        botonGuardar.requestFocus();
    }//GEN-LAST:event_campoCosto2ActionPerformed

    private void campoCosto2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoCosto2KeyPressed
      if (KeyEvent.getKeyText(evt.getKeyCode()).equals("Intro")) {
            botonGuardar.requestFocus();
        }
        else{
        
            if (KeyEvent.getKeyText(evt.getKeyCode()).equals("F3")) {
                    PanelCamposModificar.setVisible(false);
                    lblMensajes.setVisible(false);
                    botonGuardar.setVisible(false);
                    botonCancelar.setVisible(false);
                    caracteristicaBuscar.requestFocus();
                }
        }
    }//GEN-LAST:event_campoCosto2KeyPressed

    private void campoCosto2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoCosto2KeyTyped
            char c = evt.getKeyChar();
        if (!Character.getName(c).equals("FULL STOP") && !Character.isDigit(c)) {
            evt.consume();
        } 
    }//GEN-LAST:event_campoCosto2KeyTyped
    /*
     * Este metodo se utiliza para rellenar la tabla mediante una consulta con
     * la Tabla Articulos Utiliza el objeto creado en el constructor ModeloTabla
     * 1 y 2 para agregar dinamicamente las filas a la tabla y asi no depender
     * solo de un numero estatico, permitiendo tener mas de 100 elementos cosa
     * que nos limita el editor de NetBeans recibe como parametro un numero que
     * hace alución a la tabla que se kiere actualizar
     */

    private void llenarTabla(int tabla) {
        ContadorLlenadoTabla += 1;//contador de las veces que es utilizado este metodo
        try {

            ResultadoTabla = conexion.consultar(1);//Se invoca al metodo consultar generico para obtener todos los articulos de la tabla

            switch (tabla) {//Se hace la comparacion de la tabla a llenar
                case 1:
                    while (ResultadoTabla.next()) {//Se itera con el Objeto tipo ResulSet
                        //Se guarda en un arreglo los elementos del registro en la tabla para despues ser agregados como una fila
                        fila[0] = ResultadoTabla.getString(1);
                        fila[1] = ResultadoTabla.getString(2);
                        fila[2] = ResultadoTabla.getString(3);
                        fila[3] = ResultadoTabla.getString(4);
                        fila[4] = ResultadoTabla.getString(5);
                        fila[5] = ResultadoTabla.getString(6);
                        //Se agrega la fila a la tabla, mandandole como parametro el arreglo asignado anteriormente
                        ModeloTabla1.addRow(fila);

                    }


                    break;
                case 2:
                    while (ResultadoTabla.next()) {//Se itera con el Objeto tipo ResulSet
                        //Se guarda en un arreglo los elementos del registro en la tabla para despues ser agregados como una fila
                        fila[0] = ResultadoTabla.getString(1);
                        fila[1] = ResultadoTabla.getString(2);
                        fila[2] = ResultadoTabla.getString(3);
                        fila[3] = ResultadoTabla.getString(4);
                        fila[4] = ResultadoTabla.getString(5);
                        fila[5] = ResultadoTabla.getString(6);
                        //Se agrega la fila a la tabla, mandandole como parametro el arreglo asignado anteriormente
                        ModeloTabla2.addRow(fila);

                    }
//                    

                    break;
                default:
                    throw new AssertionError();
            }



        } catch (SQLException ex) {
            Logger.getLogger(Almacen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//Este metodo se utiliza para borrar todos los elementos de la tabla(filas)
    //recibe como parametro un numero que hace alucion a que tabla es la que se kiere vaciar

    private void vaciarTabla(int tabla) {
        switch (tabla) {
            case 1:
                for (int i = TablaArticulosModificar.getRowCount() - 1; i >= 0; i--) {//Se itera desde el ultimo elemento hasta el primero
                    //Se puede hacer al reves pero asi lo kise hcer XD
                    //Se elimina la fila
                    ModeloTabla1.removeRow(i);

                }
                break;
            case 2:
                for (int i = TablaArticulosBorrar.getRowCount() - 1; i >= 0; i--) {//Se itera desde el ultimo elemento hasta el primero
                    //Se puede hacer al reves pero asi lo kise hcer XD
                    //Se elimina la fila    
                    ModeloTabla2.removeRow(i);

                }
                break;
            default:
                throw new AssertionError();
        }

    }

    private void mostrarPanelModificar(int filatabla) {

        PanelCamposModificar.setVisible(true);             //Se hace visible el panel que contiene los campos para introducir los nuevos datos del articulo              
        lblMensajes.setText("Ingresa los nuevos datos del artículo en la parte inferior");//Se despliega un mensaje
        campoNombre.requestFocus();                        //Se posiciona el focus en el primer campo que corresponde al nombre
        lblMensajes.setVisible(true);                      //Se hace visible el label para el mensaje
        //Se rellenan los campos del articulo con los valores anteriores             
        campoNombre.setText(String.valueOf(TablaArticulosModificar.getValueAt(filatabla, 1)));
        campoTipo.setText(String.valueOf(TablaArticulosModificar.getValueAt(filatabla, 2)));
        campoExistencia.setText(String.valueOf(TablaArticulosModificar.getValueAt(filatabla, 3)));
        campoCosto.setText(String.valueOf(TablaArticulosModificar.getValueAt(filatabla, 4)));
        campoCosto2.setText(String.valueOf(TablaArticulosModificar.getValueAt(filatabla, 5)));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox Autocompletar;
    private javax.swing.JComboBox Autocompletar2;
    private javax.swing.JPanel PanelBorrar;
    private javax.swing.JPanel PanelCamposModificar;
    private javax.swing.JPanel PanelModificar;
    private javax.swing.JPanel PanelTipoBusqueda;
    private javax.swing.JPanel PanelTipoBusqueda1;
    private javax.swing.JTable TablaArticulosBorrar;
    private javax.swing.JTable TablaArticulosModificar;
    private javax.swing.ButtonGroup TipoBusqueda1;
    private javax.swing.ButtonGroup TipoBusqueda2;
    private javax.swing.JRadioButton TipoBusquedaClave1;
    private javax.swing.JRadioButton TipoBusquedaClave2;
    private javax.swing.JRadioButton TipoBusquedaNombre1;
    private javax.swing.JRadioButton TipoBusquedaNombre2;
    private javax.swing.JRadioButton TipoBusquedaTipo1;
    private javax.swing.JRadioButton TipoBusquedaTipo2;
    private javax.swing.JButton botonBorrar;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonCerrar;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JButton botonModificar;
    private javax.swing.JFormattedTextField campoCosto;
    private javax.swing.JFormattedTextField campoCosto2;
    private javax.swing.JTextField campoExistencia;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JTextField campoTipo;
    private javax.swing.JTextField caracteristicaBuscar;
    private javax.swing.JTextField caracteristicaBuscar2;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblMensajes;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
}
