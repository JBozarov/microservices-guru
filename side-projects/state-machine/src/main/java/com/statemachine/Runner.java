package com.statemachine;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineFactory;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Runner implements ApplicationRunner {

  private final StateMachineFactory<OrderStates, OrderEvents> factory;

  public Runner(StateMachineFactory<OrderStates, OrderEvents> factory) {
    this.factory = factory;
  }

  @Override
  public void run(ApplicationArguments args) throws Exception {
    StateMachine<OrderStates, OrderEvents> machine = this.factory.getStateMachine("13232");

    machine.start();
    log.info("First log " + machine.getState().getId().name());

    machine.sendEvent(OrderEvents.PAY);
    log.info("Second line " + machine.getState().getId().name());

    machine.sendEvent(OrderEvents.CANCEL);
    log.info("Third line " + machine.getState().getId().name());

  }
}
