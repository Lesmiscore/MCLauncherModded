package joptsimple;

import java.util.Collection;
import java.util.List;

public abstract interface OptionDescriptor
{
  public abstract Collection<String> options();
  
  public abstract String description();
  
  public abstract List<?> defaultValues();
  
  public abstract boolean isRequired();
  
  public abstract boolean acceptsArguments();
  
  public abstract boolean requiresArgument();
  
  public abstract String argumentDescription();
  
  public abstract String argumentTypeIndicator();
  
  public abstract boolean representsNonOptions();
}


/* Location:              M:\AFolderOfMinecraft\Minecraft.jar!\joptsimple\OptionDescriptor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */