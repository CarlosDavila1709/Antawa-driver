package store.antawa.backoffice.solicitud.application.update_state;

import store.antawa.shared.domain.bus.command.Command;

public final class SolicitudNewStateCommand implements Command {

    private final String uid;
    private final String state;
    private final String observation;

    public SolicitudNewStateCommand(String uid, String state, String observation) {
        this.uid 			= uid;
        this.state			= state;
        this.observation 	= observation;
        
    }

    public String uid() {
        return uid;
    }
    public String state() {
        return state;
    }
    public String observation() {
    	return observation;
    }
}
