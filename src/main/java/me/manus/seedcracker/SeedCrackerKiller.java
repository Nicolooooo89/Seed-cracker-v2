package me.manus.seedcracker;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SeedCrackerKiller implements ModInitializer {
    public static final String MOD_ID = "seedcrackerkiller";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Caricamento moduli SeedCrackerKiller...");
    }
}
