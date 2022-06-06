package com.sinarJaya;

public class databaseToko {

    private String merek = "a";
    private String kategori = "a"; 
    private int stok = 0; 
    private double harga = 0;
    private String jenis = "a";

    public databaseToko(){}
    public databaseToko(String merek, String kategori, int stok, double harga, String jenis){
        this.merek = merek;
        this.kategori = kategori;
        this.stok = stok;
        this.harga = harga;
        this.jenis = jenis;
    }
    
    public String getMerek() {
        return merek;
    }
    public String getKategori() {
        return kategori;
    }
    public int getStok() {
        return stok;
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
    public void setStok(int stok) {
        this.stok = stok;
    }
    public void setHarga(double harga) {
        this.harga = harga;
    }
    public void setJenis(String jenis) {
        this.jenis = jenis;
    }
    
    @Override
    public String toString() {
        return "Merek : "+merek+"\nKategori : "+kategori+"\nStok : "+stok+"\nHarga : $ "+harga+"\nJenis : "+jenis+"\n";
    }
}
