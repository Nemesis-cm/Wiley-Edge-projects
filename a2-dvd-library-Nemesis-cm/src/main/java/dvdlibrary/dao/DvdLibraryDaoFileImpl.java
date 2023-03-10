
package dvdlibrary.dao;

import dvdlibrary.dto.Dvd;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;


public class DvdLibraryDaoFileImpl implements DvdLibraryDao {
    private Map <String, Dvd> dvds = new HashMap<>();  
    
    private final String LIBRARY_FILE;  //static removed 
    private final  String DELIMITER = "::";
    
    //default constructor
    public DvdLibraryDaoFileImpl() {
        LIBRARY_FILE = "DvdLibrary.txt";
    }

    public DvdLibraryDaoFileImpl(String libraryTextFile) {
        LIBRARY_FILE = libraryTextFile;
    }
    
    @Override
    public Dvd addDvd(String title, Dvd dvd) throws DvdLibraryDaoException {
        // Reads txt file
        loadLibrary();
        //New DVD is added to the dvds HashMap.
        Dvd newDvd = dvds.put(title, dvd);
        // Writes into txt file
        writeLibrary();
        return newDvd;
    }

    @Override
    public Dvd removeDvd(String title) throws DvdLibraryDaoException {
        loadLibrary();
        Dvd removedDvd = dvds.remove(title);
        writeLibrary();
        return removedDvd;
    }

    @Override
    public List<Dvd> getAllDvds() throws DvdLibraryDaoException{
        loadLibrary();
        return new ArrayList(dvds.values());
    }

    @Override
    public Dvd getDvd(String title) throws DvdLibraryDaoException {
        loadLibrary();
        return dvds.get(title);
    }

    @Override
    public Dvd changeReleaseDate(String title, LocalDate releaseDate)throws DvdLibraryDaoException {
        loadLibrary();
        Dvd dvdToEdit = dvds.get(title);
        dvdToEdit.setReleaseDate(releaseDate);
        writeLibrary();
        return dvdToEdit;
    }

    @Override
    public Dvd changeMpaaRating(String title, String mpaaRating) throws DvdLibraryDaoException {
        loadLibrary();
        Dvd dvdToEdit = dvds.get(title);
        dvdToEdit.setMpaaRating(mpaaRating);
        writeLibrary();
        return dvdToEdit;
    }

    @Override
    public Dvd changeDirectorName(String title, String directorName) throws DvdLibraryDaoException {
        loadLibrary();
        Dvd dvdToEdit = dvds.get(title);
        dvdToEdit.setDirectorName(directorName);
        writeLibrary();
        return dvdToEdit;
    }

    @Override
    public Dvd changeUserRating(String title, String userRating)throws DvdLibraryDaoException {
        loadLibrary();
        Dvd dvdToEdit = dvds.get(title);
        dvdToEdit.setUserRating(userRating);
        writeLibrary();
        return dvdToEdit;
    }
    
    @Override
    public Dvd changeStudioName(String title, String studioName) throws DvdLibraryDaoException {
        loadLibrary();
        Dvd dvdToEdit = dvds.get(title);
        dvdToEdit.setStudio(studioName);
        writeLibrary();
        return dvdToEdit;
    }
    
    @Override
    public Map<String, Dvd> getDvdsLastYears(int years) throws DvdLibraryDaoException {
        LocalDate now = LocalDate.now();
        LocalDate sinceThisDate = now.minusYears(years);
        loadLibrary();
        Map<String, Dvd> dvdsLastYears = dvds.entrySet().stream()
                .filter((dvd) -> dvd.getValue().getReleaseDate().isAfter(sinceThisDate))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return dvdsLastYears;
    }
    @Override
    public Map<String, Dvd> getDvdsByMpaaRating(String mpaaRating) throws DvdLibraryDaoException {
        loadLibrary();
        Map<String, Dvd> dvdsMpaRating = dvds
                .entrySet()
                .stream()
                .filter((dvd) -> dvd.getValue().getMpaaRating().equalsIgnoreCase(mpaaRating))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return dvdsMpaRating;
    }
    @Override
    public Map<String, Dvd> getDvdsByDirector(String directorName) throws DvdLibraryDaoException {
        loadLibrary();
        Map<String, Dvd> dvdsByDirector = dvds
                .entrySet()
                .stream()
                .filter((dvd) -> dvd.getValue().getDirectorName().equalsIgnoreCase(directorName))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return dvdsByDirector;
    }
    @Override
    public Map<String, Dvd> getDvdsByStudio(String studioName) throws DvdLibraryDaoException {
        loadLibrary();
        Map<String, Dvd> dvdsByStudio = dvds
                .entrySet().stream().filter((dvd) -> dvd.getValue().getStudio().equalsIgnoreCase(studioName))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return dvdsByStudio;
    }
    private String marshallDvd(Dvd aDvd) {

        String dvdAsText = aDvd.getTitle() + DELIMITER;
        dvdAsText += aDvd.getReleaseDate() + DELIMITER;
        dvdAsText += aDvd.getMpaaRating() + DELIMITER;
        dvdAsText += aDvd.getDirectorName() + DELIMITER;
        dvdAsText += aDvd.getUserRating() + DELIMITER;
        dvdAsText += aDvd.getStudio();
        return dvdAsText;
    }

    private Dvd unmarshallDvd(String dvdAsText) {

        String [] dvdTokens = dvdAsText.split(DELIMITER);
        //Given the pattern above, the DVD title is in index 0 of the array.
        String title = dvdTokens[0];
        String releaseDate = dvdTokens[1];
        String mpaaRating = dvdTokens[2];
        String directorName = dvdTokens[3];
        String userRating = dvdTokens[4];
        String studio = dvdTokens[5];
        
        //A new DVD object is created using the title to satisfy the 
        //requirements of the DVD constructor
        Dvd dvdFromFile = new Dvd(title);
        //The remaining tokens are then set into the DVD object using the appropriate setters.
        dvdFromFile.setReleaseDate(LocalDate.parse(releaseDate));
        dvdFromFile.setMpaaRating(mpaaRating);
        dvdFromFile.setDirectorName(directorName);
        dvdFromFile.setUserRating(userRating);
        dvdFromFile.setStudio(studio);
        return dvdFromFile;
    }

    private void loadLibrary() throws DvdLibraryDaoException {
        Scanner scanner;
        try {
            // Create Scanner for reading the file
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(LIBRARY_FILE)));
        } catch (FileNotFoundException e) {
            throw new DvdLibraryDaoException(
                    "-_- Could not load roster data into memory.", e);
        }
        //currentLine holds the most recent line read from the file
        String currentLine;
        //curentDvd holds the most recent DVD
        Dvd currentDvd;

        while (scanner.hasNextLine()) {
            //get the next line in the file
            currentLine = scanner.nextLine();
            //unmarshall the line into a DVD
            currentDvd = unmarshallDvd(currentLine);
            
            //The Dvd title is used as a map key to put the currentDvd ino the map
            dvds.put(currentDvd.getTitle(),currentDvd);
        }
        //Clean up
        scanner.close();
    }

    private void writeLibrary() throws DvdLibraryDaoException {
    PrintWriter out;
    
    try {
        out = new PrintWriter(new FileWriter(LIBRARY_FILE));
    } catch (IOException e) {
        throw new DvdLibraryDaoException("Could not save DVD data",e);
    }
    String dvdAsText;
    List <Dvd> dvdList = this.getAllDvds();
    for (Dvd currentDvd : dvdList) {

        dvdAsText = marshallDvd(currentDvd);
        out.println(dvdAsText);

        out.flush();
    }
    out.close();
    }


}
