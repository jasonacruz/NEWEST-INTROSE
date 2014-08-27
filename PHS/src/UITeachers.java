
import ProgramCodes.Classroom;
import ProgramCodes.Employee;
import ProgramCodes.Faculty;
import ProgramCodes.Settings;
import databaseCodes.ClassroomDAO;
import databaseCodes.SettingsDAO;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author James
 */
public class UITeachers extends javax.swing.JFrame {
    private Faculty teacher;
    private String[] subjList;
    private final ClassroomDAO cd = new ClassroomDAO();
    private final Settings settings = new Settings();
    private final SettingsDAO setD = new SettingsDAO();
    /**
     * Creates new form Splash
     */
    public UITeachers() {
        initComponents();
    }
    public UITeachers(Faculty emp)
    {
        setD.getSettings(settings);
        initComponents();
        teacher = emp;
        IUserName.setText(teacher.getFirstName() + " " +teacher.getLastName());
        addSectionButton();
    }

    public String[] getTruncate(javax.swing.JButton jb) {
        return jb.getText().split(" - ");
    }
    
    @SuppressWarnings("empty-statement")
    public Classroom setSection(javax.swing.JButton jb)
    {
        String[] temp;
        Classroom cTemp = new Classroom();
        temp = getTruncate(jb);
        cTemp.setSectYearlvl(Integer.parseInt(temp[0]));
        cTemp.setSectName(temp[1]);
        if(!temp[2].equals("Adviser"));
            cTemp.setSubjectName(temp[2]);
        cTemp.setSchoolYear(settings.getSchoolYear());
        cd.setStudentList(cTemp);
        System.out.println(cTemp.getSectYearlvl() + " - " + cTemp.getSectName() + " - " + cTemp.getSchoolYear() + " - "+cTemp.getSubjectName());
        return cTemp;
        
        
    }
    /*public ArrayList<Student> getStudent(javax.swing.JComboBox jc) {
        s = new Section();
        ArrayList<Student> studentList;
        studentList = new ArrayList<Student>();
        String[] x;
        x = getTruncate(jc);
        s.setSectname(x[1]);
        c = new Classroom(s, user);
        studentList = cd.getStudent(c);
        return studentList;
    }*/
    public final void addSectionButton()
    {
        GridBagConstraints constraint = new GridBagConstraints();
        constraint.anchor = GridBagConstraints.CENTER;
        constraint.fill = GridBagConstraints.NONE;
        constraint.gridx = 0;
        constraint.gridy = GridBagConstraints.RELATIVE;
        constraint.weightx = 1.0f;
        constraint.weighty = 1.0f;
        
        subjList = new String[20];
        cd.getAdviserSect(teacher, subjList, settings.getSchoolYear());
         for (String string : subjList) {
             if(string != null){
            final JButton buttonx = new JButton();
            buttonx.setText(string);
            buttonx.setBackground(new java.awt.Color(255, 255, 255));
            buttonx.setFont(new java.awt.Font("Lao UI", 1, 24));
            buttonx.setForeground(new java.awt.Color(156, 89, 90));
            jPanel1.add(buttonx, constraint);
             buttonx.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent ae2) {
            new MainTable(teacher, setSection(buttonx), settings, true).setVisible(true);
        }
    });
                     }
         
         }
        subjList = new String[20];
        cd.getSubjectInfo(teacher, subjList, settings.getSchoolYear());
         for (String string : subjList) {
             if(string != null){
            final JButton button = new JButton();
            button.setText(string);
            button.setBackground(new java.awt.Color(255, 255, 255));
            button.setFont(new java.awt.Font("Lao UI", 1, 24));
            button.setForeground(new java.awt.Color(156, 89, 90));
            jPanel1.add(button, constraint);
             button.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent ae2) {
               new MainTable(teacher, setSection(button), settings, false).setVisible(true);
        }
    });
                     }
         
         }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        PHSLogo = new javax.swing.JLabel();
        settingsIcon = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        IUserName = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        ribbon = new javax.swing.JLabel();
        redbar = new javax.swing.JLabel();
        bgElement = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Philadelphia High School");
        setBackground(new java.awt.Color(255, 204, 204));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setOpaque(false);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Lao UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(156, 89, 90));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("LOG OUT");
        jLabel4.setOpaque(true);
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel4MousePressed(evt);
            }
        });
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 110, 30));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Lao UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(156, 89, 90));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("ACCOUNT");
        jLabel5.setOpaque(true);
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel5MousePressed(evt);
            }
        });
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 110, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bar.png"))); // NOI18N
        jLabel3.setRequestFocusEnabled(false);
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 150));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 600, 153, 140));
        jPanel3.setVisible(false);
        jPanel3.getAccessibleContext().setAccessibleName("");

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setOpaque(false);

        jPanel1.setOpaque(false);
        java.awt.GridBagLayout jPanel1Layout = new java.awt.GridBagLayout();
        jPanel1Layout.columnWidths = new int[] {0, 5, 0};
        jPanel1Layout.rowHeights = new int[] {0, 5, 0};
        jPanel1.setLayout(jPanel1Layout);
        jScrollPane1.setViewportView(jPanel1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1130, 500));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 1100, 590));

        PHSLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/phila-logo.png"))); // NOI18N
        getContentPane().add(PHSLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, -1));
        getContentPane().add(settingsIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 490, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/settingslogo.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 660, -1, -1));

        IUserName.setText("User name");
        getContentPane().add(IUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ribbon.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 163, -1, 50));
        getContentPane().add(ribbon, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 160, 60));

        redbar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bar.png"))); // NOI18N
        getContentPane().add(redbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, -1));

        bgElement.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background2_1.png"))); // NOI18N
        getContentPane().add(bgElement, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -820, 1980, 1680));

        setBounds(0, 0, 1492, 798);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
       if(!jPanel3.isVisible())
           jPanel3.setVisible(true);
       else
           jPanel3.setVisible(false);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel5MousePressed

    private void jLabel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MousePressed
       int response = JOptionPane.showConfirmDialog(rootPane, "Will you log out?", "Notice: Log out",  JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
       if(response == JOptionPane.YES_OPTION)
       {
           this.setVisible(false);
           new mainLogin().setVisible(true);
       }
    }//GEN-LAST:event_jLabel4MousePressed

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
                UITeachers s = new UITeachers();
                s.setVisible(true);
                s.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IUserName;
    private javax.swing.JLabel PHSLogo;
    private javax.swing.JLabel bgElement;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel redbar;
    private javax.swing.JLabel ribbon;
    private javax.swing.JLabel settingsIcon;
    // End of variables declaration//GEN-END:variables
}