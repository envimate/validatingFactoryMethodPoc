package valuetypes;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Username {
    private final String value;

    public static Username aUsername(final String value) {
        return new Username(value);
    }

    public static Username fromEmail(final Email email) {
        return aUsername(email.stringValue());
    }
}
