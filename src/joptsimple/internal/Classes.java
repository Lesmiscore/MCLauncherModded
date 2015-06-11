/*    */ package joptsimple.internal;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
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
/*    */ public final class Classes
/*    */ {
/* 35 */   private static final Map<Class<?>, Class<?>> WRAPPERS = new HashMap(13);
/*    */   
/*    */   static {
/* 38 */     WRAPPERS.put(Boolean.TYPE, Boolean.class);
/* 39 */     WRAPPERS.put(Byte.TYPE, Byte.class);
/* 40 */     WRAPPERS.put(Character.TYPE, Character.class);
/* 41 */     WRAPPERS.put(Double.TYPE, Double.class);
/* 42 */     WRAPPERS.put(Float.TYPE, Float.class);
/* 43 */     WRAPPERS.put(Integer.TYPE, Integer.class);
/* 44 */     WRAPPERS.put(Long.TYPE, Long.class);
/* 45 */     WRAPPERS.put(Short.TYPE, Short.class);
/* 46 */     WRAPPERS.put(Void.TYPE, Void.class);
/*    */   }
/*    */   
/*    */   private Classes() {
/* 50 */     throw new UnsupportedOperationException();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static String shortNameOf(String className)
/*    */   {
/* 60 */     return className.substring(className.lastIndexOf('.') + 1);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static <T> Class<T> wrapperOf(Class<T> clazz)
/*    */   {
/* 72 */     return clazz.isPrimitive() ? (Class)WRAPPERS.get(clazz) : clazz;
/*    */   }
/*    */ }


/* Location:              M:\AFolderOfMinecraft\Minecraft.jar!\joptsimple\internal\Classes.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */