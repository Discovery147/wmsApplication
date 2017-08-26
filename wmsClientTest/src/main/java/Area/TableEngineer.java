package Area;

import Connection.ConnectionToRest;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.logging.*;
import javax.swing.JOptionPane;
import javax.swing.RowSorter.SortKey;
import javax.swing.SortOrder;
import javax.swing.table.*;
import org.json.*;


public class TableEngineer extends javax.swing.JFrame {

    ConnectionToRest connection;
    public TableEngineer() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        tableName = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableOfEngineer = new javax.swing.JTable();
        Save = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel2.setForeground(new java.awt.Color(0, 153, 204));

        tableName.setForeground(new java.awt.Color(255, 255, 255));
        tableName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tableName.setText("Наименование таблицы: ");

        tableOfEngineer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tableOfEngineer.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tableOfEngineer);

        Save.setForeground(new java.awt.Color(0, 102, 0));
        Save.setText("Сохранить");
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });

        jButton2.setForeground(new java.awt.Color(204, 0, 0));
        jButton2.setText("Отмена");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("Добавить");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Удалить");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(255, 153, 102));
        jButton4.setText("Удалить все");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(tableName, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                .addGap(68, 68, 68))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(Save, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tableName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Save)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
        String [] name = tableName.getText().split(": ");
        
        connection = new ConnectionToRest(); 
        JSONArray result = new JSONArray();  
        OutputStream os = null;
        if(name[1].equals("Продукция"))
        {               
            for(int i=0; i<tableOfEngineer.getRowCount(); i++)
            {
                try {
                    JSONObject jo = new JSONObject();
                    jo.put("Id", tableOfEngineer.getValueAt(i, 0));
                    jo.put("Na", tableOfEngineer.getValueAt(i, 1));
                    jo.put("Ty", tableOfEngineer.getValueAt(i, 2));
                    jo.put("Me", tableOfEngineer.getValueAt(i, 3));
                    jo.put("Co", tableOfEngineer.getValueAt(i, 4));
                    result.put(jo);
                } catch (JSONException ex) {
                    Logger.getLogger(TableEngineer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                os = connection.postAllInfoProducts().getOutputStream();
            } catch (IOException ex) {
                Logger.getLogger(TableEngineer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(name[1].equals("Компании-отправители"))
        {
            for(int i=0; i<tableOfEngineer.getRowCount(); i++)
            {
                try {
                    JSONObject jo = new JSONObject();
                    jo.put("Id", tableOfEngineer.getValueAt(i, 0));
                    jo.put("Or", tableOfEngineer.getValueAt(i, 1));
                    jo.put("Ad", tableOfEngineer.getValueAt(i, 2));
                    jo.put("Em", tableOfEngineer.getValueAt(i, 3));
                    jo.put("Ph", tableOfEngineer.getValueAt(i, 4));
                    result.put(jo);
                } catch (JSONException ex) {
                    Logger.getLogger(TableEngineer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                os = connection.postAllInfoShippers().getOutputStream();
            } catch (IOException ex) {
                Logger.getLogger(TableEngineer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(name[1].equals("Компании-получатели"))
        {
            for(int i=0; i<tableOfEngineer.getRowCount(); i++)
            {
                try {
                    JSONObject jo = new JSONObject();
                    jo.put("Id", tableOfEngineer.getValueAt(i, 0));
                    jo.put("Or", tableOfEngineer.getValueAt(i, 1));
                    jo.put("Ad", tableOfEngineer.getValueAt(i, 2));
                    jo.put("Co", tableOfEngineer.getValueAt(i, 3));
                    result.put(jo);
                } catch (JSONException ex) {
                    Logger.getLogger(TableEngineer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                os = connection.postAllInfoDestination().getOutputStream();
            } catch (IOException ex) {
                Logger.getLogger(TableEngineer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(name[1].equals("Персонал"))
        {
            for(int i=0; i<tableOfEngineer.getRowCount(); i++)
            {
                try {
                    JSONObject jo = new JSONObject();
                    jo.put("Id", tableOfEngineer.getValueAt(i, 0));
                    jo.put("Fi", tableOfEngineer.getValueAt(i, 1));
                    jo.put("La", tableOfEngineer.getValueAt(i, 2));
                    jo.put("Em", tableOfEngineer.getValueAt(i, 3));
                    jo.put("Mo", tableOfEngineer.getValueAt(i, 4));
                    jo.put("Po", tableOfEngineer.getValueAt(i, 5));
                    jo.put("Lo", tableOfEngineer.getValueAt(i, 6));
                    jo.put("Pa", tableOfEngineer.getValueAt(i, 7));
                    result.put(jo);
                } catch (JSONException ex) {
                    Logger.getLogger(TableEngineer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                os = connection.postAllInfoWorkers().getOutputStream();
            } catch (IOException ex) {
                Logger.getLogger(TableEngineer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try 
        {           
            System.out.println("Data: "+result.toString());
            os.write(result.toString().getBytes());
            os.flush();
            os.close();
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getConnection().getInputStream()));
            while (in.readLine() != null) {}
            System.out.println("\nCrunchify REST Service Invoked Successfully..");
            in.close();
            JOptionPane.showMessageDialog(null, "Данные сохранены!", "Уведомление",   JOptionPane.INFORMATION_MESSAGE);
            connection.getConnection().disconnect();
        } 
        catch (IOException ex){}
    }//GEN-LAST:event_SaveActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DefaultTableModel model = (DefaultTableModel) tableOfEngineer.getModel();
        model.addRow(new Object[]{});
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        DefaultTableModel model = (DefaultTableModel) tableOfEngineer.getModel();
        int rowCount = model.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        DefaultTableModel model = (DefaultTableModel) tableOfEngineer.getModel();
        int[] rows = tableOfEngineer.getSelectedRows();
        for(int i=0;i<rows.length;i++){
          model.removeRow(rows[i]-i);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(TableEngineer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TableEngineer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TableEngineer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TableEngineer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TableEngineer().setVisible(true);
            }
        });
    }

    public void setTableName(String name)
    {
        tableName.setText(tableName.getText()+name);
    }
    public void fillTable(int type)throws Exception
    {
        BufferedReader br = null;
        connection = new ConnectionToRest();
        switch(type){
            case 1:
                 br = new BufferedReader(new InputStreamReader(
                (connection.getAllProducts().getInputStream()), StandardCharsets.UTF_8));
                 break;
            case 2:
                br = new BufferedReader(new InputStreamReader(
                (connection.getAllInfoShippers().getInputStream()), StandardCharsets.UTF_8));
                break;
            case 3:
                br = new BufferedReader(new InputStreamReader(
                (connection.getDestinations().getInputStream()), StandardCharsets.UTF_8));
                break;
            case 4:
                br = new BufferedReader(new InputStreamReader(
                (connection.getAllInfoWorkers().getInputStream()), StandardCharsets.UTF_8));
                break;
        }        
        String output = br.readLine();
        connection.getConnection().disconnect();
        System.out.println(output);
        JSONArray obj = new JSONArray(output);
        DefaultTableModel model = (DefaultTableModel) tableOfEngineer.getModel();
        Vector row;
        switch(type)
        {
            case 1:
                model.addColumn("Номер"); model.addColumn("Наименование"); model.addColumn("Тип");
                model.addColumn("Мера"); model.addColumn("Код");
                for(int i=0; i<obj.length();i++)
                {
                    row = new Vector();
                    JSONObject first = obj.getJSONObject(i);
                    row.add(first.getString("idproduct"));
                    row.add(first.getString("name"));
                    row.add(first.getString("type"));
                    row.add(first.getString("measure"));
                    row.add(first.getString("code"));
                    model.addRow(row);
                }
                break;
            case 2:
                model.addColumn("Страна"); model.addColumn("Организация"); model.addColumn("Адрес");
                for(int i=0; i<obj.length();i++)
                {
                    row = new Vector();
                    JSONObject first = obj.getJSONObject(i);
                    row.add(first.getString("Id"));
                    row.add(first.getString("Or"));
                    row.add(first.getString("Ad"));
                    model.addRow(row);
                }
                break;
            case 3:
                model.addColumn("Номер"); model.addColumn("Организация");
                model.addColumn("Адрес"); model.addColumn("Телефон");
                for(int i=0; i<obj.length();i++)
                {
                    row = new Vector();
                    JSONObject first = obj.getJSONObject(i);
                    row.add(first.getString("idOfDestination"));
                    row.add(first.getString("Organization"));
                    row.add(first.getString("Address"));
                    row.add(first.getString("ContactPhone"));
                    model.addRow(row);
                }
                break;
            case 4:
                model.addColumn("Номер"); model.addColumn("Имя");
                model.addColumn("Фамилия"); model.addColumn("Почта");
                model.addColumn("Телефон"); model.addColumn("Позиция");
                model.addColumn("log"); model.addColumn("pas");
                for(int i=0; i<obj.length();i++)
                {
                    row = new Vector();
                    JSONObject first = obj.getJSONObject(i);
                    row.add(first.getString("Id"));
                    row.add(first.getString("Fi"));
                    row.add(first.getString("La"));
                    row.add(first.getString("Em"));
                    row.add(first.getString("Mo"));
                    row.add(first.getString("Po"));
                    row.add(first.getString("Lo"));
                    row.add(first.getString("Pa"));
                    model.addRow(row);
                }
                break;                
        }
        for (int i = model.getRowCount() - 1; i >= 0; i--)
        {
            if (model.getValueAt(i, 1) == null)
                model.removeRow(i);
        }
        
        TableRowSorter sorter=new TableRowSorter(model); //Создаем сортировщик
        sorter.setSortable(1, true); //Указываем, что сортировать будем в первой колонке
        //sorter.setSortable(0, false); // а в других нет
       // sorter.setSortable(2, false);
       // sorter.setSortable(3, false);
       // sorter.setSortable(4, false);
        ArrayList<SortKey> keys=new ArrayList<SortKey>(); // создаем коллецию ключей сортировки
        keys.add(new SortKey(0, SortOrder.DESCENDING));  //Записываем два ключа !!! (если задать
        keys.add(new SortKey(0, SortOrder.DESCENDING));  //один раз, то сортировщик по-умолчанию
                                                                              //DefaultRowSorter от которого происходит
                                                                              //TableRowSorter автоматически добавит
                                                                             //SortOrder.ASCENDING
        sorter.setSortKeys(keys);                                   //Добавляем ключи к сортировщику
        sorter.toggleSortOrder(1);                                  //Сортируем первую колонку
        sorter.setSortsOnUpdates(true);                         //Указываем автоматически сортировать
                                                                            //при изменении модели данных
        tableOfEngineer.setRowSorter(sorter);                        //Устанавливаем сортировщик в таблицу
        
        
        br.close();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Save;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel tableName;
    private javax.swing.JTable tableOfEngineer;
    // End of variables declaration//GEN-END:variables
}
