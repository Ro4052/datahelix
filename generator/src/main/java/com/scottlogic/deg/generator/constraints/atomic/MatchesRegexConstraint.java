package com.scottlogic.deg.generator.constraints.atomic;

import com.scottlogic.deg.generator.Field;
import com.scottlogic.deg.generator.constraints.ConstraintRule;

import java.util.Objects;
import java.util.regex.Pattern;

public class MatchesRegexConstraint implements AtomicConstraint {
    public final Field field;
    public final Pattern regex;
    private final ConstraintRule rule;

    public MatchesRegexConstraint(Field field, Pattern regex, ConstraintRule rule) {
        this.field = field;
        this.regex = regex;
        this.rule = rule;
    }

    @Override
    public String toDotLabel(){
        return String.format("%s matches /%s/", field.name, regex);
    }

    @Override
    public Field getField() {
        return field;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatchesRegexConstraint constraint = (MatchesRegexConstraint) o;
        return Objects.equals(field, constraint.field) && Objects.equals(regex.toString(), constraint.regex.toString());
    }

    @Override
    public int hashCode(){
        return Objects.hash(field, regex.toString());
    }

    @Override
    public String toString(){ return String.format("`%s` matches /%s/", field.name, regex); }

    @Override
    public ConstraintRule getRule() {
        return rule;
    }
}
