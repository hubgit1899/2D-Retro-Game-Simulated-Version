import java.io.*;
import java.util.*;

public class TileParser {
    private static final Map<String, Boolean> tileData = new HashMap<>();
    private static final List<List<Integer>> worldMap = new ArrayList<>();

    public static void loadTileData(String tileFile) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(tileFile));
        String line;
        while ((line = br.readLine()) != null) {
            String tile = line.trim();
            Boolean walkable = Boolean.parseBoolean(br.readLine().trim());
            tileData.put(tile, walkable);
        }
        br.close();
    }

    public static void loadWorldMap(String mapFile) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(mapFile));
        String line;
        while ((line = br.readLine()) != null) {
            String[] tiles = line.split(" ");
            List<Integer> row = new ArrayList<>();
            for (String tile : tiles) {
                row.add(Integer.parseInt(tile));
            }
            worldMap.add(row);
        }
        br.close();
    }

    public static boolean isWalkable(int tileId) {
        return tileData.getOrDefault(String.format("%03d.png", tileId), false);
    }

    public static List<List<Integer>> getWorldMap() {
        return worldMap;
    }
}
