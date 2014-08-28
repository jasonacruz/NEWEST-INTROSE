
import ProgramCodes.Classroom;
import ProgramCodes.Faculty;
import ProgramCodes.Settings;
import databaseCodes.GradesDAO;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
    
    private Classroom c;
    private Faculty teacher;
    private Settings s;
    private GradesDAO gd;
    DefaultTableModel tab = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return column != 2;
        }
    };
    /**
     * Creates new form UITeachers
     */
    public MainTable() {
        this.gd = new GradesDAO(s);
        initComponents();
    }
    public MainTable(Faculty emp, Classroom c, Settings settings, Boolean enableAdviser) {
        initComponents();
        teacher = emp;
        this.c = c;
        bExport.setVisible(enableAdviser);
        pClassList.setVisible(!enableAdviser);
        IUserName.setText(teacher.getFirstName()+ " " + teacher.getLastName());
        this.s = settings;
        this.gd = new GradesDAO(s);
        changeTable();
    }
    
    private void changeTable() {
        Object[] tableColumnNames = new Object[24];
        tableColumnNames[0] = "Student ID";
        tableColumnNames[1] = "Student Name";
        tableColumnNames[2] = "KNLDG-Quiz";
        tableColumnNames[3] = "KNLDG-Oral";
        tableColumnNames[4] = "KNLDG-PT";
        tableColumnNames[5] = "KNLDG-AVE";
        tableColumnNames[6] = "KNLDG%";
        tableColumnNames[7] = "PRCSS-Quiz";
        tableColumnNames[8] = "PRCSS-Oral";
        tableColumnNames[9] = "PRCSS-PT";
        tableColumnNames[10] = "PRCSS-AVE";
        tableColumnNames[11] = "PRCSS%";
        tableColumnNames[12] = "USTND-Quiz";
        tableColumnNames[13] = "USTND-Oral";
        tableColumnNames[14] = "USTND-PT";
        tableColumnNames[15] = "USTND-AVE";
        tableColumnNames[16] = "USTND%";
        tableColumnNames[17] = "PRDCT-Project";
        tableColumnNames[18] = "PRDCT-Oral";
        tableColumnNames[19] = "PRDCT-HW";
        tableColumnNames[20] = "PRDCT-AVE";
        tableColumnNames[21] = "PRDCT%";
        tableColumnNames[22] = "TOTAL";
        tableColumnNames[23] = "FINAL RATING";
        tab.setColumnIdentifiers(tableColumnNames);
        Object[] objects = new Object[24];
        if (c.getStudentList().size() > 0) {
            for (int i = 0; i < c.getStudentList().size(); i++) {
                objects[0] = c.getStudentList().get(i).getIdNum();
                objects[1] = (c.getStudentList().get(i).getLastName() + ", " + c.getStudentList().get(i).getFirstName() + " " + c.getStudentList().get(i).getMidName());
                objects[2] = gd.getGradeComp(c, "Quiz", c.getStudentList().get(i).getIdNum(), 1);
                objects[3] = gd.getGradeComp(c, "Class Participation", c.getStudentList().get(i).getIdNum(), 1);
                objects[4] = gd.getGradeComp(c, "Periodical Test", c.getStudentList().get(i).getIdNum(), 1);
                objects[6] = ((gd.getGradeComp(c, "Quiz", c.getStudentList().get(i).getIdNum(), 1)) + gd.getGradeComp(c, "Class Participation", c.getStudentList().get(i).getIdNum(), 1) +gd.getGradeComp(c, "Periodical Test", c.getStudentList().get(i).getIdNum(), 1) )/ 0.03;
                objects[7] = ((gd.getGradeComp(c, "Quiz", c.getStudentList().get(i).getIdNum(), 1)) + gd.getGradeComp(c, "Class Participation", c.getStudentList().get(i).getIdNum(), 1) +gd.getGradeComp(c, "Periodical Test", c.getStudentList().get(i).getIdNum(), 1) )/ 0.03 * (s.getKnowledge()/100);
                objects[8] = gd.getGradeComp(c, "Quiz", c.getStudentList().get(i).getIdNum(), 2);
                objects[9] = gd.getGradeComp(c, "Class Participation", c.getStudentList().get(i).getIdNum(), 2);
                objects[10] = gd.getGradeComp(c, "Periodical Test", c.getStudentList().get(i).getIdNum(), 2);
                objects[11] = ((gd.getGradeComp(c, "Quiz", c.getStudentList().get(i).getIdNum(),2)) + gd.getGradeComp(c, "Class Participation", c.getStudentList().get(i).getIdNum(), 2) +gd.getGradeComp(c, "Periodical Test", c.getStudentList().get(i).getIdNum(), 2) )/ 0.03;
                objects[12] = ((gd.getGradeComp(c, "Quiz", c.getStudentList().get(i).getIdNum(), 2)) + gd.getGradeComp(c, "Class Participation", c.getStudentList().get(i).getIdNum(), 2) +gd.getGradeComp(c, "Periodical Test", c.getStudentList().get(i).getIdNum(), 2) )/ 0.03 * (s.getProcess()/100);
                objects[13] = gd.getGradeComp(c, "Quiz", c.getStudentList().get(i).getIdNum(), 3);
                objects[14] = gd.getGradeComp(c, "Class Participation", c.getStudentList().get(i).getIdNum(),3);
                objects[15] = gd.getGradeComp(c, "Periodical Test", c.getStudentList().get(i).getIdNum(),3);
                objects[16] = ((gd.getGradeComp(c, "Quiz", c.getStudentList().get(i).getIdNum(), 3)) + gd.getGradeComp(c, "Class Participation", c.getStudentList().get(i).getIdNum(), 3) +gd.getGradeComp(c, "Periodical Test", c.getStudentList().get(i).getIdNum(), 3) )/ 0.03;
                objects[17] = ((gd.getGradeComp(c, "Quiz", c.getStudentList().get(i).getIdNum(), 3)) + gd.getGradeComp(c, "Class Participation", c.getStudentList().get(i).getIdNum(),3) +gd.getGradeComp(c, "Periodical Test", c.getStudentList().get(i).getIdNum(), 3) )/ 0.03 * (s.getUnderstanding()/100);
                objects[18] = gd.getGradeComp(c, "Project", c.getStudentList().get(i).getIdNum(), 4);
                objects[19] = gd.getGradeComp(c, "Class Participation", c.getStudentList().get(i).getIdNum(), 4);
                objects[19] = gd.getGradeComp(c, "Homework", c.getStudentList().get(i).getIdNum(), 4);
                objects[21] = ((gd.getGradeComp(c, "Project", c.getStudentList().get(i).getIdNum(), 4)) + gd.getGradeComp(c, "Class Participation", c.getStudentList().get(i).getIdNum(), 4) + gd.getGradeComp(c, "Homework", c.getStudentList().get(i).getIdNum(), 4) )/ 0.03;
                objects[22] = ((gd.getGradeComp(c, "Project", c.getStudentList().get(i).getIdNum(), 4)) + gd.getGradeComp(c, "Class Participation", c.getStudentList().get(i).getIdNum(), 4) + gd.getGradeComp(c, "Homework", c.getStudentList().get(i).getIdNum(), 4) )/ 0.03 * (s.getProduct()/100);
                tab.addRow(objects);
            }
            Grades.setFont(new Font("Arial", Font.PLAIN, 10));
            this.Grades.setModel(tab);
        }
        Grades.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        GradesScrollPane.setViewportView(Grades);
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
        lblPT1 = new javax.swing.JLabel();
        btnPT1 = new javax.swing.JButton();
        btnGrades = new javax.swing.JButton();
        lClassList = new javax.swing.JLabel();
        btnBack = new javax.swing.JLabel();
        bExport = new javax.swing.JButton();
        lbSxnSubj = new javax.swing.JLabel();
        PHSLogo = new javax.swing.JLabel();
        settingsIcon = new javax.swing.JLabel();
        IUserName = new javax.swing.JLabel();
        ribbon1 = new javax.swing.JLabel();
        redbar = new javax.swing.JLabel();
        bgElement = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setTitle("Philadelphia High School");
        setBackground(new java.awt.Color(255, 204, 204));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        GradesScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        GradesScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        GradesScrollPane.setMaximumSize(new java.awt.Dimension(1600, 1600));
        GradesScrollPane.setName(""); // NOI18N
        GradesScrollPane.setPreferredSize(new java.awt.Dimension(1600, 1600));

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

        getContentPane().add(GradesScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 1470, 410));

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
        pClassList.add(lblHW, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 130, -1));

        btnHW.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plussign.png"))); // NOI18N
        btnHW.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHWMouseClicked(evt);
            }
        });
        pClassList.add(btnHW, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 40, -1));

        lblSW.setForeground(new java.awt.Color(255, 255, 255));
        lblSW.setText("Seatwork (number)");
        pClassList.add(lblSW, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 120, 23));

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
        btnProj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProjActionPerformed(evt);
            }
        });
        pClassList.add(btnProj, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 40, -1));

        lblPT.setBackground(new java.awt.Color(255, 255, 255));
        lblPT.setForeground(new java.awt.Color(255, 255, 255));
        lblPT.setText("Perodical Test");
        pClassList.add(lblPT, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 97, 23));

        btnPT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plussign.png"))); // NOI18N
        btnPT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPTMouseClicked(evt);
            }
        });
        pClassList.add(btnPT, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 40, -1));

        lblPT1.setBackground(new java.awt.Color(255, 255, 255));
        lblPT1.setForeground(new java.awt.Color(255, 255, 255));
        lblPT1.setText("Class Participation");
        pClassList.add(lblPT1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 110, 23));

        btnPT1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plussign.png"))); // NOI18N
        btnPT1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPT1MouseClicked(evt);
            }
        });
        btnPT1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPT1ActionPerformed(evt);
            }
        });
        pClassList.add(btnPT1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 40, -1));

        getContentPane().add(pClassList, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 180, 250));

        btnGrades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clients.png"))); // NOI18N
        btnGrades.setText("Grades");
        btnGrades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnGradesMousePressed(evt);
            }
        });
        getContentPane().add(btnGrades, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, 160, -1));

        lClassList.setForeground(new java.awt.Color(255, 255, 204));
        lClassList.setText("Class List");
        getContentPane().add(lClassList, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, 20));

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
        getContentPane().add(IUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, -1, -1));

        ribbon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ribbon.png"))); // NOI18N
        getContentPane().add(ribbon1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        redbar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bar.png"))); // NOI18N
        getContentPane().add(redbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, -1));

        bgElement.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background2_1.png"))); // NOI18N
        getContentPane().add(bgElement, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1980, 1490));
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnQuizzesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuizzesActionPerformed
       AddComponent ac = new AddComponent(this,true, "Quiz", c,s);
       ac.setTitle("Quiz <number>");
       ac.setVisible(true);
    }//GEN-LAST:event_btnQuizzesActionPerformed

    private void btnHWMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHWMouseClicked
        AddComponent ac = new AddComponent(this,true, "Homework",c,s);
        ac.setTitle("Homework <number>");
        ac.setVisible(true);
    }//GEN-LAST:event_btnHWMouseClicked

    private void btnSWMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSWMouseClicked
        AddComponent ac = new AddComponent(this,true, "Seatwork",c,s);
        ac.setTitle("Seatwork <number>");
        ac.setVisible(true);
    }//GEN-LAST:event_btnSWMouseClicked

    private void btnProjMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProjMouseClicked
        AddProjectGrades ac = new AddProjectGrades(this,true);
        new GradesDAO(s).addGradeComp(c, "Project", 0, 0, 0, 100);
        ac.setTitle("Project");
        ac.setVisible(true);
    }//GEN-LAST:event_btnProjMouseClicked

    private void btnPTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPTMouseClicked
        AddComponent ac = new AddComponent(this,true, "Periodical Test",c,s);
        ac.setTitle("Periodical Test");
        ac.setVisible(true);
    }//GEN-LAST:event_btnPTMouseClicked

    private void btnBackMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMousePressed
        this.setVisible(false);
    }//GEN-LAST:event_btnBackMousePressed

    private void btnGradesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGradesMousePressed
    
    }//GEN-LAST:event_btnGradesMousePressed

    private void btnPT1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPT1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPT1MouseClicked

    private void btnPT1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPT1ActionPerformed
        AddComponent ac = new AddComponent(this,true, "Class Participation",c,s);
        ac.setTitle("Class Participation");
        ac.setVisible(true);
    }//GEN-LAST:event_btnPT1ActionPerformed

    private void btnProjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProjActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnProjActionPerformed

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
            java.util.logging.Logger.getLogger(UITeachers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UITeachers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UITeachers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UITeachers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UITeachers().setVisible(true);
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
    private javax.swing.JButton btnGrades;
    private javax.swing.JButton btnHW;
    private javax.swing.JButton btnPT;
    private javax.swing.JButton btnPT1;
    private javax.swing.JButton btnProj;
    private javax.swing.JButton btnQuizzes;
    private javax.swing.JButton btnSW;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lClassList;
    private javax.swing.JLabel lbSxnSubj;
    private javax.swing.JLabel lblHW;
    private javax.swing.JLabel lblPT;
    private javax.swing.JLabel lblPT1;
    private javax.swing.JLabel lblProj;
    private javax.swing.JLabel lblQuiz;
    private javax.swing.JLabel lblSW;
    private javax.swing.JPanel pClassList;
    private javax.swing.JLabel redbar;
    private javax.swing.JLabel ribbon1;
    private javax.swing.JLabel settingsIcon;
    // End of variables declaration//GEN-END:variables
}
