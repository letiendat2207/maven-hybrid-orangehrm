package javaSDET;

public class Topic_10 extends Topic_09 {
    // Bien toan cuc, pham vi toan cuc - pham vi class
    String address;

    public Topic_10(String name, String address) {  // Bien cuc bo, pham vi cuc bo - pham vi ham
        // dung super de goi qua constructor cua class cha
        // super luon dung dau trong constructor
        super(name);

        // dung this de bien dc lay den pham vi toan cuc
        // bien toan cuc address duoc gan bang bien address pham vi cuc bo
        this.address = address;
    }
}
