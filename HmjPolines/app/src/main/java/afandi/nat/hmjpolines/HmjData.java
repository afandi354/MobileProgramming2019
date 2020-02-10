package afandi.nat.hmjpolines;

import java.util.ArrayList;

public class HmjData {

    public static String[][] data = new String[][]{
            {"0",
                    "HM Software Engineering",
                    "Himpunan Mahasiswa Software Engineering, berada pada Prodi S1 Rekayasa Perangkat Lunak, Fakultas Teknologi Industri dan Informatika, Institut Teknologi Telkom Purwokerto.",
                    "https://i.postimg.cc/hj2mN5HD/hmse.png"},
            {"1",
                    "HM Informatika",
                    "Himpunan Mahasiswa Informatika, berada pada Prodi S1 Informatika, Fakultas Teknologi Industri dan Informatika, Institut Teknologi Telkom Purwokerto.",
                    "https://i.postimg.cc/c42RsP66/hmif.png"},
            {"2",
                    "HM Sistem Informasi",
                    "Himpunan Mahasiswa Sistem Informasi, berada pada Prodi S1 Sistem Informasi, Fakultas Teknologi Industri dan Informatika, Institut Teknologi Telkom Purwokerto.",
                    "https://i.postimg.cc/MHXBwYSy/hmsi.png"},
            {"3",
                    "HM Teknik Industri",
                    "Himpunan Mahasiswa Teknik Industri, berada pada Prodi S1 Teknik Industri, Fakultas Teknologi Industri dan Informatika, Institut Teknologi Telkom Purwokerto.",
                    "https://i.postimg.cc/L5718Z9G/hmti.png"},
            {"4",
                    "HM Desain Komunikasi Visual",
                    "Himpunan Mahasiswa Desain Komunikasi Visual, berada pada Prodi S1 Desain Komunikasi Visual, Fakultas Teknologi Industri dan Informatika, Institut Teknologi Telkom Purwokerto.",
                    "https://i.postimg.cc/1XYpVjHC/hmdkv.png"}
    };

    public static ArrayList<Hmj> getListData(){
        ArrayList<Hmj> list = new ArrayList<>();
        for (String[] aData : data){
            Hmj hmj = new Hmj();
            hmj.setId(Integer.parseInt(aData[0]));
            hmj.setName(aData[1]);
            hmj.setDescription(aData[2]);
            hmj.setPhoto(aData[3]);

            list.add(hmj);
        }
        return list;
    }
}
