package com.restaurant;

import com.restaurant.menu.MenuItem;
import com.restaurant.order.Order;

import java.util.Scanner;

public class Restaurant {
    private MenuItem[] menu;

    public Restaurant() {
        // Daftar menu contoh
        menu = new MenuItem[] {
                new MenuItem("Nasi Goreng", 15000),
                new MenuItem("Mie Goreng", 12000),
                new MenuItem("Sate Ayam", 18000)
        };
    }

    public void showMenu() {
        System.out.println("Menu:");
        for (int i = 0; i < menu.length; i++) {
            System.out.println((i + 1) + ". " + menu[i].toString());
        }
        System.out.println("0. Hapus item dari pesanan");
        System.out.println("q. Selesai");
    }

    public void takeOrder() {
        Scanner scanner = new Scanner(System.in);
        Order order = new Order();
        String choice;

        do {
            showMenu();
            System.out.print("Pilih item (1-" + menu.length + "), '0' untuk menghapus item, atau 'q' untuk selesai: ");
            choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("q")) {
                break;
            }

            // Menghapus item dari pesanan
            if (choice.equals("0")) {
                System.out.print("Masukkan nomor item yang ingin dihapus: ");
                choice = scanner.nextLine();
                int itemIndex = Integer.parseInt(choice) - 1;
                if (itemIndex >= 0 && itemIndex < menu.length) {
                    order.removeItem(menu[itemIndex]);
                    System.out.println(menu[itemIndex].getName() + " telah dihapus dari pesanan.");
                } else {
                    System.out.println("Pilihan tidak valid.");
                }
                continue;
            }

            // Menambah item ke dalam pesanan
            try {
                int itemIndex = Integer.parseInt(choice) - 1;
                if (itemIndex >= 0 && itemIndex < menu.length) {
                    System.out.print("Masukkan jumlah item: ");
                    int quantity = Integer.parseInt(scanner.nextLine());
                    if (quantity > 0) {
                        order.addItem(menu[itemIndex], quantity);
                        System.out.println(quantity + " " + menu[itemIndex].getName() + " ditambahkan ke pesanan.");
                    } else {
                        System.out.println("Jumlah harus lebih dari 0.");
                    }
                } else {
                    System.out.println("Pilihan tidak valid.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Harap masukkan angka yang sesuai.");
            }

        } while (!choice.equalsIgnoreCase("q"));

        order.printOrder();
    }
}
