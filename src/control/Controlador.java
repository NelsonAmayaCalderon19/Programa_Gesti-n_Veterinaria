/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import vista.Vista;
import modelo.*;

/**
 *
 * @author NELSON
 */
public class Controlador implements ActionListener{
    private Vista vista = null;
    Dueño d = new Dueño();
    Mascota m = new Mascota();
    Servicio s = new Servicio();
    Vacuna v = new Vacuna();
//    Adicional a = new Adicional();
//    Pedido pe = new Pedido();
//    Cliente c = new Cliente();
//    Ingrediente i = new Ingrediente();
//    Bebida b = new Bebida();
    public Controlador(Vista vista) {
        super();
        this.vista = vista;
        actionListener(this);

        vista.jDateChooser1.setDate(new Date("01/01/2010"));
         vista.jTable1.setEnabled(false);
         vista.jTable1.setVisible(false);
//    vista.jButton6.setEnabled(false);
    vista.jButton5.setEnabled(false);
    vista.jTextField12.setEditable(false);
    vista.jTextField11.setEditable(false);
    vista.jTextField13.setEditable(false);
//        inhabilitarPedido();
//        inhabilitarIngredientes2();
//        inhabilitarIngredientes3();
//        vista.btn15.setEnabled(false);
//        vista.btn17.setEnabled(false);
//        vista.btn19.setEnabled(false);
//        vista.btnAct.setEnabled(false);
//        vista.jLabel16.setText("0");
//        vista.jLabel14.setText("0");
//        vista.jLabel27.setText("0");
//        vista.cb5.setEnabled(false);
//        vista.btn1.setEnabled(false);
    }
    
    private void actionListener(ActionListener Controlador) {
        vista.jButton1.addActionListener(Controlador);
        vista.jButton2.addActionListener(Controlador);
        vista.jButton3.addActionListener(Controlador);
        vista.jButton4.addActionListener(Controlador);
        vista.jButton5.addActionListener(Controlador);
//        vista.jButton6.addActionListener(Controlador);
        vista.jButton7.addActionListener(Controlador);
//        vista.jTable1.addActionListener(Controlador);
    }
//DefaultTableModel modelo = new DefaultTableModel();
//        int filaselec=vista.jTable1.getSelectedRow();
//    vista.jTextField12.setText(modelo.getValueAt(filaselec, 1).toString());
//    vista.jTextField11.setText(modelo.getValueAt(filaselec, 2).toString());
//    vista.jTextField13.setText(modelo.getValueAt(filaselec, 3).toString());
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
          if(e.getSource()==vista.jButton1){
              if (vista.jTextField1.getText().length() == 0) {
                    JOptionPane.showMessageDialog(null, "Debe Ingresar la Cedula del Cliente");
                    vista.jTextField1.requestFocus();
                } else if (vista.jTextField2.getText().length() == 0) {
                    JOptionPane.showMessageDialog(null, "Debe Ingresar el Nombre del Cliente");
                    vista.jTextField2.requestFocus();
                } else if (vista.jTextField5.getText().length() == 0) {
                    JOptionPane.showMessageDialog(null, "Debe Ingresar la Dirección del Cliente");
                    vista.jTextField5.requestFocus();
                } else if (vista.jTextField4.getText().length() == 0) {
                    JOptionPane.showMessageDialog(null, "Debe Ingresar el Telefono del Cliente");
                    vista.jTextField4.requestFocus();
                } else if(vista.jComboBox1.getSelectedIndex() == 0){
                JOptionPane.showMessageDialog(null, "Debe Seleccionar el Genero del Cliente");
                }
                else{
              int seleccionado = vista.jComboBox1.getSelectedIndex();
              
              d.registrarDueño(vista.jTextField1.getText(), vista.jTextField2.getText(), vista.jTextField5.getText(), vista.jTextField4.getText(), vista.jComboBox1.getItemAt(seleccionado));
          JOptionPane.showMessageDialog(null, "Cliente/Dueño Registrado Exitosamente");
          
           DefaultTableModel modelo = (DefaultTableModel) vista.jTable2.getModel();

                Object[] fila = new Object[5];               
                fila[0] = vista.jTextField1.getText();
                fila[1] = vista.jTextField2.getText();
                fila[2] = vista.jTextField5.getText();
                fila[3] = vista.jTextField4.getText();
                fila[4] = vista.jComboBox1.getItemAt(seleccionado);
                
                modelo.addRow(fila);
                vista.jTable2.setModel(modelo);
                }
          }if(e.getSource()==vista.jButton2){
          vista.jTextField1.setText("");
          vista.jTextField2.setText("");
          vista.jTextField5.setText("");
          vista.jTextField4.setText("");
          vista.jComboBox1.setSelectedIndex(0);
          
          }if(e.getSource()==vista.jButton3){
              if (vista.jTextField3.getText().length() == 0) {
                    JOptionPane.showMessageDialog(null, "Debe Ingresar el Nombre de la Mascota");
                    vista.jTextField3.requestFocus();
                } else if (vista.jTextField7.getText().length() == 0) {
                    JOptionPane.showMessageDialog(null, "Debe Ingresar la Cedula del Responsable de la Mascota");
                    vista.jTextField7.requestFocus();
                } else if (vista.jTextField8.getText().length() == 0) {
                    JOptionPane.showMessageDialog(null, "Debe Ingresar la Raza de la Mascota");
                    vista.jTextField8.requestFocus();
                } else if (vista.jTextField10.getText().length() == 0) {
                    JOptionPane.showMessageDialog(null, "Debe Ingresar el Peso de la Mascota");
                    vista.jTextField10.requestFocus();
                } else if(vista.jTextField9.getText().length() == 0){
                JOptionPane.showMessageDialog(null, "Debe Ingresar la Ultima Vacuna de la Mascota");
                vista.jTextField9.requestFocus();
                }
                else if(d.buscarDueño(vista.jTextField7.getText())!=null){
              
              
          Calendar calendario = GregorianCalendar.getInstance();
                    java.util.Date fecha = calendario.getTime();
                    SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd/MM/yyyy");
              m.registrarMascota(vista.jTextField3.getText(), formatoDeFecha.format(vista.jDateChooser1.getDate()), vista.jTextField7.getText(), vista.jTextField8.getText(), Double.parseDouble(vista.jTextField10.getText()), vista.jTextField9.getText());
          JOptionPane.showMessageDialog(null, "Mascota Registrada Exitosamente");
          
          DefaultTableModel modelo = (DefaultTableModel) vista.jTable3.getModel();

                Object[] fila = new Object[6];               
                fila[0] = vista.jTextField3.getText();
                fila[1] = formatoDeFecha.format(vista.jDateChooser1.getDate());
                fila[2] = vista.jTextField7.getText();
                fila[3] = vista.jTextField8.getText();
                fila[4] = vista.jTextField10.getText();
                fila[5] = vista.jTextField9.getText();
                modelo.addRow(fila);
                vista.jTable3.setModel(modelo);
              }else{
              JOptionPane.showMessageDialog(null, "No Existe un Cliente/Dueño con esa Cedula Registrado, Debe Registrarse");
              }
          }if(e.getSource()==vista.jButton4){
          vista.jTextField3.setText("");
          vista.jTextField7.setText("");
          vista.jTextField8.setText("");
          vista.jTextField9.setText("");
          vista.jTextField10.setText("");
          vista.jDateChooser1.setDate(new Date("01/01/2010"));
          
          
          }if(e.getSource()==vista.jButton7){
              if(vista.jTextField6.getText().length() == 0){
                JOptionPane.showMessageDialog(null, "Debe Ingresar la Cedula del Responsable de la Mascota");
                vista.jTextField6.requestFocus();
                }
              else if(m.buscarMascota(vista.jTextField6.getText())!=null){
       vista.jTable1.setEnabled(true);
       vista.jTable1.setVisible(true);
//       vista.jButton6.setEnabled(true);
//    vista.jButton5.setEnabled(true);
    vista.jButton7.setEnabled(false);
    
//if(vista.jTable1.getSelectedRow()==-1){
JOptionPane.showMessageDialog(null,"Seleccione 1 Servicio de la Tabla");
//}else{
//    DefaultTableModel modelo = new DefaultTableModel();
//        int filaselec=vista.jTable1.getSelectedRow();
//    vista.jTextField12.setText(modelo.getValueAt(filaselec, 1).toString());
//    vista.jTextField11.setText(modelo.getValueAt(filaselec, 2).toString());
//    vista.jTextField13.setText(modelo.getValueAt(filaselec, 3).toString());
//}
//    Integer hab=Integer.parseInt(modelo.getValueAt(filaselec, 2).toString());
    }else{
     JOptionPane.showMessageDialog(null, "No Existe una Mascota con esa Persona como Responsable, Debe Registrar Mascota");
             
    }
          }
//          s.registrarServicio(vista.jTextField6.getText(), vista.jTextField12.getText(), vista.jTextField11.getText(), Double.parseDouble(vista.jTextField13.getText()));
//          JOptionPane.showMessageDialog(null, "Servicio Registrado Exitosamente");
//          DefaultTableModel modelo = (DefaultTableModel) vista.jTable1.getModel();
//
//                Object[] fila = new Object[4];               
//                fila[0] = vista.jTextField6.getText();
//                fila[1] = vista.jTextField12.getText();
//                fila[2] = vista.jTextField11.getText();
//                fila[3] = vista.jTextField13.getText();
//                modelo.addRow(fila);
//                vista.jTable1.setModel(modelo);
if(e.getSource()==vista.jButton5){
    if(vista.jTable1.getSelectedRow()==-1){
JOptionPane.showMessageDialog(null,"Seleccione 1 Tratamiento de la Tabla");
}else{
     s.registrarServicio(vista.jTextField6.getText(), vista.jTextField12.getText(), vista.jTextField11.getText(), Double.parseDouble(vista.jTextField13.getText()));
          JOptionPane.showMessageDialog(null, "Servicio Registrado Exitosamente");
          DefaultTableModel modelo = (DefaultTableModel) vista.jTable4.getModel();

                Object[] fila = new Object[4];               
                fila[0] = vista.jTextField6.getText();
                fila[1] = vista.jTextField12.getText();
                fila[2] = vista.jTextField11.getText();
                fila[3] = vista.jTextField13.getText();
                modelo.addRow(fila);
                vista.jTable4.setModel(modelo);
//                vista.jButton6.setEnabled(false);
   vista.jButton5.setEnabled(false);
   vista.jTable1.setEnabled(false);
       vista.jTable1.setVisible(false);
       vista.jButton7.setEnabled(true);
       vista.jTextField12.setText("");
            vista.jTextField11.setText("");
            vista.jTextField13.setText("");
            vista.jTextField6.setText("");
       
    }
//if(vista.jTable1.getSelectedRow()==-1){
//JOptionPane.showMessageDialog(null,"Error Debe Seleccionar 1 Tratamiento de la Tabla","Error Fatal",JOptionPane.ERROR_MESSAGE);
//}else{
//    DefaultTableModel modelo = new DefaultTableModel();
//        int filaselec=vista.jTable1.getSelectedRow();
//    vista.jTextField12.setText(modelo.getValueAt(filaselec, 1).toString());
//    vista.jTextField11.setText(modelo.getValueAt(filaselec, 2).toString());
//    vista.jTextField13.setText(modelo.getValueAt(filaselec, 3).toString());
//}
// vista.jTable1.setEnabled(true);
//       vista.jButton6.setEnabled(true);
//    vista.jButton5.setEnabled(true);
//    vista.jButton7.setEnabled(false);
          
          }
            
        }catch(Exception ev){

            
        }
    }
}
              //AGREGAR DATOS A UNA TABLA
//          DefaultTableModel modelo = (DefaultTableModel) vista.tabla1.getModel();
//
//                Object[] fila = new Object[8];
//
//                
//                fila[0] = vista.t1.getText();
//                int seleccionado = vista.cb1.getSelectedIndex();
//
//                fila[1] = (String) vista.cb1.getItemAt(seleccionado);
//                fila[2] = vista.sp1.getValue();
//                fila[3] = vista.sp2.getValue();
//                seleccionado = vista.cb2.getSelectedIndex();
//                fila[4] = (String) vista.cb2.getItemAt(seleccionado);
//                seleccionado = vista.cb3.getSelectedIndex();
//                fila[5] = (String) vista.cb3.getItemAt(seleccionado);
//                fila[6] = vista.t20.getText();
//                fila[7] = "Iniciado";
//
//                modelo.addRow(fila);
//
//                vista.tabla1.setModel(modelo);


//VALIDAR UN CORREO ELECTRONICO
//Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
//                                            +"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
//        Matcher mather = pattern.matcher(txtUsuario.getText());
//        if(mather.find()==false){
//            JOptionPane.showConfirmDialog(rootPane, "Email Ingresado no Válido");
//            txtUsuario.setText("");
//            txtUsuario.requestFocus();
//            return;
//        }


//AGREGAR UNA FECHA A UN ARRAYLIST
//Calendar calendario = GregorianCalendar.getInstance();
//                    java.util.Date fecha = calendario.getTime();
//                    SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd/MM/yyyy");
//                    int seleccionado = vista.cb4.getSelectedIndex();
//
//                    c.registrarCliente(vista.t2.getText(), vista.t3.getText(), vista.t4.getText(), vista.t5.getText(), vista.t6.getText(), formatoDeFecha.format(vista.dc1.getDate()), (String) vista.cb4.getItemAt(seleccionado));
//                    JOptionPane.showMessageDialog(null, "Cliente Registrado Exitosamente");