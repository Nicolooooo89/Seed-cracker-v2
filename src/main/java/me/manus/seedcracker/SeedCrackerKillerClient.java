package me.manus.seedcracker;

import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SeedCrackerKillerClient implements ClientModInitializer {
    public static final String MOD_ID = "seedcrackerkiller";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitializeClient() {
        LOGGER.info("SeedCrackerKiller inizializzato per Minecraft 1.21.11!");
    }
}
