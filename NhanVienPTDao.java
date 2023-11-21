package quanly;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class NhanVienPTDao {
	public void ghiFile(ArrayList<NhanVienPT> dsnvpt) {
        FileOutputStream fout = null;
        ObjectOutputStream oos = null;
        try {

 

            fout = new FileOutputStream("e:\\danhsachnhanvienpt.bin");
            oos = new ObjectOutputStream(fout);
            oos.writeObject(dsnvpt);

 

            System.out.println("đã ghi file xong!");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (fout != null) {
                try {
                    fout.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

 

            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
	public ArrayList<NhanVienPT> docFile(String filename) {

		 

        ArrayList<NhanVienPT> dsnvpt = new ArrayList<>();

 

        FileInputStream fin = null;
        ObjectInputStream ois = null;
        try {
            fin = new FileInputStream(filename);
            ois = new ObjectInputStream(fin);
            dsnvpt = (ArrayList<NhanVienPT>) ois.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (fin != null) {
                try {
                    fin.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

 

            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

 

        }
        return dsnvpt;
    }
 
	
}

