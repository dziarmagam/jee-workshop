package my;

public interface ThrowableFunction<T,S> {
	S apply(T t) throws Exception;
}
