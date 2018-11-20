package valuetypes;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class LastName {
    private final String value;

    public static LastName aLastName(final String value) {
        return new LastName(value);
    }
}
