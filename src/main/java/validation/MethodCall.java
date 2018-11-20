package validation;

import java.util.stream.Stream;

public interface MethodCall {
    Stream<Argument> streamArguments();

    Class<?> callee();
}
