
import ProgramCodes.Classroom;
import ProgramCodes.Settings;
import databaseCodes.GradesDAO;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.text.NumberFormatter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author James
 */
public class AddComponent extends javax.swing.JDialog {

    private String examType;
    private Classroom c;
    private Settings s;
    private int totalValue = 0;
    /**
     * Creates new form AddComponent
     * @param parent
     * @param modal
     * @param examType
     * @param c
     * @param s
     */
    public AddComponent(java.awt.Frame parent, boolean modal, String examType, Classroom c, Settings s) {
        super(parent, modal);
        initComponents();
        this.c = c;
        this.s = s;
        this.examType = examType;
        JFormattedTextField txt = ((JSpinner.NumberEditor) sKnow.getEditor()).getTextField();
        ((NumberFormatter) txt.getFormatter()).setAllowsInvalid(false);
        JFormattedTextField txt2 = ((JSpinner.NumberEditor) sUnder.getEditor()).getTextField();
        ((NumberFormatter) txt2.getFormatter()).setAllowsInvalid(false);
        JFormattedTextField txt3 = ((JSpinner.NumberEditor) sPS.getEditor()).getTextField();
        ((NumberFormatter) txt3.getFormatter()).setAllowsInvalid(false);
        JFormattedTextField txt4 = ((JSpinner.NumberEditor) sP.getEditor()).getTextField();
        ((NumberFormatter) txt4.getFormatter()).setAllowsInvalid(false);
        
    }

    private AddComponent(java.awt.Frame parent, boolean modal) {
         super(parent, modal);
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

        jPanel1 = new javax.swing.JPanel();
        lblKnow = new javax.swing.JLabel();
        lblUnd = new javax.swing.JLabel();
        lblPS = new javax.swing.JLabel();
        lblPS1 = new javax.swing.JLabel();
        sKnow = new javax.swing.JSpinner();
        sUnder = new javax.swing.JSpinner();
        sPS = new javax.swing.JSpinner();
        sP = new javax.swing.JSpinner();
        jPanel2 = new javax.swing.JPanel();
        lTotal = new javax.swing.JLabel();
        btnCreate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Components");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Components"));

        lblKnow.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        lblKnow.setText("Knowledge");

        lblUnd.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        lblUnd.setText("Understanding");

        lblPS.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        lblPS.setText("Process/Skill");

        lblPS1.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        lblPS1.setText("Product");

        sKnow.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        sKnow.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sKnowStateChanged(evt);
            }
        });

        sUnder.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        sUnder.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sUnderStateChanged(evt);
            }
        });

        sPS.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        sPS.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sPSStateChanged(evt);
            }
        });

        sP.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        sP.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sPStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblPS1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(sP, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblKnow, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblUnd, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(89, 89, 89))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lblPS, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sPS, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sUnder, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sKnow, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(95, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblKnow, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sKnow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUnd, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sUnder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPS, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sPS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPS1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 490, 200));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Total"));

        lTotal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lTotal.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(458, Short.MAX_VALUE)
                .addComponent(lTotal)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(lTotal)
                .addGap(0, 14, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 490, 60));

        btnCreate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/check.png"))); // NOI18N
        btnCreate.setText("Create");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });
        getContentPane().add(btnCreate, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 323, 530, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        java.awt.Frame f = (java.awt.Frame) this.getParent();
        AddGrades g = new AddGrades(f, true, c, examType, s);
        new GradesDAO(s).addGradeComp(c, examType, ((SpinnerNumberModel) sKnow.getModel()).getNumber().intValue(), ((SpinnerNumberModel) sUnder.getModel()).getNumber().intValue(), ((SpinnerNumberModel) sPS.getModel()).getNumber().intValue(), ((SpinnerNumberModel) sP.getModel()).getNumber().intValue());
        g.setVisible(true);
        g.setTitle(this.getTitle());
        this.setVisible(false);
    }//GEN-LAST:event_btnCreateActionPerformed

    private void sKnowStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sKnowStateChanged
       lTotal.setText(Integer.toString(((SpinnerNumberModel) sKnow.getModel()).getNumber().intValue() + ((SpinnerNumberModel) sUnder.getModel()).getNumber().intValue()+ ((SpinnerNumberModel) sPS.getModel()).getNumber().intValue()+ ((SpinnerNumberModel) sP.getModel()).getNumber().intValue()));
    }//GEN-LAST:event_sKnowStateChanged

    private void sUnderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sUnderStateChanged
        lTotal.setText(Integer.toString(((SpinnerNumberModel) sKnow.getModel()).getNumber().intValue() + ((SpinnerNumberModel) sUnder.getModel()).getNumber().intValue()+ ((SpinnerNumberModel) sPS.getModel()).getNumber().intValue()+ ((SpinnerNumberModel) sP.getModel()).getNumber().intValue()));
    }//GEN-LAST:event_sUnderStateChanged

    private void sPSStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sPSStateChanged
        lTotal.setText(Integer.toString(((SpinnerNumberModel) sKnow.getModel()).getNumber().intValue() + ((SpinnerNumberModel) sUnder.getModel()).getNumber().intValue()+ ((SpinnerNumberModel) sPS.getModel()).getNumber().intValue()+ ((SpinnerNumberModel) sP.getModel()).getNumber().intValue()));
    }//GEN-LAST:event_sPSStateChanged

    private void sPStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sPStateChanged
        lTotal.setText(Integer.toString(((SpinnerNumberModel) sKnow.getModel()).getNumber().intValue() + ((SpinnerNumberModel) sUnder.getModel()).getNumber().intValue()+ ((SpinnerNumberModel) sPS.getModel()).getNumber().intValue()+ ((SpinnerNumberModel) sP.getModel()).getNumber().intValue()));
    }//GEN-LAST:event_sPStateChanged

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
            java.util.logging.Logger.getLogger(AddComponent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddComponent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddComponent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddComponent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AddComponent dialog = new AddComponent(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lTotal;
    private javax.swing.JLabel lblKnow;
    private javax.swing.JLabel lblPS;
    private javax.swing.JLabel lblPS1;
    private javax.swing.JLabel lblUnd;
    private javax.swing.JSpinner sKnow;
    private javax.swing.JSpinner sP;
    private javax.swing.JSpinner sPS;
    private javax.swing.JSpinner sUnder;
    // End of variables declaration//GEN-END:variables
}
