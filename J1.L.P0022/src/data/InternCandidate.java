/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author SE140355
 */
public class InternCandidate extends Candidate {

    private String majors;
    private String semester;
    private String universityName;

    public InternCandidate(String candidateId, String firstName, String lastName,
            int birthDate, String address, String phone, String email, int candidateType,
            String majors, String semester, String universityName) {
        super(candidateId, firstName, lastName, birthDate, address, phone, email, candidateType);
        this.majors = majors;
        this.semester = semester;
        this.universityName = universityName;
    }

    public String getMajors() {
        return majors;
    }

    public void setMajors(String majors) {
        this.majors = majors;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    @Override
    public void showProfile() {
        System.out.println(firstName + " " + lastName + " | "
                + birthDate + " | "
                + address + " | "
                + phone + " | "
                + email + " | "
                + candidateType
        );
    }
}
