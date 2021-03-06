/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import javax.swing.JLabel;

/**
 *
 * @author Carlos
 */
public class Menu extends javax.swing.JFrame {
    
    Logica logica=new Logica(this);
    /**
     * Creates new form Menu
     */
    public Menu() {
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

        btnIngresarInorden = new javax.swing.JButton();
        btnBorrarInorden = new javax.swing.JButton();
        btnIngresarPreorden = new javax.swing.JButton();
        btnBorrarPreorden = new javax.swing.JButton();
        btnIngresarPostorden = new javax.swing.JButton();
        btnBorrarPostorden = new javax.swing.JButton();
        btnDibujar = new javax.swing.JButton();
        lblInorden = new javax.swing.JLabel();
        lblPreorden = new javax.swing.JLabel();
        lblPostorden = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(255, 255, 255));

        btnIngresarInorden.setText("Ingresar Inorden");
        btnIngresarInorden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarInordenActionPerformed(evt);
            }
        });

        btnBorrarInorden.setText("Borrar Inorden");
        btnBorrarInorden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarInordenActionPerformed(evt);
            }
        });

        btnIngresarPreorden.setText("Ingresar Preorden");
        btnIngresarPreorden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarPreordenActionPerformed(evt);
            }
        });

        btnBorrarPreorden.setText("Borrar Preorden");
        btnBorrarPreorden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarPreordenActionPerformed(evt);
            }
        });

        btnIngresarPostorden.setText("Ingresar Postorden");
        btnIngresarPostorden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarPostordenActionPerformed(evt);
            }
        });

        btnBorrarPostorden.setText("Borrar Postorden");
        btnBorrarPostorden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarPostordenActionPerformed(evt);
            }
        });

        btnDibujar.setText("Dibujar");
        btnDibujar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDibujarActionPerformed(evt);
            }
        });

        lblInorden.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInorden.setToolTipText("");

        lblPreorden.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblPostorden.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnIngresarPreorden, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnIngresarInorden, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnIngresarPostorden))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(btnBorrarPostorden))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(btnBorrarInorden, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnBorrarPreorden, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)))))
                            .addComponent(lblPostorden, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(lblInorden, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPreorden, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24))
            .addGroup(layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(btnDibujar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIngresarInorden)
                    .addComponent(btnBorrarInorden))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblInorden, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIngresarPreorden)
                    .addComponent(btnBorrarPreorden))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPreorden, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIngresarPostorden)
                    .addComponent(btnBorrarPostorden))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPostorden, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDibujar)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBorrarPostordenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarPostordenActionPerformed
        logica.borrarPos();
    }//GEN-LAST:event_btnBorrarPostordenActionPerformed

    private void btnBorrarPreordenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarPreordenActionPerformed
        logica.borrarPre();
    }//GEN-LAST:event_btnBorrarPreordenActionPerformed

    private void btnIngresarInordenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarInordenActionPerformed
        logica.insertarIn();
    }//GEN-LAST:event_btnIngresarInordenActionPerformed

    private void btnIngresarPreordenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarPreordenActionPerformed
        logica.insertarPre();
    }//GEN-LAST:event_btnIngresarPreordenActionPerformed

    private void btnIngresarPostordenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarPostordenActionPerformed
        logica.insertarPos();
    }//GEN-LAST:event_btnIngresarPostordenActionPerformed

    private void btnDibujarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDibujarActionPerformed
        logica.imprimir();
    }//GEN-LAST:event_btnDibujarActionPerformed

    private void btnBorrarInordenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarInordenActionPerformed
        logica.borrarIn();
    }//GEN-LAST:event_btnBorrarInordenActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }
    
    public JLabel getLblInorden() {
        return lblInorden;
    }

    public JLabel getLblPosorden() {
        return lblPostorden;
    }

    public JLabel getLblPreorden() {
        return lblPreorden;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrarInorden;
    private javax.swing.JButton btnBorrarPostorden;
    private javax.swing.JButton btnBorrarPreorden;
    private javax.swing.JButton btnDibujar;
    private javax.swing.JButton btnIngresarInorden;
    private javax.swing.JButton btnIngresarPostorden;
    private javax.swing.JButton btnIngresarPreorden;
    private javax.swing.JLabel lblInorden;
    private javax.swing.JLabel lblPostorden;
    private javax.swing.JLabel lblPreorden;
    // End of variables declaration//GEN-END:variables
}
