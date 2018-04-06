/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

/**
 *
 * @author s_ele
 */
public class User {
    
    private int iduser;
    private String email;
    private String password;
    public enum UserRole {
        employee("employee"), 
        customer("customer");
        
        private String role;
        
        UserRole(String role) {
            this.role = role;
        }
        
        public String getName() {
            return role;
        }
        
    }
    private UserRole role;

    public User(String email, String password, UserRole role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public int getIduser() {
        return iduser;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" + "iduser=" + iduser + ", email=" + email + ", password=" + password + ", role=" + role + '}';
    }

    
    
    
    
}//Class
