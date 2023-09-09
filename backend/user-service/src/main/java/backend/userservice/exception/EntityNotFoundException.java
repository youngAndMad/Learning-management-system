package backend.userservice.exception;

public class EntityNotFoundException extends RuntimeException{
    public EntityNotFoundException(Class<?> c) {
        super(c.getSimpleName().concat("not found"));
    }
}
