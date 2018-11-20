package dataobjects;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import validation.Argument;
import validation.MethodCall;
import valuetypes.Email;
import valuetypes.Password;
import valuetypes.Username;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import static validation.AggregatedValidator.on;
import static validation.Argument.argument;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class CreateUserProfileRequest {
    public final Email email;
    public final Password password;
    public final Username username;

    private static void validate(final FactoryCall call) {
        on(call).requireAll();
    }

    public static CreateUserProfileRequest createUserProfileRequest(
            final Email email,
            final Password password,
            final Username username) {

        final FactoryCall args = new FactoryCall(email, password, username);
        validate(args);
        return new CreateUserProfileRequest(args.email, args.password, args.username);
    }

    @RequiredArgsConstructor
    private static class FactoryCall implements MethodCall {
        private final Email email;
        private final Password password;
        private final Username username;

        @Override
        public Stream<Argument> streamArguments() {
            final List<Argument> args = new LinkedList<>();
            args.add(argument("email", email, Email.class));
            args.add(argument("password", password, Password.class));
            args.add(argument("username", username, Username.class));
            return args.stream();
        }

        @Override
        public Class<CreateUserProfileRequest> callee() {
            return CreateUserProfileRequest.class;
        }
    }
}

