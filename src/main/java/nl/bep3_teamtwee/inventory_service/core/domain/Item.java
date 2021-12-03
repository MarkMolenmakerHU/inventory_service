package nl.bep3_teamtwee.inventory_service.core.domain;

import nl.bep3_teamtwee.inventory_service.core.domain.event.ItemEvent;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Document
public class Item {

    @Id
    private UUID id;

    @Indexed(unique = true)
    private String productName;

    private Unit unit;

    private int stock;
    private int capacity;
    private int purchaseCapacity;
    private int sellCapacity;
    private double purchasePrice;
    private double sellPrice;

    @Transient
    private List<ItemEvent> events = new ArrayList<>();

    public Item(String productName, Unit unit, int capacity, int purchaseCapacity, int sellCapacity, double purchasePrice, double sellPrice) {
        this.id = UUID.randomUUID();
        this.stock = 0;
        this.productName = productName;
        this.unit = unit;
        this.capacity = capacity;
        this.purchaseCapacity = purchaseCapacity;
        this.sellCapacity = sellCapacity;
        this.purchasePrice = purchasePrice;
        this.sellPrice = sellPrice;
    }

    public void clearEvents() {
        this.events.clear();
    }

    public List<ItemEvent> listEvents() {
        return events;
    }
}
