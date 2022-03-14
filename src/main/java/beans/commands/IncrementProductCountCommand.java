package beans.commands;

import lombok.Value;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Value
public class IncrementProductCountCommand {

    @TargetAggregateIdentifier
    String orderId;
    String productId;

}
