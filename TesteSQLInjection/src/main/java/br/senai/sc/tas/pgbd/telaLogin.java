/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.tas.pgbd;


import br.senai.sc.tas.pgbd.db.ConexaoSingleton;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Everton
 */
public class telaLogin extends javax.swing.JFrame {

    /**
     * Creates new form telaLogin
     */
    public telaLogin() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        usuarioField = new javax.swing.JTextField();
        senhaTextField = new javax.swing.JPasswordField();
        entrarButton = new javax.swing.JButton();
        sqlLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LOGIN");

        jLabel1.setText("usuário:");

        jLabel2.setText("senha:");

        usuarioField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioFieldActionPerformed(evt);
            }
        });

        entrarButton.setText("Entrar");
        entrarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entrarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(entrarButton)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(usuarioField)
                        .addComponent(senhaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(329, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sqlLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(usuarioField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(senhaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(entrarButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addComponent(sqlLabel)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void usuarioFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usuarioFieldActionPerformed

    private void entrarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entrarButtonActionPerformed
        String sql = "select name from Usuario where user = '" + usuarioField.getText().trim() + "' and password = '" + new String(senhaTextField.getPassword()) + "'";
        sqlLabel.setText(sql);
        try {
            Connection conn = ConexaoSingleton.getConexao();
            ResultSet rs = conn.createStatement().executeQuery(sql);

            if (rs.next()) {
                String nome = rs.getString("name");
                if (nome != null) {
                    JOptionPane.showMessageDialog(null, "Login efetuado com sucesso");
                } else {
                    JOptionPane.showMessageDialog(null, "Login FALHOU");
                }
            }else{
                 JOptionPane.showMessageDialog(null, "Usuário ou senha inválidos");
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro no acesso a tabela Usuario.");
            Logger.getLogger(telaLogin.class.getName()).log(Level.SEVERE, null, sql);
            Logger.getLogger(telaLogin.class.getName()).log(Level.SEVERE, null, ex);

        }


    }//GEN-LAST:event_entrarButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        String servidor, usuario, senha;
        servidor = "localhost";
        usuario = "root";
        senha = "root";
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(telaLogin.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaLogin.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaLogin.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaLogin.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

         for(int i = 0; i<args.length; i++) {
             if (args[i].substring(0, 2).equals("-h") ) {
                servidor = args[i].substring(2);
             }
             if (args[i].substring(0, 2).equals("-u") ) {
                usuario = args[i].substring(2);
             }
             if (args[i].substring(0, 2).equals("-p") ) {
                senha = args[i].substring(2);
             }
                
         System.out.println("args[" + i + "]: " + args[i]);
         }

        Connection conn = null;
        try {
            conn = ConexaoSingleton.getConexao(servidor, usuario, senha);
            conn.createStatement().execute("CREATE SCHEMA IF NOT EXISTS `corp` DEFAULT CHARACTER SET utf8 ;");
            conn.createStatement().execute("USE `corp`;");
            conn.createStatement().execute("DROP TABLE IF EXISTS `corp`.`Usuario` ;");
            conn.createStatement().execute("CREATE  TABLE IF NOT EXISTS `corp`.`Usuario` (\n"
                    + "  `user` varchar(10) not null, `name` VARCHAR(50) NOT NULL, `password` VARCHAR(50) NOT NULL , PRIMARY KEY (`user`) )\n"
                    + "ENGINE = InnoDB;");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na criação do banco de dados.");
            Logger
                    .getLogger(telaLogin.class
                            .getName()).log(Level.SEVERE, null, ex);
            System.exit(-1);
        }

        try {

            conn.createStatement().execute("insert into corp.Usuario values ('telles', 'Everton Luis Telles', '123456');");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na inserção dos dados.");
            Logger
                    .getLogger(telaLogin.class
                            .getName()).log(Level.SEVERE, null, ex);
            System.exit(-1);
        }
        /*
                senha:  a' or 1=1; --   
         */

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new telaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton entrarButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField senhaTextField;
    private javax.swing.JLabel sqlLabel;
    private javax.swing.JTextField usuarioField;
    // End of variables declaration//GEN-END:variables
}