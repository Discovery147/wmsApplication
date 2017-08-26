package Workers;

import Area.TableProducts;
import Connection.ConnectionToRest;
import java.awt.event.KeyEvent;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.logging.*;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import org.json.*;

public class Stockman extends javax.swing.JFrame implements PackFunctions {
    
    ConnectionToRest connection;
    private String waybillClass;
    public Stockman() throws JSONException, IOException {
        
        initComponents();
        getShippers();
        getProducts();
        getProductsToExpense();
        getDestinations();
        jRadioButton2.doClick();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator7 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        workArea = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        waybill = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        shippersBox = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        productsBox = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        areaOfArrival = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        countProductSt = new javax.swing.JSpinner();
        countProductDes = new javax.swing.JSpinner();
        countProductEd = new javax.swing.JSpinner();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        dateOfArrival = new javax.swing.JSpinner();
        jSeparator6 = new javax.swing.JSeparator();
        AcceptArrivalButton = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        FinishArrival = new javax.swing.JButton();
        ButtonUndo = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        waybill1 = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        shippersBox1 = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        dateOfArrival1 = new javax.swing.JSpinner();
        shippersBox3 = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        BoxToExtense = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        FinishExpense = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 204));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                CancelData(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 6));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 6, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(255, 51, 51));
        jPanel3.setPreferredSize(new java.awt.Dimension(400, 5));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        workArea.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        workArea.setText("         Рабочая область Кладовщика: ");

        jPanel4.setBackground(new java.awt.Color(255, 255, 153));
        jPanel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setToolTipText("");
        jSeparator1.setOpaque(true);

        jLabel2.setText("Номер накладной");

        waybill.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                waybillKeyTyped(evt);
            }
        });

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator2.setOpaque(true);

        jLabel3.setText("№");

        jLabel4.setText("Дата прихода");
        jLabel4.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        jLabel5.setText("Товар");

        shippersBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shippersBoxActionPerformed(evt);
            }
        });

        jLabel6.setText("Отправитель");

        jLabel7.setText("Кол-во товара");

        areaOfArrival.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Зона разгрузки: №1", "Зона разгрузки: №2", "Зона разгрузки: №3", "Зона разгрузки: №4", "Зона разгрузки: №5", "Зона разгрузки: №6", "Зона разгрузки: №7", "Зона разгрузки: №8" }));

        jLabel8.setText("Место принятия");

        countProductSt.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 100));

        countProductDes.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 10));

        jLabel9.setText("100");

        jLabel10.setText("10");

        jLabel11.setText("1");

        dateOfArrival.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, null, java.util.Calendar.HOUR));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel2))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(areaOfArrival, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(productsBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(shippersBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(dateOfArrival)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(waybill))))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(countProductSt, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(countProductDes, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(countProductEd, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(waybill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(dateOfArrival, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(shippersBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(productsBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(countProductEd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(countProductDes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(countProductSt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(areaOfArrival, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 12, Short.MAX_VALUE))
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        AcceptArrivalButton.setBackground(new java.awt.Color(255, 102, 51));
        AcceptArrivalButton.setText("Принять на разгрузку");
        AcceptArrivalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AcceptArrivalButtonActionPerformed(evt);
            }
        });

        jCheckBox1.setSelected(true);
        jCheckBox1.setText("Разгружено");
        jCheckBox1.setEnabled(false);
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        FinishArrival.setBackground(new java.awt.Color(51, 102, 0));
        FinishArrival.setText("Завершить прием");
        FinishArrival.setEnabled(false);
        FinishArrival.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FinishArrivalActionPerformed(evt);
            }
        });

        ButtonUndo.setBackground(new java.awt.Color(153, 204, 255));
        ButtonUndo.setText("Отменить");
        ButtonUndo.setEnabled(false);
        ButtonUndo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonUndoActionPerformed(evt);
            }
        });

        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jLabel18.setIcon(new javax.swing.ImageIcon("C:\\Users\\Sizon\\wmsClient\\compass-for-orientation (1).png")); // NOI18N
        jLabel18.setText("Обновить");
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(workArea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton1))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(AcceptArrivalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ButtonUndo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(FinishArrival, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(workArea)
                            .addComponent(jLabel18)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton2)
                            .addComponent(jRadioButton1))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ButtonUndo)
                    .addComponent(AcceptArrivalButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FinishArrival)
                    .addComponent(jCheckBox1))
                .addGap(16, 16, 16))
        );

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Расход");

        jPanel5.setBackground(new java.awt.Color(153, 204, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jSeparator4.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator4.setToolTipText("");
        jSeparator4.setOpaque(true);

        jLabel12.setText("Номер накладной");

        waybill1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                waybill1KeyTyped(evt);
            }
        });

        jSeparator5.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator5.setOpaque(true);

        jLabel13.setText("№");

        jLabel14.setText("Дата расхода");
        jLabel14.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        shippersBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shippersBox1ActionPerformed(evt);
            }
        });

        jLabel16.setText("Отправитель");

        dateOfArrival1.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, null, java.util.Calendar.HOUR));

        shippersBox3.setLightWeightPopupEnabled(false);
        shippersBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shippersBox3ActionPerformed(evt);
            }
        });

        jLabel17.setText("Получатель");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator5)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel12))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel17))))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateOfArrival1)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(waybill1))
                            .addComponent(shippersBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(shippersBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(waybill1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel13))
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(12, 12, 12))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(dateOfArrival1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(shippersBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))))
                .addGap(2, 2, 2)
                .addComponent(jLabel17)
                .addGap(2, 2, 2)
                .addComponent(shippersBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(255, 102, 102));

        BoxToExtense.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoxToExtenseActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Для погрузки:");

        jButton1.setBackground(new java.awt.Color(51, 153, 255));
        jButton1.setText("Просмотр всей продукции");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                    .addComponent(BoxToExtense, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BoxToExtense, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        FinishExpense.setBackground(new java.awt.Color(51, 102, 0));
        FinishExpense.setText("Завершить погрузку");
        FinishExpense.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FinishExpenseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(FinishExpense, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FinishExpense, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AcceptArrivalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AcceptArrivalButtonActionPerformed
        connection = new ConnectionToRest(); 
        waybillClass = waybill.getText();
        String arrival[] = new String[7];
        String [] one = workArea.getText().split(": ");
        String [] two = one[1].split(Pattern.quote("."));
        arrival[0] = two[0];
        arrival[1] = waybill.getText();
        arrival[2] = (dateOfArrival.getValue()).toString();
        one = (shippersBox.getSelectedItem().toString()).split(Pattern.quote("."));
        arrival[3] = one[0];
        one = (productsBox.getSelectedItem().toString()).split(Pattern.quote("."));
        arrival[4] = one[0];
        arrival[5] = Integer.toString((Integer)countProductSt.getValue() + (Integer)countProductDes.getValue() + (Integer)countProductEd.getValue());
        arrival[6] = areaOfArrival.getSelectedItem().toString();
        String input = "{\"idWorker\":\""+arrival[0]+"\",\"wayBill\":\""+arrival[1]+"\",\"dateOfArrival\":\""+arrival[2]+"\","
                + "\"idShipper\":\""+arrival[3]+"\",\"idProduct\":\""+arrival[4]+"\",\"countProduct\":\""+arrival[5]+"\","
                + "\"areaOfArrival\":\""+arrival[6]+"\"}";
        try 
        {
            OutputStream os = connection.postArrival().getOutputStream();  
            System.out.println(input);
            os.write(input.getBytes());
            os.flush();
            os.close();
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getConnection().getInputStream()));
            while (in.readLine() != null) {}
            System.out.println("\nCrunchify REST Service Invoked Successfully..");
            in.close();
            JOptionPane.showMessageDialog(null, "Данный привоз активирован! Статус: Не разгружен.", "Уведомление",   JOptionPane.INFORMATION_MESSAGE);
            AcceptArrivalButton.setEnabled(false);
            FinishArrival.setEnabled(true);
            ButtonUndo.setEnabled(true);
            connection.getConnection().disconnect();
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(Stockman.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_AcceptArrivalButtonActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void shippersBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shippersBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_shippersBoxActionPerformed

    private void waybillKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_waybillKeyTyped
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE)))
            evt.consume();
    }//GEN-LAST:event_waybillKeyTyped

    private void ButtonUndoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonUndoActionPerformed
        connection = new ConnectionToRest(); 
        String input = "{\"waybill\":\""+waybillClass+"\"}";
        try 
        {
            OutputStream os = connection.cancelArrival().getOutputStream();  
            System.out.println(input);
            os.write(input.getBytes());
            os.flush();
            os.close();
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getConnection().getInputStream()));
            while (in.readLine() != null) {}
            System.out.println("\nCrunchify REST Service Invoked Successfully..");
            in.close();
            AcceptArrivalButton.setEnabled(true);
            FinishArrival.setEnabled(false);
            ButtonUndo.setEnabled(false);
            connection.getConnection().disconnect();
            JOptionPane.showMessageDialog(null, "Привоз отменен!", "Уведомление",   JOptionPane.INFORMATION_MESSAGE);
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(Stockman.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ButtonUndoActionPerformed

    private void FinishArrivalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FinishArrivalActionPerformed
        connection = new ConnectionToRest(); 
        String input = "{\"waybill\":\""+waybillClass+"\"}";
        try 
        {
            OutputStream os = connection.finishArrival().getOutputStream();  
            System.out.println(input);
            os.write(input.getBytes());
            os.flush();
            os.close();
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getConnection().getInputStream()));
            while (in.readLine() != null) {}
            System.out.println("\nCrunchify REST Service Invoked Successfully..");
            in.close();
            AcceptArrivalButton.setEnabled(true);
            FinishArrival.setEnabled(false);
            ButtonUndo.setEnabled(false);
            waybillClass = "";
            connection.getConnection().disconnect();
            JOptionPane.showMessageDialog(null, "Привоз оформлен! Статус: Товар разгружен.", "Уведомление",   JOptionPane.INFORMATION_MESSAGE);
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(Stockman.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_FinishArrivalActionPerformed

    private void CancelData(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_CancelData
        if(FinishArrival.isEnabled())
            ButtonUndo.doClick();
    }//GEN-LAST:event_CancelData

    private void waybill1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_waybill1KeyTyped
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE)))
            evt.consume();
    }//GEN-LAST:event_waybill1KeyTyped

    private void shippersBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shippersBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_shippersBox1ActionPerformed

    private void shippersBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shippersBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_shippersBox3ActionPerformed

    private void FinishExpenseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FinishExpenseActionPerformed
        connection = new ConnectionToRest(); 
        String waybill = waybill1.getText();
        String date = dateOfArrival1.getValue().toString();
            String [] shippers = (shippersBox.getSelectedItem().toString()).split(Pattern.quote("."));
        String idShipper = shippers[0];
            String destinations [] = (shippersBox3.getSelectedItem().toString()).split(Pattern.quote("."));
        String idOfDestination = destinations[0];
            String products [] = (BoxToExtense.getSelectedItem().toString()).split(" ");
        String idProduct = products[3];
        String countProduct = products[5];        
            String [] one = workArea.getText().split(": ");
            String [] two = one[1].split(Pattern.quote("."));
        String idWorker = two[0];
            String operations [] = (BoxToExtense.getSelectedItem().toString()).split(Pattern.quote("."));
        String idOperation = operations[0];
        
        String input = "{\"numberOfInvoice\":\""+waybill+"\",\"idShipper\":\""+idShipper+"\",\"idProduct\":\""+idProduct+"\","
                + "\"idOfDestination\":\""+idOfDestination+"\",\"countProduct\":\""+countProduct+"\",\"idWorker\":\""+idWorker+"\",\"idOperation\":\""+idOperation+"\"}";
        try 
        {
            OutputStream os = connection.postExpense().getOutputStream();  
            System.out.println(input);
            os.write(input.getBytes());
            os.flush();
            os.close();
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getConnection().getInputStream()));
            while (in.readLine() != null) {}
            System.out.println("\nCrunchify REST Service Invoked Successfully..");
            in.close();
            connection.getConnection().disconnect();
            JOptionPane.showMessageDialog(null, "Расход заверешен!", "Уведомление",   JOptionPane.INFORMATION_MESSAGE);
            int selectedIndex = BoxToExtense.getSelectedIndex();
            if (selectedIndex != -1) {
                BoxToExtense.removeItemAt(selectedIndex);
            }
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(Stockman.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_FinishExpenseActionPerformed

    private void BoxToExtenseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoxToExtenseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BoxToExtenseActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        TableProducts area = new TableProducts();
        area.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        jLabel19.setEnabled(false);
        BoxToExtense.setEnabled(false);
        jLabel12.setEnabled(false);
        jLabel13.setEnabled(false);
        waybill1.setEnabled(false);
        jLabel14.setEnabled(false);
        dateOfArrival1.setEnabled(false);
        jLabel16.setEnabled(false);
        shippersBox1.setEnabled(false);
        jLabel17.setEnabled(false);
        shippersBox3.setEnabled(false);
        FinishExpense.setEnabled(false);
        jRadioButton1.setSelected(false);
        jRadioButton2.setSelected(true);
        
        jLabel2.setEnabled(true);
        jLabel3.setEnabled(true);
        waybill.setEnabled(true);
        jLabel4.setEnabled(true);
        dateOfArrival.setEnabled(true);
        jLabel6.setEnabled(true);
        shippersBox.setEnabled(true);
        jLabel5.setEnabled(true);
        productsBox.setEnabled(true);
        jLabel7.setEnabled(true);
        jLabel9.setEnabled(true);
        countProductSt.setEnabled(true);
        jLabel10.setEnabled(true);
        countProductDes.setEnabled(true);
        jLabel11.setEnabled(true);
        countProductEd.setEnabled(true);
        jLabel8.setEnabled(true);
        areaOfArrival.setEnabled(true);
        AcceptArrivalButton.setEnabled(true);
        
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        jLabel2.setEnabled(false);
        jLabel3.setEnabled(false);
        waybill.setEnabled(false);
        jLabel4.setEnabled(false);
        dateOfArrival.setEnabled(false);
        jLabel6.setEnabled(false);
        shippersBox.setEnabled(false);
        jLabel5.setEnabled(false);
        productsBox.setEnabled(false);
        jLabel7.setEnabled(false);
        jLabel9.setEnabled(false);
        countProductSt.setEnabled(false);
        jLabel10.setEnabled(false);
        countProductDes.setEnabled(false);
        jLabel11.setEnabled(false);
        countProductEd.setEnabled(false);
        jLabel8.setEnabled(false);
        areaOfArrival.setEnabled(false);
        AcceptArrivalButton.setEnabled(false);
        
        jLabel19.setEnabled(true);
        BoxToExtense.setEnabled(true);
        jLabel12.setEnabled(true);
        jLabel13.setEnabled(true);
        waybill1.setEnabled(true);
        jLabel14.setEnabled(true);
        dateOfArrival1.setEnabled(true);
        jLabel16.setEnabled(true);
        shippersBox1.setEnabled(true);
        jLabel17.setEnabled(true);
        shippersBox3.setEnabled(true);
        FinishExpense.setEnabled(true);
        jRadioButton1.setSelected(true);
        jRadioButton2.setSelected(false);
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
        try {
            Stockman obj = new Stockman();
            obj.setVisible(true);
            obj.setWorkerInfo(workArea.getText());
            this.dispose();
             JOptionPane.showMessageDialog(null, "Обновлено!", "Уведомление",   JOptionPane.INFORMATION_MESSAGE);
        } catch (JSONException ex) {
            Logger.getLogger(Stockman.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Stockman.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel18MouseClicked

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Stockman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Stockman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Stockman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Stockman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Stockman().setVisible(true);
                } catch (JSONException ex) {
                    Logger.getLogger(Stockman.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Stockman.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AcceptArrivalButton;
    private javax.swing.JComboBox<String> BoxToExtense;
    private javax.swing.JButton ButtonUndo;
    private javax.swing.JButton FinishArrival;
    private javax.swing.JButton FinishExpense;
    private javax.swing.JComboBox<String> areaOfArrival;
    private javax.swing.JSpinner countProductDes;
    private javax.swing.JSpinner countProductEd;
    private javax.swing.JSpinner countProductSt;
    private javax.swing.JSpinner dateOfArrival;
    private javax.swing.JSpinner dateOfArrival1;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JComboBox<String> productsBox;
    private javax.swing.JComboBox<String> shippersBox;
    private javax.swing.JComboBox<String> shippersBox1;
    private javax.swing.JComboBox<String> shippersBox3;
    private javax.swing.JTextField waybill;
    private javax.swing.JTextField waybill1;
    private javax.swing.JLabel workArea;
    // End of variables declaration//GEN-END:variables
   
    @Override
    public void setWorkerInfo(int id, String firstname, String lastname){
        workArea.setText(workArea.getText() + id + ". " + firstname + " " + lastname);
    }
    
    public void setWorkerInfo(String s){
        workArea.setText(s);
    }

    private void getShippers() throws JSONException, IOException {

        connection = new ConnectionToRest();		

        BufferedReader br = new BufferedReader(new InputStreamReader(
                (connection.getShippers().getInputStream()), StandardCharsets.UTF_8));
        String output = br.readLine();             
        connection.getConnection().disconnect(); 
        JSONArray obj = new JSONArray(output);
        for(int i=0; i<obj.length();i++)
        {
            System.out.println(output);
            JSONObject first = obj.getJSONObject(i);
            shippersBox.addItem(first.getString("id") + ". " + first.getString("organization"));
            shippersBox1.addItem(first.getString("id") + ". " + first.getString("organization"));
        }

    }

    private void getProducts() throws JSONException, IOException {
        connection = new ConnectionToRest();	
        BufferedReader br = new BufferedReader(new InputStreamReader(
                (connection.getProducts().getInputStream()), StandardCharsets.UTF_8));
        String output = br.readLine();             
        connection.getConnection().disconnect(); 
        JSONArray obj = new JSONArray(output);
        for(int i=0; i<obj.length();i++)
        {
            System.out.println(output);
            JSONObject first = obj.getJSONObject(i);
            productsBox.addItem(first.getString("idProduct") + ". " + first.getString("Name") + " <" + first.getString("Measure") + ">");
        }
    }

    private void getProductsToExpense() throws JSONException, IOException {
        connection = new ConnectionToRest();
        BufferedReader br = new BufferedReader(new InputStreamReader(
                (connection.getProductsToExpense().getInputStream()), StandardCharsets.UTF_8));
        String output = br.readLine();             
        connection.getConnection().disconnect(); 
        JSONArray obj = new JSONArray(output);
        for(int i=0; i<obj.length();i++)
        {
            JSONObject first = obj.getJSONObject(i);
            BoxToExtense.addItem(first.getString("idOperation") + ". № продукта: " + first.getString("idProduct") + " Кол-во: " + first.getString("countOfProduct") + " " + first.getString("position"));
        }
    }

    private void getDestinations() throws JSONException, IOException {
        connection = new ConnectionToRest();
        BufferedReader br = new BufferedReader(new InputStreamReader(
                (connection.getDestinations().getInputStream()), StandardCharsets.UTF_8));
        String output = br.readLine();             
        connection.getConnection().disconnect(); 
        JSONArray obj = new JSONArray(output);
        for(int i=0; i<obj.length();i++)
        {
            JSONObject first = obj.getJSONObject(i);
            shippersBox3.addItem(first.getString("idOfDestination") + ". " + first.getString("Organization") + " - " + first.getString("Address") + " - " + first.getString("ContactPhone"));
        }
    }
}
