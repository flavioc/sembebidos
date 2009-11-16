package org.sunspotworld;

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

    /** Creates new form Window */
    public SunSpotWindow() {
        initComponents();
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        sliderTemperature = new javax.swing.JSlider();
        sliderLuminosity = new javax.swing.JSlider();
        sliderMovement = new javax.swing.JSlider();
        labelLuminosity = new javax.swing.JLabel();
        labelTemperature = new javax.swing.JLabel();
        labelMovement = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sun spot host application");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel1.setText("Luminosidade:");

        jLabel2.setText("Temperatura:");

        jLabel3.setText("Movimento:");

        sliderTemperature.setMaximum(60);
        sliderTemperature.setMinimum(1);
        sliderTemperature.setValue(3);
        sliderTemperature.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                temperatureValueChanged(evt);
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

        sliderMovement.setMaximum(60);
        sliderMovement.setMinimum(1);
        sliderMovement.setValue(4);
        sliderMovement.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                movementValueChanged(evt);
            }
        });

        labelLuminosity.setText("Val");

        labelTemperature.setText("Val");

        labelMovement.setText("Val");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(83, 83, 83)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(jLabel3)
                            .add(jLabel1)
                            .add(jLabel2))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(sliderTemperature, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(labelTemperature))
                            .add(layout.createSequentialGroup()
                                .add(sliderLuminosity, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(labelLuminosity, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 34, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(layout.createSequentialGroup()
                                .add(sliderMovement, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(labelMovement)))
                        .add(60, 60, 60))
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(24, 24, 24)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(layout.createSequentialGroup()
                        .add(jLabel1)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED))
                    .add(layout.createSequentialGroup()
                        .add(sliderLuminosity, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(8, 8, 8))
                    .add(layout.createSequentialGroup()
                        .add(labelLuminosity, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 14, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)))
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(sliderTemperature, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 29, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(labelTemperature)
                    .add(jLabel2))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel3)
                    .add(sliderMovement, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 29, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(labelMovement))
                .add(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void movementValueChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_movementValueChanged
        labelMovement.setText("" + sliderMovement.getValue() + " s");
    }//GEN-LAST:event_movementValueChanged

    private void temperatureValueChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_temperatureValueChanged
        labelTemperature.setText("" + sliderTemperature.getValue() + " s");
        // TODO add your handling code here:
    }//GEN-LAST:event_temperatureValueChanged

    private void luminosityValueChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_luminosityValueChanged
        // TODO add your handling code here:
        labelLuminosity.setText("" + sliderLuminosity.getValue() + " s");
    }//GEN-LAST:event_luminosityValueChanged

    public void addMessage(Message m)
    {
        String s = m.toString() + "\n";
        jTextArea1.append(s);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
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