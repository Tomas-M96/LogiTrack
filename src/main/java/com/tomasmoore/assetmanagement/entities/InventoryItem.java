package com.tomasmoore.assetmanagement.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "inventory_item")
public class InventoryItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private long itemId;
    @Id
    @Column(name = "inventory_id")
    private long inventoryId;
    @Column(name = "serial_no")
    private String serialNo;


    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public long getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(long inventoryId) {
        this.inventoryId = inventoryId;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }



    public InventoryItem() {
    }

    public InventoryItem(long itemId, long inventoryId, String serialNo) {
        this.itemId = itemId;
        this.inventoryId = inventoryId;
        this.serialNo = serialNo;
    }
}
