package danekerscode.courseservice.exception;


public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(Class<?> c, Long id) {
        super("%s by id: %d not found".formatted(c.getSimpleName(), id));
    }

    public EntityNotFoundException(Class<?> c) {
        super("%s not found".formatted(c.getSimpleName()));
    }
}
