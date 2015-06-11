package joptsimple;

public abstract interface ValueConverter<V>
{
  public abstract V convert(String paramString);
  
  public abstract Class<V> valueType();
  
  public abstract String valuePattern();
}


/* Location:              M:\AFolderOfMinecraft\Minecraft.jar!\joptsimple\ValueConverter.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */