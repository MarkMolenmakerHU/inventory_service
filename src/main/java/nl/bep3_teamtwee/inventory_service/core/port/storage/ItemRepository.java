package nl.bep3_teamtwee.inventory_service.core.port.storage;

import nl.bep3_teamtwee.inventory_service.core.domain.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;
import java.util.UUID;

public interface ItemRepository extends MongoRepository<Item, UUID> {

    Optional<Item> findByProductName(String productName);

}
