/*   */ package net.minecraft.hopper;
/*   */ 
/*   */ public class PublishRequest {
/*   */   private String token;
/*   */   private int report_id;
/*   */   
/*   */   public PublishRequest(Report report) {
/* 8 */     this.report_id = report.getId();
/* 9 */     this.token = report.getToken();
/*   */   }
/*   */ }


/* Location:              M:\AFolderOfMinecraft\Minecraft.jar!\net\minecraft\hopper\PublishRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */