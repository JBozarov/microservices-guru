package guru.springframework.msscssm.services;

import guru.springframework.msscssm.domain.Payment;
import guru.springframework.msscssm.domain.PaymentState;
import guru.springframework.msscssm.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineFactory;
import org.springframework.stereotype.Service;

import java.awt.event.PaintEvent;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

  private final PaymentRepository paymentRepository;
  private final StateMachineFactory<PaymentState, PaintEvent> stateMachineFactory;

  @Override
  public Payment newPayment(Payment payment) {
    payment.setState(PaymentState.NEW);
    return paymentRepository.save(payment);
  }

  @Override
  public StateMachine<PaymentState, PaintEvent> preAuth(Long paymentId) {
    return null;
  }

  @Override
  public StateMachine<PaymentState, PaintEvent> authorizePayment(Long paymentId) {
    return null;
  }

  @Override
  public StateMachine<PaymentState, PaintEvent> declineAuth(Long paymentId) {
    return null;
  }
}
