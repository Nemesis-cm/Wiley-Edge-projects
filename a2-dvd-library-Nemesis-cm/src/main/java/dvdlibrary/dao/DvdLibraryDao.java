
package dvdlibrary.dao;

import dvdlibrary.dto.Dvd;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;


public interface DvdLibraryDao {
   // Here we Define all methods
    Dvd addDvd(String title, Dvd dvd) throws DvdLibraryDaoException;

    Dvd removeDvd(String title) throws DvdLibraryDaoException;
    

    Dvd changeReleaseDate(String title, LocalDate releaseDate)throws DvdLibraryDaoException;

    Dvd changeMpaaRating(String title, String mpaaRating)throws DvdLibraryDaoException;
    // Method for changing MPAA rating
    Dvd changeDirectorName(String title, String directorName)throws DvdLibraryDaoException;

    Dvd changeUserRating(String title, String userRating)throws DvdLibraryDaoException;

    Dvd changeStudioName(String title, String studioName)throws DvdLibraryDaoException;    

    List <Dvd> getAllDvds () throws DvdLibraryDaoException ;

    Dvd getDvd(String title) throws DvdLibraryDaoException ;
    
    Map<String, Dvd> getDvdsLastYears(int years) throws DvdLibraryDaoException;
    
    Map<String, Dvd> getDvdsByMpaaRating(String mpaaRating) throws DvdLibraryDaoException;
    
    Map<String, Dvd> getDvdsByDirector(String directorName) throws DvdLibraryDaoException;
    
    Map<String, Dvd> getDvdsByStudio(String studioName) throws DvdLibraryDaoException;
    
    
    
}
