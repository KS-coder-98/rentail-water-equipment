package pl.sekowski.rent.water.equipment.appuser.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import pl.sekowski.rent.water.equipment.appuser.User;
import pl.sekowski.rent.water.equipment.appuser.UserService;
import pl.sekowski.rent.water.equipment.csv.CsvReader;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Service
public class FileService {
    @Value("${app.upload.dir:${user.home}}")
    public String uploadDir;
    @Autowired
    UserService userService;

    public void uploadFile(MultipartFile file) {

        try {
            Path copyLocation = Paths
                    .get(uploadDir + File.separator + StringUtils.cleanPath(file.getOriginalFilename()));
            System.out.println("tu zapisz!!!!" +  copyLocation);
            Files.copy(file.getInputStream(), copyLocation, StandardCopyOption.REPLACE_EXISTING);
            System.out.println(copyLocation + "lokalizacja");
            List<User> users = CsvReader.readUser(uploadDir + File.separator + StringUtils.cleanPath(file.getOriginalFilename()));
            users.forEach(userService::signUser);
        } catch (Exception e) {
            e.printStackTrace();
            throw new FileStorageException("Could not store file " + file.getOriginalFilename()
                    + ". Please try again!");
        }
    }
}
