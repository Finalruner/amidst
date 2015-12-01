package amidst.minecraft.world;

import java.util.List;

import amidst.minecraft.world.object.CachedWorldObjectProducer;
import amidst.minecraft.world.object.NetherFortressProducer;
import amidst.minecraft.world.object.OceanMonumentProducer;
import amidst.minecraft.world.object.PlayerProducer;
import amidst.minecraft.world.object.SpawnProducer;
import amidst.minecraft.world.object.StrongholdProducer;
import amidst.minecraft.world.object.TempleProducer;
import amidst.minecraft.world.object.VillageProducer;
import amidst.minecraft.world.object.WorldIcon;
import amidst.minecraft.world.object.WorldIconProducer;

public abstract class World {
	private final BiomeDataOracle biomeDataOracle = new BiomeDataOracle();
	private final SlimeChunkOracle slimeChunkOracle = new SlimeChunkOracle(this);
	private final WorldIconProducer oceanMonumentProducer = new OceanMonumentProducer(
			this);
	private final WorldIconProducer templeProducer = new TempleProducer(this);
	private final WorldIconProducer villageProducer = new VillageProducer(
			this);
	private final WorldIconProducer netherFortressProducer = new NetherFortressProducer(
			this);
	private final CachedWorldObjectProducer playerProducer = new PlayerProducer(
			this);
	private final CachedWorldObjectProducer spawnProducer = new SpawnProducer(
			this);
	private final CachedWorldObjectProducer strongholdProducer = new StrongholdProducer(
			this);

	public BiomeDataOracle getBiomeDataOracle() {
		return biomeDataOracle;
	}

	public SlimeChunkOracle getSlimeChunkOracle() {
		return slimeChunkOracle;
	}

	public WorldIconProducer getOceanMonumentProducer() {
		return oceanMonumentProducer;
	}

	public WorldIconProducer getTempleProducer() {
		return templeProducer;
	}

	public WorldIconProducer getVillageProducer() {
		return villageProducer;
	}

	public WorldIconProducer getNetherFortressProducer() {
		return netherFortressProducer;
	}

	public CachedWorldObjectProducer getPlayerProducer() {
		return playerProducer;
	}

	public CachedWorldObjectProducer getSpawnProducer() {
		return spawnProducer;
	}

	public CachedWorldObjectProducer getStrongholdProducer() {
		return strongholdProducer;
	}

	public List<WorldIcon> getPlayers() {
		return playerProducer.getWorldObjects();
	}

	public WorldIcon getSpawn() {
		return spawnProducer.getFirstWorldObject();
	}

	public List<WorldIcon> getStrongholds() {
		return strongholdProducer.getWorldObjects();
	}

	public void reloadPlayers() {
		playerProducer.resetCache();
	}

	@Deprecated
	public boolean hasPlayers() {
		return isFileWorld();
	}

	@Deprecated
	public boolean isFileWorld() {
		return this instanceof FileWorld;
	}

	@Deprecated
	public FileWorld getAsFileWorld() {
		return (FileWorld) this;
	}

	public abstract long getSeed();

	public abstract String getSeedText();

	public abstract WorldType getWorldType();
}
