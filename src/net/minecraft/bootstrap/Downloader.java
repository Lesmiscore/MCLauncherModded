/*     */ package net.minecraft.bootstrap;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.InputStream;
/*     */ import java.math.BigInteger;
/*     */ import java.net.Proxy;
/*     */ import java.net.URL;
/*     */ import java.security.MessageDigest;
/*     */ import java.util.concurrent.CountDownLatch;
/*     */ import java.util.concurrent.atomic.AtomicBoolean;
/*     */ import javax.net.ssl.HttpsURLConnection;
/*     */ 
/*     */ public class Downloader implements Runnable
/*     */ {
/*     */   private static final int MAX_RETRIES = 10;
/*     */   private final Proxy proxy;
/*     */   private final String currentMd5;
/*     */   private final File targetFile;
/*     */   private final Controller controller;
/*     */   private Bootstrap bootstrap;
/*     */   
/*     */   public static class Controller
/*     */   {
/*  25 */     public final CountDownLatch foundUpdateLatch = new CountDownLatch(1);
/*  26 */     public final AtomicBoolean foundUpdate = new AtomicBoolean(false);
/*  27 */     public final CountDownLatch hasDownloadedLatch = new CountDownLatch(1);
/*     */   }
/*     */   
/*     */   public Downloader(Controller controller, Bootstrap bootstrap, Proxy proxy, String currentMd5, File targetFile) {
/*  31 */     this.controller = controller;
/*  32 */     this.bootstrap = bootstrap;
/*  33 */     this.proxy = proxy;
/*  34 */     this.currentMd5 = currentMd5;
/*  35 */     this.targetFile = targetFile;
/*     */   }
/*     */   
/*     */   public void run()
/*     */   {
/*  40 */     int retries = 0;
/*     */     for (;;) {
/*  42 */       retries++; if (retries > 10)
/*     */         break;
/*  44 */       try { URL url = new URL("https://s3.amazonaws.com/Minecraft.Download/launcher/launcher.pack.lzma");
/*     */         
/*  46 */         HttpsURLConnection connection = getConnection(url);
/*     */         
/*     */ 
/*  49 */         connection.setUseCaches(false);
/*  50 */         connection.setDefaultUseCaches(false);
/*  51 */         connection.setRequestProperty("Cache-Control", "no-store,max-age=0,no-cache");
/*  52 */         connection.setRequestProperty("Expires", "0");
/*  53 */         connection.setRequestProperty("Pragma", "no-cache");
/*  54 */         if (this.currentMd5 != null) {
/*  55 */           connection.setRequestProperty("If-None-Match", this.currentMd5.toLowerCase());
/*     */         }
/*     */         
/*     */ 
/*  59 */         connection.setConnectTimeout(30000);
/*  60 */         connection.setReadTimeout(10000);
/*     */         
/*  62 */         log("Downloading: https://s3.amazonaws.com/Minecraft.Download/launcher/launcher.pack.lzma" + (retries > 1 ? String.format(" (try %d/%d)", new Object[] { Integer.valueOf(retries), Integer.valueOf(10) }) : ""));
/*  63 */         long start = System.nanoTime();
/*  64 */         connection.connect();
/*  65 */         long elapsed = System.nanoTime() - start;
/*  66 */         log("Got reply in: " + elapsed / 1000000L + "ms");
/*     */         
/*  68 */         int code = connection.getResponseCode() / 100;
/*     */         
/*  70 */         if (code == 2)
/*     */         {
/*  72 */           String eTag = connection.getHeaderField("ETag");
/*     */           
/*     */ 
/*  75 */           if (eTag == null) {
/*  76 */             eTag = "-";
/*     */           }
/*     */           else {
/*  79 */             eTag = eTag.substring(1, eTag.length() - 1);
/*     */           }
/*     */           
/*     */ 
/*  83 */           this.controller.foundUpdate.set(true);
/*  84 */           this.controller.foundUpdateLatch.countDown();
/*     */           
/*  86 */           InputStream inputStream = connection.getInputStream();
/*  87 */           FileOutputStream outputStream = new FileOutputStream(this.targetFile);
/*     */           
/*  89 */           MessageDigest digest = MessageDigest.getInstance("MD5");
/*     */           
/*  91 */           long startDownload = System.nanoTime();
/*  92 */           long bytesRead = 0L;
/*  93 */           byte[] buffer = new byte[65536];
/*     */           try {
/*  95 */             int read = inputStream.read(buffer);
/*  96 */             while (read >= 1) {
/*  97 */               bytesRead += read;
/*  98 */               digest.update(buffer, 0, read);
/*  99 */               outputStream.write(buffer, 0, read);
/* 100 */               read = inputStream.read(buffer);
/*     */             }
/*     */           } finally {
/* 103 */             inputStream.close();
/* 104 */             outputStream.close();
/*     */           }
/* 106 */           long elapsedDownload = System.nanoTime() - startDownload;
/*     */           
/* 108 */           float elapsedSeconds = (float)(1L + elapsedDownload) / 1.0E9F;
/* 109 */           float kbRead = (float)bytesRead / 1024.0F;
/* 110 */           log(String.format("Downloaded %.1fkb in %ds at %.1fkb/s", new Object[] { Float.valueOf(kbRead), Integer.valueOf((int)elapsedSeconds), Float.valueOf(kbRead / elapsedSeconds) }));
/*     */           
/*     */ 
/* 113 */           String md5sum = String.format("%1$032x", new Object[] { new BigInteger(1, digest.digest()) });
/* 114 */           if ((!eTag.contains("-")) && (!eTag.equalsIgnoreCase(md5sum))) {
/* 115 */             log("After downloading, the MD5 hash didn't match. Retrying");
/*     */           }
/*     */           else {
/* 118 */             this.controller.hasDownloadedLatch.countDown();
/* 119 */             return;
/*     */           }
/* 121 */         } else if (code == 4) {
/* 122 */           log("Remote file not found.");
/*     */         } else {
/* 124 */           this.controller.foundUpdate.set(false);
/* 125 */           this.controller.foundUpdateLatch.countDown();
/* 126 */           log("No update found.");
/* 127 */           return;
/*     */         }
/*     */       } catch (Exception e) {
/* 130 */         log("Exception: " + e.toString());
/* 131 */         suggestHelp(e);
/*     */       }
/*     */     }
/*     */     
/* 135 */     log("Unable to download remote file. Check your internet connection/proxy settings.");
/*     */   }
/*     */   
/*     */   public void suggestHelp(Throwable t) {
/* 139 */     if ((t instanceof java.net.BindException)) {
/* 140 */       log("Recognized exception: the likely cause is a broken ipv4/6 stack. Check your TCP/IP settings.");
/* 141 */     } else if ((t instanceof javax.net.ssl.SSLHandshakeException)) {
/* 142 */       log("Recognized exception: the likely cause is a set of broken/missing root-certificates. Check your java install and perhaps reinstall it.");
/*     */     }
/*     */   }
/*     */   
/*     */   public void log(String str) {
/* 147 */     this.bootstrap.println(str);
/*     */   }
/*     */   
/*     */   public HttpsURLConnection getConnection(URL url) throws java.io.IOException {
/* 151 */     return (HttpsURLConnection)url.openConnection(this.proxy);
/*     */   }
/*     */ }


/* Location:              M:\AFolderOfMinecraft\Minecraft.jar!\net\minecraft\bootstrap\Downloader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */