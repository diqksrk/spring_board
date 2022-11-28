package com.example.demo.TDD;

import java.awt.*;

public class Money  {
    protected int amount;
    protected String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public int amount() {
        return this.amount;
    }

    static public Money Dollar(int amount) {
        return new Money(amount, "USD");
    }

    static public Money Franc(int amount) {
        return new Money(amount,"CHF");
    }

    public Money plus(Money addend) {
        return new Money(this.amount + addend.amount, this.currency);
    }

    public Money times(int multiplier) {
        return new Money(this.amount * multiplier, this.currency);
    }

    @Override
    public boolean equals(Object obj) {
        Money money = (Money) obj;
        return this.amount == money.amount && this.currency == money.currency;
    }
}
