package midProject_Bryan;

import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Karyawan> listKaryawan = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Input data karyawan");
            System.out.println("2. View data karyawan");
            System.out.println("3. Update data karyawan");
            System.out.println("4. Delete data karyawan");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            int menu = scanner.nextInt();
            scanner.nextLine(); 

            switch (menu) {
                case 1:
                    inputDataKaryawan();
                    break;
                case 2:
                    viewDataKaryawan();
                    break;
                case 3:
                    updateDataKaryawan();
                    break;
                case 4:
                    deleteDataKaryawan();
                    break;
                case 5:
                    System.out.println("Terima kasih!");
                    System.exit(0);
                default:
                    System.out.println("Menu tidak valid!");
            }
        }
    }

    static void inputDataKaryawan() {
        System.out.print("Masukkan kode karyawan: ");
        String kodeKaryawan = scanner.nextLine();

        System.out.print("Masukkan nama karyawan: ");
        String namaKaryawan = scanner.nextLine();

        System.out.print("Masukkan jenis kelamin (Laki-Laki / Perempuan): ");
        String jenisKelamin = scanner.nextLine();

        System.out.print("Masukkan jabatan (Manager / Supervisor / Admin): ");
        String jabatan = scanner.nextLine();

        double gaji = 0;
        switch (jabatan) {
            case "Manager":
                gaji = 8000000;
                break;
            case "Supervisor":
                gaji = 6000000;
                break;
            case "Admin":
                gaji = 4000000;
                break;
            default:
                System.out.println("Jabatan tidak valid!");
                return;
        }

        listKaryawan.add(new Karyawan(kodeKaryawan, namaKaryawan, jenisKelamin, jabatan, gaji));

        System.out.println("Data karyawan berhasil ditambahkan!");
    }

    static void viewDataKaryawan() {
        if (listKaryawan.isEmpty()) {
            System.out.println("Belum ada data karyawan.");
            return;
        }

        Collections.sort(listKaryawan, Comparator.comparing(Karyawan::getNamaKaryawan));

        System.out.println("Data karyawan:");
        for (int i = 0; i < listKaryawan.size(); i++) {
            System.out.println((i+1) + ". " + listKaryawan.get(i));
        }
    }

    static void updateDataKaryawan() {
        if (listKaryawan.isEmpty()) {
            System.out.println("Belum ada data karyawan.");
            return;
        }

        viewDataKaryawan(); 

        System.out.print("Pilih nomor data yang ingin diupdate (0 untuk batal): ");
        int index = scanner.nextInt();
        scanner.nextLine();

        if (index < 0 || index > listKaryawan.size()) {
            System.out.println("Nomor data tidak valid!");
            return;
        } else if (index == 0) {
            System.out.println("Batal update data.");
            return;
        }

        Karyawan karyawan = listKaryawan.get(index - 1);

        System.out.print("Masukkan kode karyawan baru: ");
        String kodeKaryawan = scanner.nextLine();

        System.out.print("Masukkan nama karyawan baru: ");
        String namaKaryawan = scanner.nextLine();

        System.out.print("Masukkan jenis kelamin baru (Laki-Laki / Perempuan): ");
        String jenisKelamin = scanner.nextLine();

        System.out.print("Masukkan jabatan baru (Manager / Supervisor / Admin): ");
        String jabatan = scanner.nextLine();

        double gaji = 0;
        switch (jabatan) {
            case "Manager":
                gaji = 8000000;
                break;
            case "Supervisor":
                gaji = 6000000;
                break;
            case "Admin":
                gaji = 4000000;
                break;
            default:
                System.out.println("Jabatan tidak valid!");
                return;
        }

        karyawan.setKodeKaryawan(kodeKaryawan);
        karyawan.setNamaKaryawan(namaKaryawan);
        karyawan.setJenisKelamin(jenisKelamin);
        karyawan.setJabatan(jabatan);
        karyawan.setGaji(gaji);

        System.out.println("Data karyawan berhasil diupdate!");

        
        viewDataKaryawan();
    }

    static void deleteDataKaryawan() {
        if (listKaryawan.isEmpty()) {
            System.out.println("Belum ada data karyawan.");
            return;
        }

        viewDataKaryawan();

        System.out.print("Pilih nomor data yang ingin dihapus: ");
        int index = scanner.nextInt();
        scanner.nextLine();

        if (index < 1 || index > listKaryawan.size()) {
            System.out.println("Nomor data tidak valid!");
            return;
        }

        Karyawan karyawan = listKaryawan.remove(index - 1);
        System.out.println("Data karyawan berhasil dihapus: " + karyawan);
    }
}