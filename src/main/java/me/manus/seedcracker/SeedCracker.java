package me.manus.seedcracker;

import com.mojang.logging.LogUtils;
import me.manus.seedcracker.api.SeedCrackerAPI;
import me.manus.seedcracker.config.Config;
import me.manus.seedcracker.cracker.storage.DataStorage;
import me.manus.seedcracker.finder.FinderQueue;
import me.manus.seedcracker.init.ClientCommands;
import me.manus.seedcracker.util.Database;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;

import java.util.ArrayList;

public class SeedCracker implements ModInitializer {
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final ArrayList<SeedCrackerAPI> entrypoints = new ArrayList<>();
    private static SeedCracker INSTANCE;
    private final DataStorage dataStorage = new DataStorage();

    public static SeedCracker get() {
        return INSTANCE;
    }

    @Override
    public void onInitialize() {
        INSTANCE = this;
        Config.load();
        Features.init(Config.get().getVersion());
        FabricLoader.getInstance().getEntrypointContainers("seedcrackerkiller", SeedCrackerAPI.class).forEach(entrypoint ->
                entrypoints.add(entrypoint.getEntrypoint()));

        FinderQueue.registerEvents();

        ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> ClientCommands.registerCommands(dispatcher));

        Database.fetchSeeds();
    }

    public DataStorage getDataStorage() {
        return this.dataStorage;
    }

    public void reset() {
        SeedCracker.get().getDataStorage().clear();
        FinderQueue.get().finderControl.deleteFinders();
    }
}
