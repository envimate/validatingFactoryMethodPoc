package valuetypes;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Password {
    private final String value;

    public static Password aPassword(final String value) {
        return new Password(value);
    }
}
