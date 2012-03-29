    package client;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import service.ServiceInterface;

/**
 * @author Benjamin Schmid <B.Schmid@exxcellent.de>
 */
public class ServiceCaller {

    public void doWork(@Nonnull ServiceInterface service) {

        // null auf unnanottieren Parameter
        //   (Verhalten in Projekt konfigurierbar)
        String result = service.aFunction(null);

        // null-Status von result -> Unklar.
        result = result.intern();                           // Toleriert Dereferenzierung
        result = service.nonnullableFunction(result);       // Toleriert Weitergabe

        // Potentieller null-Status
        result = service.nullableFunction(result);
        result.intern();                                    // Unerlaubte Dereferenzierung

        // Potentieller null-Status -> Weitergabe
        result = service.nullableFunction(result);
        service.nonnullableFunction(result);                // Unerlaubte Weitergabe
    }

    private static class MyService implements ServiceInterface {

        @Override
        public String nullableFunction(@Nullable String parameter) {
            return parameter.trim();
        }

        @Nonnull
        @Override
        public String nonnullableFunction(@Nonnull String parameter) {
            return parameter.trim();
        }

        @Override
        public String aFunction(String parameter) {
            return parameter.trim();
        }
    }



}
