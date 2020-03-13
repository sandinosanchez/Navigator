package com.solvd.argwinterlab.navigator.algorithm;

import java.util.*;

import com.solvd.argwinterlab.navigator.db.dao.PathMapper;
import com.solvd.argwinterlab.navigator.db.model.Path;
import com.solvd.argwinterlab.navigator.db.model.Station;
import com.solvd.argwinterlab.navigator.db.services.PathService;
import com.solvd.argwinterlab.navigator.db.services.StationService;
import com.solvd.argwinterlab.navigator.db.services.StationServiceMyBatis;
import org.apache.ibatis.session.SqlSession;

public class PathSearch {

	private static Map<Station, Result> shortestPath(Station originStation, Station destinyStation, SqlSession session) {
		List<Station> visited = new ArrayList<>();
		Map<Station, Result> result = new HashMap<>();
		List<Station> toVisit = new ArrayList<>();

		toVisit.add(originStation);
		result.put(originStation, null);

		while (toVisit.size() > 0) {
			Station currentStation = toVisit.get(0);
			PathMapper pathMapper = initPathMapperSession(session);
			for (Path path : pathMapper.findAllByStationId(currentStation.getId())) {
				if (!visited.contains(path.getDestiny())) {
					toVisit.add(path.getDestiny());
					if (currentStation.equals(originStation)) {
						result.put(path.getDestiny(), Result.initResult(currentStation, path.getTransport()));
					} else {
						// for the same transport
						if (path.getTransports().contains(result.get(currentStation).getTransport())) {
							int var = path.getTransports().indexOf(result.get(currentStation).getTransport());
							result.put(path.getDestiny(), Result.initResult(currentStation, path.getTransports().get(var)));
						} else {
							result.put(path.getDestiny(), Result.initResult(currentStation, path.getTransport()));
						}
					}
					if (path.getDestiny().equals(destinyStation)) {
						return result;
					}
				}
			}
			visited.add(currentStation);
			toVisit.remove(0);
		}
		HashMap<Station , Result> map = new HashMap<>();
		map.put(new Station(), new Result());
		return map;
	}

	private static PathMapper initPathMapperSession(SqlSession session) {
		return session.getMapper(PathMapper.class);
	}

	public static List<Result> getPath(Station origin, Station destiny, SqlSession session) {
		List<Result> result = new ArrayList<>();
		if (origin.equals(destiny)) {
			result.add(Result.initResult(origin, null));
			return result;
		}

		Map <Station, Result> resultMap = shortestPath(origin, destiny, session);

		if (Objects.nonNull(resultMap)) {
			Station actualStation = destiny;
			result.add(Result.initResult(actualStation, null));
			while (resultMap.get(actualStation) != null) {
				result.add(0, resultMap.get(actualStation));
				actualStation = resultMap.get(actualStation).getOrigin();
			}
		} else {
			result.add(Result.initResult(origin, null));
			result.add(Result.initResult(destiny, null));
		}
		return result;
	}
}