package com.scottlogic.deg.generator.restrictions;

import com.scottlogic.deg.generator.Field;
import com.scottlogic.deg.generator.constraints.atomic.AtomicConstraint;
import com.scottlogic.deg.generator.constraints.atomic.IsNullConstraint;
import com.scottlogic.deg.generator.utils.EqualityComparer;
import com.scottlogic.deg.generator.restrictions.Equality.FieldSpecEqualityComparer;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

class FieldSpecFactoryTests {
    private EqualityComparer fieldSpecComparer = new FieldSpecEqualityComparer();

    @Test
    void toMustContainRestrictionFieldSpec_constraintsContainsNotConstraint_returnsMustContainsRestrictionWithNotConstraint() {
        FieldSpecFactory fieldSpecFactory = new FieldSpecFactory();
        Collection<AtomicConstraint> constraints = Arrays.asList(
            new IsNullConstraint(new Field("Test")).negate()
        );

        FieldSpec fieldSpec = fieldSpecFactory.toMustContainRestrictionFieldSpec(constraints);

        FieldSpec expectedFieldSpec = FieldSpec.Empty.withMustContainRestriction(
            new MustContainRestriction(
                new HashSet<FieldSpec>() {{
                    add(
                        FieldSpec.Empty.withNullRestrictions(
                            new NullRestrictions(NullRestrictions.Nullness.MUST_NOT_BE_NULL),
                            null
                        )
                    );
                }}
            )
        );

        Assert.assertTrue(fieldSpecComparer.equals(fieldSpec, expectedFieldSpec));
    }
}
