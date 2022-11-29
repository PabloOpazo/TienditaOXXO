package donde_pablito;
import java.awt.Color;
import java.sql.*;

public class Venta extends javax.swing.JFrame {
    
    
    public Venta() {
        initComponents();
        setLocationRelativeTo(null);
        cb_Producto();
        BuscarProducto();
    }
    
    public void actualizarTabla() {
    }
    private void cb_Producto() { //llenar ComboBox de "PRODUCTO"
        try {
            ConexionBD obj = new ConexionBD();
            obj.databaseconect("donde_pablito");
            String sql = "SELECT * FROM producto WHERE stock_producto > 0";
            obj.setRs(sql);
            
            while (obj.getRs().next()) {                
                cb_producto.addItem(obj.getRs().getString("nombre_producto"));
            }
            obj.dbdesc();
            
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    private void BuscarProducto() { //Buscar un dato desde la BD
        try{
            Connection consultar = DriverManager.getConnection("jdbc:mysql://localhost/donde_pablito" ,"root","");
            PreparedStatement pst = consultar.prepareStatement("SELECT * FROM producto WHERE nombre_producto = ? AND stock_producto > 0");
            
            pst.setString(1, cb_producto.getSelectedItem().toString());
            
            ResultSet rs = pst.executeQuery();
            
            if (cb_producto.getSelectedIndex() == 0) {
                lb_precio.setText("$0");
            }
            if (rs.next()) {
                lb_precio.setText("$" + rs.getString("precio_producto"));
            } else {
                System.out.println("No queda: " + rs.getString("nombre_producto"));
            }
            
            
            
        } catch (Exception e){
            
        }
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb_titulo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cb_producto = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_detalle_venta = new javax.swing.JTable();
        lb_precio = new javax.swing.JLabel();
        bt_añadir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Comprar");
        setPreferredSize(new java.awt.Dimension(1000, 600));
        setResizable(false);

        lb_titulo.setFont(new java.awt.Font("Arial", 3, 48)); // NOI18N
        lb_titulo.setForeground(new java.awt.Color(255, 0, 0));
        lb_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_titulo.setText("Donde Pablito");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Producto:");

        cb_producto.setMaximumRowCount(99);
        cb_producto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar..." }));
        cb_producto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cb_producto.setFocusable(false);
        cb_producto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_productoItemStateChanged(evt);
            }
        });
        cb_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_productoActionPerformed(evt);
            }
        });

        tb_detalle_venta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "PRODUCTO", "CANTIDAD", "TOTAL"
            }
        ));
        jScrollPane1.setViewportView(tb_detalle_venta);

        lb_precio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lb_precio.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lb_precio.setText("$0");

        bt_añadir.setText("Añadir al carro");
        bt_añadir.setEnabled(false);
        bt_añadir.setFocusable(false);
        bt_añadir.setRolloverEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_titulo, javax.swing.GroupLayout.DEFAULT_SIZE, 1045, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb_precio, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
            .addGroup(layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(bt_añadir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_titulo)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(cb_producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lb_precio))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(bt_añadir)
                .addGap(66, 66, 66))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cb_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_productoActionPerformed
        
    }//GEN-LAST:event_cb_productoActionPerformed

    private void cb_productoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_productoItemStateChanged
        BuscarProducto();
        
        if (cb_producto.getSelectedIndex() == 0 ) {
            cb_producto.setForeground(Color.gray);
            bt_añadir.setEnabled(false);
        } else{
            cb_producto.setForeground(Color.black);
            bt_añadir.setEnabled(true);
        }
    }//GEN-LAST:event_cb_productoItemStateChanged

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
            java.util.logging.Logger.getLogger(Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Venta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_añadir;
    private javax.swing.JComboBox<String> cb_producto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_precio;
    private javax.swing.JLabel lb_titulo;
    private javax.swing.JTable tb_detalle_venta;
    // End of variables declaration//GEN-END:variables
}
