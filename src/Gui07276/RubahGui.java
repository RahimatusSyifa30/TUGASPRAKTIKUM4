/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui07276;
import Entity07276.MahasiswaEntity;
import Controller07276.AllObjectController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RubahGui extends ComponentGui {
    int id;
    int status;
    String nama,npm, password, notelp;
   
    public RubahGui(int cek){
        initComponent(cek);
    }
    void initComponent(final int cek){
        for(MahasiswaEntity mahasiswaEntities : AllObjectController.kursus.getById(cek)) {
            this.id       = mahasiswaEntities.getId();
            this.nama     = mahasiswaEntities.getNama();
            this.npm      = mahasiswaEntities.getNpm();
            this.password = mahasiswaEntities.getPassword();
            this.notelp   = mahasiswaEntities.getNoTelp();
            this.status   = mahasiswaEntities.getStatus();
        }
        
        setTitle("EDIT DATA KURSUS");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(380,380);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
        
        btnback.setBounds(25, 20, 80, 25);
        btnback.setBackground(Color.white);
        btnback.setFocusPainted(false);
        btnback.setBorder(null);
        add(btnback);
        
        labelnama.setBounds(25, 50, 40, 25);
        add(labelnama);
        fieldnama.setBounds(120, 50, 100, 25);
        fieldnama.setText(nama);
        fieldnama.setEditable(false);
        add(fieldnama);
        
        labelnpm.setBounds(25,90, 40, 25);
        add(labelnpm);
        fieldnpm.setBounds(120, 90, 100, 25);
        fieldnpm.setText(npm);
        fieldnpm.setEditable(false);
        add(fieldnpm);
        
        labelpassword.setBounds(25, 135, 80, 25);
        add(labelpassword);
        fieldpassword.setBounds(120, 135, 100, 25);
        fieldpassword.setText(password);
        fieldpassword.setEditable(false);
        add(fieldpassword);
        
        labelnotelp.setBounds(25, 180, 80, 25);
        add(labelnotelp);
        fieldnotelp.setBounds(120, 180, 100, 25);
        fieldnotelp.setText(notelp);
        fieldnotelp.setEditable(false);
        add(fieldnotelp);
      
        btnubahnama.setBounds(245, 50, 80, 25);
        btnubahnpm.setBounds(245, 90, 80, 25);
        btnubahpassword.setBounds(245, 135, 80, 25);
        btnubahnotelp.setBounds(245, 180, 80, 25);
        add(btnubahnama);
        add(btnubahnpm);
        add(btnubahpassword);
        add(btnubahnotelp);
      
        btnback.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                btnback.setForeground(Color.yellow);
            }
            @Override
            public void mouseExited(MouseEvent e){
                btnback.setForeground(Color.black);
            }});
        
        btnback.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                CoreGui Gui = new CoreGui();
                Gui.setVisible(true);
                dispose();
            }
        });
        
        btnubahnama.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    String inputnama = JOptionPane.showInputDialog("Masukkan Nama Baru");
                    if(inputnama.length() > 0){
                        AllObjectController.kursus.updateData(1, inputnama, cek);
                        fieldnama.setText(inputnama);
                    } else {
                        JOptionPane.showMessageDialog(null, "Data Kosong");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Cancelled");
                }
            }
        });
        btnubahnpm.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    String inputnpm = JOptionPane.showInputDialog("Masukkan Npm Baru");
                    if(inputnpm.length() > 0){
                        AllObjectController.kursus.updateData(2, inputnpm, cek);
                        fieldnpm.setText(inputnpm);
                    } else {
                        JOptionPane.showMessageDialog(null, "Data Kosong");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Cancelled");
                }
            }
        });
       
        btnubahpassword.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    String inputpass = JOptionPane.showInputDialog("Masukan Password Baru");
                    if(inputpass.length() > 0){
                        AllObjectController.kursus.updateData(3, inputpass, cek);
                        fieldpassword.setText(inputpass);
                    } else {
                        JOptionPane.showMessageDialog(null, "Data Kosong");
                    }
                } catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Cancelled");
                }
            }
        });
        
        btnubahnotelp.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    String inputNoTelp = JOptionPane.showInputDialog("Masukan Nomor Telepon Baru");
                    if(inputNoTelp.length() > 0){
                        AllObjectController.kursus.updateData(4, inputNoTelp, cek);
                        fieldnotelp.setText(inputNoTelp);
                    } else {
                        JOptionPane.showMessageDialog(null, "Data Kosong");
                    }
                } catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Cancelled");
                }
            }
        });
        
  }
}
        
        

