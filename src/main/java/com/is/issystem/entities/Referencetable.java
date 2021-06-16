package com.is.issystem.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Referencetable {
    private List<MultiplierForAge> multiplierForAge;
    private List<MultiplierForCareerGroup> multiplierForCareerGroup;
    private List<MultiplierForGenders> multiplierForGenders;
    private List<MultiplierForMainBenifit> multiplierForMainBenifit;
    private List<MultiplierForPaymentPeriod> multiplierForPaymentPeriod;
    private List<MultiplierForSubBenifit> multiplierForSubBenifit;

    public Referencetable(List<MultiplierForAge> multiplierForAge, List<MultiplierForCareerGroup> multiplierForCareerGroup, List<MultiplierForGenders> multiplierForGenders, List<MultiplierForMainBenifit> multiplierForMainBenifit, List<MultiplierForPaymentPeriod> multiplierForPaymentPeriod, List<MultiplierForSubBenifit> multiplierForSubBenifit) {
        this.multiplierForAge = multiplierForAge;
        this.multiplierForCareerGroup = multiplierForCareerGroup;
        this.multiplierForGenders = multiplierForGenders;
        this.multiplierForMainBenifit = multiplierForMainBenifit;
        this.multiplierForPaymentPeriod = multiplierForPaymentPeriod;
        this.multiplierForSubBenifit = multiplierForSubBenifit;
    }
}
