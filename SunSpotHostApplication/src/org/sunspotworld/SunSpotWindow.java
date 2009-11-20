package org.sunspotworld;

import java.awt.Color;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Window.java
 *
 * Created on 6/Nov/2009, 12:28:45
 */

/**
 *
 * @author flaviocruz
 */
public class SunSpotWindow extends javax.swing.JFrame {

    private int oldSecondsMovement = 4;
    private int oldSecondsLuminosity = 3;
    private int oldSecondsTemperature = 2;
    
    private int secondsMovement = 4;
    private int secondsLuminosity = 3;
    private int secondsTemperature = 2;
    
    /** Creates new form Window */
    public SunSpotWindow() {
        initComponents();
        sliderMovement.setValue(oldSecondsMovement);
        sliderLuminosity.setValue(oldSecondsLuminosity);
        sliderTemperature.setValue(oldSecondsTemperature);
        movementValueChanged(null);
        temperatureValueChanged(null);
        luminosityValueChanged(null);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        sliderMovement = new javax.swing.JSlider();
        sliderLuminosity = new javax.swing.JSlider();
        sliderTemperature = new javax.swing.JSlider();
        labelLuminosity = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        labelTemperature = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        labelMovement = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sun spot host application");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        sliderMovement.setMaximum(60);
        sliderMovement.setMinimum(1);
        sliderMovement.setValue(4);
        sliderMovement.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                movementValueChanged(evt);
            }
        });

        sliderLuminosity.setMaximum(60);
        sliderLuminosity.setMinimum(1);
        sliderLuminosity.setValue(2);
        sliderLuminosity.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                luminosityValueChanged(evt);
            }
        });

        sliderTemperature.setMaximum(60);
        sliderTemperature.setMinimum(1);
        sliderTemperature.setValue(3);
        sliderTemperature.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                temperatureValueChanged(evt);
            }
        });

        labelLuminosity.setText("Val");

        jLabel2.setText("Temperatura:");

        labelTemperature.setText("Val");

        jLabel3.setText("Movimento:");

        labelMovement.setText("Val");

        jLabel1.setText("Luminosidade:");

        jButton1.setText("Broadcast");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jLabel3)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(sliderMovement, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                            .add(jLabel2)
                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                            .add(sliderTemperature, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(jPanel1Layout.createSequentialGroup()
                            .add(jLabel1)
                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                            .add(sliderLuminosity, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(labelTemperature)
                    .add(labelMovement)
                    .add(labelLuminosity, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 34, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(99, Short.MAX_VALUE)
                .add(jButton1)
                .add(136, 136, 136))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(16, 16, 16)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel1)
                    .add(sliderLuminosity, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(labelLuminosity, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 14, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(sliderTemperature, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 29, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel2)
                    .add(labelTemperature))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(sliderMovement, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 29, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel3)
                    .add(labelMovement))
                .add(18, 18, 18)
                .add(jButton1)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(6, 6, 6)
                        .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(24, 24, 24)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 236, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void movementValueChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_movementValueChanged
        secondsMovement = sliderMovement.getValue();
        labelMovement.setText("" + sliderMovement.getValue() + "s");
        if(secondsMovement != oldSecondsMovement) {
            labelMovement.setForeground(Color.RED);
        } else {
            labelMovement.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_movementValueChanged

    private void temperatureValueChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_temperatureValueChanged
        secondsTemperature = sliderTemperature.getValue();
        labelTemperature.setText("" + sliderTemperature.getValue() + "s");
        if(secondsTemperature != oldSecondsTemperature) {
            labelTemperature.setForeground(Color.RED);
        } else {
            labelTemperature.setForeground(Color.BLACK);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_temperatureValueChanged

    private void luminosityValueChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_luminosityValueChanged
        // TODO add your handling code here:
        secondsLuminosity = sliderLuminosity.getValue();
        labelLuminosity.setText("" + sliderLuminosity.getValue() + "s");
        if(secondsLuminosity != oldSecondsLuminosity) {
            labelLuminosity.setForeground(Color.RED);
        } else {
            labelLuminosity.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_luminosityValueChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    public void addMessage(Message m)
    {
        String s = m.toString() + "\n";
        jTextArea1.append(s);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel labelLuminosity;
    private javax.swing.JLabel labelMovement;
    private javax.swing.JLabel labelTemperature;
    private javax.swing.JSlider sliderLuminosity;
    private javax.swing.JSlider sliderMovement;
    private javax.swing.JSlider sliderTemperature;
    // End of variables declaration//GEN-END:variables

}
