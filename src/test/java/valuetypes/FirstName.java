package valuetypes;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class FirstName {
    private final String value;

    public static FirstName aFirstName(final String value) {
        return new FirstName(value);
    }
}
