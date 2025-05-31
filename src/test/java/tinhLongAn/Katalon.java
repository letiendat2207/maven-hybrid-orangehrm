package tinhLongAn;

public class Katalon extends KMSTechnology {
    // Pham vi ngoai class nhung trong cung package
    // Moi quan he ke thua

    public void showSoftwareName(){
        softwareName = "Katalon Automation";
        setSoftwareName();
    }

    public void showSoftwarePrice(){
        softwarePrice = "2000";
        setSoftwarePrice();
    }

    public void showSoftwareSize(){
        softwareSize = "10MB";
        setSoftwareSize();
    }

    // private access ko cho phep truy cap tu ben ngoai class du la ke thua hay khoi tao
//    public void showSoftwareNumbers(){
//        softwareNumbers = 1000;
//        setSoftwareNumbers();
//    }
}
