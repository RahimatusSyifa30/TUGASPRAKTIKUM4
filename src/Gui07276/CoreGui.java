package Gui07276;
import Controller07276.AllObjectController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class CoreGui extends ComponentGui {
    JTable tabelmahasiswa = new JTable();
    JScrollPane spmahasiswa = new JScrollPane(tabelmahasiswa);
    JTextField textpilih = new JTextField();
    int kode;
    
    public CoreGui(){
        initComponent();
    }
    
    void initComponent(){
        setTitle("PROGRAM KURSUS");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,480);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        
        setLayout(null);
        setVisible(true);
        
        spmahasiswa.setBounds(20, 50, 500, 350);
        tabelmahasiswa.setModel(AllObjectController.kursus.daftarMahasiswa());
        add(spmahasiswa);
        
        btnverif.setBounds(540, 50, 110, 25);
        btnverif.setFocusPainted(false);
        btnverif.setBorder(null);
        btnverif.setBackground(Color.black);
        btnverif.setForeground(Color.white);
        add(btnverif);
        
        btndelete.setBounds(540, 95, 110, 25);
        btndelete.setFocusPainted(false);
        btndelete.setBorder(null);
        btndelete.setBackground(Color.black);
        btndelete.setForeground(Color.white);
        add(btndelete);
        
        
        btnregister.setText("REGIST");
        btnregister.setBounds(540, 140, 110, 25);
        btnregister.setFocusPainted(false);
        btnregister.setBorder(null);
        btnregister.setBackground(Color.black);
        btnregister.setForeground(Color.white);
        add(btnregister);
        
        
        btnrubah.setBounds(540, 180, 110, 25);
        btnrubah.setFocusPainted(false);
        btnrubah.setBorder(null);
        btnrubah.setBackground(Color.black);
        btnrubah.setForeground(Color.white);
        add(btnrubah);
        
        tabelmahasiswa.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                int i = tabelmahasiswa.getSelectedRow();
                textpilih.setText(AllObjectController.kursus.daftarMahasiswa().getValueAt(i,0).toString());
            }
        });
        
        btnverif.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                kode = Integer.parseInt(textpilih.getText());
                AllObjectController.kursus.verifMahasiswa(kode);
                JOptionPane.showMessageDialog(null, "Berhasil Verifikasi");
                tabelmahasiswa.setModel(AllObjectController.kursus.daftarMahasiswa());
            }
        });
        btnrubah.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                kode = Integer.parseInt(textpilih.getText());
                RubahGui rubahGui = new RubahGui(kode);
                rubahGui.setVisible(true);
                dispose();
            }
        });
        
        btndelete.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                kode = Integer.parseInt(textpilih.getText());
                AllObjectController.kursus.deleteData(kode);
                tabelmahasiswa.setModel(AllObjectController.kursus.daftarMahasiswa());
                JOptionPane.showMessageDialog(null, "Berhasil HAPUS DATA");
            }
        });
        
        btnregister.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                RegisterGui registerGui = new RegisterGui();
                registerGui.setVisible(true);
                dispose();
            }
        });
    } 
}
