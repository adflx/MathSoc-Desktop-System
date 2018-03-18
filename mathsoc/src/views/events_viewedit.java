
package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class events_viewedit extends javax.swing.JFrame {

    String url;
    Connection connection;
    PreparedStatement pst;
    Statement st;
    ResultSet rs;
    private ImageIcon photo;
    public String z;
    String officerID;
    String officerPosition;
    
    public events_viewedit() {
        initComponents();
             ((JTextField)eventdate.getDateEditor().getUiComponent()).setEditable(false);
             ((JTextField)eventdate1.getDateEditor().getUiComponent()).setEditable(false);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        eventnum = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        backlabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        eventdate = new com.toedter.calendar.JDateChooser();
        eventtitle = new javax.swing.JTextField();
        eventvenue = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        eventdetails = new javax.swing.JTextArea();
        delete = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        JScrollPane1 = new javax.swing.JScrollPane();
        evedesc = new javax.swing.JTextArea();
        eventdate1 = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        pic = new javax.swing.JPanel();
        filenam = new javax.swing.JLabel();
        sampic = new javax.swing.JLabel();
        imeji = new javax.swing.JButton();
        save1 = new javax.swing.JButton();
        clearall = new javax.swing.JButton();

        jLabel7.setText("jLabel7");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel5.setText("Event number:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(97, 110, -1, -1));

        jLabel1.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel1.setText("Project Title:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 150, -1, -1));

        eventnum.setEditable(false);
        eventnum.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        eventnum.setBorder(null);
        jPanel1.add(eventnum, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, 230, 28));

        jLabel2.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel2.setText("Venue:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(173, 240, -1, 20));

        backlabel.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        backlabel.setText("Back to Dashboard");
        backlabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backlabelMouseClicked(evt);
            }
        });
        jPanel1.add(backlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 30, -1, -1));

        jLabel3.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel3.setText("Date:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(184, 190, -1, -1));

        jLabel4.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel4.setText("Narrative Report:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 370, -1, -1));

        eventdate.setBackground(new java.awt.Color(255, 255, 255));
        eventdate.setDateFormatString("MMMM dd, yyyy");
        jPanel1.add(eventdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 190, 210, 25));

        eventtitle.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        eventtitle.setBorder(null);
        jPanel1.add(eventtitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, 450, 30));

        eventvenue.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        eventvenue.setBorder(null);
        jPanel1.add(eventvenue, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 230, 450, 30));

        eventdetails.setColumns(10);
        eventdetails.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        eventdetails.setLineWrap(true);
        eventdetails.setRows(5);
        eventdetails.setWrapStyleWord(true);
        eventdetails.setBorder(null);
        jScrollPane1.setViewportView(eventdetails);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 380, 450, 240));

        delete.setBackground(new java.awt.Color(0, 51, 51));
        delete.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        delete.setForeground(new java.awt.Color(255, 255, 255));
        delete.setText("CANCEL EVENT");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        jPanel1.add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 550, 200, 65));

        jLabel6.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel6.setText("Project Description:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, -1));

        evedesc.setColumns(20);
        evedesc.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        evedesc.setRows(5);
        JScrollPane1.setViewportView(evedesc);

        jPanel1.add(JScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 270, 450, 90));

        eventdate1.setBackground(new java.awt.Color(255, 255, 255));
        eventdate1.setDateFormatString("MMMM dd, yyyy");
        jPanel1.add(eventdate1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 190, 210, 25));

        jLabel8.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        jLabel8.setText("to");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 180, 30, 50));

        pic.setBackground(new java.awt.Color(255, 255, 153));

        imeji.setBackground(new java.awt.Color(0, 51, 51));
        imeji.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        imeji.setForeground(new java.awt.Color(255, 255, 255));
        imeji.setText("ADD IMAGE");
        imeji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imejiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout picLayout = new javax.swing.GroupLayout(pic);
        pic.setLayout(picLayout);
        picLayout.setHorizontalGroup(
            picLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(picLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(picLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(filenam, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sampic, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(picLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(imeji)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        picLayout.setVerticalGroup(
            picLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(picLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(filenam, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sampic, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(imeji, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(pic, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 70, 270, 380));

        save1.setBackground(new java.awt.Color(0, 51, 51));
        save1.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        save1.setForeground(new java.awt.Color(255, 255, 255));
        save1.setText("CONTINUE EVENT");
        save1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save1ActionPerformed(evt);
            }
        });
        jPanel1.add(save1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 470, 200, 65));

        clearall.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        clearall.setText("CLEAR ALL");
        clearall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearallActionPerformed(evt);
            }
        });
        jPanel1.add(clearall, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jScrollPane2.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1015, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backlabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backlabelMouseClicked
        events_viewedit.this.setVisible(false);
        events_dashboard a = new events_dashboard();
        a.setVisible(true);
        a.setOfficerID(officerID);
        a.setOfficer(officerPosition);
    }//GEN-LAST:event_backlabelMouseClicked

    public void savedata(String stat,String typ){
        int answer;
        String datesave;
        String datesave1;
        answer = JOptionPane.showConfirmDialog(null, "Are you sure you want to " +typ+ " this event?","System Message",JOptionPane.YES_NO_OPTION);
        if(answer==JOptionPane.YES_OPTION){
            
            if((eventdate.getDate()==null) || (evedesc.getText().equals("")) || (eventtitle.getText().equals("")) || (eventvenue.getText().equals(""))|| (eventdetails.getText().equals(""))){
                JOptionPane.showMessageDialog(null, "Every field is required!","System Message",JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                if(eventdate.getDate()==eventdate1.getDate()){
                    datesave=new SimpleDateFormat("MMMM dd, yyyy").format(eventdate.getDate());
                    datesave1=datesave;
                }   
                else{
                    datesave=new SimpleDateFormat("MMMM dd, yyyy").format(eventdate.getDate());
                    datesave1=new SimpleDateFormat("MMMM dd, yyyy").format(eventdate1.getDate());
                }
           
                updatedb(datesave,datesave1,stat);
             
                if(person_image!=null){
                    saveimage();
                }
            }
        }
    }
    private void updatedb(String date,String date1, String status){
        if((eventdetails.getText().equals("") || evedesc.getText().equals("")) || (eventtitle.getText().equals("")) || (eventvenue.getText().equals("")) || (eventdate.getDate()==null)|| (eventdate1.getDate()==null)){
                JOptionPane.showMessageDialog(null, "Every field is required!","System Message",JOptionPane.ERROR_MESSAGE);
            }
            else if(eventdate1.getDate().before(eventdate.getDate())==true){
                JOptionPane.showMessageDialog(null,"Date not properly entered!");
            }
        
        else{
                try{
                Class.forName("com.mysql.jdbc.Driver");
                url="jdbc:mysql://localhost:3306/math";
                connection=DriverManager.getConnection(url, "root", "");
                st=connection.createStatement();
                
                st.executeUpdate("UPDATE `events` SET `project_title`='"+eventtitle.getText()+"',`date`='"+date+"',`enddate`='"+date1+"',`venue`='"+eventvenue.getText()+"',`event_description`='"+evedesc.getText()+"',`event_details`='"+eventdetails.getText()+"',`status`='"+status+"' WHERE `event_num`='"+eventnum.getText()+"'");
              
                JOptionPane.showMessageDialog(null, "Event Modified!","System Message",JOptionPane.INFORMATION_MESSAGE);
                this.setVisible(false);
                events_dashboard a = new events_dashboard();
                a.setVisible(true);
                a.setOfficer(officerPosition);
                a.setOfficerID(officerID);
            } catch (SQLException | ClassNotFoundException ex) {
                        JOptionPane.showMessageDialog(null, ex);
            }
        
    }   
    }
    
    private void saveimage(){
        try{
                String sql = "INSERT INTO images(event_num,image) values (?,?)";
                pst = connection.prepareStatement(sql);
                pst.setString(1,eventnum.getText());
                pst.setBytes(2,person_image);
                pst.executeUpdate();
            
                JOptionPane.showMessageDialog(null, "Image successfully added!","System Message",JOptionPane.INFORMATION_MESSAGE);
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null, "ERROR!","System Message",JOptionPane.INFORMATION_MESSAGE);
            }
    }
    
    
    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
       String s = "CANCELLED";
       String d = "cancel";
        savedata(s,d);
        
    }//GEN-LAST:event_deleteActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
       int width = 200;
       try{
            Class.forName("com.mysql.jdbc.Driver");
            url="jdbc:mysql://localhost:3306/math";
            connection=DriverManager.getConnection(url, "root", "");
            String sql= "SELECT image FROM images where event_num='"+z+"'";
            st=connection.prepareStatement(sql);
            rs=st.executeQuery(sql);
                
            while(rs.next()==true){
                        
                byte[] imagedb=rs.getBytes("image");
                photo =new ImageIcon(imagedb);
                sampic.setIcon(photo);
                JButton del = new JButton();
                del.setSize(127,30);
                del.setLocation(10,320);
                del.setText("Remove Image");
                del.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                    try{
                        String query;
                            query = "Delete From images Where event_num='" +eventnum.getText() + "'";
                            st.executeUpdate(query);
                            pic.remove(sampic);
                            pic.remove(del);
                            pic.updateUI();
                            JOptionPane.showMessageDialog(null,"Image successfully removed!");
                    
                    } catch (SQLException ex) {
                        Logger.getLogger(events_viewedit.class.getName()).log(Level.SEVERE, null, ex);
                    }
                                
                    }
                }); 
                            
                pic.add(del);
                pic.updateUI();
                            
                }
        }catch(ClassNotFoundException | SQLException u){
        }
    }//GEN-LAST:event_formWindowOpened

    private void imejiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imejiActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        filename = f.getAbsolutePath();
        if(filename!=null){
        filenam.setText(filename);
        ImageIcon icon=new ImageIcon(filename);
        sampic.setIcon(icon);

        try{
            File image = new File(filename);
            FileInputStream fis = new FileInputStream(image);

            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];

            for(int readnum;(readnum=fis.read(buf))!=-1;){
                bos.write(buf, 0, readnum);
            }
            person_image=bos.toByteArray();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        }
    }//GEN-LAST:event_imejiActionPerformed

    private void save1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save1ActionPerformed
        String t = "UPCOMING";
       String f = "update";
        savedata(t,f);// TODO add your handling code here:
    }//GEN-LAST:event_save1ActionPerformed

    private void clearallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearallActionPerformed
        eventtitle.setText("");
        eventvenue.setText("");
        evedesc.setText("");
        eventdetails.setText("");
        sampic.setIcon(null);        // TODO add your handling code here:
    }//GEN-LAST:event_clearallActionPerformed
    public void setOfficer(String officer){
        this.officerPosition = officer;
    }
    
    public void setOfficerID(String idnum){
        this.officerID = idnum;
    }

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
            java.util.logging.Logger.getLogger(events_viewedit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(events_viewedit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(events_viewedit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(events_viewedit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new events_viewedit().setVisible(true);
            }
        });
    }
    
    String filename=null;
    int s=0;
    byte[] person_image=null;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane JScrollPane1;
    private javax.swing.JLabel backlabel;
    private javax.swing.JButton clearall;
    private javax.swing.JButton delete;
    public javax.swing.JTextArea evedesc;
    public com.toedter.calendar.JDateChooser eventdate;
    public com.toedter.calendar.JDateChooser eventdate1;
    public javax.swing.JTextArea eventdetails;
    public javax.swing.JTextField eventnum;
    public javax.swing.JTextField eventtitle;
    public javax.swing.JTextField eventvenue;
    private javax.swing.JLabel filenam;
    private javax.swing.JButton imeji;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel pic;
    private javax.swing.JLabel sampic;
    private javax.swing.JButton save1;
    // End of variables declaration//GEN-END:variables
}
