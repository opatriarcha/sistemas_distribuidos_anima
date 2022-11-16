package repositories;

import java.util.ArrayList;
import java.util.List;
import models.Song;

public class SongRepository {
    
    private List<Song> songsState = new ArrayList<>();
    
    public SongRepository(){
        this.songsState.add( new Song("2", "The Police", "4.0"));
        this.songsState.add( new Song("3", "Iron Maiden", "4.0"));
        this.songsState.add( new Song("4", "The Cure", "4.0"));
        this.songsState.add( new Song("5", "Guns N' Roses", "4.0"));
    }
    
    public Song getSongById(String id) {
        for( Song song : this.songsState ){
            if( song.getId().equals( id ))
                return song;
        }
        return null;
    }
    
    public List<Song> getAllSongs() {
       return this.songsState;
    }
    
    public void createsong(Song song ){
        this.songsState.add(song);
    }
    
    public void deleteSongById(String id){
        for( Song song : this.songsState ){
            if( song.getId().equals(id))
                this.songsState.remove(song);
        }
    }
    
    public void updateSong( Song aSong ){
        for( Song song : this.songsState ){
            if( song.getId().equals(aSong)){
                this.songsState.remove(song);
                this.songsState.add(song);
                return ;
            }
        }
    }
}
