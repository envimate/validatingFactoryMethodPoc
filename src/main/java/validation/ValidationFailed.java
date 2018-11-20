package validation;

import lombok.RequiredArgsConstructor;

import java.util.Collections;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

public class ValidationFailed extends RuntimeException {
    private final List<ValidationError> validationErrors;

    private ValidationFailed(
            final String message,
            final List<ValidationError> validationErrors) {
        super(message);
        this.validationErrors = Collections.unmodifiableList(validationErrors);
    }

    public static ValidationFailed.ErrorsStage because(final String whoOrWhat) {
        final ErrorsStage errorsStage = new ErrorsStage(whoOrWhat);
        return errorsStage;
    }

    public List<ValidationError> validationErrors() {
        return validationErrors;
    }

    @RequiredArgsConstructor(access = PRIVATE)
    public static class ErrorsStage {
        private final String whoOrWhat;

        public ValidationFailed hasValidationErrors(final List<ValidationError> validationErrors) {
            final String message = String.format("validation of %s failed: %s", whoOrWhat, validationErrors);
            return new ValidationFailed(message, validationErrors);
        }
    }
}
