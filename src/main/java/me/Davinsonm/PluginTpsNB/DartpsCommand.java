package me.Davinsonm.PluginTpsNB;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DartpsCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        // Verificar si el comando se ejecuta desde la consola o por un OP
        if (!(sender instanceof Player) || sender.isOp()) {
            if (args.length != 2) {
                sender.sendMessage("§cUso correcto: /dartps <jugador> <cantidad>");
                return false;
            }

            @SuppressWarnings("deprecation")
			Player target = Bukkit.getPlayerExact(args[0]); // Buscar jugador exacto
            if (target == null) {
                sender.sendMessage("§cEl jugador no está en línea.");
                return false;
            }

            int amount;
            try {
                amount = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                sender.sendMessage("§cCantidad inválida.");
                return false;
            }

            // Ejecutar el comando "jrmctp" desde la consola en lugar del jugador
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "jrmctp " + amount + " " +target.getName());

            // Mensaje de feedback
            String color = (amount >= 0) ? "§a+" : "§c";
            target.sendMessage(color + amount + " TPs!");

            sender.sendMessage("§aSe han otorgado " + amount + " TPs a " + target.getName());

            return true;
        } else {
            sender.sendMessage("§cNo tienes permiso para ejecutar este comando.");
            return false;
        }
    }
}

/*package me.Davinsonm.PluginTpsNB;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DartpsCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        // Permitir ejecución solo por la consola o por jugadores OP
        if (!(sender instanceof Player) || sender.isOp()) {
            if (args.length != 2) {
                sender.sendMessage("§cUso correcto: /dartps <jugador> <cantidad>");
                return false;
            }

            @SuppressWarnings("deprecation")
			Player target = Bukkit.getPlayerExact(args[0]); // Buscar jugador exacto
            if (target == null) {
                sender.sendMessage("§cEl jugador no está en línea.");
                return false;
            }

            int amount;
            try {
                amount = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                sender.sendMessage("§cCantidad inválida.");
                return false;
            }

            // Ejecutar comando en el jugador
            target.performCommand("jrmctp " + amount);

            // Mensaje de feedback
            String color = (amount >= 0) ? "§a+" : "§c";
            target.sendMessage(color + amount + " TPs!");

            return true;
        } else {
            sender.sendMessage("§cNo tienes permiso para ejecutar este comando.");
            return false;
        }
    }
}*/


/*package me.Davinsonm.PluginTpsNB;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DartpsCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length != 2) {
            sender.sendMessage("§cUso correcto: /dartps <jugador> <cantidad>");
            return false;
        }

        @SuppressWarnings("deprecation")
		Player target = Bukkit.getPlayerExact(args[0]); // Más eficiente que recorrer todos los jugadores
        if (target == null) {
            sender.sendMessage("§cEl jugador no está en línea.");
            return false;
        }

        int amount;
        try {
            amount = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            sender.sendMessage("§cCantidad inválida.");
            return false;
        }

        // Si es posible, usa la API de DBC en lugar de performCommand
        target.performCommand("jrmctp " + amount);

        // Mensaje de feedback formateado correctamente
        String color = (amount >= 0) ? "§a+" : "§c";
        target.sendMessage(color + amount + " TPs!");

        return true;
    }
}
*/
