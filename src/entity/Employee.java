package entity;

public class Employee {
    private int id;
    private String fullName;
    private String email;
    private int phoneNumber;
    private String dateOfBirth;
    private int monthlySalary;




    public Employee(int id, String fullName, String email, int phoneNumber, String dateOfBirth, int monthlySalary) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.monthlySalary = monthlySalary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        if(fullName.isBlank() || fullName == null){
            throw new IllegalArgumentException("Full Name cannot be null or blank");
        }
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email.isBlank()|| email == null ){
            throw new IllegalArgumentException("email cannot be null or blank");
        }
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        if(dateOfBirth.isBlank() || dateOfBirth == null){
            throw new IllegalArgumentException("Date of birth cannot be null or blank");
        }
        this.dateOfBirth = dateOfBirth;
    }

    public int getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(int monthlySalary) {
        this.monthlySalary = monthlySalary;


    }

    public String toString(){
        return fullName +" " + email +" " + phoneNumber +" " + dateOfBirth +" " + monthlySalary;
    }
}
