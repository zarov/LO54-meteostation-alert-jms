package fr.utbm.core.service;

import java.util.Date;

import fr.utbm.core.dao.StationDao;
import fr.utbm.core.entity.Station;

/**
 * @author zarov
 * @package fr.utbm.core.service
 */
public class StationService {
	public void addStation(Station t) {
		StationDao dao = new StationDao();
		dao.addStation(t);
	}

	public void addStation(String label, int areaId, int valid) {
		Station s = new Station();
		s.setLabel(label);
		s.setAreaId(areaId);
		s.setValid(valid);
		addStation(s);
	}

	public void addStation(String label, int areaId, int valid, Date lastCom) {
		Station s = new Station();
		s.setLabel(label);
		s.setAreaId(areaId);
		s.setValid(valid);
		s.setLastCom(lastCom);
		addStation(s);
	}

	public Station getStationById(int id) {
		StationDao dao = new StationDao();
		return dao.getStationById(id);
	}

	public void deleteStationById(int id) {
		StationDao dao = new StationDao();
		dao.deleteStationById(id);
	}
}
