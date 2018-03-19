public class EmployeeView {
    private String username;
    private String password;
    private String staffID;
    private String firstName;
    private String lastName;
    private String dob;
    private String email;
    private String phoneNumber;
    private String address;
    private String country;
    private String city;
    private String postCode;
    private boolean isAllowedManagerFunctions;
    private boolean isAllowedAdminFunctions;

    public EmployeeView(String username, String password, String staffID, String firstName, String lastName, String dob,
                    String email, String phoneNumber, String address, String country, String city, String postCode ){
        this.username = username;
        this.password = password;
        this.staffID = staffID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.country = country;
        this.city = city;
        this.postCode = postCode;
        isAllowedManagerFunctions = false;
        isAllowedManagerFunctions = false;
    }

    public void setUsername(String newUsername){
        this.username=newUsername;
    }
    public String getUserName(){
        return this.username;
    }

    public void setUserPassword(String newPassword){
        this.password = newPassword;
    }
    public String getPassword(){
        return this.password;
    }


    public void setIsAllowedManagerFunctions(boolean value){
        isAllowedManagerFunctions = value;
    }
    public boolean getIsAllowedManagerFunctions(){
        return this.isAllowedManagerFunctions;
    }


    public void setIsAllowedAdminFunctions(boolean value){
        isAllowedAdminFunctions = value;
    }
    public boolean getIsAllowedAdminFunctions(){
        return this.isAllowedAdminFunctions;
    }

    public String getStaffID(){
        return this.staffID;
    }
    public String getFirstName(){
        return this.firstName;
    }
    public String getLastName(){
        return this.lastName;
    }
    public String getDob(){
        return this.dob;
    }
    public String getEmail(){
        return email;
    }
    public String getPhoneNumber(){
        return this.phoneNumber;
    }
    public String getAddress(){
        return this.address;
    }
    public String getCountry(){
        return this.country;
    }
    public String getCity(){
        return this.city;
    }
    public String getPostCode(){
        return this.postCode;
    }
}