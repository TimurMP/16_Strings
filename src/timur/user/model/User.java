package timur.user.model;

public class User {
    private String email;
    private String password;

    public User(String email, String password) {
        setEmail(email);
        setPassword(password);
    }


    private boolean validatePassword(String password) {
        if (password.length() < 8) {
            return false;
        }
        boolean isUppercase = false;
        boolean isLowercase = false;
        boolean isDigit = false;
        boolean isSpecialSymbol = false;

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (Character.isUpperCase(c)) {
                isUppercase = true;
            }
            if (Character.isLowerCase(c)) {
                isLowercase = true;
            }
            if (Character.isDigit(c)) {
                isDigit = true;
            }
            if (c == '@' || c == '!' || c == '%' || c == '*' || c == '&') {
                isSpecialSymbol = true;
            }

        }
        return isUppercase && isLowercase && isDigit && isSpecialSymbol;
    }


    private boolean validateEmail(String email) {
        int indexAt = email.indexOf('@');
        if (indexAt == -1 || email.indexOf('@', indexAt + 1) >= 0) {
            return false;
        }

        if (email.indexOf('.', indexAt + 1) < 0) {
            return false;
        }

        if (email.lastIndexOf('.') >= email.length() - 3) {
            return false;
        }
        for (int i = 0; i < email.length(); i++) {
            char c = email.charAt(i);
            if (!(Character.isAlphabetic(c) || Character.isDigit(c) || c == '_'
                    || c == '-' || c == '.' || c == '@')) {
                return false;
            }
        }


        return true;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (validateEmail(email)) {
            this.email = email;


        } else {
            System.out.println(email + " Email not valid");
        }
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (validatePassword(password)) {
            this.password = password;
        } else {
            System.out.println(password + " - password is not valid");
        }
    }

    @Override
    public String toString() {
        return "User [email=" + email + ", password=" + password + "]";
    }

}
