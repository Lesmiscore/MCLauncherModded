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
/*    */ class OptionMissingRequiredArgumentException
/*    */   extends OptionException
/*    */ {
/*    */   private static final long serialVersionUID = -1L;
/*    */   
/*    */   OptionMissingRequiredArgumentException(Collection<String> options)
/*    */   {
/* 39 */     super(options);
/*    */   }
/*    */   
/*    */   public String getMessage()
/*    */   {
/* 44 */     return "Option " + multipleOptionMessage() + " requires an argument";
/*    */   }
/*    */ }


/* Location:              M:\AFolderOfMinecraft\Minecraft.jar!\joptsimple\OptionMissingRequiredArgumentException.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */