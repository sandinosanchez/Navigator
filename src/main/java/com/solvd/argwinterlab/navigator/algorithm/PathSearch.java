package com.solvd.argwinterlab.navigator.algorithm;

import java.util.*;

import com.solvd.argwinterlab.navigator.db.dao.PathMapper;
import com.solvd.argwinterlab.navigator.db.model.Path;
import com.solvd.argwinterlab.navigator.db.model.Station;
import com.solvd.argwinterlab.navigator.db.model.Taxi;
import org.apache.ibatis.session.SqlSession;

public class PathSearch {

	private Set<Station> visited;
	private Map<Station, Result> resultMap;
	private List<Station> toVisit;
	private SqlSession session;
	private PathMapper pathMapper;

	public PathSearch() {}

	public PathSearch(SqlSession session) {
		this.visited = new HashSet<>();
		this.resultMap = new HashMap<>();
		this.toVisit = new ArrayList<>();
		this.session = session;
		this.pathMapper = initPathMapperSession(session);

	}

	private Map<Station, Result> shortestPath(Station originStation, Station destinyStation) {
		toVisit.add(originStation);
		resultMap.put(originStation, null);

		while (toVisit.size() > 0) {
			Station currentStation = toVisit.get(0);
			for (Path path : pathMapper.findAllByStationId(currentStation.getId())) {
				if (!visited.contains(path.getDestiny())) {
					toVisit.add(path.getDestiny());
					if (currentStation.equals(originStation)) {
						resultMap.put(path.getDestiny(), Result.initResult(currentStation, path.getTransport()));
					} else {
						// for the same transport
						if (path.getTransports().contains(resultMap.get(currentStation).getTransport())) {
							int var = path.getTransports().indexOf(resultMap.get(currentStation).getTransport());
							resultMap.put(path.getDestiny(), Result.initResult(currentStation, path.getTransports().get(var)));
						} else {
							resultMap.put(path.getDestiny(), Result.initResult(currentStation, path.getTransport()));
						}
					}
					if (path.getDestiny().equals(destinyStation)) {
						return resultMap;
					}
				}
			}
			visited.add(currentStation);
			toVisit.remove(0);
		}
		return null;
	}

	private static PathMapper initPathMapperSession(SqlSession session) {
		return session.getMapper(PathMapper.class);
	}

	public  List<Result> getPath(Station origin, Station destiny) {
		List<Result> result = new ArrayList<>();
		if (origin.equals(destiny)) {
			result.add(Result.initResult(origin, null));
			return result;
		}

		Map <Station, Result> resultMap = shortestPath(origin, destiny);

		if (Objects.nonNull(resultMap)) {
			Station actualStation = destiny;
			result.add(Result.initResult(actualStation, null));
			while (resultMap.get(actualStation) != null) {
				result.add(0, resultMap.get(actualStation));
				actualStation = resultMap.get(actualStation).getOrigin();
			}
		} else {
			result.add(Result.initResult(origin, new Taxi("Uber")));
			result.add(Result.initResult(destiny, null));
		}
		return result;
	}

	public Set<Station> getVisited() {
		return visited;
	}

	public void setVisited(Set<Station> visited) {
		this.visited = visited;
	}

	public Map<Station, Result> getResultMap() {
		return resultMap;
	}

	public void setResultMap(Map<Station, Result> resultMap) {
		this.resultMap = resultMap;
	}

	public List<Station> getToVisit() {
		return toVisit;
	}

	public void setToVisit(List<Station> toVisit) {
		this.toVisit = toVisit;
	}

	public SqlSession getSession() {
		return session;
	}

	public void setSession(SqlSession session) {
		this.session = session;
	}
}