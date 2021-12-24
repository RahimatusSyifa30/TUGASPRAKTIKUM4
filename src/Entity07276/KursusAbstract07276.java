package Entity07276;

public abstract class KursusAbstract07276 {
    protected int id;
    protected String nama,password,noTelp;
   
    public KursusAbstract07276(){}
    public KursusAbstract07276(String nama,String password, String noTelp){
        this.nama = nama;
        this.password = password;
        this.noTelp = noTelp;
    }
    public int getId(){return id;}
    public String getNama() {return nama;}
    public String getPassword() {return password;}
    public String getNoTelp() {return noTelp;}
    
    public void setId(int id) {this.id = id;}
    public void setNama(String nama) {this.nama = nama;}
    public void setPassword(String password) {this.password = password;}
    public void setNoTelp(String noTelp) {this.noTelp = noTelp;}
}
