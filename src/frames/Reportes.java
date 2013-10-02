
package frames;

import conexiones.Conexion;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;
import org.apache.log4j.BasicConfigurator;
import org.freixas.jcalendar.DateEvent;
import org.freixas.jcalendar.JCalendarCombo;
import utilidades.Fecha;



public class Reportes extends javax.swing.JDialog {
    
   Conexion conexion;
   

   private int contador1; 
   private int contador2;
   private int contador3;
   private int contador4;
   
   JCalendarCombo calendario1;
   JCalendarCombo calendario2;
   JCalendarCombo calendario3;
   JCalendarCombo calendario4;
   
    private int MostrarListaProveedores;
 
    public Reportes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
       
        conexion = new Conexion();
        conexion.conectarMySQL();
        
        initComponents();
         BasicConfigurator.configure();
        this.setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(getClass().getResource("/imagenes/icono-proyecto.png")).getImage());
        lblFecha.setText(Fecha.getDia()+"-"+Fecha.getMes()+"-"+Fecha.getAño());
          
       
        
         //Se declara el combo para el calendario
          calendario1 = new JCalendarCombo();
          calendario2 = new JCalendarCombo();
          calendario3 = new JCalendarCombo();
          calendario4 = new JCalendarCombo();
        //Se inicializa el Campo de texto cuando se carga la ventana
          TxtFechas1.setText(calendario1.getSelectedItem().toString());
          TxtFechas2.setText(calendario2.getSelectedItem().toString());
          TxtFechas3.setText(calendario2.getSelectedItem().toString());
          TxtFechas4.setText(calendario2.getSelectedItem().toString());
          
          
          MostrarListaProveedores = 1;
          opCredito.setSelected(true);
        //Se le agrega un DateListener al combo para capturar la fecha
          calendario1.addDateListener( new org.freixas.jcalendar.DateListener(){

        
            
            //Si se sobre-lleva el metodo del cambio de fecha q se acciona cuando se elige una fecha del JCalendarCombo
             @Override
            public void dateChanged(DateEvent de) {
                 
                //SE invova al metodo que hara las acciones pertinentes 
                calendario_DateChanged(de);
                
            }

        });
        
        
          calendario2.addDateListener( new org.freixas.jcalendar.DateListener(){

        
            
            //Si se sobre-lleva el metodo del cambio de fecha q se acciona cuando se elige una fecha del JCalendarCombo
             @Override
            public void dateChanged(DateEvent de) {
                 
                //SE invova al metodo que hara las acciones pertinentes 
                calendario_DateChanged(de);
                
            }

        });
          
          calendario3.addDateListener( new org.freixas.jcalendar.DateListener(){

        
            
            //Si se sobre-lleva el metodo del cambio de fecha q se acciona cuando se elige una fecha del JCalendarCombo
             @Override
            public void dateChanged(DateEvent de) {
                 
                //SE invova al metodo que hara las acciones pertinentes 
                calendario_DateChanged(de);
                
            }

        });
          
          calendario4.addDateListener( new org.freixas.jcalendar.DateListener(){

        
            
            //Si se sobre-lleva el metodo del cambio de fecha q se acciona cuando se elige una fecha del JCalendarCombo
             @Override
            public void dateChanged(DateEvent de) {
                 
                //SE invova al metodo que hara las acciones pertinentes 
                calendario_DateChanged(de); 
                
            }

        });
          
         SubPaneContenedorVentas.add(calendario1).setBounds(75, 150, 200, 40);
         System.out.println(calendario1.getDate().toString());
        
        
         SubPaneContenedorVentas.add(calendario2).setBounds(300, 150, 200, 40);
         System.out.println(calendario2.getDate().toString());
    
         
         PanelComprasFecha.add(calendario3).setBounds(75, 150, 200, 40);
         System.out.println(calendario3.getDate().toString());
        
         
         PanelComprasFecha.add(calendario4).setBounds(310, 150, 200, 40);
         System.out.println(calendario4.getDate().toString());
         
                  
       contador1 = 0;
       contador2 = 0;
       contador3 = 0;
       contador4 = 0;
       
    }
    
    
    
   //Metodo asociado al evento que se dispara al seleccionar un elemento del JCalendarCombo
   private void calendario_DateChanged(org.freixas.jcalendar.DateEvent evt) {                                           
       
               TxtFechas1.setText(calendario1.getSelectedItem().toString());
               TxtFechas2.setText(calendario2.getSelectedItem().toString());
               TxtFechas3.setText(calendario3.getSelectedItem().toString());
               TxtFechas4.setText(calendario4.getSelectedItem().toString());

}
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GrupoFolios = new javax.swing.ButtonGroup();
        GrupoFechas = new javax.swing.ButtonGroup();
        TipoCompras = new javax.swing.ButtonGroup();
        FoliosCompras = new javax.swing.ButtonGroup();
        ProveedoresReportes = new javax.swing.ButtonGroup();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        PanelVentas1 = new javax.swing.JPanel();
        BtnCancelarVentas = new javax.swing.JButton();
        BtnMostrarReporteVentas = new javax.swing.JButton();
        PanelContenedorVentas = new javax.swing.JPanel();
        VentaTotalRepo = new javax.swing.JRadioButton();
        SubPaneContenedorVentas = new javax.swing.JPanel();
        FechasUltimos = new javax.swing.JRadioButton();
        FechasActual = new javax.swing.JRadioButton();
        RangoFechas = new javax.swing.JRadioButton();
        UltimosDias = new javax.swing.JComboBox();
        LabelFechasFolio = new javax.swing.JLabel();
        lblMensajes4 = new javax.swing.JLabel();
        TxtFechas1 = new javax.swing.JTextField();
        LabelFechas = new javax.swing.JLabel();
        TxtFechas2 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        FolioEspecial = new javax.swing.JRadioButton();
        TodosLosFolios = new javax.swing.JRadioButton();
        LabelFolios = new javax.swing.JLabel();
        txtFolio1 = new javax.swing.JTextField();
        RangoFolioEspecial = new javax.swing.JRadioButton();
        TxtFolioEspecial = new javax.swing.JTextField();
        TxtRangoFolio2 = new javax.swing.JTextField();
        LabelHastaFolio = new javax.swing.JLabel();
        PanelCompras = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        PanelContenedorCompras = new javax.swing.JPanel();
        PanelComprasFecha = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        TxtFechas4 = new javax.swing.JTextField();
        TxtFechas3 = new javax.swing.JTextField();
        jRadioButton9 = new javax.swing.JRadioButton();
        jRadioButton10 = new javax.swing.JRadioButton();
        jRadioButton11 = new javax.swing.JRadioButton();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        opContado = new javax.swing.JRadioButton();
        opCredito = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jRadioButton7 = new javax.swing.JRadioButton();
        jRadioButton8 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jTextField7 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        PanelProveedores = new javax.swing.JPanel();
        lblMensajes1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        BtnReportesProveedores = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        CreditosActivos = new javax.swing.JRadioButton();
        jComboBox1 = new javax.swing.JComboBox();
        jRadioButton12 = new javax.swing.JRadioButton();
        ListaProveedores = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        PanelArticulos = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        BtnReportesAlmacen = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jRadioButton4 = new javax.swing.JRadioButton();
        ListaDeArticulos = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jRadioButton5 = new javax.swing.JRadioButton();
        jTextField2 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        botonCerrar = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Reportes");
        setModalExclusionType(null);
        setModalityType(java.awt.Dialog.ModalityType.MODELESS);
        setUndecorated(true);

        jTabbedPane2.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane2.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTabbedPane2.setRequestFocusEnabled(false);

        PanelVentas1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PanelVentas1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        PanelVentas1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        BtnCancelarVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancelar.png"))); // NOI18N
        BtnCancelarVentas.setText("Cancelar");

        BtnMostrarReporteVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/reportes.png"))); // NOI18N
        BtnMostrarReporteVentas.setText("Mostrar Reporte");
        BtnMostrarReporteVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnMostrarReporteVentasActionPerformed(evt);
            }
        });

        PanelContenedorVentas.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Reporte de Ventas"));

        VentaTotalRepo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        VentaTotalRepo.setText("Total caja");
        VentaTotalRepo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VentaTotalRepoActionPerformed(evt);
            }
        });

        SubPaneContenedorVentas.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        GrupoFechas.add(FechasUltimos);
        FechasUltimos.setText("Ultimos");

        GrupoFechas.add(FechasActual);
        FechasActual.setText("Actual");

        RangoFechas.setText("Rango");

        UltimosDias.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2 Días", "3 Días", "4 Días", "5 Días", "6 Días", "7 Día" }));

        LabelFechasFolio.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        LabelFechasFolio.setText("Fechas");

        lblMensajes4.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblMensajes4.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        TxtFechas1.setEditable(false);

        LabelFechas.setText("Hasta");

        TxtFechas2.setEditable(false);

        javax.swing.GroupLayout SubPaneContenedorVentasLayout = new javax.swing.GroupLayout(SubPaneContenedorVentas);
        SubPaneContenedorVentas.setLayout(SubPaneContenedorVentasLayout);
        SubPaneContenedorVentasLayout.setHorizontalGroup(
            SubPaneContenedorVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SubPaneContenedorVentasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabelFechasFolio)
                .addGap(28, 28, 28)
                .addGroup(SubPaneContenedorVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SubPaneContenedorVentasLayout.createSequentialGroup()
                        .addComponent(TxtFechas1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LabelFechas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtFechas2, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 59, Short.MAX_VALUE))
                    .addGroup(SubPaneContenedorVentasLayout.createSequentialGroup()
                        .addGroup(SubPaneContenedorVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(FechasUltimos)
                            .addComponent(RangoFechas)
                            .addGroup(SubPaneContenedorVentasLayout.createSequentialGroup()
                                .addComponent(FechasActual)
                                .addGap(18, 18, 18)
                                .addComponent(UltimosDias, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(54, 54, 54)
                        .addComponent(lblMensajes4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        SubPaneContenedorVentasLayout.setVerticalGroup(
            SubPaneContenedorVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SubPaneContenedorVentasLayout.createSequentialGroup()
                .addGroup(SubPaneContenedorVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SubPaneContenedorVentasLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(lblMensajes4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(SubPaneContenedorVentasLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(SubPaneContenedorVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(FechasActual)
                            .addComponent(UltimosDias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(SubPaneContenedorVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelFechasFolio)
                            .addComponent(FechasUltimos))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(RangoFechas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(SubPaneContenedorVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtFechas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelFechas)
                    .addComponent(TxtFechas2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        GrupoFolios.add(FolioEspecial);
        FolioEspecial.setText("Folio En Especial");

        GrupoFolios.add(TodosLosFolios);
        TodosLosFolios.setText("Todos Los Folios");

        LabelFolios.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        LabelFolios.setText("Folios");

        txtFolio1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFolio1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFolio1KeyTyped(evt);
            }
        });

        RangoFolioEspecial.setText("Rango");

        TxtFolioEspecial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TxtFolioEspecial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtFolioEspecialKeyTyped(evt);
            }
        });

        TxtRangoFolio2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TxtRangoFolio2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtRangoFolio2KeyTyped(evt);
            }
        });

        LabelHastaFolio.setText("Hasta");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(LabelFolios, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(TodosLosFolios)
                        .addComponent(FolioEspecial))
                    .addComponent(RangoFolioEspecial))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFolio1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(TxtFolioEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LabelHastaFolio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtRangoFolio2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(TodosLosFolios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FolioEspecial)
                    .addComponent(txtFolio1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelFolios))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(RangoFolioEspecial)
                        .addGap(0, 5, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtFolioEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LabelHastaFolio)
                            .addComponent(TxtRangoFolio2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        javax.swing.GroupLayout PanelContenedorVentasLayout = new javax.swing.GroupLayout(PanelContenedorVentas);
        PanelContenedorVentas.setLayout(PanelContenedorVentasLayout);
        PanelContenedorVentasLayout.setHorizontalGroup(
            PanelContenedorVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelContenedorVentasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelContenedorVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(VentaTotalRepo, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SubPaneContenedorVentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        PanelContenedorVentasLayout.setVerticalGroup(
            PanelContenedorVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelContenedorVentasLayout.createSequentialGroup()
                .addComponent(VentaTotalRepo)
                .addGap(12, 12, 12)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SubPaneContenedorVentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout PanelVentas1Layout = new javax.swing.GroupLayout(PanelVentas1);
        PanelVentas1.setLayout(PanelVentas1Layout);
        PanelVentas1Layout.setHorizontalGroup(
            PanelVentas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelVentas1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanelVentas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelVentas1Layout.createSequentialGroup()
                        .addComponent(BtnCancelarVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BtnMostrarReporteVentas))
                    .addComponent(PanelContenedorVentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );
        PanelVentas1Layout.setVerticalGroup(
            PanelVentas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelVentas1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(PanelContenedorVentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelVentas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnMostrarReporteVentas)
                    .addComponent(BtnCancelarVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane2.addTab("Ventas          ", new javax.swing.ImageIcon(getClass().getResource("/imagenes/ventas.png")), PanelVentas1); // NOI18N

        PanelCompras.setBackground(new java.awt.Color(255, 255, 255));
        PanelCompras.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PanelCompras.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        PanelCompras.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancelar.png"))); // NOI18N
        jButton1.setText("Cancelar");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/reportes.png"))); // NOI18N
        jButton2.setText("Mostrar Reporte");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        PanelContenedorCompras.setBackground(new java.awt.Color(255, 255, 255));
        PanelContenedorCompras.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Reportes Compra"));

        PanelComprasFecha.setBackground(new java.awt.Color(255, 255, 255));
        PanelComprasFecha.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Fecha");

        jLabel6.setText("Hasta");

        jRadioButton9.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButton9.setText("Rango");

        jRadioButton10.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButton10.setText("Actual");

        jRadioButton11.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButton11.setText("Ultimos");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2 Días", "3 Días", "4 Días", "5 Días", "6 Días", "7 Días" }));

        javax.swing.GroupLayout PanelComprasFechaLayout = new javax.swing.GroupLayout(PanelComprasFecha);
        PanelComprasFecha.setLayout(PanelComprasFechaLayout);
        PanelComprasFechaLayout.setHorizontalGroup(
            PanelComprasFechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelComprasFechaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(36, 36, 36)
                .addGroup(PanelComprasFechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton11)
                    .addGroup(PanelComprasFechaLayout.createSequentialGroup()
                        .addComponent(jRadioButton10)
                        .addGap(69, 69, 69)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelComprasFechaLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(TxtFechas4, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtFechas3, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jRadioButton9))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelComprasFechaLayout.setVerticalGroup(
            PanelComprasFechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelComprasFechaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelComprasFechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelComprasFechaLayout.createSequentialGroup()
                        .addGroup(PanelComprasFechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton10)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addComponent(jRadioButton11))
                    .addComponent(jLabel3))
                .addGap(5, 5, 5)
                .addComponent(jRadioButton9)
                .addGap(12, 12, 12)
                .addGroup(PanelComprasFechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtFechas4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(TxtFechas3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(76, Short.MAX_VALUE))
        );

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Tipo");

        opContado.setBackground(new java.awt.Color(255, 255, 255));
        TipoCompras.add(opContado);
        opContado.setText("Contado");

        opCredito.setBackground(new java.awt.Color(255, 255, 255));
        TipoCompras.add(opCredito);
        opCredito.setText("Credito");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Folios");

        jRadioButton7.setBackground(new java.awt.Color(255, 255, 255));
        FoliosCompras.add(jRadioButton7);
        jRadioButton7.setText("Todos los folios");

        jRadioButton8.setBackground(new java.awt.Color(255, 255, 255));
        FoliosCompras.add(jRadioButton8);
        jRadioButton8.setText("Folio en especial");
        jRadioButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton8ActionPerformed(evt);
            }
        });

        jRadioButton6.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButton6.setText("Rango");

        jLabel4.setText("Hasta");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton7)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton8)
                            .addComponent(jRadioButton6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jRadioButton7)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton8))
                            .addComponent(jTextField7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton6)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PanelContenedorComprasLayout = new javax.swing.GroupLayout(PanelContenedorCompras);
        PanelContenedorCompras.setLayout(PanelContenedorComprasLayout);
        PanelContenedorComprasLayout.setHorizontalGroup(
            PanelContenedorComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelContenedorComprasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelContenedorComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelContenedorComprasLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(opContado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(opCredito)
                        .addGap(47, 47, 47))
                    .addGroup(PanelContenedorComprasLayout.createSequentialGroup()
                        .addGroup(PanelContenedorComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(PanelComprasFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        PanelContenedorComprasLayout.setVerticalGroup(
            PanelContenedorComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelContenedorComprasLayout.createSequentialGroup()
                .addGroup(PanelContenedorComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(opContado)
                    .addComponent(opCredito))
                .addGap(14, 14, 14)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelComprasFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout PanelComprasLayout = new javax.swing.GroupLayout(PanelCompras);
        PanelCompras.setLayout(PanelComprasLayout);
        PanelComprasLayout.setHorizontalGroup(
            PanelComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelComprasLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addGap(14, 14, 14))
            .addGroup(PanelComprasLayout.createSequentialGroup()
                .addComponent(PanelContenedorCompras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 35, Short.MAX_VALUE))
        );
        PanelComprasLayout.setVerticalGroup(
            PanelComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelComprasLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PanelContenedorCompras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(29, 29, 29))
        );

        PanelContenedorCompras.getAccessibleContext().setAccessibleName("Datos del Reporte de Compras");

        jTabbedPane2.addTab("Compras      ", new javax.swing.ImageIcon(getClass().getResource("/imagenes/carrito.png")), PanelCompras); // NOI18N

        PanelProveedores.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PanelProveedores.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        PanelProveedores.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        lblMensajes1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblMensajes1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancelar.png"))); // NOI18N
        jButton3.setText("Cancelar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        BtnReportesProveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/reportes.png"))); // NOI18N
        BtnReportesProveedores.setText("Mostrar Reportes");
        BtnReportesProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnReportesProveedoresActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Reportes Proveedores"));

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        ProveedoresReportes.add(CreditosActivos);
        CreditosActivos.setText("Creditos Activos");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        ProveedoresReportes.add(jRadioButton12);
        jRadioButton12.setText("Compras a Proveedor");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CreditosActivos)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jRadioButton12)
                        .addGap(41, 41, 41)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(183, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton12)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addComponent(CreditosActivos)
                .addContainerGap(124, Short.MAX_VALUE))
        );

        ProveedoresReportes.add(ListaProveedores);
        ListaProveedores.setText("Proveedores");
        ListaProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListaProveedoresActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Lista");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(ListaProveedores)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ListaProveedores)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout PanelProveedoresLayout = new javax.swing.GroupLayout(PanelProveedores);
        PanelProveedores.setLayout(PanelProveedoresLayout);
        PanelProveedoresLayout.setHorizontalGroup(
            PanelProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelProveedoresLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMensajes1, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                .addGap(35, 35, 35)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnReportesProveedores)
                .addGap(33, 33, 33))
            .addGroup(PanelProveedoresLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PanelProveedoresLayout.setVerticalGroup(
            PanelProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelProveedoresLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(lblMensajes1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelProveedoresLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanelProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnReportesProveedores)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        jTabbedPane2.addTab("Proveedores", new javax.swing.ImageIcon(getClass().getResource("/imagenes/proveedores.png")), PanelProveedores); // NOI18N

        PanelArticulos.setBackground(new java.awt.Color(255, 255, 255));
        PanelArticulos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PanelArticulos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        PanelArticulos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancelar.png"))); // NOI18N
        jButton5.setText("Cancelar");

        BtnReportesAlmacen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/reportes.png"))); // NOI18N
        BtnReportesAlmacen.setText("Generar Reportes");
        BtnReportesAlmacen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnReportesAlmacenActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Reportes Almacen"));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jRadioButton4.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButton4.setText("Tipo");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        ListaDeArticulos.setBackground(new java.awt.Color(255, 255, 255));
        ListaDeArticulos.setText("Lista de Articulos");
        ListaDeArticulos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListaDeArticulosActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Articulo en especial");

        jRadioButton5.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButton5.setText("Nombre");
        jRadioButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton5ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Existencia");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ListaDeArticulos))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jRadioButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jRadioButton5)
                                .addGap(31, 31, 31)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)))
                .addContainerGap(137, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton5)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ListaDeArticulos)
                            .addComponent(jLabel1))
                        .addGap(62, 62, 62)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)))
                .addGap(31, 31, 31)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton4)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout PanelArticulosLayout = new javax.swing.GroupLayout(PanelArticulos);
        PanelArticulos.setLayout(PanelArticulosLayout);
        PanelArticulosLayout.setHorizontalGroup(
            PanelArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelArticulosLayout.createSequentialGroup()
                .addGroup(PanelArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelArticulosLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BtnReportesAlmacen))
                    .addGroup(PanelArticulosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 43, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PanelArticulosLayout.setVerticalGroup(
            PanelArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelArticulosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(PanelArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnReportesAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane2.addTab("Almacen      ", new javax.swing.ImageIcon(getClass().getResource("/imagenes/reportesalmacen.png")), PanelArticulos); // NOI18N

        jTabbedPane2.setBounds(20, 40, 760, 490);
        jLayeredPane1.add(jTabbedPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jTabbedPane2.getAccessibleContext().setAccessibleName("");

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

        lblTitulo.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Reportes");
        lblTitulo.setBounds(360, 10, 80, 22);
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
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 801, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_botonCerrarActionPerformed

    private void VentaTotalRepoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VentaTotalRepoActionPerformed
        
        
    }//GEN-LAST:event_VentaTotalRepoActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void jRadioButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jRadioButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton8ActionPerformed

    private void ListaProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListaProveedoresActionPerformed
        MostrarListaProveedores = 1;
    }//GEN-LAST:event_ListaProveedoresActionPerformed

    private void BtnMostrarReporteVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMostrarReporteVentasActionPerformed

        
         if (TodosLosFolios.isSelected()) {
            String r = System.getProperty("user.dir");
        if(r.substring(r.length()-1, r.length()).equals("\\"))
            r =r.substring(0, r.length()-1);
        String fileName =r+ "/Reportes/VentasTodosFolios.jrxml";
        
       try {
            JasperReport reporte =JasperCompileManager.compileReport(fileName);
            JasperPrint imprime =JasperFillManager.fillReport(reporte,null,conexion.getConexion());
            JasperViewer.viewReport(imprime,false);

            
        } catch (JRException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }     
        }
         
      
    }//GEN-LAST:event_BtnMostrarReporteVentasActionPerformed

    private void BtnReportesAlmacenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnReportesAlmacenActionPerformed
    
        if (ListaDeArticulos.isSelected()) {
            String r = System.getProperty("user.dir");
        if(r.substring(r.length()-1, r.length()).equals("\\"))
            r =r.substring(0, r.length()-1);
        String fileName =r+ "/Reportes/ArticulosExistencia.jrxml";
        
       try {
            JasperReport reporte =JasperCompileManager.compileReport(fileName);
            JasperPrint imprime =JasperFillManager.fillReport(reporte,null,conexion.getConexion());
            JasperViewer.viewReport(imprime,false);

            
        } catch (JRException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }     
        }    
    }//GEN-LAST:event_BtnReportesAlmacenActionPerformed

    private void BtnReportesProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnReportesProveedoresActionPerformed

        if (ListaProveedores.isSelected()) {
            String r = System.getProperty("user.dir");
        if(r.substring(r.length()-1, r.length()).equals("\\"))
            r =r.substring(0, r.length()-1);
        String fileName =r+ "/Reportes/Proveedores.jrxml";
        
       try {
            JasperReport reporte =JasperCompileManager.compileReport(fileName);
            JasperPrint imprime =JasperFillManager.fillReport(reporte,null,conexion.getConexion());
            JasperViewer.viewReport(imprime,false);

            
        } catch (JRException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }     
        }
        
         else if(CreditosActivos.isSelected()){
        String r = System.getProperty("user.dir");
        if(r.substring(r.length()-1, r.length()).equals("\\"))
            r =r.substring(0, r.length()-1);
        String fileName =r+ "/Reportes/ComprasCredito.jrxml";
        
       try {
            JasperReport reporte =JasperCompileManager.compileReport(fileName);
            JasperPrint imprime =JasperFillManager.fillReport(reporte,null,conexion.getConexion());
            JasperViewer.viewReport(imprime,false);

            
        } catch (JRException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }     
        }
    }//GEN-LAST:event_BtnReportesProveedoresActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (opContado.isSelected()) {
            String r = System.getProperty("user.dir");
        if(r.substring(r.length()-1, r.length()).equals("\\"))
            r =r.substring(0, r.length()-1);
        String fileName =r+ "/Reportes/ComprasContado.jrxml";
        
       try {
            JasperReport reporte =JasperCompileManager.compileReport(fileName);
            JasperPrint imprime =JasperFillManager.fillReport(reporte,null,conexion.getConexion());
            JasperViewer.viewReport(imprime,false);

            
        } catch (JRException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }     
        }
        else if(opCredito.isSelected()){
        String r = System.getProperty("user.dir");
        if(r.substring(r.length()-1, r.length()).equals("\\"))
            r =r.substring(0, r.length()-1);
        String fileName =r+ "/Reportes/ComprasCredito.jrxml";
        
       try {
            JasperReport reporte =JasperCompileManager.compileReport(fileName);
            JasperPrint imprime =JasperFillManager.fillReport(reporte,null,conexion.getConexion());
            JasperViewer.viewReport(imprime,false);

            
        } catch (JRException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }     
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtFolio1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFolio1KeyTyped
       char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        } else {
            if (txtFolio1.getText().length() > 9) {
                Toolkit.getDefaultToolkit().beep();
                evt.consume();
            }
        }
    }//GEN-LAST:event_txtFolio1KeyTyped

    private void TxtFolioEspecialKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtFolioEspecialKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        } else {
            if (TxtFolioEspecial.getText().length() > 9) {
                Toolkit.getDefaultToolkit().beep();
                evt.consume();
            }
        }
    }//GEN-LAST:event_TxtFolioEspecialKeyTyped

    private void TxtRangoFolio2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtRangoFolio2KeyTyped
         char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        } else {
            if (TxtRangoFolio2.getText().length() > 9) {
                Toolkit.getDefaultToolkit().beep();
                evt.consume();
            }
        }
    }//GEN-LAST:event_TxtRangoFolio2KeyTyped

    private void ListaDeArticulosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListaDeArticulosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ListaDeArticulosActionPerformed

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCancelarVentas;
    private javax.swing.JButton BtnMostrarReporteVentas;
    private javax.swing.JButton BtnReportesAlmacen;
    private javax.swing.JButton BtnReportesProveedores;
    private javax.swing.JRadioButton CreditosActivos;
    private javax.swing.JRadioButton FechasActual;
    private javax.swing.JRadioButton FechasUltimos;
    private javax.swing.JRadioButton FolioEspecial;
    private javax.swing.ButtonGroup FoliosCompras;
    private javax.swing.ButtonGroup GrupoFechas;
    private javax.swing.ButtonGroup GrupoFolios;
    private javax.swing.JLabel LabelFechas;
    private javax.swing.JLabel LabelFechasFolio;
    private javax.swing.JLabel LabelFolios;
    private javax.swing.JLabel LabelHastaFolio;
    private javax.swing.JRadioButton ListaDeArticulos;
    private javax.swing.JRadioButton ListaProveedores;
    private javax.swing.JPanel PanelArticulos;
    private javax.swing.JPanel PanelCompras;
    private javax.swing.JPanel PanelComprasFecha;
    private javax.swing.JPanel PanelContenedorCompras;
    private javax.swing.JPanel PanelContenedorVentas;
    private javax.swing.JPanel PanelProveedores;
    private javax.swing.JPanel PanelVentas1;
    private javax.swing.ButtonGroup ProveedoresReportes;
    private javax.swing.JRadioButton RangoFechas;
    private javax.swing.JRadioButton RangoFolioEspecial;
    private javax.swing.JPanel SubPaneContenedorVentas;
    private javax.swing.ButtonGroup TipoCompras;
    private javax.swing.JRadioButton TodosLosFolios;
    private javax.swing.JTextField TxtFechas1;
    private javax.swing.JTextField TxtFechas2;
    private javax.swing.JTextField TxtFechas3;
    private javax.swing.JTextField TxtFechas4;
    private javax.swing.JTextField TxtFolioEspecial;
    private javax.swing.JTextField TxtRangoFolio2;
    private javax.swing.JComboBox UltimosDias;
    private javax.swing.JRadioButton VentaTotalRepo;
    private javax.swing.JButton botonCerrar;
    private javax.swing.JLabel fondo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JRadioButton jRadioButton10;
    private javax.swing.JRadioButton jRadioButton11;
    private javax.swing.JRadioButton jRadioButton12;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JRadioButton jRadioButton9;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblMensajes1;
    private javax.swing.JLabel lblMensajes4;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JRadioButton opContado;
    private javax.swing.JRadioButton opCredito;
    private javax.swing.JTextField txtFolio1;
    // End of variables declaration//GEN-END:variables
}
