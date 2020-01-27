package me.kici33.ItemFrame.commands;

import me.kici33.ItemFrame.managers.ShopItemManager;
import me.kici33.ItemFrame.objects.ShopItem;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Player;
import java.util.concurrent.atomic.AtomicInteger;

public class LoadSigns implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (!sender.hasPermission("KItemFrame.loadsigns")) {
            sender.sendMessage("§cUgh, I think you don't have permission to use that command ;/");
            return false;
        }
        Player p = (Player) sender;
        World w = p.getWorld();
        AtomicInteger i = new AtomicInteger();
        w.getEntities().forEach(entity -> {
            if (entity instanceof ItemFrame) {
                ItemFrame frame = (ItemFrame) entity;
                ShopItem item = ShopItemManager.isSpecified(frame.getItem());
                if (item != null) {
                    if(item.isBuyDefined()) {
                        i.getAndIncrement();
                        Location loc = frame.getLocation().add(0, 1, 0);
                        Block block = loc.getBlock();
                        block.setType(Material.WALL_SIGN);
                        //Double Check if Block was replaced as Sign
                        if(block.getType() == Material.WALL_SIGN) {
                            Sign sign = (Sign) block.getState();
                            org.bukkit.material.Sign sign2 = new org.bukkit.material.Sign(Material.WALL_SIGN);
                            sign2.setFacingDirection(frame.getFacing());
                            sign.setData(sign2);
                            sign.setLine(0, "§1[Buy]");
                            sign.setLine(1, item.getBuyAmount());
                            sign.setLine(2, "" + item.getID() + (item.getData() == 0 ? "" : ":" + item.getData()));
                            sign.setLine(3, item.getBuyPrice());
                            sign.update();
                        }
                    }
                    if(item.isSellDefined()) {
                        i.getAndIncrement();
                        Location loc = frame.getLocation().subtract(0, 1, 0);
                        Block block = loc.getBlock();
                        block.setType(Material.WALL_SIGN);
                        //Double Check if Block was replaced as Sign
                        if(block.getType() == Material.WALL_SIGN) {
                            Sign sign = (Sign) block.getState();
                            org.bukkit.material.Sign sign2 = new org.bukkit.material.Sign(Material.WALL_SIGN);
                            sign2.setFacingDirection(frame.getFacing());
                            sign.setData(sign2);
                            sign.setLine(0, "§1[Sell]");
                            sign.setLine(1, item.getSellAmount());
                            sign.setLine(2, "" + item.getID() + (item.getData() == 0 ? "" : ":" + item.getData()));
                            sign.setLine(3, item.getSellPrice());
                            sign.update();
                        }
                    }
                }
            }
        });
        sender.sendMessage("§cSuccessfully Placed " + i + " signs!");
        return false;
    }
}