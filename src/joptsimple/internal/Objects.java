/*    */ package joptsimple.internal;
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
/*    */ public final class Objects
/*    */ {
/*    */   private Objects()
/*    */   {
/* 33 */     throw new UnsupportedOperationException();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static void ensureNotNull(Object target)
/*    */   {
/* 43 */     if (target == null) {
/* 44 */       throw new NullPointerException();
/*    */     }
/*    */   }
/*    */ }


/* Location:              M:\AFolderOfMinecraft\Minecraft.jar!\joptsimple\internal\Objects.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */