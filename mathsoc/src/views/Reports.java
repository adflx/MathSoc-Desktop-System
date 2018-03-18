
package views;
import java.sql.*;
import java.text.MessageFormat;
import java.text.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
//import net.proteanit.sql.DbUtils;
/**
 *
 * @author ChinieAnn
 */
public class Reports extends javax.swing.JFrame {
    private static final String USERNAME="root";
    private static final String PASSWORD= "";
    private static final String CONN_STRING=
            "jdbc:mysql://localhost:3306/math";
               Date datee= new Date();
       SimpleDateFormat ft = 
      new SimpleDateFormat ("MM-dd-yyyy");
    DefaultTableModel panelmodel;
    int collect =0;
    int expense =0;
    int counter;
    String officerPosition;
    String officerID;
    
    public Reports() {
        
        initComponents();
          ImageIcon icon = new ImageIcon("C:\\Users\\ChinieAnn\\Desktop\\Reports\\Reports\\src\\reports\\images\\MATHSOC LOGO.png");
            Reports.this.setIconImage(icon.getImage());
         aa.setVisible(false);
        totalex.setVisible(false);
         try {
                load();
            } catch (SQLException ex) {
                // Logger.getLogger(frameRegister.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                //Logger.getLogger(frameRegister.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    
    public void load()throws SQLException, ClassNotFoundException{
        
    }


    public Connection getConnection(){
        Connection con;
    try{
        con = DriverManager.getConnection("jdbc:mysql://localhost/math", "root", "");
        return con;
       } catch (Exception e){
            e.printStackTrace();
            return null;
        }
}

  
   
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        b_load = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        r_events = new javax.swing.JRadioButton();
        r_financial = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        aa = new javax.swing.JLabel();
        totalex = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(900, 700));
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        b_load.setBackground(new java.awt.Color(0, 51, 51));
        b_load.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        b_load.setForeground(new java.awt.Color(255, 255, 255));
        b_load.setText("Load");
        b_load.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b_loadMouseClicked(evt);
            }
        });
        b_load.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_loadActionPerformed(evt);
            }
        });
        jPanel1.add(b_load, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 150, 65));

        jButton2.setBackground(new java.awt.Color(0, 51, 51));
        jButton2.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Print");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 10, 150, 65));

        jButton1.setBackground(new java.awt.Color(0, 51, 51));
        jButton1.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 10, 140, 65));

        r_events.setBackground(new java.awt.Color(255, 255, 204));
        buttonGroup1.add(r_events);
        r_events.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        r_events.setText("Events");
        r_events.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_eventsActionPerformed(evt);
            }
        });
        jPanel1.add(r_events, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 120, 30));

        r_financial.setBackground(new java.awt.Color(255, 255, 204));
        buttonGroup1.add(r_financial);
        r_financial.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        r_financial.setText("Financial");
        r_financial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_financialActionPerformed(evt);
            }
        });
        jPanel1.add(r_financial, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, 130, 30));

        jTable1.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, new javax.swing.border.MatteBorder(null)));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 1310, 343));

        aa.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        aa.setForeground(new java.awt.Color(255, 0, 0));
        aa.setText("Total Expenses:     Php");
        jPanel1.add(aa, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 440, 450, -1));

        totalex.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        totalex.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(totalex, new org.netbeans.lib.awtextra.AbsoluteConstraints(744, 432, 70, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/images/webtreats-paper-pattern-1-grey.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1330, 480));

        jScrollPane2.setViewportView(jPanel1);

        getContentPane().add(jScrollPane2, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void b_loadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_loadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b_loadActionPerformed

    private void b_loadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_loadMouseClicked
        if(r_events.isSelected())
        {
             try{
                  jButton2.setEnabled(true);
                 aa.setVisible(false);
        totalex.setVisible(false);
                 
        Class.forName("com.mysql.jdbc.Driver");
           Connection con = DriverManager.getConnection
           ("jdbc:mysql://localhost:3306/math", "root", "");
           Statement stt=con.createStatement();
             ResultSet rss=stt.executeQuery("SELECT * FROM `events` where 1");
                    
                panelmodel = new DefaultTableModel();
                jTable1.setModel(panelmodel);
                
                    panelmodel.addColumn("Event");
                     panelmodel.addRow(new String[]{"Date printed: " +ft.format(datee)});
             
                
            while(rss.next())
             {
                 
                 panelmodel.addRow(new String[]{"Event Number: "+rss.getString("event_num")});
             panelmodel.addRow(new String[]{"Project Title: "+rss.getString("date")});
             panelmodel.addRow(new String[]{"Date: "+rss.getString("date")});
             panelmodel.addRow(new String[]{"Venue: "+rss.getString("venue")});
             panelmodel.addRow(new String[]{"Event Description: "+rss.getString("event_description")});
             panelmodel.addRow(new String[]{"Event Details: "+rss.getString("event_details")});
             panelmodel.addRow(new String[]{""});
             }
          panelmodel.addRow(new String[]{"NOTHING FOLLOWS"});
        }
         catch(Exception e){
         }
         
         
    
           
       
        }
        else if(r_financial.isSelected())
        {   
            jButton2.setEnabled(true);
//           aa.setVisible(true);
//        totalex.setVisible(true);
           try{
                 
        Class.forName("com.mysql.jdbc.Driver");
           Connection con = DriverManager.getConnection
           ("jdbc:mysql://localhost:3306/math", "root", "");
    
               String exp="SELECT * FROM `expenses` where 1";
          ResultSet rss;
               PreparedStatement pst;
                     pst=con.prepareStatement(exp);
                     rss=pst.executeQuery();         
                
                panelmodel = new DefaultTableModel();
                jTable1.setModel(panelmodel);
                
                        
                    panelmodel.addColumn("Financial");
                    panelmodel.addRow(new String[]{"Date Printed: "+ ft.format(datee)});
                    panelmodel.addRow(new String[]{""});
                    panelmodel.addRow(new String[]{"Expense"});
                    panelmodel.addRow(new String[]{""});
                
                        
            while(rss.next())
             {
                 
                    panelmodel.addRow(new String[]{"ID: "+rss.getString("ID")});
                         panelmodel.addRow(new String[]{"Date "+rss.getString("DATE")});
                         panelmodel.addRow(new String[]{"Item Desciption: "+rss.getString("ITEM_DESCRIPTION")});
                         panelmodel.addRow(new String[]{"Quantity: "+rss.getString("QUANTITY")});
                     panelmodel.addRow(new String[]{"Amount: "+rss.getString("AMOUNT")});
                      panelmodel.addRow(new String[]{"Total "+rss.getString("TOTAL")});
                                   panelmodel.addRow(new String[]{""});
             }
                          panelmodel.addRow(new String[]{"NOTHING FOLLOWS"});
             try{
           
             //    aa.setVisible(true);
               //       aa.setText("Total Expenses:     Php");
                  //   totalex.setVisible(true);
                     String sql="SELECT sum(TOTAL) from expenses where STATUS like 'APPROVED' ";
                     PreparedStatement pstr;
                     pstr=con.prepareStatement(sql);
                     rss=pstr.executeQuery();
                     if(rss.next()){
                         String sum= rss.getString("sum(TOTAL)");
                         expense=Integer.parseInt(sum);
                      //   totalex.setText(sum);
                       //   aa.setText("Total Expenses:     Php " +sum);
                          panelmodel.addRow(new String[]{"Total Expenses: "+"Php "+sum});
                          panelmodel.addRow(new String[]{""});
                     }
                     
                 }catch(Exception e){
                     
                 }
         
              
        }
         catch(Exception e){
         }
           
             try{
                 
        Class.forName("com.mysql.jdbc.Driver");
           Connection con = DriverManager.getConnection
           ("jdbc:mysql://localhost:3306/math", "root", "");
            String col="SELECT * FROM `collection` where 1";
          ResultSet rss;
               PreparedStatement pst;
                     pst=con.prepareStatement(col);
                     rss=pst.executeQuery();
          
                panelmodel.addRow(new String[]{"Collection"});
                panelmodel.addRow(new String[]{""});
//                panelmodel = new DefaultTableModel();
//                jTable1.setModel(panelmodel);
//                
//                        
//                    panelmodel.addColumn("ID");
//                    panelmodel.addColumn("Date");
//                    panelmodel.addColumn("Type");
//                    panelmodel.addColumn("Descrption");
//                    panelmodel.addColumn("Price");
//                
                        
            while(rss.next())
             {
                 
                    panelmodel.addRow(new String[]{"ID: " +rss.getString("ID")});
                        panelmodel.addRow(new String[]{"Date: " +rss.getString("DATE")});
                        panelmodel.addRow(new String[]{"Type: " +rss.getString("TYPE")});
                        panelmodel.addRow(new String[]{"Description: " +rss.getString("DESCRIPTION")});
                            panelmodel.addRow(new String[]{"Quantity: " +rss.getString("QUANTITY")});
                            panelmodel.addRow(new String[]{"Price: " +rss.getString("PRICE")});
                               panelmodel.addRow(new String[]{"Total: " +rss.getString("TOTAL")});
                        
                    panelmodel.addRow(new String[]{""});
             }
              panelmodel.addRow(new String[]{"NOTHING FOLLOWS"});
             try{
                    // aa.setVisible(true);
        //             aa.setText("Total Collection:   Php");
                    // totalex.setVisible(true);
                     String sql="SELECT sum(TOTAL) from collection where STATUS like 'APPROVED'";
                     PreparedStatement pstf;
                     pstf=con.prepareStatement(sql);
                     rss=pstf.executeQuery();
                     if(rss.next()){
                         String sum= rss.getString("sum(TOTAL)");
                         collect=Integer.parseInt(sum);
                     //    totalex.setText(sum);
          //               aa.setText("Total Collection:   Php "+sum);
          panelmodel.addRow(new String[]{"Total Collection: "+"Php "+sum});
                   panelmodel.addRow(new String[]{""});
           panelmodel.addRow(new String[]{"Total Financial Fund: "+Integer.toString(collect-expense)});
                     }
                     
                 }catch(Exception e){
                     
                 }
           
              
        } 
        
         catch(Exception e){
         }
         
         
    }
            
        
    
    }//GEN-LAST:event_b_loadMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        MainMenu m= new MainMenu();
        m.setVisible(true);
        m.setOfficer(officerPosition);
        this.setVisible(false);
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void r_eventsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_eventsActionPerformed
        // TODO add your handling code here:
  
    }//GEN-LAST:event_r_eventsActionPerformed

    private void r_financialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_financialActionPerformed
        // TODO add your handling code here:
         
    }//GEN-LAST:event_r_financialActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
       
          
         if(r_financial.isSelected()){
               MessageFormat header = new MessageFormat("MATH SOCIETY Financial Report"+" ("+ft.format(datee)+")");
        
            MessageFormat footer = new MessageFormat("Page {0,number,integer}");
            try{
                jTable1.print(JTable.PrintMode.FIT_WIDTH,header,footer);
               
            }catch(java.awt.print.PrinterException e){
                JOptionPane.showMessageDialog(null,"Printing Failed"+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            }
        }
        else if(r_events.isSelected()){
               MessageFormat header = new MessageFormat("MATH SOCIETY REPORT - Events" +" ("+ft.format(datee)+")");
            MessageFormat footer = new MessageFormat("Page {0,number,integer}");
            try{
                jTable1.print(JTable.PrintMode.FIT_WIDTH,header,footer);
            }catch(java.awt.print.PrinterException e){
                JOptionPane.showMessageDialog(null,"Printing Failed"+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    public void setOfficer(String officer){
        this.officerPosition = officer;
    }
    
    public void setOfficerID(String idnum){
        this.officerID = idnum;
    }


    public static void main(String args[]) {
      
       Connection conn = null;
        
       try{
           conn= DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
          System.out.println("Connected");
       }catch(SQLException e){
           System.err.println();
       }
                
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reports().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JLabel aa;
    javax.swing.JButton b_load;
    javax.swing.ButtonGroup buttonGroup1;
    javax.swing.JButton jButton1;
    javax.swing.JButton jButton2;
    javax.swing.JLabel jLabel1;
    javax.swing.JPanel jPanel1;
    javax.swing.JScrollPane jScrollPane1;
    javax.swing.JScrollPane jScrollPane2;
    javax.swing.JTable jTable1;
    javax.swing.JRadioButton r_events;
    javax.swing.JRadioButton r_financial;
    javax.swing.JLabel totalex;
    // End of variables declaration//GEN-END:variables
}
