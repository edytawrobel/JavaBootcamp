package bootcamp.data;

import java.util.Objects;
import java.util.Optional;

public class Result<T> {
    private final Status status;
    private final String message;
    private final Optional<T> value;

    //1. With argument of type T indicating success and the return value. Status is set to success, message to empty string and value to the argument.
    public Result() {
        this.status = Status.SUCCESS;
        this.message = "";
        this.value = Optional.empty();
    }

    //2. With status and message. value set to empty optional. Status and message set to corresponding arguments.
    public Result(Status status, String message) {
        this.status = status;
        this.message = message;
        this.value = Optional.empty();
    }

    //3. No arguments. Implies success with no return value. status set to success, message to empty string and value to empty Optional.
    public Result(Optional<T> value) {
        this.status = Status.SUCCESS;
        this.message = "";
        this.value = value;
    }

    public Status getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public Optional<T> getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result<?> result = (Result<?>) o;
        return status == result.status &&
                Objects.equals(message, result.message) &&
                Objects.equals(value, result.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, message, value);
    }
}
