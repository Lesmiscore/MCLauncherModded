/*    */ package joptsimple.internal;
/*    */ 
/*    */ import java.lang.reflect.Constructor;
/*    */ import joptsimple.ValueConverter;
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
/*    */ 
/*    */ class ConstructorInvokingValueConverter<V>
/*    */   implements ValueConverter<V>
/*    */ {
/*    */   private final Constructor<V> ctor;
/*    */   
/*    */   ConstructorInvokingValueConverter(Constructor<V> ctor)
/*    */   {
/* 42 */     this.ctor = ctor;
/*    */   }
/*    */   
/*    */   public V convert(String value) {
/* 46 */     return (V)Reflection.instantiate(this.ctor, new Object[] { value });
/*    */   }
/*    */   
/*    */   public Class<V> valueType() {
/* 50 */     return this.ctor.getDeclaringClass();
/*    */   }
/*    */   
/*    */   public String valuePattern() {
/* 54 */     return null;
/*    */   }
/*    */ }


/* Location:              M:\AFolderOfMinecraft\Minecraft.jar!\joptsimple\internal\ConstructorInvokingValueConverter.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */