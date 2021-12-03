package nl.bep3_teamtwee.inventory_service.infrastructure.driver.web.request;

import nl.bep3_teamtwee.inventory_service.core.domain.Unit;

import javax.validation.constraints.NotBlank;

public class RegisterItemRequest {

    @NotBlank public String productName;
    @NotBlank public Unit unit;
    @NotBlank public int capacity;
    @NotBlank public int purchaseCapacity;
    @NotBlank public int sellCapacity;
    @NotBlank public double purchasePrice;
    @NotBlank public double sellPrice;
}
