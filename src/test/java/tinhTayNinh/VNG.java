package tinhTayNinh;

import tinhLongAn.KMSTechnology;

public class VNG {
    // Pham vi ngoai class nhung khac package
    // Bang cach khoi tao

    public void showSoftwareName(){
        KMSTechnology kms = new KMSTechnology();
        kms.softwareName = "Zing MP3";
        kms.setSoftwareName();
    }

    // Ko the khoi tao tu thuoc tinh va phuong thuc protected ma khac package
//    public void showSoftwarePrice(){
//        KMSTechnology kms = new KMSTechnology();
//        kms.softwarePrice = "10000";
//        kms.setSoftwarePrice();
//    }

    // private access ko cho phep truy cap tu ben ngoai class du la ke thua hay khoi tao
//    public void showSoftwareNumbers(){
//        KMSTechnology kms = new KMSTechnology();
//        kms.softwareNumbers = 100;
//        kms.setSoftwareNumbers();
//    }
}
