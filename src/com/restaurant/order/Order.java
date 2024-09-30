package com.restaurant.order;

import com.restaurant.menu.MenuItem;
import java.util.HashMap;
import java.util.Map;

public class Order {
    // Menggunakan HashMap untuk menyimpan item dan kuantitasnya
    private Map<MenuItem, Integer> items;

    public Order() {
        this.items = new HashMap<>();
    }

    // Menambahkan item ke dalam pesanan dengan kuantitas
    public void addItem(MenuItem item, int quantity) {
        if (items.containsKey(item)) {
            items.put(item, items.get(item) + quantity); // Tambah kuantitas jika sudah ada
        } else {
            items.put(item, quantity); // Masukkan item baru
        }
    }

    // Menghapus item dari pesanan
    public void removeItem(MenuItem item) {
        if (items.containsKey(item)) {
            items.remove(item);
        } else {
            System.out.println("Item tidak ada di pesanan.");
        }
    }

    // Menghitung total harga
    public double calculateTotal() {
        return items.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
    }

    // Mencetak pesanan
    public void printOrder() {
        if (items.isEmpty()) {
            System.out.println("Tidak ada pesanan.");
            return;
        }

        System.out.println("Detail pesanan:");
        items.forEach((item, quantity) ->
                System.out.println(item.getName() + " x " + quantity + " = Rp." + (item.getPrice() * quantity)));
        System.out.println("Total: Rp." + calculateTotal());
    }
}
