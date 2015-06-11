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
/*    */ 
/*    */ class RequiredArgumentOptionSpec<V>
/*    */   extends ArgumentAcceptingOptionSpec<V>
/*    */ {
/*    */   RequiredArgumentOptionSpec(String option)
/*    */   {
/* 38 */     super(option, true);
/*    */   }
/*    */   
/*    */   RequiredArgumentOptionSpec(Collection<String> options, String description) {
/* 42 */     super(options, true, description);
/*    */   }
/*    */   
/*    */   protected void detectOptionArgument(OptionParser parser, ArgumentList arguments, OptionSet detectedOptions)
/*    */   {
/* 47 */     if (!arguments.hasMore()) {
/* 48 */       throw new OptionMissingRequiredArgumentException(options());
/*    */     }
/* 50 */     addArguments(detectedOptions, arguments.next());
/*    */   }
/*    */ }


/* Location:              M:\AFolderOfMinecraft\Minecraft.jar!\joptsimple\RequiredArgumentOptionSpec.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */