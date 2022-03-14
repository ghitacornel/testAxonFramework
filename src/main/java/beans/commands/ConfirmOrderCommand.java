package beans.commands;

import lombok.Value;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Value
public class ConfirmOrderCommand {

    @TargetAggregateIdentifier
    String orderId;

}
