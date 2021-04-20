package guru.springframework.msscssm.services;

import guru.springframework.msscssm.domain.Payment;
import guru.springframework.msscssm.domain.PaymentState;
import org.springframework.statemachine.StateMachine;

import java.awt.event.PaintEvent;

public interface PaymentService {

    Payment newPayment(Payment payment);

    StateMachine<PaymentState, PaintEvent> preAuth(Long paymentId);

    StateMachine<PaymentState, PaintEvent> authorizePayment(Long paymentId);

    StateMachine<PaymentState, PaintEvent> declineAuth(Long paymentId);

}
