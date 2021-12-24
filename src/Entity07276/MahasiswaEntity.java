package Entity07276;

public class MahasiswaEntity extends KursusAbstract07276 {
    private String npm;
    private int status;
    
    public MahasiswaEntity(){}
    public String getNpm(){
        return npm;
    }
    public int getStatus(){
        return status;
    }
    public void setNpm(String npm){
        this.npm=npm;
    }
    public void setStatus(int status){
        this.status = status;
    }
}
