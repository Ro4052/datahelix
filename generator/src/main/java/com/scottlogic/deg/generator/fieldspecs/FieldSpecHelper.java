package com.scottlogic.deg.generator.fieldspecs;

import com.scottlogic.deg.generator.restrictions.NullRestrictions;
import com.scottlogic.deg.generator.restrictions.Nullness;
import com.scottlogic.deg.generator.restrictions.SetRestrictions;

import java.util.Collections;
import java.util.HashSet;

public class FieldSpecHelper {
    //TODO paul TEST
    public FieldSpec getFieldSpecForValue(Object value){
        if (value == null) {
            return getNullRequiredFieldSpec();
        }
        return FieldSpec.Empty
            .withSetRestrictions(new SetRestrictions(new HashSet<>(Collections.singletonList(value)), null), FieldSpecSource.Empty)
            .withNullRestrictions(new NullRestrictions(Nullness.MUST_NOT_BE_NULL), FieldSpecSource.Empty);
    }

    private FieldSpec getNullRequiredFieldSpec() {
        return FieldSpec.Empty
            .withNullRestrictions(new NullRestrictions(Nullness.MUST_BE_NULL), FieldSpecSource.Empty);
    }
}
