package valuetypes;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Email {
    private final String value;

    public static Email anEmail(final String value) {
        return new Email(value);
    }

    public String stringValue() {
        return value;
    }
}
