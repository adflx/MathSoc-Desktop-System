package views;

import java.awt.event.KeyEvent;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class Collection extends javax.swing.JFrame {

    ResultSet rs =null;
  Connection con = null;
  PreparedStatement st=null;    
   String officerPosition;
   String officerID;
   final String task = "Collection";
    public Collection() {
        initComponents();
         Date now = new Date();
         SimpleDateFormat watsz= new SimpleDateFormat("MM-dd-yyyy");
       ((JTextField)jcdate_c.getDateEditor().getUiComponent()).setText(watsz.format(now));
      ((JTextField)jcdate_c.getDateEditor().getUiComponent()).setEditable(false);
       display_data();
        tfid_c.setVisible(false);
 
    }

    private void display_data(){
      
     try {
          con = DriverManager.getConnection("jdbc:mysql://localhost/math","root","");
         String gow ="select ID,DATE,TYPE,DESCRIPTION,QUANTITY,PRICE,STATUS from collection";
          st =  con.prepareStatement(gow); 
           st.execute(gow);
          rs = st.executeQuery();
     tbl.setModel(DbUtils.resultSetToTableModel(rs));
     }
     catch(Exception e){          
         
     }

 }
    
    
    private void display_colstat(String status){
      
     try {
          con = DriverManager.getConnection("jdbc:mysql://localhost/math","root","");
         String gow ="select * from collection where STATUS like '"+status+"'";
          st =  con.prepareStatement(gow); 
           st.execute(gow);          rs = st.executeQuery();
     tbl.setModel(DbUtils.resultSetToTableModel(rs));
     }
     catch(Exception e){          
         
     }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jcdate_c = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        tfquan_c = new javax.swing.JTextField();
        combo = new javax.swing.JComboBox();
        approve_btn = new javax.swing.JButton();
        disapprove_btn = new javax.swing.JButton();
        approve1 = new javax.swing.JRadioButton();
        approve = new javax.swing.JRadioButton();
        disapprove = new javax.swing.JRadioButton();
        tfid_c = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        addbtn_c = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        tfprice_c = new javax.swing.JTextField();
        upbtn_c = new javax.swing.JButton();
        tfdesc_c = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        back = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jcdate_c.setDateFormatString("MM-dd-yyyy");
        jcdate_c.setMaxSelectableDate(new java.util.Date(253370739677000L));
        jcdate_c.setMinSelectableDate(new java.util.Date(1451581277000L));
        jPanel1.add(jcdate_c, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 330, 257, 30));

        jLabel6.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel6.setText("Quantity");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 450, 90, -1));

        tfquan_c.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        tfquan_c.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfquan_cKeyTyped(evt);
            }
        });
        jPanel1.add(tfquan_c, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 440, 249, -1));

        combo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ticket", "T-shirt", "Membership", "Registration", "others" }));
        jPanel1.add(combo, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 370, 100, -1));

        approve_btn.setBackground(new java.awt.Color(0, 51, 51));
        approve_btn.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        approve_btn.setForeground(new java.awt.Color(255, 255, 255));
        approve_btn.setText("APPROVE");
        approve_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                approve_btnActionPerformed(evt);
            }
        });
        jPanel1.add(approve_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 340, 110, 40));

        disapprove_btn.setBackground(new java.awt.Color(0, 51, 51));
        disapprove_btn.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        disapprove_btn.setForeground(new java.awt.Color(255, 255, 255));
        disapprove_btn.setText("PENDING");
        disapprove_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disapprove_btnActionPerformed(evt);
            }
        });
        jPanel1.add(disapprove_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 340, 110, 40));

        buttonGroup1.add(approve1);
        approve1.setText("Show All");
        approve1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                approve1ActionPerformed(evt);
            }
        });
        jPanel1.add(approve1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 290, 70, 20));

        buttonGroup1.add(approve);
        approve.setText("Approve");
        approve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                approveActionPerformed(evt);
            }
        });
        jPanel1.add(approve, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 290, 70, 20));

        buttonGroup1.add(disapprove);
        disapprove.setText("Pending");
        disapprove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disapproveActionPerformed(evt);
            }
        });
        jPanel1.add(disapprove, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 290, 70, -1));

        tfid_c.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        jPanel1.add(tfid_c, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 280, 250, -1));

        jLabel2.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel2.setText("Item Description");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, -1, -1));

        jLabel3.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel3.setText("Type");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 370, -1, -1));

        addbtn_c.setBackground(new java.awt.Color(0, 51, 51));
        addbtn_c.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        addbtn_c.setForeground(new java.awt.Color(255, 255, 255));
        addbtn_c.setText("Add");
        addbtn_c.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbtn_cActionPerformed(evt);
            }
        });
        jPanel1.add(addbtn_c, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 520, 150, 65));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Collection", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24))); // NOI18N

        tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Date", "Quantity", "Item Description", "Amount", "Status"
            }
        ));
        tbl.setName("Collection"); // NOI18N
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 767, 258));

        jLabel4.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel4.setText("Price");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 490, -1, -1));

        tfprice_c.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        tfprice_c.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfprice_cKeyTyped(evt);
            }
        });
        jPanel1.add(tfprice_c, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 480, 249, -1));

        upbtn_c.setBackground(new java.awt.Color(0, 51, 51));
        upbtn_c.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        upbtn_c.setForeground(new java.awt.Color(255, 255, 255));
        upbtn_c.setText("Update");
        upbtn_c.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upbtn_cActionPerformed(evt);
            }
        });
        jPanel1.add(upbtn_c, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 520, 150, 65));

        tfdesc_c.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        jPanel1.add(tfdesc_c, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 400, 363, -1));

        jLabel1.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel1.setText("Date");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 330, -1, -1));

        back.setBackground(new java.awt.Color(0, 51, 51));
        back.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        back.setForeground(new java.awt.Color(255, 255, 255));
        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        jPanel1.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 150, 65));

        jLabel5.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/images/webtreats-paper-pattern-1-grey.jpg"))); // NOI18N
        jLabel5.setText("jLabel5");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 590));

        jScrollPane2.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 851, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 643, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void reset(){
     tfprice_c.setText("");combo.setSelectedItem("");tfdesc_c.setText("");tfquan_c.setText("");
                        
}    

    
    private void addbtn_cActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbtn_cActionPerformed
        java.text.SimpleDateFormat fmt1 = new java.text.SimpleDateFormat("MM-dd-yyyy");
       String sdate = fmt1.format(jcdate_c.getDate());
 
        DefaultTableModel model=(DefaultTableModel) tbl.getModel();
        if( !sdate.trim().equals("") && !tfdesc_c.getText().trim().equals("") && !tfquan_c.getText().trim().equals("")  && !tfprice_c.getText().trim().equals("") )
        {
                 float total= Integer.parseInt(tfquan_c.getText())* Integer.parseInt(tfprice_c.getText());
                Connection con = null;
            model.addRow(new Object[]{sdate,combo.getSelectedItem(),tfdesc_c.getText(),tfprice_c.getText()});
            String goinsert=("insert into collection (DATE,TYPE,DESCRIPTION,QUANTITY,PRICE,TOTAL,STATUS) " + "values"  + "('"+sdate+"','"+combo.getSelectedItem()
                    +"','" +tfdesc_c.getText()+"','" +tfquan_c.getText()+"','"+tfprice_c.getText()+"','"+total+"','"+"PENDING"+"')");
            try{
                con = DriverManager.getConnection("jdbc:mysql://localhost/math","root","");
                Statement st =  con.prepareStatement(goinsert);
                st.execute(goinsert);
                st = con.createStatement();
                display_data();
                reset();
                JOptionPane.showMessageDialog(null,"INSERTED");
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null,ex.getMessage()); }
            
        }else{
            
            JOptionPane.showMessageDialog(null, "You need to fill all information","System Message",JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_addbtn_cActionPerformed

    private void tblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMouseClicked

        DefaultTableModel model = (DefaultTableModel) tbl.getModel();
        tfid_c.setText(model.getValueAt(tbl.getSelectedRow(),0).toString());
        ((JTextField)jcdate_c.getDateEditor().getUiComponent()).setText(model.getValueAt(tbl.getSelectedRow(),1).toString());
        combo.setSelectedItem(model.getValueAt(tbl.getSelectedRow(),2).toString());
        tfdesc_c.setText(model.getValueAt(tbl.getSelectedRow(),3).toString());
        tfquan_c.setText(model.getValueAt(tbl.getSelectedRow(),4).toString());
        tfprice_c.setText(model.getValueAt(tbl.getSelectedRow(),5).toString());
    
    }//GEN-LAST:event_tblMouseClicked

    private void upbtn_cActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upbtn_cActionPerformed
    java.text.SimpleDateFormat fmt1 = new java.text.SimpleDateFormat("MM-dd-yyyy");
       String sdate = fmt1.format(jcdate_c.getDate());
         
 
        DefaultTableModel model = (DefaultTableModel) tbl.getModel();
        if(tbl.getSelectedRow()==-1)
        {
            if(tbl.getRowCount()==0)
            {
                                    JOptionPane.showMessageDialog(null, "Table is empty","System Message",JOptionPane.ERROR_MESSAGE);
           

            }else{
                                    JOptionPane.showMessageDialog(null, "You must select in the ROW","System Message",JOptionPane.ERROR_MESSAGE);
                
            }
        }else{
            if(!sdate.trim().equals("") && !tfdesc_c.getText().trim().equals("") && !tfquan_c.getText().trim().equals("") && !tfprice_c.getText().trim().equals("")){
            model.setValueAt(tfdesc_c.getText(),tbl.getSelectedRow(),0);
            model.setValueAt(tfquan_c.getText(),tbl.getSelectedRow(),0);
             model.setValueAt(sdate,tbl.getSelectedRow(),1);
            model.setValueAt(combo.getSelectedItem(),tbl.getSelectedRow(),2);
            model.setValueAt(tfprice_c.getText(),tbl.getSelectedRow(),3);
            Connection con = null;
                   float total= Integer.parseInt(tfquan_c.getText())* Integer.parseInt(tfprice_c.getText());
            String goinsert="UPDATE collection set DATE ='"+sdate+"',DESCRIPTION ='" +tfdesc_c.getText()+"',QUANTITY ='" +tfquan_c.getText()+"', TYPE='"+combo.getSelectedItem()+"',PRICE= '"+tfprice_c.getText()+"',TOTAL= '"+total+"' where ID='"+tfid_c.getText()+"' ";
            try{
                con = DriverManager.getConnection("jdbc:mysql://localhost/math","root","");
                Statement st =  con.prepareStatement(goinsert);
                st.execute(goinsert);
                st = con.createStatement();
                reset();
                display_data();
                JOptionPane.showMessageDialog(null,"Data UPDATED");
            }      catch(Exception ex){
                JOptionPane.showMessageDialog(null,ex.getMessage());
            }
        }
            
            else{
                JOptionPane.showMessageDialog(null, "You need to fill all information","System Message",JOptionPane.ERROR_MESSAGE);

            } 
            
        }
        

    }//GEN-LAST:event_upbtn_cActionPerformed

    private void tfprice_cKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfprice_cKeyTyped
        char c=evt.getKeyChar();
       if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE)){
           evt.consume();
       }
       if (tfprice_c.getText().length()>=4) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_tfprice_cKeyTyped

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        MainMenu a = new MainMenu();
        a.setVisible(true);
        a.setOfficer(officerPosition);
        Collection.this.setVisible(false);
    }//GEN-LAST:event_backActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
       restrictions res = new restrictions(officerPosition, task);
        if(res.isRestricted()){
            addbtn_c.setEnabled(false);
          upbtn_c.setEnabled(false);
           approve_btn.setEnabled(false);
                disapprove_btn.setEnabled(false);
        }
        else{
            addbtn_c.setEnabled(true);
           upbtn_c.setEnabled(true);
             if(officerPosition.equalsIgnoreCase("Tresurer")||officerPosition.equalsIgnoreCase("Auditor")){
                approve_btn.setEnabled(false);
                disapprove_btn.setEnabled(false);
            }
            else{
                approve_btn.setEnabled(true);
                disapprove_btn.setEnabled(true);
            }
        }
    }//GEN-LAST:event_formWindowOpened

    private void approve_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_approve_btnActionPerformed
         java.text.SimpleDateFormat fmt1 = new java.text.SimpleDateFormat("MM-dd-yyyy");
       String sdate = fmt1.format(jcdate_c.getDate());
         
       
        DefaultTableModel model = (DefaultTableModel) tbl.getModel();
        if(tbl.getSelectedRow()==-1)
        {
            if(tbl.getRowCount()==0)
            {
                                    JOptionPane.showMessageDialog(null, "Table is empty","System Message",JOptionPane.ERROR_MESSAGE);
           

            }else{
                                    JOptionPane.showMessageDialog(null, "You must select in the ROW","System Message",JOptionPane.ERROR_MESSAGE);
                
            }
        }else{
            if(!sdate.trim().equals("") && !tfdesc_c.getText().trim().equals("") && !tfquan_c.getText().trim().equals("")&& !tfprice_c.getText().trim().equals("")){
            model.setValueAt(tfdesc_c.getText(),tbl.getSelectedRow(),0);
            model.setValueAt(tfquan_c.getText(),tbl.getSelectedRow(),1);
             model.setValueAt(sdate,tbl.getSelectedRow(),2);
            model.setValueAt(combo.getSelectedItem(),tbl.getSelectedRow(),3);
            model.setValueAt(tfprice_c.getText(),tbl.getSelectedRow(),4);
            Connection con = null;

            String goinsert="UPDATE collection set STATUS = 'APPROVED' where ID='"+tfid_c.getText()+"' ";
            try{
                con = DriverManager.getConnection("jdbc:mysql://localhost/math","root","");
                Statement st =  con.prepareStatement(goinsert);
                st.execute(goinsert);
                st = con.createStatement();
                reset();
                display_data();
                JOptionPane.showMessageDialog(null,"Data APPROVED");
            }      catch(Exception ex){
                JOptionPane.showMessageDialog(null,ex.getMessage());
            }
        }
            
            else{
                JOptionPane.showMessageDialog(null, "You need to fill all information","System Message",JOptionPane.ERROR_MESSAGE);

            } 
            
        }
        

    
    }//GEN-LAST:event_approve_btnActionPerformed

    private void disapproveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disapproveActionPerformed
        // TODO add your handling code here:
        display_colstat("PENDING");
    }//GEN-LAST:event_disapproveActionPerformed

    private void approveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_approveActionPerformed
        // TODO add your handling code here:
         display_colstat("APPROVED");
    }//GEN-LAST:event_approveActionPerformed

    private void approve1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_approve1ActionPerformed
        display_data();
    }//GEN-LAST:event_approve1ActionPerformed

    private void disapprove_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disapprove_btnActionPerformed
  java.text.SimpleDateFormat fmt1 = new java.text.SimpleDateFormat("MM-dd-yyyy");
       String sdate = fmt1.format(jcdate_c.getDate());
         
       
        DefaultTableModel model = (DefaultTableModel) tbl.getModel();
        if(tbl.getSelectedRow()==-1)
        {
            if(tbl.getRowCount()==0)
            {
                                    JOptionPane.showMessageDialog(null, "Table is empty","System Message",JOptionPane.ERROR_MESSAGE);
           

            }else{
                                    JOptionPane.showMessageDialog(null, "You must select in the ROW","System Message",JOptionPane.ERROR_MESSAGE);
                
            }
        }else{
            if(!sdate.trim().equals("") && !tfdesc_c.getText().trim().equals("")  && !tfprice_c.getText().trim().equals("")){
            model.setValueAt(tfdesc_c.getText(),tbl.getSelectedRow(),0);
            model.setValueAt(tfquan_c.getText(),tbl.getSelectedRow(),1);
             model.setValueAt(sdate,tbl.getSelectedRow(),2);
            model.setValueAt(combo.getSelectedItem(),tbl.getSelectedRow(),3);
            model.setValueAt(tfprice_c.getText(),tbl.getSelectedRow(),4);
            Connection con = null;

            String goinsert="UPDATE collection set STATUS = 'PENDING' where ID='"+tfid_c.getText()+"' ";
            try{
                con = DriverManager.getConnection("jdbc:mysql://localhost/math","root","");
                Statement st =  con.prepareStatement(goinsert);
                st.execute(goinsert);
                st = con.createStatement();
                reset();
                display_data();
                JOptionPane.showMessageDialog(null,"Data PENDING");
            }      catch(Exception ex){
                JOptionPane.showMessageDialog(null,ex.getMessage());
            }
        }
            
            else{
                JOptionPane.showMessageDialog(null, "You need to fill all information","System Message",JOptionPane.ERROR_MESSAGE);

            } 
            
        }        // TODO add your handling code here:
    }//GEN-LAST:event_disapprove_btnActionPerformed

    private void tfquan_cKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfquan_cKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_tfquan_cKeyTyped

    private void jcdate_cKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcdateKeyTyped

    }//GEN-LAST:event_jcdateKeyTyped

    /**
     * @param args the command line arguments
     */
    public void setOfficer(String officer){
        this.officerPosition = officer;
    }
    
    public void setOfficerID(String idnum){
        this.officerID = idnum;
    }

    
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
            java.util.logging.Logger.getLogger(Collection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Collection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Collection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Collection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Collection().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addbtn_c;
    private javax.swing.JRadioButton approve;
    private javax.swing.JRadioButton approve1;
    private javax.swing.JButton approve_btn;
    private javax.swing.JButton back;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox combo;
    private javax.swing.JRadioButton disapprove;
    private javax.swing.JButton disapprove_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.toedter.calendar.JDateChooser jcdate_c;
    private javax.swing.JTable tbl;
    private javax.swing.JTextField tfdesc_c;
    private javax.swing.JTextField tfid_c;
    private javax.swing.JTextField tfprice_c;
    private javax.swing.JTextField tfquan_c;
    private javax.swing.JButton upbtn_c;
    // End of variables declaration//GEN-END:variables
}
