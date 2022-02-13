package store.antawa.backoffice.solicitud.application.update_state;

import store.antawa.backoffice.solicitud.domain.SolicitudStatus;
import store.antawa.backoffice.solicitud.domain.SolicitudUid;
import store.antawa.shared.domain.Service;
import store.antawa.shared.domain.bus.command.CommandHandler;

@Service
public final class SolicitudNewStateCommandHandler  implements CommandHandler<SolicitudNewStateCommand>{

    private final NewStateSolicitudUpdater updater;

    public SolicitudNewStateCommandHandler(NewStateSolicitudUpdater updater) {
        this.updater = updater;
    }

    @Override
    public void handle(SolicitudNewStateCommand command) {
    	
    	SolicitudUid 	uid 	= new SolicitudUid(command.uid());
    	SolicitudStatus state 	= new  SolicitudStatus(command.state());
    	String observation		= command.observation();
    	updater.update(uid, state, observation);
    }
    
}
