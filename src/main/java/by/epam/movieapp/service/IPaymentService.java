package by.epam.movieapp.service;


import by.epam.movieapp.model.PaymentData;
import by.epam.movieapp.model.PaymentStatus;

/**
 * @author Olga Shahray
 */
public interface IPaymentService {

  PaymentStatus processPayment(PaymentData pd);
}
