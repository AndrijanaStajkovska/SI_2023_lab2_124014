import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class User {
    String username;
    String password;
    String email;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username){
        this.username=username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}

public class SILab2 {

    public static boolean function(User user, List<User> allUsers) { //start
        if (user == null || user.getPassword() == null || user.getEmail() == null) { //1
            throw new RuntimeException("Mandatory information missing!"); //2
        }

        if (user.getUsername() == null) { //3
            user.setUsername(user.getEmail()); //4
        }

        int same = 1; //5
        if (user.getEmail().contains("@") && user.getEmail().contains(".")) { //6
            same = 0; //7
            for (int i = 0; i < allUsers.size(); i++) { //8,9,10
                User existingUser = allUsers.get(i); //11
                if (existingUser.getEmail() == user.getEmail()) { //12
                    same += 1; //13
                }
                if (existingUser.getUsername() == user.getUsername()) { //14
                    same += 1; //15
                }
            }
        }

        String specialCharacters = "!#$%&'()*+,-./:;<=>?@[]^_`{|}"; //16
        String password = user.getPassword(); //17
        String passwordLower = password.toLowerCase(); //18

        if (passwordLower.contains(user.getUsername().toLowerCase()) || password.length() < 8) { //19
            return false; //20
        } else { //21
            if (!passwordLower.contains(" ")) { //22
                for (int i = 0; i < specialCharacters.length(); i++) { //23,24,25
                    if (password.contains(String.valueOf(specialCharacters.charAt(i)))) { //26
                        return same == 0; //27
                    }
                }
            }
        }
        return false; //28
    } //end
}