package com.scottlogic.deg.generator.constraints.atomic;

import com.scottlogic.deg.generator.Field;
import com.scottlogic.deg.generator.constraints.ConstraintRule;

import java.util.Collection;

public class ViolatedAtomicConstraint implements AtomicConstraint {
    public final AtomicConstraint violatedConstraint;

    public ViolatedAtomicConstraint(AtomicConstraint violatedConstraint) {
        this.violatedConstraint = violatedConstraint;
    }

    @Override
    public Field getField() {
        return violatedConstraint.getField();
    }

    @Override
    public String toDotLabel() {
        return violatedConstraint.toDotLabel();
    }

    @Override
    public AtomicConstraint negate() {
        return new ViolatedAtomicConstraint(violatedConstraint.negate());
    }

    @Override
    public Collection<Field> getFields() {
        return violatedConstraint.getFields();
    }

    @Override
    public ConstraintRule getRule() {
        return this.violatedConstraint.getRule().violate();
    }

    @Override
    public String toString() {
        return String.format("Violated: %s", this.violatedConstraint.toString());
    }

    public int hashCode(){
        return violatedConstraint.hashCode();
    }

    public boolean equals(Object obj){
        return violatedConstraint.equals(obj);
    }
}
