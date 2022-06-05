package com.sinarJaya;

import java.util.*;

import javax.lang.model.util.ElementScanner6;


public class Main {

    static void wait(int ms)
    {
        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        ArrayList<databaseToko> dataToko = new ArrayList<>();
        ArrayList<keranjang> dataKeranjang = new ArrayList<>();

        dataToko.add(new databaseToko("Ibanez RG", "Gitar Elektrik", 2, 500.0, "Baru"));
        dataToko.add(new databaseToko("Fender Stratocaster", "Gitar Elektrik", 2, 450.0, "Baru"));
        dataToko.add(new databaseToko("Yamaha F-310", "Gitar Akustik", 5, 200.0, "Bekas"));

        double totalHarga=0;
        double hargaBarang =0;
        int jumlahBarang=0;
        double totalBelanja=0;
        int randomNumber;
        double d=0;
        double hargaJual=0;
        int exit = 0;
        while (exit != 1) {
            System.out.println("\t\tSelamat Datang \n\tdi Toko Alat Musik Sinar Jaya");
            System.out.println("1. Beli Alat Musik");
            System.out.println("2. Jual Alat Musik");
            System.out.println("3. Cek Keranjang");
            System.out.println("4. Checkout");
            System.out.println("5. Keluar");
            System.out.print("Masukkan pilihan : ");
            int pilihan = sc.nextInt();
            sc.nextLine();

            if (pilihan == 1) {
                pilihan=0;
                System.out.println("");
                for(int i=0; i<dataToko.size(); i++)
                {
                    System.out.println("Nomor. "+(i+1));
                    System.out.println(dataToko.get(i));
                }
                System.out.print("Pilih Barang yang ingin dibeli : ");
                int nomor = sc.nextInt();
                sc.nextLine();
                int newNomor = nomor-1;
                
                if(newNomor<=dataToko.size())
                {
                    if(dataToko.get(newNomor).getStok()!=0)
                    {
                        System.out.println();
                        dataToko.get(newNomor).setStok(dataToko.get(newNomor).getStok()-1);
                        System.out.println("Barang sukses masuk ke keranjang!");
                        String merekGitarPilihan = dataToko.get(newNomor).getMerek();
                        System.out.println(merekGitarPilihan);

                        if(!dataKeranjang.isEmpty())
                        {
                            for(int i=0; i<dataKeranjang.size(); i++)
                            {   
                                String merekGitarKeranjang = dataKeranjang.get(i).getMerek();
                                int jumlahGitarKeranjang = dataKeranjang.get(i).getJumlah();
                                if(merekGitarPilihan==merekGitarKeranjang && jumlahGitarKeranjang>0 ){
                                    System.out.println(dataKeranjang.get(i).getMerek());
                                    dataKeranjang.get(i).setJumlah(dataKeranjang.get(i).getJumlah()+1);
                                    break;
                                }
                                else if(merekGitarPilihan!=dataKeranjang.get(i).getMerek()){
                                    if(dataKeranjang.toString().contains(merekGitarPilihan))
                                    {
                                        continue;
                                    }
                                    else{
                                        System.out.println(dataKeranjang.get(i).getMerek());
                                    dataKeranjang.add(new keranjang(dataToko.get(newNomor).getMerek(), dataToko.get(newNomor).getKategori(), 1, dataToko.get(newNomor).getHarga(), dataToko.get(newNomor).getJenis()));
                                    break;
                                    }
                                }
                                else{
                                    continue;
                                }
                            }   
                        }
                        else{
                            dataKeranjang.add(new keranjang(dataToko.get(newNomor).getMerek(), dataToko.get(newNomor).getKategori(), 1, dataToko.get(newNomor).getHarga(), dataToko.get(newNomor).getJenis()));   
                        }
                            
                    }
                    else{
                        System.out.println("Stock Barang Habis");
                    }
                }
                else{
                    System.out.println("\nPilihan anda tidak sesuai");
                    System.out.println("Barang gagal masuk keranjang");
                }
            }

            else if(pilihan==2){
                System.out.println("Masukkan keterangan barang yang anda jual");
                System.out.println("Merek : ");
                String merek = sc.nextLine();
                System.out.println("Kategori (Gitar Elektrik/Gitar Akustik/Drum Elektrik/Keyboard Elektrik) : ");
                String kategori = sc.nextLine();
                System.out.println("Harga Beli : $ ");
                int hargabeli = sc.nextInt();
                sc.nextLine();
                int kondisi=100;
                while(kondisi>99 || kondisi<0)
                {
                    System.out.println("Kondisi : (0%-99%)");
                    kondisi = sc.nextInt();
                    sc.nextLine();
                    if(kondisi>99){
                        System.out.println("Anda tidak boleh memasukkan kondisi 100%");
                        break;
                    }
                    else if(kondisi<0){
                        System.out.println("Anda memasukkan input dengan salah");
                        break;
                    }
                    
                }
                kondisi=100;
                if(kondisi>80){
                    d = hargabeli;
                    hargaJual = 0.8*d;
                }
                else if(kondisi<80 && kondisi>50)
                {
                    d = hargabeli;
                    hargaJual = 0.5*d;
                }
                else{
                    System.out.println("Mohon maaf, kami tidak dapat menerima barang anda");
                }
                System.out.println("Barang anda akan kami beli seharga : $"+hargaJual);
                System.out.println("Kami akan mengirim uangnya setelah melalui proses inspeksi oleh tim kami");
                System.out.println("Mohon tunggu sejenak...");

                wait(3000);
                randomNumber = rand.nextInt(2);
                if(randomNumber==1)
                {
                    System.out.println("===========================================================================");
                    System.out.println(
                        "Merek : "+merek+
                        "\nKategori : "+kategori+
                        "\nHarga Beli : $"+hargabeli+
                        "\nKondisi : "+kondisi+"%"+
                        "\nHarga Jual : $"+hargaJual+
                        "\n");
                    System.out.println("Barang anda telah berhasil melalui proses inspeksi dari tim kami");
                    System.out.println("Total Saldo Anda = "+hargaJual);
                    dataToko.add(new databaseToko(merek, kategori, 1, hargaJual, "Bekas"));
                }
                else{
                    System.out.println("===========================================================================");
                    System.out.println("Mohon maaf barang yang anda jual tidak memenuhi kriteria inspeksi dari tim kami");
                    System.out.println("Total Saldo Anda = $"+0);
                }
                
            }

            else if(pilihan==3){
                if(!dataKeranjang.isEmpty())
                {
                    System.out.println("Isi Keranjang Anda : ");
                    for(int i=0; i<dataKeranjang.size(); i++)
                    {
                        System.out.println("\nNomor. "+(i+1));
                        System.out.println(dataKeranjang.get(i));
                        
                    }
                    
                }
                else{
                    System.out.println("\nKeranjang Kosong, Silahkan belanja terlebih dahulu\n");
                }
                
            }
            else if(pilihan==4){
                for(int i =0;i<dataKeranjang.size();i++){
                    hargaBarang = dataKeranjang.get(i).getHarga();
                    jumlahBarang = dataKeranjang.get(i).getJumlah();
                    totalHarga = hargaBarang*jumlahBarang;
                    totalBelanja = totalBelanja + totalHarga;
                }
                System.out.println("Total Belanja Anda");
            }

            else if(pilihan==5){
                System.out.println("Terimakasih Telah Berbelanja di Toko Kami");
                sc.close();
                exit=1;
            }
            else{
                System.out.println("Masukkan inputan dengan benar");
                exit=1;
                sc.close();
            }
        }

    }
}
