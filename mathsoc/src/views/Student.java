package views;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Adrian
 */

import controller.StudentController;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.*;
import java.util.Date;
import javax.swing.*;
import javax.swing.JSpinner.DefaultEditor;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DateFormatter;
import javax.swing.text.PlainDocument;
import models.StudentModel;

public class Student extends javax.swing.JFrame {

    /**
     * Creates new form Student
     */
    
    public String sex="MALE";
    public String sex2="";
    public int ctr=0;
    int manyleng=0;
    String[] ids;
    DefaultTableModel panelmodel;
    SpinnerDateModel  jmodel;
    DefaultListModel listModel;
    DefaultComboBoxModel combomodel;
    static Connection connection;
    static String url;
    static Statement st;
    static ResultSet rs;
    final String task = "Student";
    String officerPosition;
    String officerID;
     Date datee= new Date();
              SimpleDateFormat fttmo = 
      new SimpleDateFormat ("MM");  
    int index1=0;
              
    public class JTextFieldLimit extends PlainDocument {
  private int limit;
    
  JTextFieldLimit(int limit) {
   super();
   this.limit = limit;
   }

  public void insertString( int offset, String  str, AttributeSet attr ) throws BadLocationException {
    if (str == null) return;

    if ((getLength() + str.length()) <= limit) {
      super.insertString(offset, str, attr);
    }
  }
}
    
    public Student() {
        initComponents();
        ImageIcon icon = new ImageIcon("C:\\Users\\Adrian\\Dropbox\\MATH SOC SYSTEM\\SOFT ENG\\MathSOC\\src\\views\\images\\MATHSOC LOGO.png");
        Student.this.setIconImage(icon.getImage());
           jLabel38.setVisible(false);
          pane4seldata.setVisible(false);
          pane4del.setVisible(false);
          jComboBox1.setVisible(false);
        try {
                load();
            } catch (SQLException ex) {
                // Logger.getLogger(frameRegister.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                //Logger.getLogger(frameRegister.class.getName()).log(Level.SEVERE, null, ex);
            }
        
       //pagseset ng maxlength ng field sa provide data
        pane2studata.setEnabled(false);
        pane4studata.setEnabled(false);
        pane1id0.setDocument
        (new JTextFieldLimit(2));
        pane1id1.setDocument
        (new JTextFieldLimit(3));
        pane1id2.setDocument
        (new JTextFieldLimit(3));
        pane1last.setDocument
        (new JTextFieldLimit(20));
        pane1first.setDocument
        (new JTextFieldLimit(20));
        pane1mi.setDocument
        (new JTextFieldLimit(4));
        pane1course.setDocument
        (new JTextFieldLimit(6));
        pane1prof.setDocument
        (new JTextFieldLimit(20));
        pane1sub.setDocument
        (new JTextFieldLimit(20));
        //pagseset ng maxlength ng field sa edit data
        pane3id0.setDocument
        (new JTextFieldLimit(2));
        pane3id1.setDocument
        (new JTextFieldLimit(3));
        pane3id2.setDocument
        (new JTextFieldLimit(3));
        pane3last.setDocument
        (new JTextFieldLimit(20));
        pane3first.setDocument
        (new JTextFieldLimit(20));
        pane3mi.setDocument
        (new JTextFieldLimit(4));
        pane3course.setDocument
        (new JTextFieldLimit(6));
        pane3prof.setDocument
        (new JTextFieldLimit(20));
        pane3sub.setDocument
        (new JTextFieldLimit(20));
        
        
    }
    
    public void loadall() throws SQLException, ClassNotFoundException{
        try{    
        Class.forName("com.mysql.jdbc.Driver");
           Connection con = DriverManager.getConnection
           ("jdbc:mysql://localhost:3306/math", "root", "");
           Statement stt=con.createStatement();
             ResultSet rss=stt.executeQuery
                ("SELECT * FROM `student` WHERE 1 ORDER BY `idno` ASC");
             
                 listModel = new DefaultListModel();
             pane2selma.setModel(listModel);
                  combomodel = new  DefaultComboBoxModel();
                   pane2selone.setModel(combomodel);
                combomodel = new  DefaultComboBoxModel();
                pane4seldata.setModel(combomodel);
                 panelmodel = new DefaultTableModel();
                   pane4studata.setModel(panelmodel);
                     panelmodel.addColumn("ID Number");
                    panelmodel.addColumn("Last Name");
                    panelmodel.addColumn("First Name");
                    panelmodel.addColumn("Middle Initial");
                    panelmodel.addColumn("Course");
                    panelmodel.addColumn("Sex");
                    panelmodel.addColumn("Professor");
                    panelmodel.addColumn("Subject");
                    panelmodel.addColumn("Payment Date");
                    panelmodel.addColumn("Payment Status");
                    panelmodel.addColumn("Membership Status");
                    panelmodel.addColumn("Membership Duration");
                      while(rss.next())
             {
                 panelmodel.addRow(new String[]{rss.getString("idno"),rss.getString("lname"),rss.getString("fname"),rss.getString("mi"),rss.getString("course"),rss.getString("sex"),rss.getString("professor"),rss.getString("subject"),rss.getString("datepay"),rss.getString("paystat")
                 ,rss.getString("memstat"),rss.getString("memsy")});
                 combomodel.addElement(rss.getString("idno"));
                 
             
             }
                }
         catch(Exception e){}
        pane4seldata.setSelectedIndex(-1);
         pane4seldata.setEnabled(true);
        
    }
    public void loadpay(String pay) throws SQLException, ClassNotFoundException{
         try{    
        Class.forName("com.mysql.jdbc.Driver");
           Connection con = DriverManager.getConnection
           ("jdbc:mysql://localhost:3306/math", "root", "");
           Statement stt=con.createStatement();
             ResultSet rss=stt.executeQuery
                ("SELECT * FROM `student` WHERE `paystat` LIKE '"+pay+"' ORDER BY `idno` ASC");
               
         
             combomodel = new  DefaultComboBoxModel();
//          pane2selone.setModel(combomodel);
                pane4seldata.setModel(combomodel);
                            panelmodel = new DefaultTableModel();
//             pane2studata.setModel(panelmodel);
               pane4studata.setModel(panelmodel);
//                 listModel = new DefaultListModel();
//             pane2selma.setModel(listModel);
                     panelmodel.addColumn("ID Number");
                    panelmodel.addColumn("Last Name");
                    panelmodel.addColumn("First Name");
                    panelmodel.addColumn("Middle Initial");
                    panelmodel.addColumn("Course");
                    panelmodel.addColumn("Sex");
                    panelmodel.addColumn("Professor");
                    panelmodel.addColumn("Subject");
                    panelmodel.addColumn("Payment Date");
                    panelmodel.addColumn("Payment Status");
                    panelmodel.addColumn("Membership Status");
                    panelmodel.addColumn("Membership Duration");
                      while(rss.next())
             {
                panelmodel.addRow(new String[]{rss.getString("idno"),rss.getString("lname"),rss.getString("fname"),rss.getString("mi"),rss.getString("course"),rss.getString("sex"),rss.getString("professor"),rss.getString("subject"),rss.getString("datepay"),rss.getString("paystat")
                 ,rss.getString("memstat"),rss.getString("memsy")});
//                 combomodel.addElement(rss.getString("idno"));
//                 listModel.addElement(rss.getString("idno"));
             
             
             }
                }
         catch(Exception e){}
//         pane2selone.setSelectedIndex(-1);
       pane4seldata.setSelectedIndex(-1);
       pane4selpay.setSelectedIndex(0);
         pane4seldata.setEnabled(true);
        
    }
    
    
    public void loadpay1(String pay) throws SQLException, ClassNotFoundException{
         try{    
        Class.forName("com.mysql.jdbc.Driver");
           Connection con = DriverManager.getConnection
           ("jdbc:mysql://localhost:3306/math", "root", "");
           Statement stt=con.createStatement();
             ResultSet rss=stt.executeQuery
                ("SELECT * FROM `student` WHERE `paystat` LIKE '"+pay+"' ORDER BY `idno` ASC");
               
         
             combomodel = new  DefaultComboBoxModel();
          pane2selone.setModel(combomodel);
              DefaultComboBoxModel combomodel1 = new DefaultComboBoxModel();
          jComboBox1.setModel(combomodel1);
                            panelmodel = new DefaultTableModel();
             pane2studata.setModel(panelmodel);
          
                 listModel = new DefaultListModel();
             pane2selma.setModel(listModel);
                     panelmodel.addColumn("ID Number");
                    panelmodel.addColumn("Last Name");
                    panelmodel.addColumn("First Name");
                    panelmodel.addColumn("Middle Initial");
                    panelmodel.addColumn("Course");
                    panelmodel.addColumn("Sex");
                    panelmodel.addColumn("Professor");
                    panelmodel.addColumn("Subject");
                    panelmodel.addColumn("Payment Date");
                    panelmodel.addColumn("Payment Status");
                    panelmodel.addColumn("Membership Status");
                    panelmodel.addColumn("Membership Duration");
                      while(rss.next())
             {
                panelmodel.addRow(new String[]{rss.getString("idno"),rss.getString("lname"),rss.getString("fname"),rss.getString("mi"),rss.getString("course"),rss.getString("sex"),rss.getString("professor"),rss.getString("subject"),rss.getString("datepay"),rss.getString("paystat")
                 ,rss.getString("memstat"),rss.getString("memsy")});
                 combomodel.addElement(rss.getString("idno"));
                 listModel.addElement(rss.getString("idno"));
                 combomodel1.addElement(rss.getString("lname")+" ,"+rss.getString("fname")+" "+rss.getString("mi")+ " "+ rss.getString("course"));
             
             }
                }
         catch(Exception e){}
         pane2selone.setSelectedIndex(-1);
    
        
    }
    
    public void loadmem(String mem) throws SQLException, ClassNotFoundException{
        try{    
        Class.forName("com.mysql.jdbc.Driver");
           Connection con = DriverManager.getConnection
           ("jdbc:mysql://localhost:3306/math", "root", "");
           Statement stt=con.createStatement();
             ResultSet rss=stt.executeQuery
                ("SELECT * FROM `student` WHERE `memstat` LIKE '"+mem+"' ORDER BY `idno` ASC");
              
            
             combomodel = new  DefaultComboBoxModel();
                pane4seldata.setModel(combomodel);
                 panelmodel = new DefaultTableModel();
                   pane4studata.setModel(panelmodel);
                     panelmodel.addColumn("ID Number");
                    panelmodel.addColumn("Last Name");
                    panelmodel.addColumn("First Name");
                    panelmodel.addColumn("Middle Initial");
                    panelmodel.addColumn("Course");
                    panelmodel.addColumn("Sex");
                    panelmodel.addColumn("Professor");
                    panelmodel.addColumn("Subject");
                    panelmodel.addColumn("Payment Date");
                    panelmodel.addColumn("Payment Status");
                    panelmodel.addColumn("Membership Status");
                    panelmodel.addColumn("Membership Duration");
                      while(rss.next())
             {
                 panelmodel.addRow(new String[]{rss.getString("idno"),rss.getString("lname"),rss.getString("fname"),rss.getString("mi"),rss.getString("course"),rss.getString("sex"),rss.getString("professor"),rss.getString("subject"),rss.getString("datepay"),rss.getString("paystat")
                 ,rss.getString("memstat"),rss.getString("memsy")});
                 combomodel.addElement(rss.getString("idno"));
                 
             
             }
                }
         catch(Exception e){}
        pane4seldata.setSelectedIndex(-1);
           pane4selmem.setSelectedIndex(0);
         pane4seldata.setEnabled(true);
        
    }
    public void loadid(String id) throws SQLException, ClassNotFoundException{
        
   try{    
        Class.forName("com.mysql.jdbc.Driver");
           Connection con = DriverManager.getConnection
           ("jdbc:mysql://localhost:3306/math", "root", "");
           Statement stt=con.createStatement();
             ResultSet rss=stt.executeQuery
                ("SELECT * FROM `student` WHERE `idno` LIKE '%"+id+"%' ORDER BY `idno` ASC");
                combomodel = new  DefaultComboBoxModel();
                pane4seldata.setModel(combomodel);
                 panelmodel = new DefaultTableModel();
                   pane4studata.setModel(panelmodel);
                     panelmodel.addColumn("ID Number");
                    panelmodel.addColumn("Last Name");
                    panelmodel.addColumn("First Name");
                    panelmodel.addColumn("Middle Initial");
                    panelmodel.addColumn("Course");
                    panelmodel.addColumn("Sex");
                    panelmodel.addColumn("Professor");
                    panelmodel.addColumn("Subject");
                    panelmodel.addColumn("Payment Date");
                    panelmodel.addColumn("Payment Status");
                    panelmodel.addColumn("Membership Status");
                    panelmodel.addColumn("Membership Duration");
                      while(rss.next())
             {
                 panelmodel.addRow(new String[]{rss.getString("idno"),rss.getString("lname"),rss.getString("fname"),rss.getString("mi"),rss.getString("course"),rss.getString("sex"),rss.getString("professor"),rss.getString("subject"),rss.getString("datepay"),rss.getString("paystat")
                 ,rss.getString("memstat"),rss.getString("memsy")});
                 combomodel.addElement(rss.getString("idno"));
                 
             
             }
                }
         catch(Exception e){}
        
         pane4seldata.setSelectedIndex(-1);
         pane4seldata.setEnabled(true);
        
    }
    
     public void loadid1(String id) throws SQLException, ClassNotFoundException{
        
   try{    
        Class.forName("com.mysql.jdbc.Driver");
           Connection con = DriverManager.getConnection
           ("jdbc:mysql://localhost:3306/math", "root", "");
           Statement stt=con.createStatement();
             ResultSet rss=stt.executeQuery
                ("SELECT * FROM `student` WHERE `idno` LIKE '%"+id+"%' ORDER BY `idno` ASC");
            
                 panelmodel = new DefaultTableModel();
                  pane2studata1.setModel(panelmodel);
                     panelmodel.addColumn("ID Number");
                    panelmodel.addColumn("Last Name");
                    panelmodel.addColumn("First Name");
                    panelmodel.addColumn("Middle Initial");
                    panelmodel.addColumn("Course");
                    panelmodel.addColumn("Sex");
                    panelmodel.addColumn("Professor");
                    panelmodel.addColumn("Subject");
                    panelmodel.addColumn("Payment Date");
                    panelmodel.addColumn("Payment Status");
                    panelmodel.addColumn("Membership Status");
                    panelmodel.addColumn("Membership Duration");
                      while(rss.next())
             {
                 panelmodel.addRow(new String[]{rss.getString("idno"),rss.getString("lname"),rss.getString("fname"),rss.getString("mi"),rss.getString("course"),rss.getString("sex"),rss.getString("professor"),rss.getString("subject"),rss.getString("datepay"),rss.getString("paystat")
                 ,rss.getString("memstat"),rss.getString("memsy")});
                 
             }
                }
         catch(Exception e){}
        
       
    }
     
     
   
            
      
    public void load() throws SQLException, ClassNotFoundException{
        
         try{
        Class.forName("com.mysql.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/math", "root", "");
           Statement stt=con.createStatement();
             ResultSet rss=stt.executeQuery("select * from student where 1");
              
          
             combomodel = new  DefaultComboBoxModel();
            
          pane2selone.setModel(combomodel);
          pane3idsel.setModel(combomodel);
          DefaultComboBoxModel combomodel1 = new DefaultComboBoxModel();
          jComboBox1.setModel(combomodel1);
         
            pane4seldata.setModel(combomodel);
         jmodel  = new SpinnerDateModel();
          pane3spindate.setModel(jmodel);
          
             pane3spindate.setEditor(new JSpinner.DateEditor(pane3spindate,"MM-dd-yyyy"));
            ((DefaultEditor) pane3spindate.getEditor()).getTextField().setEditable(false);
                panelmodel = new DefaultTableModel();
             pane2studata.setModel(panelmodel);
               pane4studata.setModel(panelmodel);
             pane2studata1.setModel(panelmodel);
              pane2studata2.setModel(panelmodel);
              
             listModel = new DefaultListModel();
             pane2selma.setModel(listModel);
             
                    panelmodel.addColumn("ID Number");
                    panelmodel.addColumn("Last Name");
                    panelmodel.addColumn("First Name");
                    panelmodel.addColumn("Middle Initial");
                    panelmodel.addColumn("Course");
                    panelmodel.addColumn("Sex");
                    panelmodel.addColumn("Professor");
                    panelmodel.addColumn("Subject");
                    panelmodel.addColumn("Payment Date");
                    panelmodel.addColumn("Payment Status");
                    panelmodel.addColumn("Membership Status");
                    panelmodel.addColumn("Membership Duration");
                    int ctr=0;
            while(rss.next())
             {
            
                 panelmodel.addRow(new String[]{rss.getString("idno"),rss.getString("lname"),rss.getString("fname"),rss.getString("mi"),rss.getString("course"),rss.getString("sex"),rss.getString("professor"),rss.getString("subject"),rss.getString("datepay"),rss.getString("paystat")
                 ,rss.getString("memstat"),rss.getString("memsy")});
                 combomodel.addElement(rss.getString("idno"));
                 listModel.addElement(rss.getString("idno"));
                 combomodel1.addElement(rss.getString("lname")+" ,"+rss.getString("fname")+" "+rss.getString("mi")+ " "+ rss.getString("course"));
                 
                
             
             }
             pane2selone.setSelectedIndex(-1);
           pane3idsel.setSelectedIndex(-1);
           pane4seldata.setSelectedIndex(-1);
           pane4seldata.setEnabled(false);
          
        }
         catch(Exception e){}
    }
    
  
    
    //values pa more
    
     public String getid(){
         String id="";
         id= pane1id0.getText()+"-"+pane1id1.getText()+"-"+pane1id2.getText();
        return id;
    }
     
  
     
    public String getlast(){
      return pane1last.getText();
    }
    public String getfirst(){
        return pane1first.getText();
    }
    public String getmi(){
        return pane1mi.getText();
    }
    public String getcourse(){
        return pane1course.getText();
    }
  
    public String getsub(){
        return pane1sub.getText();
    }
    public String getprof(){
        return pane1prof.getText();
    }
    
    public String getiddel(){
        if(pane4seldata.getSelectedIndex()==-1)
                {
                  return "wala";
                }
        else{    
        return pane4seldata.getSelectedItem().toString();
        }
    }
    
     public String[] getiddec(){
        String[ ] a = new String[listModel.getSize()];
       for(int x=0;x<pane2studata.getRowCount();x++){
                     a[x]=pane2studata.getValueAt(x,0).toString();
                 }
      return a;
          
     
        
    }
    
    public String getreid(){
        return pane3idsel.getSelectedItem().toString();
    }

    public String getedid(){
        String id1="";
         id1= pane3id0.getText()+"-"+pane3id1.getText()+"-"+pane3id2.getText();
        return id1;
    }
    public String getedlast(){
        return pane3last.getText();
    }
    public String getedfirst(){
        return pane3first.getText();
    }
    public String getedmi(){
        return pane3mi.getText();
    }
    public String getedcourse(){
        return pane3course.getText();
    }
  
    public String getedsub(){
        return pane3sub.getText();
    }
    public String getedprof(){
        return pane3prof.getText();
    }
     public String getedpaystat(){
           if(pane3idsel.getSelectedIndex()==-1)
                {
                  return "wala";
                }
        else{    
         return  pane3paybox.getSelectedItem().toString();
        }
}
     public String geteddatepay(){
          DateFormat dff = new SimpleDateFormat("MM-dd-yyyy");
        return  dff.format(pane3spindate.getValue());
    }
     
   public String[] getpayone(){
        String[] a = new String[1];
        a[0]=pane2selone.getSelectedItem().toString();
        index1=pane2selone.getSelectedIndex();
       return a;
   }
  public String info(){
       String info="";
       info=jComboBox1.getItemAt(index1).toString();
       return info;
   }
   public String[] getpaymany(){
       String[ ] a = new String[listModel.getSize()];
       for(int x=0;x<listModel.getSize();x++){
                        if(pane2selma.isSelectedIndex(x)){
                   
                     a[x]=pane2studata.getValueAt(x,0).toString();
                    
                        }
                    }
      return a;
   }
   
    public String[] getpayall(){
       String[ ] a = new String[listModel.getSize()];
       for(int x=0;x<pane2studata.getRowCount();x++){
                     a[x]=pane2studata.getValueAt(x,0).toString();
                 }
      return a;
   }
    
   public int getlength(){
       if (ctr==0){
           return pane2studata.getRowCount();
       }
       else if(ctr==2){
           return listModel.getSize();
       }
       else{
           return 0;
       }
   }
   public int getlength1(){
     
           return pane4studata.getRowCount();
       
   }
   
 //buttons pa more   
    
 public void reg(ActionListener al){
        pane1reg.addActionListener(al);
}    
 
 
public void del(ActionListener al){
        pane4del.addActionListener(al);
}

public void dec(ActionListener al){
        pane4dec.addActionListener(al);
}  

public void ed(ActionListener al){
        pane3edit.addActionListener(al);
} 

public void pay(ActionListener al){
        pane2conf.addActionListener(al);
} 

    
public void resetprovide(){
     pane1id0.setText("");pane1id1.setText("");pane1last.setText("");pane1first.setText("");
            pane1id2.setText("");pane1course.setText("");pane1prof.setText("");pane1sub.setText("");
                       pane1mi.setText("");
                        
}    

public void reseted(){
        pane3id1.setEnabled(false); pane3id1.setText("");pane3last.setEnabled(false); pane3last.setText("");
                pane3first.setEnabled(false); pane3first.setText("");pane3prof.setEnabled(false); pane3prof.setText("");
                pane3sub.setEnabled(false); pane3sub.setText("");pane3course.setEnabled(false); pane3course.setText("");
                pane3sexm.setEnabled(false);pane3sexf.setEnabled(false);pane3spindate.setEnabled(false);pane3paybox.setEnabled(false);
                pane3paybox.setSelectedIndex(-1);pane3mi.setEnabled(false); pane3mi.setText("");
                pane3id0.setEnabled(false); pane3id0.setText("");pane3id2.setEnabled(false); pane3id2.setText("");
                        
}    
 
    
    public void search(){
        Connection cn;
        ResultSet rst;
        Statement sti;
        String urll;
        rst=null;
         try {     
                    urll = "jdbc:mysql://localhost:3306/math";
                    Class.forName("com.mysql.jdbc.Driver");
                    cn = (Connection) DriverManager.getConnection(urll, "root","");
                    sti = (Statement) cn.createStatement();
                    rst = sti.executeQuery("Select * From student Where idno= '" + pane3idsel.getSelectedItem().toString() + "'  ");
                    rst.next();
                    String a="",b="",c="";
                    for(int i=0;i<10;i++){
                        if(i==0 || i==1)
                        {
                         a+=rst.getString("idno").charAt(i);
                        }
                        else if(i==3||i==4||i==5){
                              b+=rst.getString("idno").charAt(i);
                        }
                        else if(i==7||i==8||i==9){
                              c+=rst.getString("idno").charAt(i);
                        }
                            
                    }
                   
                    
                    pane3id0.setText(a);
                    pane3id1.setText(b);
                    pane3id2.setText(c);
                    pane3id0.setEnabled(true);
                   pane3id1.setEnabled(true);
                   pane3id2.setEnabled(true);
                    pane3last.setText(rst.getString("lname"));
                    pane3last.setEnabled(true);
                   
                    pane3first.setText(rst.getString("fname"));
                    pane3first.setEnabled(true);

                    pane3mi.setText(rst.getString("mi"));
                    pane3mi.setEnabled(true);
                    
                    pane3course.setText(rst.getString("course"));
                    pane3course.setEnabled(true);
                    
                    String sex1=rst.getString("sex");
                    if(sex1.startsWith("M")){
                        sex2="MALE";
                        pane3sexm.setSelected(true);
                        pane3sexm.setEnabled(true);
                        pane3sexf.setEnabled(true);
                    }
                    else{
                        sex2="FEMALE";
                        pane3sexf.setSelected(true);
                        pane3sexm.setEnabled(true);
                        pane3sexf.setEnabled(true);
                    }
                    
                    
                    pane3prof.setText(rst.getString("professor"));
                    pane3prof.setEnabled(true);
                    
                    pane3sub.setText(rst.getString("subject"));
                    pane3sub.setEnabled(true);
                     DateFormat df = new SimpleDateFormat("MM/dd/yyyy"); 
                     Date startDate;
                     
                        try {
                     startDate = df.parse(rst.getString("datepay"));
                     String newDateString = df.format(startDate);
                     pane3spindate.setValue(newDateString);
        
                    } catch (ParseException e) {
                     
                    }
                    
                    pane3spindate.setEnabled(true);
                   
                    if(rst.getString("paystat").equals("PAID")){
                        pane3paybox.setSelectedIndex(0);
                        pane3paybox.setEnabled(true);
                    }
                    else{
                        
                        pane3paybox.setSelectedIndex(1);
                         pane3paybox.setEnabled(true);
                    }
                    pane3edit.setEnabled(true);
                    
                }
            catch(SQLException ex) {
                //Logger.getLogger(frameTerminateEdit.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Data Not Found","System Message",JOptionPane.ERROR_MESSAGE);
                
            }catch (ClassNotFoundException ex) {
                //1 Logger.getLogger(frameTerminateEdit.class.getName()).log(Level.SEVERE, null, ex);
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

        pane1sex = new javax.swing.ButtonGroup();
        pane2sel = new javax.swing.ButtonGroup();
        pane3sex = new javax.swing.ButtonGroup();
        decview = new javax.swing.ButtonGroup();
        paygp = new javax.swing.ButtonGroup();
        stud = new javax.swing.JTabbedPane();
        provdata = new javax.swing.JScrollPane();
        pane1 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        pane1id0 = new javax.swing.JTextField();
        pane1id1 = new javax.swing.JTextField();
        pane1id2 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        pane1last = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        pane1first = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        pane1course = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        pane1prof = new javax.swing.JTextField();
        pane1sexm = new javax.swing.JRadioButton();
        pane1sexf = new javax.swing.JRadioButton();
        pane1reg = new javax.swing.JButton();
        pane1sub = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        pane2studata1 = new javax.swing.JTable();
        pane1mi = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pane4idview1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        pane1back = new javax.swing.JButton();
        payconfirm = new javax.swing.JScrollPane();
        pane2 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        pane2studata = new javax.swing.JTable();
        pane2selone = new javax.swing.JComboBox();
        pane2selall = new javax.swing.JRadioButton();
        pane2seleone = new javax.swing.JRadioButton();
        pane2selmany = new javax.swing.JScrollPane();
        pane2selma = new javax.swing.JList();
        pane2selman = new javax.swing.JRadioButton();
        pane2conf = new javax.swing.JButton();
        pane1back1 = new javax.swing.JButton();
        pane2notpaid = new javax.swing.JRadioButton();
        pane2all = new javax.swing.JRadioButton();
        pane2paid = new javax.swing.JRadioButton();
        jComboBox1 = new javax.swing.JComboBox();
        eddata = new javax.swing.JScrollPane();
        pane3 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        pane3id0 = new javax.swing.JTextField();
        pane3id1 = new javax.swing.JTextField();
        pane3id2 = new javax.swing.JTextField();
        pane3last = new javax.swing.JTextField();
        pane3first = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        pane3mi = new javax.swing.JTextField();
        pane3sexm = new javax.swing.JRadioButton();
        pane3sexf = new javax.swing.JRadioButton();
        pane3course = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        pane3prof = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        pane3idsel = new javax.swing.JComboBox();
        pane3apply = new javax.swing.JButton();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        pane3edit = new javax.swing.JButton();
        pane3sub = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        pane2studata2 = new javax.swing.JTable();
        pane3spindate = new javax.swing.JSpinner();
        pane3paybox = new javax.swing.JComboBox();
        jLabel31 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        pane1back2 = new javax.swing.JButton();
        deldata = new javax.swing.JScrollPane();
        pane4 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        pane4del = new javax.swing.JButton();
        pane4seldata = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        pane4studata = new javax.swing.JTable();
        pane4dec = new javax.swing.JButton();
        pane4all = new javax.swing.JRadioButton();
        pane4pay = new javax.swing.JRadioButton();
        pane4mem = new javax.swing.JRadioButton();
        pane4id = new javax.swing.JRadioButton();
        jLabel42 = new javax.swing.JLabel();
        pane4idview = new javax.swing.JTextField();
        pane4selpay = new javax.swing.JComboBox();
        pane4selmem = new javax.swing.JComboBox();
        pane1back3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Student");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName("Student"); // NOI18N
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        stud.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 0, 0)));
        stud.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        stud.setAutoscrolls(true);
        stud.setName("STUDENT"); // NOI18N

        pane1.setBackground(new java.awt.Color(255, 255, 255));
        pane1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 0, 0)));

        jLabel20.setText("ID NUMBER");

        pane1id0.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pane1id0KeyTyped(evt);
            }
        });

        pane1id1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pane1id1KeyTyped(evt);
            }
        });

        pane1id2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pane1id2KeyTyped(evt);
            }
        });

        jLabel21.setText("LAST NAME");

        pane1last.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pane1lastKeyTyped(evt);
            }
        });

        jLabel22.setText("FIRST NAME");

        pane1first.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pane1firstKeyTyped(evt);
            }
        });

        jLabel24.setText("SEX");

        jLabel25.setText("COURSE");

        pane1course.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pane1courseKeyTyped(evt);
            }
        });

        jLabel26.setText("PROFESSOR");

        pane1prof.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pane1profKeyTyped(evt);
            }
        });

        pane1sex.add(pane1sexm);
        pane1sexm.setSelected(true);
        pane1sexm.setText("MALE");
        pane1sexm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pane1sexmActionPerformed(evt);
            }
        });

        pane1sex.add(pane1sexf);
        pane1sexf.setText("FEMALE");
        pane1sexf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pane1sexfActionPerformed(evt);
            }
        });

        pane1reg.setText("Register");

        pane1sub.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pane1subKeyTyped(evt);
            }
        });

        jLabel39.setText("SUBJECT");

        jScrollPane10.setBorder(javax.swing.BorderFactory.createTitledBorder("Student Data"));

        pane2studata1.setAutoCreateRowSorter(true);
        pane2studata1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pane2studata1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        pane2studata1.setToolTipText("Student Record");
        pane2studata1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        pane2studata1.setEnabled(false);
        pane2studata1.setName("Membership"); // NOI18N
        pane2studata1.setRowMargin(0);
        jScrollPane10.setViewportView(pane2studata1);

        pane1mi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pane1miKeyTyped(evt);
            }
        });

        jLabel41.setText("MIDDLE INITIAL");

        jLabel1.setText("_");

        jLabel2.setText("_");

        pane4idview1.setBackground(new java.awt.Color(0, 51, 51));
        pane4idview1.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        pane4idview1.setForeground(new java.awt.Color(255, 255, 255));
        pane4idview1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pane4idview1ActionPerformed(evt);
            }
        });
        pane4idview1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pane4idview1KeyTyped(evt);
            }
        });

        jLabel5.setText("ID Number");

        pane1back.setBackground(new java.awt.Color(0, 51, 51));
        pane1back.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        pane1back.setForeground(new java.awt.Color(255, 255, 255));
        pane1back.setText("Back");
        pane1back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pane1backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pane1Layout = new javax.swing.GroupLayout(pane1);
        pane1.setLayout(pane1Layout);
        pane1Layout.setHorizontalGroup(
            pane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 764, Short.MAX_VALUE)
                    .addGroup(pane1Layout.createSequentialGroup()
                        .addGroup(pane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pane1Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addGap(36, 36, 36)
                                .addComponent(pane1id0, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pane1id1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pane1id2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(pane1reg)
                            .addGroup(pane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(pane1Layout.createSequentialGroup()
                                    .addComponent(jLabel41)
                                    .addGap(18, 18, 18)
                                    .addComponent(pane1mi))
                                .addGroup(pane1Layout.createSequentialGroup()
                                    .addGroup(pane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel22)
                                        .addComponent(jLabel21))
                                    .addGap(36, 36, 36)
                                    .addGroup(pane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(pane1last)
                                        .addComponent(pane1first)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pane1Layout.createSequentialGroup()
                                    .addComponent(jLabel24)
                                    .addGap(84, 84, 84)
                                    .addComponent(pane1sexm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(18, 18, 18)
                                    .addComponent(pane1sexf))
                                .addGroup(pane1Layout.createSequentialGroup()
                                    .addGroup(pane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel25)
                                        .addComponent(jLabel26)
                                        .addComponent(jLabel39))
                                    .addGap(36, 36, 36)
                                    .addGroup(pane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(pane1sub)
                                        .addComponent(pane1course)
                                        .addComponent(pane1prof, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pane1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pane4idview1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pane1back, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))))
        );
        pane1Layout.setVerticalGroup(
            pane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pane1Layout.createSequentialGroup()
                .addGroup(pane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pane1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pane4idview1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addComponent(pane1back, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addGroup(pane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(pane1id1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pane1id2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pane1id0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pane1last, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(pane1first, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(pane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pane1mi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(pane1sexm)
                    .addComponent(pane1sexf))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(pane1course, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(pane1prof, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(pane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(pane1sub, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pane1reg)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        provdata.setViewportView(pane1);

        stud.addTab("Provide Data", provdata);

        pane2.setBackground(new java.awt.Color(255, 255, 255));
        pane2.setBorder(new javax.swing.border.MatteBorder(null));

        jScrollPane9.setBorder(javax.swing.BorderFactory.createTitledBorder("Student Data"));

        pane2studata.setAutoCreateRowSorter(true);
        pane2studata.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pane2studata.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        pane2studata.setToolTipText("Student Record");
        pane2studata.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        pane2studata.setEnabled(false);
        pane2studata.setName("Membership"); // NOI18N
        pane2studata.setRowMargin(0);
        jScrollPane9.setViewportView(pane2studata);

        pane2selone.setEnabled(false);
        pane2selone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pane2seloneMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pane2seloneMousePressed(evt);
            }
        });
        pane2selone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pane2seloneKeyPressed(evt);
            }
        });

        pane2sel.add(pane2selall);
        pane2selall.setText("Confirm ALL");
        pane2selall.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pane2selallMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pane2selallMousePressed(evt);
            }
        });
        pane2selall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pane2selallActionPerformed(evt);
            }
        });
        pane2selall.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pane2selallKeyPressed(evt);
            }
        });

        pane2sel.add(pane2seleone);
        pane2seleone.setText("Select ONE");
        pane2seleone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pane2seleoneActionPerformed(evt);
            }
        });

        pane2selmany.setBorder(javax.swing.BorderFactory.createTitledBorder("Select one/more"));

        pane2selma.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pane2selma.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { " ", " " };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        pane2selma.setEnabled(false);
        pane2selma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pane2selmaMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pane2selmaMousePressed(evt);
            }
        });
        pane2selma.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pane2selmaKeyPressed(evt);
            }
        });
        pane2selmany.setViewportView(pane2selma);

        pane2sel.add(pane2selman);
        pane2selman.setText("Select MANY");
        pane2selman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pane2selmanActionPerformed(evt);
            }
        });

        pane2conf.setText("Confirm");
        pane2conf.setEnabled(false);

        pane1back1.setText("Back");
        pane1back1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pane1back1ActionPerformed(evt);
            }
        });

        paygp.add(pane2notpaid);
        pane2notpaid.setText("NOT PAID");
        pane2notpaid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pane2notpaidActionPerformed(evt);
            }
        });

        paygp.add(pane2all);
        pane2all.setText("ALL");
        pane2all.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pane2allActionPerformed(evt);
            }
        });

        paygp.add(pane2paid);
        pane2paid.setText("PAID");
        pane2paid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pane2paidActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));

        javax.swing.GroupLayout pane2Layout = new javax.swing.GroupLayout(pane2);
        pane2.setLayout(pane2Layout);
        pane2Layout.setHorizontalGroup(
            pane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pane2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(pane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pane2Layout.createSequentialGroup()
                        .addComponent(pane2selall)
                        .addGap(26, 26, 26)
                        .addComponent(pane2seleone))
                    .addGroup(pane2Layout.createSequentialGroup()
                        .addGroup(pane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pane2Layout.createSequentialGroup()
                                .addComponent(pane2conf)
                                .addGap(217, 217, 217))
                            .addGroup(pane2Layout.createSequentialGroup()
                                .addGap(109, 109, 109)
                                .addGroup(pane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(pane2selone, 0, 187, Short.MAX_VALUE)
                                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(pane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pane2selman)
                            .addComponent(pane2selmany, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pane2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pane2Layout.createSequentialGroup()
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 769, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(pane2Layout.createSequentialGroup()
                        .addComponent(pane2all)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pane2notpaid)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pane2paid)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pane1back1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))))
        );
        pane2Layout.setVerticalGroup(
            pane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pane2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pane2all)
                    .addComponent(pane2notpaid)
                    .addComponent(pane2paid)
                    .addComponent(pane1back1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pane2selall)
                    .addComponent(pane2seleone)
                    .addComponent(pane2selman))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pane2selmany, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pane2Layout.createSequentialGroup()
                        .addComponent(pane2selone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(pane2conf)))
                .addGap(54, 54, 54))
        );

        payconfirm.setViewportView(pane2);

        stud.addTab("Payment Confirmation", payconfirm);

        pane3.setBackground(new java.awt.Color(255, 255, 255));
        pane3.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel28.setText("ID NUMBER");

        pane3id0.setEnabled(false);
        pane3id0.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pane3id0KeyTyped(evt);
            }
        });

        pane3id1.setEnabled(false);
        pane3id1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pane3id1KeyTyped(evt);
            }
        });

        pane3id2.setEnabled(false);
        pane3id2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pane3id2KeyTyped(evt);
            }
        });

        pane3last.setEnabled(false);
        pane3last.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pane3lastKeyTyped(evt);
            }
        });

        pane3first.setEnabled(false);
        pane3first.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pane3firstKeyTyped(evt);
            }
        });

        jLabel29.setText("LAST NAME");

        jLabel30.setText("FIRST NAME");

        jLabel32.setText("SEX");

        pane3mi.setEnabled(false);
        pane3mi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pane3miKeyTyped(evt);
            }
        });

        pane3sex.add(pane3sexm);
        pane3sexm.setText("MALE");
        pane3sexm.setEnabled(false);
        pane3sexm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pane3sexmActionPerformed(evt);
            }
        });

        pane3sex.add(pane3sexf);
        pane3sexf.setText("FEMALE");
        pane3sexf.setEnabled(false);
        pane3sexf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pane3sexfActionPerformed(evt);
            }
        });

        pane3course.setEnabled(false);
        pane3course.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pane3courseKeyTyped(evt);
            }
        });

        jLabel33.setText("COURSE");

        jLabel34.setText("PROFESSOR");

        pane3prof.setEnabled(false);
        pane3prof.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pane3profKeyTyped(evt);
            }
        });

        jLabel35.setText("ID NUMBER");

        jSeparator2.setBorder(javax.swing.BorderFactory.createTitledBorder("Edit Data"));

        pane3idsel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pane3idselMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pane3idselMousePressed(evt);
            }
        });
        pane3idsel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pane3idselKeyPressed(evt);
            }
        });

        pane3apply.setText("Apply");
        pane3apply.setEnabled(false);
        pane3apply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pane3applyActionPerformed(evt);
            }
        });

        jLabel36.setText("Date of Payment");

        jLabel37.setText("Payment Status");

        pane3edit.setText("Edit");
        pane3edit.setEnabled(false);

        pane3sub.setEnabled(false);
        pane3sub.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pane3subKeyTyped(evt);
            }
        });

        jLabel40.setText("SUBJECT");

        jScrollPane11.setBorder(javax.swing.BorderFactory.createTitledBorder("Student Data"));

        pane2studata2.setAutoCreateRowSorter(true);
        pane2studata2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pane2studata2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        pane2studata2.setToolTipText("Student Record");
        pane2studata2.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        pane2studata2.setEnabled(false);
        pane2studata2.setName("Membership"); // NOI18N
        pane2studata2.setRowMargin(0);
        jScrollPane11.setViewportView(pane2studata2);

        pane3spindate.setModel(new javax.swing.SpinnerDateModel());
        pane3spindate.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pane3spindate.setEditor(new javax.swing.JSpinner.DateEditor(pane3spindate, ""));
        pane3spindate.setEnabled(false);

        pane3paybox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PAID", "NOT PAID" }));
        pane3paybox.setSelectedIndex(-1);
        pane3paybox.setEnabled(false);

        jLabel31.setText("MIDDLE INITIAL");

        jLabel3.setText("_");

        jLabel4.setText("_");

        pane1back2.setText("Back");
        pane1back2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pane1back2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pane3Layout = new javax.swing.GroupLayout(pane3);
        pane3.setLayout(pane3Layout);
        pane3Layout.setHorizontalGroup(
            pane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pane3Layout.createSequentialGroup()
                .addGroup(pane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pane3Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pane3idsel, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pane3apply)
                        .addGap(73, 73, 73)
                        .addComponent(pane1back2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 718, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pane3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel36))
                    .addGroup(pane3Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(pane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel29)
                            .addComponent(jLabel30)
                            .addComponent(jLabel35))
                        .addGap(42, 42, 42)
                        .addGroup(pane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pane3Layout.createSequentialGroup()
                                .addComponent(pane3sexm)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pane3sexf))
                            .addComponent(pane3course, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pane3Layout.createSequentialGroup()
                                .addGroup(pane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(pane3Layout.createSequentialGroup()
                                        .addComponent(pane3id0, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(pane3id1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(pane3last, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(pane3first, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(pane3mi, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(7, 7, 7)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(pane3id2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pane3Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(pane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pane3prof, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pane3Layout.createSequentialGroup()
                                .addComponent(jLabel40)
                                .addGap(61, 61, 61)
                                .addGroup(pane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(pane3paybox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(pane3spindate)
                                    .addComponent(pane3sub, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE))))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pane3Layout.createSequentialGroup()
                .addGroup(pane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pane3Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(pane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel31)
                            .addComponent(jLabel32)
                            .addComponent(jLabel33)
                            .addComponent(jLabel34)))
                    .addGroup(pane3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel37)
                            .addComponent(pane3edit)
                            .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 748, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pane3Layout.setVerticalGroup(
            pane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pane3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pane1back2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel28)
                        .addComponent(pane3idsel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pane3apply)))
                .addGroup(pane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pane3Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel35)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pane3Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(pane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(pane3id0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pane3id1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pane3id2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(pane3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pane3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(pane3last, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(pane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(pane3first, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pane3mi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(pane3sexm)
                    .addComponent(pane3sexf))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(pane3course, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(pane3prof, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(pane3sub, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(pane3spindate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(pane3paybox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(pane3edit)
                .addContainerGap())
        );

        eddata.setViewportView(pane3);

        stud.addTab("Edit Data", eddata);

        pane4.setBackground(new java.awt.Color(255, 255, 255));
        pane4.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel38.setText("ID NUMBER");

        pane4del.setText("Delete");

        pane4seldata.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pane4seldataMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pane4seldataMousePressed(evt);
            }
        });
        pane4seldata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pane4seldataActionPerformed(evt);
            }
        });
        pane4seldata.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pane4seldataKeyPressed(evt);
            }
        });

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("Decline Membership"));

        pane4studata.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pane4studata.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(pane4studata);

        pane4dec.setText("Decline");

        decview.add(pane4all);
        pane4all.setText("ALL");
        pane4all.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pane4allActionPerformed(evt);
            }
        });

        decview.add(pane4pay);
        pane4pay.setText("PAYMENT STATUS");
        pane4pay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pane4payActionPerformed(evt);
            }
        });

        decview.add(pane4mem);
        pane4mem.setText("MEMBERSHIP STATUS");
        pane4mem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pane4memActionPerformed(evt);
            }
        });

        decview.add(pane4id);
        pane4id.setText("ID NUMBER");
        pane4id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pane4idActionPerformed(evt);
            }
        });

        jLabel42.setText("VIEW OR SEARCH BY:");

        pane4idview.setEnabled(false);
        pane4idview.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pane4idviewKeyTyped(evt);
            }
        });

        pane4selpay.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "----------", "NOT PAID", "PAID" }));
        pane4selpay.setEnabled(false);
        pane4selpay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pane4selpayActionPerformed(evt);
            }
        });

        pane4selmem.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "----------", "NOT MEMBER", "MEMBER" }));
        pane4selmem.setEnabled(false);
        pane4selmem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pane4selmemActionPerformed(evt);
            }
        });

        pane1back3.setText("Back");
        pane1back3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pane1back3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pane4Layout = new javax.swing.GroupLayout(pane4);
        pane4.setLayout(pane4Layout);
        pane4Layout.setHorizontalGroup(
            pane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pane4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(pane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pane4Layout.createSequentialGroup()
                        .addGroup(pane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pane4Layout.createSequentialGroup()
                                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pane4seldata, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pane4Layout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addComponent(pane4dec)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pane1back3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pane4del)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pane4Layout.createSequentialGroup()
                        .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pane4all)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pane4selpay, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pane4pay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(10, 10, 10)
                        .addGroup(pane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pane4Layout.createSequentialGroup()
                                .addComponent(pane4selmem, 0, 105, Short.MAX_VALUE)
                                .addGap(350, 350, 350))
                            .addGroup(pane4Layout.createSequentialGroup()
                                .addComponent(pane4mem)
                                .addGap(18, 18, 18)
                                .addComponent(pane4id)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pane4idview, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
            .addGroup(pane4Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        pane4Layout.setVerticalGroup(
            pane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pane4Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pane4all)
                    .addComponent(pane4pay)
                    .addComponent(pane4mem)
                    .addComponent(pane4id)
                    .addComponent(jLabel42)
                    .addComponent(pane4idview, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pane4selpay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pane4selmem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(pane4seldata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pane4del)
                    .addComponent(pane4dec)
                    .addComponent(pane1back3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        deldata.setViewportView(pane4);

        stud.addTab("Decline Membership", deldata);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(stud, javax.swing.GroupLayout.PREFERRED_SIZE, 802, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(stud, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void pane3applyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pane3applyActionPerformed
        // TODO add your handling code here:
         search();
        
    }//GEN-LAST:event_pane3applyActionPerformed

    private void pane3sexfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pane3sexfActionPerformed
        // TODO add your handling code here:
        sex2="FEMALE";
    }//GEN-LAST:event_pane3sexfActionPerformed

    private void pane1sexfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pane1sexfActionPerformed
        // TODO add your handling code here:
        sex="FEMALE";
    }//GEN-LAST:event_pane1sexfActionPerformed

    private void pane2seleoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pane2seleoneActionPerformed
        // TODO add your handling code here:
        ctr=1;
        pane2selone.setEnabled(true);
        pane2selma.setEnabled(false);
    }//GEN-LAST:event_pane2seleoneActionPerformed

    private void pane2selmanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pane2selmanActionPerformed
        // TODO add your handling code here:
        ctr=2;
        pane2selone.setEnabled(false);
        pane2selma.setEnabled(true);
    }//GEN-LAST:event_pane2selmanActionPerformed

    private void pane2selallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pane2selallActionPerformed
        // TODO add your handling code here:
        ctr=0;
         pane2selone.setEnabled(false);
        pane2selma.setEnabled(false);
    }//GEN-LAST:event_pane2selallActionPerformed

    private void pane3idselKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pane3idselKeyPressed
        // TODO add your handling code here:
        pane3apply.setEnabled(true);
    }//GEN-LAST:event_pane3idselKeyPressed

    private void pane3idselMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pane3idselMouseClicked
        // TODO add your handling code here:
        pane3apply.setEnabled(true);
    }//GEN-LAST:event_pane3idselMouseClicked

    private void pane3idselMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pane3idselMousePressed
        // TODO add your handling code here:
        pane3apply.setEnabled(true);
    }//GEN-LAST:event_pane3idselMousePressed

    private void pane2seloneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pane2seloneKeyPressed
        // TODO add your handling code here:
        pane2conf.setEnabled(true);
    }//GEN-LAST:event_pane2seloneKeyPressed

    private void pane2seloneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pane2seloneMouseClicked
        // TODO add your handling code here:
        pane2conf.setEnabled(true);
    }//GEN-LAST:event_pane2seloneMouseClicked

    private void pane2seloneMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pane2seloneMousePressed
        // TODO add your handling code here:
        pane2conf.setEnabled(true);
    }//GEN-LAST:event_pane2seloneMousePressed

    private void pane2selmaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pane2selmaKeyPressed
        // TODO add your handling code here:
        pane2conf.setEnabled(true);
    }//GEN-LAST:event_pane2selmaKeyPressed

    private void pane2selmaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pane2selmaMouseClicked
        // TODO add your handling code here:
        pane2conf.setEnabled(true);
    }//GEN-LAST:event_pane2selmaMouseClicked

    private void pane2selmaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pane2selmaMousePressed
        // TODO add your handling code here:
        pane2conf.setEnabled(true);
    }//GEN-LAST:event_pane2selmaMousePressed

    private void pane2selallKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pane2selallKeyPressed
        // TODO add your handling code here:
        pane2conf.setEnabled(true);
    }//GEN-LAST:event_pane2selallKeyPressed

    private void pane2selallMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pane2selallMouseClicked
        // TODO add your handling code here:
        pane2conf.setEnabled(true);
    }//GEN-LAST:event_pane2selallMouseClicked

    private void pane2selallMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pane2selallMousePressed
        // TODO add your handling code here:
        pane2conf.setEnabled(true);
    }//GEN-LAST:event_pane2selallMousePressed

    private void pane1sexmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pane1sexmActionPerformed
        // TODO add your handling code here:
        sex="MALE";
    }//GEN-LAST:event_pane1sexmActionPerformed

    private void pane3sexmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pane3sexmActionPerformed
        // TODO add your handling code here:
        sex2="MALE";
    }//GEN-LAST:event_pane3sexmActionPerformed

    private void pane1id0KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pane1id0KeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
       if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE)){
           evt.consume();
       }
     
    }//GEN-LAST:event_pane1id0KeyTyped

    private void pane1id1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pane1id1KeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
       if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE)){
           evt.consume();
       }
     
    }//GEN-LAST:event_pane1id1KeyTyped

    private void pane1id2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pane1id2KeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
       if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE)){
           evt.consume();
       }
      
    }//GEN-LAST:event_pane1id2KeyTyped

    private void pane1lastKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pane1lastKeyTyped
        // TODO add your handling code here:
             char c=evt.getKeyChar();
       if(!(Character.isAlphabetic(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE)){
           evt.consume();
       }
      
    }//GEN-LAST:event_pane1lastKeyTyped

    private void pane3firstKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pane3firstKeyTyped
        // TODO add your handling code here:
             char c=evt.getKeyChar();
       if(!(Character.isAlphabetic(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE)){
           evt.consume();
       }
    }//GEN-LAST:event_pane3firstKeyTyped

    private void pane3miKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pane3miKeyTyped
        // TODO add your handling code here:
            char c=evt.getKeyChar();
       if(!(Character.isAlphabetic(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE)){
           evt.consume();
       }
    }//GEN-LAST:event_pane3miKeyTyped

    private void pane3courseKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pane3courseKeyTyped
        // TODO add your handling code here:
            char c=evt.getKeyChar();
       if(!(Character.isAlphabetic(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE)){
           evt.consume();
       }
    }//GEN-LAST:event_pane3courseKeyTyped

    private void pane3profKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pane3profKeyTyped
        // TODO add your handling code here:
            char c=evt.getKeyChar();
       if(!(Character.isAlphabetic(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE)){
           evt.consume();
       }
    }//GEN-LAST:event_pane3profKeyTyped

    private void pane1firstKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pane1firstKeyTyped
        // TODO add your handling code here:
            char c=evt.getKeyChar();
       if(!(Character.isAlphabetic(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE)){
           evt.consume();
       }
    }//GEN-LAST:event_pane1firstKeyTyped

    private void pane1courseKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pane1courseKeyTyped
        // TODO add your handling code here:
            char c=evt.getKeyChar();
       if(!(Character.isAlphabetic(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE)){
           evt.consume();
       }
    }//GEN-LAST:event_pane1courseKeyTyped

    private void pane1profKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pane1profKeyTyped
        // TODO add your handling code here:
            char c=evt.getKeyChar();
       if(!(Character.isAlphabetic(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE)){
           evt.consume();
       }
    }//GEN-LAST:event_pane1profKeyTyped

    private void pane1subKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pane1subKeyTyped
        // TODO add your handling code here:
            char c=evt.getKeyChar();
       if(!(Character.isAlphabetic(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE)){
           evt.consume();
       }
    }//GEN-LAST:event_pane1subKeyTyped

    private void pane3lastKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pane3lastKeyTyped
        // TODO add your handling code here:
            char c=evt.getKeyChar();
       if(!(Character.isAlphabetic(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE)){
           evt.consume();
       }
    }//GEN-LAST:event_pane3lastKeyTyped

    private void pane3subKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pane3subKeyTyped
        // TODO add your handling code here:
            char c=evt.getKeyChar();
       if(!(Character.isAlphabetic(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE)){
           evt.consume();
       }
    }//GEN-LAST:event_pane3subKeyTyped

    private void pane3id0KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pane3id0KeyTyped
        // TODO add your handling code here:
         char c=evt.getKeyChar();
       if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE)){
           evt.consume();
       }
    }//GEN-LAST:event_pane3id0KeyTyped

    private void pane3id1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pane3id1KeyTyped
        // TODO add your handling code here:
         char c=evt.getKeyChar();
       if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE)){
           evt.consume();
       }
    }//GEN-LAST:event_pane3id1KeyTyped

    private void pane3id2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pane3id2KeyTyped
        // TODO add your handling code here:
         char c=evt.getKeyChar();
       if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE)){
           evt.consume();
       }
    }//GEN-LAST:event_pane3id2KeyTyped

    private void pane1miKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pane1miKeyTyped
        // TODO add your handling code here:
          char c=evt.getKeyChar();
       if(!(Character.isAlphabetic(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE)){
           evt.consume();
       }
    }//GEN-LAST:event_pane1miKeyTyped

    private void pane4allActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pane4allActionPerformed
        // TODO add your handling code here:
        
        pane4idview.setEnabled(false);
        pane4selpay.setEnabled(false);
        pane4selmem.setEnabled(false);
        
        
         try {
                loadall();
            } catch (SQLException ex) {
                // Logger.getLogger(frameRegister.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                //Logger.getLogger(frameRegister.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_pane4allActionPerformed

    private void pane4payActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pane4payActionPerformed
        // TODO add your handling code here:
        pane4seldata.setEnabled(false);
        pane4selpay.setEnabled(true);
        pane4idview.setEnabled(false);
        pane4selmem.setEnabled(false);
        
       
      
    }//GEN-LAST:event_pane4payActionPerformed

    private void pane4memActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pane4memActionPerformed
        // TODO add your handling code here:
        pane4selmem.setEnabled(true);
        pane4idview.setEnabled(false);
        pane4selpay.setEnabled(false);
        pane4seldata.setEnabled(false);
         
       
         
    }//GEN-LAST:event_pane4memActionPerformed

    private void pane4idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pane4idActionPerformed
        // TODO add your handling code here:
        pane4seldata.setEnabled(false);
        pane4idview.setEnabled(true);
        pane4selpay.setEnabled(false);
        pane4selmem.setEnabled(false);
   
         
          
    }//GEN-LAST:event_pane4idActionPerformed

    private void pane4selpayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pane4selpayActionPerformed
        // TODO add your handling code here:
        String pay= pane4selpay.getSelectedItem().toString();
          try {
                loadpay(pay);
            } catch (SQLException ex) {
                // Logger.getLogger(frameRegister.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                //Logger.getLogger(frameRegister.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_pane4selpayActionPerformed

    private void pane4selmemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pane4selmemActionPerformed
        // TODO add your handling code here:
         String mem= pane4selmem.getSelectedItem().toString();
          try {
                loadmem(mem);
            } catch (SQLException ex) {
                // Logger.getLogger(frameRegister.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                //Logger.getLogger(frameRegister.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_pane4selmemActionPerformed

    private void pane4idviewKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pane4idviewKeyTyped
        // TODO add your handling code here:
         String id= pane4idview.getText();
          try {
                loadid(id);
                
            } catch (SQLException ex) {
                // Logger.getLogger(frameRegister.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                //Logger.getLogger(frameRegister.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_pane4idviewKeyTyped

    private void pane4idview1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pane4idview1KeyTyped
        // TODO add your handling code here:
         String id= pane4idview1.getText();
          try {
                loadid1(id);
                
            } catch (SQLException ex) {
                // Logger.getLogger(frameRegister.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                //Logger.getLogger(frameRegister.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_pane4idview1KeyTyped

    private void pane4idview1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pane4idview1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pane4idview1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
         
         restrictions res = new restrictions(officerPosition, task);
        if(res.isRestricted()){
          stud.setEnabledAt(1, false);
            stud.setEnabledAt(3, false);
            stud.setEnabledAt(2, false);
            pane1reg.setEnabled(false);
        }
        else{
            if(fttmo.format(datee).equalsIgnoreCase("04")||fttmo.format(datee).equalsIgnoreCase("05")){
                 pane1reg.setEnabled(true);
            stud.setEnabledAt(1, false);
            stud.setEnabledAt(3, true);
            stud.setEnabledAt(2, true);
            }
            else{
             pane1reg.setEnabled(true);
            stud.setEnabledAt(1, true);
            stud.setEnabledAt(3, false);
            stud.setEnabledAt(2, true);   
            }
           
        }
        
           
    }//GEN-LAST:event_formWindowOpened

    private void pane1backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pane1backActionPerformed
        // TODO add your handling code here:
        MainMenu a = new MainMenu();
        a.setVisible(true);
        a.setOfficer(officerPosition);
        a.setOfficerID(officerID);
        Student.this.setVisible(false);
    }//GEN-LAST:event_pane1backActionPerformed

    private void pane1back1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pane1back1ActionPerformed
        // TODO add your handling code here:
         MainMenu a = new MainMenu();
        a.setVisible(true);
        a.setOfficerID(officerID);
        a.setOfficer(officerPosition);
        Student.this.setVisible(false);
    }//GEN-LAST:event_pane1back1ActionPerformed

    private void pane1back2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pane1back2ActionPerformed
        // TODO add your handling code here:
         MainMenu a = new MainMenu();
        a.setVisible(true);
        a.setOfficer(officerPosition);
        a.setOfficerID(officerID);
        Student.this.setVisible(false);
    }//GEN-LAST:event_pane1back2ActionPerformed

    private void pane1back3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pane1back3ActionPerformed
        // TODO add your handling code here:
         MainMenu a = new MainMenu();
        a.setVisible(true);
        a.setOfficer(officerPosition);
        a.setOfficerID(officerID);
        Student.this.setVisible(false);
    }//GEN-LAST:event_pane1back3ActionPerformed

    private void pane2notpaidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pane2notpaidActionPerformed
        // TODO add your handling code here:
        if(pane2notpaid.isSelected()){
         try {
                loadpay1("NOT PAID");
            } catch (SQLException ex) {
                // Logger.getLogger(frameRegister.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                //Logger.getLogger(frameRegister.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
              
    }//GEN-LAST:event_pane2notpaidActionPerformed

    private void pane2allActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pane2allActionPerformed
        // TODO add your handling code here:
            try {
                load();
            } catch (SQLException ex) {
                // Logger.getLogger(frameRegister.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                //Logger.getLogger(frameRegister.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_pane2allActionPerformed

    private void pane2paidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pane2paidActionPerformed
        // TODO add your handling code here:
            try {
                loadpay1("PAID");
            } catch (SQLException ex) {
                // Logger.getLogger(frameRegister.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                //Logger.getLogger(frameRegister.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_pane2paidActionPerformed

    private void pane4seldataKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pane4seldataKeyPressed
        // TODO add your handling code here:
        pane4del.setEnabled(true);
    }//GEN-LAST:event_pane4seldataKeyPressed

    private void pane4seldataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pane4seldataActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_pane4seldataActionPerformed

    private void pane4seldataMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pane4seldataMousePressed
        // TODO add your handling code here:
        pane4del.setEnabled(true);
    }//GEN-LAST:event_pane4seldataMousePressed

    private void pane4seldataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pane4seldataMouseClicked
        // TODO add your handling code here:
        pane4del.setEnabled(true);
    }//GEN-LAST:event_pane4seldataMouseClicked
    public void setOfficer(String officer){
        this.officerPosition = officer;
    }
    
    public void setOfficerID(String idnum){
        this.officerID = idnum;
    
    }
    /**
     * @param args the command line arguments
     */
    
    
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
////                Student vi=new Student();
////        StudentModel mo=new StudentModel();
////        StudentController co=new StudentController(vi,mo);
////        vi.setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup decview;
    private javax.swing.JScrollPane deldata;
    private javax.swing.JScrollPane eddata;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel pane1;
    private javax.swing.JButton pane1back;
    private javax.swing.JButton pane1back1;
    private javax.swing.JButton pane1back2;
    private javax.swing.JButton pane1back3;
    private javax.swing.JTextField pane1course;
    private javax.swing.JTextField pane1first;
    private javax.swing.JTextField pane1id0;
    private javax.swing.JTextField pane1id1;
    private javax.swing.JTextField pane1id2;
    private javax.swing.JTextField pane1last;
    private javax.swing.JTextField pane1mi;
    private javax.swing.JTextField pane1prof;
    private javax.swing.JButton pane1reg;
    private javax.swing.ButtonGroup pane1sex;
    private javax.swing.JRadioButton pane1sexf;
    private javax.swing.JRadioButton pane1sexm;
    private javax.swing.JTextField pane1sub;
    private javax.swing.JPanel pane2;
    private javax.swing.JRadioButton pane2all;
    private javax.swing.JButton pane2conf;
    private javax.swing.JRadioButton pane2notpaid;
    private javax.swing.JRadioButton pane2paid;
    private javax.swing.ButtonGroup pane2sel;
    private javax.swing.JRadioButton pane2selall;
    private javax.swing.JRadioButton pane2seleone;
    private javax.swing.JList pane2selma;
    private javax.swing.JRadioButton pane2selman;
    private javax.swing.JScrollPane pane2selmany;
    private javax.swing.JComboBox pane2selone;
    private javax.swing.JTable pane2studata;
    private javax.swing.JTable pane2studata1;
    private javax.swing.JTable pane2studata2;
    private javax.swing.JPanel pane3;
    private javax.swing.JButton pane3apply;
    private javax.swing.JTextField pane3course;
    private javax.swing.JButton pane3edit;
    private javax.swing.JTextField pane3first;
    private javax.swing.JTextField pane3id0;
    private javax.swing.JTextField pane3id1;
    private javax.swing.JTextField pane3id2;
    private javax.swing.JComboBox pane3idsel;
    private javax.swing.JTextField pane3last;
    private javax.swing.JTextField pane3mi;
    private javax.swing.JComboBox pane3paybox;
    private javax.swing.JTextField pane3prof;
    private javax.swing.ButtonGroup pane3sex;
    private javax.swing.JRadioButton pane3sexf;
    private javax.swing.JRadioButton pane3sexm;
    private javax.swing.JSpinner pane3spindate;
    private javax.swing.JTextField pane3sub;
    private javax.swing.JPanel pane4;
    private javax.swing.JRadioButton pane4all;
    private javax.swing.JButton pane4dec;
    private javax.swing.JButton pane4del;
    private javax.swing.JRadioButton pane4id;
    private javax.swing.JTextField pane4idview;
    private javax.swing.JTextField pane4idview1;
    private javax.swing.JRadioButton pane4mem;
    private javax.swing.JRadioButton pane4pay;
    private javax.swing.JComboBox pane4seldata;
    private javax.swing.JComboBox pane4selmem;
    private javax.swing.JComboBox pane4selpay;
    private javax.swing.JTable pane4studata;
    private javax.swing.JScrollPane payconfirm;
    private javax.swing.ButtonGroup paygp;
    private javax.swing.JScrollPane provdata;
    private javax.swing.JTabbedPane stud;
    // End of variables declaration//GEN-END:variables
}
