package com.topjavatutorial.services;

import com.topjavatutorial.dao.Dao;
import com.topjavatutorial.dao.IPlayerDao;
import com.topjavatutorial.dao.MineDao;
import com.topjavatutorial.dao.PlayerDao;
import com.topjavatutorial.model.Mine;
import com.topjavatutorial.model.Player;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Root resource (exposed at "players" path)
 */
@Path("/players")
public class PlayersService {
  private Dao<Player> playerDao = new PlayerDao();
  private Dao<Mine> mineDao = new MineDao();

  /**
   * Method handling HTTP GET requests. The returned object will be sent to the
   * client as "text/plain" media type.
   *
   * @return String that will be returned as a text/plain response.
   */
  @GET
  @Produces("application/json")
  public List<Player> getPlayers() {
    return playerDao.getAll();
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Path("/create")
  public Response addPlayer(Player p) {
    System.out.println(p.getPseudo());
    playerDao.add(p);
    return Response.ok().build();
  }

  @Consumes("application/json")
  @PUT
  @Path("/update/{id}")
  public Response updatePlayer(@PathParam("id") int id, Player p) {
    return (new PlayerDao()).update(id, p) != 0 ? Response.ok().build()
        : Response.status(Response.Status.BAD_REQUEST).build();
  }

  @Consumes("application/json")
  @POST
  @Path("/addMine/{id}")
  public Response addMine(Mine m, @PathParam("id") int id) {
    mineDao.add(m);
    ((IPlayerDao) playerDao).addMine(id, m);
    return Response.ok().build();
  }

  @Consumes("application/json")
  @DELETE
  @Path("/delete/{id}")
  public Response deleteEmployee(@PathParam("id") int id) {
    return (playerDao.delete(id) != 0 
        ? Response.ok() : Response.status(Response.Status.BAD_REQUEST)).build();
  }

}
