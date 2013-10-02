
package frames;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import utilidades.Cuentas_Usuario;
import utilidades.Usuarios;
public class Login extends javax.swing.JFrame {

    public String usr;
    public String pswd;
    private int intentosLogin;

    public Login() {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/imagenes/icono-proyecto.png")).getImage());
        this.setLocationRelativeTo(null);
        intentosLogin = 0;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        usuario = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        cancelar = new javax.swing.JButton();
        entrar = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inicio de Sesión");
        setName("frmlogin");
        setUndecorated(true);

        jLayeredPane1.setOpaque(true);

        usuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioActionPerformed(evt);
            }
        });
        usuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                usuarioKeyTyped(evt);
            }
        });
        usuario.setBounds(120, 20, 200, 25);
        jLayeredPane1.add(usuario, javax.swing.JLayeredPane.DEFAULT_LAYER);

        password.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });
        password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                passwordKeyTyped(evt);
            }
        });
        password.setBounds(120, 65, 200, 25);
        jLayeredPane1.add(password, javax.swing.JLayeredPane.DEFAULT_LAYER);

        cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/boton-cancelar1.png"))); // NOI18N
        cancelar.setContentAreaFilled(false);
        cancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancelar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/boton-cancelar2.png"))); // NOI18N
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        cancelar.setBounds(205, 120, 115, 40);
        jLayeredPane1.add(cancelar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        entrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/boton-entrar1.png"))); // NOI18N
        entrar.setContentAreaFilled(false);
        entrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        entrar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/boton-entrar2.png"))); // NOI18N
        entrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entrarActionPerformed(evt);
            }
        });
        entrar.setBounds(85, 120, 120, 38);
        jLayeredPane1.add(entrar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo-login2.png"))); // NOI18N
        fondo.setOpaque(true);
        fondo.setBounds(0, 0, 335, 180);
        jLayeredPane1.add(fondo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
System.exit(0);
}//GEN-LAST:event_cancelarActionPerformed

private void entrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entrarActionPerformed
        
    if (intentosLogin < 3) {
        if (!usuario.getText().equals("")) {
            usr = usuario.getText();
            pswd = new String(password.getPassword());
            if (Cuentas_Usuario.buscarUsuario(usr, pswd)) {
                Usuarios.nombre = usr;
                Usuarios.password = pswd;
                if (Usuarios.nombre.equals("administrador")) {

                    new Menu_Inicio().setVisible(true);
                    this.dispose();
                } else {

                    new Menu_Inicio().setVisible(true);
                    this.dispose();
                }

            } else {
                JOptionPane.showMessageDialog(this, "Usuario o Contraseña incorrectos", "Advertencia", 2);
            }
            intentosLogin += 1;
        } else {
            JOptionPane.showMessageDialog(this, "Los campos no pueden estar vacios", "Advertencia", 2);
        }
    } else {
        JOptionPane.showMessageDialog(this, "Haz superado el número máximo de intentos", "Advertencia", 0);
        System.exit(0);
    }
}//GEN-LAST:event_entrarActionPerformed

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
   
        if (intentosLogin < 3) {
            if (!usuario.getText().equals("")) {
                usr = usuario.getText();
                pswd = new String(password.getPassword());
                if (Cuentas_Usuario.buscarUsuario(usr, pswd)) {
                    Usuarios.nombre = usr;
                    Usuarios.password = pswd;
                    if (Usuarios.nombre.equals("administrador")) {

                        new Menu_Inicio().setVisible(true);
                        this.dispose();
                    } else {

                        new Menu_Inicio().setVisible(true);
                        this.dispose();
                    }


                } else {
                    JOptionPane.showMessageDialog(this, "Usuario o Contraseña incorrectos", "Advertencia", 2);
                }
                intentosLogin += 1;
            } else {
                JOptionPane.showMessageDialog(this, "Los campos no pueden estar vacios", "Advertencia", 2);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Haz superado el numero maximo de intentos", "Advertencia", 0);
            System.exit(0);
        }
    }//GEN-LAST:event_passwordActionPerformed

    private void usuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usuarioKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLetter(c) == false && Character.isDigit(c) == false) {
            evt.consume();
        }
    }//GEN-LAST:event_usuarioKeyTyped

    private void passwordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLetter(c) == false && Character.isDigit(c) == false) {
            evt.consume();
        }
    }//GEN-LAST:event_passwordKeyTyped

    private void usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioActionPerformed
       password.requestFocus();
    }//GEN-LAST:event_usuarioActionPerformed

    
    public static void main(String args[]) {
      
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
            Thread.sleep(3500);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InterruptedException e) {
        }



        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Login().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelar;
    private javax.swing.JButton entrar;
    private javax.swing.JLabel fondo;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField usuario;
    // End of variables declaration//GEN-END:variables
}
