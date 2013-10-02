package frames;

import com.mysql.jdbc.Statement;
import conexiones.Conexion;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import utilidades.Cuentas_Usuario;
import utilidades.ExtensionFileFilter;
import utilidades.Fecha;

public class Herramientas extends javax.swing.JDialog {

    Conexion conexion;//Variable utilizada para instanciar el objeto de la clase Conexion, que nos da la pauta para manejar la conexión con la base de datos
    Statement sentencia;
    ExtensionFileFilter filter1;
    String comando, ruta_respaldo, ruta_restaura;
    private int tipo, contador, filaSeleccionada;
    boolean pass_coincide;

    public Herramientas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(getClass().getResource("/imagenes/icono-proyecto.png")).getImage());
        selecciona1.setVisible(false);
        selecciona2.setVisible(false);
        btnRespaldar.setVisible(false);
        btnRestaurar.setVisible(false);
        barra1.setVisible(false);
        barra2.setVisible(false);
        btnguardar.setVisible(false);
        PanelNuevoUsuario.setVisible(false);
        pass_coincide = true;
        lblError.setVisible(false);
        lblError1.setVisible(false);
        lblError2.setVisible(false);
        comando = "";
        ruta_respaldo = "";
        ruta_restaura = "";
        filter1 = new ExtensionFileFilter("sql", new String[]{"SQL"});
        selecciona1.setFileFilter(filter1);
        //Se establece la fecha en el label destinado para desplegar la fecha-----------
        lblFecha.setText(Fecha.getDia() + "-" + Fecha.getMes() + "-" + Fecha.getAño());
        rellenarTabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        PanelUsuarios = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaUsuarios = new javax.swing.JTable();
        btnnuevo = new javax.swing.JButton();
        btnmodificar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        PanelNuevoUsuario = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        CampoNombre = new javax.swing.JTextField();
        CampoPass1 = new javax.swing.JPasswordField();
        CampoPass2 = new javax.swing.JPasswordField();
        btnguardar = new javax.swing.JButton();
        lblError = new javax.swing.JLabel();
        lblError1 = new javax.swing.JLabel();
        lblError2 = new javax.swing.JLabel();
        PanelRespaldar = new javax.swing.JPanel();
        selecciona2 = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        txtruta1 = new javax.swing.JTextField();
        btndestino = new javax.swing.JButton();
        btnRespaldar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        barra1 = new javax.swing.JProgressBar();
        PanelRestaurar = new javax.swing.JPanel();
        selecciona1 = new javax.swing.JFileChooser();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtruta2 = new javax.swing.JTextField();
        btndestino2 = new javax.swing.JButton();
        barra2 = new javax.swing.JProgressBar();
        btnRestaurar = new javax.swing.JButton();
        botonCerrar = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        TablaUsuarios.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        TablaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Usuario", "Contraseña"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaUsuarios.setRowHeight(25);
        jScrollPane1.setViewportView(TablaUsuarios);
        TablaUsuarios.getColumnModel().getColumn(0).setResizable(false);
        TablaUsuarios.getColumnModel().getColumn(1).setResizable(false);

        btnnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nuevo.png"))); // NOI18N
        btnnuevo.setText("Nuevo Usuario");
        btnnuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });

        btnmodificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/editar.png"))); // NOI18N
        btnmodificar.setText("Modificar Usuario");
        btnmodificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodificarActionPerformed(evt);
            }
        });

        btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/borrar.png"))); // NOI18N
        btneliminar.setMnemonic('E');
        btneliminar.setText("Eliminar Usuario");
        btneliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        PanelNuevoUsuario.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Usuario"));
        PanelNuevoUsuario.setToolTipText("Datos del nuevo Usuario");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel3.setText("Nombre:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel4.setText("Introduce la Contraseña:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel5.setText("Repite la Contraseña:");

        CampoNombre.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        CampoNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoNombreActionPerformed(evt);
            }
        });
        CampoNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                CampoNombreFocusLost(evt);
            }
        });
        CampoNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CampoNombreKeyTyped(evt);
            }
        });

        CampoPass1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        CampoPass1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoPass1ActionPerformed(evt);
            }
        });
        CampoPass1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                CampoPass1FocusLost(evt);
            }
        });
        CampoPass1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CampoPass1KeyTyped(evt);
            }
        });

        CampoPass2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        CampoPass2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoPass2ActionPerformed(evt);
            }
        });
        CampoPass2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CampoPass2KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CampoPass2KeyTyped(evt);
            }
        });

        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar.png"))); // NOI18N
        btnguardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });
        btnguardar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnguardarKeyPressed(evt);
            }
        });

        lblError.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botonCerrarRojo.png"))); // NOI18N
        lblError.setText("No coincide");

        lblError1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botonCerrarRojo.png"))); // NOI18N
        lblError1.setText("Vacío");

        lblError2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botonCerrarRojo.png"))); // NOI18N
        lblError2.setText("Vacío");

        javax.swing.GroupLayout PanelNuevoUsuarioLayout = new javax.swing.GroupLayout(PanelNuevoUsuario);
        PanelNuevoUsuario.setLayout(PanelNuevoUsuarioLayout);
        PanelNuevoUsuarioLayout.setHorizontalGroup(
            PanelNuevoUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelNuevoUsuarioLayout.createSequentialGroup()
                .addGroup(PanelNuevoUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelNuevoUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(CampoPass1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                    .addComponent(CampoNombre, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CampoPass2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelNuevoUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelNuevoUsuarioLayout.createSequentialGroup()
                        .addComponent(lblError1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelNuevoUsuarioLayout.createSequentialGroup()
                        .addComponent(lblError)
                        .addContainerGap())
                    .addGroup(PanelNuevoUsuarioLayout.createSequentialGroup()
                        .addComponent(lblError2)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        PanelNuevoUsuarioLayout.setVerticalGroup(
            PanelNuevoUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelNuevoUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelNuevoUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelNuevoUsuarioLayout.createSequentialGroup()
                        .addGroup(PanelNuevoUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(CampoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblError2))
                        .addGap(18, 18, 18)
                        .addGroup(PanelNuevoUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(CampoPass1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnguardar)
                    .addComponent(lblError1))
                .addGap(18, 18, 18)
                .addGroup(PanelNuevoUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(CampoPass2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblError))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnnuevo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnmodificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btneliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                        .addGap(104, 104, 104))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(PanelNuevoUsuario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnmodificar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(PanelNuevoUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout PanelUsuariosLayout = new javax.swing.GroupLayout(PanelUsuarios);
        PanelUsuarios.setLayout(PanelUsuariosLayout);
        PanelUsuariosLayout.setHorizontalGroup(
            PanelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelUsuariosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        PanelUsuariosLayout.setVerticalGroup(
            PanelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelUsuariosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Usuarios ", new javax.swing.ImageIcon(getClass().getResource("/imagenes/usuarios.png")), PanelUsuarios); // NOI18N

        selecciona2.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);
        selecciona2.setApproveButtonText("Guardar");
        selecciona2.setCurrentDirectory(new java.io.File("C:\\"));
            selecciona2.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);

            jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

            btndestino.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
            btndestino.setText("Seleccionar Destino...");
            btndestino.setToolTipText("");
            btndestino.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btndestinoActionPerformed(evt);
                }
            });

            btnRespaldar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
            btnRespaldar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/aceptar.png"))); // NOI18N
            btnRespaldar.setText("Respaldar");
            btnRespaldar.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    btnRespaldarMouseClicked(evt);
                }
            });
            btnRespaldar.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnRespaldarActionPerformed(evt);
                }
            });

            jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
            jLabel1.setText("Selecciona la ruta en la cual se almacenara el respaldo:");

            javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(txtruta1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btndestino, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(22, 22, 22))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(0, 0, Short.MAX_VALUE))))
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(218, 218, 218)
                    .addComponent(btnRespaldar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(barra1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(22, 22, 22))
            );
            jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtruta1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btndestino))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(barra1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                    .addComponent(btnRespaldar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
            );

            javax.swing.GroupLayout PanelRespaldarLayout = new javax.swing.GroupLayout(PanelRespaldar);
            PanelRespaldar.setLayout(PanelRespaldarLayout);
            PanelRespaldarLayout.setHorizontalGroup(
                PanelRespaldarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelRespaldarLayout.createSequentialGroup()
                    .addGroup(PanelRespaldarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelRespaldarLayout.createSequentialGroup()
                            .addGap(24, 24, 24)
                            .addComponent(selecciona2, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 30, Short.MAX_VALUE))
                        .addGroup(PanelRespaldarLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addContainerGap())
            );
            PanelRespaldarLayout.setVerticalGroup(
                PanelRespaldarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelRespaldarLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(selecciona2, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                    .addContainerGap())
            );

            jTabbedPane1.addTab("Respaldar ", new javax.swing.ImageIcon(getClass().getResource("/imagenes/backup.png")), PanelRespaldar); // NOI18N

            selecciona1.setApproveButtonText("Restaurar");
            selecciona1.setCurrentDirectory(new java.io.File("C:\\"));

                jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

                jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
                jLabel2.setText("Selecciona el archivo de donde se restaurara la base de datos:");

                btndestino2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
                btndestino2.setText("Selecciona Archivo...");
                btndestino2.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btndestino2ActionPerformed(evt);
                    }
                });

                btnRestaurar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
                btnRestaurar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/aceptar.png"))); // NOI18N
                btnRestaurar.setText("Restaurar");
                btnRestaurar.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        btnRestaurarMouseClicked(evt);
                    }
                });
                btnRestaurar.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnRestaurarActionPerformed(evt);
                    }
                });

                javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
                jPanel2.setLayout(jPanel2Layout);
                jPanel2Layout.setHorizontalGroup(
                    jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtruta2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btndestino2)
                                .addGap(35, 35, 35))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(barra2, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(211, 211, 211)
                        .addComponent(btnRestaurar, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                );
                jPanel2Layout.setVerticalGroup(
                    jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btndestino2)
                            .addComponent(txtruta2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(barra2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addComponent(btnRestaurar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                );

                javax.swing.GroupLayout PanelRestaurarLayout = new javax.swing.GroupLayout(PanelRestaurar);
                PanelRestaurar.setLayout(PanelRestaurarLayout);
                PanelRestaurarLayout.setHorizontalGroup(
                    PanelRestaurarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelRestaurarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(PanelRestaurarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelRestaurarLayout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelRestaurarLayout.createSequentialGroup()
                                .addGap(0, 19, Short.MAX_VALUE)
                                .addComponent(selecciona1, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26))))
                );
                PanelRestaurarLayout.setVerticalGroup(
                    PanelRestaurarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelRestaurarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(selecciona1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );

                jTabbedPane1.addTab("Restaurar", new javax.swing.ImageIcon(getClass().getResource("/imagenes/restaurar.png")), PanelRestaurar); // NOI18N

                jTabbedPane1.setBounds(10, 50, 770, 470);
                jLayeredPane1.add(jTabbedPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

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

                lblTitulo.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
                lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
                lblTitulo.setText("Herramientas del Sistema");
                lblTitulo.setBounds(280, 10, 230, 22);
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
//        conexion.cerrarConexion();
        this.dispose();
    }//GEN-LAST:event_botonCerrarActionPerformed

    private void btndestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndestinoActionPerformed
        selecciona2.setVisible(true);
        if (selecciona2.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            ruta_respaldo = selecciona2.getSelectedFile().getAbsolutePath();
            txtruta1.setText(ruta_respaldo);
            txtruta1.requestFocus();
            btnRespaldar.setVisible(true);

        }
    }//GEN-LAST:event_btndestinoActionPerformed

    private void btnRespaldarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRespaldarActionPerformed
        barra1.setVisible(true);

        TareaBarra tarea = new TareaBarra(1);
        tarea.start();
        generar_respaldo();

    }//GEN-LAST:event_btnRespaldarActionPerformed

    private void btnRespaldarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRespaldarMouseClicked
    }//GEN-LAST:event_btnRespaldarMouseClicked

    private void btndestino2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndestino2ActionPerformed
        selecciona1.setVisible(true);
        if (selecciona1.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            ruta_restaura = selecciona1.getSelectedFile().getAbsolutePath();
            txtruta2.setText(ruta_restaura);
            txtruta2.requestFocus();

            btnRestaurar.setVisible(true);
        }
    }//GEN-LAST:event_btndestino2ActionPerformed

    private void btnRestaurarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRestaurarMouseClicked
    }//GEN-LAST:event_btnRestaurarMouseClicked

    private void btnRestaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestaurarActionPerformed
        barra2.setVisible(true);
        TareaBarra tarea2 = new TareaBarra(2);
        tarea2.start();
        restaurar_BD();
    }//GEN-LAST:event_btnRestaurarActionPerformed

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        PanelNuevoUsuario.setVisible(true);
        CampoNombre.setText("");
        CampoPass1.setText("");
        CampoPass2.setText("");
        CampoNombre.requestFocus();
        tipo = 1;
        btnguardar.setVisible(true);

        btneliminar.setEnabled(false);
        btnmodificar.setEnabled(false);
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void CampoNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CampoNombreKeyTyped
        char c = evt.getKeyChar();  //obtiene la tecla que se a presionado y lo guarda en la variable key
        if (!Character.isLetterOrDigit(c)) {
            evt.consume();
        } else {
            if (CampoNombre.getText().length() > 19) {
                Toolkit.getDefaultToolkit().beep();
                evt.consume();
            }
        }

    }//GEN-LAST:event_CampoNombreKeyTyped

    private void CampoPass1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CampoPass1KeyTyped
        char c = evt.getKeyChar();  //obtiene la tecla que se a presionado y lo guarda en la variable key
        if (!Character.isLetterOrDigit(c)) {
            evt.consume();
        } else {
            String password = new String(CampoPass1.getPassword());
            if (password.length() > 19) {
                Toolkit.getDefaultToolkit().beep();
                evt.consume();
            }
        }
    }//GEN-LAST:event_CampoPass1KeyTyped

    private void CampoPass2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CampoPass2KeyTyped
        char c = evt.getKeyChar();  //obtiene la tecla que se a presionado y lo guarda en la variable key
        if (!Character.isLetterOrDigit(c)) {
            evt.consume();
        } else {
            String password = new String(CampoPass2.getPassword());
            if (password.length() > 19) {
                Toolkit.getDefaultToolkit().beep();
                evt.consume();
            }
        }
    }//GEN-LAST:event_CampoPass2KeyTyped

    private void CampoNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoNombreActionPerformed
        CampoPass1.requestFocus();
    }//GEN-LAST:event_CampoNombreActionPerformed

    private void CampoPass1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoPass1ActionPerformed
        CampoPass2.requestFocus();
    }//GEN-LAST:event_CampoPass1ActionPerformed

    private void btnmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificarActionPerformed

        tipo = 2;
        filaSeleccionada = TablaUsuarios.getSelectedRow();//Variable en la cual se almacena la fila que ha sido seleccionada en la Tabla que despliega a los usuarios
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Primero debes seleccionar un usuario de la lista");
        } else {

            if (TablaUsuarios.getValueAt(filaSeleccionada, 0) != null) {
                if (TablaUsuarios.getValueAt(filaSeleccionada, 0).equals("administrador")) {
                    CampoNombre.setEditable(false);
                } else {
                    CampoNombre.setEditable(true);
                }
                btnnuevo.setEnabled(false);
                btneliminar.setEnabled(false);
                btnguardar.setVisible(true);
                PanelNuevoUsuario.setVisible(true);
                CampoNombre.setText(String.valueOf(TablaUsuarios.getValueAt(filaSeleccionada, 0)));
                CampoPass1.setText("");
                CampoPass2.setText("");


            }
        }

    }//GEN-LAST:event_btnmodificarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        String guardaContraseñas[] = new String[contador]; //Este arreglo es utilizado para almacenar temporalmente las contraseñas del archivo de contraseñas
        String linea = "";                                 //Variable en la cual se almacena toda una linea leida desde el archivo de contraseñas           
        int filaGuardada = 0;                             //Variable auxiliar para cuardar el indice del arreglo "guardarContraseñas"
        filaSeleccionada = TablaUsuarios.getSelectedRow();//Variable en la cual se almacena la fila que ha sido seleccionada en la Tabla que despliega a los usuarios
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Primero debes seleccionar un usuario de la lista");
        } else {

            if (TablaUsuarios.getValueAt(filaSeleccionada, 0) != null) {
                if (!TablaUsuarios.getValueAt(filaSeleccionada, 0).equals("administrador")) {
                    if (JOptionPane.showConfirmDialog(this, "¿Realmente deseas eliminar los datos del usuario en la linea: " + (filaSeleccionada + 1), "Advertencia", 2) == 0) {
                        try {
                            try (LineNumberReader leer2 = new LineNumberReader(new FileReader("cuentas.pwd"))) {
                                linea = leer2.readLine();
                                while (linea != null) {
                                    guardaContraseñas[filaGuardada] = linea;

                                    filaGuardada += 1;
                                    linea = leer2.readLine();
                                }
                                try (PrintWriter escribir2 = new PrintWriter(new FileWriter("cuentas.pwd", false))) {
                                    for (int i = 0; i < guardaContraseñas.length; i++) {
                                        if (filaSeleccionada != i) {
                                            escribir2.println(guardaContraseñas[i]);
                                        }

                                    }

                                    JOptionPane.showMessageDialog(this, "Se ha eliminado el usuario");

                                }
                            }
                        } catch (IOException ex) {
                            Logger.getLogger(Contraseñas_Usuarios.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "No puedes eliminar a este usuario", "Advertencia", 2);
                }


            }
            vaciaTabla();
            rellenarTabla();
        }



    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        boolean existe;
        String usr = "", password = "";
        switch (tipo) {
            case 1:

                if (!CampoNombre.getText().equals("") && pass_coincide) {
                    int respuesta = JOptionPane.showConfirmDialog(this, "¿Realmente desea agregar este nuevo Usuario?", "Advertencia", 2);
                    String pass2 = new String(CampoPass2.getPassword());
                    if (respuesta == 0 && !pass2.equals("")) {
                        usr = CampoNombre.getText();
                        password = new String(CampoPass1.getPassword());


                        existe = Cuentas_Usuario.encriptarDatos(usr, password);
                        if (!existe) {
                            JOptionPane.showMessageDialog(this, "El Usuario se guardo con exito");
                        }
                        tipo = 0;
                        PanelNuevoUsuario.setVisible(false);

                        CampoNombre.setText("");
                        CampoPass1.setText("");
                        CampoPass2.setText("");
                        lblError.setVisible(false);
                        lblError1.setVisible(false);
                        lblError2.setVisible(false);



                    } else {
                        CampoNombre.setText("");
                        CampoPass1.setText("");
                        CampoPass2.setText("");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Los campos no pueden estar vacios y la contraseña debe ser igual", "Advertencia", 2);
                    tipo = 1;
                    lblError.setVisible(false);
                    lblError1.setVisible(false);
                    lblError2.setVisible(false);

                }


                break;
            case 2:

                String guardaContraseñas[] = new String[contador]; //Este arreglo es utilizado para almacenar temporalmente las contraseñas del archivo de contraseñas
                String linea = "";                                 //Variable en la cual se almacena toda una linea leida desde el archivo de contraseñas           


                int filaGuardada = 0;
                if (JOptionPane.showConfirmDialog(this, "¿Deseas modificar los datos del usuario en la linea: " + (filaSeleccionada + 1), "Advertencia", 2) == 0 && pass_coincide) {


                    usr = CampoNombre.getText();
                    password = new String(CampoPass1.getPassword());
                    String password2 = new String(CampoPass2.getPassword());
                    if (!password.equals("") && !password2.equals("")) {

                        try {
                            LineNumberReader leer2 = new LineNumberReader(new FileReader("cuentas.pwd"));
                            linea = leer2.readLine();
                            while (linea != null) {
                                guardaContraseñas[filaGuardada] = linea;

                                filaGuardada += 1;
                                linea = leer2.readLine();
                            }
                            try (PrintWriter escribir2 = new PrintWriter(new FileWriter("cuentas.pwd", false))) {
                                for (int i = 0; i < guardaContraseñas.length; i++) {
                                    if (i != filaSeleccionada) {
                                        escribir2.println(guardaContraseñas[i]);
                                    }

                                }
                                escribir2.flush();
                            }

                            Cuentas_Usuario.encriptarDatos(usr, password);
                            JOptionPane.showMessageDialog(this, "El Usuario fue modificado y se guardo al final del archivo!");
                            tipo = 0;
                            lblError.setVisible(false);
                            lblError1.setVisible(false);
                            lblError2.setVisible(false);

                        } catch (FileNotFoundException e) {
                        } catch (IOException e) {
                        }
                    }



                }



                break;

        }


        vaciaTabla();
        rellenarTabla();
        btneliminar.setEnabled(true);
        btnguardar.setEnabled(true);
        btnmodificar.setEnabled(true);
        btnnuevo.setEnabled(true);
        CampoNombre.setText("");
        CampoPass1.setText("");
        CampoPass2.setText("");
        PanelNuevoUsuario.setVisible(false);

    }//GEN-LAST:event_btnguardarActionPerformed

    private void CampoPass2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CampoPass2KeyReleased
        String pass1 = new String(CampoPass1.getPassword());
        String pass2 = new String(CampoPass2.getPassword());
        if (!pass2.equals("")) {
            if (pass1.equals(pass2) == false) {
                pass_coincide = false;

                lblError.setVisible(true);

            } else {
                lblError.setVisible(false);
                pass_coincide = true;
            }
        }

    }//GEN-LAST:event_CampoPass2KeyReleased

    private void CampoPass2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoPass2ActionPerformed
        btnguardar.requestFocus();
    }//GEN-LAST:event_CampoPass2ActionPerformed

    private void btnguardarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnguardarKeyPressed
        int tecla = evt.getKeyCode();
        if (tecla == KeyEvent.VK_ENTER) {
            boolean existe;
            String usr = "", password = "";
            switch (tipo) {
                case 1:

                    if (!CampoNombre.getText().equals("") && pass_coincide) {
                        int respuesta = JOptionPane.showConfirmDialog(this, "¿Realmente desea agregar este nuevo Usuario?", "Advertencia", 2);
                        String pass2 = new String(CampoPass2.getPassword());
                        if (respuesta == 0 && !pass2.equals("")) {
                            usr = CampoNombre.getText();
                            password = new String(CampoPass1.getPassword());


                            existe = Cuentas_Usuario.encriptarDatos(usr, password);
                            if (!existe) {
                                JOptionPane.showMessageDialog(this, "El Usuario se guardo con exito");
                            }
                            tipo = 0;
                            PanelNuevoUsuario.setVisible(false);

                            CampoNombre.setText("");
                            CampoPass1.setText("");
                            CampoPass2.setText("");
                            lblError.setVisible(false);
                            lblError1.setVisible(false);
                            lblError2.setVisible(false);


                        } else {
                            CampoNombre.setText("");
                            CampoPass1.setText("");
                            CampoPass2.setText("");
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Los campos no pueden estar vacios y la contraseña debe ser igual", "Advertencia", 2);
                        tipo = 1;
                        lblError.setVisible(false);
                        lblError1.setVisible(false);
                        lblError2.setVisible(false);

                    }


                    break;
                case 2:

                    String guardaContraseñas[] = new String[contador]; //Este arreglo es utilizado para almacenar temporalmente las contraseñas del archivo de contraseñas
                    String linea = "";                                 //Variable en la cual se almacena toda una linea leida desde el archivo de contraseñas           


                    int filaGuardada = 0;
                    if (JOptionPane.showConfirmDialog(this, "¿Deseas modificar los datos del usuario en la linea: " + (filaSeleccionada + 1), "Advertencia", 2) == 0 && pass_coincide) {


                        usr = CampoNombre.getText();
                        password = new String(CampoPass1.getPassword());
                        String password2 = new String(CampoPass2.getPassword());
                        if (!password.equals("") && !password2.equals("")) {
                            try {
                                LineNumberReader leer2 = new LineNumberReader(new FileReader("cuentas.pwd"));
                                linea = leer2.readLine();
                                while (linea != null) {
                                    guardaContraseñas[filaGuardada] = linea;

                                    filaGuardada += 1;
                                    linea = leer2.readLine();
                                }
                                try (PrintWriter escribir2 = new PrintWriter(new FileWriter("cuentas.pwd", false))) {
                                    for (int i = 0; i < guardaContraseñas.length; i++) {
                                        if (i != filaSeleccionada) {
                                            escribir2.println(guardaContraseñas[i]);
                                        }

                                    }
                                    escribir2.flush();
                                }

                                Cuentas_Usuario.encriptarDatos(usr, password);
                                JOptionPane.showMessageDialog(this, "El Usuario fue modificado y se guardo al final del archivo!");
                                tipo = 0;
                                lblError.setVisible(false);
                                lblError1.setVisible(false);
                                lblError2.setVisible(false);

                            } catch (FileNotFoundException e) {
                            } catch (IOException e) {
                            }
                        }


                    } else {
                    }



                    break;

            }


            vaciaTabla();
            rellenarTabla();
            btneliminar.setEnabled(true);
            btnguardar.setEnabled(true);
            btnmodificar.setEnabled(true);
            btnnuevo.setEnabled(true);
            CampoNombre.setText("");
            CampoPass1.setText("");
            CampoPass2.setText("");
            PanelNuevoUsuario.setVisible(false);

        }

    }//GEN-LAST:event_btnguardarKeyPressed

    private void CampoNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CampoNombreFocusLost
        if (CampoNombre.getText().equals("")) {
            lblError2.setVisible(true);
            pass_coincide = false;

        } else {
            lblError2.setVisible(false);
            pass_coincide = true;
        }
    }//GEN-LAST:event_CampoNombreFocusLost

    private void CampoPass1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CampoPass1FocusLost
        String pass_aux = new String(CampoPass1.getPassword());
        if (pass_aux.equals("")) {
            lblError1.setVisible(true);
            pass_coincide = false;

        } else {
            lblError1.setVisible(false);
            pass_coincide = true;
        }
    }//GEN-LAST:event_CampoPass1FocusLost

    public void generar_respaldo() {
        try {
            Runtime runtime = Runtime.getRuntime();
            File backupFile = new File(ruta_respaldo + "\\Respaldo_Papeleria_Angel" + Fecha.getDia() + "-" + Fecha.getMes() + "-" + Fecha.getAño() + ".sql");
            FileWriter fw = new FileWriter(backupFile);
            Process child = runtime.exec("C:\\xampp\\mysql\\bin\\mysqldump.exe --opt --password= --user=root --databases papeleria_angel");
            InputStreamReader irs = new InputStreamReader(child.getInputStream());
            BufferedReader br = new BufferedReader(irs);
            String line;
            while ((line = br.readLine()) != null) {
                fw.write(line + "\n");
            }
            fw.close();
            irs.close();
            br.close();
            JOptionPane.showMessageDialog(null, "Se respaldo Exitosamente", "Verificar", JOptionPane.INFORMATION_MESSAGE);

            btnRespaldar.setVisible(false);
            barra1.setString("0%");
            barra1.setVisible(false);


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error no se genero el archivo por el siguiente motivo:" + e.getMessage(), "Verificar", JOptionPane.ERROR_MESSAGE);
        }



    }

    public void restaurar_BD() {
//    

        try {
            Runtime runtime = Runtime.getRuntime();
            Process child = runtime.exec("cmd /C C:\\xampp\\mysql\\bin\\mysql -u root papeleria_angel < " + ruta_restaura);
            JOptionPane.showMessageDialog(null, "Se restauro correctamente", "Verificar", JOptionPane.INFORMATION_MESSAGE);
            //
            btnRestaurar.setVisible(false);
            barra2.setString("0%");
            barra2.setVisible(false);


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error no se genero el archivo por el siguiente motivo:" + e.getMessage(), "Verificar", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void rellenarTabla() {

        String linea = "";
        String datos[], usrpass[];

        try {
            try (LineNumberReader leer = new LineNumberReader(new FileReader("cuentas.pwd"))) {
                linea = leer.readLine();



                while (linea != null) {
                    contador = leer.getLineNumber();
                    datos = linea.split(" ");
                    usrpass = Cuentas_Usuario.desencripta(datos[0], datos[1]);

                    TablaUsuarios.setValueAt(usrpass[0], contador - 1, 0);
                    TablaUsuarios.setValueAt(usrpass[1], contador - 1, 1);
                    linea = leer.readLine();

                }

                leer.reset();
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Cuentas_Usuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException e) {
        }
    }

    private void vaciaTabla() {
        for (int i = 0; i < TablaUsuarios.getRowCount(); i++) {
            TablaUsuarios.setValueAt("", i, 0);
            TablaUsuarios.setValueAt("", i, 1);
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
            java.util.logging.Logger.getLogger(Herramientas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Herramientas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Herramientas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Herramientas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                Herramientas dialog = new Herramientas(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    public class TareaBarra extends Thread {

        public int num_barra;

        public TareaBarra(int num_barra) {
            this.num_barra = num_barra;
        }

        @Override
        public void run() {

            switch (num_barra) {
                case 1:
                    barra1.setValue(0);

                    for (int i = 0; i < 100; i++) {
                        try {
                            TareaBarra.sleep(5);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Herramientas.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        barra1.setStringPainted(true);
                        barra1.setString((barra1.getValue() + 1) + "%");
                        barra1.setValue(barra1.getValue() + 1);


                    }
                    break;
                case 2:
                    barra2.setValue(0);

                    for (int i = 0; i < 100; i++) {
                        try {
                            TareaBarra.sleep(5);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Herramientas.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        barra2.setStringPainted(true);
                        barra2.setString((barra2.getValue() + 1) + "%");
                        barra2.setValue(barra2.getValue() + 1);


                    }
                    break;
            }



        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CampoNombre;
    private javax.swing.JPasswordField CampoPass1;
    private javax.swing.JPasswordField CampoPass2;
    private javax.swing.JPanel PanelNuevoUsuario;
    private javax.swing.JPanel PanelRespaldar;
    private javax.swing.JPanel PanelRestaurar;
    private javax.swing.JPanel PanelUsuarios;
    private javax.swing.JTable TablaUsuarios;
    private javax.swing.JProgressBar barra1;
    private javax.swing.JProgressBar barra2;
    private javax.swing.JButton botonCerrar;
    private javax.swing.JButton btnRespaldar;
    private javax.swing.JButton btnRestaurar;
    private javax.swing.JButton btndestino;
    private javax.swing.JButton btndestino2;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnmodificar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblError1;
    private javax.swing.JLabel lblError2;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JFileChooser selecciona1;
    private javax.swing.JFileChooser selecciona2;
    private javax.swing.JTextField txtruta1;
    private javax.swing.JTextField txtruta2;
    // End of variables declaration//GEN-END:variables
}
