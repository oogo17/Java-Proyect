
package frames;
import java.awt.Frame;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import utilidades.Fecha;
import utilidades.Usuarios;


public class Menu_Inicio extends javax.swing.JFrame {

    public Menu_Inicio() {
         this.setUndecorated(true);
         initComponents();
          this.setIconImage(new ImageIcon(getClass().getResource("/imagenes/icono-proyecto.png")).getImage());
          this.setLocationRelativeTo(null);
           lblFecha.setText(Fecha.getDia()+"-"+Fecha.getMes()+"-"+Fecha.getAño());
         
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        botonAlmacen = new javax.swing.JButton();
        botonVentas = new javax.swing.JButton();
        botonCompras = new javax.swing.JButton();
        botonProveedores = new javax.swing.JButton();
        botonAdministrarCuentas = new javax.swing.JButton();
        botonMinimizar = new javax.swing.JButton();
        botonCerrar = new javax.swing.JButton();
        botonReportes = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Papeleria Angel");
        setName("menuinicio");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        botonAlmacen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/boton-almacen1.png"))); // NOI18N
        botonAlmacen.setToolTipText("Almacen (Productos)");
        botonAlmacen.setContentAreaFilled(false);
        botonAlmacen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonAlmacen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonAlmacen.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/boton-almacen2.png"))); // NOI18N
        botonAlmacen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAlmacenActionPerformed(evt);
            }
        });
        botonAlmacen.setBounds(75, 233, 200, 65);
        jLayeredPane1.add(botonAlmacen, javax.swing.JLayeredPane.DEFAULT_LAYER);

        botonVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/boton-ventas1.png"))); // NOI18N
        botonVentas.setToolTipText("Nueva Venta");
        botonVentas.setContentAreaFilled(false);
        botonVentas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonVentas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonVentas.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/boton-ventas2.png"))); // NOI18N
        botonVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVentasActionPerformed(evt);
            }
        });
        botonVentas.setBounds(75, 123, 200, 65);
        jLayeredPane1.add(botonVentas, javax.swing.JLayeredPane.DEFAULT_LAYER);

        botonCompras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/boton-compras1.png"))); // NOI18N
        botonCompras.setToolTipText("Nueva Compra (Proveedor)");
        botonCompras.setContentAreaFilled(false);
        botonCompras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonCompras.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonCompras.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/boton-compras2.png"))); // NOI18N
        botonCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonComprasActionPerformed(evt);
            }
        });
        botonCompras.setBounds(75, 178, 200, 65);
        jLayeredPane1.add(botonCompras, javax.swing.JLayeredPane.DEFAULT_LAYER);

        botonProveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/boton-proveedores1.png"))); // NOI18N
        botonProveedores.setToolTipText("Nuevo Proveedor");
        botonProveedores.setContentAreaFilled(false);
        botonProveedores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonProveedores.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonProveedores.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/boton-proveedores2.png"))); // NOI18N
        botonProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonProveedoresActionPerformed(evt);
            }
        });
        botonProveedores.setBounds(75, 288, 200, 65);
        jLayeredPane1.add(botonProveedores, javax.swing.JLayeredPane.DEFAULT_LAYER);

        botonAdministrarCuentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/boton-cuentas-usuario1.png"))); // NOI18N
        botonAdministrarCuentas.setToolTipText("Herramientas del Sistema");
        botonAdministrarCuentas.setContentAreaFilled(false);
        botonAdministrarCuentas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonAdministrarCuentas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonAdministrarCuentas.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/boton-cuentas-usuario2.png"))); // NOI18N
        botonAdministrarCuentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAdministrarCuentasActionPerformed(evt);
            }
        });
        botonAdministrarCuentas.setBounds(75, 398, 200, 65);
        jLayeredPane1.add(botonAdministrarCuentas, javax.swing.JLayeredPane.DEFAULT_LAYER);

        botonMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/boton_menos.png"))); // NOI18N
        botonMinimizar.setToolTipText("Minimizar");
        botonMinimizar.setContentAreaFilled(false);
        botonMinimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonMinimizar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/boton_menos2.png"))); // NOI18N
        botonMinimizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMinimizarActionPerformed(evt);
            }
        });
        botonMinimizar.setBounds(35, 5, 30, 30);
        jLayeredPane1.add(botonMinimizar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        botonCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cerrar.png"))); // NOI18N
        botonCerrar.setToolTipText("Salir");
        botonCerrar.setContentAreaFilled(false);
        botonCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonCerrar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cerrar2.png"))); // NOI18N
        botonCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCerrarActionPerformed(evt);
            }
        });
        botonCerrar.setBounds(5, 5, 30, 30);
        jLayeredPane1.add(botonCerrar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        botonReportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/boton-reportes1.png"))); // NOI18N
        botonReportes.setToolTipText("Nuevo Reporte");
        botonReportes.setContentAreaFilled(false);
        botonReportes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonReportes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonReportes.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/boton-reportes2.png"))); // NOI18N
        botonReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonReportesActionPerformed(evt);
            }
        });
        botonReportes.setBounds(75, 343, 200, 65);
        jLayeredPane1.add(botonReportes, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lblTitulo.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Menú Principal");
        lblTitulo.setBounds(180, 10, 120, 22);
        jLayeredPane1.add(lblTitulo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lblFecha.setFont(new java.awt.Font("Candara", 1, 12)); // NOI18N
        lblFecha.setForeground(new java.awt.Color(255, 255, 255));
        lblFecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFecha.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblFecha.setBounds(370, 10, 130, 18);
        jLayeredPane1.add(lblFecha, javax.swing.JLayeredPane.DEFAULT_LAYER);

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo-menuinicio3.png"))); // NOI18N
        fondo.setBounds(0, 0, 510, 563);
        jLayeredPane1.add(fondo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAlmacenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAlmacenActionPerformed
    
        
    if(Usuarios.nombre.equals("administrador")){
    new Almacen(this,true).setVisible(true);
    }
    else{
    JOptionPane.showInternalMessageDialog(fondo, "No cuentas con los permisos necesarios para acceder");
    }
        
    }//GEN-LAST:event_botonAlmacenActionPerformed

    private void botonVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVentasActionPerformed
        new Ventas(this,true).setVisible(true);
   
    }//GEN-LAST:event_botonVentasActionPerformed

    private void botonComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonComprasActionPerformed
        try {
            new Compras(this, true).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Menu_Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botonComprasActionPerformed

    private void botonProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonProveedoresActionPerformed
     if(Usuarios.nombre.equals("administrador")){
     new Proveedores(this,true).setVisible(true);
     }
    else{
    JOptionPane.showInternalMessageDialog(fondo, "No cuentas con los permisos necesarios para acceder");
    }
    }//GEN-LAST:event_botonProveedoresActionPerformed

    private void botonAdministrarCuentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAdministrarCuentasActionPerformed
if(Usuarios.nombre.equals("administrador")){
     new Herramientas(this, true).setVisible(true);
     }
    else{
    JOptionPane.showInternalMessageDialog(fondo, "No cuentas con los permisos necesarios para acceder");
    }
    }//GEN-LAST:event_botonAdministrarCuentasActionPerformed

    private void botonMinimizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMinimizarActionPerformed
 this.setState(Frame.ICONIFIED); 
     
    }//GEN-LAST:event_botonMinimizarActionPerformed

    private void botonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCerrarActionPerformed
         
         
        int op= JOptionPane.showInternalConfirmDialog(fondo, "¿Deseas salir de la aplicacion?","Advertencia",0,2);
       if(op==0){
        
        System.exit(0);
       }
    }//GEN-LAST:event_botonCerrarActionPerformed

    private void botonReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonReportesActionPerformed
    if(Usuarios.nombre.equals("administrador")){
     new Reportes(this,true).setVisible(true);
     }
    else{
    JOptionPane.showInternalMessageDialog(fondo, "No cuentas con los permisos necesarios para acceder");
    }
    }//GEN-LAST:event_botonReportesActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int op= JOptionPane.showInternalConfirmDialog(fondo,"¿Deseas salir de la aplicacion?");
        System.out.println("asdads");
        if(op==0){
        
        System.exit(0);
       }
       else{
       new Menu_Inicio().setVisible(true);
       }
    }//GEN-LAST:event_formWindowClosing

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
       int op= JOptionPane.showInternalConfirmDialog(fondo,"¿Deseas salir de la aplicacion?");
        System.out.println("asas");
       if(op==0){
        
        System.exit(0);
       }
       else{
      
       }
    }//GEN-LAST:event_formWindowClosed

    
    public static void main(String args[]) {
        
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } 
    
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Menu_Inicio().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAdministrarCuentas;
    private javax.swing.JButton botonAlmacen;
    private javax.swing.JButton botonCerrar;
    private javax.swing.JButton botonCompras;
    private javax.swing.JButton botonMinimizar;
    private javax.swing.JButton botonProveedores;
    private javax.swing.JButton botonReportes;
    private javax.swing.JButton botonVentas;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
}
