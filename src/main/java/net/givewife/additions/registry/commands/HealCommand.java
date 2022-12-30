package net.givewife.additions.registry.commands;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;

public class HealCommand extends CustomCommand {

    @Override
    public void register() {

        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> dispatcher.register(literal("heal").executes(

                context -> {

                    context.getSource().getEntity();
                    if(helper.isPlayer(context.getSource().getEntity())) {

                        PlayerEntity entity = (PlayerEntity) context.getSource().getEntity();
                        entity.heal(entity.getMaxHealth() - entity.getHealth());

                    }

                    return 1;

                }

        )));

    }

}
