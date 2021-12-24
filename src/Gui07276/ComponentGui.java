package Gui07276;
import javax.swing.*;

public class ComponentGui extends JFrame {
    protected JButton btnregister = new JButton("REGISTRASI");
    protected JButton btndelete = new JButton("DELETE");
    protected JButton btnback = new JButton("<< BACK");
    protected JButton btnverif = new JButton("VERIF");
    protected JButton btnrubah = new JButton("RUBAH");
   
    protected JLabel labelregister = new JLabel("REGISTER");
    protected JLabel labelid = new JLabel("ID");
    protected JLabel labelnama = new JLabel("NAMA");
    protected JLabel labelnpm = new JLabel("NPM");
    protected JLabel labelpassword = new JLabel("PASSWORD");
    protected JLabel labelnotelp = new JLabel("NO TELP");
   
    protected JTextField fieldnama = new JTextField();
    protected JTextField fieldnpm= new JTextField();
    protected JPasswordField fieldpassword = new JPasswordField();
    protected JTextField fieldnotelp = new JTextField();

    protected JButton btnubahnama = new JButton("Ubah");
    protected JButton btnubahnpm = new JButton("Ubah");
    protected JButton btnubahpassword = new JButton("Ubah");
    protected JButton btnubahnotelp = new JButton("Ubah");
 
    void kosong(){
        fieldnama.setText(null);
        fieldnpm.setText(null);
        fieldpassword.setText(null);
        fieldnotelp.setText(null);
    }}

