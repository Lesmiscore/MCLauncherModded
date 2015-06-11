/*    */ package joptsimple;
/*    */ 
/*    */ import java.util.Collection;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class MultipleArgumentsForOptionException
/*    */   extends OptionException
/*    */ {
/*    */   private static final long serialVersionUID = -1L;
/*    */   
/*    */   MultipleArgumentsForOptionException(Collection<String> options)
/*    */   {
/* 39 */     super(options);
/*    */   }
/*    */   
/*    */   public String getMessage()
/*    */   {
/* 44 */     return "Found multiple arguments for option " + multipleOptionMessage() + ", but you asked for only one";
/*    */   }
/*    */ }


/* Location:              M:\AFolderOfMinecraft\Minecraft.jar!\joptsimple\MultipleArgumentsForOptionException.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */