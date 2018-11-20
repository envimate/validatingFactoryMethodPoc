package validation;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ValidationError {
    public final String property;
    public final String reason;

    public static ValidationError validationError(final String property, final String reason) {
        return new ValidationError(property, reason);
    }
}
