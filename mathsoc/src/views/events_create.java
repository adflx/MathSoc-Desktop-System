
package views;

import com.toedter.calendar.JDateChooser;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.*;
import javax.swing.JLabel;

public class events_create extends javax.swing.JFrame {
    
    String url,output,rdate="",evennum, dateend;
    Date dateee;
    Connection connection;
    PreparedStatement pst;
    Statement st;
    ResultSet rs;
    String officerID, officerPosition;
   
   public events_create() {
        initComponents();
        groupradio();
       ((JTextField)prodate.getDateEditor().getUiComponent()).setEditable(false);
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        protitle = new javax.swing.JTextField();
        provenue = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        prodetails = new javax.swing.JTextArea();
        create = new javax.swing.JButton();
        backlabel = new javax.swing.JLabel();
        duepanel = new javax.swing.JPanel();
        daily = new javax.swing.JRadioButton();
        weekly = new javax.swing.JRadioButton();
        monthly = new javax.swing.JRadioButton();
        yearly = new javax.swing.JRadioButton();
        specific = new javax.swing.JRadioButton();
        sameday = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        prodesc = new javax.swing.JTextArea();
        imagee = new javax.swing.JPanel();
        imeji = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        prodate = new com.toedter.calendar.JDateChooser();
        clearall = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel1.setText("Project Title:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 113, -1, -1));

        jLabel2.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel2.setText("Venue:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 163, -1, -1));

        jLabel3.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel3.setText("Date:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 221, -1, 10));

        jLabel4.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel4.setText("Narrative Report:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, -1, -1));

        protitle.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        protitle.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(protitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(236, 105, 610, -1));

        provenue.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        provenue.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(provenue, new org.netbeans.lib.awtextra.AbsoluteConstraints(236, 156, 610, -1));

        prodetails.setColumns(10);
        prodetails.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        prodetails.setLineWrap(true);
        prodetails.setRows(5);
        prodetails.setWrapStyleWord(true);
        jScrollPane1.setViewportView(prodetails);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(236, 420, 610, 130));

        create.setBackground(new java.awt.Color(0, 51, 51));
        create.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        create.setForeground(new java.awt.Color(255, 255, 255));
        create.setText("CREATE EVENT");
        create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createActionPerformed(evt);
            }
        });
        jPanel1.add(create, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 780, 200, 65));

        backlabel.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        backlabel.setText("Back to Dashboard");
        backlabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backlabelMouseClicked(evt);
            }
        });
        jPanel1.add(backlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 20, -1, -1));

        duepanel.setBackground(new java.awt.Color(255, 255, 204));
        duepanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)), "Duration", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Courier New", 1, 18))); // NOI18N

        daily.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        daily.setText("For days");
        daily.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dailyActionPerformed(evt);
            }
        });

        weekly.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        weekly.setText("For a week");
        weekly.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                weeklyActionPerformed(evt);
            }
        });

        monthly.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        monthly.setText("For a month");
        monthly.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthlyActionPerformed(evt);
            }
        });

        yearly.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        yearly.setText("For a year");
        yearly.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearlyActionPerformed(evt);
            }
        });

        specific.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        specific.setText("Specify period");
        specific.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                specificActionPerformed(evt);
            }
        });

        sameday.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        sameday.setSelected(true);
        sameday.setText("Within the same day");
        sameday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                samedayActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout duepanelLayout = new javax.swing.GroupLayout(duepanel);
        duepanel.setLayout(duepanelLayout);
        duepanelLayout.setHorizontalGroup(
            duepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(duepanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(duepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(duepanelLayout.createSequentialGroup()
                        .addComponent(sameday)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(duepanelLayout.createSequentialGroup()
                        .addGroup(duepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(weekly)
                            .addComponent(monthly)
                            .addComponent(daily)
                            .addComponent(specific)
                            .addComponent(yearly))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        duepanelLayout.setVerticalGroup(
            duepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(duepanelLayout.createSequentialGroup()
                .addComponent(sameday)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(daily, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(weekly, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(monthly)
                .addGap(6, 6, 6)
                .addComponent(yearly, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(specific)
                .addGap(6, 6, 6))
        );

        jPanel1.add(duepanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(586, 197, -1, 220));

        jLabel6.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel6.setText("Project Description:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 261, -1, -1));

        prodesc.setColumns(20);
        prodesc.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        prodesc.setRows(5);
        jScrollPane2.setViewportView(prodesc);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(236, 253, 338, 160));

        imagee.setBackground(new java.awt.Color(255, 204, 204));

        imeji.setBackground(new java.awt.Color(0, 51, 51));
        imeji.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        imeji.setForeground(new java.awt.Color(255, 255, 255));
        imeji.setText("ADD IMAGE");
        imeji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imejiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout imageeLayout = new javax.swing.GroupLayout(imagee);
        imagee.setLayout(imageeLayout);
        imageeLayout.setHorizontalGroup(
            imageeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, imageeLayout.createSequentialGroup()
                .addContainerGap(444, Short.MAX_VALUE)
                .addComponent(imeji, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        imageeLayout.setVerticalGroup(
            imageeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imageeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imeji, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(176, Short.MAX_VALUE))
        );

        jPanel1.add(imagee, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 560, 600, -1));

        jLabel5.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel5.setText("Thumbnail(optional):");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 550, 230, 50));

        prodate.setDateFormatString("MMMM dd, YYYY");
        prodate.setMinSelectableDate(new Date());
        jPanel1.add(prodate, new org.netbeans.lib.awtextra.AbsoluteConstraints(236, 207, 298, -1));

        clearall.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        clearall.setText("CLEAR ALL");
        clearall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearallActionPerformed(evt);
            }
        });
        jPanel1.add(clearall, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/images/color20.png"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 860));

        jScrollPane3.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 912, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void groupradio(){
        ButtonGroup bgdue = new ButtonGroup();
        bgdue.add(sameday);
        bgdue.add(daily);
        bgdue.add(weekly);
        bgdue.add(monthly);
        bgdue.add(yearly);
        bgdue.add(specific);
    }
    private void createActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createActionPerformed
       int answer;
        answer = JOptionPane.showConfirmDialog(null, "Are you sure you want to record this event?","System Message",JOptionPane.YES_NO_OPTION);
        if(answer==JOptionPane.YES_OPTION){
         
           if((prodesc.getText().equals("")) || (protitle.getText().equals("")) || (prodate.getDate()==null)|| (numdaily.getText().equals("0")) || (numdaily.getText().equals(""))){
                JOptionPane.showMessageDialog(null, "Every field is required!","System Message",JOptionPane.ERROR_MESSAGE);
            }
            else if (specific.isSelected()==true && dateee==null){
                JOptionPane.showMessageDialog(null,"Date not specified!");
            }
            else if(specific.isSelected()==true && dateee.before(prodate.getDate())==true){
                JOptionPane.showMessageDialog(null,"Date not properly entered!");
            }
            else if(prodetails.getText().equals("")){
                prodetails.setText("Narrative Report to follow.");
            }
    
        else
        {
                getendDate();
                JOptionPane.showMessageDialog(null,rdate);
                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    url="jdbc:mysql://localhost:3306/math";
                    connection = (com.mysql.jdbc.Connection) DriverManager.getConnection(url, "root","");
                    st=(com.mysql.jdbc.Statement) connection.createStatement();
                    rs=st.executeQuery("SELECT * FROM events");
                    rs.last();
                    evennum = rs.getString("event_num");
                    createnum(evennum);
                    JOptionPane.showMessageDialog(null,evennum);

                    st.executeUpdate("INSERT INTO `events`(`event_num`, `project_title`, `date`, `enddate`,`venue`,`event_description`, `event_details`, `status`)"
                    + "VALUES ('"+evennum+"','"+protitle.getText()+"','"+rdate+"','"+output+"','"+provenue.getText()+"','"+prodesc.getText()+"','"+prodetails.getText()+"','"+"UPCOMING"+"')");
                        
                    JOptionPane.showMessageDialog(null, "Event successfully created!\n"+"Event Number = "+evennum,"System Message",JOptionPane.INFORMATION_MESSAGE);
                   
                    this.setVisible(false);
                    new events_dashboard().setVisible(true);

                } catch (SQLException | ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(null,ex);
             
                }
        
              if(person_image!=null){
                    
                        saveimage(evennum);
                    }
                        
                
            
            this.setVisible(false);
            events_dashboard a = new events_dashboard();
            a.setOfficer(officerPosition);
            a.setOfficerID(officerID);
            a.setVisible(true);
            
        }
    } 
            
    }//GEN-LAST:event_createActionPerformed

    private void createnum(String eveno){
        int evnum;
        String nunum;
        int month = Integer.parseInt(new SimpleDateFormat("M").format(prodate.getDate()));
        int yearla = Integer.parseInt(new SimpleDateFormat("yyyy").format(prodate.getDate()));
       
        String[] parts = eveno.split("-");
            String year = parts[0]; 
            String number = parts[1];
                
            int newnum = Integer.parseInt(number)+1;
            if(String.valueOf(newnum).length()==2){
                nunum="0"+newnum;
            }
            else{
                nunum="00"+newnum;
            }
             
             
            if(month<4){
                evnum=yearla-1;
                
                if(evnum==Integer.parseInt(year)){
                    evennum=String.valueOf(evnum)+"-"+nunum;
                }
                else{
                    evennum=String.valueOf(evnum)+"-001";
                }
            }
            else{
               evnum=yearla;
               if(evnum==Integer.parseInt(year)){
                    evennum=String.valueOf(evnum)+"-"+nunum;
                }
                else{
                    evennum=String.valueOf(evnum)+"-001";
                }
            }
              
    }
    
    private void saveimage(String evnum){
        try{
             
            String sql = "INSERT INTO images(event_num,image,batch_num) values (?,?,?)";
            pst = connection.prepareStatement(sql);
            pst.setString(1,String.valueOf(evnum));
            pst.setBytes(2,person_image);
            pst.executeUpdate();
            
                //JOptionPane.showMessageDialog(null, "YHEY!","System Message",JOptionPane.INFORMATION_MESSAGE);
            }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "ERROR!","System Message",JOptionPane.INFORMATION_MESSAGE);
        }
           
    }
    
    private void getendDate(){
        rdate = new SimpleDateFormat("MMMM dd, yyyy").format(prodate.getDate());
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd, yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(prodate.getDate());
        if(sameday.isSelected()==true){
            rdate=rdate;
        }
        else if(daily.isSelected()==true){
            c.add(Calendar.DATE, Integer.parseInt(numdaily.getText()));
                output = sdf.format(c.getTime());
        }
        else if(weekly.isSelected()==true){
            c.add(Calendar.DATE, Integer.parseInt(numdaily.getText())*7);
                output = sdf.format(c.getTime());
        }
        else if(monthly.isSelected()==true){
            c.add(Calendar.MONTH, Integer.parseInt(numdaily.getText()));
            output = sdf.format(c.getTime());
        }
        else if(yearly.isSelected()==true){
            c.add(Calendar.YEAR, Integer.parseInt(numdaily.getText()));
                output = sdf.format(c.getTime());
        }
       else if(specific.isSelected()==true){
            output = dateend;
        }
       
        //JOptionPane.showMessageDialog(null,date);
        
    }
    
    
    
    private void backlabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backlabelMouseClicked
        events_create.this.setVisible(false);
        events_dashboard a = new events_dashboard();
        a.setOfficerID(officerID);
        a.setOfficer(officerPosition);
        a.setVisible(true);
    }//GEN-LAST:event_backlabelMouseClicked

    private void weeklyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_weeklyActionPerformed
        removecom();
        numdays.setText("Enter number of weeks: ");
        createcom();
        duepanel.updateUI();
    }//GEN-LAST:event_weeklyActionPerformed

    private void dailyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dailyActionPerformed
        removecom();
        numdays.setText("Enter number of days: ");
        createcom();
        duepanel.updateUI();
    }//GEN-LAST:event_dailyActionPerformed

    private void monthlyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthlyActionPerformed
        
        removecom();
        numdays.setText("Enter number of months: ");
        createcom();
        duepanel.updateUI();
        
    }//GEN-LAST:event_monthlyActionPerformed

    private void yearlyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearlyActionPerformed
       
        removecom();
        numdays.setText("Enter number of years: ");
        createcom();
        duepanel.updateUI();
    }//GEN-LAST:event_yearlyActionPerformed

    private void specificActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_specificActionPerformed
       
        removecom();
        numdays.setText("Enter Date: ");
        numdaily.setText("1");
        numdays.setLocation(30,150);
        numdays.setSize(180,30);
        
        sel.setLocation(100,150);
        sel.setSize(170,30);
        sel.setMinSelectableDate(prodate.getDate());
        sel.setDateFormatString("MMMM dd, YYYY");
        sel.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
        public void propertyChange(PropertyChangeEvent e) {
            if ("date".equals(e.getPropertyName())) {
                //JOptionPane.showMessageDialog(null, (Date) e.getNewValue());
                dateee = (Date) e.getNewValue();
                dateend = new SimpleDateFormat("MMMM dd, yyyy").format(dateee);
                //JOptionPane.showMessageDialog(null,dateend);
            }
        }
    });
        
        duepanel.add(sel);
        duepanel.add(numdays);
        duepanel.updateUI();
    }//GEN-LAST:event_specificActionPerformed

    private void samedayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_samedayActionPerformed
        numdaily.setText("1");
        duepanel.updateUI();
        
    }//GEN-LAST:event_samedayActionPerformed

    private void imejiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imejiActionPerformed
        int width = 200;
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        
        filename = f.getAbsolutePath();
        if(filename == null){
            JOptionPane.showMessageDialog(null, "No image selected!");
        }
        else{
        JTextField filenam = new JTextField();
        filenam.setSize(200, 50);
        filenam.setLocation(10,20);
        filenam.setText(filename);
        
        imejis.setSize(100,100);
        imejis.setLocation(10, 50);
        ImageIcon icon=new ImageIcon(filename);
        imejis.setIcon(icon);
        imagee.add(filenam);
        imagee.add(imejis);
        imagee.updateUI();
        
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

    private void prodatePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_prodatePropertyChange
        if ("date".equals(evt.getPropertyName())) {
                Date stadate = (Date) evt.getNewValue();
                String stadatee = new SimpleDateFormat("MMMM dd, yyyy").format(stadate);
                //JOptionPane.showMessageDialog(null,stadate);
                sel.setMinSelectableDate(stadate);
            }
    }//GEN-LAST:event_prodatePropertyChange

    private void clearallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearallActionPerformed
        protitle.setText("");
        provenue.setText("");
        prodesc.setText("");
        prodetails.setText("");
        imejis.setIcon(null);        // TODO add your handling code here:
    }//GEN-LAST:event_clearallActionPerformed

    
    public void removecom(){
        duepanel.remove(numdaily);
        duepanel.remove(numdays);
        duepanel.remove(sel);
        duepanel.updateUI();
    }
    
    public void createcom(){
        numdays.setLocation(30,150);
        numdays.setSize(180,30);
        
        numdaily.setLocation(170,150);
        numdaily.setSize(100,30);
        
        duepanel.add(numdays);
        duepanel.add(numdaily);
        duepanel.updateUI();
    }
    
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
            java.util.logging.Logger.getLogger(events_create.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(events_create.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(events_create.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(events_create.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new events_create().setVisible(true);
            }
        });
    }
    JLabel imejis = new JLabel();
    private ImageIcon format=null;
    String filename=null;
    int s=0;
    byte[] person_image =null;
    JDateChooser sel = new JDateChooser();
    JLabel numdays = new JLabel();
    JTextField numdaily = new JTextField();
    JButton entbutton = new JButton();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backlabel;
    private javax.swing.JButton clearall;
    private javax.swing.JButton create;
    private javax.swing.JRadioButton daily;
    private javax.swing.JPanel duepanel;
    private javax.swing.JPanel imagee;
    private javax.swing.JButton imeji;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JRadioButton monthly;
    private com.toedter.calendar.JDateChooser prodate;
    private javax.swing.JTextArea prodesc;
    private javax.swing.JTextArea prodetails;
    private javax.swing.JTextField protitle;
    private javax.swing.JTextField provenue;
    private javax.swing.JRadioButton sameday;
    private javax.swing.JRadioButton specific;
    private javax.swing.JRadioButton weekly;
    private javax.swing.JRadioButton yearly;
    // End of variables declaration//GEN-END:variables
}
