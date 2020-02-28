package com.solvd.argwinterlab.navigator.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.solvd.argwinterlab.navigator.database.model.Path;
import com.solvd.argwinterlab.navigator.database.model.Station;

public class Graph {
	private Map<String, Node<Station>> nodes = new HashMap<String, Node<Station>>();

	public Graph() {}

	public void addPath(Path path) {

		Node<Station> node1 = new Node<Station>(path.getOrigin());
		Node<Station> node2 = new Node<Station>(path.getDestiny());

		node1.addNeighbor(node2);
		node2.addNeighbor(node1);

		nodes.put(node1.getT().getName(), node1);
		nodes.put(node2.getT().getName(), node2);
	}

	public List<String> shortestPath(String startNodeName, String endNodeName) {
		Map<String, String> parents = new HashMap<String, String>();
		List<Node<Station>> temp = new ArrayList<Node<Station>>();

		Node<Station> start = nodes.get(startNodeName);
		temp.add(start);
		parents.put(startNodeName, null);

		while (temp.size() > 0) {
			Node<Station> currentNode = temp.get(0);
			List<Node<Station>> neighbors = currentNode.getNeighbors();

			for (int i = 0; i < neighbors.size(); i++) {
				Node<Station> neighbor = neighbors.get(i);
				String nodeName = neighbor.getT().getName();

				boolean visited = parents.containsKey(nodeName);
				if (visited) {
					continue;
				} else {
					temp.add(neighbor);

					parents.put(nodeName, currentNode.getT().getName());

					if (nodeName.equals(endNodeName)) {
						System.out.println(parents);
						return getPath(parents, endNodeName);
					}
				}
			}

			temp.remove(0);
		}

		return null;
	}

	private List<String> getPath(Map<String, String> parents, String endNodeName) {
		List<String> path = new ArrayList<String>();
		String node = endNodeName;
		while (node != null) {
			path.add(0, node);
			String parent = parents.get(node);
			node = parent;
		}
		return path;
	}
}