package service;

import javax.annotation.Nonnull;
import org.jetbrains.annotations.Nullable;

/**
 * Sample Interface to demonstrate software defect annotations.
 *
 * @author Benjamin Schmid <B.Schmid@exxcellent.de>
 */
public interface ServiceInterface {

    @Nullable
    String nullableFunction(@Nullable String parameter);

    @Nonnull
    String nonnullableFunction(@Nonnull String parameter);

    String aFunction(String parameter);


}
