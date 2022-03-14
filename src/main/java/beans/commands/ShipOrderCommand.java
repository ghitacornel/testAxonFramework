package beans.commands;

import lombok.Value;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Value
public class ShipOrderCommand {

    @TargetAggregateIdentifier
    String orderId;

}
