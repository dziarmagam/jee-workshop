package my;


public interface ThrowableConsumer<T> {
	
	void accept(T t) throws Exception;
}
