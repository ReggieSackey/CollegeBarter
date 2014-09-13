package com.hacks.collegebarter;

public class NavDrawerItems {
    
   private String title;
   private int icon;
   private String count = "0";
   // boolean to set visiblity of the counter
   private boolean isCounterVisible = false;
    
   public NavDrawerItems(){}

   public NavDrawerItems(String title, int icon){
       this.title = title;
       this.icon = icon;
   }
    
   public NavDrawerItems(String title, int icon, boolean isCounterVisible, String count){
       this.title = title;
       this.icon = icon;
       this.isCounterVisible = isCounterVisible;
       this.count = count;
   }
    
   public String getTitle(){
       return this.title;
   }
    
   public int getIcon(){
       return this.icon;
   }
    
   public boolean getCounterVisibility(){
       return this.isCounterVisible;
   }
    
   public void setTitle(String title){
       this.title = title;
   }
    
   public void setIcon(int icon){
       this.icon = icon;
   }
    
   public void setCount(String count){
       this.count = count;
   }

}