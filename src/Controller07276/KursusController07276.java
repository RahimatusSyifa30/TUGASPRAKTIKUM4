package Controller07276;
import Entity07276.MahasiswaEntity;
import Model07276.AllObjectModel;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class KursusController07276 implements ControllerInterfaces07276 {
   public void insertData(String nama,String npm, String password, String no_telp){
        MahasiswaEntity mahasiswaEntities = new MahasiswaEntity();
        mahasiswaEntities.setNama(nama);
        mahasiswaEntities.setNpm(npm);
        mahasiswaEntities.setPassword(password);
        mahasiswaEntities.setNoTelp(no_telp);
        AllObjectModel.kursusmodel.createData(mahasiswaEntities);
    }
    public ArrayList<MahasiswaEntity> getDataMahasiswa(){
        return AllObjectModel.kursusmodel.getMahasiswa();
    }
    
    public ArrayList<MahasiswaEntity> getById(int cek){
        return AllObjectModel.kursusmodel.getMahasiswa(cek);
    }
   
    public void verifMahasiswa(int id){
        AllObjectModel.kursusmodel.verifMahasiswa(id);
    }
    public void deleteData(int id){
        AllObjectModel.kursusmodel.deleteMahasiswa(id);
    }
    public int verif(int id){
        int cek = AllObjectModel.kursusmodel.cekVerif(id);
        return cek;
    }
    
    public void updateData(int urut, String data, int id){
        switch(urut){
            case 1:
                AllObjectModel.kursusmodel.updateNama(data, id);
                break;
            case 2:
                AllObjectModel.kursusmodel.updateNpm(data, id);
                break;
            case 3:
                AllObjectModel.kursusmodel.updatePassword(data, id);
                break;
            case 4:
                 AllObjectModel.kursusmodel.updateNoTelp(data, id);
                break;
            
        }
    }
    
    public DefaultTableModel daftarMahasiswa(){
        DefaultTableModel dataDaftarMahasiswa = new DefaultTableModel();
        Object[] kolom = {"ID","NPM","NAMA","NOTELP","STATUS"};
        dataDaftarMahasiswa.setColumnIdentifiers(kolom);
        int size = getDataMahasiswa().size();
        for(int i = 0; i < size; i++ ){
            Object[] data = new Object[5];
            data[0] = AllObjectModel.kursusmodel.getMahasiswa().get(i).getId();
            data[1] = AllObjectModel.kursusmodel.getMahasiswa().get(i).getNpm();
            data[2] = AllObjectModel.kursusmodel.getMahasiswa().get(i).getNama();
            data[3] = AllObjectModel.kursusmodel.getMahasiswa().get(i).getNoTelp();
            data[4] = AllObjectModel.kursusmodel.getMahasiswa().get(i).getStatus();
            dataDaftarMahasiswa.addRow(data);
        }
        return dataDaftarMahasiswa;
    }
}
