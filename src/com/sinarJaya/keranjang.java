package com.sinarJaya;

public class keranjang {

    private String merek = "a";
    private String kategori = "a"; 
    private int jumlah = 0; 
    private double harga = 0;
    private String jenis = "a";

    public keranjang(){}
    public keranjang(String merek, String kategori, int jumlah, double harga, String jenis){
        this.merek = merek;
        this.kategori = kategori;
        this.jumlah = jumlah;
        this.harga = harga;
        this.jenis = jenis;
    }
    
    public String getMerek() {
        return merek;
    }
    public String getKategori() {
        return kategori;
    }
    public int getJumlah() {
        return jumlah;
    }
    public double getHarga() {
        return harga;
    }
    public String getJenis() {
        return jenis;
    }

    public void setMerek(String merek) {
        this.merek = merek;
    }
    public void setKategori(String kategori) {
        this.kategori = kategori;
    }
    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }
    public void setHarga(double harga) {
        this.harga = harga;
    }
    public void setJenis(String jenis) {
        this.jenis = jenis;
    }
    
    @Override
    public String toString() {
        return "Merek : "+merek+"\nKategori : "+kategori+"\nJumlah : "+jumlah+"\nHarga : $ "+harga+"\nJenis : "+jenis+"\n";
    }
}


