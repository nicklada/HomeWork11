package ru.netology.domain;

public class CartManager {
    public void add(PurchaseItem item){

        PurchaseItem[] items = new PurchaseItem[0];

        int length = items.length + 1;
        PurchaseItem[]tmp = new PurchaseItem[length];
        for(int i = 0;i< items.length;i++) {
            tmp[i] = items[i];
        }
        int lastIndex = tmp.length-1;
        tmp[lastIndex]=item;
        items = tmp;
    }
}
