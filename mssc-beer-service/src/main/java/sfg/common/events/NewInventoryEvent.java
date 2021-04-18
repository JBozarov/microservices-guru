package sfg.common.events;

import guru.springframework.msscbeerservice.web.model.BeerDto;
import sfg.common.events.BeerEvent;

public class NewInventoryEvent extends BeerEvent {

    public NewInventoryEvent(BeerDto beerDto) {
        super(beerDto);
    }
}
