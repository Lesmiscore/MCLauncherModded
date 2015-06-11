package joptsimple;

import java.util.Collection;
import java.util.List;

public abstract interface OptionSpec<V>
{
  public abstract List<V> values(OptionSet paramOptionSet);
  
  public abstract V value(OptionSet paramOptionSet);
  
  public abstract Collection<String> options();
  
  public abstract boolean isForHelp();
}


/* Location:              M:\AFolderOfMinecraft\Minecraft.jar!\joptsimple\OptionSpec.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */