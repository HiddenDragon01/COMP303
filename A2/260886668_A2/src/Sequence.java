// If a certain class has a sequel and a prequel, this interface allows the user to obtain these fields

public interface Sequence<T> {
   T getSequel();
   T getPrequel();
   void setPrequel(T item);
   void setSequel(T item);

}
