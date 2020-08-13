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
public class UpdateHistory implements Comparable<UpdateHistory> {

    private Worker worker;
    private String status;
    private String date;

    public UpdateHistory(Worker worker, String status, String date) {
        this.worker = worker;
        this.status = status;
        this.date = date;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void printHistory() {
        System.out.printf("%5s | %-10s | %3d | %7.2f | %6s | %-12s\n",
                worker.getId(),
                worker.getName(),
                worker.getAge(),
                worker.getSalary(),
                status,
                date
        );
    }

    @Override
    public int compareTo(UpdateHistory o) {
        return this.worker.getId().compareToIgnoreCase(o.worker.getId());
    }

}
