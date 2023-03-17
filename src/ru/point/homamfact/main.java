package ru.point.homamfact;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin {
    private Map<UUID, String> playerFactions = new HashMap<>();
    private YamlConfiguration playerData;

    @Override
    public void onEnable() {
        // При загрузке плагина, можно выполнить некоторые действия, например, зарегистрировать обработчики событий
        getCommand("faction").setExecutor(this);
        getCommand("joinfaction").setExecutor(this);
        getCommand("leavefaction").setExecutor(this);
        this.getLogger().info("Плагин HoMaM-Factions создан индивидуально для использования на сервере HoMaM 3 Server");

        // Загрузка данных из файла
        File file = new File(getDataFolder(), "playerData.yml");
        if (file.exists()) {
            playerData = YamlConfiguration.loadConfiguration(file);
            for (String key : playerData.getKeys(false)) {
                UUID uuid = UUID.fromString(key);
                String faction = playerData.getString(key);
                playerFactions.put(uuid, faction);
            }
        } else {
            playerData = new YamlConfiguration();
        }
    }

    @Override
    public void onDisable() {
        // При выключении плагина, можно выполнить некоторые действия, например, сохранить данные

        // Сохранение данных в файл
        File file = new File(getDataFolder(), "playerData.yml");
        for (Map.Entry<UUID, String> entry : playerFactions.entrySet()) {
            playerData.set(entry.getKey().toString(), entry.getValue());
        }
        try {
            playerData.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (command.getName().equalsIgnoreCase("joinfaction")) {
            if (args.length == 1) {
                String[] validFactions = {"замок", "оплот", "башня", "инферно", "некрополис", "подземелье", "цитадель", "крепость"};
                List<String> completions = new ArrayList<>();
                for (String validFaction : validFactions) {
                    if (validFaction.startsWith(args[0].toLowerCase())) {
                        completions.add(validFaction);
                    }
                }
                return completions;
            }
        }
        return null;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Команда может быть выполнена только игроком.");
            return false;
        }

        Player player = (Player) sender;

        if (command.getName().equalsIgnoreCase("joinfaction")) {
            if (args.length == 0) {
                player.sendMessage("Укажите фракцию, к которой хотите присоединиться.");
                return false;
            }

            if (playerFactions.containsKey(player.getUniqueId())) {
                player.sendMessage("Вы уже присоединились к фракции.");
                return false;
            }

            String faction = args[0].toLowerCase();

            if (!isValidFaction(faction)) {
                player.sendMessage("Неправильная фракция. Доступные фракции: замок, оплот, башня, инферно, некрополис, подземелье, цитадель, крепость.");
                return false;
            }

            playerFactions.put(player.getUniqueId(), faction);
            player.sendMessage("Вы присоединились к фракции " + faction + ".");
            if (playerFactions.get(player.getUniqueId()) == "замок")
            {
                Location spawnLocation = new Location(player.getWorld(), 0, 64, 0); // Устанавливаем координаты точки возрождения
                player.setBedSpawnLocation(spawnLocation, true); // Устанавливаем точку возрождения игрока
                player.teleport(spawnLocation); // Телепортируем игрока на точку возрождения
            }
            else if (playerFactions.get(player.getUniqueId()) == "оплот")
            {
                Location spawnLocation = new Location(player.getWorld(), 0, 64, 0); // Устанавливаем координаты точки возрождения
                player.setBedSpawnLocation(spawnLocation, true); // Устанавливаем точку возрождения игрока
                player.teleport(spawnLocation); // Телепортируем игрока на точку возрождения
            }
            else if (playerFactions.get(player.getUniqueId()) == "башня")
            {
                Location spawnLocation = new Location(player.getWorld(), 0, 64, 0); // Устанавливаем координаты точки возрождения
                player.setBedSpawnLocation(spawnLocation, true); // Устанавливаем точку возрождения игрока
                player.teleport(spawnLocation); // Телепортируем игрока на точку возрождения
            }
            else if (playerFactions.get(player.getUniqueId()) == "инферно")
            {
                Location spawnLocation = new Location(player.getWorld(), 0, 64, 0); // Устанавливаем координаты точки возрождения
                player.setBedSpawnLocation(spawnLocation, true); // Устанавливаем точку возрождения игрока
                player.teleport(spawnLocation); // Телепортируем игрока на точку возрождения
            }
            else if (playerFactions.get(player.getUniqueId()) == "некрополис")
            {
                Location spawnLocation = new Location(player.getWorld(), 0, 64, 0); // Устанавливаем координаты точки возрождения
                player.setBedSpawnLocation(spawnLocation, true); // Устанавливаем точку возрождения игрока
                player.teleport(spawnLocation); // Телепортируем игрока на точку возрождения
            }
            else if (playerFactions.get(player.getUniqueId()) == "плдземелье")
            {
                Location spawnLocation = new Location(player.getWorld(), 0, 64, 0); // Устанавливаем координаты точки возрождения
                player.setBedSpawnLocation(spawnLocation, true); // Устанавливаем точку возрождения игрока
                player.teleport(spawnLocation); // Телепортируем игрока на точку возрождения
            }
            else if (playerFactions.get(player.getUniqueId()) == "цитадель")
            {
                Location spawnLocation = new Location(player.getWorld(), 0, 64, 0); // Устанавливаем координаты точки возрождения
                player.setBedSpawnLocation(spawnLocation, true); // Устанавливаем точку возрождения игрока
                player.teleport(spawnLocation); // Телепортируем игрока на точку возрождения
            }
            else if (playerFactions.get(player.getUniqueId()) == "крепость")
            {
                Location spawnLocation = new Location(player.getWorld(), 0, 64, 0); // Устанавливаем координаты точки возрождения
                player.setBedSpawnLocation(spawnLocation, true); // Устанавливаем точку возрождения игрока
                player.teleport(spawnLocation); // Телепортируем игрока на точку возрождения
            }
            return true;
        } else if (command.getName().equalsIgnoreCase("leavefaction")) {
            if (!playerFactions.containsKey(player.getUniqueId())) {
                player.sendMessage("Вы не присоединились к никакой фракции.");
            } else {
                String faction = playerFactions.get(player.getUniqueId());
                playerFactions.remove(player.getUniqueId());
                player.sendMessage("Вы покинули фракцию " + faction + ".");
            }
            return true;
        } else if (command.getName().equalsIgnoreCase("faction")) {
            if (!playerFactions.containsKey(player.getUniqueId())) {
                player.sendMessage("Вы не присоединились к никакой фракции.");
            } else {
                String faction = playerFactions.get(player.getUniqueId());
                player.sendMessage("Вы принадлежите к фракции " + faction + ".");
            }
            return true;
        }

        return false;
    }

    private boolean isValidFaction(String faction) {
        String[] validFactions = {"замок", "оплот", "башня", "инферно", "некрополис", "подземелье", "цитадель", "крепость"};
        for (String validFaction : validFactions) {
            if (validFaction.equals(faction)) {
                return true;
            }
        }
        return false;
    }
}