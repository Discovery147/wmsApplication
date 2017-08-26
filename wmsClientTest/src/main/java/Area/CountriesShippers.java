package Area;

import Connection.ConnectionToRest;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.logging.*;
import org.json.*;

public class CountriesShippers extends javax.swing.JFrame {
    ConnectionToRest connection;
    public CountriesShippers() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Shippers = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        Countries = new javax.swing.JComboBox<>();
        addInfo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        Shippers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShippersActionPerformed(evt);
            }
        });

        jLabel1.setText("Производитель ~> Страна");

        addInfo.setText("Добавить");
        addInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addInfoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Shippers, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(Countries, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(addInfo)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Shippers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Countries, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addInfo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addInfoActionPerformed
        try {
            connection = new ConnectionToRest();            
            OutputStream os = connection.postShippersCountries().getOutputStream();
            String shipper = String.valueOf(Shippers.getSelectedItem()).split("\\.")[0];
            String country = String.valueOf(Countries.getSelectedItem()).split("\\.")[0];          
            os.write((shipper+"."+country).toString().getBytes());
            os.flush();
            os.close();
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getConnection().getInputStream()));
            while (in.readLine() != null) {}
            System.out.println("\nCrunchify REST Service Invoked Successfully..");
            in.close();
            connection.getConnection().disconnect();
        } catch (IOException ex) {
            Logger.getLogger(CountriesShippers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addInfoActionPerformed

    private void ShippersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShippersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ShippersActionPerformed


    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CountriesShippers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CountriesShippers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CountriesShippers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CountriesShippers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CountriesShippers().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Countries;
    private javax.swing.JComboBox<String> Shippers;
    private javax.swing.JButton addInfo;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

    public void fillBoxes() throws JSONException, IOException {
        BufferedReader br = null;
        connection = new ConnectionToRest();
        br = new BufferedReader(new InputStreamReader(
                (connection.getShippersAndCountries().getInputStream()), StandardCharsets.UTF_8));
        String output = br.readLine();
        JSONArray obj = new JSONArray(output);
        for(int i=0; i<obj.length();i++)
        {
            JSONObject first = obj.getJSONObject(i);
            Shippers.addItem(first.getString("id")+"."+first.getString("name"));
        }
        br = new BufferedReader(new InputStreamReader(
                (connection.getShippersAndCountriesTwo().getInputStream()), StandardCharsets.UTF_8));
        output = br.readLine();
        obj = new JSONArray(output);
        for(int i=0; i<obj.length();i++)
        {
            JSONObject first = obj.getJSONObject(i);
            Countries.addItem(first.getString("id")+"."+first.getString("name"));
        }
        connection.getConnection().disconnect();
    }
}
