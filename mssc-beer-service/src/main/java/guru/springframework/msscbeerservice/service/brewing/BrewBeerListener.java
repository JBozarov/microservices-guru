package guru.springframework.msscbeerservice.service.brewing;

import guru.springframework.msscbeerservice.config.JmsConfig;
import guru.springframework.msscbeerservice.domain.Beer;
import sfg.common.events.BrewBeerEvent;
import sfg.common.events.NewInventoryEvent;
import guru.springframework.msscbeerservice.repositories.BeerRepository;
import guru.springframework.msscbeerservice.web.model.BeerDto;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Slf4j
@NoArgsConstructor
public class BrewBeerListener {

  private BeerRepository beerRepository;
  private JmsTemplate jmsTemplate;

  @Transactional
  @JmsListener(destination = JmsConfig.BREWING_REQUEST_QUEUE)
  public void listen(BrewBeerEvent event) {

    BeerDto beerDto = event.getBeerDto();

    Beer beer = beerRepository.getOne(beerDto.getId());

    beerDto.setQuantityOnHand(beer.getQuantityToBrew());

    NewInventoryEvent newInventoryEvent = new NewInventoryEvent(beerDto);

    log.debug("Brewed beer " + beer.getMinOnHand() + " : QOH: " + beerDto.getQuantityOnHand());

    jmsTemplate.convertAndSend(JmsConfig.NEW_INVENTORY_QUEUE, newInventoryEvent);
  }
}
