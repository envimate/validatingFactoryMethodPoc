package test;

import dataobjects.CreateUserProfileRequest;
import dataobjects.CreateUserProfileRequestWithAnnotation;
import org.junit.jupiter.api.Test;
import validation.ValidationFailed;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static valuetypes.Username.aUsername;

public class AcceptanceTest {
    @Test
    void testBefore() {
        ValidationFailed v = assertThrows(ValidationFailed.class, () ->
                CreateUserProfileRequest.createUserProfileRequest(
                        null,
                        null,
                        aUsername("u")
                ));
        assertEquals("email", v.validationErrors().get(0).property);
        assertEquals("password", v.validationErrors().get(1).property);
    }

    @Test
    void testAfter() {
        ValidationFailed v = assertThrows(ValidationFailed.class, () ->
                CreateUserProfileRequestWithAnnotation.createUserProfileRequest(
                        null,
                        null,
                        aUsername("u")
                ), "annotation processing should have occurred");
        assertEquals("email", v.validationErrors().get(0).property);
        assertEquals("password", v.validationErrors().get(1).property);
    }
}
