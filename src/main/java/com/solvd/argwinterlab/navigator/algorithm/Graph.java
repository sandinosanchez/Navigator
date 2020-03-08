package com.solvd.argwinterlab.navigator.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.solvd.argwinterlab.navigator.db.model.Path;
import com.solvd.argwinterlab.navigator.db.model.Station;

public class Graph {
	private Map<String, Vertex<Station>> nodes;

	public Graph() {
		this.nodes = new HashMap<>();
	}

	public void addPath(Path path) {

//		Vertex<Station> origin = new Vertex<>(path.getOrigin());
		Vertex<Station> destiny = new Vertex<>(path.getDestiny());

//		origin.addNeighbor(destiny);
//		destiny.addNeighbor(origin);

//		nodes.put(origin.getData().getName(), origin);
		nodes.put(destiny.getData().getName(), destiny);
	}

	public List<String> shortestPath(String originStation, String destinyStation) {
		Map<String, String> parents = new HashMap<>();
		List<Vertex<Station>> temp = new ArrayList<>();

		temp.add(nodes.get(originStation));
		parents.put(originStation, null);

		while (temp.size() > 0) {
			Vertex<Station> currentVertex = temp.get(0);
			List<Vertex<Station>> neighbors = currentVertex.getNeighbors();

			for (Vertex<Station> neighbor : neighbors) {
				String neighborStationName = neighbor.getData().getName();

				if (!parents.containsKey(neighborStationName)) {
					temp.add(neighbor);
					parents.put(neighborStationName, currentVertex.getData().getName());
					if (neighborStationName.equals(destinyStation)) {
						return getPath(parents, destinyStation);
					}
				}
			}
			temp.remove(0);
		}
		return null;
	}

	private List<String> getPath(Map<String, String> parents, String endNodeName) {
		List<String> path = new ArrayList<>();
		String node = endNodeName;
		while (node != null) {
			path.add(0, node);
			node = parents.get(node);
		}
		return path;
	}
}