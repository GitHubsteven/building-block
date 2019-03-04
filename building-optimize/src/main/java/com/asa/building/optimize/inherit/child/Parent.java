package com.asa.building.optimize.inherit.child;

import lombok.Getter;
import lombok.Setter;
import org.javamoney.moneta.Money;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import java.io.Serializable;
import java.util.Locale;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 15:20 2019/2/27.
 */
@Setter
@Getter
public class Parent implements Serializable {
    private String name;

    private Money money;

    public static void main(String[] args) {
        CurrencyUnit currencyUnit = Monetary.getCurrency(Locale.US);
        Money money = Money.of(12, currencyUnit);
    }

}