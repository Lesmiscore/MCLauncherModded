/*    */ package joptsimple;
/*    */ 
/*    */ import java.util.Collections;
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
/*    */ class UnrecognizedOptionException
/*    */   extends OptionException
/*    */ {
/*    */   private static final long serialVersionUID = -1L;
/*    */   
/*    */   UnrecognizedOptionException(String option)
/*    */   {
/* 39 */     super(Collections.singletonList(option));
/*    */   }
/*    */   
/*    */   public String getMessage()
/*    */   {
/* 44 */     return singleOptionMessage() + " is not a recognized option";
/*    */   }
/*    */ }


/* Location:              M:\AFolderOfMinecraft\Minecraft.jar!\joptsimple\UnrecognizedOptionException.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */