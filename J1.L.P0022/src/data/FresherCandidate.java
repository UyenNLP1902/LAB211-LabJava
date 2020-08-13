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
public class FresherCandidate extends Candidate {

    private int graduationDate;
    private String graduationRank;
    private String education;

    public FresherCandidate(String candidateId, String firstName, String lastName,
            int birthDate, String address, String phone, String email, int candidateType,
            int graduationDate, String graduationRank, String education) {
        super(candidateId, firstName, lastName, birthDate, address, phone, email, candidateType);
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
    }

    public int getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(int graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getGraduationRank() {
        return graduationRank;
    }

    public void setGraduationRank(String graduationRank) {
        this.graduationRank = graduationRank;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
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
