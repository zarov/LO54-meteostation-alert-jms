package fr.utbm.core.service;

import java.util.Date;
import java.util.List;

import fr.utbm.core.dao.StationDao;
import fr.utbm.core.entity.Area;
import fr.utbm.core.entity.Station;

/**
 * @author Adrien Berthet <adrien.berthet@utbm.fr>
 * @package fr.utbm.core.service
 */
public class StationService {
	public void addStation(Station t) {
		StationDao dao = new StationDao();
		dao.addStation(t);
	}

	public void addStation(String label, Area area, boolean valid) {
		Station s = new Station();
		s.setLabel(label);
		s.setArea(area);
		s.setValid(valid);
		addStation(s);
	}

	public void addStation(String label, Area area, boolean valid, Date lastCom) {
		Station s = new Station();
		s.setLabel(label);
		s.setArea(area);
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

	public List<Station> getAllStations() {
		StationDao dao = new StationDao();
		return dao.getAllStations();
	}

	public List<Station> getAllStationsByAreaId(int id) {
		StationDao dao = new StationDao();
		return dao.getAllStationsByAreaId(id);
	}
}
