package afandi.nat.hm_ittp;

import java.util.ArrayList;

public class HmjData {

    public static String[][] data = new String[][] {
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
                    "Himpunan Mahasiswa Informatika, berada pada Prodi S1 Informatika, Fakultas Teknologi Industri dan Informatika, Institut Teknologi Telkom Purwokerto.",
                    "https://i.postimg.cc/c42RsP66/hmif.png"},
            {"3",
                    "HM Teknik Industri",
                    "Himpunan Mahasiswa Informatika, berada pada Prodi S1 Informatika, Fakultas Teknologi Industri dan Informatika, Institut Teknologi Telkom Purwokerto.",
                    "https://i.postimg.cc/c42RsP66/hmif.png"},
            {"4",
                    "HM Desain Komunikasi Visual",
                    "Himpunan Mahasiswa Informatika, berada pada Prodi S1 Informatika, Fakultas Teknologi Industri dan Informatika, Institut Teknologi Telkom Purwokerto.",
                    "https://i.postimg.cc/c42RsP66/hmif.png"}
    };

    public static ArrayList<Hmj> getListData(){
        ArrayList<Hmj> list = new ArrayList<>();
        for(String[] aData : data){
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
