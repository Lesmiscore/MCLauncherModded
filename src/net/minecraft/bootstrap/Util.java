/*    */ package net.minecraft.bootstrap;
/*    */ 
/*    */ import java.io.File;
/*    */ 
/*    */ public class Util {
/*    */   public static final String APPLICATION_NAME = "minecraft";
/*    */   
/*    */   public static enum OS {
/*  9 */     WINDOWS,  MACOS,  SOLARIS,  LINUX,  UNKNOWN;
/*    */     
/*    */     private OS() {} }
/*    */   
/* 13 */   public static OS getPlatform() { String osName = System.getProperty("os.name").toLowerCase();
/* 14 */     if (osName.contains("win")) return OS.WINDOWS;
/* 15 */     if (osName.contains("mac")) return OS.MACOS;
/* 16 */     if (osName.contains("linux")) return OS.LINUX;
/* 17 */     if (osName.contains("unix")) return OS.LINUX;
/* 18 */     return OS.UNKNOWN;
/*    */   }
/*    */   
/*    */   public static File getWorkingDirectory() {
/* 22 */     String userHome = System.getProperty("user.home", ".");
/*    */     
/*    */     File workingDirectory;
/* 25 */     switch (getPlatform()) {
/*    */     case LINUX: 
/*    */     case SOLARIS: 
/* 28 */       workingDirectory = new File(userHome, ".minecraft/");
/* 29 */       break;
/*    */     case WINDOWS: 
/* 31 */       String applicationData = System.getenv("APPDATA");
/* 32 */       String folder = applicationData != null ? applicationData : userHome;
/*    */       
/* 34 */       workingDirectory = new File(folder, ".minecraft/");
/* 35 */       break;
/*    */     case MACOS: 
/* 37 */       workingDirectory = new File(userHome, "Library/Application Support/minecraft");
/* 38 */       break;
/*    */     default: 
/* 40 */       workingDirectory = new File(userHome, "minecraft/");
/*    */     }
/*    */     
/* 43 */     return workingDirectory;
/*    */   }
/*    */ }


/* Location:              M:\AFolderOfMinecraft\Minecraft.jar!\net\minecraft\bootstrap\Util.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */