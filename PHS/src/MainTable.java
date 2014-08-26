
import ProgramCodes.Classroom;
import ProgramCodes.Faculty;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author James
 */
public class MainTable extends javax.swing.JFrame {
    
    Classroom c;
    Faculty teacher;
    /**
     * Creates new form Splash
     */
    public MainTable() {
        initComponents();
    }
    MainTable(Faculty emp, Classroom c) {
        initComponents();
        teacher = emp;
        IUserName.setText(teacher.getFirstName()+ " " + teacher.getLastName());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GradesScrollPane = new javax.swing.JScrollPane();
        Grades = new javax.swing.JTable();
        btnSubmit = new javax.swing.JButton();
        pClassList = new javax.swing.JPanel();
        btnQuizzes = new javax.swing.JButton();
        lblQuiz = new javax.swing.JLabel();
        lblHW = new javax.swing.JLabel();
        btnHW = new javax.swing.JButton();
        lblSW = new javax.swing.JLabel();
        btnSW = new javax.swing.JButton();
        lblProj = new javax.swing.JLabel();
        btnProj = new javax.swing.JButton();
        lblPT = new javax.swing.JLabel();
        btnPT = new javax.swing.JButton();
        lClassList = new javax.swing.JLabel();
        btnBack = new javax.swing.JLabel();
        bExport = new javax.swing.JButton();
        lbSxnSubj = new javax.swing.JLabel();
        PHSLogo = new javax.swing.JLabel();
        settingsIcon = new javax.swing.JLabel();
        IUserName = new javax.swing.JLabel();
        ribbon1 = new javax.swing.JLabel();
        ribbon = new javax.swing.JLabel();
        redbar = new javax.swing.JLabel();
        bgElement = new javax.swing.JLabel();

        setTitle("Philadelphia High School");
        setBackground(new java.awt.Color(255, 204, 204));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Grades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Name", "Quiz", "Seatwork", "Final Rating"
            }
        ));
        GradesScrollPane.setViewportView(Grades);

        getContentPane().add(GradesScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, 1080, 410));

        btnSubmit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/check.png"))); // NOI18N
        btnSubmit.setText("Submit");
        getContentPane().add(btnSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 500, 210, -1));

        pClassList.setBackground(new java.awt.Color(102, 0, 0));
        pClassList.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        pClassList.setForeground(new java.awt.Color(102, 0, 0));
        pClassList.setOpaque(false);
        pClassList.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnQuizzes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plussign.png"))); // NOI18N
        btnQuizzes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuizzesActionPerformed(evt);
            }
        });
        pClassList.add(btnQuizzes, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 40, -1));

        lblQuiz.setForeground(new java.awt.Color(255, 255, 255));
        lblQuiz.setText("Quizzes (number)");
        pClassList.add(lblQuiz, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 14, -1, -1));

        lblHW.setForeground(new java.awt.Color(255, 255, 255));
        lblHW.setText("Homework (number)");
        pClassList.add(lblHW, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 55, -1, -1));

        btnHW.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plussign.png"))); // NOI18N
        btnHW.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHWMouseClicked(evt);
            }
        });
        pClassList.add(btnHW, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 40, -1));

        lblSW.setForeground(new java.awt.Color(255, 255, 255));
        lblSW.setText("Seatwork (number)");
        pClassList.add(lblSW, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 102, 23));

        btnSW.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plussign.png"))); // NOI18N
        btnSW.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSWMouseClicked(evt);
            }
        });
        pClassList.add(btnSW, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 40, -1));

        lblProj.setForeground(new java.awt.Color(255, 255, 255));
        lblProj.setText("Project");
        pClassList.add(lblProj, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 89, 23));

        btnProj.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plussign.png"))); // NOI18N
        btnProj.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProjMouseClicked(evt);
            }
        });
        pClassList.add(btnProj, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 40, -1));

        lblPT.setBackground(new java.awt.Color(255, 255, 255));
        lblPT.setForeground(new java.awt.Color(255, 255, 255));
        lblPT.setText("P.T.");
        pClassList.add(lblPT, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 97, 23));

        btnPT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plussign.png"))); // NOI18N
        btnPT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPTMouseClicked(evt);
            }
        });
        pClassList.add(btnPT, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 40, -1));

        getContentPane().add(pClassList, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 180, 220));

        lClassList.setForeground(new java.awt.Color(255, 255, 204));
        lClassList.setText("Class List");
        getContentPane().add(lClassList, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, 20));

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/back.png"))); // NOI18N
        btnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnBackMousePressed(evt);
            }
        });
        getContentPane().add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(191, 21, 50, 50));

        bExport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/save.png"))); // NOI18N
        bExport.setText("Compile & Export");
        getContentPane().add(bExport, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 500, 160, -1));

        lbSxnSubj.setFont(new java.awt.Font("Tahoma", 3, 36)); // NOI18N
        lbSxnSubj.setForeground(new java.awt.Color(255, 204, 255));
        lbSxnSubj.setText("Section & Subject");
        getContentPane().add(lbSxnSubj, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, 390, -1));

        PHSLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/phila-logo.png"))); // NOI18N
        getContentPane().add(PHSLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, -1));
        getContentPane().add(settingsIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 500, -1, -1));

        IUserName.setText("User name");
        getContentPane().add(IUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, -1, -1));

        ribbon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ribbon.png"))); // NOI18N
        getContentPane().add(ribbon1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));
        getContentPane().add(ribbon, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 160, 60));

        redbar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bar.png"))); // NOI18N
        getContentPane().add(redbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -30, 180, -1));

        bgElement.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background2_1.png"))); // NOI18N
        getContentPane().add(bgElement, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1980, 1490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnQuizzesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuizzesActionPerformed
       AddComponent ac = new AddComponent(this,true);
       ac.setTitle("Quiz <number>");
       ac.setVisible(true);
    }//GEN-LAST:event_btnQuizzesActionPerformed

    private void btnHWMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHWMouseClicked
        AddComponent ac = new AddComponent(this,true);
        ac.setTitle("Homework <number>");
        ac.setVisible(true);
    }//GEN-LAST:event_btnHWMouseClicked

    private void btnSWMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSWMouseClicked
        AddComponent ac = new AddComponent(this,true);
        ac.setTitle("Seatwork <number>");
        ac.setVisible(true);
    }//GEN-LAST:event_btnSWMouseClicked

    private void btnProjMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProjMouseClicked
       AddProjectGrades ac = new AddProjectGrades(this,true);
        ac.setTitle("Project");
        ac.setVisible(true);
    }//GEN-LAST:event_btnProjMouseClicked

    private void btnPTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPTMouseClicked
        AddComponent ac = new AddComponent(this,true);
        ac.setTitle("Periodical Test");
        ac.setVisible(true);
    }//GEN-LAST:event_btnPTMouseClicked

    private void btnBackMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMousePressed
        this.setVisible(false);
    }//GEN-LAST:event_btnBackMousePressed

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
            java.util.logging.Logger.getLogger(Splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Splash().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Grades;
    private javax.swing.JScrollPane GradesScrollPane;
    private javax.swing.JLabel IUserName;
    private javax.swing.JLabel PHSLogo;
    private javax.swing.JButton bExport;
    private javax.swing.JLabel bgElement;
    private javax.swing.JLabel btnBack;
    private javax.swing.JButton btnHW;
    private javax.swing.JButton btnPT;
    private javax.swing.JButton btnProj;
    private javax.swing.JButton btnQuizzes;
    private javax.swing.JButton btnSW;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel lClassList;
    private javax.swing.JLabel lbSxnSubj;
    private javax.swing.JLabel lblHW;
    private javax.swing.JLabel lblPT;
    private javax.swing.JLabel lblProj;
    private javax.swing.JLabel lblQuiz;
    private javax.swing.JLabel lblSW;
    private javax.swing.JPanel pClassList;
    private javax.swing.JLabel redbar;
    private javax.swing.JLabel ribbon;
    private javax.swing.JLabel ribbon1;
    private javax.swing.JLabel settingsIcon;
    // End of variables declaration//GEN-END:variables
}
