package tinhLongAn;

public class Axon {
    // Pham vi ngoai class nhung trong cung package
    // Bang cach khoi tao

    public void showSoftwareName(){
        KMSTechnology kms = new KMSTechnology();
        kms.softwareName = "Axon Electronic";
        kms.setSoftwareName();
    }

    public void showSoftwarePrice(){
        KMSTechnology kms = new KMSTechnology();
        kms.softwarePrice = "10000";
        kms.setSoftwarePrice();
    }

    public void showSoftwareSize(){
        KMSTechnology kms = new KMSTechnology();
        kms.softwareSize = "5MB";
        kms.setSoftwareSize();
    }

    // private access ko cho phep truy cap tu ben ngoai class du la ke thua hay khoi tao
//    public void showSoftwareNumbers(){
//        KMSTechnology kms = new KMSTechnology();
//        kms.softwareNumbers = 100;
//        kms.setSoftwareNumbers();
//    }

}
