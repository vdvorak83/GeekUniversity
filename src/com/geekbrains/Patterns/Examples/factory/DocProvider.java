package com.geekbrains.Patterns.Examples.factory;

public interface DocProvider {
    Doc getDoc(int id);
    void sendPayment(Payment payment);

}
