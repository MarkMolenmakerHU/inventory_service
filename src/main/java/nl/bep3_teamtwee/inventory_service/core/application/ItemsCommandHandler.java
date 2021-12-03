package nl.bep3_teamtwee.inventory_service.core.application;

import nl.bep3_teamtwee.inventory_service.core.application.command.RegisterItem;
import nl.bep3_teamtwee.inventory_service.core.domain.Item;
import nl.bep3_teamtwee.inventory_service.core.domain.event.ItemEvent;
import nl.bep3_teamtwee.inventory_service.core.port.messaging.ItemEventPublisher;
import nl.bep3_teamtwee.inventory_service.core.port.storage.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemsCommandHandler {

    private final ItemRepository repository;
    private final ItemEventPublisher eventPublisher;

    public ItemsCommandHandler(ItemRepository repository, ItemEventPublisher eventPublisher) {
        this.repository = repository;
        this.eventPublisher = eventPublisher;
    }

    public Item handle(RegisterItem command) {
        Item item = new Item(command.getProductName(), command.getUnit(), command.getCapacity(),
                command.getPurchaseCapacity(), command.getSellCapacity(), command.getPurchasePrice(),
                command.getSellPrice());

        this.publishEventsFor(item);
        this.repository.save(item);

        return item;
    }

    private void publishEventsFor(Item item) {
        List<ItemEvent> events = item.listEvents();
        events.forEach(eventPublisher::publish);
        item.clearEvents();
    }

}