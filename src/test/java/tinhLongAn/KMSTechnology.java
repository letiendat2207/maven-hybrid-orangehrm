package tinhLongAn;

public class KMSTechnology {
    // Thuoc tinh
    public String softwareName;
    protected String softwarePrice;
    String softwareSize;
    private int softwareNumbers;

    // Phuong thuc
    public void setSoftwareName(){
        System.out.println(softwareName);
    }

    protected void setSoftwarePrice(){
        System.out.println(softwarePrice);
    }

    void setSoftwareSize(){

    }

    private void setSoftwareNumbers(){
        int softwareNumbers = 10;
    }
}
