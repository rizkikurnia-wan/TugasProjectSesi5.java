import java.util.Scanner;
public class TugasArray {
    public static void main(String[] args) {
        Scanner inputan = new Scanner(System.in);
        System.out.print("Masukkan jumlah data: ");
        int n = inputan.nextInt();
        String[][] data= new String[n][2]; 

        for(int i=0; i<n; i++) {
            System.out.println("________________________________");
            System.out.println("Mahasiswa Ke : "+(i+1));
            System.out.print("Nama: ");
            data[i][0] = inputan.next();
            System.out.print("Nilai: ");
            data[i][1] = inputan.next();
        }
        double jumlah = 0;
        
        System.out.println("DAFTAR NILAI MAHASISWA");
        System.out.println("================================");
        System.out.println("No\tNama\tNilai\tStatus");
        for (int i=0; i<n;i++) {
            String status;
            int nilaiInt = Integer.parseInt(data[i][1]);
            if (nilaiInt >= 55) {
                status = "Lulus";
            } else {
                status = "Tidak Lulus";
            }
            jumlah += nilaiInt;
            System.out.println((i+1)+"\t"+data[i][0]+"\t"+data[i][1]+"\t"+status);
        }
        double rata_rata = (double)jumlah/n;
        System.out.println("================================");
        System.out.println("Jumlah: "+jumlah);
        System.out.println("Nilai Rata-rata: "+rata_rata);
        inputan.close();
    }
}
