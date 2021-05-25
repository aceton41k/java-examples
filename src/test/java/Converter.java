@FunctionalInterface
public interface Converter<T, N> {
    N convert(T t);
}