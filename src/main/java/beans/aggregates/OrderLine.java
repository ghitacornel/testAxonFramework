package beans.aggregates;

import beans.commands.DecrementProductCountCommand;
import beans.commands.IncrementProductCountCommand;
import beans.events.OrderConfirmedEvent;
import beans.events.ProductCountDecrementedEvent;
import beans.events.ProductCountIncrementedEvent;
import beans.events.ProductRemovedEvent;
import beans.exceptions.OrderAlreadyConfirmedException;
import lombok.Data;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.EntityId;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Data
public class OrderLine {

    @EntityId
    private final String productId;
    private Integer count;
    private boolean orderConfirmed;

    public OrderLine(String productId) {
        this.productId = productId;
        this.count = 1;
    }

    @CommandHandler
    public void handle(IncrementProductCountCommand command) {
        if (orderConfirmed) {
            throw new OrderAlreadyConfirmedException(command.getOrderId());
        }

        apply(new ProductCountIncrementedEvent(command.getOrderId(), productId));
    }

    @CommandHandler
    public void handle(DecrementProductCountCommand command) {
        if (orderConfirmed) {
            throw new OrderAlreadyConfirmedException(command.getOrderId());
        }

        if (count <= 1) {
            apply(new ProductRemovedEvent(command.getOrderId(), productId));
        } else {
            apply(new ProductCountDecrementedEvent(command.getOrderId(), productId));
        }
    }

    @EventSourcingHandler
    public void on(ProductCountIncrementedEvent event) {
        this.count++;
    }

    @EventSourcingHandler
    public void on(ProductCountDecrementedEvent event) {
        this.count--;
    }

    @EventSourcingHandler
    public void on(OrderConfirmedEvent event) {
        this.orderConfirmed = true;
    }


}