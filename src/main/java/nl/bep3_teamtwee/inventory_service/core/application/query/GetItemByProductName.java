package nl.bep3_teamtwee.inventory_service.core.application.query;

public class GetItemByProductName {

    private String productName;

    public String getProductName() {
        return productName;
    }

    public GetItemByProductName(String productName) {
        this.productName = productName;
    }
}
