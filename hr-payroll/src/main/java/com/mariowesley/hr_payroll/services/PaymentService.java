package com.mariowesley.hr_payroll.services;

import com.mariowesley.hr_payroll.entities.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public Payment getPayment(long workerId, int days) {
        return new Payment("bob", 200.0, days);
    }
}
