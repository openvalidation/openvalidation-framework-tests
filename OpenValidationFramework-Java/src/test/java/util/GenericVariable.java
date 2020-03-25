package util;

public class GenericVariable<T>
{
   private T value;

   public GenericVariable(T value)
   {
      this.value = value;
   }


   public T getValue()
   {
      return value;
   }
}
