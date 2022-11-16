package services;

import java.util.List;
import models.Song;
import repositories.SongRepository;

import javax.ws.rs.*;

@Path("/songs")
@Consumes({ "application/json" })
@Produces({ "application/json" })
public class SongService {

    private SongRepository songRepository = new SongRepository();

    @GET
    @Path("/{id}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public Song getSongById(@PathParam("id") String id) {
        return songRepository.getSongById(id);
    }
    
    @GET
    @Path("/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public List<Song> getAllSongs() {
        return songRepository.getAllSongs();
    }
    
    @POST
    @Path("/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public void insertSong(Song song) {
        this.songRepository.createsong(song);
    }
    
    @PUT
    @Path("/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public void updateSong(Song song) {
        this.songRepository.updateSong(song);
    }
}
