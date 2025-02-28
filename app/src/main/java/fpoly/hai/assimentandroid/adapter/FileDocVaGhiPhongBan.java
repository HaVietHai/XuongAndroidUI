package fpoly.hai.assimentandroid.adapter;

import android.content.Context;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import fpoly.hai.assimentandroid.models.PhongBan;

public class FileDocVaGhiPhongBan {
    private Context context;

    public FileDocVaGhiPhongBan(Context context) {
        this.context = context;
    }
    public void fileGhi(ArrayList<PhongBan> phongBanArrayList, String fileName){
        File fileDir =  context.getFilesDir();
        File file = new File(fileDir,fileName);

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(phongBanArrayList);
            objectOutputStream.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList<PhongBan> fileDoc(String fileName){
        File fileDir = context.getFilesDir();
        File file = new File(fileDir,fileName);
        ArrayList<PhongBan> phongBanArrayList = null;

        try {

            if (file.exists()){
                FileInputStream fileInputStream = new FileInputStream(file);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                phongBanArrayList = (ArrayList<PhongBan>) objectInputStream.readObject();
                objectInputStream.close();
                return phongBanArrayList;
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return phongBanArrayList;
    }
}
