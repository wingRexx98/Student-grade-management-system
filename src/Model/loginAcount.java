/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Admin
 */
public class loginAcount {

    private int adminID;
    private String loginName;
    private String password;

    public String getLoginName() {
        return loginName;
    }

    public loginAcount(int adminID, String loginName, String password) {
        this.adminID = adminID;
        this.loginName = loginName;
        this.password = password;
    }

    public int getAdminID() {
        return adminID;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public loginAcount() {
    }

}
