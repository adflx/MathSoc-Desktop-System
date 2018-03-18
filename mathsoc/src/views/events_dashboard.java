
package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class events_dashboard extends javax.swing.JFrame {
    
    String officerPosition;
    final String task = "Events";
    String url;
    Connection connection;
    Statement st;
    PreparedStatement pst;
    ResultSet rs;
    public JPanel[] stack;
    public events_viewedit edit;
    JButton viewbutton,editbutton;
    public String[] number,title,date,endate,venue,descrip,details;
    public byte[][] image;
    public JLabel photodi=new JLabel();
    private ImageIcon format=null;
    String officerID;
    int size;
    
    public events_dashboard() {
        initComponents();
        groupButton1();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        paneru = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        titulooo = new javax.swing.JRadioButton();
        petsaaa = new javax.swing.JRadioButton();
        lugarrr = new javax.swing.JRadioButton();
        detalyeee = new javax.swing.JRadioButton();
        filterbox = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        even = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        btn_mainmenu = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setName("dashboard"); // NOI18N
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(java.awt.Color.RED);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane2.setAutoscrolls(true);
        jScrollPane2.setMinimumSize(new java.awt.Dimension(100, 100));

        paneru.setBackground(java.awt.Color.RED);
        paneru.setAutoscrolls(true);
        paneru.setMinimumSize(new java.awt.Dimension(550, 1000));
        paneru.setPreferredSize(new java.awt.Dimension(550, 200));

        javax.swing.GroupLayout paneruLayout = new javax.swing.GroupLayout(paneru);
        paneru.setLayout(paneruLayout);
        paneruLayout.setHorizontalGroup(
            paneruLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );
        paneruLayout.setVerticalGroup(
            paneruLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(paneru);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(308, -7, 576, 550));

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Courier New", 1, 12))); // NOI18N

        titulooo.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        titulooo.setText("Title");

        petsaaa.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        petsaaa.setText("Date");

        lugarrr.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        lugarrr.setText("Venue");

        detalyeee.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        detalyeee.setSelected(true);
        detalyeee.setText("Description");

        filterbox.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        filterbox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                filterboxKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel1.setText("SEARCH");

        even.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        even.setText("Event number");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(petsaaa)
                            .addComponent(detalyeee)
                            .addComponent(lugarrr)
                            .addComponent(titulooo)
                            .addComponent(filterbox, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(even)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jLabel1)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filterbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(even)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(titulooo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(petsaaa, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lugarrr)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(detalyeee)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 270, -1, 250));

        jLabel2.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("PLAN AN EVENT");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, -1, -1));

        btn_mainmenu.setBackground(new java.awt.Color(0, 51, 51));
        btn_mainmenu.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        btn_mainmenu.setForeground(new java.awt.Color(255, 255, 255));
        btn_mainmenu.setText("Back");
        btn_mainmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_mainmenuActionPerformed(evt);
            }
        });
        jPanel1.add(btn_mainmenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 150, 65));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/images/color20.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 550));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
     public void groupButton1() {

        ButtonGroup bg1 = new ButtonGroup();
        bg1.add(titulooo);
        bg1.add(petsaaa);
        bg1.add(lugarrr);
        bg1.add(detalyeee);
        bg1.add(even);
    }
     
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
    restrictions res = new restrictions(officerPosition, task);
        if(res.isRestricted()){
            jLabel2.setVisible(false);
        }
        else{
            jLabel2.setVisible(true);
        }
        paneru.setAutoscrolls(true);
        paneru.updateUI();
        getdata();
        
    }//GEN-LAST:event_formWindowOpened

    public void getdata(){
        int counter=0;
        
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            url="jdbc:mysql://localhost:3306/math";
            connection = (com.mysql.jdbc.Connection) DriverManager.getConnection(url, "root","");
            st=(com.mysql.jdbc.Statement) connection.createStatement();
            rs=st.executeQuery("SELECT COUNT(*) FROM events where status='"+"DONE"+"' or status='"+"UPCOMING"+"' ORDER BY event_num ASC");
            
            if(rs.next()){
                size=rs.getInt(1);
            }
            
            number = new String[size];
            title = new String[size];
            date = new String[size];
            endate = new String[size];
            venue = new String[size];
            descrip = new String[size];
            details = new String[size];
            stack=new JPanel[size];
      
            rs=st.executeQuery("SELECT * FROM events where status='"+"DONE"+"' or status='"+"UPCOMING"+"' ORDER BY event_num ASC");
            
            
        while(rs.next()){
                number[counter] = rs.getString("event_num");
                title[counter] = rs.getString("project_title");
                date[counter] = rs.getString("date");
                endate[counter] = rs.getString("enddate");
                venue[counter] = rs.getString("venue");
                descrip[counter] = rs.getString("event_description");
                details[counter] = rs.getString("event_details");
                createpanel(counter,number[counter],title[counter],date[counter],endate[counter],venue[counter],descrip[counter],details[counter]);
                counter++;    
            }
                 
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,ex);
             
            }catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null,ex);        
            }
       
    }
    public void filter(String s){
        int counter=0; 
        try{
            paneru.removeAll();
            paneru.updateUI();
            Class.forName("com.mysql.jdbc.Driver");
            url="jdbc:mysql://localhost:3306/math";
            connection = (com.mysql.jdbc.Connection) DriverManager.getConnection(url, "root","");
            st=(com.mysql.jdbc.Statement) connection.createStatement();
            if(even.isSelected()==true){
                rs=st.executeQuery("SELECT * FROM events where event_num like '%"+s+"%'");
            }
            else if(titulooo.isSelected()==true){
                rs=st.executeQuery("SELECT * FROM events where project_title like '%"+s+"%'");
            }
            else if(petsaaa.isSelected()==true){
                rs=st.executeQuery("SELECT * FROM events where date like '%"+s+"%'");
            }
            else if(lugarrr.isSelected()==true){
                rs=st.executeQuery("SELECT * FROM events where venue like '%"+s+"%'");
            }
            else if(detalyeee.isSelected()==true){
                rs=st.executeQuery("SELECT * FROM events where event_description like '%"+s+"%'");
            }
            else{
                rs=st.executeQuery("SELECT * FROM events");
            }
            
            while(rs.next()){
                number[counter] = rs.getString("event_num");
                title[counter] = rs.getString("project_title");
                date[counter] = rs.getString("date");
                endate[counter] = rs.getString("enddate");
                venue[counter] = rs.getString("venue");
                descrip[counter] = rs.getString("event_description");
                details[counter] = rs.getString("event_details");
                createpanel(counter,number[counter],title[counter],date[counter],endate[counter],venue[counter],descrip[counter],details[counter]);
                counter++;
            }
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex);
             
        }catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,ex);        
        }
    }
    
    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        events_dashboard.this.setVisible(false);
        events_create a = new events_create();
        a.setOfficer(officerPosition);
        a.setOfficerID(officerID);
        a.setVisible(true);
            // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseClicked

    private void btn_mainmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_mainmenuActionPerformed
        // TODO add your handling code here:
          MainMenu main = new MainMenu();
        events_dashboard.this.setVisible(false);
        main.setOfficer(this.officerPosition);
        main.setOfficerID(officerID);
        main.setVisible(true);
    }//GEN-LAST:event_btn_mainmenuActionPerformed

    private void filterboxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filterboxKeyReleased
        String search=filterbox.getText();
        filter(search);
    }//GEN-LAST:event_filterboxKeyReleased
    
    public void createpanel(int x, String y, String z, String a, String e,String b,String d, String c){
        int width=225;
        stack[x]=new JPanel();
        stack[x].setLayout(null);
        stack[x].setLocation(0,(width*x)+5);
        stack[x].setBorder(BorderFactory.createLineBorder(java.awt.Color.RED,5));
        stack[x].setSize(550, width);
        stack[x].setBackground(java.awt.Color.GREEN); 
        paneru.add(stack[x]);
        paneru.setPreferredSize(new Dimension(550,250+width*x));
        paneru.updateUI();
     
        JLabel numero = new JLabel();
        numero.setLocation(10, 10);
        numero.setSize(550,30);
        numero.setText("Event Number: "+y);
     
        JLabel titulo = new JLabel();
        titulo.setLocation(10, 30);
        titulo.setSize(550,30);
        titulo.setText("Project Title: "+z);
     
        JLabel petsa = new JLabel();
        petsa.setLocation(10, 50);
        petsa.setSize(1000,30);
        if(a.equals(e)){
            petsa.setText("Date: "+a);
        }
        else{
            petsa.setText("Date: "+a+" - "+e);
        }
     
        JLabel lugar = new JLabel();
        lugar.setLocation(10, 70);
        lugar.setSize(1000,30);
        lugar.setText("Venue: "+b);
        
        JTextArea desc = new JTextArea();
        desc.setBorder(null);
        desc.setBackground(Color.GREEN);
        desc.setLocation(10,100);
        desc.setLineWrap(true);
        desc.setWrapStyleWord(true);
        desc.setAutoscrolls(true);
        desc.setEditable(false);
        desc.setSize(420,75);
        desc.setText("Project Description: "+d);
    
        stack[x].add(numero);
        stack[x].add(titulo);
        stack[x].add(petsa);
        stack[x].add(lugar);
        stack[x].add(desc);
        stack[x].updateUI();        
     
        viewbutton = new JButton();
        viewbutton.setSize(200, 30);
        viewbutton.setLocation(150, 180);
        viewbutton.setText("View Narrative Report");
        viewbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                JFrame frame = new JFrame ();
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible (true);  
                frame.setBounds(300, 300, 700, 700);
                frame.getContentPane().setLayout(null);
                frame.setResizable(false);
                
                loadimage(x,y);
                
                JTextArea textField = new JTextArea();
                textField.setEditable(false);
                textField.setBackground(Color.WHITE);
                textField.setLineWrap(true);
                textField.setWrapStyleWord(true);
                textField.setText("Narrative Report: " +c);
                JScrollPane scroll = new JScrollPane(textField);
                
                if(photodi.getText().equals("No image available")){
                    textField.setLocation(10,0);
                    textField.setSize(672,500);
                    scroll.setBounds(10,0,672,660);
                }
                else{
                    textField.setLocation(10,300);
                    textField.setSize(672,200);
                    scroll.setBounds(10, 300, 672, 360);
                }
                
                
                                     
                frame.getContentPane().add(scroll);
                frame.getContentPane().add(photodi);
                frame.setLocationRelativeTo ( null );
            }
        });
       
        stack[x].add(viewbutton);
        stack[x].updateUI();
  
        editbutton = new JButton();
        editbutton.setSize(150, 30);
        editbutton.setLocation(370, 180);
        editbutton.setText("Edit Details");
      
        editbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent t){
                Date date = null;
                Date date1 = null;
                SimpleDateFormat format = new SimpleDateFormat("MMMM d, yyyy");
                
                
                    try {
                        date = format.parse(a);
                        date1 = format.parse(e);
                 //       JOptionPane.showMessageDialog(null,date);
                   //     JOptionPane.showMessageDialog(null,date1);
                    } catch (ParseException m) {
                    }
            
                
                      
                edit = new events_viewedit();
                edit.eventnum.setText(y);
                edit.z = y;
                edit.eventtitle.setText(z);
                edit.eventdate.setDate(date);
                edit.eventdate1.setDate(date1);
                edit.evedesc.setText(d);
                edit.eventvenue.setText(b);
                edit.eventdetails.setText(c);
                restrictions res = new restrictions(officerPosition, task);
                if(res.isRestricted())
                edit.setVisible(false);
                else{
                edit.setVisible(true);
                edit.setOfficer(officerPosition);
                edit.setOfficerID(officerID);
                }
            }
        });
        stack[x].add(editbutton);
        stack[x].updateUI();
   
    } 
    
    public void loadimage(int y, String z){
          photodi.setText("");
          photodi.setIcon(null);
          try{
            String sql="select * from images where event_num='"+z+"'";
            pst=connection.prepareStatement(sql);
            rs=pst.executeQuery();
            
            if(rs.next()){
                byte[]imagedata=rs.getBytes("image");
                format=new ImageIcon(imagedata);
                if(format==null){
                    photodi.setText("No image available");
                }
                photodi.setVisible(true);
                photodi.setSize(670, 300);
                photodi.setLocation(10,0);
                photodi.setBorder(BorderFactory.createLineBorder(java.awt.Color.RED,1));
                photodi.setIcon(format);
               photodi.setHorizontalAlignment(JLabel.CENTER);
            }
            else{
                photodi.setText("No image available");
            }
        }catch(NullPointerException e){
            JOptionPane.showMessageDialog(null, e);
        }
        catch(Exception e){
            e.printStackTrace();
        }
      
    }
 
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
            java.util.logging.Logger.getLogger(events_dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(events_dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(events_dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(events_dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new events_dashboard().setVisible(true);
            }
        });
        
      
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_mainmenu;
    private javax.swing.JRadioButton detalyeee;
    private javax.swing.JRadioButton even;
    private javax.swing.JTextField filterbox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton lugarrr;
    private javax.swing.JPanel paneru;
    private javax.swing.JRadioButton petsaaa;
    private javax.swing.JRadioButton titulooo;
    // End of variables declaration//GEN-END:variables
}
