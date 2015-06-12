package fr.utbm.core.service;

import fr.utbm.core.dao.AreaDao;
import fr.utbm.core.entity.Area;

/**
 * @author Adrien Berthet <adrien.berthet@utbm.fr>
 * @package fr.utbm.core.service
 */
public class AreaService {
	public void addArea(Area a) {
		AreaDao dao = new AreaDao();
		dao.addArea(a);
	}

	public void addArea(String label) {
		Area a = new Area();
		a.setLabel(label);
		a.setRoad("");
		addArea(a);
	}

	public void addArea(String label, String road) {
		Area a = new Area();
		a.setLabel(label);
		a.setRoad(road);
		addArea(a);
	}

	public Area getAreaById(int id) {
		AreaDao dao = new AreaDao();
		return dao.getAreaById(id);
	}

	public void deleteAreaById(int id) {
		AreaDao dao = new AreaDao();
		dao.deleteAreaById(id);
	}
}
