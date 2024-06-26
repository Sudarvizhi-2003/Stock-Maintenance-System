/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import commonFinish.openPdf;
import static commonFinish.openPdf.openbyid;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import dao.ConnectionProvider;
import dao.StockUtils;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.*;
/**
 *
 * @author SAI
 */
public class ManageOrder extends javax.swing.JFrame {
    private int customerPK = 0;
    private int productPK = 0;
    private int finaltotalprice = 0;
    private String orderid = "";
    /**
     * Creates new form ManageOrder
     */
    public ManageOrder() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    private void clearProductFields(){
        productPK = 0;
        txtproductname.setText("");
        txtproductprice.setText("");
        txtproductdescription.setText("");
        txtorderquantity.setText("");
    }
    
    public String getUniqueId(String prefix){
        return prefix + System.nanoTime();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablecustomer = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableproduct = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablecart = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtcustomername = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtcustomermobile = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtcustomeremail = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtproductname = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtproductprice = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtproductdescription = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtorderquantity = new javax.swing.JTextField();
        btnaddtocart = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        lblfinaltotalprice = new javax.swing.JLabel();
        btnsaveorderdetails = new javax.swing.JButton();
        btnreset = new javax.swing.JButton();
        btnclose = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Mange Order");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(585, 24, 257, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Customer List");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 102, 99, -1));

        tablecustomer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Mobile Number", "Email"
            }
        ));
        tablecustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablecustomerMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablecustomer);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 125, 361, 202));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Product List");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 102, 96, -1));

        tableproduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Price", "Quantity", "Description", "Category ID", "Category Name"
            }
        ));
        tableproduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableproductMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableproduct);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 125, 409, 202));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Cart");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1129, 84, 31, -1));

        tablecart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "Name", "Quantity", "Price", "Description", "Sub Total"
            }
        ));
        tablecart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablecartMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tablecart);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(966, 125, 352, 202));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Selected Customer");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 397, 127, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Name");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 431, 64, -1));

        txtcustomername.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(txtcustomername, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 457, 361, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Mobile Number");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 497, -1, -1));

        txtcustomermobile.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(txtcustomermobile, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 523, 361, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Email");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 563, 55, -1));

        txtcustomeremail.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(txtcustomeremail, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 597, 361, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Selected Product");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 400, 121, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Product Name");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 430, 92, -1));

        txtproductname.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(txtproductname, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 457, 409, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Product Price");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 497, 100, -1));

        txtproductprice.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(txtproductprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 523, 409, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Product Description");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 563, -1, -1));

        txtproductdescription.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(txtproductdescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 597, 409, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Order Quantity");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 637, 99, -1));

        txtorderquantity.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(txtorderquantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 670, 409, -1));

        btnaddtocart.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnaddtocart.setText("Add to Cart");
        btnaddtocart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddtocartActionPerformed(evt);
            }
        });
        getContentPane().add(btnaddtocart, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 709, 409, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setText("Total Amount RS: ");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(1017, 391, -1, -1));

        lblfinaltotalprice.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblfinaltotalprice.setText("00000");
        getContentPane().add(lblfinaltotalprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(1193, 391, -1, -1));

        btnsaveorderdetails.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnsaveorderdetails.setText("Save Order Details");
        btnsaveorderdetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveorderdetailsActionPerformed(evt);
            }
        });
        getContentPane().add(btnsaveorderdetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(966, 456, 352, -1));

        btnreset.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnreset.setText("Reset");
        btnreset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnresetActionPerformed(evt);
            }
        });
        getContentPane().add(btnreset, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 530, 352, -1));

        btnclose.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnclose.setText("Close");
        btnclose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncloseActionPerformed(evt);
            }
        });
        getContentPane().add(btnclose, new org.netbeans.lib.awtextra.AbsoluteConstraints(966, 596, 352, -1));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Orders_background.png"))); // NOI18N
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        txtcustomername.setEditable(false);
        txtcustomermobile.setEditable(false);
        txtcustomeremail.setEditable(false);
        
        txtproductname.setEditable(false);
        txtproductprice.setEditable(false);
        txtproductdescription.setEditable(false);
        
        DefaultTableModel model = (DefaultTableModel) tablecustomer.getModel();
        DefaultTableModel productmodel = (DefaultTableModel) tableproduct.getModel();
        
        try{
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from customer");
            while(rs.next()){
                model.addRow(new Object[]{rs.getString("customer_pk"), rs.getString("name"), rs.getString("mobileNumber"), rs.getString("email")});
            }
            
            rs = st.executeQuery("select * from products inner join category on products.category_fk = category.category_pk");
            while(rs.next()){
                productmodel.addRow(new Object[]{rs.getString("product_pk"), rs.getString("name"), rs.getString("price"), rs.getString("quantity"), rs.getString("description"), rs.getString("category_fk"), rs.getString(1)});
                
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_formComponentShown

    private void btnresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnresetActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new ManageOrder().setVisible(true);
    }//GEN-LAST:event_btnresetActionPerformed

    private void btnsaveorderdetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveorderdetailsActionPerformed
        // TODO add your handling code here:
        if(finaltotalprice != 0 && !txtcustomername.getText().equals(" ")){
            orderid = getUniqueId("Bill-");
            
            DefaultTableModel dtm = (DefaultTableModel) tablecart.getModel();
            if(tablecart.getRowCount() != 0){
                for(int i=0; i<tablecart.getRowCount(); i++){
                    try{
                        Connection con = ConnectionProvider.getCon();
                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery("update products set quantity="+Integer.parseInt(dtm.getValueAt(i, 2).toString())+" where product_pk="+Integer.parseInt(dtm.getValueAt(i, 0).toString())+"");
                    }
                    catch(Exception e){
                        JOptionPane.showMessageDialog(null, e);
                    }
                }
            }
            try {
                SimpleDateFormat  myformat = new SimpleDateFormat("dd-mm-yyyy");
                Calendar cal = Calendar.getInstance();
                Connection con = ConnectionProvider.getCon();
                PreparedStatement pt = con.prepareStatement("insert into orderDetail (orderid, customer_fk, orderdate, totalpaid) values(?,?,?,?)");
                pt.setString(1, orderid);
                pt.setInt(2, customerPK);
                pt.setString(3, myformat.format(cal.getTime()));
                pt.setInt(4, finaltotalprice);
                pt.executeUpdate();
            } 
            catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            
            //Creating document
            com.itextpdf.text.Document doc = new com.itextpdf.text.Document();
            try{
                SimpleDateFormat  myformat = new SimpleDateFormat("dd-mm-yyyy");
                Calendar cal = Calendar.getInstance();
                PdfWriter.getInstance(doc, new FileOutputStream(StockUtils.billpath+""+orderid+".pdf"));
                doc.open();
                Paragraph projectname = new Paragraph("                                     Stock Maintenanace System\n");
                doc.add(projectname);
                Paragraph starline = new Paragraph("*****************************************************************************************\n");
                doc.add(starline);
                Paragraph details = new Paragraph("\tOrderID:  "+orderid+"\nDate:  "+myformat.format(cal.getTime())+"\nTotal Paid:  "+finaltotalprice);
                doc.add(details);
                doc.add(starline);
                PdfPTable tb1 = new PdfPTable(5);
                PdfPCell namecell = new PdfPCell(new Phrase("Name"));
                PdfPCell descriptioncell = new PdfPCell(new Phrase("Description"));
                PdfPCell pricecell = new PdfPCell(new Phrase("Price per unit"));
                PdfPCell quantitycell = new PdfPCell(new Phrase("Quantity"));
                PdfPCell subtotalpricecell = new PdfPCell(new Phrase("Sub Total Price"));
                
                BaseColor backgroundcolor = new BaseColor(255,204,51);
                namecell.setBackgroundColor(backgroundcolor);
                descriptioncell.setBackgroundColor(backgroundcolor);
                pricecell.setBackgroundColor(backgroundcolor);
                quantitycell.setBackgroundColor(backgroundcolor);
                subtotalpricecell.setBackgroundColor(backgroundcolor);
                
                tb1.addCell(namecell);
                tb1.addCell(descriptioncell);
                tb1.addCell(pricecell);
                tb1.addCell(quantitycell);
                tb1.addCell(subtotalpricecell);
                
                for(int i=0; i<tablecart.getRowCount(); i++){
                    tb1.addCell(tablecart.getValueAt(i, 1).toString());
                    tb1.addCell(tablecart.getValueAt(i, 4).toString());
                    tb1.addCell(tablecart.getValueAt(i, 3).toString());
                    tb1.addCell(tablecart.getValueAt(i, 2).toString());
                    tb1.addCell(tablecart.getValueAt(i, 5).toString());
                }
                
                doc.add(tb1);
                doc.add(starline);
                Paragraph thanksmessage = new Paragraph("Thank you. Please visit again.");
                doc.add(thanksmessage);
                openPdf.openbyid(orderid);
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
            doc.close();
            setVisible(false);
            new ManageOrder().setVisible(true);
        }
        else{
            JOptionPane.showMessageDialog(null, "Please add some product to the cart or select customer");
        }
    }//GEN-LAST:event_btnsaveorderdetailsActionPerformed

    private void btnaddtocartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddtocartActionPerformed
        // TODO add your handling code here:
        String noOfunits = txtorderquantity.getText();
        if(!noOfunits.equals(" ")){
            String productname = txtproductname.getText();
            String productdescription = txtproductdescription.getText();
            String productprice = txtproductprice.getText();
            
            int totalprice = Integer.parseInt(txtorderquantity.getText()) * Integer.parseInt(productprice);
            
            int checkstock = 0;
            int checkincart = 0;
            
            try{
                Connection con = ConnectionProvider.getCon();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select * from products where product_pk="+productPK+"");
                while(rs.next()){
                    if(rs.getInt("quantity") >= Integer.parseInt(noOfunits)){
                        checkstock = 1;
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Product out of stock. Only "+rs.getInt("quantity")+" left");
                    }
                }
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
            
            if(checkstock == 1){
                DefaultTableModel model = (DefaultTableModel) tablecart.getModel();
                if(tablecart.getRowCount() != 0){
                    for(int i=0; i<tablecart.getRowCount(); i++){
                        if(Integer.parseInt(model.getValueAt(i, 0).toString()) == productPK){
                            checkincart = 1;
                            JOptionPane.showMessageDialog(null, "Product already exists in cart");
                        }
                    }
                }
                if(checkincart == 0){
                    model.addRow(new Object[]{productPK, productname, noOfunits, productprice, productdescription, totalprice});
                    finaltotalprice = finaltotalprice + totalprice;
                    lblfinaltotalprice.setText(String.valueOf(finaltotalprice));
                    JOptionPane.showMessageDialog(null, "Product added successfully");
                }
                clearProductFields();
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "No of quantity and product field is required");
        }
    }//GEN-LAST:event_btnaddtocartActionPerformed

    private void tablecustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablecustomerMouseClicked
        // TODO add your handling code here:
        int index = tablecustomer.getSelectedRow();
        TableModel model = tablecustomer.getModel();
        String id = model.getValueAt(index, 0).toString();
        customerPK = Integer.parseInt(id);
        
        String name = model.getValueAt(index, 1).toString();
        txtcustomername.setText(name);
        
        String mobileno = model.getValueAt(index, 2).toString();
        txtcustomermobile.setText(mobileno);
        
        String email = model.getValueAt(index, 3).toString();
        txtcustomeremail.setText(email);
    }//GEN-LAST:event_tablecustomerMouseClicked

    private void tableproductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableproductMouseClicked
        // TODO add your handling code here:
        int index = tableproduct.getSelectedRow();
        TableModel model = tableproduct.getModel();
        String id = model.getValueAt(index, 0).toString();
        productPK = Integer.parseInt(id);
        
        String productname = model.getValueAt(index, 1).toString();
        txtproductname.setText(productname);
        
        String productprice = model.getValueAt(index, 2).toString();
        txtproductprice.setText(productprice);
        
        String productdescription = model.getValueAt(index, 4).toString();
        txtproductdescription.setText(productdescription);
    }//GEN-LAST:event_tableproductMouseClicked

    private void btncloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncloseActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_btncloseActionPerformed

    private void tablecartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablecartMouseClicked
        // TODO add your handling code here:
        int index = tablecart.getSelectedRow();
        int a = JOptionPane.showConfirmDialog(null, "Do you want to remove this product", "Select", JOptionPane.YES_NO_OPTION);
        if(a == 0){
            TableModel model = tablecart.getModel();
            String subtotal = model.getValueAt(index, 5).toString();
            finaltotalprice = finaltotalprice - Integer.parseInt(subtotal);
            lblfinaltotalprice.setText(String.valueOf(finaltotalprice));
            ((DefaultTableModel) tablecart.getModel()).removeRow(index);
        }
    }//GEN-LAST:event_tablecartMouseClicked

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
            java.util.logging.Logger.getLogger(ManageOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageOrder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnaddtocart;
    private javax.swing.JButton btnclose;
    private javax.swing.JButton btnreset;
    private javax.swing.JButton btnsaveorderdetails;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblfinaltotalprice;
    private javax.swing.JTable tablecart;
    private javax.swing.JTable tablecustomer;
    private javax.swing.JTable tableproduct;
    private javax.swing.JTextField txtcustomeremail;
    private javax.swing.JTextField txtcustomermobile;
    private javax.swing.JTextField txtcustomername;
    private javax.swing.JTextField txtorderquantity;
    private javax.swing.JTextField txtproductdescription;
    private javax.swing.JTextField txtproductname;
    private javax.swing.JTextField txtproductprice;
    // End of variables declaration//GEN-END:variables
}
