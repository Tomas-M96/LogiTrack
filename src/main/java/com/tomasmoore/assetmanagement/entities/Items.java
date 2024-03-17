package com.tomasmoore.assetmanagement.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "items")
public class Items {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private long itemId;
    @Column(name = "item_category")
    private String itemCategory;
    @Column(name = "item_name")
    private String itemName;


    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public String getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }



    public Items() {
    }

    public Items(String itemCategory, String itemName) {
        this.itemCategory = itemCategory;
        this.itemName = itemName;
    }
}
