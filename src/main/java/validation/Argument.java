package validation;

public interface Argument<T> {
    static <T> Argument<T> argument(final String name, final T value, final Class<T> type) {
        return new Argument<T>() {
            @Override
            public Class<T> type() {
                return type;
            }

            @Override
            public String name() {
                return name;
            }

            @Override
            public T value() {
                return value;
            }
        };
    }

    Class<T> type();
    String name();
    T value();
}
