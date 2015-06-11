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
/*    */ class ArgumentList
/*    */ {
/*    */   private final String[] arguments;
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
/*    */   private int currentIndex;
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
/*    */   ArgumentList(String... arguments)
/*    */   {
/* 40 */     this.arguments = ((String[])arguments.clone());
/*    */   }
/*    */   
/*    */   boolean hasMore() {
/* 44 */     return this.currentIndex < this.arguments.length;
/*    */   }
/*    */   
/*    */   String next() {
/* 48 */     return this.arguments[(this.currentIndex++)];
/*    */   }
/*    */   
/*    */   String peek() {
/* 52 */     return this.arguments[this.currentIndex];
/*    */   }
/*    */   
/*    */   void treatNextAsLongOption() {
/* 56 */     if ('-' != this.arguments[this.currentIndex].charAt(0)) {
/* 57 */       this.arguments[this.currentIndex] = ("--" + this.arguments[this.currentIndex]);
/*    */     }
/*    */   }
/*    */ }


/* Location:              M:\AFolderOfMinecraft\Minecraft.jar!\joptsimple\ArgumentList.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */