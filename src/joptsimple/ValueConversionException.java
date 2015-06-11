/*    */ package joptsimple;
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
/*    */ public class ValueConversionException
/*    */   extends RuntimeException
/*    */ {
/*    */   private static final long serialVersionUID = -1L;
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
/*    */   public ValueConversionException(String message)
/*    */   {
/* 42 */     this(message, null);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public ValueConversionException(String message, Throwable cause)
/*    */   {
/* 52 */     super(message, cause);
/*    */   }
/*    */ }


/* Location:              M:\AFolderOfMinecraft\Minecraft.jar!\joptsimple\ValueConversionException.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */