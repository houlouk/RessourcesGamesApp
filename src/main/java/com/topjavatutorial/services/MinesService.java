package com.topjavatutorial.services;

import com.topjavatutorial.dao.Dao;
import com.topjavatutorial.dao.ExtractionDao;
import com.topjavatutorial.dao.IMineDao;
import com.topjavatutorial.dao.MineDao;
import com.topjavatutorial.model.Extraction;
import com.topjavatutorial.model.Mine;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 * Root resource (exposed at "players" path)
 */
@Path("/mines")
public class MinesService {
  private Dao<Mine> mineDao = new MineDao();
  private Dao<Extraction> extractionDao = new ExtractionDao();

  @Consumes("application/json")
  @POST
  @Path("/addExtraction/{id}")
  public Response addExtraction(@PathParam("id") int id) {
    Mine mine = mineDao.get(id);

    Extraction e = new Extraction();
    mine.extract(e);

    extractionDao.add(e);

    ((IMineDao) mineDao).addExtraction(id, e);
    return Response.ok().build();
  }

}
