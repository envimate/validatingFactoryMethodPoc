package validation;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class AggregatedValidator {
    private final Class<?> whoOrWhat;
    private final MethodCall args;

    public static AggregatedValidator on(final MethodCall methodCall) {
        return new AggregatedValidator(methodCall.callee(), methodCall);
    }

    public void requireAll() {
        final List<ValidationError> validationErrors =
                args.streamArguments()
                        .filter(a -> a.value() == null)
                        .map(a -> ValidationError.validationError(a.name(), "is required"))
                        .collect(toList());
        if (! validationErrors.isEmpty()) {
            throw ValidationFailed.because(whoOrWhat.getSimpleName()).hasValidationErrors(validationErrors);
        }
    }
}
