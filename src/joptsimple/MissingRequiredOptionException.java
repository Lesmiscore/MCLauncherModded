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
/*    */ class MissingRequiredOptionException
/*    */   extends OptionException
/*    */ {
/*    */   private static final long serialVersionUID = -1L;
/*    */   
/*    */   protected MissingRequiredOptionException(Collection<String> options)
/*    */   {
/* 39 */     super(options);
/*    */   }
/*    */   
/*    */   public String getMessage()
/*    */   {
/* 44 */     return "Missing required option(s) " + multipleOptionMessage();
/*    */   }
/*    */ }


/* Location:              M:\AFolderOfMinecraft\Minecraft.jar!\joptsimple\MissingRequiredOptionException.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */