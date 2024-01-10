package online.magicksaddon.magicsaddonmod.network.cts;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.network.NetworkEvent;
import online.kingdomkeys.kingdomkeys.capability.IPlayerCapabilities;
import online.kingdomkeys.kingdomkeys.capability.ModCapabilities;
import online.kingdomkeys.kingdomkeys.lib.SoAState;
import online.kingdomkeys.kingdomkeys.network.PacketHandler;
import online.kingdomkeys.kingdomkeys.util.Utils;
import online.kingdomkeys.kingdomkeys.network.stc.SCSyncCapabilityPacket;
import online.magicksaddon.magicsaddonmod.capabilities.IPlayerCapabilitiesX;
import online.magicksaddon.magicsaddonmod.capabilities.ModCapabilitiesX;
import online.magicksaddon.magicsaddonmod.network.PacketHandlerX;
import online.magicksaddon.magicsaddonmod.network.stc.SCSyncCapabilityPacketX;
import org.apache.logging.log4j.core.jmx.Server;

import java.util.function.Supplier;

public class CSPrestigePacket {



    public CSPrestigePacket(){}

    public void encode(FriendlyByteBuf buffer) {

    }

    public static CSPrestigePacket decode(FriendlyByteBuf buffer) {
        CSPrestigePacket msg = new CSPrestigePacket();

        return msg;
    }

    public static void handle(final CSPrestigePacket message, Supplier<NetworkEvent.Context> ctx) {
        Player player = ctx.get().getSender();

        //IPlayerCapabilitiesX playerData = ModCapabilitiesX.getPlayer(player);
        IPlayerCapabilities playerData = ModCapabilities.getPlayer(player);
        Utils.restartLevel(playerData, player);
        //

        // Choice Reset Here
        playerData.setSoAState(SoAState.NONE);
        PacketHandler.sendTo(new SCSyncCapabilityPacket(playerData), (ServerPlayer) player);
        ctx.get().setPacketHandled(true);
    }
}
