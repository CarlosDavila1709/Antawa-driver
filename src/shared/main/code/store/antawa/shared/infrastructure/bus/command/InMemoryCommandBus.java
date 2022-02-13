package store.antawa.shared.infrastructure.bus.command;

import org.springframework.context.ApplicationContext;
import store.antawa.shared.domain.Service;
import store.antawa.shared.domain.bus.command.Command;
import store.antawa.shared.domain.bus.command.CommandBus;
import store.antawa.shared.domain.bus.command.CommandHandler;
import store.antawa.shared.domain.bus.command.CommandHandlerExecutionError;

@Service
public final class InMemoryCommandBus implements CommandBus {
    private final CommandHandlersInformation information;
    private final ApplicationContext         context;

    public InMemoryCommandBus(CommandHandlersInformation information, ApplicationContext context) {
        this.information = information;
        this.context     = context;
    }

    @Override
    public void dispatch(Command command) throws CommandHandlerExecutionError {
        try {
            Class<? extends CommandHandler> commandHandlerClass = information.search(command.getClass());

            CommandHandler handler = context.getBean(commandHandlerClass);

            handler.handle(command);
        } catch (Throwable error) {
            throw new CommandHandlerExecutionError(error);
        }
    }
}
